package Gravity;

//import grim3212.mc.core.Grim3212Core;
import net.minecraft.item.ItemFood;

public class GenericFood extends ItemFood
{

    public GenericFood(int healAmount, float saturationModifier, boolean isWolfsFavoriteMeat)
    {
        super(healAmount, saturationModifier, isWolfsFavoriteMeat);
        this.setCreativeTab(Grim3212Core.tabsGrimItems);
    }
}
