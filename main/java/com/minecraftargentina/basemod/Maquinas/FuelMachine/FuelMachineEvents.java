package com.minecraftargentina.basemod.Maquinas.FuelMachine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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
	
	@SubscribeEvent
	public void onEntityConstructing0(EntityEvent.EntityConstructing event) {
	        if (TileEntityFuelMachine.prendida == true && ) {
	 
	     System.out.println("AAAAAAAAAAAAA");
	        	
	        	//  if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(CreacionDeItems.hojasDelRecuerdo))){
	        SoundHandler.onEntityPlay("Skyrim0", event.entity.worldObj, event.entity, 1, 1);
	        
	        

	}
	}
	

}
