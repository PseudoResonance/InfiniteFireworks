package io.github.wolfleader116.infinitefireworks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteFireworks extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.hasItem() && e.getItem().getType() == Material.FIREWORK) {
				Location loc = e.getPlayer().getEyeLocation().toVector().add(e.getPlayer().getLocation().getDirection().multiply(2)).toLocation(e.getPlayer().getWorld(), e.getPlayer().getLocation().getYaw(), e.getPlayer().getLocation().getPitch());
				ItemStack item = e.getItem();
				Firework firework = (Firework) e.getPlayer().getWorld().spawnEntity(loc, EntityType.FIREWORK);
				FireworkMeta fwm = (FireworkMeta)item.getItemMeta();
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDispenser(BlockDispenseEvent e) {
		Block b = e.getBlock();
		if (b.getType() == Material.DISPENSER && e.getItem().getType() == Material.FIREWORK) {
			ItemStack item = e.getItem();
			FireworkMeta fwm = (FireworkMeta)item.getItemMeta();
			MaterialData d = b.getState().getData();
			Dispenser disp = (Dispenser) d;
			int bdata = disp.getRawData();
			if (bdata == 0) {
				Location fire = b.getLocation();
				fire.setX(fire.getX() + 0.5);
				fire.setZ(fire.getZ() + 0.5);
				fire.setY(fire.getY() - 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else if (bdata == 1) {
				Location fire = b.getLocation();
				fire.setX(fire.getX() + 0.5);
				fire.setZ(fire.getZ() + 0.5);
				fire.setY(fire.getY() + 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else if (bdata == 2) {
				Location fire = b.getLocation();
				fire.setX(fire.getX() + 0.5);
				fire.setY(fire.getY() + 0.5);
				fire.setZ(fire.getZ() - 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else if (bdata == 3) {
				Location fire = b.getLocation();
				fire.setX(fire.getX() + 0.5);
				fire.setY(fire.getY() + 0.5);
				fire.setZ(fire.getZ() + 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else if (bdata == 4) {
				Location fire = b.getLocation();
				fire.setZ(fire.getZ() + 0.5);
				fire.setY(fire.getY() + 0.5);
				fire.setX(fire.getX() - 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else if (bdata == 5) {
				Location fire = b.getLocation();
				fire.setZ(fire.getZ() + 0.5);
				fire.setY(fire.getY() + 0.5);
				fire.setX(fire.getX() + 1);
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			} else {
				Location fire = b.getLocation();
				Firework firework = (Firework) b.getWorld().spawnEntity(fire, EntityType.FIREWORK);
				firework.setFireworkMeta(fwm);
				e.setCancelled(true);
			}
		}
	}
}
