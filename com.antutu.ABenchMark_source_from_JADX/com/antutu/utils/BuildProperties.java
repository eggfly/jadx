package com.antutu.utils;

import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class BuildProperties {
    private static BuildProperties mInstance;
    private BuildPropertiesImpl mImpl;

    private interface BuildPropertiesImpl {
        boolean containsKey(Object obj);

        String getProperty(String str);

        String getProperty(String str, String str2);
    }

    private static class BuildPropFileImpl implements BuildPropertiesImpl {
        private final Properties properties;

        public BuildPropFileImpl() {
            this.properties = new Properties();
            try {
                this.properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public boolean containsKey(Object obj) {
            return this.properties.containsKey(obj);
        }

        public String getProperty(String str) {
            return this.properties.getProperty(str);
        }

        public String getProperty(String str, String str2) {
            return this.properties.getProperty(str, str2);
        }
    }

    private static class SystemPropertiesImpl implements BuildPropertiesImpl {
        private Method mGetString;
        private Object mInvoker;

        public SystemPropertiesImpl() {
            this.mInvoker = null;
            this.mGetString = null;
            try {
                Class cls = Class.forName("android.os.SystemProperties");
                this.mInvoker = cls.newInstance();
                this.mGetString = cls.getMethod("get", new Class[]{String.class});
            } catch (Exception e) {
                this.mInvoker = null;
            }
        }

        public boolean containsKey(Object obj) {
            return getProperty((String) obj) != null;
        }

        public String getProperty(String str) {
            if (this.mInvoker == null) {
                return null;
            }
            try {
                return (String) this.mGetString.invoke(this.mInvoker, new Object[]{str});
            } catch (Exception e) {
                return null;
            }
        }

        public String getProperty(String str, String str2) {
            String property = getProperty(str);
            return property == null ? str2 : property;
        }
    }

    private BuildProperties() {
        if (VERSION.SDK_INT >= 21) {
            this.mImpl = new SystemPropertiesImpl();
        } else {
            this.mImpl = new BuildPropFileImpl();
        }
    }

    public static BuildProperties getInstance() {
        if (mInstance == null) {
            mInstance = new BuildProperties();
        }
        return mInstance;
    }

    public boolean containsKey(Object obj) {
        return this.mImpl.containsKey(obj);
    }

    public String getProperty(String str) {
        return this.mImpl.getProperty(str);
    }

    public String getProperty(String str, String str2) {
        return this.mImpl.getProperty(str, str2);
    }
}
