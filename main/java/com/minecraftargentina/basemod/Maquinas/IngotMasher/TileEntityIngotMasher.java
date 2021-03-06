package com.minecraftargentina.basemod.Maquinas.IngotMasher;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Cubos.CreacionDeCubos;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIngotMasher extends TileEntity implements ISidedInventory{

	private ItemStack slots[];
	
	public int dualCookTime;
	public int dualPower;
	public static final int maxPower = 10000;
	public static final int mashingSpeed = 100;
	
	private static final int[] slots_top = new int[] {0, 1};
	private static final int[] slots_bottom = new int[]  {3};
	private static final int[] slots_side = new int[]  {2};	
	
	
	private String customname;

	public TileEntityIngotMasher() {
		slots = new ItemStack[4];
	}

	@Override
	public int getSizeInventory() {
			return slots.length;
		
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return slots[i];
		
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (slots [i] != null) {
			ItemStack itemstack = slots [i];
				slots[i] = null;
                return itemstack;
		}else{
			return null;
		}
	
	}

		public ItemStack decrStackSize(int i, int j) {
		if (slots[i] != null) {
			if (slots[i].stackSize <= j) {
				ItemStack itemstack =  slots[i];
				slots[i] = null;
				return itemstack;
					
			}
			
			ItemStack itemstack1 = slots[i].splitStack(j);
			
			if (slots[i].stackSize == 0){
				slots[i] = null;
				
			}
			return itemstack1;
			
		}else{
			return null;
			
		}
	}
		

		public void readFromNBT (NBTTagCompound nbt) {
			super.readFromNBT(nbt);
			NBTTagList list = nbt.getTagList("Items", 10);
			slots = new ItemStack[getSizeInventory()];
			
			for (int i = 0; i < list.tagCount(); i++) {
				NBTTagCompound nbt1 = (NBTTagCompound)list.getCompoundTagAt(i);
				byte b0 = nbt1.getByte("Slot");
				
				if (b0 >= 0 && b0 < slots.length) {
					slots[b0] = ItemStack.loadItemStackFromNBT(nbt1);
					
				}
			}
			
			dualPower = nbt.getShort("PowerTime");
			dualCookTime = nbt.getShort("CookTime");
			
			
		}
		
		public void writeToNBT(NBTTagCompound nbt){
			super.writeToNBT(nbt);
			nbt.setShort("PowerTime", (short)dualPower);
			nbt.setShort("CookTime", (short)dualCookTime);
			NBTTagList list = new NBTTagList();
			
			for (int i = 0; i < slots.length; i++){
				if (slots[i] != null){
					NBTTagCompound nbt1 = new NBTTagCompound();
					nbt1.setByte("Slot", (byte)i);
					slots[i].writeToNBT(nbt1);
					list.appendTag(nbt1);
					
					
				}
			}
			
			nbt.setTag("Items", list);
		}	

	

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		slots[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
			
		}

	}
	@Override
	public int[] getAccessibleSlotsFromSide (int i) {
		return i == 0 ? slots_bottom : (i == 1 ? slots_top : slots_side);
		
	}	


	@Override
	public int getInventoryStackLimit() {
			return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this) {
			return false;
		}else{
			return player.getDistanceSq((double)xCoord + 0.50, (double)yCoord + 0.50, (double)zCoord + 0.50) <= 64;
		
		}
	}

	public void openInventory() {}
	public void closeInventory() {}		

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
			return i == 2 ? false : (i == 1 ? hasItemPower(itemStack) : true);
	}
	
	
	public boolean hasItemPower(ItemStack itemStack) {
		return getItemPower(itemStack) > 0;
		
	}
	
	private static int getItemPower (ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
			
		}else{
			Item item = itemstack.getItem();
			if (item == CreacionDeCubos.BioFuelBucketItem) return 500;
			
			
			return 0;
			
		}
	}

	
	
	
	@Override
	public String getInventoryName() {
		return "Ingot Masher";
	}
	

	@Override
	public boolean canInsertItem(int var1, ItemStack itemstack, int var3) {
		return this.isItemValidForSlot(var1, itemstack);		
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
		
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customname != null && this.customname.length() > 0;
		
	}
	
	public int getMasherProgressSclaed(int i) {
		return (dualCookTime * i) / this.mashingSpeed;
	}
	
	public int getPowerRemainingScaled(int i) {
		return (dualPower * i) / maxPower;
	}
	
	private boolean canMash() {
		
		if (slots[0] == null || slots[1] == null) {
			return false;
		}
		
		ItemStack itemstack = IngotMasherRecipes.getMashingResult(slots[0].getItem(), slots[1].getItem());
		
		if (itemstack == null) {
			return false;
		}
		
		if (slots[3] == null){
			return true;
		}
		
		if (!slots[3].isItemEqual(itemstack)) {
			return false;
		}
		
		if (slots[3].stackSize < getInventoryStackLimit()  && slots[3].stackSize < slots[3].getMaxStackSize()) {
			return true;
		}else{
			return slots[3].stackSize < itemstack.getMaxStackSize();
		}				
	}
	
	private void mashItem() {
		if (canMash()) {
			ItemStack itemstack = IngotMasherRecipes.getMashingResult(slots[0].getItem(), slots[1].getItem());
			
			if (slots[3] == null) {
				slots[3] = itemstack.copy();
			}else if (slots[3].isItemEqual(itemstack)) {
				slots[3].stackSize += itemstack.stackSize;
				
			}
			
			for (int i = 0; i < 2; i++) {
				if (slots[i].stackSize <= 0) {
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
					
				}
					
					if (slots[i].stackSize > 0) {
						slots[i].stackSize--;
					}
					
					if (slots[i].stackSize == 0) {
						slots[i] = null;
					}
				}
			}
		}
				
			
				
	
	
	public boolean hasPower() {
		return dualPower > 0;

	}
	
	public boolean isMashing() {
		return this.dualCookTime > 0;
	}
	
	public void updateEntity() {
		boolean flag = this.hasPower();
		boolean flag1 = false;	

		
		if(hasPower() && this.isMashing()) {
			this.dualPower--;
		}
		
		if(!worldObj.isRemote){
			
			
			if (slots[2] != null && this.hasItemPower(this.slots[2]) && this.dualPower <= (this.maxPower - this.getItemPower(this.slots[2]))) {
				
				
				this.dualPower += getItemPower(this.slots[2]);
				
				slots[2] = new ItemStack(Items.bucket).copy();
				
		           	flag1 = true;
					
					this.slots[2].stackSize--;
						
					}							
				}
			
			
			if (hasPower() && canMash()) {
				dualCookTime++;
				
				if (this.dualCookTime == this.mashingSpeed){
					this.dualCookTime = 0;
					this.mashItem();
					flag1 = true;
					
				}				
			}else{ 
				dualCookTime = 0;
		}
	    if ((flag == this.isMashing()) || (flag != this.isMashing())){
			flag1 = true;
			IngotMasher.updateBlockState(this.isMashing(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);						
	    	}		
    	
	
	    if (flag1) {
		this.markDirty();
	    }
    }
	
  }



	

	
	
	
