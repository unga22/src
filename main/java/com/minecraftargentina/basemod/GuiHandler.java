package com.minecraftargentina.basemod;

import com.minecraftargentina.basemod.AlabasterOven.ContainerAlabasterOven;
import com.minecraftargentina.basemod.AlabasterOven.GuiAlabasterOven;
import com.minecraftargentina.basemod.AlabasterOven.TileEntityAlabasterOven;
import com.minecraftargentina.basemod.FuelMachine.ContainerFuelMachine;
import com.minecraftargentina.basemod.FuelMachine.GuiFuelMachine;
import com.minecraftargentina.basemod.FuelMachine.TileEntityFuelMachine;
import com.minecraftargentina.basemod.IngotMasher.ContainerIngotMasher;
import com.minecraftargentina.basemod.IngotMasher.GuiIngotMasher;
import com.minecraftargentina.basemod.IngotMasher.TileEntityIngotMasher;
import com.minecraftargentina.basemod.WorckSurface.GuiWorkSurface;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			
			case BaseMod.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
				
			case BaseMod.guiIDFuelMachine:
				if (entity instanceof TileEntityFuelMachine) {
					return new ContainerFuelMachine(player.inventory, (TileEntityFuelMachine) entity);
				}
				return null;

				
				

			case BaseMod.guiIDIngotMasher:
				if (entity instanceof TileEntityIngotMasher) {
					return new ContainerIngotMasher(player.inventory, (TileEntityIngotMasher) entity);
				}
				return null;
				
				
			}
		}

		if(ID == BaseMod.guiIDWorkSurface) {
			return ID == BaseMod.guiIDWorkSurface && world.getBlock(x, y, z) == BaseMod.blockWorkSurface ? new ContainerWorkSurface(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			
			case BaseMod.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;

			
			case BaseMod.guiIDFuelMachine:
				if (entity instanceof TileEntityFuelMachine) {
					return new GuiFuelMachine(player.inventory, (TileEntityFuelMachine) entity);
				}
				
				return null;

			case BaseMod.guiIDIngotMasher:
				if (entity instanceof TileEntityIngotMasher) {
					return new GuiIngotMasher(player.inventory, (TileEntityIngotMasher) entity);
				}
				return null;
			}
		}

		if(ID == BaseMod.guiIDWorkSurface) {
			return ID == BaseMod.guiIDWorkSurface && world.getBlock(x, y, z) == BaseMod.blockWorkSurface ? new GuiWorkSurface(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}