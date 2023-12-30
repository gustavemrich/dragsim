package com.github.dragsim.items.armor;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.armor.armors.Tarantula;

import java.util.HashMap;

public class CustomArmorManager {

    private Dragsim plugin;
    private HashMap<ArmorType, CustomArmor> armors = new HashMap<>();


    public CustomArmorManager(Dragsim plugin){
        this.plugin = plugin;
        loadArmor();

    }

    private void loadArmor(){
        armors.put(ArmorType.TARANTULA, new Tarantula(plugin, 1));
    }
    public HashMap<ArmorType, CustomArmor> getArmor(){
        return armors;
    }
}
