package Prueba.olivecraft;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToast extends ItemFood {
    public ItemToast() {
        super(0, false);
        setMaxStackSize(64);
        setPotionEffect(22, 60, 0, 1F);
        setAlwaysEdible();
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("toast");
    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":toast");
    }
}
