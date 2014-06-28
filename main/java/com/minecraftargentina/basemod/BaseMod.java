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
	public static Item BioFuelBucketItem;
	
	public static Item itemOldBook;

	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemZincIngot;
	public static Item itemNickelIngot;
	public static Item itemManganeseIngot;
	public static Item itemVanadiumIngot;
	public static Item itemTurmalineIngot;

	public static Item itemTinCog;
	public static Item itemIronWasher;
	public static Item itemIronDisc;
	public static Item itemIronHammer;
	public static Item itemIronPunch;

	public static Item itemResiduos;

	public static Item itemStaff;

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

	public static Item itemTopaz;

	public static Item itemTopazSword;
	public static Item itemTopazAxe;
	public static Item itemTopazShovel;
	public static Item itemTopazHoe;
	public static Item itemTopazPickaxe;

	public static int armorTopazHelmID;
	public static int armorTopazChestID;
	public static int armorTopazLegsID;
	public static int armorTopazBootsID;

	public static Item armorTopazHelm;
	public static Item armorTopazChest;
	public static Item armorTopazLegs;
	public static Item armorTopazBoots;

	public static Item foodHotDog;
	public static Item foodBBQRibs;

	//Crops
	public static Item cropStrawberrySeeds;
	public static Item cropStrawberry;
	public static Block cropStrawberryPlant;

	public static Item cropBloodMelonSeeds;
	public static Item cropBloodMelonSlice;
	public static Block cropBloodMelonStem;
	public static Block cropBloodMelon;

	//FLuidsOLD
	public static Block fluidSludgeStill;
	public static Block fluidSludgeFlowing;
	public static Fluid fluidSludge;
	
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

	@SidedProxy(clientSide = "com.minecraftargentina.basemod.ClientProxy", serverSide = "com.minecraftargentina.basemod.CommonProxy")
	public static CommonProxy nealeProxy;
	public static Item Frutilla;
	
	
	  // ItemBlueBerrySeeds
	  public final static Block blockBlueberry = new blueberrycrop();
	 public final static Item blueberryseeds = new ItemBlueberrySeeds();


	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){

		oblivion = new CreativeTabs("Oblivion") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(BaseMod.oreCopperOre);		
				
			}
			
		};
		
		
		//BioFuelRegistry
		
		FluidRegistry.registerFluid(BioFuel);
		fluidblock = new BioFuel(BioFuel, Material.water).setBlockName("BioFuel");
		GameRegistry.registerBlock(fluidblock, "BioFuel");
		BioFuel.setUnlocalizedName(fluidblock.getUnlocalizedName());
		  
		//Initializations
	

		//Items
		itemOldBook = new NCItems().setUnlocalizedName("OldBook");
		itemCopperIngot = new NCItems().setUnlocalizedName("CopperIngot");
		itemTinIngot = new NCItems().setUnlocalizedName("TinIngot");
		itemZincIngot = new NCItems().setUnlocalizedName("ZincIngot");
		itemNickelIngot = new NCItems().setUnlocalizedName("NickelIngot");
		itemManganeseIngot = new NCItems().setUnlocalizedName("ManganeseIngot");
		itemVanadiumIngot = new NCItems().setUnlocalizedName("VanadiumIngot");
		itemTurmalineIngot = new NCItems().setUnlocalizedName("TurmalineIngot");
		

		//Item Parts
		itemTinCog = new NCItems().setUnlocalizedName("TinCog");
		itemIronWasher = new NCItems().setUnlocalizedName("IronWasher");
		itemIronDisc = new NCItems().setUnlocalizedName("IronDisc");
		itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
		itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");

		//Custom Fuel and Tree Drop
		itemResiduos = new NCItems().setUnlocalizedName("Residuos");

		//5x5 Item
		itemStaff = new NCItems().setUnlocalizedName("Staff");

		//Gems
		itemTopaz = new NCItems().setUnlocalizedName("Topaz");

		//Food
		foodHotDog = new ItemFood(6, 0.6F, true).setUnlocalizedName("HotDog").setCreativeTab(oblivion).setTextureName(BaseMod.modid + ":HotDog");
		foodBBQRibs = new FoodBBQRibs(10, 1.0F, true).setUnlocalizedName("BBQRibs");

		//Crops
		cropStrawberryPlant = new NCCrop().setBlockName("StrawberryPlant");
		cropStrawberrySeeds = new ItemSeeds(cropStrawberryPlant, Blocks.farmland).setUnlocalizedName("StrawberrySeeds").setTextureName(modid + ":StrawberrySeeds").setCreativeTab(oblivion);
		cropStrawberry = new ItemFood(4, 0.5F, false).setUnlocalizedName("Strawberry").setTextureName(modid + ":Strawberry").setCreativeTab(oblivion);

		cropBloodMelon = new BloodMelon().setBlockName("BloodMelon").setBlockTextureName(modid + ":BloodMelon");
		cropBloodMelonStem = new BlockNCStem(cropBloodMelon).setBlockName("BloodMelonStem").setBlockTextureName(modid + ":BloodMelon");
		cropBloodMelonSeeds = new ItemSeeds(cropBloodMelonStem, Blocks.farmland).setUnlocalizedName("BloodMelonSeeds").setTextureName(modid + ":BloodMelonSeeds").setCreativeTab(oblivion);
		cropBloodMelonSlice = new ItemFood(4, 0.5F, false).setUnlocalizedName("BloodMelonSlice").setTextureName(modid + ":BloodMelonSlice").setCreativeTab(oblivion);

		//Tools and Weapons
		itemTopazSword = new TopazSword(TopazMaterial).setUnlocalizedName("TopazSword");
		itemTopazAxe = new TopazAxe(TopazMaterial).setUnlocalizedName("TopazAxe");
		itemTopazShovel = new TopazShovel(TopazMaterial).setUnlocalizedName("TopazShovel");
		itemTopazHoe = new TopazHoe(TopazMaterial).setUnlocalizedName("TopazHoe");
		itemTopazPickaxe = new TopazPickaxe(TopazMaterial).setUnlocalizedName("TopazPickaxe");

		//Armor
		armorTopazHelm = new TopazArmor(TopazArmorMaterial, armorTopazHelmID, 0).setUnlocalizedName("TopazHelm");
		armorTopazChest = new TopazArmor(TopazArmorMaterial, armorTopazChestID, 1).setUnlocalizedName("TopazChest");
		armorTopazLegs = new TopazArmor(TopazArmorMaterial, armorTopazLegsID, 2).setUnlocalizedName("TopazLegs");
		armorTopazBoots = new TopazArmor(TopazArmorMaterial, armorTopazBootsID, 3).setUnlocalizedName("TopazBoots");

		//Ores
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

		//Blocks
		blockCopperBlock = new CopperBlock(Material.iron).setBlockName("CopperBlock");
		blockMinerals = new MineralBlocks().setBlockName("Minerals");
		blockObsidianTable = new ObsidianBlock(Material.rock).setBlockName("ObsidianTable");

		//Lamps
		blockPurpleLampOn = new PurpleLamp(true).setBlockName("PurpleLampOn");
		blockPurpleLampOff = new PurpleLamp(false).setBlockName("PurpleLampOff").setCreativeTab(oblivion);

		//Fluids
		materialSludge = new MaterialLiquid(MapColor.greenColor);
		fluidSludgeStill = new NCBlockStaticLiquid(BaseMod.materialSludge).setBlockName("SludgeStill");
		fluidSludgeFlowing = new NCBlockDynamicLiquid(BaseMod.materialSludge).setBlockName("SludgeFlowing");

		//Cubos
		BioFuelBucketItem = new BioFuelBucket(fluidblock).setUnlocalizedName("BioFuelBucket").setTextureName("basemod:BioFuelBucket");

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
		GameRegistry.registerItem(itemOldBook, "OldBook");
		GameRegistry.registerItem(itemCopperIngot, "CopperIngot");
		GameRegistry.registerItem(itemTinIngot, "TinIngot");
		GameRegistry.registerItem(itemZincIngot, "ZincIngot");
		GameRegistry.registerItem(itemNickelIngot, "NickelIngot");
		GameRegistry.registerItem(itemManganeseIngot, "ManganeseIngot");
		GameRegistry.registerItem(itemVanadiumIngot, "VanadiumIngot");
		GameRegistry.registerItem(itemTurmalineIngot, "TurmalineIngot");

		GameRegistry.registerItem(itemTinCog, "TinCog");
		GameRegistry.registerItem(itemIronWasher, "IronWasher");
		GameRegistry.registerItem(itemIronDisc, "IronDisc");
		GameRegistry.registerItem(itemIronHammer, "IronHammer");
		GameRegistry.registerItem(itemIronPunch, "IronPunch");		

		GameRegistry.registerItem(itemResiduos, "Residuos");

		GameRegistry.registerItem(itemStaff, "Staff");

		GameRegistry.registerItem(itemTopaz, "Topaz");

		GameRegistry.registerItem(foodHotDog, "HotDog");
		GameRegistry.registerItem(foodBBQRibs, "BBQRibs");

		GameRegistry.registerItem(cropStrawberrySeeds, "StrawberrySeeds");
		GameRegistry.registerItem(cropStrawberry, "Strawberry");
		GameRegistry.registerBlock(cropStrawberryPlant, "StrawberryPlant");

		GameRegistry.registerItem(cropBloodMelonSeeds, "BloodMelonSeeds");
		GameRegistry.registerItem(cropBloodMelonSlice, "BloodMelonSlice");
		GameRegistry.registerBlock(cropBloodMelon, "BloodMelon");
		GameRegistry.registerBlock(cropBloodMelonStem, "BloodMelonStem");

		MinecraftForge.addGrassSeed(new ItemStack(cropStrawberrySeeds), 10);
		MinecraftForge.addGrassSeed(new ItemStack(cropBloodMelonSeeds), 10);

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(armorTopazChest),1,1,065));

		GameRegistry.registerItem(itemTopazAxe, "TopazAxe");
		GameRegistry.registerItem(itemTopazSword, "TopazSword");
		GameRegistry.registerItem(itemTopazShovel, "TopazShovel");
		GameRegistry.registerItem(itemTopazHoe, "TopazHoe");
		GameRegistry.registerItem(itemTopazPickaxe, "TopazPickaxe");

		//Armor
		GameRegistry.registerItem(armorTopazHelm, "TopazHelm");
		GameRegistry.registerItem(armorTopazChest, "TopazChest");
		GameRegistry.registerItem(armorTopazLegs, "TopazLegs");
		GameRegistry.registerItem(armorTopazBoots, "TopazBoots");

		//Ores
		GameRegistry.registerBlock(oreCopperOre, "CopperOre");
		GameRegistry.registerBlock(oreTinOre, "TinOre");
		GameRegistry.registerBlock(oreZincOre, "ZincOre");
		GameRegistry.registerBlock(oreNickelOre, "NickelOre");
		GameRegistry.registerBlock(oreManganeseOre, "ManganeseOre");
		GameRegistry.registerBlock(oreVanadiumOre, "VanadiumOre");
		GameRegistry.registerBlock(oreTopazOre, "TopazOre");

		//Nether Ores
		GameRegistry.registerBlock(oreNetherCopperOre, "NetherCopperOre");
		GameRegistry.registerBlock(oreNetherTinOre, "NetherTinOre");
		GameRegistry.registerBlock(oreNetherZincOre, "NetherZincOre");
		GameRegistry.registerBlock(oreNetherNickelOre, "NetherNickelOre");
		GameRegistry.registerBlock(oreNetherManganeseOre, "NetherManganeseOre");
		GameRegistry.registerBlock(oreNetherVanadiumOre, "NetherVanadiumOre");
		GameRegistry.registerBlock(oreNetherTopazOre, "NetherTopazOre");

		//Blocks
		GameRegistry.registerBlock(blockCopperBlock, "CopperBlock");
		//GameRegistry.registerBlock(blockMinerals, ItemMineralBlocks.class, blockMinerals.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockObsidianTable, "ObsidianTable");

		//Lamps
		GameRegistry.registerBlock(blockPurpleLampOn, "PurpleLampOn");
		GameRegistry.registerBlock(blockPurpleLampOff, "PurpleLampOff");

		//Fluids

		GameRegistry.registerBlock(fluidSludgeStill, "SludgeStill");
		GameRegistry.registerBlock(fluidSludgeFlowing, "SludgeFlowing");

		
		//FluidRegistry.registerFluid(BioFuel);
		
		
		//Cubos
		GameRegistry.registerItem(BioFuelBucketItem, "BiofuelBucket");

		
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
		BucketHandler.INSTANCE.buckets.put(fluidblock, BioFuelBucketItem);
		
		GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
		GameRegistry.registerTileEntity(TileEntityIngotMasher.class, "IngotMasher");
		GameRegistry.registerTileEntity(TileEntityFuelMachine.class, "FuelMashine");
		
		achievementOblivion = new Achievement("archievement.mineOblivion", "mineOblivion", 0, 0, new ItemStack(BaseMod.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, BaseMod.oreCopperOre, achievementOblivion).registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick}));
		FMLCommonHandler.instance().bus().register(new CopperOnPickEvent());
		FMLCommonHandler.instance().bus().register(new CopperOnCraftEvent());
		
		
		//Archievement Language (Nombres y Descripcion)
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion", "en_US", "Oblivion");
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion.desc", "en_US", "� Acaso empiezas a recordar algo?");
		
		
		

		//Recipes
		//RecipeRemover.removeCraftingRecipe();
		//RecipeRemover.removeFurnaceRecipe();

		GameRegistry.addRecipe(new ItemStack(blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', itemCopperIngot});
		GameRegistry.addRecipe(new ItemStack(itemTinCog, 4), new Object[]{" X ", "XFX", " X ", 'X', itemTinIngot, 'F', Items.flint});
		GameRegistry.addRecipe(new ItemStack(Items.book), new Object[]{"XXX", "YYY", "XXX", 'X', Items.leather, 'Y', Items.paper});
		GameRegistry.addRecipe(new ItemStack(Blocks.furnace), new Object[]{"XXX", "X X", "XXX", 'X', Blocks.stone});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 2), new Object[]{"X", "X", "X", 'X', Blocks.planks});

		GameRegistry.addRecipe(new ItemStack(armorTopazHelm), new Object[]{"XXX", "X X", 'X', itemTopaz});
		GameRegistry.addRecipe(new ItemStack(armorTopazChest), new Object[]{"X X", "XXX", "XXX", 'X', itemTopaz});
		GameRegistry.addRecipe(new ItemStack(armorTopazLegs), new Object[]{"XXX", "X X", "X X", 'X', itemTopaz});
		GameRegistry.addRecipe(new ItemStack(armorTopazBoots), new Object[]{"X X", "X X", 'X', itemTopaz});

		GameRegistry.addRecipe(new ItemStack(blockPurpleLampOff), new Object[]{"CXC", "XEX", "CXC", 'C', Blocks.glass, 'X', Items.glowstone_dust, 'E', Items.redstone});

		GameRegistry.addShapelessRecipe(new ItemStack(oreCopperOre), new Object[]{itemCopperIngot, Blocks.cobblestone});

		GameRegistry.addRecipe(new ItemStack(itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(itemIronWasher), new Object[]{"DP", 'D', itemIronDisc, 'P', new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});

		//Smelting
		GameRegistry.addSmelting(oreCopperOre, new ItemStack(itemCopperIngot), 0);
		GameRegistry.addSmelting(oreTinOre, new ItemStack(itemTinIngot), 0);
		GameRegistry.addSmelting(oreZincOre, new ItemStack(itemZincIngot), 0);
		GameRegistry.addSmelting(oreNickelOre, new ItemStack(itemNickelIngot), 0);
		GameRegistry.addSmelting(oreManganeseOre, new ItemStack(itemManganeseIngot), 0);
		GameRegistry.addSmelting(oreVanadiumOre, new ItemStack(itemVanadiumIngot), 0);

		GameRegistry.addSmelting(oreNetherCopperOre, new ItemStack(oreCopperOre, 2), 0);

		GameRegistry.registerFuelHandler(new FuelHandler());
		
		
		
		

		//Entities
		EntityHandler.registerMonsters(EntityCyclops.class, "Cyclops");
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){

	}


 }

