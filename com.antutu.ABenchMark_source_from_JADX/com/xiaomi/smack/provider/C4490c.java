package com.xiaomi.smack.provider;

import com.umeng.message.util.HttpRequest;
import com.xiaomi.smack.packet.C4478e;
import com.xiaomi.smack.packet.C4481b;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.smack.provider.c */
public class C4490c {
    private static C4490c f15451a;
    private Map<String, Object> f15452b;
    private Map<String, Object> f15453c;

    private C4490c() {
        this.f15452b = new ConcurrentHashMap();
        this.f15453c = new ConcurrentHashMap();
        m18628b();
    }

    public static synchronized C4490c m18623a() {
        C4490c c4490c;
        synchronized (C4490c.class) {
            if (f15451a == null) {
                f15451a = new C4490c();
            }
            c4490c = f15451a;
        }
        return c4490c;
    }

    private String m18624b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(str).append("/>");
        if (str != null) {
            stringBuilder.append("<").append(str2).append("/>");
        }
        return stringBuilder.toString();
    }

    private ClassLoader[] m18625c() {
        int i = 0;
        ClassLoader[] classLoaderArr = new ClassLoader[]{C4490c.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        List arrayList = new ArrayList();
        int length = classLoaderArr.length;
        while (i < length) {
            Object obj = classLoaderArr[i];
            if (obj != null) {
                arrayList.add(obj);
            }
            i++;
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public Object m18626a(String str, String str2) {
        return this.f15452b.get(m18624b(str, str2));
    }

    public void m18627a(String str, String str2, Object obj) {
        if ((obj instanceof C4408b) || (obj instanceof Class)) {
            this.f15452b.put(m18624b(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    protected void m18628b() {
        try {
            for (ClassLoader resources : m18625c()) {
                Enumeration resources2 = resources.getResources("META-INF/smack.providers");
                while (resources2.hasMoreElements()) {
                    InputStream inputStream = null;
                    inputStream = ((URL) resources2.nextElement()).openStream();
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                    newPullParser.setInput(inputStream, HttpRequest.f14548a);
                    int eventType = newPullParser.getEventType();
                    do {
                        if (eventType == 2) {
                            String nextText;
                            String nextText2;
                            String nextText3;
                            Class cls;
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                nextText3 = newPullParser.nextText();
                                nextText = m18624b(nextText, nextText2);
                                if (!this.f15453c.containsKey(nextText)) {
                                    try {
                                        cls = Class.forName(nextText3);
                                        if (C4489a.class.isAssignableFrom(cls)) {
                                            this.f15453c.put(nextText, cls.newInstance());
                                        } else if (C4481b.class.isAssignableFrom(cls)) {
                                            this.f15453c.put(nextText, cls);
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    } catch (Throwable th) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                nextText3 = newPullParser.nextText();
                                nextText = m18624b(nextText, nextText2);
                                if (!this.f15452b.containsKey(nextText)) {
                                    try {
                                        cls = Class.forName(nextText3);
                                        if (C4408b.class.isAssignableFrom(cls)) {
                                            this.f15452b.put(nextText, cls.newInstance());
                                        } else if (C4478e.class.isAssignableFrom(cls)) {
                                            this.f15452b.put(nextText, cls);
                                        }
                                    } catch (ClassNotFoundException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
