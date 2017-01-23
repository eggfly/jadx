package android.support.v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.media.TransportMediator;
import it.gmariotti.cardslib.library.internal.Card;

class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
            case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
            case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
            case FragmentManagerImpl.ANIM_STYLE_FADE_EXIT /*6*/:
                return true;
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                return false;
            default:
                return true;
        }
    }
}
