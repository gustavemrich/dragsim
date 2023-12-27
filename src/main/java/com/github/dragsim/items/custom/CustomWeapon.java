package com.github.dragsim.items.custom;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.CustomItem;
import com.github.dragsim.items.custom.weapons.WeaponCooldownManager;
import com.github.dragsim.player.StatType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CustomWeapon extends CustomItem {

    private int damage;
    private ItemStack item;
    private HashMap<StatType, Integer> buffs;
    public WeaponCooldownManager cooldownManager;

    public CustomWeapon(Dragsim plugin, long cooldownDuration){
        super(plugin);
        cooldownManager = new WeaponCooldownManager(cooldownDuration);

    }


    public Dragsim getPlugin(){
        return super.plugin;
    }


    public void createWeapon(Material material,String name, List<String> lore, HashMap<String, Integer> stats) {
        item = new ItemStack(material);

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(name);

        itemMeta.setLore(lore);

        itemMeta.setUnbreakable(true);



        for (Map.Entry<String, Integer> e:stats.entrySet()) {

            itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, e.getKey()), PersistentDataType.INTEGER, e.getValue());
        }
        itemMeta.getPersistentDataContainer().set(new NamespacedKey(plugin, "iscustom"), PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

    }

    public ItemStack getItem(){
        return item;
    }
}
