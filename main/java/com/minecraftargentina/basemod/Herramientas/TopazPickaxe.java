package com.minecraftargentina.basemod.Herramientas;



import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;


public class TopazPickaxe extends ItemPickaxe {

	public TopazPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(BaseMod.oblivion);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}


}