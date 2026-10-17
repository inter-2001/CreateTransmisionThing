package com.enxv.aerouniversaljoint.content;

import com.enxv.aerouniversaljoint.AeroUniversalJointConfig;

public enum JointVariant {
    ANDESITE,
    BRASS;

    /** Distance off rest length (blocks) at which an andesite link reaches full pull stiffness. */
    private static final double ANDESITE_FULL_FORCE_OFFSET = 2.0D;

    public double getLinkRange() {
        return this == ANDESITE
                ? AeroUniversalJointConfig.andesiteJointLinkRange()
                : AeroUniversalJointConfig.brassJointLinkRange();
    }

    public double getSoftRange() {
        return this == ANDESITE
                ? AeroUniversalJointConfig.andesiteJointSoftRange()
                : AeroUniversalJointConfig.brassJointSoftRange();
    }

    public double getDisconnectRange() {
        return this == ANDESITE
                ? AeroUniversalJointConfig.andesiteJointDisconnectRange()
                : AeroUniversalJointConfig.brassJointDisconnectRange();
    }

    public double getMaxForceRange() {
        return this == ANDESITE ? ANDESITE_FULL_FORCE_OFFSET : this.getDisconnectRange();
    }

    public boolean isWithinLinkRange(double distanceSquared) {
        double configuredLinkRange = this.getLinkRange();
        return distanceSquared <= configuredLinkRange * configuredLinkRange;
    }

    public boolean isBeyondDisconnectRange(double distanceSquared) {
        double configuredDisconnectRange = this.getDisconnectRange();
        return distanceSquared > configuredDisconnectRange * configuredDisconnectRange;
    }

    public String getSerializedName() {
        return this.name().toLowerCase(java.util.Locale.ROOT);
    }

    public static JointVariant byName(String name) {
        for (JointVariant variant : values()) {
            if (variant.getSerializedName().equals(name)) {
                return variant;
            }
        }
        return null;
    }
}
