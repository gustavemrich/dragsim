package com.github.dragsim.player;

import com.github.dragsim.Dragsim;
import com.github.dragsim.player.statistics.*;

import java.util.HashMap;

public class DPlayer {
    private HashMap<StatType, Stat> statistics;
    public DPlayer(Dragsim plugin, String uuid){
        statistics = new HashMap<>();
        loadStatistics(plugin);

    }
    private void loadStatistics(Dragsim plugin){
        statistics.put(StatType.CRIT_CHANCE, new CritChance(plugin));
        statistics.put(StatType.CRIT_DAMAGE, new CritDamage(plugin));
        statistics.put(StatType.DEFENSE, new Defense(plugin));
        statistics.put(StatType.HEALTH, new Health(plugin));
        statistics.put(StatType.MAGIC_FIND, new MagicFind(plugin));
        statistics.put(StatType.MANA, new Mana(plugin));
        statistics.put(StatType.SPEED, new Speed(plugin));
        statistics.put(StatType.STRENGTH, new Strength(plugin));
        statistics.put(StatType.REGEN_HEALTH, new RegenHealth(plugin));
        statistics.put(StatType.REGEN_MANA, new RegenMana(plugin));
    }

    public HashMap<StatType, Stat> getStatistics(){
        return statistics;
    }
}
