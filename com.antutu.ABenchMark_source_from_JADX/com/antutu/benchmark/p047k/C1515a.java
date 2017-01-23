package com.antutu.benchmark.p047k;

import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.antutu.benchmark.k.a */
public class C1515a implements Renderer {
    public C1515a(Context context) {
    }

    public void onDrawFrame(GL10 gl10) {
        gl10.glClear(16640);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        try {
            gl10.glDisable(3024);
            gl10.glHint(3152, 4353);
            gl10.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
            C1516b.m6025d(gl10.glGetString(7936));
            C1516b.m6028e(gl10.glGetString(7937));
            C1516b.m6030f(gl10.glGetString(7938));
        } catch (Exception e) {
        }
    }
}
