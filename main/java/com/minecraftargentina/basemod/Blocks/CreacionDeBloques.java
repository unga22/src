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
import net.minecraft.block.BlockFire;
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
	
	public static Block blockMaderaRefinada;
	public final int blockMaderaRefinadaID = 1111;
	public static Block OblivionPortalBlock;
	
	public static Block OblivionTreelog;
	public static Block OblivionTreeLeaves;
	
	public static Block ArbolBaseBlock;
	public static Block ToconBlock;
	public static Block ToconBlock2;
	public static Block ToconBlock3;
	public static Block ToconBlock4;
	public static Block ToconBlock5;
	public static Block ToconBlock6;
	public static Block ToconBlock7;
	public static Block ToconBlock8;
	public static Block ToconBlock9;
	public static Block ToconBlock10;
	public static Block ToconBlock11;


	
	
	
	
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeBloques(){
		
		ArbolBaseBlock = new ArbolBaseBlock(Material.wood).setBlockName("ArbolBase");
		ToconBlock = new ToconBlock(Material.wood).setBlockName("ToconBlock");
		ToconBlock2 = new ToconBlock2(Material.wood).setBlockName("ToconBlock2");
		ToconBlock3 = new ToconBlock3(Material.wood).setBlockName("ToconBlock3");
		ToconBlock4 = new ToconBlock4(Material.wood).setBlockName("ToconBlock4");
		ToconBlock5 = new ToconBlock5(Material.wood).setBlockName("ToconBlock5");
		ToconBlock6 = new ToconBlock6(Material.wood).setBlockName("ToconBlock6");
		ToconBlock7 = new ToconBlock7(Material.wood).setBlockName("ToconBlock7");
		ToconBlock8 = new ToconBlock8(Material.wood).setBlockName("ToconBlock8");
		ToconBlock9 = new ToconBlock9(Material.wood).setBlockName("ToconBlock9");
		ToconBlock10 = new ToconBlock10(Material.wood).setBlockName("ToconBlock10");
		ToconBlock11 = new ToconBlock11(Material.wood).setBlockName("ToconBlock11");
		
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
		blockMaderaRefinada = new MaderaRefinada(Material.wood).setBlockName("MaderaRefinada");
		OblivionPortalBlock = new OblivionPortalBlock().setBlockName("OblivionPortal");
		OblivionTreelog = new OblivionTreeLog(Material.wood).setBlockName("obliviontreelog");
		OblivionTreeLeaves = new OblivionTreeLeaves(Material.leaves).setBlockName("obliviontreeleaves");
		//OblivionFireBlock = (BlockFire) new OblivionFireBlock(Material.cactus).setBlockName("OblivionFireBlock");
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
		GameRegistry.registerBlock(blockMaderaRefinada, "MaderaRefinada");
		GameRegistry.registerBlock(OblivionPortalBlock, "OblivionPortal");
		GameRegistry.registerBlock(OblivionTreelog, "OblivionTreelog");
		GameRegistry.registerBlock(OblivionTreeLeaves, "OblivionTreeLeaves");
		
		GameRegistry.registerBlock(ArbolBaseBlock, "ArbolBase");
		GameRegistry.registerBlock(ToconBlock, "ToconBlock");
		GameRegistry.registerBlock(ToconBlock2, "ToconBlock2");
		GameRegistry.registerBlock(ToconBlock3, "ToconBlock3");
		GameRegistry.registerBlock(ToconBlock4, "ToconBlock4");
		GameRegistry.registerBlock(ToconBlock5, "ToconBlock5");
		GameRegistry.registerBlock(ToconBlock6, "ToconBlock6");
		GameRegistry.registerBlock(ToconBlock7, "ToconBlock7");
		GameRegistry.registerBlock(ToconBlock8, "ToconBlock8");
		GameRegistry.registerBlock(ToconBlock9, "ToconBlock9");
		GameRegistry.registerBlock(ToconBlock10, "ToconBlock10");
		GameRegistry.registerBlock(ToconBlock11, "ToconBlock11");

		
		
		
		
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
}
