package Prueba.olivecraft;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public interface ICuantityRecipe extends IRecipe
{
    /**
     * Returns the cuantity used of each item in the recipe
     */
    public int getCuantityUsedOf(ItemStack itemStack);
}
