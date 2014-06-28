package com.minecraftargentina.basemod.FuelMachine;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerFuelMachine extends Container {

	private TileEntityFuelMachine fuelmashine;
	public int transformingTime;
	public int waterStatus;
	public int biofuelStatus;
	public int combustibleTime;
	public int combustibleTimeMax;

	public ContainerFuelMachine(InventoryPlayer invPlayer, TileEntityFuelMachine biofuelTransformer) {

		fuelmashine = biofuelTransformer;
        //BioFuelImput
		this.addSlotToContainer(new Slot(fuelmashine, 0, 8, 72));
        //Natural 1
		this.addSlotToContainer(new Slot(fuelmashine, 1, 48, 24));
        //Natural 2
		this.addSlotToContainer(new Slot(fuelmashine, 2, 81, 24));
        //Natural 3
		this.addSlotToContainer(new Slot(fuelmashine, 3, 113, 24));
        //FuelImput
		this.addSlotToContainer(new Slot(fuelmashine, 4, 81, 72));
        //BifuelOutput
		this.addSlotToContainer(new Slot(fuelmashine, 5, 152, 72));


		//Inventoario del Jugador
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 100 + i * 18)); 
			}
		}
		//ABarra en donde se ponen los items en miencraft
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 158));
		}
	}

	public void addCraftingToCrafters (ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, fuelmashine.transformingTime);
		crafting.sendProgressBarUpdate(this, 1, fuelmashine.waterStatus);
		crafting.sendProgressBarUpdate(this, 2, fuelmashine.biofuelStatus);
		crafting.sendProgressBarUpdate(this, 3, fuelmashine.combustibleTime);
		crafting.sendProgressBarUpdate(this, 4, fuelmashine.combustibleTimeMax);
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
		return fuelmashine.isUseableByPlayer(player);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < crafters.size(); i++){
			ICrafting par1 = (ICrafting)crafters.get(i);
			
			if(transformingTime != fuelmashine.transformingTime){
				par1.sendProgressBarUpdate(this, 0, fuelmashine.transformingTime);
			}
			if(waterStatus != fuelmashine.waterStatus){
				par1.sendProgressBarUpdate(this, 1, fuelmashine.waterStatus);
			}
			if(biofuelStatus != fuelmashine.biofuelStatus){
				par1.sendProgressBarUpdate(this, 2, fuelmashine.biofuelStatus);
			}
			if(combustibleTime != fuelmashine.combustibleTime){
				par1.sendProgressBarUpdate(this, 3, fuelmashine.combustibleTime);
			}
			if(combustibleTimeMax != fuelmashine.combustibleTimeMax){
				par1.sendProgressBarUpdate(this, 4, fuelmashine.combustibleTimeMax);
			}
		}
		transformingTime = fuelmashine.transformingTime;
		waterStatus = fuelmashine.waterStatus;
		biofuelStatus = fuelmashine.biofuelStatus;
		combustibleTime = fuelmashine.combustibleTime;
		combustibleTimeMax = fuelmashine.combustibleTimeMax;
	}
	
	public void updateProgressBar(int i, int j) {
		if (i ==0){
			fuelmashine.transformingTime = j;	
		}
		if (i == 1) {
			fuelmashine.waterStatus = j;
		}
		if(i == 2){
			fuelmashine.biofuelStatus = j;
		}
		if(i == 3){
			fuelmashine.combustibleTime = j;
		}
		if(i == 4){
			fuelmashine.combustibleTimeMax = j;
		}
	}

}