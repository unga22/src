package com.minecraftargentina.basemod;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class BlockBioFuel extends BlockFluidClassic {

        
        public BlockBioFuel(Fluid fluid, Material material) {
                super(fluid, Material.water);
                setCreativeTab(BaseMod.oblivion);   
}
}