package com.github.dragsim.player;

import com.github.dragsim.Dragsim;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Regen {
    private Dragsim plugin;

    public Regen(Dragsim plugin){
        this.plugin = plugin;
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String uuid = p.getUniqueId().toString();
                DPlayer dplayer = plugin.getDPlayerManager().getDPlayer(uuid);
                int maxHealth = dplayer.getStatistics().get(DPlayerStatType.HEALTH).getValue();
                int maxMana = dplayer.getStatistics().get(DPlayerStatType.MANA).getValue();
                if (dplayer.getStatistics().get(DPlayerStatType.REGEN_HEALTH).getValue() + 15 > maxHealth){
                    dplayer.getStatistics().get(DPlayerStatType.REGEN_HEALTH).set(maxHealth);
                }else {
                    dplayer.getStatistics().get(DPlayerStatType.REGEN_HEALTH).add(15);
                }
                if (dplayer.getStatistics().get(DPlayerStatType.REGEN_MANA).getValue() + (maxMana * 0.04) > maxMana){
                    dplayer.getStatistics().get(DPlayerStatType.REGEN_MANA).set(maxMana);
                }else {
                    dplayer.getStatistics().get(DPlayerStatType.REGEN_MANA).add((int) (maxMana*0.04));
                }
            }
        }, 20L, 20L);
    }
}
