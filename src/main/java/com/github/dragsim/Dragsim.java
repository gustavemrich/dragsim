package com.github.dragsim;

import com.github.dragsim.actionbar.ActionBar;
import com.github.dragsim.events.EventDoubleJump;
import com.github.dragsim.events.EventInteract;
import com.github.dragsim.events.EventPlayerJoin;
import com.github.dragsim.items.armor.CustomArmorManager;
import com.github.dragsim.items.commands.GiveArmorCommand;
import com.github.dragsim.items.weapon.CustomWeaponManager;
import com.github.dragsim.items.commands.GiveWeaponCommand;
import com.github.dragsim.player.DPlayerManager;
import com.github.dragsim.player.PlaceHolderAPI.*;
import com.github.dragsim.player.Regen;
import com.github.dragsim.player.commands.statCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Dragsim extends JavaPlugin {

    private FileManager fileManager;
    private DPlayerManager dPlayerManager;

    private CustomWeaponManager customWeaponManager;

    private ActionBar actionBar;

    private Regen regen;

    private CustomArmorManager customArmorManager;

    @Override
    public void onEnable() {
        this.fileManager = new FileManager(this);
        this.fileManager.getConfig("config.yml").copyDefaults(true).save();
        this.dPlayerManager = new DPlayerManager(this);
        this.customWeaponManager = new CustomWeaponManager(this);
        this.actionBar = new ActionBar(this);
        this.regen = new Regen(this);
        this.customArmorManager = new CustomArmorManager(this);

        registerEvents();


        getCommand("stats").setExecutor(new statCommand());
        getCommand("giveweapon").setExecutor(new GiveWeaponCommand(this));
        getCommand("givearmor").setExecutor(new GiveArmorCommand(this));


        new StatPlaceHolder(this).register();
    }
    @Override
    public void onDisable() {
    }


    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new EventPlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new EventInteract(this), this);
        getServer().getPluginManager().registerEvents(new EventDoubleJump(this), this);
    }

    public DPlayerManager getDPlayerManager(){
        return dPlayerManager;
    }

    public CustomWeaponManager getCustomWeaponManager(){return customWeaponManager;}

    public CustomArmorManager getCustomArmorManager(){return customArmorManager;}
}
