package com.google.analytics.tracking.android;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class MetaModel {
    private Map<String, MetaInfo> mMetaInfos;

    public interface Formatter {
        String format(String str);
    }

    public static class MetaInfo {
        private final String mDefaultValue;
        private final Formatter mFormatter;
        private final String mUrlParam;

        public MetaInfo(String str, String str2, Formatter formatter) {
            this.mUrlParam = str;
            this.mDefaultValue = str2;
            this.mFormatter = formatter;
        }

        public String getDefaultValue() {
            return this.mDefaultValue;
        }

        public Formatter getFormatter() {
            return this.mFormatter;
        }

        @VisibleForTesting
        String getUrlParam() {
            return this.mUrlParam;
        }

        public String getUrlParam(String str) {
            String str2 = null;
            if (!str.contains("*")) {
                return this.mUrlParam;
            }
            String str3 = this.mUrlParam;
            String[] split = str.split("\\*");
            if (split.length <= 1) {
                return str2;
            }
            try {
                return str3 + Integer.parseInt(split[1]);
            } catch (NumberFormatException e) {
                Log.m10260w("Unable to parse slot for url parameter " + str3);
                return str2;
            }
        }
    }

    MetaModel() {
        this.mMetaInfos = new HashMap();
    }

    public void addField(String str, String str2, String str3, Formatter formatter) {
        this.mMetaInfos.put(str, new MetaInfo(str2, str3, formatter));
    }

    MetaInfo getMetaInfo(String str) {
        if (str.startsWith("&")) {
            return new MetaInfo(str.substring(1), null, null);
        }
        Object substring;
        if (str.contains("*")) {
            substring = str.substring(0, str.indexOf("*"));
        }
        return (MetaInfo) this.mMetaInfos.get(substring);
    }
}
