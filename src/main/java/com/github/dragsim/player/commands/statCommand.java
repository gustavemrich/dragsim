package com.github.dragsim.player.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class statCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;

            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Crit Chance: %dplayer_crit_chance%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Crit Damage: %dplayer_crit_damage%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Defense: %dplayer_defense%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Health: %dplayer_health%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Magic Find: %dplayer_magic_find%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Mana: %dplayer_mana%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Speed: %dplayer_speed%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Strength: %dplayer_strength%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Regen Health: %dplayer_regen_health%"));
            player.sendMessage(PlaceholderAPI.setPlaceholders(player, "Regen Mana: %dplayer_regen_mana%"));
        }
        return false;
    }
}
