package com.minecraftargentina.basemod.Blocks;



import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;


public class MaderaRefinada extends Block {

	public MaderaRefinada(Material material) {
		super(material);

		this.setStepSound(soundTypeWood);
		this.setHardness(1.0F);
		this.setResistance(2.0F);
		this.setCreativeTab(BaseMod.oblivion);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}