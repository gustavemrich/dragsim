package com.github.dragsim.items.armor;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.CustomItem;
import com.github.dragsim.items.ItemStatType;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;

public abstract class CustomArmorSet {

    public CustomArmorPiece helmet;
    public CustomArmorPiece chestplate;
    public CustomArmorPiece leggings;
    public CustomArmorPiece boots;
    public int id;

    public CustomArmorSet(Dragsim plugin, int id,
                          LinkedHashMap<ItemStatType, Integer> helmetStat,
                          LinkedHashMap<ItemStatType, Integer> chestplateStat,
                          LinkedHashMap<ItemStatType, Integer> leggingsStat,
                          LinkedHashMap<ItemStatType, Integer> bootsStat){

        this.id = id;
        helmet = new CustomArmorPiece(plugin, helmetStat);
        chestplate = new CustomArmorPiece(plugin, chestplateStat);
        leggings = new CustomArmorPiece(plugin, leggingsStat);
        boots = new CustomArmorPiece(plugin, bootsStat);
        initArmor(plugin);
    }
    private void initArmor(Dragsim plugin){
        createBoots(plugin);
        createHelmet(plugin);
        createLeggings(plugin);
        createChestplate(plugin);
    }

    public abstract void createBoots(Dragsim plugin);

    public abstract void createLeggings(Dragsim plugin);

    public abstract void createChestplate(Dragsim plugin);

    public abstract void createHelmet(Dragsim plugin);

    public ItemStack getHelmet(){
        return helmet.getPiece();
    }

    public ItemStack getChestplate() {
        return chestplate.getPiece();
    }

    public ItemStack getLeggings() {
        return leggings.getPiece();
    }

    public ItemStack getBoots() {
        return boots.getPiece();
    }

}
