package com.minecraftargentina.basemod.Blocks;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Biomes.OblivionLeaf;
import com.minecraftargentina.basemod.Biomes.OblivionLog;
import com.minecraftargentina.basemod.Biomes.OblivionSapling;
import com.minecraftargentina.basemod.Items.ItemLeafBlocks;
import com.minecraftargentina.basemod.Items.ItemLogBlocks;
import com.minecraftargentina.basemod.Items.ItemSaplingBlocks;
import com.minecraftargentina.basemod.Semillas.StrawberryCrop;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CreacionDeBloques {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreZincOre;
	public static Block oreNickelOre;
	public static Block oreManganeseOre;
	public static Block oreVanadiumOre;
	public static Block oreTopazOre;

	public static Block oreNetherCopperOre;
	public static Block oreNetherTinOre;
	public static Block oreNetherZincOre;
	public static Block oreNetherNickelOre;
	public static Block oreNetherManganeseOre;
	public static Block oreNetherVanadiumOre;
	public static Block oreNetherTopazOre;

	public static Block blockCopperBlock;
	public static Block blockMinerals;
	public static Block blockObsidianTable;

	public static Block blockPurpleLampOn;
	public static Block blockPurpleLampOff;


	public static Block cropStrawberryPlant;

	public static Block cropBloodMelonStem;
	public static Block cropBloodMelon;
	
	public static Block blockLog;
	public static Block blockLeaf;
	public static Block blockSapling;
	
	
	
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeBloques(){
		cropStrawberryPlant = new StrawberryCrop().setBlockName("StrawberryPlant");

		cropBloodMelon = new BloodMelon().setBlockName("BloodMelon").setBlockTextureName(BaseMod.modid + ":BloodMelon");
		cropBloodMelonStem = new BlockNCStem(cropBloodMelon).setBlockName("BloodMelonStem").setBlockTextureName(BaseMod.modid + ":BloodMelon");
		oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
		oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
		oreZincOre = new OreBlock(Material.rock).setBlockName("ZincOre");
		oreNickelOre = new OreBlock(Material.rock).setBlockName("NickelOre");
		oreManganeseOre = new OreBlock(Material.rock).setBlockName("ManganeseOre");
		oreVanadiumOre = new OreBlock(Material.rock).setBlockName("VanadiumOre");
		oreTopazOre = new OreBlock(Material.rock).setBlockName("TopazOre");

		oreNetherCopperOre = new OreBlock(Material.rock).setBlockName("NetherCopperOre");
		oreNetherTinOre = new OreBlock(Material.rock).setBlockName("NetherTinOre");
		oreNetherZincOre = new OreBlock(Material.rock).setBlockName("NetherZincOre");
		oreNetherNickelOre = new OreBlock(Material.rock).setBlockName("NetherNickelOre");
		oreNetherManganeseOre = new OreBlock(Material.rock).setBlockName("NetherManganeseOre");
		oreNetherVanadiumOre = new OreBlock(Material.rock).setBlockName("NetherVanadiumOre");
		oreNetherTopazOre = new OreBlock(Material.rock).setBlockName("NetherTopazOre");
		blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
		blockMinerals = new MineralBlocks().setBlockName("Minerals");
		blockObsidianTable = new ObsidianBlock(Material.rock).setBlockName("ObsidianTable");
		blockPurpleLampOn = new PurpleLamp(true).setBlockName("PurpleLampOn");
		blockPurpleLampOff = new PurpleLamp(false).setBlockName("PurpleLampOff").setCreativeTab(BaseMod.oblivion);
		blockLog = new OblivionLog().setBlockName("Log").setCreativeTab(BaseMod.oblivion);
		blockLeaf = new OblivionLeaf().setBlockName("Leaf").setCreativeTab(BaseMod.oblivion);
		blockSapling = new OblivionSapling().setBlockName("Sapling").setCreativeTab(BaseMod.oblivion);
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistraciondeBloques(){
		GameRegistry.registerBlock(cropStrawberryPlant, "StrawberryPlant");
		GameRegistry.registerBlock(cropBloodMelon, "BloodMelon");
		GameRegistry.registerBlock(cropBloodMelonStem, "BloodMelonStem");
		GameRegistry.registerBlock(oreCopperOre, "CopperOre");
		GameRegistry.registerBlock(oreTinOre, "TinOre");
		GameRegistry.registerBlock(oreZincOre, "ZincOre");
		GameRegistry.registerBlock(oreNickelOre, "NickelOre");
		GameRegistry.registerBlock(oreManganeseOre, "ManganeseOre");
		GameRegistry.registerBlock(oreVanadiumOre, "VanadiumOre");
		GameRegistry.registerBlock(oreTopazOre, "TopazOre");

		GameRegistry.registerBlock(oreNetherCopperOre, "NetherCopperOre");
		GameRegistry.registerBlock(oreNetherTinOre, "NetherTinOre");
		GameRegistry.registerBlock(oreNetherZincOre, "NetherZincOre");
		GameRegistry.registerBlock(oreNetherNickelOre, "NetherNickelOre");
		GameRegistry.registerBlock(oreNetherManganeseOre, "NetherManganeseOre");
		GameRegistry.registerBlock(oreNetherVanadiumOre, "NetherVanadiumOre");
		GameRegistry.registerBlock(oreNetherTopazOre, "NetherTopazOre");
		GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
		GameRegistry.registerBlock(blockPurpleLampOn, "PurpleLampOn");
		GameRegistry.registerBlock(blockPurpleLampOff, "PurpleLampOff");
		GameRegistry.registerBlock(blockObsidianTable, "ObsidianTable");
		GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockLeaf, ItemLeafBlocks.class, blockLeaf.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName().substring(5));
		
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
}
