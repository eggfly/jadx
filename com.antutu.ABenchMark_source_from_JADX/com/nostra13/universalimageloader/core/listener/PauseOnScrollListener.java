package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

public class PauseOnScrollListener implements OnScrollListener {
    private final OnScrollListener externalListener;
    private ImageLoader imageLoader;
    private final boolean pauseOnFling;
    private final boolean pauseOnScroll;

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z, boolean z2) {
        this(imageLoader, z, z2, null);
    }

    public PauseOnScrollListener(ImageLoader imageLoader, boolean z, boolean z2, OnScrollListener onScrollListener) {
        this.imageLoader = imageLoader;
        this.pauseOnScroll = z;
        this.pauseOnFling = z2;
        this.externalListener = onScrollListener;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.externalListener != null) {
            this.externalListener.onScroll(absListView, i, i2, i3);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                this.imageLoader.resume();
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (this.pauseOnScroll) {
                    this.imageLoader.pause();
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (this.pauseOnFling) {
                    this.imageLoader.pause();
                    break;
                }
                break;
        }
        if (this.externalListener != null) {
            this.externalListener.onScrollStateChanged(absListView, i);
        }
    }
}
