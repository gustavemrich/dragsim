package com.github.dragsim.events;

import com.github.dragsim.Dragsim;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class EventPlayerJoin implements Listener {

    private Dragsim plugin;

    public EventPlayerJoin(Dragsim plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getDPlayerManager().loadPlayer(event.getPlayer().getUniqueId().toString());
        /*
        // Get player UUID
        UUID uuid = event.getPlayer().getUniqueId();

        // Create player data directory if it doesn't exist
        File dataFolder = new File(plugin.getDataFolder(), "playerStats");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        // Create player file
        File playerFile = new File(dataFolder, uuid.toString() + ".yml");

        // Check if the player file already exists
        if (!playerFile.exists()) {
            try {
                playerFile.createNewFile();
                // You can add default data to the YAML file if needed
                YamlConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
                config.save(playerFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         */
    }

}

