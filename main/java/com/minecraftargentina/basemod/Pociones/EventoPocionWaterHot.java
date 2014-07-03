package com.minecraftargentina.basemod.Pociones;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventoPocionWaterHot {
    @SubscribeEvent
    public void onEntityUpdate(LivingUpdateEvent event) {
    	if (event.entityLiving.isPotionActive(CreacionDePociones.PocionWaterHot)) {
    		if (event.entityLiving.worldObj.rand.nextInt(20) == 0) {
    			event.entityLiving.attackEntityFrom(DamageSource.drown, 1);
    			event.entityLiving.attackEntityFrom(DamageSource.generic, 1);
    			if (event.entityLiving.getActivePotionEffect(CreacionDePociones.PocionWaterHot).getDuration()==0) {
    				event.entityLiving.removePotionEffect(CreacionDePociones.PocionWaterHot.id);
    				return;
    			}
    		}
    	}
    }
}
