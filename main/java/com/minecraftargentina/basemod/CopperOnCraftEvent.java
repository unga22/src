package com.minecraftargentina.basemod;

import com.minecraftargentina.basemod.Items.CreaciondeItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;


public class CopperOnCraftEvent {
	
	@SubscribeEvent
	public void whenICraftMachine(PlayerEvent.ItemSmeltedEvent e){
		if(e.smelting.getItem().equals(CreaciondeItems.itemCopperIngot)){
			e.player.addStat(BaseMod.achievementCopperPick, 1);
			
		
			
			
		}
	}
	
	
	
	
	


}