package Prueba.olivecraft;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOliveEdible extends ItemFood {

	public ItemOliveEdible() {
		super(2, false);
        setMaxStackSize(64);
        setPotionEffect(3, 15, 0, 0.5F);
        setAlwaysEdible();
		setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("oliveEdible");
	}
	
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":olive_edible");
    }

}
