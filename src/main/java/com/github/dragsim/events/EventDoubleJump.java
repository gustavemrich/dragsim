package com.github.dragsim.events;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.armor.ArmorType;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

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
            if (Objects.equals(e.getPlayer().getInventory().getBoots(), plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).boots)){
                plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).onDoubleJump(e.getPlayer());
            }
        }
    }
}