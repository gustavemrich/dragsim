package com.github.dragsim.player;

import com.github.dragsim.Dragsim;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Regen {
    private Dragsim plugin;

    public Regen(Dragsim plugin){
        this.plugin = plugin;
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String uuid = p.getUniqueId().toString();
                DPlayer dplayer = plugin.getDPlayerManager().getDPlayer(uuid);
                int maxHealth = dplayer.getStatistics().get(StatType.HEALTH).getValue();
                int maxMana = dplayer.getStatistics().get(StatType.MANA).getValue();
                if (dplayer.getStatistics().get(StatType.REGEN_HEALTH).getValue() + 15 > maxHealth){
                    dplayer.getStatistics().get(StatType.REGEN_HEALTH).set(maxHealth);
                }else {
                    dplayer.getStatistics().get(StatType.REGEN_HEALTH).add(15);
                }
                if (dplayer.getStatistics().get(StatType.REGEN_MANA).getValue() + (maxMana * 0.04) > maxMana){
                    dplayer.getStatistics().get(StatType.REGEN_MANA).set(maxMana);
                }else {
                    dplayer.getStatistics().get(StatType.REGEN_MANA).add((int) (maxMana*0.04));
                }
            }
        }, 25L, 25L);
    }
}
