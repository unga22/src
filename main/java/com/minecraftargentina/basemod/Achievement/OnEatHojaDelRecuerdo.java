package com.minecraftargentina.basemod.Achievement;

import com.minecraftargentina.basemod.Items.CreacionDeItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OnEatHojaDelRecuerdo {
	
	
	@SubscribeEvent
<<<<<<< HEAD
<<<<<<< HEAD
	 public void foodEaten(PlayerUseItemEvent.Finish event) {
	  	   if(event.item.getItem() == CreacionDeItems.hojasDelRecuerdo) {
	  		 event.entityPlayer.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoEat, 1);
	   
	   }
	  }
	 }
=======
	public void whenPlayerEatHojaDelRecuerdo(PlayerUseItemEvent e) {
		System.out.println("1");
=======
	public void whenIEatHojaDelRecuerdo(PlayerUseItemEvent e) {
		System.out.println((e.item.equals(new ItemStack(CreacionDeItems.hojasDelRecuerdo))));
>>>>>>> ffa78be739e3660beaab6edc45e8fb2c78bdda1b
		if(e.item.equals(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
			e.entityPlayer.addStat(CreacionDeAchievement.achievementHojasDelRecuerdoEat, 1);
		}
	}

}
>>>>>>> origin/master
