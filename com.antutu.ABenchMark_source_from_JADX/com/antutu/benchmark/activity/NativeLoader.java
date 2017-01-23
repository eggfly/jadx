package com.antutu.benchmark.activity;

import android.app.NativeActivity;
import android.content.res.AssetManager;
import android.os.Bundle;
import com.antutu.utils.ACPManager;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.IOException;
import java.io.InputStream;

public class NativeLoader extends NativeActivity {
    private AssetManager f4352a;
    private RawData f4353b;
    private InputStream f4354c;

    public class RawData {
        final /* synthetic */ NativeLoader f4351a;
        public byte[] data;
        public int length;

        public RawData(NativeLoader nativeLoader) {
            this.f4351a = nativeLoader;
        }
    }

    public NativeLoader() {
        this.f4353b = null;
        this.f4354c = null;
    }

    public void beginStream(String str) {
        if (this.f4354c != null) {
            throw new Exception("beginStream called while another stream is still open");
        }
        try {
            this.f4354c = this.f4352a.open(str);
            if (this.f4354c != null && this.f4353b == null) {
                this.f4353b = new RawData(this);
                this.f4353b.data = new byte[ACPManager.MAX_BUFFER];
            }
        } catch (IOException e) {
        }
    }

    public void endStream() {
        if (this.f4354c != null) {
            try {
                this.f4354c.close();
            } catch (IOException e) {
            }
            this.f4354c = null;
        }
    }

    public int getFileSize(String str) {
        int i = 0;
        InputStream inputStream = null;
        try {
            inputStream = this.f4352a.open(str);
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

    public String getInternalDataPath() {
        return getFilesDir().getAbsolutePath() + BuildConfig.FLAVOR;
    }

    public boolean hasFile(String str) {
        boolean z = false;
        InputStream inputStream = null;
        try {
            inputStream = this.f4352a.open(str);
            if (inputStream != null) {
                z = true;
            }
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
        return z;
    }

    protected void onCreate(Bundle bundle) {
        this.f4352a = getAssets();
        super.onCreate(bundle);
    }

    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
        MobclickAgent.onPause(this);
    }

    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName());
        MobclickAgent.onResume(this);
    }

    protected void onStop() {
        super.onStop();
        finish();
        System.exit(0);
    }

    public RawData readStream() {
        int i = ACPManager.MAX_BUFFER;
        if (this.f4354c == null) {
            return null;
        }
        try {
            int available = this.f4354c.available();
            if (available <= ACPManager.MAX_BUFFER) {
                i = available;
            }
            this.f4353b.length = this.f4354c.read(this.f4353b.data, 0, i);
        } catch (IOException e) {
        }
        return this.f4353b;
    }
}
