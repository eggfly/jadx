package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.p121f.C2432b;
import com.qq.p035e.comm.constants.ErrorCode.NetWorkError;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;

public class NativeAdView {

    public enum Type {
        HEIGHT_100(-1, 100),
        HEIGHT_120(-1, 120),
        HEIGHT_300(-1, ErrorCode.APP_NOT_BIND),
        HEIGHT_400(-1, NetWorkError.STUB_NETWORK_ERROR);
        
        private final int f7873a;
        private final int f7874b;

        private Type(int i, int i2) {
            this.f7873a = i;
            this.f7874b = i2;
        }

        public int getHeight() {
            return this.f7874b;
        }

        public int getValue() {
            switch (this.f7874b) {
                case Constants.COMMAND_SEND_DATA /*100*/:
                    return 1;
                case 120:
                    return 2;
                case ErrorCode.APP_NOT_BIND /*300*/:
                    return 3;
                case NetWorkError.STUB_NETWORK_ERROR /*400*/:
                    return 4;
                default:
                    return -1;
            }
        }

        public int getWidth() {
            return this.f7873a;
        }
    }

    public static View render(Context context, NativeAd nativeAd, Type type) {
        return render(context, nativeAd, type, null);
    }

    public static View render(Context context, NativeAd nativeAd, Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        if (nativeAd.isNativeConfigEnabled()) {
            nativeAdViewAttributes = nativeAd.getAdViewAttributes();
        } else if (nativeAdViewAttributes == null) {
            nativeAdViewAttributes = new NativeAdViewAttributes();
        }
        nativeAd.m8620a(type);
        return new C2432b(context, nativeAd, type, nativeAdViewAttributes);
    }
}
