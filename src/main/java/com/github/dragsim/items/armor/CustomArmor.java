package com.github.dragsim.items.armor;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.CustomItem;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class CustomArmor extends CustomItem {

    public ItemStack helmet;
    public ItemStack chestplate;
    public ItemStack leggings;
    public ItemStack boots;

    public int id;

    public enum Piece{
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS;
    }
    private HashMap<Piece, HashMap<DPlayerStatType, Integer>> buffs;

    public Dragsim getPlugin(){
        return super.plugin;
    }

    public CustomArmor(Dragsim plugin, int id) {
        super(plugin, new LinkedHashMap<>());
        this.id = id;
    }

    public void createPiece(ItemStack item, String name, List<String> lore, HashMap<String, Integer> stats) {

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);

        itemMeta.setLore(lore);

        itemMeta.setUnbreakable(true);

        for (Map.Entry<String, Integer> e:stats.entrySet()) {

            itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, e.getKey()), PersistentDataType.INTEGER, e.getValue());
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "iscustom"), PersistentDataType.BOOLEAN, true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.INTEGER, this.id);

        item.setItemMeta(itemMeta);
    }

    public ItemStack getHelmet(){
        return helmet;
    }

    public ItemStack getChestplate() {
        return chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public ItemStack getBoots() {
        return boots;
    }
}
