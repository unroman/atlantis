package com.mystic.atlantis.items;

import net.minecraft.core.Holder;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import org.jetbrains.annotations.NotNull;

import com.mystic.atlantis.init.AtlantisGroupInit;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;

public class SodiumItem extends Item {
    public SodiumItem(Item.Properties properties) {
        super(properties
                .stacksTo(64)
                .fireResistant());
    }

    @Override
    public boolean canBeHurtBy(@NotNull DamageSource arg) {
        return !(arg.m_269415_().equals(new DamageType("lightningBolt", 0.1F)));
    }
}
