package Prueba.olivecraft;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOlive extends Item {
    public ItemOlive() {
        super();
        setMaxStackSize(64);
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("olive");
    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":olive");
    }
}
