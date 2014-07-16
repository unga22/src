package Prueba.olivecraft;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBarrel extends BlockContainer {
	
	public BlockBarrel(Material par2Material) {
        super(par2Material);
        setHardness(2.0F);
        setStepSound(soundTypeWood);
        setBlockName("barrel");
        setCreativeTab(OliveCraft.oliveTab);
	}
	
	public TileEntity createNewTileEntity(World par1World, int var2) {
		return new TileEntityBarrel();
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!player.isSneaking()) {
			if (((TileEntityBarrel) world.getTileEntity(x, y, z)).onActivated(player.getHeldItem())) {
				if (!player.capabilities.isCreativeMode) {
					if (player.getHeldItem().getItem() == Items.potionitem) {
						player.getHeldItem().func_150996_a(Items.glass_bottle);
					} else {
						player.getHeldItem().stackSize--;
					}
				}
				return true;
			} else {
				return false;
			}
		} else {
			((TileEntityBarrel) world.getTileEntity(x, y, z)).emptyFull();
			return true;
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block i, int j) {
        ((TileEntityBarrel) world.getTileEntity(x, y, z)).emptyFull();
        super.breakBlock(world, x, y, z, i, j);
    }
	
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity) {
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 0.125F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0F, 0F, 0.875F, 1F, 1F, 1F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0F, 0F, 0.125F, 0.125F, 1F, 0.875F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.875F, 0F, 0.125F, 1F, 1F, 0.875F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		this.setBlockBounds(0.125F, 0F, 0.125F, 0.875F, 0.25F, 0.875F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
	}
	
	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}
	
	 @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister iconRegister) {
		 this.blockIcon = Blocks.log.getIcon(2, 0);
	 }

}

