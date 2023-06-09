package com.mystic.atlantis.items;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;

public class CrabEntityBucketItem extends MobBucketItem {
    private final Supplier<? extends EntityType<?>> entityType;

    public CrabEntityBucketItem(Supplier<? extends EntityType<?>> type, Supplier<Fluid> fluid, Supplier<SoundEvent> emptyingSound, Properties settings) {
        super(type, fluid, emptyingSound, settings);
        this.entityType = type;
    }

    @Override
    public void checkExtraContent(@Nullable Player player, Level world, ItemStack stack, BlockPos pos) {
        if (world instanceof ServerLevel) {
            this.spawn((ServerLevel)world, stack, pos);
            world.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    private void spawn(ServerLevel world, ItemStack stack, BlockPos pos) {
        Entity entity = this.entityType.get().spawn(world, stack, null, pos, MobSpawnType.BUCKET, true, false);
        if (entity instanceof Bucketable bucketable) {
            bucketable.loadFromBucketTag(stack.getOrCreateTag());
            bucketable.setFromBucket(true);
        }
    }
}
