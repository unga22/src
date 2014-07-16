package Prueba.olivecraft;

import java.util.List;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemOil extends Item {
    private IIcon badIcon, rottenIcon;

    public ItemOil() {
        super();
        setMaxStackSize(1);
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("oil");
        setMaxDamage(32);
        setNoRepair();
    }
    
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List par3List) {
        par3List.add(new ItemStack(item, 1, 0));

    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		String name = itemStack.getItemDamage() >= 24 ? "item.refriedOil" : super.getUnlocalizedName();
		return Strings.MODID.toLowerCase() + "." + name;
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage) {
        return damage < 24 ? itemIcon : damage < 32 ? badIcon : rottenIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":oil_good");
        this.badIcon = iconRegister.registerIcon(Strings.MODID + ":oil_bad");
        this.rottenIcon = iconRegister.registerIcon(Strings.MODID + ":oil_rotten");
    }
}
