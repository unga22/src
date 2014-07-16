package Prueba.olivecraft;

import java.util.HashMap;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesFryer {
	public static RecipesFryer manager = new RecipesFryer();
	
    private HashMap<String, ItemStack> fryerRecipes = new HashMap<String, ItemStack>();

    private RecipesFryer(){
        addFryer(new ItemStack(Items.potato), new ItemStack(OliveItems.chip, 4, 0));
    }

    public void addFryer(ItemStack product, ItemStack result) {
    	fryerRecipes.put(getStackID(product), result);
    }

    public ItemStack getFryerResult(ItemStack product) {
        return fryerRecipes.get(getStackID(product));
    }

    public ItemStack getFryerFail() {
        return new ItemStack(OliveItems.burnt);
    }
    
    public boolean isIngredient(ItemStack itemStack) {
    	return fryerRecipes.containsKey(getStackID(itemStack));
    }
    
    public boolean isResult(ItemStack itemStack) {
    	if (itemStack.isItemEqual(getFryerFail())) {
    		return true;
    	} else {
    		boolean isResult = false;
    		for (ItemStack result : fryerRecipes.values()) {
    			if (itemStack.isItemEqual(result)) {
    				isResult = true;
    				break;
    			}
    		}
    		return isResult;
    	}
    }

    private String getStackID(ItemStack stack) {
        return stack != null ? stack.getUnlocalizedName() : "";
    }
}
