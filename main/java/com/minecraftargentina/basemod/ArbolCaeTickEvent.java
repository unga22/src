package com.minecraftargentina.basemod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.event.world.WorldEvent;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//@SideOnly(Side.CLIENT)
public class ArbolCaeTickEvent {
	
	
	
	
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event){
		
		if(event.block == CreacionDeBloques.ToconBlock){
			if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock2){
				event.world.setBlockToAir(event.x, event.y + 1, event.z);
				event.world.setBlock(event.x + 1, event.y, event.z, CreacionDeBloques.ToconBlock6);
			}
			if(event.world.getBlock(event.x, event.y + 2, event.z) == CreacionDeBloques.ToconBlock3){
				event.world.setBlockToAir(event.x, event.y + 2, event.z);
				event.world.setBlock(event.x + 2, event.y, event.z, CreacionDeBloques.ToconBlock7);
			}
			if(event.world.getBlock(event.x, event.y + 3, event.z) == CreacionDeBloques.ToconBlock4){
				event.world.setBlockToAir(event.x, event.y + 3, event.z);
				event.world.setBlock(event.x + 3, event.y, event.z, CreacionDeBloques.ToconBlock8);
			}
			if(event.world.getBlock(event.x, event.y + 4, event.z) == CreacionDeBloques.ToconBlock5){
				event.world.setBlockToAir(event.x, event.y + 4, event.z);
				event.world.setBlock(event.x + 4, event.y, event.z, CreacionDeBloques.ToconBlock9);
			}
			if(event.world.getBlock(event.x, event.y + 5, event.z) == CreacionDeBloques.ToconBlock10){
				event.world.setBlockToAir(event.x, event.y + 5, event.z);
			}
		}
	}
	
}

		  

	
	


    
    



