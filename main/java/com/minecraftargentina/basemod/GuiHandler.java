package com.minecraftargentina.basemod;

import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.ContainerAlabasterOven;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.GuiAlabasterOven;
import com.minecraftargentina.basemod.Maquinas.AlabasterOven.TileEntityAlabasterOven;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.ContainerFuelMachine;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.GuiFuelMachine;
import com.minecraftargentina.basemod.Maquinas.FuelMachine.TileEntityFuelMachine;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.ContainerIngotMasher;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.GuiIngotMasher;
import com.minecraftargentina.basemod.Maquinas.IngotMasher.TileEntityIngotMasher;
import com.minecraftargentina.basemod.Maquinas.WorckSurface.ContainerWorkSurface;
import com.minecraftargentina.basemod.Maquinas.WorckSurface.GuiWorkSurface;

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
			
			case CreacionDeMaquinas.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
				
			case CreacionDeMaquinas.guiIDFuelMachine:
				if (entity instanceof TileEntityFuelMachine) {
					return new ContainerFuelMachine(player.inventory, (TileEntityFuelMachine) entity);
				}
				return null;

				
				

			case CreacionDeMaquinas.guiIDIngotMasher:
				if (entity instanceof TileEntityIngotMasher) {
					return new ContainerIngotMasher(player.inventory, (TileEntityIngotMasher) entity);
				}
				return null;
				
				
			}
		}

		if(ID == CreacionDeMaquinas.guiIDWorkSurface) {
			return ID == CreacionDeMaquinas.guiIDWorkSurface && world.getBlock(x, y, z) == CreacionDeMaquinas.blockWorkSurface ? new ContainerWorkSurface(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			
			case CreacionDeMaquinas.guiIDAlabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;

			
			case CreacionDeMaquinas.guiIDFuelMachine:
				if (entity instanceof TileEntityFuelMachine) {
					return new GuiFuelMachine(player.inventory, (TileEntityFuelMachine) entity);
				}
				
				return null;

			case CreacionDeMaquinas.guiIDIngotMasher:
				if (entity instanceof TileEntityIngotMasher) {
					return new GuiIngotMasher(player.inventory, (TileEntityIngotMasher) entity);
				}
				return null;
			}
		}

		if(ID == CreacionDeMaquinas.guiIDWorkSurface) {
			return ID == CreacionDeMaquinas.guiIDWorkSurface && world.getBlock(x, y, z) == CreacionDeMaquinas.blockWorkSurface ? new GuiWorkSurface(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}