package Prueba.olivecraft;


import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOliveLog extends ItemBlock {
    public ItemBlockOliveLog(Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxStackSize(64);
    }

    public int getMetadata(int meta) {
        return meta;
    }

	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		String name = itemStack.getItemDamage() == 0 ? "tile.fertilizedLog" : super.getUnlocalizedName();
		return Strings.MODID.toLowerCase() + "." + name;
	}
}
