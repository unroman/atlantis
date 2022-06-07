package com.mystic.atlantis.entities.models;

import com.mystic.atlantis.Atlantis;
import com.mystic.atlantis.entities.LeviathanEntity;
import com.mystic.atlantis.entities.ShrimpEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LeviathanEntityModel extends AnimatedGeoModel<LeviathanEntity> {
    @Override
    public ResourceLocation getModelLocation(LeviathanEntity object) {
        return Atlantis.id("geo/leviathan.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LeviathanEntity entity) {
        return Atlantis.id("textures/entity/leviathan.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LeviathanEntity animatable) {
        return Atlantis.id("animations/leviathan.animation.json");
    }
}