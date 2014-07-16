package Prueba.olivecraft;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FillingRecipe implements ICuantityRecipe {
    private ItemStack containerEmpty;
    private ItemStack containerFull;
    private int maxCapacity;
    private ItemStack content;

    public FillingRecipe(ItemStack containerEmpty, ItemStack containerFull, ItemStack content) {
        this.containerEmpty = containerEmpty;
        this.containerFull = containerFull;
        this.maxCapacity = containerFull.getItem().getMaxDamage();
        this.content = content;
    }

    public boolean matches(InventoryCrafting inventorycrafting, World world) {
        int cuantity = 0;
        ItemStack container = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ItemStack stack = inventorycrafting.getStackInRowAndColumn(i, j);
                if (stack != null) {
                    if (stack.isItemEqual(containerEmpty) || stack.getItem() == containerFull.getItem()) {
                        if (container != null) {
                            return false;
                        } else {
                            container = stack.copy();
                        }
                    }
                    if (stack.isItemEqual(content)) {
                        cuantity += stack.stackSize;
                    }
                }
            }
        }

        if (container == null || cuantity == 0) {
            return false;
        } else {
            if (container.isItemEqual(containerEmpty)) {
                return cuantity <= maxCapacity;
            } else if (container.getItem() == containerFull.getItem()) {
                return cuantity - container.getItemDamage() <= 0;
            }
        }
        return false;
    }

    public ItemStack getCraftingResult(InventoryCrafting inventorycrafting)  {
        int cuantity = 0, damage;
        ItemStack container = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ItemStack stack = inventorycrafting.getStackInRowAndColumn(i, j);
                if (stack != null) {
                	if (stack.isItemEqual(containerEmpty) || stack.getItem() == containerFull.getItem()) {
                        container = stack.copy();
                    }
                	if (stack.isItemEqual(content)) {
                        cuantity += stack.stackSize;
                    }
                }
            }
        }
        damage = container.isItemEqual(containerEmpty) ? maxCapacity : container.getItemDamage();
        damage -= cuantity;
        return new ItemStack(containerFull.getItem(), 1, damage);
    }

    public int getRecipeSize() {
        return 9;
    }

    public ItemStack getRecipeOutput() {
        return this.containerFull;
    }

    public int getCuantityUsedOf(ItemStack itemStack) {
        if (itemStack.isItemEqual(content)) {
            return 64;
        } else {
            return 1;
        }
    }
}
