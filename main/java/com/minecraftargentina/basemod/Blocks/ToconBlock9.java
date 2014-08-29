package com.minecraftargentina.basemod.Blocks;



import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon4;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon5;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon6;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon7;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon8;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon9;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ToconBlock9 extends BlockContainer {




	protected ToconBlock9(Material material) {
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		
		//this.setBlockBounds(ANCHO, ALTO, LARGO, ANCHO, ALTO, LARGO);
	    this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setCreativeTab(BaseMod.oblivion);
	}
	
	public int getRenderType(){
		return -11;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}


	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {		
		return new TileEntityArbolTocon9();	
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName());
		this.blockIcon = Blocks.deadbush.getBlockTextureFromSide(0);
	}
	
}