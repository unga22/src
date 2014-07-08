package com.minecraftargentina.basemod.Achievement;

import java.lang.reflect.Field;
import java.util.Map;

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
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class CreacionDeAchievement {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Achievement achievementOblivion;
	public static Achievement achievementCopperPick;
	
	public static Achievement achievementHojasDelRecuerdoPick;
	public static Achievement achievementHojasDelRecuerdoEat;
	public static AchievementPage OblivionPage;
	public static Achievement achievementHidden;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeAchievement(){			
		
		
		achievementOblivion = new Achievement("archievement.Oblivion", "Oblivion", 0, 0, new ItemStack(CreacionDeItems.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, CreacionDeBloques.oreCopperOre, achievementOblivion).registerStat();
		achievementHojasDelRecuerdoPick = new Achievement("archievement.pickHojasDelRcuerdo", "PickHojasDelRecuerdo", 0, 4, new ItemStack(CreacionDeItems.hojasDelRecuerdo), (Achievement)null).initIndependentStat().registerStat();
		achievementHojasDelRecuerdoEat = new Achievement("archivement.eatHojasDelRecuerdo", "EatHojasDelRecuerdo", 1, 5, CreacionDeItems.hojasDelRecuerdo, achievementHojasDelRecuerdoPick).registerStat();
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistracionAchievement(){
		
		
		OblivionPage = new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick, achievementHojasDelRecuerdoPick, achievementHojasDelRecuerdoEat});
		AchievementPage.registerAchievementPage(OblivionPage);
		
		
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
		
       
		
		MinecraftForge.EVENT_BUS.register(new FuelMachineEvents());
		FMLCommonHandler.instance().bus().register(new FuelMachineEvents());
		
		MinecraftForge.EVENT_BUS.register(new Hidden());
		FMLCommonHandler.instance().bus().register(new Hidden());
		
		
		
		
		
		
		
		
	}

	public boolean addHiddenAchievement(Achievement ach) {
	    StatList.allStats.add(ach);
	            
	    Map oneShotStats = null;
	    Field field = null;
	    
	    for (Field f : StatList.class.getDeclaredFields()) {
	        f.setAccessible(true);
	        try {
	                        if (f.getName().equals("oneShotStats") || f.getName().equals("field_75942_a")) {
	                                oneShotStats = (Map)f.get(null);
	                                field = f;
	                        }
	                } catch (Exception ex) {
	                        System.out.println("no field " + ex);
	                        return false;
	                }
	    }
	   
	        
	        if (oneShotStats == null) return false;
	        
	        try {
	                if (oneShotStats.containsKey(Integer.valueOf(ach.statId))) {
	                        System.out.println("Already existing Achievement with this stat id!");
	            return false;
	        }
	                
	                oneShotStats.put(Integer.valueOf(ach.statId), ach);
	        } catch (Exception e) {
	                System.out.println("Failed setting");
	                return false;
	        }
	        
	        
	    ach = new Achievement("archivement.Hidden", "Hidden", 3, 1, new ItemStack(CreacionDeBloques.blockObsidianTable), (Achievement)null).initIndependentStat();
	        
	    return true;
	}
}
