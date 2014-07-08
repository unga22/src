package com.minecraftargentina.basemod.Fluidos;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;







import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Achievement.CreacionDeAchievement;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class BioFuelEvents {
	
	
	@SubscribeEvent
	public void onEventBioFuelFlint(PlayerInteractEvent event){
		System.out.println("0");
				
		if(event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
			
			System.out.println("1");
			
			System.out.println(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z));
			
			if(event.entityPlayer.getHeldItem() == new ItemStack(Items.flint_and_steel)){
				
			
			
			System.out.println("2");
		
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Block.getBlockFromName("BioFuelStill")) {
	
				System.out.println("3");
		
			
				
				
				int dy = event.y;
				int dx = event.x;
				int dz = event.z;
				
				// Switch adds/subtracts 1 from coordinates of the block that was right clicked based on which face of the
				// block that is associated with the PlayerInteractEvent
			
				
				System.out.println("4");
			
			event.entityPlayer.worldObj.setBlock(dx, dy, dz, Blocks.grass);
			
	
				
				}
			}
	
		}
	}
}
