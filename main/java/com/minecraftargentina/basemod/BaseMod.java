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

import com.minecraftargentina.basemod.AlabasterOven.AlabasterOven;
import com.minecraftargentina.basemod.AlabasterOven.TileEntityAlabasterOven;
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
import com.minecraftargentina.basemod.FuelMachine.FuelMachine;
import com.minecraftargentina.basemod.FuelMachine.TileEntityFuelMachine;
import com.minecraftargentina.basemod.Herramientas.TopazArmor;
import com.minecraftargentina.basemod.Herramientas.TopazAxe;
import com.minecraftargentina.basemod.Herramientas.TopazHoe;
import com.minecraftargentina.basemod.Herramientas.TopazPickaxe;
import com.minecraftargentina.basemod.Herramientas.TopazShovel;
import com.minecraftargentina.basemod.Herramientas.TopazSword;
import com.minecraftargentina.basemod.IngotMasher.IngotMasher;
import com.minecraftargentina.basemod.IngotMasher.TileEntityIngotMasher;
import com.minecraftargentina.basemod.Items.CreaciondeItems;
import com.minecraftargentina.basemod.Items.ItemBlueberrySeeds;
import com.minecraftargentina.basemod.Items.ItemsGenericos;
import com.minecraftargentina.basemod.WorckSurface.WorkSurface;
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
	//Cubos


	//FLuidsOLD
	
	//Bio Fuel
	
	public static Block fluidblock;
	public static Fluid BioFuel = new Fluid("BioFuel");
	
	//BioFuelTank
	
	public static Block blockFuelMachineIdle;
	public static Block blockFuelMachineActive;
	public static final int guiIDFuelMachine = 3;
	


	
	

	public static MaterialLiquid materialSludge;

	//Machines
	public static Block blockAlabasterOvenIdle;
	public static Block blockAlabasterOvenActive;
	public static final int guiIDAlabasterOven = 0;

	public static Block blockIngotMasherIdle;
	public static Block blockIngotMasherActive;
	public static final int guiIDIngotMasher = 1;

	public static Block blockWorkSurface;
	public static final int guiIDWorkSurface = 1;

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
		
		
		//BioFuelRegistry
		
		FluidRegistry.registerFluid(BioFuel);
		fluidblock = new BioFuel(BioFuel, Material.water).setBlockName("BioFuel");
		GameRegistry.registerBlock(fluidblock, "BioFuel");
		BioFuel.setUnlocalizedName(fluidblock.getUnlocalizedName());
		
		CreaciondeItems.CreacionDeItems();
		CreaciondeItems.RegistracionDeItems();
		CreacionDeBloques.CreacionDeBloqes();
		CreacionDeBloques.RegistracionDeBloques();
		//Initializations
	

		//Items
		

		//Item Parts

		//Custom Fuel and Tree Drop
		
		//5x5 Item
		

		//Gems
		

		//Food
		

		//Crops

		

		//Tools and Weapons

		//Armor
		

		//Ores
		

		//Blocks

		//Lamps

		//Fluids
		materialSludge = new MaterialLiquid(MapColor.greenColor);

		//Cubos

		//Machines
		
		
		blockFuelMachineIdle = new FuelMachine(false).setBlockName("FuelMachineEmpty").setCreativeTab(oblivion).setHardness(3.5F);
		blockFuelMachineActive = new FuelMachine(true).setBlockName("FuelMachineFull").setCreativeTab(oblivion).setHardness(3.5F);
		
		blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(oblivion).setHardness(3.5F);
		blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F).setHardness(3.5F);

		blockIngotMasherIdle = new IngotMasher(false).setBlockName("IngotMasherIdle").setCreativeTab(oblivion).setHardness(3.5F);
		blockIngotMasherActive = new IngotMasher(true).setBlockName("IngotMasherActive").setHardness(3.5F);

		//Crafting Tables
		blockWorkSurface = new WorkSurface().setBlockName("WorkSurface");

		//Registers
		//Items		


		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(CreaciondeItems.armorTopazChest),1,1,065));

		MinecraftForge.addGrassSeed(new ItemStack(CreaciondeItems.cropStrawberrySeeds), 10);
		MinecraftForge.addGrassSeed(new ItemStack(CreaciondeItems.cropBloodMelonSeeds), 10);
		//Armor
		//Ores

		//Blocks
		//GameRegistry.registerBlock(blockMinerals, ItemMineralBlocks.class, blockMinerals.getUnlocalizedName().substring(5));

		//Lamps

		//Fluids

		
		//FluidRegistry.registerFluid(BioFuel);
		
		
		//Cubos

		
		//FluidRegistry.registerFluid(fluidSludgeStill);
		//FluidRegistry.registerFluid(fluidSludge);

		//Machines
		GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
		GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
		
		GameRegistry.registerBlock(blockFuelMachineIdle, "FuelMachineIdle");
		GameRegistry.registerBlock(blockFuelMachineActive, "FuelMachineActive");

		GameRegistry.registerBlock(blockIngotMasherIdle, "IngotMasherIdle");
		GameRegistry.registerBlock(blockIngotMasherActive, "IngotMasherActive");

		GameRegistry.registerBlock(blockWorkSurface, "WorkSurface");

		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);

		//Renderers
		nealeProxy.registerRenderThings();

	}

	@EventHandler
	public void Init(FMLInitializationEvent event){

		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		//cubos
		BucketHandler.INSTANCE.buckets.put(fluidblock, CreaciondeItems.BioFuelBucketItem);
		
		GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
		GameRegistry.registerTileEntity(TileEntityIngotMasher.class, "IngotMasher");
		GameRegistry.registerTileEntity(TileEntityFuelMachine.class, "FuelMashine");
		
		achievementOblivion = new Achievement("archievement.mineOblivion", "mineOblivion", 0, 0, new ItemStack(CreaciondeItems.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, CreacionDeBloques.oreCopperOre, achievementOblivion).registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick}));
		FMLCommonHandler.instance().bus().register(new CopperOnPickEvent());
		FMLCommonHandler.instance().bus().register(new CopperOnCraftEvent());
		
		
		//Archievement Language (Nombres y Descripcion)
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion", "en_US", "Oblivion");
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion.desc", "en_US", "¿ Acaso empiezas a recordar algo?");
		
		
		

		//Recipes
		//RecipeRemover.removeCraftingRecipe();
		//RecipeRemover.removeFurnaceRecipe();

		GameRegistry.addRecipe(new ItemStack(CreacionDeBloques.blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', CreaciondeItems.itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.itemTinCog, 4), new Object[]{" X ", "XFX", " X ", 'X', CreaciondeItems.itemTinIngot, 'F', Items.flint});
		GameRegistry.addRecipe(new ItemStack(Items.book), new Object[]{"XXX", "YYY", "XXX", 'X', Items.leather, 'Y', Items.paper});
		GameRegistry.addRecipe(new ItemStack(Blocks.furnace), new Object[]{"XXX", "X X", "XXX", 'X', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 2), new Object[]{"X", "X", "X", 'X', Blocks.planks});

		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.armorTopazHelm), new Object[]{"XXX", "X X", 'X', CreaciondeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.armorTopazChest), new Object[]{"X X", "XXX", "XXX", 'X', CreaciondeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.armorTopazLegs), new Object[]{"XXX", "X X", "X X", 'X', CreaciondeItems.itemTopaz});
		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.armorTopazBoots), new Object[]{"X X", "X X", 'X', CreaciondeItems.itemTopaz});

		GameRegistry.addRecipe(new ItemStack(CreacionDeBloques.blockPurpleLampOff), new Object[]{"CXC", "XEX", "CXC", 'C', Blocks.glass, 'X', Items.glowstone_dust, 'E', Items.redstone});

		GameRegistry.addShapelessRecipe(new ItemStack(CreacionDeBloques.oreCopperOre), new Object[]{CreaciondeItems.itemCopperIngot, Blocks.cobblestone});

		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(CreaciondeItems.itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(CreaciondeItems.itemIronWasher), new Object[]{"DP", 'D', CreaciondeItems.itemIronDisc, 'P', new ItemStack(CreaciondeItems.itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});

		//Smelting
		GameRegistry.addSmelting(CreacionDeBloques.oreCopperOre, new ItemStack(CreaciondeItems.itemCopperIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreTinOre, new ItemStack(CreaciondeItems.itemTinIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreZincOre, new ItemStack(CreaciondeItems.itemZincIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreNickelOre, new ItemStack(CreaciondeItems.itemNickelIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreManganeseOre, new ItemStack(CreaciondeItems.itemManganeseIngot), 0);
		GameRegistry.addSmelting(CreacionDeBloques.oreVanadiumOre, new ItemStack(CreaciondeItems.itemVanadiumIngot), 0);

		GameRegistry.addSmelting(CreacionDeBloques.oreNetherCopperOre, new ItemStack(CreacionDeBloques.oreCopperOre, 2), 0);

		GameRegistry.registerFuelHandler(new FuelHandler());
		
		
		
		

		//Entities
		EntityHandler.registerMonsters(EntityCyclops.class, "Cyclops");
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){

	}


 }

