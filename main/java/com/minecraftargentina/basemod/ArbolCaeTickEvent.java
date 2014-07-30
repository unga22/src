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
			
			System.out.println("DESTRUCCION1");
			
		}
		
		
		if(event.world.getBlock(event.x, event.y, event.z) == CreacionDeBloques.ToconBlock){
			
			System.out.println("DESTRUCCION0");
			
		}
	}
	
			
			@SubscribeEvent
			public void createFallingBlocks(BreakEvent event) {
			World world = event.world;
			if (!world.isRemote) {
			for (int i = 1; i <= 256; ++i) {
			Block block = world.getBlock(event.x, event.y+i, event.z);
			if (block == CreacionDeBloques.ToconBlock) {
			world.setBlockToAir(event.x, event.y+i, event.z);
		//	world.spawnEntityInWorld(new TileEntityArbolTocon(world, event.x, event.y+i, event.z));
			}

		}
		
	}
	
}
}
			
			
			
			
		
		
		/*
		TileEntity entity = event.world.getTileEntity(event.x, event.y, event.z);
		
		if(entity = Models.TileEntityArbolTocon){
	  
	
	  
	  if(event.world.getBlock(event.x, event.y, event.z) == CreacionDeBloques.ToconBlock){	  
		  
		  
		  System.out.println("DESTRUCCION1");
		  
		
			/*
			
		  
		  
		  /*
		   private void breakBlock(World world, int x, int y, int z){
		if(world.getBlock(x, y, z) != Blocks.bedrock){
			world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
		}
	} 
		   
		   */
		  
		//  event.block.beginLeavesDecay(world, x, y, z);
			
		//  event.block.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	
		//  event.block.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_)
		  
		  

	
	


    
    



