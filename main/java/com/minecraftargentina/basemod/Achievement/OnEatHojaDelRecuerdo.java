package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OnEatHojaDelRecuerdo {
	
	
	@SubscribeEvent


	 public void ComerHojaDelRecuerdo(PlayerUseItemEvent.Finish event) {

	  	   if(event.item.getItem() == CreacionDeItems.hojasDelRecuerdo) {
	  		 event.entityPlayer.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoEat, 1);
	   
	  	   }
	}
}
	  	   
