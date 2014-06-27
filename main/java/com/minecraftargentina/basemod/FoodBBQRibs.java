package com.minecraftargentina.basemod;

import net.minecraft.item.ItemFood;


public class FoodBBQRibs extends ItemFood {

	public FoodBBQRibs(int heal, float saturation, boolean wolfmeat) {
		super(heal, saturation, wolfmeat);

		this.setPotionEffect(8, 60, 1, 1F);
		this.setPotionEffect(10, 60, 1, 1F);
		this.setTextureName(BaseMod.modid + ":BBQRibs");
		this.setCreativeTab(BaseMod.oblivion);
	}

}