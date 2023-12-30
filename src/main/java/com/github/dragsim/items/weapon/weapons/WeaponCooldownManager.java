package com.github.dragsim.items.weapon.weapons;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.HashMap;

public class WeaponCooldownManager {
    private HashMap<String, Long> cooldowns;
    private final long cooldownDuration;

    public static DecimalFormat decimalFormat = new DecimalFormat("#.#");


    public WeaponCooldownManager(long cooldownDuration){
        cooldowns = new HashMap<>();
        this.cooldownDuration = cooldownDuration;
    }

    public long checkCooldown(String uuid) {
        if (!cooldowns.containsKey(uuid)) {
            addCooldown(uuid, cooldownDuration);
            return 0;
        } else if (cooldowns.get(uuid) < System.currentTimeMillis()) {
            addCooldown(uuid, cooldownDuration);
            return 0;
        }
        return cooldowns.get(uuid) - System.currentTimeMillis();
    }

    private void addCooldown(String uuid, long cooldownDuration){
        cooldowns.put(uuid, System.currentTimeMillis() + cooldownDuration);
    }

    public static void sendCooldownMessage(Player player, long cooldown){
        player.sendMessage(ChatColor.RED + "You are on cooldown for another " + decimalFormat.format(cooldown/1000D) + "s");
    }
}
