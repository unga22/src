package com.minecraftargentina.basemod;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.fluids.Fluid;

public class Definer {

	public static void addFluidDefinitions(){
		DrugMod m = new DrugMod();

    	m.HotWaterFluid = new Fluid("hotwater").setTemperature(373).setViscosity(1200);

	}

	public static void addBlockDefinitions(){
		DrugMod m = new DrugMod();

    	m.CocaCrop = new DmCocaCrop().setBlockName("cocaCrop");
    	m.HotWaterBlock = new DmHotWater().setBlockName("hotWater");
    	m.ChemicalExtractorIdle = new DmChemicalExtractor(false).setBlockName("extractorChemicalIdle").setHardness(3.5F).setCreativeTab(DrugMod.drugTab); 
		m.ChemicalExtractorActive = new DmChemicalExtractor(true).setBlockName("extractorChemicalActive").setHardness(3.5F).setLightLevel(0.9F);

	}

	public static void addItemDefinitions(){
		DrugMod m = new DrugMod();

    	m.CocaSeeds = new ItemSeeds(m.CocaCrop, Blocks.farmland).setTextureName(DrugMod.modid + ":" + "seedCoca").setUnlocalizedName("seedCoca").setCreativeTab(DrugMod.drugTab);
    	m.CocaLeaf = new DmCocaLeaf("leafCoca");
    	m.HotWaterBucket = new DmHotWaterBucket(m.HotWaterBlock).setTextureName(DrugMod.modid + ":" + "bucketHotWater");
    	
	}

	public static void addPotionDefinitions(){
		DrugMod m = new DrugMod();

    	m.waterHot = (new PotionDrugMod(32, true, 0)).setIconIndex(1,1).setPotionName("potion.waterHot");

	}
}