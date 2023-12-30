package com.github.dragsim.items.weapon.weapons;

import com.github.dragsim.Dragsim;
import com.github.dragsim.items.ItemStatType;
import com.github.dragsim.items.weapon.CustomWeapon;
import com.github.dragsim.player.DPlayerStatType;
import org.bukkit.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class FrozenScythe extends CustomWeapon {

    private int manaCost;
    public FrozenScythe(Dragsim plugin) {
        super(plugin, 0, new LinkedHashMap<>() {
            {
                put(ItemStatType.DAMAGE, 80);
            }
        });
        manaCost = 30;
        createItem();
    }

    public void createItem(){
        List<String> lore = super.getStat().getBaseStats(ChatColor.RED);
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Ice Bolt " + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK");
        lore.add(ChatColor.GRAY + "Shoots " + ChatColor.GOLD + "1 " + ChatColor.GRAY + "Ice Bolt that deals");
        lore.add(ChatColor.GRAY + "damage and slows enemies hit");
        lore.add(ChatColor.GRAY + "for " + ChatColor.YELLOW + "5 seconds.");
        lore.add(ChatColor.DARK_GRAY + "Mana Cost: " + ChatColor.DARK_AQUA + "30");
        lore.add("");
        lore.add("" + ChatColor.BLUE + ChatColor.BOLD + "RARE WEAPON");

        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("damage", 80);

        createWeapon(Material.IRON_HOE,ChatColor.BLUE + "Frozen Scythe", lore, super.getStat().getBase());

    }
    @Override
    public void onRightClick(Player player) {
        if (manaCost<=plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).getValue()) {
            plugin.getDPlayerManager().getDPlayer(player.getUniqueId().toString()).getStatistics().get(DPlayerStatType.REGEN_MANA).remove(manaCost);

            Location loc = player.getLocation();
            player.playSound(loc, Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 10.0f);
            loc.add(0, 1, 0);

            Location origin = loc.clone();

            Vector to1 = loc.getDirection().normalize().multiply(0.3);
            Vector to = loc.getDirection().normalize().multiply(1.0);

            EulerAngle angle = new EulerAngle(0, 0, 12.0);

            loc.add(to1);

            ArmorStand firstStand = origin.getWorld().spawn(loc, ArmorStand.class);
            firstStand.setVisible(false);
            firstStand.setArms(true);
            firstStand.setItemInHand(new ItemStack(Material.ICE));
            firstStand.setSmall(true);
            firstStand.setMarker(true);
            firstStand.setRightArmPose(angle);

            loc.add(to1);

            ArmorStand secondStand = origin.getWorld().spawn(loc, ArmorStand.class);
            secondStand.setVisible(false);
            secondStand.setArms(true);
            secondStand.setItemInHand(new ItemStack(Material.PACKED_ICE));
            secondStand.setSmall(true);
            secondStand.setMarker(true);
            secondStand.setRightArmPose(angle);

            loc.add(to1);

            ArmorStand thirdStand = origin.getWorld().spawn(loc, ArmorStand.class);
            thirdStand.setVisible(false);
            thirdStand.setArms(true);
            thirdStand.setItemInHand(new ItemStack(Material.ICE));
            thirdStand.setSmall(true);
            thirdStand.setMarker(true);
            thirdStand.setRightArmPose(angle);

            loc.add(to1);

            ArmorStand fourthStand = origin.getWorld().spawn(loc, ArmorStand.class);
            fourthStand.setVisible(false);
            fourthStand.setArms(true);
            fourthStand.setItemInHand(new ItemStack(Material.PACKED_ICE));
            fourthStand.setSmall(true);
            fourthStand.setMarker(true);
            fourthStand.setRightArmPose(angle);

            final boolean[] didHitBlock = {false};

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (firstStand.getLocation().getBlock().getType() != Material.AIR) {
                        didHitBlock[0] = true;

                        firstStand.setGravity(false);
                        secondStand.setGravity(false);
                        thirdStand.setGravity(false);
                        fourthStand.setGravity(false);

                        delay(() -> {
                            firstStand.remove();
                            secondStand.remove();
                            thirdStand.remove();
                            fourthStand.remove();
                        }, 100);

                        this.cancel();
                    }

                    firstStand.getLocation().getWorld().spawnParticle(Particle.CLOUD, firstStand.getLocation(), 1, 0, 0, 0, 0);

                    moveArmorStand(firstStand);
                    moveArmorStand(secondStand);
                    moveArmorStand(thirdStand);
                    moveArmorStand(fourthStand);

                    if (firstStand.getLocation().distance(origin) > 50) {
                        firstStand.remove();
                        secondStand.remove();
                        thirdStand.remove();
                        fourthStand.remove();
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0, 1);
        }
    }

    public void delay(Runnable run, long ticks) {
        new BukkitRunnable() {
            @Override
            public void run() {
                run.run();
            }
        }.runTaskLater(plugin, ticks);
    }
    private void moveArmorStand(ArmorStand armorStand) {
        // Get the current location of the armor stand
        Location currentLocation = armorStand.getLocation();

        // Calculate the new location (for example, move it 1 block forward)
        Vector direction = currentLocation.getDirection().multiply(1); // Move 1 block in the direction the armor stand is facing
        Location newLocation = currentLocation.add(direction);

        // Set the new location for the armor stand
        armorStand.teleport(newLocation);
    }
}
