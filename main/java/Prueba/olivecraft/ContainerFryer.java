package Prueba.olivecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerFryer extends Container {
    private TileEntityFryer tileEntity;
    private int lastFuel, lastWait, lastLastFuel, lastOil;

    public ContainerFryer(TileEntityFryer tileEntity, InventoryPlayer inventory) {
        this.tileEntity = tileEntity;
        bindFryerInventory();
        bindPlayerInventory(inventory);
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting) {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tileEntity.fuel);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tileEntity.wait);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tileEntity.lastFuel);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.tileEntity.oil);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastFuel != this.tileEntity.fuel) {
                icrafting.sendProgressBarUpdate(this, 0, this.tileEntity.fuel);
            }
            if (this.lastWait != this.tileEntity.wait) {
                icrafting.sendProgressBarUpdate(this, 1, this.tileEntity.wait);
            }
            if (this.lastLastFuel != this.tileEntity.lastFuel) {
                icrafting.sendProgressBarUpdate(this, 2, this.tileEntity.lastFuel);
            }
            if (this.lastOil != this.tileEntity.oil) {
                icrafting.sendProgressBarUpdate(this, 3, this.tileEntity.oil);
            }
        }
        this.lastFuel = this.tileEntity.fuel;
        this.lastWait = this.tileEntity.wait;
        this.lastLastFuel = this.tileEntity.lastFuel;
        this.lastOil = this.tileEntity.oil;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2) {
        if (par1 == 0) {
            this.tileEntity.fuel = par2;
        } else if (par1 == 1) {
            this.tileEntity.wait = par2;
        } else if (par1 == 2) {
            this.tileEntity.lastFuel = par2;
        } else if (par1 == 3) {
            this.tileEntity.oil = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return tileEntity.isUseableByPlayer(entityPlayer);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int id) {
        Slot slot = (Slot)this.inventorySlots.get(id);
        ItemStack itemStack = null;
        if (slot != null && slot.getHasStack()) {
            itemStack = slot.getStack();
            if (id < 11) {
                if (!this.mergeItemStack(itemStack, 11, 47, true)) {
                    return null;
                }
            } else {
                if (TileEntityFurnace.isItemFuel(itemStack)) {
                    if (!this.mergeItemStack(itemStack, 9, 10, true)) {
                        return null;
                    }
                } else if (itemStack.getItem() == OliveItems.oil) {
                    if (!this.mergeItemStack(itemStack, 10, 11, true)) {
                        return null;
                    }
                } else {
                    if (!this.mergeItemStack(itemStack, 0, 9, false)) {
                        return null;
                    }
                }            
            }
            if (itemStack.stackSize == 0)  {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
            slot.onPickupFromSlot(player, itemStack);
        }
        return itemStack;
    }

    private void bindPlayerInventory(InventoryPlayer inventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        
        for (int i = 0; i < 9; ++i)  {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    private void bindFryerInventory() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                this.addSlotToContainer(new SlotFryer(tileEntity, j + i * 3, 87 + j * 18, 17 + i * 18));
            }
        }

        addSlotToContainer(new SlotFryer(tileEntity, 9, 37, 53));
        addSlotToContainer(new SlotFryer(tileEntity, 10, 37, 17));
    }
}
