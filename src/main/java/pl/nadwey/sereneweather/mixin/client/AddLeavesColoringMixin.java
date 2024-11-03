package pl.nadwey.sereneweather.mixin.client;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BlockColors.class)
public class AddLeavesColoringMixin {
    @Inject(method = "createDefault", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void createDefault(CallbackInfoReturnable<BlockColors> cir, BlockColors blockColors) {
        blockColors.register((blockstate, blockandtintgetter, blockpos, i) -> {
            return blockandtintgetter != null && blockpos != null ? BiomeColors.getAverageFoliageColor(blockandtintgetter, blockpos) : FoliageColor.getDefaultColor();
        }, Blocks.BIRCH_LEAVES);
    }
}
