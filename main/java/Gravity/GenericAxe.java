package Gravity;

//import grim3212.mc.core.Grim3212Core;
import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class GenericAxe extends ItemAxe
{

    public GenericAxe(net.minecraft.item.Item.ToolMaterial toolMaterial)
    {
        super(toolMaterial);
        this.setCreativeTab(Grim3212Core.tabsGrimItems);
		
    }
}
