package com.aide.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class s {
    public static Object j6(String str, Object obj) {
        if (str == null) {
            return obj;
        }
        try {
            Object readObject = new ObjectInputStream(new ByteArrayInputStream(g.j6(str))).readObject();
            if (readObject != null) {
                return readObject;
            }
            return obj;
        } catch (Exception e) {
            return obj;
        }
    }

    public static String j6(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return new String(g.j6(byteArrayOutputStream.toByteArray()));
        } catch (Exception e) {
            return null;
        }
    }
}
