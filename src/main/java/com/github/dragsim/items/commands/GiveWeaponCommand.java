package com.github.dragsim.items.commands;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.weapon.WeaponType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GiveWeaponCommand implements TabExecutor {
    private Dragsim plugin;

    public GiveWeaponCommand(Dragsim plugin){
        this.plugin = plugin;

    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length > 0) {
                switch (strings[0].toLowerCase()) {
                    case "leaping_sword":
                        player.getInventory().addItem(plugin.getCustomWeaponManager().getWeapons().get(WeaponType.LEAPING_SWORD).getItem());
                        break;
                    case "aspect_of_the_end":
                        player.getInventory().addItem(plugin.getCustomWeaponManager().getWeapons().get(WeaponType.ASPECT_OF_THE_END).getItem());
                        break;
                    case "aspect_of_the_void":
                        player.getInventory().addItem(plugin.getCustomWeaponManager().getWeapons().get(WeaponType.ASPECT_OF_THE_VOID).getItem());
                        break;
                    case "frozen_scythe":
                        player.getInventory().addItem(plugin.getCustomWeaponManager().getWeapons().get(WeaponType.FROZEN_SCYTHE).getItem());
                    default:
                        player.sendMessage("Weapon doesnt exist x(");
                        break;
                }
            }


        }
        return false;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> completions = new ArrayList<>();
        completions.add("Leaping_Sword");
        completions.add("Aspect_Of_The_End");
        completions.add("Aspect_of_the_End");
        completions.add("Frozen_Scythe");
        return completions;
    }
}
