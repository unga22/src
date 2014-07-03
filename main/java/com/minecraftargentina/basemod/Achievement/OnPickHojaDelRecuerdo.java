package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnPickHojaDelRecuerdo {
	
	@SubscribeEvent
	public void whenIPickHojaDelRecuerdo(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
			e.player.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoPick, 1);
		}
	}

}