package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class CreacionDeAchievement {
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static Achievement achievementOblivion;
	public static Achievement achievementCopperPick;
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void CreaciondeAchievement(){
		achievementOblivion = new Achievement("archievement.mineOblivion", "mineOblivion", 0, 0, new ItemStack(CreacionDeItems.itemOldBook), (Achievement)null).initIndependentStat().registerStat();
		achievementCopperPick = new Achievement("archivement.craftPick", "craftPick", 2, 1, CreacionDeBloques.oreCopperOre, achievementOblivion).registerStat();
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------
	//
	public static void RegistracionAchievement(){
		AchievementPage.registerAchievementPage(new AchievementPage("Oblivion Archives", new Achievement[]{achievementOblivion, achievementCopperPick}));
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion", "en_US", "Oblivion");
		LanguageRegistry.instance().addStringLocalization("achievement.mineOblivion.desc", "en_US", "¿ Acaso empiezas a recordar algo?");
	}
	//
	//-----------------------------------------------------------------------------------------------------------------------
	
}
