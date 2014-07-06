package com.minecraftargentina.basemod.Maquinas.FuelMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent;

import com.minecraftargentina.basemod.SoundHandler;
import com.minecraftargentina.basemod.Achievement.CreacionDeAchievement;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

public class FuelMachineEvents {
	
	private TileEntityFuelMachine fuelmashine;
	
	public void onEntityConstructing(EntityEvent.EntityConstructing event) {
	        if (event.equals(fuelmashine.estaTransformado()));
	        SoundHandler.onEntityPlay("bunnyBegA", event.entity.worldObj, event.entity, 1, 1);
  }
	
}