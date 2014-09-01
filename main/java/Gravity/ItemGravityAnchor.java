package Gravity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGravityAnchor extends Item
{

    public ItemGravityAnchor()
    {
        tickCount = 0;
    }




    public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        if((par3Entity instanceof EntityPlayer) && tickCount > 10)
        {
            ((EntityPlayer)par3Entity).func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 14, 0));
            tickCount = 0;
        }
        tickCount++;
    }

    int tickCount;
}
