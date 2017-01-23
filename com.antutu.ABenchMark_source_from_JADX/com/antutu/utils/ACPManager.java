package com.antutu.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.provider.Settings.System;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.io.InputStream;

public class ACPManager {
    public static final int MAX_BUFFER = 102400;
    private static ACPManager mInst;
    private AssetManager mAssets;
    private RawData mBuffer;
    private String mPrefix;
    private InputStream mStream;

    public class RawData {
        public byte[] data;
        public int length;
    }

    static {
        mInst = new ACPManager();
    }

    private ACPManager() {
        this.mBuffer = null;
        this.mStream = null;
    }

    public static ACPManager getInstance() {
        return mInst;
    }

    public static String getSystemString(Context context, String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return System.getString(context.getContentResolver(), str);
                }
            } catch (Exception e) {
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static boolean putSystemString(Context context, String str, String str2) {
        if (str != null) {
            try {
                if (!(str.isEmpty() || str2 == null || str2.isEmpty())) {
                    return System.putString(context.getContentResolver(), str, str2);
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    public void beginStream(String str) {
        String str2 = this.mPrefix + str;
        if (this.mStream != null) {
            throw new Exception("beginStream called while another stream is still open");
        }
        try {
            this.mStream = this.mAssets.open(str2);
            if (this.mStream != null && this.mBuffer == null) {
                this.mBuffer = new RawData();
                this.mBuffer.data = new byte[MAX_BUFFER];
            }
        } catch (IOException e) {
        }
    }

    public void endStream() {
        if (this.mStream != null) {
            try {
                this.mStream.close();
            } catch (IOException e) {
            }
            this.mStream = null;
        }
    }

    public AssetManager getAssetManager() {
        return this.mAssets;
    }

    public int getFileSize(String str) {
        String str2 = this.mPrefix + str;
        int i = 0;
        InputStream inputStream = null;
        try {
            inputStream = this.mAssets.open(str2);
            i = inputStream.available();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
        } catch (IOException e2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                }
            }
        }
        return i;
    }

    public boolean hasFile(String str) {
        String str2 = this.mPrefix + str;
        boolean z = false;
        InputStream inputStream = null;
        try {
            InputStream open = this.mAssets.open(str2);
            if (open != null) {
                z = true;
            }
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e) {
                }
            }
        } catch (IOException e2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                }
            }
        }
        return z;
    }

    public RawData readStream() {
        int i = MAX_BUFFER;
        if (this.mStream == null) {
            return null;
        }
        try {
            int available = this.mStream.available();
            if (available <= MAX_BUFFER) {
                i = available;
            }
            this.mBuffer.length = this.mStream.read(this.mBuffer.data, 0, i);
        } catch (IOException e) {
        }
        return this.mBuffer;
    }

    public void setAssets(AssetManager assetManager, String str) {
        this.mAssets = assetManager;
        this.mPrefix = str;
    }
}
