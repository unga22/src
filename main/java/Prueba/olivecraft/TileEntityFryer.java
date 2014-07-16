package Prueba.olivecraft;

import java.util.Random;


import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityFryer extends TileEntity implements ISidedInventory {
	
	private static final int[] bottom_slots = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private static final int[] other_slots = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
    private ItemStack[] inventory;
    public int fuel, wait, lastFuel, oil;

    public TileEntityFryer() {
        inventory = new ItemStack[11];
        fuel = 0;
        lastFuel = 0;
        wait = 200;
        oil = 0;
    }

    public int getSizeInventory() {
        return inventory.length;
    }

    public ItemStack getStackInSlot(int i) {
        return inventory[i];
    }

    public ItemStack decrStackSize(int i, int j) {
        ItemStack stack = getStackInSlot(i);
        if (stack != null) {
            if (stack.stackSize <= j) {
                setInventorySlotContents(i, null);
            } else {
                stack = stack.splitStack(j);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(i, null);
                }
            }
        }
        return stack;
    }

    public ItemStack getStackInSlotOnClosing(int i) {
        ItemStack stack = getStackInSlot(i);
        if (stack != null) {
            setInventorySlotContents(i, null);
        }
        return stack;
    }

    public void setInventorySlotContents(int i, ItemStack itemStack) {
        inventory[i] = itemStack;
        if (itemStack != null && itemStack.stackSize >= getInventoryStackLimit()) {
            itemStack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInventoryName() {
        return "fryer";
    }

    public boolean hasCustomInventoryName() {
        return false;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityPlayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    public void openInventory() {}
    public void closeInventory() {}

    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        if (i < 9) {
            return RecipesFryer.manager.isIngredient(itemStack);
        } else if (i == 9) {
            return TileEntityFurnace.isItemFuel(itemStack);
        } else if (i == 10) {
            return itemStack.getItem() == OliveItems.oil;
        } else {
            return false;
        }
    }
    
	public int[] getAccessibleSlotsFromSide(int side) {
		if (side == 0) {
			return bottom_slots;
		} else {
			return other_slots;
		}
	}

	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return isItemValidForSlot(i, itemStack);
	}

	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return RecipesFryer.manager.isResult(itemStack);
	}
	
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            ItemStack stack = inventory[i];
            if (stack != null) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setByte("Slot", (byte) i);
                stack.writeToNBT(tag);
                itemList.appendTag(tag);
            }
        }
        tagCompound.setTag("Inventory", itemList);
        tagCompound.setShort("Fuel", (short)fuel);
        tagCompound.setShort("LastFuel", (short)lastFuel);
        tagCompound.setShort("Wait", (short)wait);
        tagCompound.setShort("Oil", (short)oil);
    }
    
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        NBTTagList tagList = tagCompound.getTagList("Inventory", 10);
        for (int i = 0; i < tagList.tagCount(); i++) {
            NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
            byte slot = tag.getByte("Slot");
            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
        fuel = tagCompound.getShort("Fuel");
        wait = tagCompound.getShort("Wait");
        lastFuel = tagCompound.getShort("LastFuel");
        oil = tagCompound.getShort("Oil");
    }

    public void updateEntity() {
        if (fuel > 0) {
            wait--;
            oil++;
            fuel--;
        }

        if (fuel == 0) {
            if (canBurn()) {
                if (inventory[9] != null) {
                    fuel = TileEntityFurnace.getItemBurnTime(inventory[9]);
                    lastFuel = fuel;
                    inventory[9].stackSize--;
                    if (inventory[9].stackSize == 0) {
                        inventory[9] = null;
                    }
                }
            }
        }
        
        if (oil == 200) {
            if (inventory[10] != null && inventory[10].getItem() == OliveItems.oil) {
                if (inventory[10].getItemDamage() < inventory[10].getMaxDamage()) {
                    inventory[10].setItemDamage(inventory[10].getItemDamage() + 1);
                }
            }
            oil = 0;
        }

        if (wait == 0) {
            doCookingWithProb();
            wait = 200;
        }

        if (!canBurn()) {
            wait = 200;
        }

        if (!worldObj.isRemote) {
            updateBlock();
        }

        this.markDirty();
    }
    
    @SideOnly(Side.CLIENT)
    public int getFuelForDisplay(int scale) {
        if (lastFuel == 0) {
            lastFuel = 200;
        }
        return fuel * scale / lastFuel;
    }

    @SideOnly(Side.CLIENT)
    public int getProgressForDisplay(int scale) {
        return (200 - wait) * scale / 200;
    }

    private boolean canBurn() {
        boolean hasFuel = TileEntityFurnace.getItemBurnTime(inventory[9]) > 0 || fuel > 0;
        boolean hasOil = inventory[10] != null && inventory[10].getItem() == OliveItems.oil;
        boolean validRecipe = false;

        for (int i = 0; i < 9; i++) {
            validRecipe = validRecipe || isCookable(inventory[i]);
        }

        return hasFuel && hasOil && validRecipe;
    }

    private void doCookingWithProb() {
        int dmg = inventory[10].getItemDamage();
        Random rand = new Random();
        if (rand.nextInt(8) > (dmg - 24)) {
            doCooking(false);
        } else {
            doCooking(true);
        }
    }

    private void doCooking(boolean fail) {
        int i = 0;
        boolean located = !fail;
        for (i = 0; i < 9; i++) {
            if (isCookable(inventory[i])) {
                break;
            }
        }

        ItemStack result = fail ? RecipesFryer.manager.getFryerFail() : RecipesFryer.manager.getFryerResult(inventory[i]);
        inventory[i].stackSize--;
        if (inventory[i].stackSize == 0) {
            inventory[i] = null;
        }
        for (int j = 0; j < 9; j++) {
            if (inventory[j] == null) {
                inventory[j] = result.copy();
                located = true;
                break;
            } else {
                if (result.isItemEqual(inventory[j]) && inventory[j].stackSize + result.stackSize <= result.getMaxStackSize()) {
                    inventory[j].stackSize += result.stackSize;
                    located = true;
                    break;
                }
            }
        }
        if (!located && !worldObj.isRemote) {
            dropItem(result);
        }
    }

    private void dropItem(ItemStack item) {
        Random rand = new Random();
        if (item != null && item.stackSize > 0) {
            float rx = rand.nextFloat() * 0.6F + 0.1F;
            float ry = rand.nextFloat() * 0.6F + 0.1F;
            float rz = rand.nextFloat() * 0.6F + 0.1F;
            EntityItem entityItem = new EntityItem(worldObj, xCoord + rx, yCoord + ry, zCoord + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
            if (item.hasTagCompound()) {
                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
            }
            float factor = 0.05F;
            entityItem.motionX = rand.nextGaussian() * factor;
            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
            entityItem.motionZ = rand.nextGaussian() * factor;
            worldObj.spawnEntityInWorld(entityItem);
        }
    }

    private void updateBlock() {
        int on = fuel > 0 ? 4 : 0;
        int full = inventory[10] != null ? inventory[10].getItem() == OliveItems.oil ? 8 : 0 : 0;
        int meta = (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) & 3) | on | full;
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, meta, 2);
    }

    private boolean isCookable(ItemStack stack) {
        boolean cookable = false;
        ItemStack result = RecipesFryer.manager.getFryerResult(stack);
        if (result != null) {
            if (stack.stackSize == 1) {
                cookable = true;
            } else {
                for (int j = 0; j < 9; j++) {
                    if (inventory[j] != null) {
                        if (result.isItemEqual(inventory[j])) {
                            if (inventory[j].stackSize + result.stackSize <= result.getMaxStackSize()) {
                                cookable = true;
                            }
                        }
                    } else {
                        cookable = true;
                    }
                }
            }
        }
        return cookable;
    }
}
