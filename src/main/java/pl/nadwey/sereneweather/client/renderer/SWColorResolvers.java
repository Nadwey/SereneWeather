package pl.nadwey.sereneweather.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import pl.nadwey.sereneweather.SereneWeather;
import pl.nadwey.sereneweather.season.SWSubSeason;
import pl.nadwey.sereneweather.util.Color;
import sereneseasons.api.season.ISeasonState;
import sereneseasons.api.season.SeasonHelper;

@EventBusSubscriber(modid = SereneWeather.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SWColorResolvers {
    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        ColorResolver oldFoliageColorResolver = BiomeColors.FOLIAGE_COLOR_RESOLVER;

        BiomeColors.FOLIAGE_COLOR_RESOLVER = (biome, x, z) -> {
            int oldColor = oldFoliageColorResolver.getColor(biome, x, z);

            Level level = Minecraft.getInstance().level;
            ISeasonState seasonState = SeasonHelper.getSeasonState(level);

            return new Color(oldColor).interpolate(SWSubSeason.getByOriginalSubSeason(seasonState.getSubSeason()).getFoliageColor(), 1.0f).toARGB();
        };

        ColorResolver oldGrassColorResolver = BiomeColors.GRASS_COLOR_RESOLVER;

        BiomeColors.GRASS_COLOR_RESOLVER = (biome, x, z) -> {
            int oldColor = oldGrassColorResolver.getColor(biome, x, z);

            return new Color(oldColor).interpolate(new Color(255, 255, 255), 1.0f).toARGB();
        };
    }
}
