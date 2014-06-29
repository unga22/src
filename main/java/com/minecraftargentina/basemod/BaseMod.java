package com.minecraftargentina.basemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
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
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.oredict.OreDictionary;
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
import com.minecraftargentina.basemod.Blocks.BlockNCStem;
import com.minecraftargentina.basemod.Blocks.BloodMelon;
import com.minecraftargentina.basemod.Blocks.CopperBlock;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Blocks.MineralBlocks;
import com.minecraftargentina.basemod.Blocks.NCCrop;
import com.minecraftargentina.basemod.Blocks.ObsidianBlock;
import com.minecraftargentina.basemod.Blocks.OreBlock;
import com.minecraftargentina.basemod.Blocks.PurpleLamp;
import com.minecraftargentina.basemod.Cubos.BioFuelBucket;
import com.minecraftargentina.basemod.Cubos.BucketHandler;
import com.minecraftargentina.basemod.Fluidos.BioFuel;
import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;
import com.minecraftargentina.basemod.Herramientas.TopazArmor;
import com.minecraftargentina.basemod.Herramientas.TopazAxe;
import com.minecraftargentina.basemod.Herramientas.TopazHoe;
import com.minecraftargentina.basemod.Herramientas.TopazPickaxe;
import com.minecraftargentina.basemod.Herramientas.TopazShovel;
import com.minecraftargentina.basemod.Herramientas.TopazSword;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Items.ItemBlueberrySeeds;
import com.minecraftargentina.basemod.Items.ItemsGenericos;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.AlabasterOven;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.TileEntityAlabasterOven;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.FuelMachine;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.TileEntityFuelMachine;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.IngotMasher;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.TileEntityIngotMasher;
import com.minecraftargentina.basemod.Maquinas.WorckSurface.WorkSurface;
import com.minecraftargentina.basemod.Recipes.CreacionDeRecetasDelHorno;
import com.minecraftargentina.basemod.Recipes.CreacionDeRecetasMesaDeCrafteo;
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

	NealecraftWorldGen eventWorldGen = new NealecraftWorldGen();

	public static CreativeTabs oblivion;

	public static ToolMaterial TopazMaterial = EnumHelper.addToolMaterial("TopazMaterial", 2, 750, 6.0F, 2.0F, 10);
	public static ArmorMaterial TopazArmorMaterial = EnumHelper.addArmorMaterial("TopazArmorMaterial", 24, new int[] {3, 7, 5, 3}, 10);
	
	public static Achievement achievementOblivion;
	public static Achievement achievementCopperPick;
	
	@Instance(modid)
	public static BaseMod instance;
	

	@SidedProxy(clientSide = "com.minecraftargentina.basemod.lib.ClientProxy", serverSide = "com.minecraftargentina.basemod.lib.CommonProxy")
	public static ClientProxy nealeProxy;
	public static Item Frutilla;
	
	
	 // ItemBlueBerrySeeds
	 public final static Block blockBlueberry = new blueberrycrop();
	 public final static Item blueberryseeds = new ItemBlueberrySeeds();


	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){

		oblivion = new CreativeTabs("Oblivion") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(CreacionDeBloques.oreCopperOre);		
				
			}
		};
		CreacionDeItems.CreaciondeItems();
		CreacionDeItems.RegistraciondeItems();
		CreacionDeBloques.CreaciondeBloques();
		CreacionDeBloques.RegistraciondeBloques();
		CreacionDeFluidos.CreaciondeFluidos();
		CreacionDeMaquinas.CreaciondeMaquinas();
		CreacionDeMaquinas.RegistraaciondeMaquinas();
		//Machines
		
	
		

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CreacionDeItems.armorTopazChest),1,1,065));

		MinecraftForge.addGrassSeed(new ItemStack(CreacionDeItems.cropStrawberrySeeds), 10);
		MinecraftForge.addGrassSeed(new ItemStack(CreacionDeItems.cropBloodMelonSeeds), 10);


		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);

		nealeProxy.registerRenderThings();

	}

	@EventHandler
	public void Init(FMLInitializationEvent event){

		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//cubos
		BucketHandler.INSTANCE.buckets.put(CreacionDeFluidos.fluidblock, CreacionDeItems.BioFuelBucketItem);
		
		GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
		GameRegistry.registerTileEntity(TileEntityIngotMasher.class, "IngotMasher");
		GameRegistry.registerTileEntity(TileEntityFuelMachine.class, "FuelMashine");
		
		achievementOblivion = new Achievement("archievement.mineOblivion", "mineOblivion", 0, 0, new ItemStack(CreacionDeItems.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, CreacionDeBloques.oreCopperOre, achievementOblivion).registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick}));
		FMLCommonHandler.instance().bus().register(new CopperOnPickEvent());
		FMLCommonHandler.instance().bus().register(new CopperOnCraftEvent());
		//Archievement Language (Nombres y Descripcion)
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion", "en_US", "Oblivion");
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion.desc", "en_US", "¿ Acaso empiezas a recordar algo?");
		
		
		

		CreacionDeRecetasMesaDeCrafteo.RecetasMesaDeCrafteo();
		CreacionDeRecetasDelHorno.RecetasDelHorno();
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		EntityHandler.registerMonsters(EntityCyclops.class, "Cyclops");
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
	}
 }

