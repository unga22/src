package Prueba.olivecraft;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChip extends ItemFood {
    public ItemChip() {
        super(2, false);
        setMaxStackSize(8);
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("chip");
    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":chip");
    }
}
