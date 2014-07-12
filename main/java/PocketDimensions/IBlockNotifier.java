package PocketDimensions;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public interface IBlockNotifier {

    public void onBlockPlaced(EntityLivingBase entityLiving, ItemStack itemStack);

    public void onBlockDestroyed();

}
