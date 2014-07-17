package com.minecraftargentina.basemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.oredict.OreDictionary;
import OblivionDimension.BiomeGenTutorial;
import Prueba.olivecraft.OliveGen;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.minecraftargentina.basemod.Achievement.CopperOnCraftEvent;
import com.minecraftargentina.basemod.Achievement.CopperOnPickEvent;
import com.minecraftargentina.basemod.Achievement.CreacionDeAchievement;
import com.minecraftargentina.basemod.Armaduras.TopazArmor;
import com.minecraftargentina.basemod.Biomes.OblivionLeaf;
import com.minecraftargentina.basemod.Biomes.OblivionLog;
import com.minecraftargentina.basemod.Biomes.OblivionSapling;
import com.minecraftargentina.basemod.Biomes.WorldGenOlvidoTree;
import com.minecraftargentina.basemod.Blocks.BlockNCStem;
import com.minecraftargentina.basemod.Blocks.BloodMelon;
import com.minecraftargentina.basemod.Blocks.CopperBlock;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Blocks.MineralBlocks;
import com.minecraftargentina.basemod.Blocks.ObsidianBlock;
import com.minecraftargentina.basemod.Blocks.OreBlock;
import com.minecraftargentina.basemod.Blocks.PurpleLamp;
import com.minecraftargentina.basemod.Cubos.BucketGenericos;
import com.minecraftargentina.basemod.Cubos.BucketHandler;
import com.minecraftargentina.basemod.Cubos.CreacionDeCubos;
import com.minecraftargentina.basemod.Fluidos.BioFuel;
import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;
import com.minecraftargentina.basemod.Herramientas.TopazAxe;
import com.minecraftargentina.basemod.Herramientas.TopazHoe;
import com.minecraftargentina.basemod.Herramientas.TopazPickaxe;
import com.minecraftargentina.basemod.Herramientas.TopazShovel;
import com.minecraftargentina.basemod.Herramientas.TopazSword;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Items.ItemLeafBlocks;
import com.minecraftargentina.basemod.Items.ItemLogBlocks;
import com.minecraftargentina.basemod.Items.ItemSaplingBlocks;
import com.minecraftargentina.basemod.Items.ItemsGenericos;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.AlabasterOven;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.TileEntityAlabasterOven;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.FuelMachine;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.TileEntityFuelMachine;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.IngotMasher;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.TileEntityIngotMasher;
import com.minecraftargentina.basemod.Maquinas.WorckSurface.WorkSurface;
import com.minecraftargentina.basemod.Pociones.CreacionDePociones;
import com.minecraftargentina.basemod.Recipes.CreacionDeRecetasDelHorno;
import com.minecraftargentina.basemod.Recipes.CreacionDeRecetasMesaDeCrafteo;
import com.minecraftargentina.basemod.Semillas.CreacionDeSemillas;
import com.minecraftargentina.basemod.Semillas.StrawberryCrop;
import com.minecraftargentina.basemod.lib.ClientProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = BaseMod.modid, version = BaseMod.version)
public class BaseMod {

	public static final String modid = "basemod";
	public static final String version = "Alpha v0.1";
	public static int DimID = 32;

	NealecraftWorldGen eventWorldGen = new NealecraftWorldGen();
	

	
	//public static final BiomeGenBase BiomeGenTutorial = new BiomeGenTutorial(DimID);
	public static final BiomeGenBase BiomeGenTutorial = new BiomeGenTutorial(DimID).setBiomeName("OblivionBiome");
	public static CreativeTabs oblivion;
	
	

	
	

	public static ToolMaterial TopazMaterial = EnumHelper.addToolMaterial("TopazMaterial", 2, 750, 6.0F, 2.0F, 10);
	public static ArmorMaterial TopazArmorMaterial = EnumHelper.addArmorMaterial("TopazArmorMaterial", 24, new int[] {3, 7, 5, 3}, 10);
	
	@Instance(modid)
	public static BaseMod instance;
	

	@SidedProxy(clientSide = "com.minecraftargentina.basemod.lib.ClientProxy", serverSide = "com.minecraftargentina.basemod.lib.CommonProxy")
	public static ClientProxy nealeProxy;
	public static Item Frutilla;
	


	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		//Pasar CreativeTap
			oblivion = new CreativeTabs("Oblivion") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(CreacionDeBloques.oreCopperOre);		
				
			}
		};
		//Falta pasat todo esto
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CreacionDeItems.armorTopazChest),1,1,065));
		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		
		
		
		
		nealeProxy.registerRenderThings();

	}

	@EventHandler
	public void Init(FMLInitializationEvent event){
		CreacionDeItems.CreaciondeItems();
		CreacionDeItems.RegistraciondeItems();
		CreacionDeBloques.CreaciondeBloques();
		CreacionDeBloques.RegistraciondeBloques();
		CreacionDeFluidos.CreaciondeFluidos();
		CreacionDeMaquinas.CreaciondeMaquinas();
		CreacionDeMaquinas.RegistraaciondeMaquinas();
		CreacionDePociones.RegistraciondePociones();
		CreacionDePociones.CreaciondePociones();
		CreacionDePociones.RegistrarEventosdePociones();
		CreacionDeAchievement.CreaciondeAchievement();
		CreacionDeAchievement.RegistracionAchievement();
		CreacionDeAchievement.RegistracionDeEventos();
		CreacionDeSemillas.CreaciondeSemillas();
		CreacionDeSemillas.RegistraciondeSemillas();
		CreacionDeCubos.CreaciondeCubos();
		CreacionDeCubos.RegistraciondeCubos();
		CreacionDeRecetasMesaDeCrafteo.RecetasMesaDeCrafteo();
		CreacionDeRecetasDelHorno.RecetasDelHorno();
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//Falta pasar todo esto
		GameRegistry.registerFuelHandler(new FuelHandler());
		EntityHandler.registerMonsters(EntityCyclops.class, "Cyclops");
		
		GameRegistry.registerWorldGenerator(new WorldGenOlvidoTree(null, null, 0, 0), 32);
		

		
		DimensionManager.registerProviderType(BaseMod.DimID, OblivionDimension.WorldProviderOblivion.class, false);
		DimensionManager.registerDimension(BaseMod.DimID, BaseMod.DimID);
		
		
		BiomeManager.addSpawnBiome(BiomeGenTutorial);		
		


	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){		
		
	}
 }

