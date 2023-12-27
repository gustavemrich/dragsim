package com.github.dragsim.items.custom;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.custom.weapons.AspectOfTheEnd;
import com.github.dragsim.items.custom.weapons.AspectOfTheVoid;
import com.github.dragsim.items.custom.weapons.LeapingSword;

import java.util.HashMap;

public class CustomWeaponManager {
    private Dragsim plugin;
    private HashMap<WeaponType, CustomWeapon> weapons = new HashMap<>();


    public CustomWeaponManager(Dragsim plugin){
        this.plugin = plugin;
        loadWeapons();

    }

    private void loadWeapons(){
        weapons.put(WeaponType.LEAPING_SWORD, new LeapingSword(plugin));
        weapons.put(WeaponType.ASPECT_OF_THE_END, new AspectOfTheEnd(plugin));
        weapons.put(WeaponType.ASPECT_OF_THE_VOID, new AspectOfTheVoid(plugin));
    }
    public HashMap<WeaponType, CustomWeapon> getWeapons(){
        return weapons;
    }
}
