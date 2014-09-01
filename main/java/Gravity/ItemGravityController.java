package Gravity;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// Referenced classes of package grim3212.mc.gravitycontrol:
//            GravityControl

public class ItemGravityController extends Item
{

    public ItemGravityController()
    {
        upInc = 0.089999999999999997D;
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

  /*  public void func_77663_a(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        if(On)
        {
            for(int i = 0; i < par2World.field_72996_f.size(); i++)
            {
                Entity entity = (Entity)par2World.field_72996_f.get(i);
                if(((Entity)par2World.field_72996_f.get(i)).field_70181_x >= 2D)
                    continue;
                if(entity instanceof EntityPlayer)
                {
                    if(!((EntityPlayer)entity).field_71071_by.func_146028_b(GravityControl.ItemGravityAnchor))
                        entity.field_70181_x += upInc;
                    continue;
                }
                if(entity instanceof EntityItem)
                {
                    Item id = ((EntityItem)entity).func_92059_d().func_77973_b();
                    if(id != GravityControl.ItemGravityAnchor && id != GravityControl.ItemGravityController)
                        entity.field_70181_x += upInc;
                } else
                {
                    entity.field_70181_x += upInc;
                }
            }

        }
        
        
        tickCount++;
    }
    
    */

    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        On = false;
        return true;
    }

    public boolean On;
    private int tickCount;
    private double upInc;
}
