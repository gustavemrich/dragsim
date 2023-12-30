package com.github.dragsim.items.armor.armors;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.ItemStatType;
import com.github.dragsim.items.armor.CustomArmorPiece;
import com.github.dragsim.items.armor.CustomArmorSet;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.LinkedHashMap;
import java.util.List;

public class Tarantula extends CustomArmorSet {

    private int manaCost;
    private int id;
    public Tarantula(Dragsim plugin, int id) {
        super(plugin, id,
                new LinkedHashMap<>(){{
                    put(ItemStatType.MANA, 100);
                    put(ItemStatType.HEALTH, 100);
                    put(ItemStatType.DEFENSE, 80);
                }},
                new LinkedHashMap<>(){{
                    put(ItemStatType.MANA, 100);
                    put(ItemStatType.HEALTH, 120);
                    put(ItemStatType.DEFENSE, 100);
                }},
                new LinkedHashMap<>(){{
                    put(ItemStatType.HEALTH, 60);
                    put(ItemStatType.DEFENSE, 20);
                }},
                new LinkedHashMap<>(){{
                    put(ItemStatType.MANA, 50);
                    put(ItemStatType.HEALTH, 70);
                    put(ItemStatType.DEFENSE, 100);
                    put(ItemStatType.SPEED, 5);
                }}
        );
        manaCost = 40;
    }

    @Override
    public void createHelmet(Dragsim plugin){
        helmet.piece = new ItemStack(Material.LEATHER_HELMET);

        ItemMeta itemMeta = helmet.piece.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        helmet.piece.setItemMeta(leatherArmorMeta);

        List<String> lore = helmet.stats.getBaseStats(ChatColor.GREEN);

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

        CustomArmorPiece.createPiece(id,plugin,helmet.piece,ChatColor.DARK_PURPLE + "Tarantula Helmet",lore, helmet.stats.getBase());
    }

    @Override
    public void createChestplate(Dragsim plugin){
        chestplate.piece = new ItemStack(Material.LEATHER_CHESTPLATE);

        ItemMeta itemMeta = chestplate.piece.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        chestplate.piece.setItemMeta(leatherArmorMeta);

        List<String> lore = chestplate.stats.getBaseStats(ChatColor.GREEN);

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


        CustomArmorPiece.createPiece(id,plugin,chestplate.piece,ChatColor.DARK_PURPLE + "Tarantula Chestplate",lore, chestplate.stats.getBase());
    }

    @Override
    public void createLeggings(Dragsim plugin){
        leggings.piece = new ItemStack(Material.LEATHER_LEGGINGS);

        ItemMeta itemMeta = leggings.piece.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        leggings.piece.setItemMeta(leatherArmorMeta);

        List<String> lore = leggings.stats.getBaseStats(ChatColor.GREEN);

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

        CustomArmorPiece.createPiece(id, plugin,leggings.piece, ChatColor.DARK_PURPLE + "Tarantula Leggings",lore, leggings.stats.getBase());

        //createPiece();
    }

    @Override
    public void createBoots(Dragsim plugin){
        boots.piece = new ItemStack(Material.LEATHER_BOOTS);

        ItemMeta itemMeta = boots.piece.getItemMeta();

        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
        leatherArmorMeta.setColor(Color.BLACK);
        boots.piece.setItemMeta(leatherArmorMeta);

        List<String> lore = boots.stats.getBaseStats(ChatColor.GREEN);

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
        lore.add("");
        lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "EPIC BOOTS");


        CustomArmorPiece.createPiece(id, plugin, boots.piece, ChatColor.DARK_PURPLE + "Tarantula Boots",lore, boots.stats.getBase());

    }

}
