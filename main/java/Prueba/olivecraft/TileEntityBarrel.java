package Prueba.olivecraft;

import java.util.Random;


import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBarrel extends TileEntity {
		
	public static final int MAX_OLIVES = 9;
	public static final int TIME = 24000;
	private boolean water, sugar, mushroom;
	private int fermenter;
	private int[] olives = new int[MAX_OLIVES];
	
	public EntityItem renderOliveRaw = new EntityItem(worldObj, 0, 0, 0, new ItemStack(OliveItems.olive));
	public EntityItem renderOliveEdible = new EntityItem(worldObj, 0, 0, 0, new ItemStack(OliveItems.oliveEdible));
	private Random rand = new Random();
	public double[] olivesX = new double[MAX_OLIVES], olivesZ = new double[MAX_OLIVES];
	
	public TileEntityBarrel() {
		water = sugar = mushroom = false;
		fermenter = 0;
		for (int i = 0; i < MAX_OLIVES; i++) {
			olives[i] = -1;
			olivesX[i] = 0;
			olivesZ[i] = 0;
		}
	}
	
	public boolean hasFermenter() {
		return fermenter > 0;
	}
	
	public int getOlive(int i) {
		return olives[i];
	}
	
	public boolean hasWater() {return water;}
	public boolean hasSugar() {return sugar;}
	public boolean hasMushroom() {return mushroom;}
	
	
	public boolean onActivated(ItemStack stack) {
		if (stack == null) {
			takeOlive();
			return false;
		} else if (stack.getItem() == OliveItems.olive) {
			return addOlive();
		} else if (!hasFermenter()) {
			if (!water && stack.getItem() == Items.potionitem && stack.getItemDamage() == 0) {
				water = true;
				makeFermenter();
				return true;
			} else if (water && !mushroom && stack.getItem() == Item.getItemFromBlock(Blocks.brown_mushroom)) {
				mushroom = true;
				makeFermenter();
				return true;
			} else if (water && !sugar && stack.getItem() == Items.sugar) {
				sugar = true;
				makeFermenter();
				return true;
			} else {
				takeOlive();
				return false;
			}
		} else {	
			takeOlive();
			return false;
		}
	}
	
	public void updateEntity() {
		for (int i = 0; i < MAX_OLIVES; i++) {
			if (hasFermenter()) {
				if (olives[i] > 0) {
					olives[i]--;
					if (olives[i] == 0)
						fermenter--;
					this.markDirty();
				}
			}
		}	
	}
	
	public void emptyFull() {
		for (int i = 0; i < MAX_OLIVES; i++) {
			if (!worldObj.isRemote) {
				if (olives[i] == 0) {				
					EntityItem olive = new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(OliveItems.oliveEdible));
					worldObj.spawnEntityInWorld(olive);
				} else if (olives[i] > 0) {
					EntityItem olive = new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(OliveItems.olive));
					worldObj.spawnEntityInWorld(olive);
				}
			}
			olives[i] = -1;
		}
	}
	
	public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setBoolean("water", water);
        tagCompound.setBoolean("sugar", sugar);
        tagCompound.setBoolean("mushroom", mushroom);
        tagCompound.setByte("fermenter", (byte) fermenter);
        
        NBTTagCompound oliveList = new NBTTagCompound();
        for (int i = 0; i < MAX_OLIVES; i++) {
        	oliveList.setShort("olive" + i, (short) olives[i]);
        }
        tagCompound.setTag("olives", oliveList);
	}
	
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
	    water = tagCompound.getBoolean("water");
	    sugar = tagCompound.getBoolean("sugar");
	    mushroom = tagCompound.getBoolean("mushroom");
	    fermenter = tagCompound.getByte("fermenter");
        
	    NBTTagCompound oliveList = tagCompound.getCompoundTag("olives");
	    for (int i = 0; i < MAX_OLIVES; i++) {
	    	olives[i] = oliveList.getShort("olive" + i);
	    }
        
	    for (int i = 0; i < MAX_OLIVES; i++) {
	    	olivesX[i] = rand.nextDouble() * 0.6 - 0.3;
	    	olivesZ[i] = rand.nextDouble() * 0.6 - 0.3;
	    }
	}
	 
	 public Packet getDescriptionPacket() {
		 NBTTagCompound nbttagcompound = new NBTTagCompound();
		 this.writeToNBT(nbttagcompound);
		 return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, nbttagcompound);
	 }
	 
	 public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity packet) {
		 this.readFromNBT(packet.func_148857_g());
	 }
	
	private void makeFermenter() {
		if (fermenter == 0 && water && sugar && mushroom) {
			fermenter = 20;
			water = sugar = mushroom = false;
		}
	}
	
	private boolean addOlive() {
		boolean hasSpace = false;
		int i = 0;
		while (i < MAX_OLIVES && !hasSpace) {
			if (olives[i] == -1)
				hasSpace = true;
			else
				i++;
		}
		
		if (hasSpace) {
			olives[i] = TIME;
			olivesX[i] = rand.nextDouble() * 0.6 - 0.3;
			olivesZ[i] = rand.nextDouble() * 0.6 - 0.3;
		}
		return hasSpace;
	}
	
	private void takeOlive() {
		boolean hasOlives = false;
		int i = 0;
		while (i < MAX_OLIVES && !hasOlives) {
			if (olives[i] == 0)
				hasOlives = true;
			else
				i++;
		}
		
		if (hasOlives) {
			olives[i] = -1;
			if (!worldObj.isRemote) {
				EntityItem olive = new EntityItem(worldObj, xCoord, yCoord, zCoord, new ItemStack(OliveItems.oliveEdible));
				worldObj.spawnEntityInWorld(olive);
			}
		}
	}
	
	
}
