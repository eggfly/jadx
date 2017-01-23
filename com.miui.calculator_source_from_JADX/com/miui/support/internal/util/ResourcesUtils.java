package com.miui.support.internal.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ResourcesUtils {
    private static Method f2569a;
    private static Constructor<AssetManager> f2570b;

    static {
        try {
            f2569a = AssetManager.class.getMethod("addAssetPath", new Class[]{String.class});
            f2570b = AssetManager.class.getConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private ResourcesUtils() {
    }

    public static Resources m4242a(String... strArr) {
        return m4241a(null, strArr);
    }

    public static Resources m4241a(Resources resources, String... strArr) {
        AssetManager assetManager;
        InstantiationException instantiationException;
        IllegalAccessException illegalAccessException;
        InvocationTargetException invocationTargetException;
        try {
            AssetManager assetManager2 = (AssetManager) f2570b.newInstance(new Object[0]);
            try {
                for (Object obj : strArr) {
                    f2569a.invoke(assetManager2, new Object[]{obj});
                }
                assetManager = assetManager2;
            } catch (InstantiationException e) {
                InstantiationException instantiationException2 = e;
                assetManager = assetManager2;
                instantiationException = instantiationException2;
                instantiationException.printStackTrace();
                if (resources == null) {
                    return new Resources(assetManager, null, null);
                }
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            } catch (IllegalAccessException e2) {
                IllegalAccessException illegalAccessException2 = e2;
                assetManager = assetManager2;
                illegalAccessException = illegalAccessException2;
                illegalAccessException.printStackTrace();
                if (resources == null) {
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
                return new Resources(assetManager, null, null);
            } catch (InvocationTargetException e3) {
                InvocationTargetException invocationTargetException2 = e3;
                assetManager = assetManager2;
                invocationTargetException = invocationTargetException2;
                invocationTargetException.printStackTrace();
                if (resources == null) {
                    return new Resources(assetManager, null, null);
                }
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        } catch (InstantiationException e4) {
            instantiationException = e4;
            assetManager = null;
            instantiationException.printStackTrace();
            if (resources == null) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
            return new Resources(assetManager, null, null);
        } catch (IllegalAccessException e5) {
            illegalAccessException = e5;
            assetManager = null;
            illegalAccessException.printStackTrace();
            if (resources == null) {
                return new Resources(assetManager, null, null);
            }
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (InvocationTargetException e6) {
            invocationTargetException = e6;
            assetManager = null;
            invocationTargetException.printStackTrace();
            if (resources == null) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
            return new Resources(assetManager, null, null);
        }
        if (resources == null) {
            return new Resources(assetManager, null, null);
        }
        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
    }
}
