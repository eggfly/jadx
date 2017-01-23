package com.miui.support.reflect;

import com.miui.support.internal.os.Native;

public class Constructor {
    private long mPtr;

    private Constructor() {
        this.mPtr = 0;
    }

    public static Constructor of(Class<?> cls, String str) {
        return Native.getConstructor((Class) cls, str);
    }

    public static Constructor of(Class<?> cls, Class<?>... clsArr) {
        return Native.getConstructor((Class) cls, ReflectUtils.getSignature(clsArr, Void.TYPE));
    }

    public static Constructor of(String str, String str2) {
        return Native.getConstructor(str, str2);
    }

    public static Constructor of(java.lang.reflect.Constructor<?> constructor) {
        return Native.getConstructor(constructor);
    }

    public java.lang.reflect.Constructor<?> toRefelect() {
        return Native.getReflectConstructor(this);
    }

    public Object newInstance(Object... objArr) {
        return Native.newInstance(this, objArr);
    }
}
