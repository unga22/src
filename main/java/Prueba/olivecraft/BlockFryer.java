package Prueba.olivecraft;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFryer extends BlockContainer {
    private IIcon sideIcon, topIcon, frontIcon;
    private IIcon topIconFull, frontIconOn;

    public BlockFryer(Material par2Material) {
        super(par2Material);
        setHardness(3.0F);
        setStepSound(soundTypeMetal);
        setBlockName("fryer");
        setCreativeTab(OliveCraft.oliveTab);
    }

    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityFryer();
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        } else if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        } else if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 0, 2);
        } else if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity == null || player.isSneaking()) {
            return false;
        }
        player.openGui(OliveCraft.instance, 0, world, x, y, z);
        return true;
    }

    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return (world.getBlockMetadata(x, y, z) & 4) == 4 ? 14 : 0;
    }

    public void breakBlock(World world, int x, int y, int z, Block i, int j) {
        dropItems(world, x, y, z);
        super.breakBlock(world, x, y, z, i, j);
    }

    private void dropItems(World world, int x, int y, int z) {
        Random rand = new Random();
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if ((tileEntity instanceof IInventory)) {
        	IInventory inventory = (IInventory) tileEntity;
        	for (int i = 0; i < inventory.getSizeInventory(); i++) {
        		ItemStack item = inventory.getStackInSlot(i);
        		if (item != null && item.stackSize > 0) {
        			float rx = rand.nextFloat() * 0.6F + 0.1F;
        			float ry = rand.nextFloat() * 0.6F + 0.1F;
        			float rz = rand.nextFloat() * 0.6F + 0.1F;
                
        			EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));
        			if (item.hasTagCompound()) {
        				entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
        			}

        			float factor = 0.05F;
        			entityItem.motionX = rand.nextGaussian() * factor;
        			entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
        			entityItem.motionZ = rand.nextGaussian() * factor;
        			world.spawnEntityInWorld(entityItem);
        			item.stackSize = 0;
            	}
        	}
        }
    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        boolean on = (meta & 4) == 4;
        boolean full = (meta & 8) == 8;
        meta = meta & 3;
        if (side == 0) {
            return blockIcon;
        } else if (side == 1) {
            return full ? topIconFull : topIcon;
        } else {
            if (side == (((meta + 1) & 3) + 2)) {
                return on ? frontIconOn : frontIcon;
            } else {
                return sideIcon;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Strings.MODID + ":fryer_bottom");
        this.sideIcon = iconRegister.registerIcon(Strings.MODID + ":fryer_side");
        this.frontIcon = iconRegister.registerIcon(Strings.MODID + ":fryer_front");
        this.frontIconOn = iconRegister.registerIcon(Strings.MODID + ":fryer_front_2");
        this.topIcon = iconRegister.registerIcon(Strings.MODID + ":fryer_top");
        this.topIconFull = iconRegister.registerIcon(Strings.MODID + ":fryer_top_2");
    }
}
