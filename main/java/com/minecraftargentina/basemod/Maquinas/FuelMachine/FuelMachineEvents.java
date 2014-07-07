package com.minecraftargentina.basemod.Maquinas.FuelMachine;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.sound.PlaySoundEffectEvent;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.event.entity.EntityEvent;

import com.minecraftargentina.basemod.SoundHandler;
import com.minecraftargentina.basemod.Achievement.CreacionDeAchievement;
import com.minecraftargentina.basemod.Items.CreacionDeItems;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class FuelMachineEvents {
	
	private TileEntityFuelMachine fuelmashine;
	private boolean hasPlayed = false;
	@SubscribeEvent
	public void onEntityConstructing0(TickEvent.PlayerTickEvent event) {
		boolean mustPlayMusic = TileEntityFuelMachine.prendida;
	    if(mustPlayMusic == true && !hasPlayed ) {	
	    	SoundHandler.onEntityPlay("Skyrim0", event.player.worldObj, event.player, 1, 1);
	     }
		hasPlayed = mustPlayMusic;
	}
	

}
