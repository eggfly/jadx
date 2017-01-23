package com.miui.support.net.http;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.miui.support.text.ExtraTextUtils;
import com.miui.support.util.AppConstants;
import com.miui.support.util.IOUtils;
import com.miui.support.util.SoftReferenceSingleton;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PersistentCookieStore implements CookieStore {
    private static final SoftReferenceSingleton<PersistentCookieStore> f3454a;
    private final ConcurrentHashMap<String, Cookie> f3455b;
    private final SharedPreferences f3456c;

    /* renamed from: com.miui.support.net.http.PersistentCookieStore.1 */
    final class C04101 extends SoftReferenceSingleton<PersistentCookieStore> {
        C04101() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5152a();
        }

        protected PersistentCookieStore m5152a() {
            return new PersistentCookieStore();
        }
    }

    static {
        f3454a = new C04101();
    }

    private PersistentCookieStore() {
        int i = 0;
        this.f3456c = AppConstants.m4227a().getSharedPreferences("CookiePrefs", 0);
        this.f3455b = new ConcurrentHashMap();
        String string = this.f3456c.getString("names", null);
        if (string != null) {
            String[] split = TextUtils.split(string, ",");
            int length = split.length;
            while (i < length) {
                String str = split[i];
                String string2 = this.f3456c.getString(str, null);
                if (string2 != null) {
                    Cookie a = m5155a(string2);
                    if (a != null) {
                        this.f3455b.put(str, a);
                    }
                }
                i++;
            }
        }
        clearExpired(new Date());
    }

    public static PersistentCookieStore m5153a() {
        return (PersistentCookieStore) f3454a.get();
    }

    public void addCookie(Cookie cookie) {
        String str = cookie.getName() + cookie.getDomain();
        Editor edit;
        if (!cookie.isExpired(new Date())) {
            this.f3455b.put(str, cookie);
            edit = this.f3456c.edit();
            edit.putString("names", TextUtils.join(",", this.f3455b.keySet()));
            edit.putString(str, m5154a(cookie));
            edit.commit();
        } else if (this.f3455b.remove(str) != null) {
            edit = this.f3456c.edit();
            edit.putString("names", TextUtils.join(",", this.f3455b.keySet()));
            edit.remove(str);
            edit.commit();
        }
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.f3455b.values());
    }

    public boolean clearExpired(Date date) {
        Editor edit = this.f3456c.edit();
        boolean z = false;
        for (Entry entry : this.f3455b.entrySet()) {
            boolean z2;
            String str = (String) entry.getKey();
            if (((Cookie) entry.getValue()).isExpired(date)) {
                this.f3455b.remove(str);
                edit.remove(str);
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z) {
            edit.putString("names", TextUtils.join(",", this.f3455b.keySet()));
            edit.commit();
        }
        return z;
    }

    public void clear() {
        Editor edit = this.f3456c.edit();
        for (String remove : this.f3455b.keySet()) {
            edit.remove(remove);
        }
        edit.remove("names");
        this.f3455b.clear();
        edit.commit();
    }

    private String m5154a(Cookie cookie) {
        OutputStream objectOutputStream;
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(cookie.getName());
                objectOutputStream.writeObject(cookie.getValue());
                objectOutputStream.writeObject(cookie.getComment());
                objectOutputStream.writeObject(cookie.getDomain());
                objectOutputStream.writeObject(cookie.getExpiryDate());
                objectOutputStream.writeObject(cookie.getPath());
                objectOutputStream.writeInt(cookie.getVersion());
                objectOutputStream.writeBoolean(cookie.isSecure());
                objectOutputStream.flush();
                IOUtils.m5389a(objectOutputStream);
                return ExtraTextUtils.m5242a(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                IOUtils.m5389a(objectOutputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.m5389a(objectOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            objectOutputStream = null;
            IOUtils.m5389a(objectOutputStream);
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = null;
            th = th4;
            IOUtils.m5389a(objectOutputStream);
            throw th;
        }
    }

    private Cookie m5155a(String str) {
        InputStream objectInputStream;
        InputStream inputStream;
        Throwable th;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(ExtraTextUtils.m5244a(str)));
            try {
                BasicClientCookie basicClientCookie = new BasicClientCookie((String) objectInputStream.readObject(), (String) objectInputStream.readObject());
                basicClientCookie.setComment((String) objectInputStream.readObject());
                basicClientCookie.setDomain((String) objectInputStream.readObject());
                basicClientCookie.setExpiryDate((Date) objectInputStream.readObject());
                basicClientCookie.setPath((String) objectInputStream.readObject());
                basicClientCookie.setVersion(objectInputStream.readInt());
                basicClientCookie.setSecure(objectInputStream.readBoolean());
                IOUtils.m5387a(objectInputStream);
                return basicClientCookie;
            } catch (Exception e) {
                inputStream = objectInputStream;
                IOUtils.m5387a(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.m5387a(objectInputStream);
                throw th;
            }
        } catch (Exception e2) {
            inputStream = null;
            IOUtils.m5387a(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            IOUtils.m5387a(objectInputStream);
            throw th;
        }
    }
}
