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
			
			
			if(event.entityPlayer.getHeldItem() == new ItemStack(Items.flint_and_steel)){
				
			
			
			System.out.println("2");
			
			
			
			
			int dy = event.y;
			int dx = event.x;
			int dz = event.z;
			switch(event.face){
			case 0:
				dy = dy - 1;
				break;
			case 1:
				dy = dy + 1;
				break;
			case 2:
				dz = dz - 1;
				break;
			case 3:
				dz = dz + 1;
				break;
			case 4:
				dx = dx - 1;
				break;
			case 5:
				dx = dx + 1;
				break;
			}
			System.out.println(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z));
			System.out.println(dy);
			System.out.println(dx);
			System.out.println(dz);
			
			if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == CreacionDeFluidos.BiofuelBlock) {
	
				System.out.println("3");
				
				// Switch adds/subtracts 1 from coordinates of the block that was right clicked based on which face of the
				// block that is associated with the PlayerInteractEvent
			
				
				System.out.println("4");
			
			event.entityPlayer.worldObj.setBlock(dx, dy, dz, Blocks.grass);
			
	
				
				}
			}
	
		}
	}
}
