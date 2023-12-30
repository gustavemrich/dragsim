package com.github.dragsim.actionbar;

import com.github.dragsim.Dragsim;
import com.github.dragsim.player.DPlayerStatType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ActionBar {

    private Dragsim plugin;

    public ActionBar(Dragsim plugin){
        this.plugin = plugin;
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String uuid = p.getUniqueId().toString();
                String message = ChatColor.RED + String.valueOf(plugin.getDPlayerManager().getDPlayer(uuid).getStatistics().get(DPlayerStatType.REGEN_HEALTH).getValue()) + "/" + ChatColor.RED + String.valueOf(plugin.getDPlayerManager().getDPlayer(uuid).getStatistics().get(DPlayerStatType.HEALTH).getValue()+ "❤     "
                        + ChatColor.GREEN + String.valueOf(plugin.getDPlayerManager().getDPlayer(uuid).getStatistics().get(DPlayerStatType.DEFENSE).getValue()) + "❈ Defense     " +
                        ChatColor.AQUA + String.valueOf(plugin.getDPlayerManager().getDPlayer(uuid).getStatistics().get(DPlayerStatType.REGEN_MANA).getValue() + "/" + String.valueOf(plugin.getDPlayerManager().getDPlayer(uuid).getStatistics().get(DPlayerStatType.MANA).getValue() + "✎")));
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

            }
        }, 5L, 5L);
    }
}
