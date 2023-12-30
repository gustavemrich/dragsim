package com.github.dragsim.events;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.armor.ArmorType;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

import java.util.Objects;


public class EventDoubleJump implements Listener {

    private Dragsim plugin;

    public EventDoubleJump(Dragsim plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void doubleJumpEvent(PlayerToggleFlightEvent e){
        if (!e.getPlayer().isOp()){
            e.setCancelled(true);
            if (e.getPlayer().getInventory().getBoots().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "id"), PersistentDataType.INTEGER).equals(1)){
                Bukkit.broadcastMessage("Double jump");
                onDoubleJump(e.getPlayer());
            }
        }
    }

    public void onDoubleJump(Player player){
        if (40 <= plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).getValue()) {
            Vector velocity = player.getLocation().getDirection().clone().multiply(0.4);
            velocity.setY(0.55);
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).remove(40);
            player.setVelocity(velocity);
        } else {
            player.sendMessage(ChatColor.RED + "Not enough mana");
        }
    }
}