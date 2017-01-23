package com.antutu.benchmark;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.widget.Toast;
import com.antutu.utils.PointMark;
import com.antutu.utils.TrackListener;
import java.util.ArrayList;

public class TrackService extends Service implements TrackListener {
    private void m4839a() {
        Process.killProcess(Process.myPid());
    }

    public void exeFunction() {
        Toast.makeText(this, "service Stop", 0).show();
        m4839a();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        PointMark.getInstance(ABenchmarkApplication.getContext()).setKeyUrl("http://certinfo.antutu.net/i/api/member/secret");
        PointMark.getInstance(ABenchmarkApplication.getContext()).setUrl("http://certinfo.antutu.net/i/api/soft/activity");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            Bundle extras = intent.getExtras();
            ArrayList stringArrayList = extras.getStringArrayList(PointMark.TOTAL_TAG);
            PointMark.getInstance(this).setParamsStr(extras.getString(PointMark.PARAMS_VALUE));
            PointMark.getInstance(this).setTotalTag(stringArrayList);
            PointMark.getInstance(this).setTrackListener(this);
            PointMark.getInstance(this).track();
        } catch (Exception e) {
            m4839a();
        }
        return 2;
    }

    public boolean trackDataListener(boolean z) {
        if (!z) {
            m4839a();
        }
        Toast.makeText(this, "data send success", 0).show();
        return z;
    }

    public boolean trackKeyListener(boolean z) {
        if (!z) {
            Toast.makeText(this, "request key failed", 0).show();
            m4839a();
        }
        return z;
    }
}
