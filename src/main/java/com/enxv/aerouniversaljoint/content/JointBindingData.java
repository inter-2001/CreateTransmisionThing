package com.enxv.aerouniversaljoint.content;

import java.util.UUID;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public final class JointBindingData {
    private JointBindingData() {
    }

    /** A joint head location: dimension, block position, and the sub-level it sits in (null for the world). */
    public record Selection(ResourceLocation dimensionId, BlockPos pos, @Nullable UUID subLevelId) {
    }
}
