package com.github.dragsim.player.PlaceHolderAPI;

import com.github.dragsim.Dragsim;
import com.github.dragsim.player.Stat;
import com.github.dragsim.player.StatType;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class StatPlaceHolder extends PlaceholderExpansion {

    private Dragsim plugin;

    public StatPlaceHolder(Dragsim plugin){
        this.plugin = plugin;

    }
    @Override
    public @NotNull String getIdentifier() {
        return "dplayer";
    }

    @Override
    public @NotNull String getAuthor() {
        return null;
    }

    @Override
    public @NotNull String getVersion() {
        return null;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (!player.isOnline()) return null;
        if (params.equalsIgnoreCase("strength")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.STRENGTH).getValue());
        } else if (params.equalsIgnoreCase("crit_chance")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.CRIT_CHANCE).getValue());
        }else if (params.equalsIgnoreCase("crit_damage")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.CRIT_DAMAGE).getValue());
        }else if (params.equalsIgnoreCase("defense")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.DEFENSE).getValue());
        }else if (params.equalsIgnoreCase("health")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.HEALTH).getValue());
        }else if (params.equalsIgnoreCase("magic_find")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.MAGIC_FIND).getValue());
        }else if (params.equalsIgnoreCase("mana")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.MANA).getValue());
        }else if (params.equalsIgnoreCase("speed")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.SPEED).getValue());
        }else if (params.equalsIgnoreCase("regen_mana")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_MANA).getValue());
        }else if (params.equalsIgnoreCase("regen_health")) {
            return String.valueOf(plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(StatType.REGEN_HEALTH).getValue());
        }
        return null;
    }
}
