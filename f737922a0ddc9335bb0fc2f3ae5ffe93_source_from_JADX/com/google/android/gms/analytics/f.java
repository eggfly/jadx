package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class f implements a {
    private final TreeSet<String> j6;

    public f(Context context, Collection<String> collection) {
        this.j6 = new TreeSet();
        j6(context, (Collection) collection);
    }

    protected StackTraceElement DW(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator it = this.j6.iterator();
            while (it.hasNext()) {
                if (className.startsWith((String) it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    public String j6(String str, Throwable th) {
        return j6(j6(th), DW(j6(th)), str);
    }

    protected String j6(Throwable th, StackTraceElement stackTraceElement, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] split = stackTraceElement.getClassName().split("\\.");
            String str2 = "unknown";
            if (split != null && split.length > 0) {
                str2 = split[split.length - 1];
            }
            stringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{str2, stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())}));
        }
        if (str != null) {
            stringBuilder.append(String.format(" {%s}", new Object[]{str}));
        }
        return stringBuilder.toString();
    }

    protected Throwable j6(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public void j6(Context context, Collection<String> collection) {
        this.j6.clear();
        Set<String> hashSet = new HashSet();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            try {
                String packageName = context.getApplicationContext().getPackageName();
                this.j6.add(packageName);
                ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 1).activities;
                if (activityInfoArr != null) {
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        hashSet.add(activityInfo.packageName);
                    }
                }
            } catch (NameNotFoundException e) {
                com.google.android.gms.analytics.internal.f.j6("No package found");
            }
        }
        for (String packageName2 : hashSet) {
            Iterator it = this.j6.iterator();
            Object obj = 1;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (packageName2.startsWith(str)) {
                    obj = null;
                } else {
                    if (str.startsWith(packageName2)) {
                        this.j6.remove(str);
                    }
                    if (obj != null) {
                        this.j6.add(packageName2);
                    }
                }
            }
            if (obj != null) {
                this.j6.add(packageName2);
            }
        }
    }
}
