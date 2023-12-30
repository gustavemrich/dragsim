package com.github.dragsim.items.commands;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.armor.ArmorType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GiveArmorCommand implements TabExecutor {

    private Dragsim plugin;

    public GiveArmorCommand(Dragsim plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            Player player = (Player) commandSender;
            if (strings.length > 0) {
                switch (strings[0].toLowerCase()) {
                    case "tarantula":
                        player.getInventory().addItem(plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).getBoots());
                        player.getInventory().addItem(plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).getLeggings());
                        player.getInventory().addItem(plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).getChestplate());
                        player.getInventory().addItem(plugin.getCustomArmorManager().getArmor().get(ArmorType.TARANTULA).getHelmet());
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> completions = new ArrayList<>();
        completions.add("tarantula");
        return completions;
    }
}
