package org.codehaus.groovy.util;

import java.util.Properties;

public class ReleaseInfo {
    private static final Properties j6;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        /*
        r0 = new java.util.Properties;
        r0.<init>();
        j6 = r0;
        r0 = org.codehaus.groovy.util.ReleaseInfo.class;
        r0 = r0.getClassLoader();
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        r0 = java.lang.ClassLoader.getSystemClassLoader();
    L_0x0013:
        r1 = r0 instanceof java.net.URLClassLoader;
        if (r1 == 0) goto L_0x0033;
    L_0x0017:
        r0 = (java.net.URLClassLoader) r0;
        r1 = "META-INF/groovy-release-info.properties";
        r0 = r0.findResource(r1);
        r1 = r0;
    L_0x0021:
        if (r1 == 0) goto L_0x0032;
    L_0x0023:
        r0 = 0;
        r0 = r1.openStream();	 Catch:{ IOException -> 0x003c, all -> 0x0041 }
        if (r0 == 0) goto L_0x002f;
    L_0x002a:
        r1 = j6;	 Catch:{ IOException -> 0x003c, all -> 0x0049 }
        r1.load(r0);	 Catch:{ IOException -> 0x003c, all -> 0x0049 }
    L_0x002f:
        org.codehaus.groovy.runtime.DefaultGroovyMethodsSupport.closeQuietly(r0);
    L_0x0032:
        return;
    L_0x0033:
        r1 = "META-INF/groovy-release-info.properties";
        r0 = r0.getResource(r1);
        r1 = r0;
        goto L_0x0021;
    L_0x003c:
        r1 = move-exception;
        org.codehaus.groovy.runtime.DefaultGroovyMethodsSupport.closeQuietly(r0);
        goto L_0x0032;
    L_0x0041:
        r1 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
    L_0x0045:
        org.codehaus.groovy.runtime.DefaultGroovyMethodsSupport.closeQuietly(r1);
        throw r0;
    L_0x0049:
        r1 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.groovy.util.ReleaseInfo.<clinit>():void");
    }
}
