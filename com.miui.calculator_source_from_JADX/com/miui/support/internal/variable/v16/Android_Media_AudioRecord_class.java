package com.miui.support.internal.variable.v16;

import android.media.AudioRecord;
import com.miui.support.reflect.Method;
import com.miui.support.reflect.NoSuchMethodException;

public class Android_Media_AudioRecord_class implements com.miui.support.internal.variable.Android_Media_AudioRecord_class {
    private static final Method setParameters;

    static {
        Method method = null;
        try {
            method = Method.of(AudioRecord.class, "setParameters", "(Ljava/lang/String;)I");
        } catch (NoSuchMethodException e) {
        }
        setParameters = method;
    }

    public boolean isExtraParamSupported() {
        return setParameters != null;
    }

    public int setParameters(AudioRecord audioRecord, String str) {
        if (setParameters == null) {
            return -1;
        }
        return setParameters.invokeInt(audioRecord.getClass(), audioRecord, str);
    }
}
