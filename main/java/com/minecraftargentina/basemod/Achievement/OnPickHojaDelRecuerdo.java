package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.SoundHandler;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class OnPickHojaDelRecuerdo {
	
	@SubscribeEvent
	public void whenIPickHojaDelRecuerdo(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
			e.player.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoPick, 1);
			
		}
	}
	
    @SubscribeEvent
    public void SoundOnPickupEventHojaDelRecuerdo(ItemPickupEvent event) {
    	
    	if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
    		SoundHandler.onEntityPlay("Skyrim0", event.player.worldObj, event.player, 1, 1);
    	}
    }

}