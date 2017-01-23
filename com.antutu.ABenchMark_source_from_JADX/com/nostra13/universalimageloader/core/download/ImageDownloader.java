package com.nostra13.universalimageloader.core.download;

import anet.channel.util.HttpConstant;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.InputStream;
import java.util.Locale;

public interface ImageDownloader {

    public enum Scheme {
        HTTP(HttpConstant.HTTP),
        HTTPS(HttpConstant.HTTPS),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN(BuildConfig.FLAVOR);
        
        private String scheme;
        private String uriPrefix;

        private Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + HttpConstant.SCHEME_SPLIT;
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.scheme}));
        }

        public String wrap(String str) {
            return this.uriPrefix + str;
        }
    }

    InputStream getStream(String str, Object obj);
}
