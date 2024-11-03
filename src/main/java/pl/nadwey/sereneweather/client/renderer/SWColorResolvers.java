package pl.nadwey.sereneweather.client.renderer;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.ColorResolver;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import pl.nadwey.sereneweather.SereneWeather;
import pl.nadwey.sereneweather.util.Color;

@EventBusSubscriber(modid = SereneWeather.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SWColorResolvers {
    @SubscribeEvent
    public static void setupClient(FMLClientSetupEvent event) {
        ColorResolver old = BiomeColors.FOLIAGE_COLOR_RESOLVER;

        BiomeColors.FOLIAGE_COLOR_RESOLVER = (biome, x, z) -> {
            int oldColor = old.getColor(biome, x, z);

            return new Color(oldColor).interpolate(new Color(255, 255, 255), 0.8f).toARGB();
        };
    }
}