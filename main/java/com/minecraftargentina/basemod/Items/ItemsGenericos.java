package com.minecraftargentina.basemod.Items;


import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemsGenericos extends Item {

	public ItemsGenericos() {
		setCreativeTab(BaseMod.oblivion);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BaseMod.modid + ":" + this.getUnlocalizedName().substring(5));
		
		
	}		
		
    @Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5){
    	if (entity instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer)entity;
    		if(itemstack.getItem() == CreaciondeItems.itemVanadiumIngot){
    			if(!(player.inventory.armorInventory[0] !=null && player.inventory.armorInventory[1] !=null && player.inventory.armorInventory[2] !=null && player.inventory.armorInventory[3] !=null)){
    				if(player.getActivePotionEffect(Potion.poison) == null){
    					player.addPotionEffect(new PotionEffect(Potion.poison.id, 240));
    				}
		     	player.addPotionEffect(new PotionEffect(Potion.blindness.id, 240));
		     	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 240));
    			} else {
    				ItemStack botas = player.inventory.armorInventory[0];
    				ItemStack pantalon = player.inventory.armorInventory[1];
    				ItemStack peto = player.inventory.armorInventory[2];
    				ItemStack casco = player.inventory.armorInventory[3];
    				if(!(botas.getItem() == CreaciondeItems.armorTopazBoots && pantalon.getItem() == CreaciondeItems.armorTopazLegs && peto.getItem() == CreaciondeItems.armorTopazChest && casco.getItem() == CreaciondeItems.armorTopazHelm)){
    					if(player.getActivePotionEffect(Potion.poison) == null){
    						player.addPotionEffect(new PotionEffect(Potion.poison.id, 240));
    					}
    					player.addPotionEffect(new PotionEffect(Potion.blindness.id, 240));
    					player.addPotionEffect(new PotionEffect(Potion.confusion.id, 240));
    				}
    			}
    		}
    	}
    }	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
