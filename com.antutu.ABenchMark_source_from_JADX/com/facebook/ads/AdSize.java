package com.facebook.ads;

public enum AdSize {
    BANNER_320_50(320, 50),
    INTERSTITIAL(0, 0),
    BANNER_HEIGHT_50(-1, 50),
    BANNER_HEIGHT_90(-1, 90),
    RECTANGLE_HEIGHT_250(-1, 250);
    
    private final int f7765a;
    private final int f7766b;

    private AdSize(int i, int i2) {
        this.f7765a = i;
        this.f7766b = i2;
    }

    private static boolean m8516a(AdSize adSize, int i, int i2) {
        return adSize != null && adSize.f7765a == i && adSize.f7766b == i2;
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        for (AdSize adSize : (AdSize[]) AdSize.class.getEnumConstants()) {
            if (m8516a(adSize, i, i2)) {
                return adSize;
            }
        }
        return null;
    }

    public int getHeight() {
        return this.f7766b;
    }

    public int getWidth() {
        return this.f7765a;
    }
}
