package com.github.dragsim.items;

import org.bukkit.entity.Player;

public interface ItemEvents {

    public void onEquip(Player player);
    public void onUnEquip(Player player);
    public void onLeftClick(Player player);
    public void onRightClick(Player player);
}
