package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class CopperOnPickEvent {
	
	@SubscribeEvent
	public void whenIGetCopper(PlayerEvent.PlayerLoggedInEvent e) {
		//if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(CreacionDeBloques.oreCopperOre))){
			e.player.addStat(CreacionDeAchievement.achievementOblivion, 1);
		}
	}

