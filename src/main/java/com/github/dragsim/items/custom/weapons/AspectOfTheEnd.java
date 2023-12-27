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

public class AspectOfTheEnd extends CustomWeapon {

    private int manaCost;
    public AspectOfTheEnd(Dragsim plugin) {
        super(plugin, 0);
        manaCost = 100;
        createItem();
    }


    private void createItem(){
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+100");
        lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+80");
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Instant Transmission " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Teleport " + ChatColor.GREEN + "7 blocks " + ChatColor.GRAY + "ahead of");
        lore.add(ChatColor.GREEN + "you and gain " + ChatColor.GREEN + "+50 " + ChatColor.WHITE + "✦ Speed");
        lore.add(ChatColor.GRAY + "for " + ChatColor.GREEN + "3 seconds.");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.DARK_AQUA + " 50");
        lore.add("");
        lore.add("" + ChatColor.BLUE + ChatColor.BOLD + "RARE SWORD");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("damage", 100);
        stats.put("strength", 80);




        createWeapon(Material.DIAMOND_SWORD,ChatColor.BLUE + "Aspect of the End", lore, stats);
    }

    @Override
    public void onRightClick(Player player) {

        if (manaCost<=plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).getValue()){
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).remove(manaCost);

            Location playerLocation = player.getLocation();
            Vector direction = playerLocation.getDirection().normalize().multiply(7);
            Location newLocation = playerLocation.add(direction);
            player.teleport(newLocation);
        }else {
            player.sendMessage(ChatColor.RED + "Not enough mana");
        }
        return;

    }
}
