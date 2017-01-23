package com.dev.system.monitor;

import android.app.Activity;
import android.app.ActivityManager;
import android.opengl.GLES10;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.Renderer;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.widget.FrameLayout;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class GPU {
    private static volatile int[] arrayBuffer;
    private static volatile IntBuffer buffer;
    private static volatile IntBuffer buffer2;
    private static Activity context;

    public static final class Egl {
        public final int EGL_ALPHA_SIZE;
        public final int EGL_BLUE_SIZE;
        public final int EGL_DEPTH_SIZE;
        public final int EGL_GREEN_SIZE;
        public final int EGL_NON_CONFORMANT_CONFIG;
        public final int EGL_RED_SIZE;
        public final int EGL_SAMPLES;
        public final int EGL_STENCIL_SIZE;

        public Egl(EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
            this.EGL_RED_SIZE = GPU.eglGetConfigAttrib(12324, egl, display, eglConfig);
            this.EGL_BLUE_SIZE = GPU.eglGetConfigAttrib(12322, egl, display, eglConfig);
            this.EGL_GREEN_SIZE = GPU.eglGetConfigAttrib(12323, egl, display, eglConfig);
            this.EGL_ALPHA_SIZE = GPU.eglGetConfigAttrib(12321, egl, display, eglConfig);
            this.EGL_DEPTH_SIZE = GPU.eglGetConfigAttrib(12325, egl, display, eglConfig);
            this.EGL_STENCIL_SIZE = GPU.eglGetConfigAttrib(12326, egl, display, eglConfig);
            this.EGL_SAMPLES = GPU.eglGetConfigAttrib(12337, egl, display, eglConfig);
            this.EGL_NON_CONFORMANT_CONFIG = GPU.eglGetConfigAttrib(12369, egl, display, eglConfig);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Egl egl = (Egl) o;
            if (this.EGL_ALPHA_SIZE != egl.EGL_ALPHA_SIZE) {
                return false;
            }
            if (this.EGL_BLUE_SIZE != egl.EGL_BLUE_SIZE) {
                return false;
            }
            if (this.EGL_DEPTH_SIZE != egl.EGL_DEPTH_SIZE) {
                return false;
            }
            if (this.EGL_GREEN_SIZE != egl.EGL_GREEN_SIZE) {
                return false;
            }
            if (this.EGL_NON_CONFORMANT_CONFIG != egl.EGL_NON_CONFORMANT_CONFIG) {
                return false;
            }
            if (this.EGL_RED_SIZE != egl.EGL_RED_SIZE) {
                return false;
            }
            if (this.EGL_SAMPLES != egl.EGL_SAMPLES) {
                return false;
            }
            if (this.EGL_STENCIL_SIZE != egl.EGL_STENCIL_SIZE) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((((((((((this.EGL_NON_CONFORMANT_CONFIG * 31) + this.EGL_SAMPLES) * 31) + this.EGL_STENCIL_SIZE) * 31) + this.EGL_DEPTH_SIZE) * 31) + this.EGL_ALPHA_SIZE) * 31) + this.EGL_BLUE_SIZE) * 31) + this.EGL_GREEN_SIZE) * 31) + this.EGL_RED_SIZE;
        }

        public String toString() {
            return "RGB" + (this.EGL_ALPHA_SIZE > 0 ? "A" : BuildConfig.VERSION_NAME) + " " + (((this.EGL_RED_SIZE + this.EGL_GREEN_SIZE) + this.EGL_BLUE_SIZE) + this.EGL_ALPHA_SIZE) + " bit" + " (" + this.EGL_RED_SIZE + BuildConfig.VERSION_NAME + this.EGL_GREEN_SIZE + this.EGL_BLUE_SIZE + BuildConfig.VERSION_NAME + (this.EGL_ALPHA_SIZE > 0 ? Integer.valueOf(this.EGL_ALPHA_SIZE) : BuildConfig.VERSION_NAME) + ")" + (this.EGL_DEPTH_SIZE > 0 ? " Depth " + this.EGL_DEPTH_SIZE + "bit" : BuildConfig.VERSION_NAME) + (this.EGL_STENCIL_SIZE > 0 ? " Stencil " + this.EGL_STENCIL_SIZE : BuildConfig.VERSION_NAME) + (this.EGL_SAMPLES > 0 ? " Samples x" + this.EGL_SAMPLES : BuildConfig.VERSION_NAME) + (this.EGL_NON_CONFORMANT_CONFIG > 0 ? " Non-Conformant" : BuildConfig.VERSION_NAME);
        }
    }

    private static final class EglChooser<T extends OpenGLInfo> implements EGLConfigChooser {
        public T info;

        private EglChooser(T info) {
            this.info = info;
        }

        public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
            int[] num_conf = new int[1];
            egl.eglGetConfigs(display, null, 0, num_conf);
            int configurations = num_conf[0];
            EGLConfig[] conf = new EGLConfig[configurations];
            egl.eglGetConfigs(display, conf, configurations, num_conf);
            EGLConfig result = null;
            for (int i = 0; i < configurations; i++) {
                result = better(result, conf[i], egl, display);
                Egl config = new Egl(egl, display, conf[i]);
                if (((config.EGL_RED_SIZE + config.EGL_BLUE_SIZE) + config.EGL_GREEN_SIZE) + config.EGL_ALPHA_SIZE >= 16) {
                    this.info.eglconfigs.add(config);
                }
            }
            return result;
        }

        private EGLConfig better(EGLConfig a, EGLConfig b, EGL10 egl, EGLDisplay display) {
            if (a == null) {
                return b;
            }
            EGLConfig result;
            int[] value = new int[1];
            egl.eglGetConfigAttrib(display, a, 12325, value);
            int depthA = value[0];
            egl.eglGetConfigAttrib(display, b, 12325, value);
            int depthB = value[0];
            if (depthA > depthB) {
                result = a;
            } else if (depthA < depthB) {
                result = b;
            } else {
                egl.eglGetConfigAttrib(display, a, 12324, value);
                int redA = value[0];
                egl.eglGetConfigAttrib(display, b, 12324, value);
                int redB = value[0];
                if (redA > redB) {
                    result = a;
                } else if (redA < redB) {
                    result = b;
                } else {
                    result = a;
                }
            }
            return result;
        }
    }

    private static class GPURenderer<T extends OpenGLInfo> implements Renderer {
        private OnCompleteCallback<T> callback;
        private GLSurfaceView glSurfaceView;
        private T result;

        /* renamed from: com.dev.system.monitor.GPU.GPURenderer.1 */
        class C01151 implements Runnable {
            C01151() {
            }

            public void run() {
                ((FrameLayout) GPU.context.findViewById(16908290)).removeView(GPURenderer.this.glSurfaceView);
                if (GPURenderer.this.callback != null) {
                    GPURenderer.this.callback.onComplete(GPURenderer.this.result);
                }
            }
        }

        protected GPURenderer(GLSurfaceView glSurfaceView, T result, OnCompleteCallback<T> callback) {
            this.result = result;
            this.glSurfaceView = glSurfaceView;
            this.callback = callback;
        }

        public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
            this.result.loadOnCreate();
            GPU.context.runOnUiThread(new C01151());
        }

        public void onSurfaceChanged(GL10 gl10, int width, int height) {
        }

        public void onDrawFrame(GL10 gl) {
        }
    }

    public static class InfoLoader<T extends OpenGLInfo> {
        private T info;
        private volatile GPURenderer<T> renderer;

        /* renamed from: com.dev.system.monitor.GPU.InfoLoader.1 */
        class C01161 implements Runnable {
            final /* synthetic */ OnCompleteCallback val$callback;

            C01161(OnCompleteCallback onCompleteCallback) {
                this.val$callback = onCompleteCallback;
            }

            public void run() {
                GLSurfaceView glView = new GLSurfaceView(GPU.context);
                glView.setEGLContextClientVersion(InfoLoader.this.info.eGLContextClientVersion);
                glView.setEGLConfigChooser(new EglChooser(null));
                glView.setZOrderOnTop(true);
                InfoLoader.this.renderer = new GPURenderer(glView, InfoLoader.this.info, this.val$callback);
                glView.setRenderer(InfoLoader.this.renderer);
                ((FrameLayout) GPU.context.findViewById(16908290)).addView(glView);
            }
        }

        protected InfoLoader(T info) {
            this.info = info;
        }

        private void loadInfo(OnCompleteCallback<T> callback) {
            GPU.context.runOnUiThread(new C01161(callback));
        }
    }

    public interface OnCompleteCallback<T> {
        void onComplete(T t);
    }

    private static abstract class OpenGLInfo {
        final int eGLContextClientVersion;
        public ArrayList<Egl> eglconfigs;

        protected abstract void loadOnCreate();

        protected OpenGLInfo(int eGLContextClientVersion) {
            this.eGLContextClientVersion = eGLContextClientVersion;
            this.eglconfigs = new ArrayList();
        }
    }

    public static class OpenGLGles10Info extends OpenGLInfo {
        public String GL_RENDERER;
        public String GL_VENDOR;
        public String GL_VERSION;

        protected OpenGLGles10Info() {
            super(1);
        }

        protected void loadOnCreate() {
            this.GL_RENDERER = GPU.glGetString(7937);
            this.GL_VERSION = GPU.glGetString(7938);
            this.GL_VENDOR = GPU.glGetString(7936);
        }

        public String toString() {
            return "OpenGLGles10Info{\nGL_RENDERER='" + this.GL_RENDERER + '\'' + '\n' + ", GL_VERSION='" + this.GL_VERSION + '\'' + '\n' + ", GL_VENDOR='" + this.GL_VENDOR + '\'' + '\n';
        }

        HashMap<String, String> getSummary() {
            HashMap<String, String> values = new HashMap();
            values.put("RENDERER", this.GL_RENDERER);
            values.put("VENDOR", this.GL_VENDOR);
            values.put("VERSION", this.GL_VERSION);
            return values;
        }
    }

    public static class OpenGLGles20Info extends OpenGLInfo {
        public String GL_RENDERER;
        public String GL_VENDOR;
        public String GL_VERSION;

        protected OpenGLGles20Info() {
            super(GPU.supportsOpenGLES2() ? 2 : 1);
        }

        protected void loadOnCreate() {
            this.GL_RENDERER = GPU.glGetString(7937);
            this.GL_VERSION = GPU.glGetString(7938);
            this.GL_VENDOR = GPU.glGetString(7936);
        }

        public String toString() {
            return "OpenGLGles20Info{GL_RENDERER='" + this.GL_RENDERER + '\'' + ", GL_VERSION='" + this.GL_VERSION + '\'' + ", GL_VENDOR='" + this.GL_VENDOR + '\'';
        }

        HashMap<String, String> getSummary() {
            HashMap<String, String> values = new HashMap();
            values.put("RENDERER", this.GL_RENDERER);
            values.put("VENDOR", this.GL_VENDOR);
            values.put("VERSION", this.GL_VERSION);
            return values;
        }
    }

    static {
        buffer = IntBuffer.allocate(1);
        buffer2 = IntBuffer.allocate(2);
        arrayBuffer = new int[1];
    }

    public GPU(Activity context) {
        context = context;
    }

    public static synchronized String glGetString(int value) {
        String glGetString;
        synchronized (GPU.class) {
            glGetString = GLES10.glGetString(value);
        }
        return glGetString;
    }

    public static synchronized int glGetIntegerv(int value) {
        int i;
        synchronized (GPU.class) {
            buffer.clear();
            GLES10.glGetIntegerv(value, buffer);
            i = buffer.get(0);
        }
        return i;
    }

    public static synchronized int[] glGetIntegerv(int value, int size) {
        int[] array;
        synchronized (GPU.class) {
            IntBuffer buffer = IntBuffer.allocate(size);
            GLES10.glGetIntegerv(value, buffer);
            array = buffer.array();
        }
        return array;
    }

    public static synchronized int[] glGetShaderPrecisionFormat(int shaderType, int precisionType) {
        int[] iArr;
        synchronized (GPU.class) {
            buffer2.clear();
            GLES20.glGetShaderPrecisionFormat(shaderType, precisionType, buffer2, buffer);
            iArr = new int[]{buffer2.get(0), buffer2.get(1), buffer.get(0)};
        }
        return iArr;
    }

    public static synchronized int eglGetConfigAttrib(int eglType, EGL10 egl, EGLDisplay display, EGLConfig eglConfig) {
        int i;
        synchronized (GPU.class) {
            egl.eglGetConfigAttrib(display, eglConfig, eglType, arrayBuffer);
            i = arrayBuffer[0];
        }
        return i;
    }

    public static boolean isVTFSupported() {
        GLES10.glGetIntegerv(35660, arrayBuffer, 0);
        if (arrayBuffer[0] != 0) {
            return true;
        }
        return false;
    }

    private static int getOpenGLVersion() {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
    }

    private static boolean supportsOpenGLES2() {
        return getOpenGLVersion() >= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION;
    }

    public void loadOpenGLGles10Info(OnCompleteCallback<OpenGLGles10Info> callback) {
        new InfoLoader(new OpenGLGles10Info()).loadInfo(callback);
    }

    public void loadOpenGLGles20Info(OnCompleteCallback<OpenGLGles20Info> callback) {
        new InfoLoader(new OpenGLGles20Info()).loadInfo(callback);
    }
}
