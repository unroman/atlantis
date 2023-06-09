package com.mystic.atlantis.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class AtlantisGroupInit {
    public static final CreativeModeTab MAIN = CreativeModeTab.builder().withBackgroundLocation(new ResourceLocation("atlantis", "textures/gui/tab_atlantis.png")).withTabsImage(BlockInit.CHISELED_GOLDEN_AQUAMARINE.getId()).m_257609_("atlantis.general").m_257652_();

    public static final CreativeModeTab GLYPH = CreativeModeTab.builder().withTabsImage(BlockInit.LINGUISTIC_BLOCK.getId()).withBackgroundLocation(new ResourceLocation("atlantis", "textures/gui/tab_atlantis.png")).m_257609_( "atlantis.glyph").m_257652_();

    public static void init(){
    }
}
