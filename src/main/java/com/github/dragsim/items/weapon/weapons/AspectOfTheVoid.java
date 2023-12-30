package com.github.dragsim.items.weapon.weapons;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.ItemStatType;
import com.github.dragsim.items.weapon.CustomWeapon;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AspectOfTheVoid extends CustomWeapon {
    private int manaCost;
    public AspectOfTheVoid(Dragsim plugin) {
        super(plugin, 0, new LinkedHashMap<>() {
            {
                put(ItemStatType.DAMAGE, 285);
                put(ItemStatType.STRENGTH, 265);
            }
        });
        manaCost = 40;
        createItem();
    }


    private void createItem(){
        List<String> lore = super.getStat().getBaseStats(ChatColor.RED);
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Instant Transmission " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Teleport " + ChatColor.GREEN + "9 blocks " + ChatColor.GRAY + "ahead of");
        lore.add(ChatColor.GREEN + "you and gain " + ChatColor.GREEN + "+50 " + ChatColor.WHITE + "✦ Speed");
        lore.add(ChatColor.GRAY + "for " + ChatColor.GREEN + "5 seconds.");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.DARK_AQUA + " 40");
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC SWORD");

        createWeapon(Material.DIAMOND_SHOVEL,ChatColor.DARK_PURPLE + "Aspect of the Void", lore, super.getStat().getBase());
    }

    @Override
    public void onRightClick(Player player) {

        if (manaCost<=plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).getValue()){
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).remove(manaCost);

            Location playerLocation = player.getLocation();
            Vector direction = playerLocation.getDirection().normalize().multiply(9);
            Location newLocation = playerLocation.add(direction);
            player.teleport(newLocation);
        }else {
            player.sendMessage(ChatColor.RED + "Not enough mana");
        }
        return;

    }
}
