package com.minecraftargentina.basemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFuelMachine extends TileEntity implements ISidedInventory{

	private ItemStack slots[];
	
	public int transformingTime;
	public int waterStatus;
	public int biofuelStatus;
	public int combustibleTime;
	public int combustibleTimeMax;
	public static final int maxWater = 100;
	public static final int maxBioFuel = 100;
	public static final int TransformingSpeed = 600;
	
	private static final int[] slots_top = new int[] {1, 2, 3};
	private static final int[] slots_bottom = new int[]  {0, 4};
	private static final int[] slots_side = new int[]  {5};	
	
	
	private String customname;

	public TileEntityFuelMachine() {
		slots = new ItemStack[6];
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
			
			waterStatus = nbt.getShort("WaterStatus");
			biofuelStatus = nbt.getShort("BioFuelStatus");
			combustibleTime = nbt.getShort("FuelTime");
			combustibleTimeMax = nbt.getShort("FuelTimeMax");
			transformingTime = nbt.getShort("TransformingTime");
			
			
		}
		
		public void writeToNBT(NBTTagCompound nbt){
			super.writeToNBT(nbt);
			nbt.setShort("WaterStatus", (short)waterStatus);
			nbt.setShort("BioFuelStatus", (short)biofuelStatus);
			nbt.setShort("FuelTime", (short)combustibleTime);
			nbt.setShort("FuelTimeMax", (short)combustibleTimeMax);
			nbt.setShort("TransformingTime", (short)transformingTime);
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
			if (item == BaseMod.itemResiduos){
				return 500;
			}
			
			
			return 0;
			
		}
	}

	
	
	
	@Override
	public String getInventoryName() {
		return "BioFuel Transformer";
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
	
	public int getTransformedProgressSclaed(int i) {
		return (transformingTime * i) / this.TransformingSpeed;
	}
	public int getWaterRemainingScaled(int i) {
		return ((this.waterStatus * i) / this.maxWater);
	}
	public int getBioFuelRemainingScaled(int i) {
		return ((this.biofuelStatus * i) / this.maxBioFuel);
	}
	public int getFuelTimeRemainingScaled(int i){
		return ((this.combustibleTime * i)/ this.combustibleTimeMax);
	}
	
	private boolean puedeTransformar() {
		if (slots[1] == null || slots[2] == null || slots[3] == null) {
			return false;
		}
		int porcentajedebiofuel = BioFuelRecipes.obtenerBioFuel(slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), waterStatus);
		if(porcentajedebiofuel > 0 && biofuelStatus != maxBioFuel){
			return true;
		} else {
			return false;
		}

	}
	
	private void transformarAgua() {
		if (puedeTransformar()) {
			int porcentajedebiofuel = BioFuelRecipes.obtenerBioFuel(slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), waterStatus);
			int AguaQueConsumir = BioFuelRecipes.ConsumirAgua(slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), waterStatus);
			waterStatus = waterStatus - AguaQueConsumir;
			biofuelStatus = biofuelStatus + porcentajedebiofuel;
			if(biofuelStatus > maxBioFuel){
				int BioFuelSobrante = biofuelStatus - maxBioFuel;
				biofuelStatus = biofuelStatus - BioFuelSobrante;
			}
			for (int i = 1; i <= 3; i++) {
				if (slots[i].stackSize > 0) {
					slots[i].stackSize--;
				}
				if (slots[i].stackSize == 0) {
					slots[i] = null;
				}
			}
		}
	}
				
	public boolean tieneCombustible() {
		return combustibleTime > 0;
	}
	public boolean estaTransformado() {
		return this.transformingTime > 0;
	}
	public void updateEntity() {
		boolean flag = this.tieneCombustible();
		boolean flag1 = false;
		ItemStack cubo = new ItemStack(Items.bucket);
		//Comprobar Combiustibe y añadir tempo de quemar y quitar el item de combustible
		if(tieneCombustible() && this.estaTransformado()) {
			this.combustibleTime--;
		}
		if(!worldObj.isRemote){
			//Comprobar si se mete agua
			if(slots[0] != null && slots[0].getItem() == Items.water_bucket && waterStatus < maxWater){
				waterStatus = waterStatus + 10;
				if(slots[0]!= null){
					flag1 = true;
					slots[0] = cubo.copy();
				}
			}
			if (hasItemPower(slots[4]) && combustibleTime == 0) {
				combustibleTimeMax = combustibleTime = getItemPower(slots[4]);
				if(slots[4] != null) {
					flag1 = true;
					slots[4].stackSize--;
					if (slots[4].stackSize == 0){
						slots[4] = null;
						
					}							
				}
			}
			//Transformacion
			if (tieneCombustible() && puedeTransformar()) {
				transformingTime++;
				if (this.transformingTime == this.TransformingSpeed){
					this.transformingTime = 0;
					this.transformarAgua();
					flag1 = true;
					
				}				
			}
		if ((flag == this.estaTransformado()) || (flag != this.estaTransformado())) {
			flag1 = true;
			FuelMachine.updateBlockState(this.estaTransformado(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);						
	    	}		
    	}
	
	    if (flag1) {
		this.markDirty();
	    }
    }
	

}


	

	
	
	
