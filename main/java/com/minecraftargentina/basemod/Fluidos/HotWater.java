package com.minecraftargentina.basemod.Fluidos;

import java.io.IOException;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Pociones.CreacionDePociones;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HotWater extends BlockFluidClassic{
	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowingIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;

	public HotWater(Fluid fluido, Material material) {
		super(fluido, material);
		this.setCreativeTab(BaseMod.oblivion);

	}
	  @Override
      public IIcon getIcon(int side, int meta) {
              return (side == 0 || side == 1)? stillIcon : flowingIcon;
      }

	  @SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister iconRegister){
		  this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":" + "hotWater");
			this.flowingIcon = iconRegister.registerIcon(BaseMod.modid + ":" + "flowHotWater");
			this.stillIcon = iconRegister.registerIcon(BaseMod.modid + ":" + "stillHotWater");



		}
	  public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		  if(entity instanceof EntityLivingBase){
			  ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(CreacionDePociones.PocionWaterHot.id, 1, 0)); //100 = 5 Seconds , 20 = 1 Second
		  }	  
	  }

	  @SideOnly(Side.CLIENT)
	  public void randomDisplayTick(World worldObj, int posX, int posY, int posZ, Random rand){
      if (this.blockMaterial == Material.water && worldObj.getBlock(posX, posY + 1, posZ).getMaterial() == Material.air && !worldObj.getBlock(posX, posY + 1, posZ).isOpaqueCube()){	  
			int direction = worldObj.getBlockMetadata(posX, posY, posZ);
  			
			float x1 = (float)posX + rand.nextFloat();
			float y1 = (float)posY + rand.nextFloat();
			float z1 = (float)posZ + rand.nextFloat();

			float f =  rand.nextFloat();
			float f1 = rand.nextFloat();

			if(direction == 4){
				worldObj.spawnParticle("reddust", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 1.0D /*red*/, 1.2D /*green*/, 1.6D /*blue*/);
			}else if(direction == 5){
				worldObj.spawnParticle("reddust", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 1.0D /*red*/, 1.2D /*green*/, 1.6D /*blue*/);
			}else if(direction == 2){
				worldObj.spawnParticle("reddust", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 1.0D /*red*/, 1.2D /*green*/, 1.6D /*blue*/);
			}else if(direction == 3){
				worldObj.spawnParticle("reddust", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 1.0D /*red*/, 1.2D /*green*/, 1.6D /*blue*/);
			}

      }

      

}
}
