package com.minecraftargentina.basemod;


import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DrugModEventHooks {



@SubscribeEvent
public void onEntityUpdate(LivingUpdateEvent event) {
if (event.entityLiving.isPotionActive(DrugMod.waterHot)) {
if (event.entityLiving.worldObj.rand.nextInt(20) == 0) {
event.entityLiving.attackEntityFrom(DamageSource.drown, 1);
event.entityLiving.attackEntityFrom( DamageSource.generic, 1);

if (event.entityLiving.getActivePotionEffect(DrugMod.waterHot).getDuration()==0) {
event.entityLiving.removePotionEffect(DrugMod.waterHot.id);
return;
}
}
}
}
}