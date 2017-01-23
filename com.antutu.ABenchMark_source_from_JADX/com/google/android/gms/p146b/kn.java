package com.google.android.gms.p146b;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: com.google.android.gms.b.kn */
public final class kn {
    public static <T extends km> String m13701a(T t) {
        if (t == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            kn.m13703a(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            return "Error printing proto: " + e.getMessage();
        } catch (InvocationTargetException e2) {
            return "Error printing proto: " + e2.getMessage();
        }
    }

    private static String m13702a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    private static void m13703a(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (obj != null) {
            if (obj instanceof km) {
                int modifiers;
                int length = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer).append(kn.m13702a(str)).append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    modifiers = field.getModifiers();
                    String name = field.getName();
                    if (!("cachedSize".equals(name) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith("_") || name.endsWith("_"))) {
                        Class type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray()) {
                            kn.m13703a(name, obj2, stringBuffer, stringBuffer2);
                        } else if (type.getComponentType() == Byte.TYPE) {
                            kn.m13703a(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                            for (modifiers = 0; modifiers < length2; modifiers++) {
                                kn.m13703a(name, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        try {
                            if (((Boolean) cls.getMethod("has" + substring, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                try {
                                    kn.m13703a(substring, cls.getMethod("get" + substring, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                                } catch (NoSuchMethodException e) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length);
                    stringBuffer2.append(stringBuffer).append(">\n");
                    return;
                }
                return;
            }
            stringBuffer2.append(stringBuffer).append(kn.m13702a(str)).append(": ");
            if (obj instanceof String) {
                stringBuffer2.append("\"").append(kn.m13705b((String) obj)).append("\"");
            } else if (obj instanceof byte[]) {
                kn.m13704a((byte[]) obj, stringBuffer2);
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append("\n");
        }
    }

    private static void m13704a(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (byte b : bArr) {
            int i = b & MotionEventCompat.ACTION_MASK;
            if (i == 92 || i == 34) {
                stringBuffer.append('\\').append((char) i);
            } else if (i < 32 || i >= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                stringBuffer.append(String.format("\\%03o", new Object[]{Integer.valueOf(i)}));
            } else {
                stringBuffer.append((char) i);
            }
        }
        stringBuffer.append('\"');
    }

    private static String m13705b(String str) {
        if (!str.startsWith(HttpConstant.HTTP) && str.length() > Constants.COMMAND_HANDSHAKE) {
            str = str.substring(0, Constants.COMMAND_HANDSHAKE) + "[...]";
        }
        return kn.m13706c(str);
    }

    private static String m13706c(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
