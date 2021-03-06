package com.minecraftargentina.basemod.Blocks;


import java.util.Random;

import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;



public class PurpleLamp extends Block {

	private final boolean isOn;

	public PurpleLamp(boolean isOn) {
		super(Material.redstoneLight);

		this.isOn = isOn;

		if (isOn) {
			this.setLightLevel(1.0F);
		}
	}

	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BaseMod.modid + ":" + (this.isOn ? "PurpleLampOn" : "PurpleLampOff"));
	}

	public void onBlockAdded(World world, int x, int y, int z) {

		if (!world.isRemote) {
			if (this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.scheduleBlockUpdate(x, y, z, this, 4);
			}
			else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.setBlock(x, y, z, CreacionDeBloques.blockPurpleLampOn, 0, 2);
			}
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {

		if (!world.isRemote) {
			if (this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.scheduleBlockUpdate(x, y, z, this, 4);
			}
			else if (!this.isOn && world.isBlockIndirectlyGettingPowered(x, y, z)) {
				world.setBlock(x, y, z, CreacionDeBloques.blockPurpleLampOn, 0, 2);
			}
		}
	}

	public void updateTick(World world, int x, int y, int z, Random random) {

		if (!world.isRemote && this.isOn && !world.isBlockIndirectlyGettingPowered(x, y, z)) {
			world.setBlock(x, y, z, CreacionDeBloques.blockPurpleLampOff, 0, 2);
		}
	}

	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(CreacionDeBloques.blockPurpleLampOff);
	}

	protected ItemStack createStackedBlock(int i) {
		return new ItemStack(CreacionDeBloques.blockPurpleLampOff);
	}


}