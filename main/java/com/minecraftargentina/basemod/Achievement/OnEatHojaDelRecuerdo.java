package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnEatHojaDelRecuerdo {
	
	@SubscribeEvent
	public void whenIEatHojaDelRecuerdo(PlayerUseItemEvent e) {
		System.out.println((e.item.equals(new ItemStack(CreacionDeItems.hojasDelRecuerdo))));
		if(e.item.equals(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
			e.entityPlayer.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoEat, 1);
		}
	}

}