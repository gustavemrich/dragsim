package com.github.dragsim.items.weapon;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.CustomItem;
import com.github.dragsim.items.ItemStat;
import com.github.dragsim.items.ItemStatType;
import com.github.dragsim.items.weapon.weapons.WeaponCooldownManager;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class CustomWeapon extends CustomItem {

    private ItemStack item;

    public WeaponCooldownManager cooldownManager;

    public CustomWeapon(Dragsim plugin, long cooldownDuration, LinkedHashMap<ItemStatType, Integer> base){
        super(plugin, base);
        cooldownManager = new WeaponCooldownManager(cooldownDuration);

    }


    public Dragsim getPlugin(){
        return super.plugin;
    }


    public void createWeapon(Material material,String name, List<String> lore, LinkedHashMap<ItemStatType, Integer> stats) {
        item = new ItemStack(material);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);

        itemMeta.setLore(lore);

        itemMeta.setUnbreakable(true);



        for (Map.Entry<ItemStatType, Integer> e:stats.entrySet()) {

            itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, e.getKey().getValue()), PersistentDataType.INTEGER, e.getValue());
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "iscustom"), PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

    }

    public ItemStack getItem(){
        return item;
    }
    public ItemStat getStat(){
        return super.stats;
    }
}
