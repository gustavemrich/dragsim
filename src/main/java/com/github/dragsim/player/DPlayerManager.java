package com.github.dragsim.player;

import com.github.dragsim.Dragsim;

import java.util.HashMap;

public class DPlayerManager{
    private HashMap<String, DPlayer> DPlayers;
    private Dragsim plugin;

    public DPlayerManager(Dragsim plugin){
        this.plugin = plugin;
        DPlayers = new HashMap<>();
    }

    public void loadPlayer(String uuid){
        DPlayers.put(uuid, new DPlayer(plugin, uuid));
    }

    public DPlayer getDPlayer(String uuid){
        return DPlayers.get(uuid);
    }
}
