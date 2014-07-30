package com.minecraftargentina.basemod.Blocks;

import Models.TileEntityArbolTocon;

import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ToconBlock extends BlockContainer {




	protected ToconBlock(Material material) {
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
	    this.setBlockBounds(0.30F, -0.25F, 0.25F, 0.75F, 1F, 0.60F);
		this.setCreativeTab(BaseMod.oblivion);
	}
	
	public int getRenderType(){
		return -3;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}


	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {		
		return new TileEntityArbolTocon();	
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName());
		
	}
	
}