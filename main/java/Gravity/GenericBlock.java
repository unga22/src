package Gravity;

//import grim3212.mc.core.Grim3212Core;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block
{

    public GenericBlock(Material material)
    {
        super(material);
        this.setCreativeTab(Grim3212Core.tabsGrimBlocks);
    }
}
