package com.minecraftargentina.basemod.Cubos;

import net.minecraft.item.Item;

import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeCubos {
	public static Item BioFuelBucketItem;
	public static void CreaciondeCubos(){
		BioFuelBucketItem = new BioFuelBucket(CreacionDeFluidos.fluidblock).setUnlocalizedName("BioFuelBucket").setTextureName("basemod:BioFuelBucket");
		BucketHandler.INSTANCE.buckets.put(CreacionDeFluidos.fluidblock, BioFuelBucketItem);
	}
	public static void RegistraciondeCubos(){
		GameRegistry.registerItem(BioFuelBucketItem, "BiofuelBucket");
	}
}
