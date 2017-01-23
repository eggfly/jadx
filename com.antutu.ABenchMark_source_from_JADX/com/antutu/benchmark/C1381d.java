package com.antutu.benchmark;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Size;
import com.antutu.benchmark.C1372c.C1343a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.d */
public class C1381d {
    public static List<C1343a> m5461a(Context context) {
        List<C1343a> arrayList = new ArrayList();
        try {
            if (VERSION.SDK_INT >= 21) {
                CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
                for (String cameraCharacteristics : cameraManager.getCameraIdList()) {
                    CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics(cameraCharacteristics);
                    C1343a c1343a = new C1343a();
                    Integer num = (Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING);
                    if (!(num == null || num.intValue() == 2)) {
                        if (num.intValue() == 0) {
                            c1343a.m5404a(true);
                        }
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics2.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                        if (streamConfigurationMap != null) {
                            Size[] outputSizes = streamConfigurationMap.getOutputSizes(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
                            if (outputSizes.length > 0) {
                                for (Size size : outputSizes) {
                                    int width = size.getWidth() * size.getHeight();
                                    if (c1343a.m5407c() < width) {
                                        c1343a.m5408c(width);
                                        c1343a.m5403a(size.getWidth());
                                        c1343a.m5406b(size.getHeight());
                                    }
                                }
                                arrayList.add(c1343a);
                            }
                            arrayList.add(c1343a);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }
}
