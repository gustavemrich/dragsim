package com.github.dragsim.player;

import com.github.dragsim.Dragsim;
import com.github.dragsim.player.statistics.*;

import java.util.HashMap;

public class DPlayer {
    private HashMap<DPlayerStatType, DPlayerStat> statistics;

    public DPlayer(Dragsim plugin, String uuid){
        statistics = new HashMap<>();
        loadStatistics(plugin);

    }
    private void loadStatistics(Dragsim plugin){
        statistics.put(DPlayerStatType.CRIT_CHANCE, new CritChance(plugin));
        statistics.put(DPlayerStatType.CRIT_DAMAGE, new CritDamage(plugin));
        statistics.put(DPlayerStatType.DEFENSE, new Defense(plugin));
        statistics.put(DPlayerStatType.HEALTH, new Health(plugin));
        statistics.put(DPlayerStatType.MAGIC_FIND, new MagicFind(plugin));
        statistics.put(DPlayerStatType.MANA, new Mana(plugin));
        statistics.put(DPlayerStatType.SPEED, new Speed(plugin));
        statistics.put(DPlayerStatType.STRENGTH, new Strength(plugin));
        statistics.put(DPlayerStatType.REGEN_HEALTH, new RegenHealth(plugin));
        statistics.put(DPlayerStatType.REGEN_MANA, new RegenMana(plugin));
    }

    public HashMap<DPlayerStatType, DPlayerStat> getStatistics(){
        return statistics;
    }


}
