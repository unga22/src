package com.minecraftargentina.basemod.Items;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.FoodBBQRibs;
import com.minecraftargentina.basemod.Armaduras.TopazArmor;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Cubos.BucketGenericos;
import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;
import com.minecraftargentina.basemod.Herramientas.TopazAxe;
import com.minecraftargentina.basemod.Herramientas.TopazHoe;
import com.minecraftargentina.basemod.Herramientas.TopazPickaxe;
import com.minecraftargentina.basemod.Herramientas.TopazShovel;
import com.minecraftargentina.basemod.Herramientas.TopazSword;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;

public class CreacionDeItems {
	//-----------------------------------------------------------------------------------------------------------------------
	//
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
	public static Item itemTopaz;
	public static Item itemTopazSword;
	public static Item itemTopazAxe;
	public static Item itemTopazShovel;
	public static Item itemTopazHoe;
	public static Item itemTopazPickaxe;
	public static Item armorTopazHelm;
	public static Item armorTopazChest;
	public static Item armorTopazLegs;
	public static Item armorTopazBoots;
	public static int armorTopazHelmID;
	public static int armorTopazChestID;
	public static int armorTopazLegsID;
	public static int armorTopazBootsID;
	public static Item foodHotDog;
	public static Item foodBBQRibs;
	public static Item hojasDelRecuerdo;
	public static Item cropBloodMelonSlice;
	public static Item cropStrawberry;
	public static Item itemLija;
	public static Item itemPolvoDeVidrio;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeItems(){
		itemOldBook = new ItemsGenericos().setUnlocalizedName("OldBook");
		itemCopperIngot = new ItemsGenericos().setUnlocalizedName("CopperIngot");
		itemTinIngot = new ItemsGenericos().setUnlocalizedName("TinIngot");
		itemZincIngot = new ItemsGenericos().setUnlocalizedName("ZincIngot");
		itemNickelIngot = new ItemsGenericos().setUnlocalizedName("NickelIngot");
		itemManganeseIngot = new ItemsGenericos().setUnlocalizedName("ManganeseIngot");
		itemVanadiumIngot = new ItemsGenericos().setUnlocalizedName("VanadiumIngot");
		itemTurmalineIngot = new ItemsGenericos().setUnlocalizedName("TurmalineIngot");
		itemTinCog = new ItemsGenericos().setUnlocalizedName("TinCog");
		itemIronWasher = new ItemsGenericos().setUnlocalizedName("IronWasher");
		itemIronDisc = new ItemsGenericos().setUnlocalizedName("IronDisc");
		itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
		itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");
		itemResiduos = new ItemsGenericos().setUnlocalizedName("Residuos");
		itemStaff = new ItemsGenericos().setUnlocalizedName("Staff");
		itemTopaz = new ItemsGenericos().setUnlocalizedName("Topaz");
		foodHotDog = new ItemFood(6, 0.6F, true).setUnlocalizedName("HotDog").setCreativeTab(BaseMod.oblivion).setTextureName(BaseMod.modid + ":HotDog");
		foodBBQRibs = new FoodBBQRibs(10, 1.0F, true).setUnlocalizedName("BBQRibs");
		itemTopazSword = new TopazSword(BaseMod.TopazMaterial).setUnlocalizedName("TopazSword");
		itemTopazAxe = new TopazAxe(BaseMod.TopazMaterial).setUnlocalizedName("TopazAxe");
		itemTopazShovel = new TopazShovel(BaseMod.TopazMaterial).setUnlocalizedName("TopazShovel");
		itemTopazHoe = new TopazHoe(BaseMod.TopazMaterial).setUnlocalizedName("TopazHoe");
		itemTopazPickaxe = new TopazPickaxe(BaseMod.TopazMaterial).setUnlocalizedName("TopazPickaxe");
		cropStrawberry = new ItemFood(4, 0.5F, false).setUnlocalizedName("Strawberry").setTextureName(BaseMod.modid + ":Strawberry").setCreativeTab(BaseMod.oblivion);
		cropBloodMelonSlice = new ItemFood(4, 0.5F, false).setUnlocalizedName("BloodMelonSlice").setTextureName(BaseMod.modid + ":BloodMelonSlice").setCreativeTab(BaseMod.oblivion);
		armorTopazHelm = new TopazArmor(BaseMod.TopazArmorMaterial, armorTopazHelmID, 0).setUnlocalizedName("TopazHelm");
		armorTopazChest = new TopazArmor(BaseMod.TopazArmorMaterial, armorTopazChestID, 1).setUnlocalizedName("TopazChest");
		armorTopazLegs = new TopazArmor(BaseMod.TopazArmorMaterial, armorTopazLegsID, 2).setUnlocalizedName("TopazLegs");
		armorTopazBoots = new TopazArmor(BaseMod.TopazArmorMaterial, armorTopazBootsID, 3).setUnlocalizedName("TopazBoots");
		hojasDelRecuerdo = new ItemFood(4, 0.5F, false).setUnlocalizedName("HojasDelRecuerdo").setTextureName(BaseMod.modid + ":HojasDelRecuerdo").setCreativeTab(BaseMod.oblivion);
		itemLija = new Lija().setUnlocalizedName("Lija");
		itemPolvoDeVidrio = new ItemPolvoDeVidrio().setUnlocalizedName("PolvoDeVidrio");
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistraciondeItems(){
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

		GameRegistry.registerItem(cropStrawberry, "Strawberry");
		GameRegistry.registerItem(cropBloodMelonSlice, "BloodMelonSlice");
		GameRegistry.registerItem(itemTopazAxe, "TopazAxe");
		GameRegistry.registerItem(itemTopazSword, "TopazSword");
		GameRegistry.registerItem(itemTopazShovel, "TopazShovel");
		GameRegistry.registerItem(itemTopazHoe, "TopazHoe");
		GameRegistry.registerItem(itemTopazPickaxe, "TopazPickaxe");
		
		GameRegistry.registerItem(armorTopazHelm, "TopazHelm");
		GameRegistry.registerItem(armorTopazChest, "TopazChest");
		GameRegistry.registerItem(armorTopazLegs, "TopazLegs");
		GameRegistry.registerItem(armorTopazBoots, "TopazBoots");
		
		GameRegistry.registerItem(hojasDelRecuerdo, "HojasDelRecuerdo");
		GameRegistry.registerItem(itemLija, "Lija");
		GameRegistry.registerItem(itemPolvoDeVidrio, "PolvoDeVidrio");
		

	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
}
