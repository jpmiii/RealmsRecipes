package com.jpmiii.RealmsRecipes;

import java.util.Iterator;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.MaterialData;

public class RealmsRecipes extends JavaPlugin {

	public void onEnable() {

		// CraftingManager.getInstance().recipes;
		final Iterator<Recipe> recipes = getServer().recipeIterator();
		Recipe recipe;
		ItemStack result;

		while (recipes.hasNext()) {
			if ((recipe = recipes.next()) == null)
				continue;

			if ((result = recipe.getResult()) == null)
				continue;
			// remove diamond chestplate
			if (result.getType() == Material.DIAMOND_CHESTPLATE)
				recipes.remove();
			// remove diamond helmet
			if (result.getType() == Material.DIAMOND_HELMET)
				recipes.remove();
			// remove diamond leggings
			if (result.getType() == Material.DIAMOND_LEGGINGS)
				recipes.remove();
		}

		// Craft diamond chestplate

		ShapedRecipe recipe1 = new ShapedRecipe(new ItemStack(
				Material.DIAMOND_CHESTPLATE, 1));
		recipe1.shape("A A", "ABA", "AAA");
		recipe1.setIngredient('A', Material.DIAMOND);
		recipe1.setIngredient('B', Material.DIAMOND_BLOCK);
		getServer().addRecipe(recipe1);

		// uncraft diamond chestplate

		ShapelessRecipe recipe2 = new ShapelessRecipe(new ItemStack(
				Material.DIAMOND, 6));
		recipe2.addIngredient(1, Material.DIAMOND_CHESTPLATE);
		getServer().addRecipe(recipe2);

		// craft diamond leggings

		ShapedRecipe recipe3 = new ShapedRecipe(new ItemStack(
				Material.DIAMOND_LEGGINGS, 1));
		recipe3.shape("A A", "A A", "ABA");
		recipe3.setIngredient('A', Material.DIAMOND);
		recipe3.setIngredient('B', Material.DIAMOND_BLOCK);
		getServer().addRecipe(recipe3);

		// uncraft diamond leggings

		ShapelessRecipe recipe6 = new ShapelessRecipe(new ItemStack(
				Material.DIAMOND, 5));
		recipe6.addIngredient(1, Material.DIAMOND_LEGGINGS);
		getServer().addRecipe(recipe6);

		ShapedRecipe recipe5 = new ShapedRecipe(new ItemStack(
				Material.DIAMOND_HELMET, 1));
		recipe5.shape("   ", "A A", "ABA");
		recipe5.setIngredient('A', Material.DIAMOND);
		recipe5.setIngredient('B', Material.DIAMOND_BLOCK);

		getServer().addRecipe(recipe5);

		ShapelessRecipe recipe8 = new ShapelessRecipe(new ItemStack(
				Material.DIAMOND, 3));
		recipe8.addIngredient(1, Material.DIAMOND_HELMET);

		getServer().addRecipe(recipe8);

		getLogger().info("onEnable has been invoked!");

	}

}
