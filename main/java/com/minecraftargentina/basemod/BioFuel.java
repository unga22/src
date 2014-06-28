package com.minecraftargentina.basemod;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;




public class BioFuel extends BlockFluidClassic {

        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;
        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;
        
        public BioFuel(Fluid fluid, Material material) {
                super(fluid, material);
                setCreativeTab(BaseMod.oblivion);
        }
        
        @Override
        public IIcon getIcon(int side, int meta) {
                return (side == 0 || side == 1)? stillIcon : flowingIcon;
        }
        
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister register) {
                stillIcon = register.registerIcon("basemod:biofuelStill");
                flowingIcon = register.registerIcon("basemod:biofuelFlowing");
        }
        
        //efecto de pocion en el agua
        @Override
        public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
			  if(entity instanceof EntityLivingBase){
				  
				  if (((EntityLivingBase)entity).getActivePotionEffect(Potion.poison) == null) {
					  ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 120)); //100 = 5 Seconds , 20 = 1 Second
				  }
				  ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 120)); //100 = 5 Seconds , 20 = 1 Second
			  }	  
		  }
        
        
        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.canDisplace(world, x, y, z);
        }
        
        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {
                if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
                return super.displaceIfPossible(world, x, y, z);
        }
        
        
		@SideOnly(Side.CLIENT)
		    public void randomDisplayTick(World worldObj, int posX, int posY, int posZ, Random rand)
		    {
    if (this.blockMaterial == Material.water && worldObj.getBlock(posX, posY + 1, posZ).getMaterial() == Material.air && !worldObj.getBlock(posX, posY + 1, posZ).isOpaqueCube())
    {
  	  
			int direction = worldObj.getBlockMetadata(posX, posY, posZ);
			
			float x1 = (float)posX + rand.nextFloat();
			float y1 = (float)posY + rand.nextFloat();
			float z1 = (float)posZ + rand.nextFloat();

			float f =  rand.nextFloat();
			float f1 = rand.nextFloat();

			if(direction == 4){
				worldObj.spawnParticle("reddust", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 1.2D /*red*/, 1.2D /*green*/, 1.2D /*blue*/);
			}else if(direction == 5){
				worldObj.spawnParticle("reddust", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 1.2D /*red*/, 1.2D /*green*/, 1.2D /*blue*/);
			}else if(direction == 2){
				worldObj.spawnParticle("reddust", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 1.2D /*red*/, 1.2D /*green*/, 1.2D /*blue*/);
			}else if(direction == 3){
				worldObj.spawnParticle("reddust", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 1.2D /*red*/, 1.2D /*green*/, 1.2D /*blue*/);
			}

    }

        
}
		
}