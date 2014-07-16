package Prueba.olivecraft;

import java.util.Iterator;
import java.util.List;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class SlotCraftingHelper {
	public static ICuantityRecipe cuantityRecipe(EntityPlayer player, IInventory craftMatrix) {
        List recipeList = CraftingManager.getInstance().getRecipeList();
        Iterator recipeSearcher = recipeList.iterator();
        ICuantityRecipe matchingRecipe = null;
        
        while (recipeSearcher.hasNext() && matchingRecipe == null) {
        	IRecipe recipe = (IRecipe) recipeSearcher.next();
        	if (recipe instanceof ICuantityRecipe && recipe.matches((InventoryCrafting) craftMatrix, player.worldObj)) {
        		matchingRecipe = (ICuantityRecipe) recipe;
        	}
        }
        
        return matchingRecipe;
	}
	
	public static void decreaseStack(ICuantityRecipe recipe, IInventory craftMatrix, int slot) {
		if (recipe != null) {
    		craftMatrix.decrStackSize(slot, recipe.getCuantityUsedOf(craftMatrix.getStackInSlot(slot)));
    	} else {
    		craftMatrix.decrStackSize(slot, 1);
    	}
	}
}
