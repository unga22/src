package Prueba.olivecraft;

import java.util.List;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBagFull extends ItemFood
{
    public ItemBagFull() {
        super(2, false);
        setMaxStackSize(1);
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("fullBag");
        setMaxDamage(256);
        setNoRepair();
    }

    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getItemDamage() >= this.getMaxDamage() - 1) {
            stack.func_150996_a(OliveItems.bagEmpty);
        } else {
            stack.damageItem(1, player);
        }
        player.getFoodStats().func_151686_a(this, stack);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(stack, world, player);
        return stack;
    }
    
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	list.add(stack.getMaxDamage() - stack.getItemDamage() + " " + StatCollector.translateToLocal("olivecraft.item.fullBag.tooltip"));
    }


	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":bag_full");
    }
}
