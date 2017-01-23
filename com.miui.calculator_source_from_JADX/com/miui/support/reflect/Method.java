package com.miui.support.reflect;

import com.miui.support.internal.os.Native;

public class Method {
    private long mPtr;

    private Method() {
        this.mPtr = 0;
    }

    public static Method of(Class<?> cls, String str, String str2) {
        return Native.getMethod((Class) cls, str, str2);
    }

    public static Method of(Class<?> cls, String str, Class<?> cls2, Class<?>... clsArr) {
        return Native.getMethod((Class) cls, str, ReflectUtils.getSignature(clsArr, cls2));
    }

    public static Method of(String str, String str2, String str3) {
        return Native.getMethod(str, str2, str3);
    }

    public static Method of(java.lang.reflect.Method method) {
        return Native.getMethod(method);
    }

    public java.lang.reflect.Method toReflect() {
        return Native.getReflectMethod(this);
    }

    public void invoke(Class<?> cls, Object obj, Object... objArr) {
        Native.invoke(this, cls, obj, objArr);
    }

    public boolean invokeBoolean(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeBoolean(this, cls, obj, objArr);
    }

    public byte invokeByte(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeByte(this, cls, obj, objArr);
    }

    public char invokeChar(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeChar(this, cls, obj, objArr);
    }

    public short invokeShort(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeShort(this, cls, obj, objArr);
    }

    public int invokeInt(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeInt(this, cls, obj, objArr);
    }

    public long invokeLong(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeLong(this, cls, obj, objArr);
    }

    public float invokeFloat(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeFloat(this, cls, obj, objArr);
    }

    public double invokeDouble(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeDouble(this, cls, obj, objArr);
    }

    public Object invokeObject(Class<?> cls, Object obj, Object... objArr) {
        return Native.invokeObject(this, cls, obj, objArr);
    }
}
