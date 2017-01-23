package com.p105c.p106a.p109b.p110a;

import com.p105c.p106a.p109b.p110a.C2095b.C2093a;
import com.p105c.p106a.p109b.p110a.C2095b.C2094b;
import com.umeng.message.util.HttpRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.c.a.b.a.d */
public class C2099d {
    private static final Object f7377c;
    private final Object f7378a;
    private File f7379b;
    private HashMap<File, C2098a> f7380d;

    /* renamed from: com.c.a.b.a.d.a */
    private static final class C2098a implements C2095b {
        private static final Object f7370f;
        private final File f7371a;
        private final File f7372b;
        private final int f7373c;
        private Map f7374d;
        private boolean f7375e;
        private WeakHashMap<C2094b, Object> f7376g;

        /* renamed from: com.c.a.b.a.d.a.a */
        public final class C2097a implements C2093a {
            final /* synthetic */ C2098a f7367a;
            private final Map<String, Object> f7368b;
            private boolean f7369c;

            public C2097a(C2098a c2098a) {
                this.f7367a = c2098a;
                this.f7368b = new HashMap();
                this.f7369c = false;
            }

            public C2093a m7842a() {
                synchronized (this) {
                    this.f7369c = true;
                }
                return this;
            }

            public C2093a m7843a(String str) {
                synchronized (this) {
                    this.f7368b.put(str, this);
                }
                return this;
            }

            public C2093a m7844a(String str, float f) {
                synchronized (this) {
                    this.f7368b.put(str, Float.valueOf(f));
                }
                return this;
            }

            public C2093a m7845a(String str, int i) {
                synchronized (this) {
                    this.f7368b.put(str, Integer.valueOf(i));
                }
                return this;
            }

            public C2093a m7846a(String str, long j) {
                synchronized (this) {
                    this.f7368b.put(str, Long.valueOf(j));
                }
                return this;
            }

            public C2093a m7847a(String str, String str2) {
                synchronized (this) {
                    this.f7368b.put(str, str2);
                }
                return this;
            }

            public C2093a m7848a(String str, boolean z) {
                synchronized (this) {
                    this.f7368b.put(str, Boolean.valueOf(z));
                }
                return this;
            }

            public boolean m7849b() {
                boolean c;
                Object obj = null;
                synchronized (C2099d.f7377c) {
                    List list;
                    if (this.f7367a.f7376g.size() > 0) {
                        obj = 1;
                    }
                    Set hashSet;
                    if (obj != null) {
                        ArrayList arrayList = new ArrayList();
                        hashSet = new HashSet(this.f7367a.f7376g.keySet());
                        list = arrayList;
                    } else {
                        hashSet = null;
                        list = null;
                    }
                    synchronized (this) {
                        if (this.f7369c) {
                            this.f7367a.f7374d.clear();
                            this.f7369c = false;
                        }
                        for (Entry entry : this.f7368b.entrySet()) {
                            String str = (String) entry.getKey();
                            C2097a value = entry.getValue();
                            if (value == this) {
                                this.f7367a.f7374d.remove(str);
                            } else {
                                this.f7367a.f7374d.put(str, value);
                            }
                            if (obj != null) {
                                list.add(str);
                            }
                        }
                        this.f7368b.clear();
                    }
                    c = this.f7367a.m7854e();
                    if (c) {
                        this.f7367a.m7858a(true);
                    }
                }
                if (obj != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        str = (String) list.get(size);
                        for (C2094b c2094b : r3) {
                            if (c2094b != null) {
                                c2094b.m7826a(this.f7367a, str);
                            }
                        }
                    }
                }
                return c;
            }
        }

        static {
            f7370f = new Object();
        }

        C2098a(File file, int i, Map map) {
            this.f7375e = false;
            this.f7371a = file;
            this.f7372b = C2099d.m7868b(file);
            this.f7373c = i;
            if (map == null) {
                map = new HashMap();
            }
            this.f7374d = map;
            this.f7376g = new WeakHashMap();
        }

        private FileOutputStream m7850a(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException e2) {
                    return null;
                }
            }
        }

        private boolean m7854e() {
            if (this.f7371a.exists()) {
                if (this.f7372b.exists()) {
                    this.f7371a.delete();
                } else if (!this.f7371a.renameTo(this.f7372b)) {
                    return false;
                }
            }
            try {
                OutputStream a = m7850a(this.f7371a);
                if (a == null) {
                    return false;
                }
                C2100e.m7875a(this.f7374d, a);
                a.close();
                this.f7372b.delete();
                return true;
            } catch (XmlPullParserException e) {
                return (!this.f7371a.exists() || this.f7371a.delete()) ? false : false;
            } catch (IOException e2) {
                if (!this.f7371a.exists()) {
                    return false;
                }
            }
        }

        public long m7855a(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.f7374d.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        public String m7856a(String str, String str2) {
            String str3;
            synchronized (this) {
                str3 = (String) this.f7374d.get(str);
                if (str3 == null) {
                    str3 = str2;
                }
            }
            return str3;
        }

        public void m7857a(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f7374d = map;
                }
            }
        }

        public void m7858a(boolean z) {
            synchronized (this) {
                this.f7375e = z;
            }
        }

        public boolean m7859a() {
            return this.f7371a != null && new File(this.f7371a.getAbsolutePath()).exists();
        }

        public Map<String, ?> m7860b() {
            Map hashMap;
            synchronized (this) {
                hashMap = new HashMap(this.f7374d);
            }
            return hashMap;
        }

        public C2093a m7861c() {
            return new C2097a(this);
        }

        public boolean m7862d() {
            boolean z;
            synchronized (this) {
                z = this.f7375e;
            }
            return z;
        }
    }

    static {
        f7377c = new Object();
    }

    public C2099d(String str) {
        this.f7378a = new Object();
        this.f7380d = new HashMap();
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f7379b = new File(str);
    }

    private File m7864a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File m7865a(String str) {
        return m7864a(m7867b(), str + ".xml");
    }

    private File m7867b() {
        File file;
        synchronized (this.f7378a) {
            file = this.f7379b;
        }
        return file;
    }

    private static File m7868b(File file) {
        return new File(file.getPath() + ".bak");
    }

    public C2095b m7869a(String str, int i) {
        C2095b c2095b;
        File a = m7865a(str);
        synchronized (f7377c) {
            c2095b = (C2098a) this.f7380d.get(a);
            if (c2095b == null || c2095b.m7862d()) {
                File b = C2099d.m7868b(a);
                if (b.exists()) {
                    a.delete();
                    b.renameTo(a);
                }
                Map map = (a.exists() && a.canRead()) ? null : null;
                if (a.exists() && a.canRead()) {
                    try {
                        InputStream fileInputStream = new FileInputStream(a);
                        map = C2100e.m7871a(fileInputStream);
                        fileInputStream.close();
                    } catch (XmlPullParserException e) {
                        try {
                            FileInputStream fileInputStream2 = new FileInputStream(a);
                            byte[] bArr = new byte[fileInputStream2.available()];
                            fileInputStream2.read(bArr);
                            String str2 = new String(bArr, 0, bArr.length, HttpRequest.f14548a);
                        } catch (FileNotFoundException e2) {
                            e2.printStackTrace();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (FileNotFoundException e22) {
                        e22.printStackTrace();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                synchronized (f7377c) {
                    if (c2095b != null) {
                        c2095b.m7857a(map);
                    } else {
                        C2098a c2098a = (C2098a) this.f7380d.get(a);
                        if (c2098a == null) {
                            c2095b = new C2098a(a, i, map);
                            this.f7380d.put(a, c2095b);
                        }
                    }
                }
            }
        }
        return c2095b;
    }
}
