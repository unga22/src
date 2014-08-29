package com.minecraftargentina.basemod.Semillas;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Items.ItemsGenericos;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class CreacionDeSemillas {
	//-----------------------------------------------------------------------------------------------------------------------
	//
    public static Item CocaSeeds;
    public static Block CocaCrop;
    
    public static Item CocaLeaf;
    
	public static Item cropStrawberrySeeds;
	
	public static Item cropBloodMelonSeeds;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
    public static void CreaciondeSemillas(){
    	CocaCrop = new CocaCrop().setBlockName("cocaCrop");
    	CocaSeeds = new ItemSeeds(CocaCrop, Blocks.farmland).setTextureName(BaseMod.modid + ":" + "seedCoca").setUnlocalizedName("seedCoca").setCreativeTab(BaseMod.oblivion);
    	
    	CocaLeaf = new ItemsGenericos().setUnlocalizedName("leafCoca");
    	
    	cropBloodMelonSeeds = new ItemSeeds(CreacionDeBloques.cropBloodMelonStem, Blocks.farmland).setUnlocalizedName("BloodMelonSeeds").setTextureName(BaseMod.modid + ":BloodMelonSeeds").setCreativeTab(BaseMod.oblivion);
    	
    	cropStrawberrySeeds = new ItemSeeds(CreacionDeBloques.cropStrawberryPlant, Blocks.farmland).setUnlocalizedName("StrawberrySeeds").setTextureName(BaseMod.modid + ":StrawberrySeeds").setCreativeTab(BaseMod.oblivion);
    }
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
    public static void RegistraciondeSemillas(){
    	MinecraftForge.addGrassSeed(new ItemStack(CocaSeeds), 10);
    	GameRegistry.registerBlock(CocaCrop, "CocaCrop");
    	GameRegistry.registerItem(CocaSeeds , "CocaSeeds");
    	
    	GameRegistry.registerItem(CocaLeaf , "CocaLeaf");
    	
		GameRegistry.registerItem(cropStrawberrySeeds, "StrawberrySeeds");
		MinecraftForge.addGrassSeed(new ItemStack(cropStrawberrySeeds), 10);
		
		GameRegistry.registerItem(cropBloodMelonSeeds, "BloodMelonSeeds");
		MinecraftForge.addGrassSeed(new ItemStack(cropBloodMelonSeeds), 10);
    }
	//
	//-----------------------------------------------------------------------------------------------------------------------
    
}
