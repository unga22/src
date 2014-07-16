package com.minecraftargentina.basemod.Blocks;

import java.util.ArrayList;
import java.util.Random;




import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OblivionTreeLeaves extends Block implements IShearable {
    private IIcon fullIcon, halfIcon;


    public OblivionTreeLeaves(Material par2Material) {
        super(par2Material);
        setHardness(0.2F);
        setStepSound(soundTypeGrass);
        setBlockName("obliviontreeLeaves");
        setLightOpacity(1);
        setCreativeTab(BaseMod.oblivion);
        setTickRandomly(true);
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta != 0) {
        	if (canBlockStay(world, x, y, z)) {
        		if (meta < 11) {
            		meta++;
            		world.setBlockMetadataWithNotify(x, y, z, meta, 2);
            	} else {
            		world.setBlockMetadataWithNotify(x, y, z, 11, 2);
            	}
        	} else {
        		world.setBlockToAir(x, y, z);
        	}
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z) {
        return (world.getBlock(x - 1, y, z) == CreacionDeBloques.OblivionTreelog || world.getBlock(x + 1, y, z) == CreacionDeBloques.OblivionTreelog || world.getBlock(x, y, z - 1) == CreacionDeBloques.OblivionTreelog || world.getBlock(x, y, z + 1) == CreacionDeBloques.OblivionTreelog || world.getBlock(x, y - 1, z) == CreacionDeBloques.OblivionTreelog) && !(world.getBlockMetadata(x, y, z) == 0);
    }

    public int quantityDropped(int meta, int fortune, Random random) {
        return 0;
    }
    
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
        return true;
    }
    
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this));
        return ret;
    }
    
	public String getUnlocalizedName() {
		return BaseMod.modid.toLowerCase() + "." + super.getUnlocalizedName();
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return meta >= 6 ? meta >= 11 ? fullIcon : halfIcon : blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":oblivionleaves_empty");
        this.halfIcon = iconRegister.registerIcon(BaseMod.modid + ":oblivionleaves_half");
        this.fullIcon = iconRegister.registerIcon(BaseMod.modid + ":oblivionleaves_full");
    }
    
    /*/Debug
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
    	this.updateTick(world, x, y, z, new Random());
    	return true;
    }//*/
    
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side){
		return true;
	}
}

