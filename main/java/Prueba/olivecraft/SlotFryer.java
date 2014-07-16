package Prueba.olivecraft;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFryer extends Slot {

	public SlotFryer(IInventory inventory, int index, int x_coord, int y_coord) {
		super(inventory, index, x_coord, y_coord);
	}
	
	public boolean isItemValid(ItemStack itemStack) {
		return inventory.isItemValidForSlot(slotNumber, itemStack);
	}

}
