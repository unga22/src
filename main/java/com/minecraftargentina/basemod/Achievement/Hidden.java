package com.minecraftargentina.basemod.Achievement;

import java.lang.reflect.Field;
import java.util.Map;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.AchievementPage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;




public class Hidden {	
	

	@SubscribeEvent
	public void whenICraftMachine(PlayerEvent.ItemSmeltedEvent e){			
		
		
		if(e.smelting.getItem().equals(CreacionDeItems.itemVanadiumIngot)){					
			e.player.addStat(CreacionDeAchievement.achievementHidden, 1);	
			
			if (CreacionDeAchievement.achievementHidden == null){
			CreacionDeAchievement.achievementHidden = new Achievement("archivement.Hidden", "Hidden", 3, 1, new ItemStack(CreacionDeBloques.blockObsidianTable),(Achievement)null).initIndependentStat().registerStat();
			
			// FUNCIONA!!			
			CreacionDeAchievement.OblivionPage.getAchievements().add(CreacionDeAchievement.achievementHidden);
				}				
			}		
	
		}	

}


