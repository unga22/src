package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class CopperOnCraftEvent {
	
	@SubscribeEvent
	public void whenICraftMachine(PlayerEvent.ItemSmeltedEvent e){
		if(e.smelting.getItem().equals(CreacionDeItems.itemCopperIngot)){
			e.player.addStat(CreacionDeAchievement.achievementCopperPick, 1);
			
		
			
			
		}
	}
	
	
	
	
	


}