package com.minecraftargentina.basemod;



import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;


public class TopazArmor extends ItemArmor {

	public TopazArmor(ArmorMaterial material, int id,
			int slot) {
		super(material, id, slot);
		this.setCreativeTab(BaseMod.oblivion);

		if(slot == 0) {
			this.setTextureName(BaseMod.modid + ":TopazHelm");
		}else if (slot == 1) {
			this.setTextureName(BaseMod.modid + ":TopazChest");
		}else if (slot == 2) {
			this.setTextureName(BaseMod.modid + ":TopazLegs");
		}else if (slot == 3) {
			this.setTextureName(BaseMod.modid + ":TopazBoots");
		}	
	}

	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (itemstack.getItem() == BaseMod.armorTopazHelm || itemstack.getItem() == BaseMod.armorTopazChest || itemstack.getItem() == BaseMod.armorTopazBoots) {  
				return BaseMod.modid + ":textures/model/armor/topaz_layer_1.png";
		}else if (itemstack.getItem() == BaseMod.armorTopazLegs) {  
			return BaseMod.modid + ":textures/model/armor/topaz_layer_2.png";
		}else{
			return null;
		}
	}

	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {

		if (itemstack.getItem() == BaseMod.armorTopazHelm) {
			itemstack.addEnchantment(Enchantment.aquaAffinity, 2);
		}else if (itemstack.getItem() == BaseMod.armorTopazChest) {
			itemstack.addEnchantment(Enchantment.fireProtection, 4);
		}else if (itemstack.getItem() == BaseMod.armorTopazLegs) {
			itemstack.addEnchantment(Enchantment.thorns, 5);
		}else if (itemstack.getItem() == BaseMod.armorTopazBoots) {
			itemstack.addEnchantment(Enchantment.unbreaking, 4);
		}
	}
}