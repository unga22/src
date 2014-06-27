package com.minecraftargentina.basemod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CopperOnPickEvent {
	
	@SubscribeEvent
	public void whenIGetCopper(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(BaseMod.oreCopperOre))){
			e.player.addStat(BaseMod.achievementOblivion, 1);
		}
	}

}