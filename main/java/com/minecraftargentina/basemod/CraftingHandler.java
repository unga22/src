package com.minecraftargentina.basemod;


import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {

	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {

		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {

				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
					if (item0 != null && item0.getItem() == CreacionDeItems.itemIronHammer) {
						ItemStack k = new ItemStack(CreacionDeItems.itemIronHammer, 2, (item0.getItemDamage() + 1));

						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
						}

					event.craftMatrix.setInventorySlotContents(i, k);

					}

				ItemStack item1 = event.craftMatrix.getStackInSlot(i);
					if (item1 != null && item1.getItem() == CreacionDeItems.itemIronPunch) {
						ItemStack k = new ItemStack(CreacionDeItems.itemIronPunch, 2, (item1.getItemDamage() + 1));

						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
						}

					event.craftMatrix.setInventorySlotContents(i, k);

					}
					ItemStack item2 = event.craftMatrix.getStackInSlot(i);
					if (item1 != null && item1.getItem() == CreacionDeItems.itemLija) {
						ItemStack k = new ItemStack(CreacionDeItems.itemLija, 2, (item1.getItemDamage() + 1));

						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
						}

					event.craftMatrix.setInventorySlotContents(i, k);

					}
					
					ItemStack item3 = event.craftMatrix.getStackInSlot(i);
					if (item1 != null && item1.getItem() == CreacionDeItems.itemTerrajaTM) {
						ItemStack k = new ItemStack(CreacionDeItems.itemTerrajaTM, 2, (item1.getItemDamage() + 1));

						if (k.getItemDamage() >= k.getMaxDamage()) {
							k.stackSize--;
						}

					event.craftMatrix.setInventorySlotContents(i, k);

					}
				}
			}
		}

}