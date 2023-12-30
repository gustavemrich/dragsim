package com.github.dragsim.items;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemStat {

    private LinkedHashMap<ItemStatType, Integer> base;

    // private HashMap<ItemStatType, Integer> reforge;

    public ItemStat(LinkedHashMap<ItemStatType, Integer> base){
        this.base = base;
    }

    public List<String> getBaseStats(ChatColor numberColor){
        List<String> s = new ArrayList<>();
        for (Map.Entry<ItemStatType, Integer> entry : base.entrySet()){
            s.add(ChatColor.GRAY + entry.getKey().getLore() + ": " + numberColor + "+" + entry.getValue() + entry.getKey().getSuffix());
        }
        return s;
    }

    public LinkedHashMap<ItemStatType, Integer> getBase(){
        return base;
    }

}
