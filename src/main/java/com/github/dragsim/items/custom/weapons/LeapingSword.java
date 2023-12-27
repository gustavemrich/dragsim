package com.github.dragsim.items.custom.weapons;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.custom.CustomWeapon;
import com.github.dragsim.player.StatType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.round;

public class LeapingSword extends CustomWeapon {

    private int manaCost;

    public LeapingSword(Dragsim plugin) {
        super(plugin, 2000);
        manaCost = 100;
        createItem();
    }

    private void createItem(){
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+150");
        lore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+100");
        lore.add(ChatColor.GRAY + "Crit Damage: " + ChatColor.RED + "+25%");
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Leap " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Leap into the air and deal");
        lore.add(ChatColor.GREEN + "350 " + ChatColor.GRAY + "base Magic Damage to");
        lore.add(ChatColor.GRAY + "nearby enemies upon landing on");
        lore.add(ChatColor.GRAY + "the ground.");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost:" + ChatColor.DARK_AQUA + " 100");
        lore.add(ChatColor.DARK_GRAY + "Cooldown:" + ChatColor.GREEN + " 2s");
        lore.add("");
        // lore.add(ChatColor.DARK_GRAY + "Ability Power:" + ChatColor.YELLOW + " 350");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC SWORD");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("damage", 150);
        stats.put("crit_damage", 25);
        stats.put("strength", 100);




        createWeapon(Material.GOLDEN_SWORD,ChatColor.DARK_PURPLE + "Leaping Sword", lore, stats);
    }

    @Override
    public void onRightClick(Player player) {
        long cooldown = cooldownManager.checkCooldown(player.getUniqueId().toString());
        if (cooldown == 0) {
            if (manaCost <= plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).getValue()) {
                Vector velocity = player.getLocation().getDirection().clone().multiply(1.2);
                velocity.setY(0.6);

                plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).remove(manaCost);
                player.setVelocity(velocity);
            } else {
                player.sendMessage(ChatColor.RED + "Not enough mana");
            }
        }else{
            WeaponCooldownManager.sendCooldownMessage(player, cooldown);
        }
    }
}
