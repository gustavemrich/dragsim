package com.github.dragsim.events;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.weapon.CustomWeapon;
import com.github.dragsim.items.weapon.WeaponType;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;

public class EventInteract implements Listener {

    private Dragsim plugin;
    public EventInteract(Dragsim plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e){
        e.setCancelled(true);
        return;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if (e.getItem() == null) return;
        if (e.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, "iscustom"), PersistentDataType.BOOLEAN)){
            for (Map.Entry<WeaponType, CustomWeapon> entry: plugin.getCustomWeaponManager().getWeapons().entrySet()) {
                if (e.getItem().isSimilar(entry.getValue().getItem())){
                    if (e.getAction().equals(Action.RIGHT_CLICK_AIR)){
                        entry.getValue().onRightClick(e.getPlayer());
                    }else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                        entry.getValue().onRightClick(e.getPlayer());
                    }
                }
            }
        }
    }
}
