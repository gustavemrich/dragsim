package com.github.dragsim.player;

import com.github.dragsim.Dragsim;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class DPlayerManager{
    private HashMap<String, DPlayer> DPlayers;
    private Dragsim plugin;

    public DPlayerManager(Dragsim plugin){
        this.plugin = plugin;
        DPlayers = new HashMap<>();
    }

    public void loadPlayer(Player player){
        DPlayers.put(player.getUniqueId().toString(), new DPlayer(plugin, player.getUniqueId().toString()));
        loadBuffs(player);
    }

    public DPlayer getDPlayer(String uuid){
        return DPlayers.get(uuid);
    }

    public void loadBuffs(Player player){
        resetBuffs(player);
        loadBuffsArmor(player);
        loadBuffsHand(player);

    }

    private void resetBuffs(Player player){
        for (DPlayerStatType stat: DPlayerStatType.values()){
            if (!stat.getValue().equals(DPlayerStatType.REGEN_HEALTH) || !stat.getValue().equals(DPlayerStatType.REGEN_MANA));
            getDPlayer(player.getUniqueId().toString()).getStatistics().get(stat).set(getDPlayer(player.getUniqueId().toString()).getStatistics().get(stat).getBaseValue());
            Bukkit.broadcastMessage("Reset buffs");

        }

    }

    private void loadBuffsArmor(Player player){
        addBuffFromItem(player.getInventory().getHelmet(), player.getUniqueId().toString());
        addBuffFromItem(player.getInventory().getChestplate(), player.getUniqueId().toString());
        addBuffFromItem(player.getInventory().getLeggings(), player.getUniqueId().toString());
        addBuffFromItem(player.getInventory().getBoots(), player.getUniqueId().toString());

        Bukkit.broadcastMessage("Loaded armor armor");
    }

    private void loadBuffsHand(Player player){
        addBuffFromItem(player.getInventory().getItemInMainHand(), player.getUniqueId().toString());
    }


    private void addBuffFromItem(ItemStack itemStack, String uuid) {
        for (DPlayerStatType stat : DPlayerStatType.values()){

            stat.getValue();
            try {
                int value = itemStack.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(plugin, stat.getValue()), PersistentDataType.INTEGER);
                getDPlayer(uuid).getStatistics().get(DPlayerStatType.valueOf(stat.getValue())).add(value);
                Bukkit.broadcastMessage(stat.getValue());
            } catch (NullPointerException e) {
            }
        }
    }
}
