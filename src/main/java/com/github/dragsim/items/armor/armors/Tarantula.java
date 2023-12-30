package com.github.dragsim.items.armor.armors;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.armor.CustomArmor;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tarantula extends CustomArmor{

    private int manaCost;
    public Tarantula(Dragsim plugin, int id) {
        super(plugin, id);
        manaCost = 40;
        createArmor();
    }

    private void createArmor(){
        createHelmet();
        createChestplate();
        createLeggings();
        createBoots();

    }

    private void createHelmet(){
        helmet = new ItemStack(Material.LEATHER_HELMET);

        ItemMeta itemMeta = helmet.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        helmet.setItemMeta(leatherArmorMeta);

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Mana: " + ChatColor.GREEN + "+100");
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+100 ❤");
        lore.add(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+80 ❈");
        lore.add("");
        lore.add(ChatColor.GOLD + "Full Set Bonus: Octodexterity");
        lore.add(ChatColor.GRAY + "Every 4th strike, deal " + ChatColor.RED + "double");
        lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "and apply venom");
        lore.add(ChatColor.GRAY + "reducing healing by " + ChatColor.DARK_GREEN + "40%" + ChatColor.GRAY + "for");
        lore.add(ChatColor.BLUE + "4 " + ChatColor.GRAY + "seconds.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Piece Bonus: Spider Bulwark");
        lore.add(ChatColor.GRAY + "Kill spiders to accumulate");
        lore.add(ChatColor.GRAY + "defence against them.");
        lore.add(ChatColor.GRAY + "Piece Bonus: " + ChatColor.GREEN + "+285❈");
        lore.add("" + ChatColor.GREEN + ChatColor.BOLD + "MAXED OUT! NICE!");
        lore.add("");
        lore.add(ChatColor.GRAY + "Kills:" + ChatColor.RED + " 500.000");
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC HELMET");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("mana", 100);
        stats.put("health", 100);
        stats.put("defence", 80);

        createPiece(helmet, ChatColor.DARK_PURPLE + "Tarantula Helmet",lore, stats);
    }
    private void createChestplate(){
        chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);

        ItemMeta itemMeta = chestplate.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        chestplate.setItemMeta(leatherArmorMeta);

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Mana: " + ChatColor.GREEN + "+100");
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+120 ❤");
        lore.add(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+100 ❈");
        lore.add("");
        lore.add(ChatColor.GOLD + "Full Set Bonus: Octodexterity");
        lore.add(ChatColor.GRAY + "Every 4th strike, deal " + ChatColor.RED + "double");
        lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "and apply venom");
        lore.add(ChatColor.GRAY + "reducing healing by " + ChatColor.DARK_GREEN + "40%" + ChatColor.GRAY + "for");
        lore.add(ChatColor.BLUE + "4 " + ChatColor.GRAY + "seconds.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Piece Bonus: Spider Bulwark");
        lore.add(ChatColor.GRAY + "Kill spiders to accumulate");
        lore.add(ChatColor.GRAY + "defence against them.");
        lore.add(ChatColor.GRAY + "Piece Bonus: " + ChatColor.GREEN + "+285❈");
        lore.add("" + ChatColor.GREEN + ChatColor.BOLD + "MAXED OUT! NICE!");
        lore.add("");
        lore.add(ChatColor.GRAY + "Kills:" + ChatColor.RED + " 500.000");
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC CHESTPLATE");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("mana", 100);
        stats.put("health", 120);
        stats.put("defence", 100);

        createPiece(chestplate, ChatColor.DARK_PURPLE + "Tarantula Chestplate",lore, stats);
    }

    private void createLeggings(){
        leggings = new ItemStack(Material.LEATHER_LEGGINGS);

        ItemMeta itemMeta = leggings.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        leggings.setItemMeta(leatherArmorMeta);

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+60 ❤");
        lore.add(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+20 ❈");
        lore.add("");
        lore.add(ChatColor.GOLD + "Full Set Bonus: Octodexterity");
        lore.add(ChatColor.GRAY + "Every 4th strike, deal " + ChatColor.RED + "double");
        lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "and apply venom");
        lore.add(ChatColor.GRAY + "reducing healing by " + ChatColor.DARK_GREEN + "40%" + ChatColor.GRAY + "for");
        lore.add(ChatColor.BLUE + "4 " + ChatColor.GRAY + "seconds.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Piece Bonus: Spider Bulwark");
        lore.add(ChatColor.GRAY + "Kill spiders to accumulate");
        lore.add(ChatColor.GRAY + "defence against them.");
        lore.add(ChatColor.GRAY + "Piece Bonus: " + ChatColor.GREEN + "+285❈");
        lore.add("" + ChatColor.GREEN + ChatColor.BOLD + "MAXED OUT! NICE!");
        lore.add("");
        lore.add(ChatColor.GRAY + "Kills:" + ChatColor.RED + " 500.000");
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC LEGGINGS");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("health", 60);
        stats.put("defence", 20);

        createPiece(leggings, ChatColor.DARK_PURPLE + "Tarantula Leggings",lore, stats);

        //createPiece();
    }

    private void createBoots(){
        boots = new ItemStack(Material.LEATHER_BOOTS);

        ItemMeta itemMeta = boots.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        boots.setItemMeta(leatherArmorMeta);

        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Mana: " + ChatColor.GREEN + "+50");
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.GREEN + "+70 ❤");
        lore.add(ChatColor.GRAY + "Defence: " + ChatColor.GREEN + "+100 ❈");
        lore.add(ChatColor.GRAY + "Speed: " + ChatColor.GREEN + "+5");
        lore.add("");
        lore.add(ChatColor.GOLD + "Full Set Bonus: Octodexterity");
        lore.add(ChatColor.GRAY + "Every 4th strike, deal " + ChatColor.RED + "double");
        lore.add(ChatColor.RED + "damage " + ChatColor.GRAY + "and apply venom");
        lore.add(ChatColor.GRAY + "reducing healing by " + ChatColor.DARK_GREEN + "40%" + ChatColor.GRAY + "for");
        lore.add(ChatColor.BLUE + "4 " + ChatColor.GRAY + "seconds.");
        lore.add("");
        lore.add(ChatColor.GOLD + "Piece Bonus: Spider Bulwark");
        lore.add(ChatColor.GRAY + "Kill spiders to accumulate");
        lore.add(ChatColor.GRAY + "defence against them.");
        lore.add(ChatColor.GRAY + "Piece Bonus: " + ChatColor.GREEN + "+285❈");
        lore.add("" + ChatColor.GREEN + ChatColor.BOLD + "MAXED OUT! NICE!");
        lore.add("");
        lore.add(ChatColor.GRAY + "Kills:" + ChatColor.RED + " 500.000");
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Double Jump");
        lore.add(ChatColor.GRAY + "Jump again mid-air to double");
        lore.add(ChatColor.GRAY + "jump!");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.DARK_AQUA + "40");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC BOOTS");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("mana", 50);
        stats.put("health", 70);
        stats.put("defence", 100);
        stats.put("speed", 5);

        createPiece(boots, ChatColor.DARK_PURPLE + "Tarantula Boots",lore, stats);

    }

    public void onDoubleJump(Player player){
        if (manaCost <= plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).getValue()) {
            Vector velocity = player.getLocation().getDirection().clone().multiply(0.4);
            velocity.setY(0.55);
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).remove(manaCost);
            player.setVelocity(velocity);
        } else {
            player.sendMessage(ChatColor.RED + "Not enough mana");
        }

    }

}
