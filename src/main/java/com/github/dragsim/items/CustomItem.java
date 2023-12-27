package com.github.dragsim.items;


import com.github.dragsim.Dragsim;
import org.bukkit.entity.Player;

public abstract class CustomItem implements ItemEvents {

    public Dragsim plugin;

    public CustomItem(Dragsim plugin){
        this.plugin = plugin;

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
