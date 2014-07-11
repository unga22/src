package com.minecraftargentina.basemod.Fluidos;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;








import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.Achievement.CreacionDeAchievement;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Items.CreacionDeItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class BioFuelEvents {
	
	
	@SubscribeEvent
	public void onEventBioFuelFlint(PlayerInteractEvent event){
		System.out.println("0");
							
			
			

				
				
				System.out.println("2");
				
				if(event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK){
					
					System.out.println("3");
					
					
					
					
					if(event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == CreacionDeBloques.blockCopperBlock){
						
					
				
	
					
					int dy = event.y;
					int dx = event.x;
					int dz = event.z;
					
					// Switch adds/subtracts 1 from coordinates of the block that was right clicked based on which face of the
					// block that is associated with the PlayerInteractEvent
					switch(event.face)
					{
					case 0:
						dy -= 1;
						break;
					case 1:
						dy += 1;
						break;
					case 2:
						dz -= 1;
						break;
					case 3:
						dz += 1;
						break;
					case 4:
						dx -= 1;
						break;
					case 5:
						dx += 1;
						break;
					}
					
					// e.entityPlayer.worldObj.playSoundEffect(dx + 0.5D, dy + 0.5D, dz + 0.5D, "block.wood.place", 1.0f, e.entityPlayer.worldObj.rand.nextFloat() * 0.1f + 0.9f);
				
					event.entityPlayer.worldObj.setBlock(dx, dy, dz, Blocks.grass);
					// Places down manicMod:fence_oak instead
					/*
					fenceItem.placeBlockAt(e.entityPlayer.getHeldItem(), 
							e.entityPlayer, 
							e.entityPlayer.worldObj,
							dx, dy, dz, 
							e.face, 
							0, 0, 0, 
							0);
					*/
					}
				}
			
			}
		}
	
