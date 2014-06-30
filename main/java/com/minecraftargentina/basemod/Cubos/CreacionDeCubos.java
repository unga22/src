package com.minecraftargentina.basemod.Cubos;

import net.minecraft.item.Item;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.DrugMod;
import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CreacionDeCubos {
	public static Item BioFuelBucketItem;
	public static Item HotWaterBueketItem;
	public static void CreaciondeCubos(){
		BioFuelBucketItem = new BucketGenericos(CreacionDeFluidos.BiofuelBlock).setUnlocalizedName("BioFuelBucket").setTextureName("basemod:BioFuelBucket");
		BucketHandler.INSTANCE.buckets.put(CreacionDeFluidos.BiofuelBlock, BioFuelBucketItem);
		
		HotWaterBueketItem = new BucketGenericos(CreacionDeFluidos.HotWaterBlock).setUnlocalizedName("HotWaterBucket").setTextureName(BaseMod.modid + ":HotWaterBucket");
		BucketHandler.INSTANCE.buckets.put(CreacionDeFluidos.HotWaterBlock, HotWaterBueketItem);
	}
	public static void RegistraciondeCubos(){
		GameRegistry.registerItem(BioFuelBucketItem, "BiofuelBucket");
		GameRegistry.registerItem(HotWaterBueketItem, "HotWaterBucket");
	}
}
