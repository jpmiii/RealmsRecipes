package com.jpmiii.RealmsRecipes;

import java.util.Iterator;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RealmsRecipes extends JavaPlugin implements Listener {

	public void onEnable() {

		getServer().getPluginManager().registerEvents(this, this);

		// CraftingManager.getInstance().recipes;
		final Iterator<Recipe> recipes = getServer().recipeIterator();
		Recipe recipe;
		ItemStack result;

		while (recipes.hasNext()) {
			if ((recipe = recipes.next()) == null)
				continue;

			if ((result = recipe.getResult()) == null)
				continue;
			/*
			 * / remove diamond chestplate if (result.getType() ==
			 * Material.DIAMOND_CHESTPLATE) recipes.remove(); // remove diamond
			 * helmet if (result.getType() == Material.DIAMOND_HELMET)
			 * recipes.remove(); // remove diamond leggings if (result.getType()
			 * == Material.DIAMOND_LEGGINGS) recipes.remove();
			 */
		}

		getLogger().info("onEnable has been invoked!");

	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void invarmorEvent(InventoryClickEvent event) {
		ItemStack enar = event.getCurrentItem();
		String aname = null;
		if (enar.hasItemMeta()) {
			aname = enar.getItemMeta().getDisplayName();
		}

		getLogger().info("1 " + event.getInventory().getType().toString());
		getLogger().info("1a " + event.getInventory().getSize());

		if (event.getInventory().getType() == InventoryType.WORKBENCH) {

			ItemStack[] is = event.getInventory().getContents();

			if (is[1] != null) {
				//
				// all armor recipes have 16 emerald blocks in slot 1
				//
				if (is[1].equals(new ItemStack(Material.EMERALD_BLOCK, 16))) {
					//
					// Helm recipe
					//
					if (is[2].equals(new ItemStack(Material.NETHER_STAR, 1))
							&& is[3].equals(new ItemStack(Material.EMERALD_BLOCK, 16))
							&& is[4].equals(new ItemStack(Material.DIAMOND_BLOCK, 3))
							&& is[6].equals(new ItemStack(Material.DIAMOND_BLOCK, 3))) {
						ItemStack nit = new ItemStack(Material.DIAMOND_HELMET,	1);

						ItemMeta im = nit.getItemMeta();

						im.setDisplayName("Civrealms Helm");
						nit.setItemMeta(im);

						nit.addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						nit.addEnchantment(Enchantment.OXYGEN, 3);
						nit.addEnchantment(Enchantment.WATER_WORKER, 1);

						event.getInventory().clear();
						CraftingInventory ci = (CraftingInventory) event
								.getInventory();
						ci.setResult(nit);
					}
					//
					// Chest plate recipe
					//
					if (       //is[2].equals(new ItemStack(Material.NETHER_STAR, 1))
							//&& 
							   is[3].equals(new ItemStack(Material.EMERALD_BLOCK, 16))
							&& is[4].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							&& is[5].equals(new ItemStack(Material.RECORD_6, 1))
							&& is[6].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							&& is[7].equals(new ItemStack(Material.DIAMOND_BLOCK, 1))
							&& is[8].equals(new ItemStack(Material.DIAMOND_BLOCK, 1))
							&& is[9].equals(new ItemStack(Material.DIAMOND_BLOCK, 1))
							)
					{
						ItemStack nit = new ItemStack(Material.DIAMOND_CHESTPLATE,	1);

						ItemMeta im = nit.getItemMeta();

						im.setDisplayName("Civrealms Plate");
						nit.setItemMeta(im);

						nit.addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						//nit.addEnchantment(Enchantment.OXYGEN, 3);
						//nit.addEnchantment(Enchantment.WATER_WORKER, 1);

						event.getInventory().clear();
						CraftingInventory ci = (CraftingInventory) event
								.getInventory();
						ci.setResult(nit);
					}
					//
					// pants recipe
					//
					if (       is[2].equals(new ItemStack(Material.RECORD_11, 1))
							&& is[3].equals(new ItemStack(Material.EMERALD_BLOCK, 16))
							&& is[4].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							//&& is[5].equals(new ItemStack(Material.RECORD_6, 1))
							&& is[6].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							&& is[7].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							//&& is[8].equals(new ItemStack(Material.DIAMOND_BLOCK, 1))
							&& is[9].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							)
					{
						ItemStack nit = new ItemStack(Material.DIAMOND_LEGGINGS,	1);

						ItemMeta im = nit.getItemMeta();

						im.setDisplayName("Civrealms Pants");
						nit.setItemMeta(im);

						nit.addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						//nit.addEnchantment(Enchantment.OXYGEN, 3);
						//nit.addEnchantment(Enchantment.WATER_WORKER, 1);

						event.getInventory().clear();
						CraftingInventory ci = (CraftingInventory) event
								.getInventory();
						ci.setResult(nit);
					}
					//
					// boots recipe
					//
					if (       is[2].equals(new ItemStack(Material.RECORD_3, 1))
							&& is[3].equals(new ItemStack(Material.EMERALD_BLOCK, 16))
							&& is[4].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							&& is[5].equals(new ItemStack(Material.RECORD_3, 1))
							&& is[6].equals(new ItemStack(Material.DIAMOND_BLOCK, 2))
							&& is[7].equals(new ItemStack(Material.GOLDEN_APPLE, 16))
							&& is[8].equals(new ItemStack(Material.RECORD_3, 1))
							&& is[9].equals(new ItemStack(Material.GOLDEN_APPLE, 16))
							)
					{
						ItemStack nit = new ItemStack(Material.DIAMOND_BOOTS,	1);

						ItemMeta im = nit.getItemMeta();

						im.setDisplayName("Civrealms Boots");
						nit.setItemMeta(im);

						nit.addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 4);
						nit.addEnchantment(Enchantment.PROTECTION_FALL, 4);
						//nit.addEnchantment(Enchantment.WATER_WORKER, 1);

						event.getInventory().clear();
						CraftingInventory ci = (CraftingInventory) event
								.getInventory();
						ci.setResult(nit);
					}
				}
			}
		}

		if (event.getInventory().getType() == InventoryType.ANVIL) {

			if (aname != null) {
				if (aname.startsWith("Civrealms")) {
					String bname = event.getInventory().getItem(0)
							.getItemMeta().getDisplayName();
					if (bname == null) {
						event.setCancelled(true);
					} else if (!bname.startsWith("Civrealms")) {
						event.setCancelled(true);
					}
				}
			}
		}

		if (enar.containsEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)) {
			getLogger().info("2");
			if (enar.getType() == Material.DIAMOND_CHESTPLATE
					|| enar.getType() == Material.DIAMOND_LEGGINGS
					|| enar.getType() == Material.DIAMOND_HELMET
					|| enar.getType() == Material.DIAMOND_BOOTS) {
				getLogger().info("3");
				if (enar.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
					getLogger().info("4");

					// String aname = enar.getItemMeta().getDisplayName();
					if (aname == null) {
						getLogger().info("5");
						event.getCurrentItem().removeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL);
						event.getCurrentItem().addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					} else if (aname.startsWith("Civrealms") != true) {
						getLogger().info("5");
						event.getCurrentItem().removeEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL);
						event.getCurrentItem().addEnchantment(
								Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void enchantEvent(EnchantItemEvent event) {
		getLogger().info("e1 " + event.getInventory().getType().toString());
		Material am = event.getItem().getType();
		if (am == Material.DIAMOND_CHESTPLATE
				|| am == Material.DIAMOND_LEGGINGS
				|| am == Material.DIAMOND_HELMET
				|| am == Material.DIAMOND_BOOTS) {

			Map<Enchantment, Integer> enchmap = event.getEnchantsToAdd();
			if (enchmap.containsKey(Enchantment.PROTECTION_ENVIRONMENTAL)) {
				if (enchmap.get(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
					event.getEnchantsToAdd().put(
							Enchantment.PROTECTION_ENVIRONMENTAL, 3);
				}
			}
		}

	}

}
