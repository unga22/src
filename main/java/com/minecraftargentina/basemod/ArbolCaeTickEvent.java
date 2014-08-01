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
	
//CAE LA BASE
@SubscribeEvent
public void onBlockBreakToconBlock(BlockEvent.BreakEvent event){
		
		if(event.block == CreacionDeBloques.ToconBlock){
			if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock2){
				event.world.setBlockToAir(event.x, event.y + 1, event.z);
				event.world.setBlockToAir(event.x, event.y + 1, event.z - 1);
				event.world.setBlockToAir(event.x, event.y + 1, event.z - 2);
				event.world.setBlockToAir(event.x, event.y + 1, event.z - 3);		
				event.world.setBlockToAir(event.x, event.y + 1, event.z - 4);	
				event.world.setBlockToAir(event.x, event.y + 1, event.z - 5);	
				event.world.setBlock(event.x, event.y, event.z - 1, CreacionDeBloques.ToconBlock6);
			}
			if(event.world.getBlock(event.x, event.y + 2, event.z) == CreacionDeBloques.ToconBlock3){
				event.world.setBlockToAir(event.x, event.y + 2, event.z);
				event.world.setBlockToAir(event.x, event.y + 2, event.z - 1);
				event.world.setBlockToAir(event.x, event.y + 2, event.z - 2);
				event.world.setBlockToAir(event.x, event.y + 2, event.z - 3);
				event.world.setBlockToAir(event.x, event.y + 2, event.z - 4);
				event.world.setBlockToAir(event.x, event.y + 2, event.z - 5);
				
				event.world.setBlock(event.x, event.y, event.z - 2, CreacionDeBloques.ToconBlock7);
			}
			if(event.world.getBlock(event.x, event.y + 3, event.z) == CreacionDeBloques.ToconBlock4){
				event.world.setBlockToAir(event.x, event.y + 3, event.z);
				event.world.setBlockToAir(event.x, event.y + 3, event.z - 1);
				event.world.setBlockToAir(event.x, event.y + 3, event.z - 2);
				event.world.setBlockToAir(event.x, event.y + 3, event.z - 3);
				event.world.setBlockToAir(event.x, event.y + 3, event.z - 4);
				event.world.setBlockToAir(event.x, event.y + 3, event.z - 5);
				event.world.setBlock(event.x, event.y, event.z - 3, CreacionDeBloques.ToconBlock8);
			}
			if(event.world.getBlock(event.x, event.y + 4, event.z) == CreacionDeBloques.ToconBlock5){
				event.world.setBlockToAir(event.x, event.y + 4, event.z);
				event.world.setBlockToAir(event.x, event.y + 4, event.z - 1);
				event.world.setBlockToAir(event.x, event.y + 4, event.z - 2);
				event.world.setBlockToAir(event.x, event.y + 4, event.z - 3);
				event.world.setBlockToAir(event.x, event.y + 4, event.z - 4);
				event.world.setBlockToAir(event.x, event.y + 4, event.z - 5);
				event.world.setBlock(event.x, event.y, event.z - 4, CreacionDeBloques.ToconBlock9);
			}
			if(event.world.getBlock(event.x, event.y + 5, event.z) == CreacionDeBloques.ToconBlock10){
				event.world.setBlockToAir(event.x, event.y + 5, event.z);
				event.world.setBlockToAir(event.x, event.y + 5, event.z - 1);
				event.world.setBlockToAir(event.x, event.y + 5, event.z - 2);
				event.world.setBlockToAir(event.x, event.y + 5, event.z - 3);
				event.world.setBlockToAir(event.x, event.y + 5, event.z - 4);
				event.world.setBlockToAir(event.x, event.y + 5, event.z - 5);
				
				event.world.setBlock(event.x, event.y, event.z - 5, CreacionDeBloques.ToconBlock11);
								
			}
		}
	}
	
//CAE TRONCO1
@SubscribeEvent
public void onBlockBreakToconBlock2(BlockEvent.BreakEvent event){
	
	if(event.block == CreacionDeBloques.ToconBlock2){
		if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock3){
			event.world.setBlockToAir(event.x, event.y + 1, event.z);
			event.world.setBlockToAir(event.x, event.y, event.z - 1);
			event.world.setBlockToAir(event.x, event.y, event.z - 2);
			event.world.setBlockToAir(event.x, event.y, event.z - 3);
			event.world.setBlockToAir(event.x, event.y, event.z - 4);
			event.world.setBlockToAir(event.x, event.y, event.z - 5);			
			event.world.setBlock(event.x, event.y - 1, event.z - 1, CreacionDeBloques.ToconBlock7);
		}
		if(event.world.getBlock(event.x, event.y + 2, event.z) == CreacionDeBloques.ToconBlock4){
			event.world.setBlockToAir(event.x, event.y, event.z);
			event.world.setBlockToAir(event.x, event.y, event.z - 1);
			event.world.setBlockToAir(event.x, event.y, event.z - 2);
			event.world.setBlockToAir(event.x, event.y, event.z - 3);
			event.world.setBlockToAir(event.x, event.y, event.z - 4);
			event.world.setBlockToAir(event.x, event.y, event.z - 5);
			event.world.setBlock(event.x, event.y - 1, event.z - 2, CreacionDeBloques.ToconBlock8);
		}
		if(event.world.getBlock(event.x, event.y + 3, event.z) == CreacionDeBloques.ToconBlock5){
			event.world.setBlockToAir(event.x, event.y, event.z);
			event.world.setBlockToAir(event.x, event.y, event.z - 1);
			event.world.setBlockToAir(event.x, event.y, event.z - 2);
			event.world.setBlockToAir(event.x, event.y, event.z - 3);
			event.world.setBlockToAir(event.x, event.y, event.z - 4);
			event.world.setBlockToAir(event.x, event.y, event.z - 5);
			event.world.setBlock(event.x, event.y - 1, event.z - 3, CreacionDeBloques.ToconBlock9);
		}
		if(event.world.getBlock(event.x, event.y + 4, event.z) == CreacionDeBloques.ToconBlock10){
			event.world.setBlockToAir(event.x, event.y, event.z);
			event.world.setBlockToAir(event.x, event.y, event.z - 1);
			event.world.setBlockToAir(event.x, event.y, event.z - 2);
			event.world.setBlockToAir(event.x, event.y, event.z - 3);
			event.world.setBlockToAir(event.x, event.y, event.z - 4);
			event.world.setBlockToAir(event.x, event.y, event.z - 5);
			event.world.setBlock(event.x, event.y - 1, event.z - 4, CreacionDeBloques.ToconBlock11);
		}
	}
}

//CAE TRONCO 2
@SubscribeEvent
public void onBlockBreakToconBlock3(BlockEvent.BreakEvent event){
	
	if(event.block == CreacionDeBloques.ToconBlock3){
		if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock4){
			event.world.setBlockToAir(event.x, event.y + 1, event.z);
			event.world.setBlock(event.x, event.y - 2, event.z - 1, CreacionDeBloques.ToconBlock8);
		}
		if(event.world.getBlock(event.x, event.y + 2, event.z) == CreacionDeBloques.ToconBlock5){
			event.world.setBlockToAir(event.x, event.y + 2, event.z);
			event.world.setBlock(event.x, event.y - 2, event.z - 2, CreacionDeBloques.ToconBlock9);
		}
		if(event.world.getBlock(event.x, event.y + 3, event.z) == CreacionDeBloques.ToconBlock10){
			event.world.setBlockToAir(event.x, event.y + 3, event.z);
			event.world.setBlock(event.x, event.y - 2, event.z - 3, CreacionDeBloques.ToconBlock11);
		
		}			
    }
}

//CAE TRONCO 3
@SubscribeEvent
public void onBlockBreakToconBlock4(BlockEvent.BreakEvent event){
	
	if(event.block == CreacionDeBloques.ToconBlock4){
		if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock5){
			event.world.setBlockToAir(event.x, event.y + 1, event.z);
			event.world.setBlock(event.x, event.y - 3, event.z - 1, CreacionDeBloques.ToconBlock9);
		}
		if(event.world.getBlock(event.x, event.y + 2, event.z) == CreacionDeBloques.ToconBlock10){
			event.world.setBlockToAir(event.x, event.y + 2, event.z);
			event.world.setBlock(event.x, event.y - 3, event.z - 2, CreacionDeBloques.ToconBlock11);
		
		}			
    }
}

//CAE RAMAS
@SubscribeEvent
public void onBlockBreakToconBlock5(BlockEvent.BreakEvent event){
	
	if(event.block == CreacionDeBloques.ToconBlock5){
		if(event.world.getBlock(event.x, event.y + 1, event.z) == CreacionDeBloques.ToconBlock10){
			event.world.setBlockToAir(event.x, event.y + 1, event.z);
			event.world.setBlock(event.x, event.y - 4, event.z - 1, CreacionDeBloques.ToconBlock11);
		}			
    }
}










}

	
	


    
    



