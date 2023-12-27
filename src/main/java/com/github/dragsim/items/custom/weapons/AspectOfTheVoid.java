package com.github.dragsim.items.custom.weapons;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.custom.CustomWeapon;
import com.github.dragsim.player.StatType;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AspectOfTheVoid extends CustomWeapon {
    private int manaCost;
    public AspectOfTheVoid(Dragsim plugin) {
        super(plugin, 0);
        manaCost = 40;
        createItem();
    }


    private void createItem(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+285");
        lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+265");
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Instant Transmission " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Teleport " + ChatColor.GREEN + "9 blocks " + ChatColor.GRAY + "ahead of");
        lore.add(ChatColor.GREEN + "you and gain " + ChatColor.GREEN + "+50 " + ChatColor.WHITE + "✦ Speed");
        lore.add(ChatColor.GRAY + "for " + ChatColor.GREEN + "5 seconds.");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.DARK_AQUA + " 40");
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC SWORD");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("damage", 285);
        stats.put("strength", 265);

        createWeapon(Material.DIAMOND_SHOVEL,ChatColor.DARK_PURPLE + "Aspect of the Void", lore, stats);
    }

    @Override
    public void onRightClick(Player player) {

        if (manaCost<=plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).getValue()){
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).remove(manaCost);

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
