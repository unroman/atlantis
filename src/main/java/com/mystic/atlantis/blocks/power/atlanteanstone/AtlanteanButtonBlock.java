package com.mystic.atlantis.blocks.power.atlanteanstone;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static com.mystic.atlantis.blocks.power.atlanteanstone.AtlanteanPowerTorchBlock.WATERLOGGED;

public class AtlanteanButtonBlock extends ButtonBlock implements SimpleWaterloggedBlock {

    public AtlanteanButtonBlock(Properties p_273290_, BlockSetType p_273462_, int p_273212_, boolean p_272786_) {
        super(p_273290_, p_273462_, p_273212_, p_272786_);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false).setValue(WATERLOGGED, false));
    }

    @Override
    protected SoundEvent getSound(boolean isOn) {
        return isOn ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, POWERED, FACE ,WATERLOGGED);
    }
}
