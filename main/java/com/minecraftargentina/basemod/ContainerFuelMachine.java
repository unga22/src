package com.minecraftargentina.basemod;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerFuelMachine extends Container {

	private TileEntityFuelMachine bifuelTransformer;
	public int transformingTime;
	public int waterStatus;
	public int biofuelStatus;
	private int lastItemBurnTime;

	public ContainerFuelMachine(InventoryPlayer invPlayer, TileEntityFuelMachine biofuelTransformer) {
		transformingTime = 0;
		waterStatus = 0;
		biofuelStatus = 0;
		lastItemBurnTime = 0;

		bifuelTransformer = biofuelTransformer;
        //BioFuelImput
		this.addSlotToContainer(new Slot(bifuelTransformer, 0, 8, 56));
        //Natural 1
		this.addSlotToContainer(new Slot(bifuelTransformer, 1, 48, 8));
        //Natural 2
		this.addSlotToContainer(new Slot(bifuelTransformer, 2, 81, 8));
        //Natural 3
		this.addSlotToContainer(new Slot(bifuelTransformer, 3, 113, 8));
        //FuelImput
		this.addSlotToContainer(new Slot(bifuelTransformer, 4, 81, 56));
        //BifuelOutput
		this.addSlotToContainer(new Slot(bifuelTransformer, 5, 152, 56));


		//Inventoario del Jugador
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18)); 
			}
		}
		//ABarra en donde se ponen los items en miencraft
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters (ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.bifuelTransformer.transformingTime);
		crafting.sendProgressBarUpdate(this, 1, this.bifuelTransformer.waterStatus);
		crafting.sendProgressBarUpdate(this, 1, this.bifuelTransformer.biofuelStatus);
	}
	
	   public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(par2);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (par2 == 2)
	            {
	                if (!this.mergeItemStack(itemstack1, 3, 39, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (par2 != 1 && par2 != 0)
	            {
	                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
	                {
	                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
	                    {
	                        return null;
	                    }
	                }
	                else if (TileEntityFurnace.isItemFuel(itemstack1))
	                {
	                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
	                    {
	                        return null;
	                    }
	                }
	                else if (par2 >= 3 && par2 < 30)
	                {
	                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
	                    {
	                        return null;
	                    }
	                }
	                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	        }

	        return itemstack;
	    }
	   

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return bifuelTransformer.isUseableByPlayer(player);
	}

}