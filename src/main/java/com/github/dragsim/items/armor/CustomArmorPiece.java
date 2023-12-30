package com.github.dragsim.items.armor;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.CustomItem;
import com.github.dragsim.items.ItemStatType;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomArmorPiece extends CustomItem {

    public ItemStack piece;

    public Dragsim getPlugin(){
        return super.plugin;
    }

    public CustomArmorPiece(Dragsim plugin, LinkedHashMap<ItemStatType, Integer> stats) {
        super(plugin, stats);
    }

    public static void createPiece(int id, Dragsim plugin, ItemStack itemstack, String name, List<String> lore, LinkedHashMap<ItemStatType, Integer> stats) {

        ItemMeta itemMeta = itemstack.getItemMeta();

        itemMeta.setDisplayName(name);

        itemMeta.setLore(lore);

        itemMeta.setUnbreakable(true);

        for (Map.Entry<ItemStatType, Integer> e:stats.entrySet()) {

            itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin,e.getKey().getValue()), PersistentDataType.INTEGER, e.getValue());
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "iscustom"), PersistentDataType.BOOLEAN, true);
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "id"), PersistentDataType.INTEGER, id);

        itemstack.setItemMeta(itemMeta);
    }

    public ItemStack getPiece(){
        return piece;
    }


}
