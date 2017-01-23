package com.github.amlcurran.showcaseview;

import android.content.Context;

class ShotStateStore {
    private static final int INVALID_SHOT_ID = -1;
    private static final String PREFS_SHOWCASE_INTERNAL = "showcase_internal";
    private final Context context;
    long shotId;

    public ShotStateStore(Context context) {
        this.shotId = -1;
        this.context = context;
    }

    boolean hasShot() {
        if (isSingleShot() && this.context.getSharedPreferences(PREFS_SHOWCASE_INTERNAL, 0).getBoolean("hasShot" + this.shotId, false)) {
            return true;
        }
        return false;
    }

    boolean isSingleShot() {
        return this.shotId != -1;
    }

    void storeShot() {
        if (isSingleShot()) {
            this.context.getSharedPreferences(PREFS_SHOWCASE_INTERNAL, 0).edit().putBoolean("hasShot" + this.shotId, true).apply();
        }
    }

    void setSingleShot(long shotId) {
        this.shotId = shotId;
    }
}
