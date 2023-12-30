package com.github.dragsim.items;


import com.github.dragsim.Dragsim;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class CustomItem implements ItemEvents {

    public Dragsim plugin;

    public ItemStat stats;

    public CustomItem(Dragsim plugin, LinkedHashMap<ItemStatType, Integer> baseStat){
        this.plugin = plugin;
        this.stats = new ItemStat(baseStat);

    }
    @Override
    public void onEquip(Player player) {
        return;

    }

    @Override
    public void onUnEquip(Player player) {
        return;

    }

    @Override
    public void onLeftClick(Player player) {
        return;

    }

    @Override
    public void onRightClick(Player player) {
        return;

    }
}
