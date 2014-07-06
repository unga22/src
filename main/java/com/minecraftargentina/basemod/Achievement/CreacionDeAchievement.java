package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.CraftingHandler;
import com.minecraftargentina.basemod.GuiHandler;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.FuelMachineEvents;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class CreacionDeAchievement {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Achievement achievementOblivion;
	public static Achievement achievementCopperPick;
	
	public static Achievement achievementHojasDelRecuerdoPick;
	public static Achievement achievementHojasDelRecuerdoEat;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeAchievement(){
		achievementOblivion = new Achievement("archievement.mineOblivion", "mineOblivion", 0, 0, new ItemStack(CreacionDeItems.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementHojasDelRecuerdoPick = new Achievement("archievement.pickHojasDelRcuerdo", "PickHojasDelRecuerdo", 0, 4, new ItemStack(CreacionDeItems.hojasDelRecuerdo), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, CreacionDeBloques.oreCopperOre, achievementOblivion).registerStat();
		achievementHojasDelRecuerdoEat = new Achievement("archivement.eatHojasDelRecuerdo", "EatHojasDelRecuerdo", 1, 5, CreacionDeItems.hojasDelRecuerdo, achievementHojasDelRecuerdoPick).registerStat();
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistracionAchievement(){
		AchievementPage.registerAchievementPage(new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick, achievementHojasDelRecuerdoPick, achievementHojasDelRecuerdoEat}));
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion", "en_US", "Oblivion");
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion.desc", "en_US", "¿ Acaso empiezas a recordar algo?");
		LanguageRegistry.instance().addStringLocalization("achievement.pickHojasDelRecuerdo.desc", "en_US", "Estas hojas me traen recuerdos...");
		
	}
	//	
	//-----------------------------------------------------------------------------------------------------------------------
	public static void RegistracionDeEventos(){
		
		//Registro Minecraft
		FMLCommonHandler.instance().bus().register(new OnPickHojaDelRecuerdo());
		FMLCommonHandler.instance().bus().register(new CopperOnPickEvent());
		FMLCommonHandler.instance().bus().register(new CopperOnCraftEvent());
		
		//Registro Forge
		MinecraftForge.EVENT_BUS.register(new OnEatHojaDelRecuerdo());
		
       // ERROR ARREGLAR//ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		MinecraftForge.EVENT_BUS.register(new FuelMachineEvents());
		FMLCommonHandler.instance().bus().register(new FuelMachineEvents());
		
		
		
		
		
		
		
		
		
	}
}
