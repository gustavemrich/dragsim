package com.github.dragsim.items.armor;

import com.github.dragsim.Dragsim;

import java.util.HashMap;

public class CustomArmorManager {

    private Dragsim plugin;
    private HashMap<ArmorType, CustomArmorSet> armors = new HashMap<>();


    public CustomArmorManager(Dragsim plugin){
        this.plugin = plugin;
        loadArmor();

    }

    private void loadArmor(){
        armors.put(ArmorType.TARANTULA, new Tarantula());
    }
    public HashMap<ArmorType, CustomArmorSet> getArmor(){
        return armors;
    }
}
