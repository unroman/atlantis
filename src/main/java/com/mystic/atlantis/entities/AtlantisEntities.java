package com.mystic.atlantis.entities;

import com.mystic.atlantis.util.Reference;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Reference.MODID)
public class AtlantisEntities {
    public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MODID);

    //Boats
    public static final RegistryObject<EntityType<AtlanteanBoatEntity>> ATLANTEAN_BOAT = register("atlantean_boat", EntityType.Builder.of(AtlanteanBoatEntity::new, MobCategory.MISC).sized(1.375f, 0.5625f).clientTrackingRange(10));

    public static final RegistryObject<EntityType<CrabEntity>> CRAB = register("atlantean_crab", EntityType.Builder.of(CrabEntity::new, MobCategory.WATER_CREATURE).sized(1.2f, 0.3f));

    public static final RegistryObject<EntityType<JellyfishEntity>> JELLYFISH = register("atlantean_jellyfish", EntityType.Builder.of(JellyfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.8f));

    public static final RegistryObject<EntityType<Jellyfish2Entity>> JELLYFISH2 = register("atlantean_jellyfish_2", EntityType.Builder.of(Jellyfish2Entity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.8f));

    public static final RegistryObject<EntityType<ShrimpEntity>> SHRIMP = register("atlantean_shrimp", EntityType.Builder.of(ShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.5f, 0.5f));

    public static final RegistryObject<EntityType<SubmarineEntity>> SUBMARINE = register("atlantean_submarine", EntityType.Builder.of(SubmarineEntity::new, MobCategory.MISC).sized(1.6F, 1.6F).clientTrackingRange(1));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, ()->builder.build("atlantis:" + name));
    }

    @SubscribeEvent
    public static void onAttributeModify(EntityAttributeCreationEvent event) {
        event.put(AtlantisEntities.CRAB.get(), CrabEntity.createCrabAttributes().build());
        event.put(AtlantisEntities.JELLYFISH.get(), JellyfishEntity.createJellyfishAttributes().build());
        event.put(AtlantisEntities.JELLYFISH2.get(), Jellyfish2Entity.createJellyfishAttributes().build());
        event.put(AtlantisEntities.SHRIMP.get(), ShrimpEntity.createShrimpAttributes().build());
    }

    public static void initialize(IEventBus bus) {
        ENTITIES.register(bus);
    }
}