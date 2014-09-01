package Gravity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLowGravityController extends Item
{

    public ItemLowGravityController()
    {
    }

    public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(tickCount > 10)
        {
            On = !On;
            tickCount = 0;
        }
        return par1ItemStack;
    }

 /*   public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        if(On)
        {
            for(int i = 0; i < par2World.field_72996_f.size(); i++)
                if(((Entity)par2World.field_72996_f.get(i)).field_70181_x < 2D)
                    ((Entity)par2World.field_72996_f.get(i)).field_70181_x += 0.037999999999999999D;

        }
        tickCount++;
    }
    
    */



    public boolean On;
    private int tickCount;
}
