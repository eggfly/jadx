package android.support.v4.media;

import android.media.Rating;

class RatingCompatApi21 {
    RatingCompatApi21() {
    }

    public static boolean m679a(Object obj) {
        return ((Rating) obj).isRated();
    }

    public static int m680b(Object obj) {
        return ((Rating) obj).getRatingStyle();
    }

    public static boolean m681c(Object obj) {
        return ((Rating) obj).hasHeart();
    }

    public static boolean m682d(Object obj) {
        return ((Rating) obj).isThumbUp();
    }

    public static float m683e(Object obj) {
        return ((Rating) obj).getStarRating();
    }

    public static float m684f(Object obj) {
        return ((Rating) obj).getPercentRating();
    }
}
