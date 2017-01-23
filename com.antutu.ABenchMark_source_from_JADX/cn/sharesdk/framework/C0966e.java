package cn.sharesdk.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import cn.sharesdk.framework.p026b.C0948a;
import cn.sharesdk.framework.p026b.C0959d;
import cn.sharesdk.framework.p026b.p028b.C0949c;
import cn.sharesdk.framework.p026b.p028b.C0950a;
import cn.sharesdk.framework.p026b.p028b.C0952d;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.utils.C4021R;
import com.mob.tools.utils.ReflectHelper;
import dalvik.system.DexFile;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* renamed from: cn.sharesdk.framework.e */
public class C0966e {
    private static boolean f3310a;
    private Context f3311b;
    private String f3312c;

    /* renamed from: cn.sharesdk.framework.e.1 */
    class C09651 implements Comparator<Platform> {
        final /* synthetic */ C0966e f3309a;

        C09651(C0966e c0966e) {
            this.f3309a = c0966e;
        }

        public int m4297a(Platform platform, Platform platform2) {
            return platform.getSortId() != platform2.getSortId() ? platform.getSortId() - platform2.getSortId() : platform.getPlatformId() - platform2.getPlatformId();
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4297a((Platform) obj, (Platform) obj2);
        }
    }

    static {
        f3310a = true;
    }

    public C0966e(Context context, String str) {
        this.f3311b = context;
        this.f3312c = str;
    }

    private ArrayList<Platform> m4298a(PackageInfo packageInfo) {
        ArrayList<Platform> arrayList = new ArrayList();
        try {
            DexFile dexFile = new DexFile(packageInfo.applicationInfo.sourceDir);
            Enumeration entries = dexFile.entries();
            dexFile.close();
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return null;
        }
        while (entries != null && entries.hasMoreElements()) {
            String str = (String) entries.nextElement();
            if (str.startsWith("cn.sharesdk") && !str.contains("$")) {
                try {
                    Class cls = Class.forName(str);
                    if (!(cls == null || !Platform.class.isAssignableFrom(cls) || CustomPlatform.class.isAssignableFrom(cls))) {
                        Constructor constructor = cls.getConstructor(new Class[]{Context.class});
                        constructor.setAccessible(true);
                        arrayList.add((Platform) constructor.newInstance(new Object[]{this.f3311b}));
                    }
                } catch (Throwable th2) {
                    C0979d.m4390a().m4388w(th2);
                }
            }
        }
        return arrayList;
    }

    private PackageInfo m4299d() {
        try {
            PackageManager packageManager = this.f3311b.getPackageManager();
            String packageName = this.f3311b.getPackageName();
            for (PackageInfo packageInfo : (List) ReflectHelper.invokeInstanceMethod(packageManager, "getInstalledPackages", Integer.valueOf(SpdyProtocol.SLIGHTSSL_1_RTT_MODE))) {
                if (packageName.equals(packageInfo.packageName)) {
                    return packageInfo;
                }
            }
            return null;
        } catch (Throwable th) {
            C0979d.m4390a().m4388w(th);
            return null;
        }
    }

    private ArrayList<Platform> m4300e() {
        String[] strArr = new String[]{"cn.sharesdk.douban.Douban", "cn.sharesdk.evernote.Evernote", "cn.sharesdk.facebook.Facebook", "cn.sharesdk.renren.Renren", "cn.sharesdk.sina.weibo.SinaWeibo", "cn.sharesdk.kaixin.KaiXin", "cn.sharesdk.linkedin.LinkedIn", "cn.sharesdk.system.email.Email", "cn.sharesdk.system.text.ShortMessage", "cn.sharesdk.tencent.qq.QQ", "cn.sharesdk.tencent.qzone.QZone", "cn.sharesdk.tencent.weibo.TencentWeibo", "cn.sharesdk.twitter.Twitter", "cn.sharesdk.wechat.friends.Wechat", "cn.sharesdk.wechat.moments.WechatMoments", "cn.sharesdk.wechat.favorite.WechatFavorite", "cn.sharesdk.youdao.YouDao", "cn.sharesdk.google.GooglePlus", "cn.sharesdk.foursquare.FourSquare", "cn.sharesdk.pinterest.Pinterest", "cn.sharesdk.flickr.Flickr", "cn.sharesdk.tumblr.Tumblr", "cn.sharesdk.dropbox.Dropbox", "cn.sharesdk.vkontakte.VKontakte", "cn.sharesdk.instagram.Instagram", "cn.sharesdk.yixin.friends.Yixin", "cn.sharesdk.yixin.moments.YixinMoments", "cn.sharesdk.mingdao.Mingdao", "cn.sharesdk.line.Line", "cn.sharesdk.kakao.story.KakaoStory", "cn.sharesdk.kakao.talk.KakaoTalk", "cn.sharesdk.whatsapp.WhatsApp", "cn.sharesdk.pocket.Pocket", "cn.sharesdk.instapaper.Instapaper", "cn.sharesdk.facebookmessenger.FacebookMessenger", "cn.sharesdk.alipay.friends.Alipay", "cn.sharesdk.alipay.moments.AlipayMoments"};
        ArrayList<Platform> arrayList = new ArrayList();
        for (String cls : strArr) {
            try {
                Constructor constructor = Class.forName(cls).getConstructor(new Class[]{Context.class});
                constructor.setAccessible(true);
                arrayList.add((Platform) constructor.newInstance(new Object[]{this.f3311b}));
            } catch (Throwable th) {
                C0979d.m4390a().m4376d(th);
            }
        }
        return arrayList;
    }

    public String m4301a(int i, String str, HashMap<Integer, HashMap<String, Object>> hashMap) {
        HashMap hashMap2 = (HashMap) hashMap.get(Integer.valueOf(i));
        if (hashMap2 == null) {
            return null;
        }
        Object obj = hashMap2.get(str);
        return obj == null ? null : String.valueOf(obj);
    }

    public String m4302a(Bitmap bitmap) {
        return C0948a.m4158a(this.f3311b, this.f3312c).m4167a(bitmap);
    }

    public String m4303a(String str) {
        return C0948a.m4158a(this.f3311b, this.f3312c).m4168a(str);
    }

    public String m4304a(String str, boolean z, int i, String str2) {
        return C0948a.m4158a(this.f3311b, this.f3312c).m4169a(str, i, z, str2);
    }

    public ArrayList<Platform> m4305a() {
        ArrayList e;
        if (f3310a) {
            e = m4300e();
        } else {
            PackageInfo d = m4299d();
            if (d == null) {
                return null;
            }
            e = m4298a(d);
        }
        m4311a(e);
        return e;
    }

    public void m4306a(int i, int i2, HashMap<Integer, HashMap<String, Object>> hashMap) {
        hashMap.put(Integer.valueOf(i2), (HashMap) hashMap.get(Integer.valueOf(i)));
    }

    public void m4307a(int i, Platform platform) {
        C0949c c0952d = new C0952d();
        switch (i) {
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                c0952d.f3242a = "SHARESDK_ENTER_SHAREMENU";
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                c0952d.f3242a = "SHARESDK_CANCEL_SHAREMENU";
                break;
            case SpdyProtocol.PUBKEY_SEQ_ACCS /*3*/:
                c0952d.f3242a = "SHARESDK_EDIT_SHARE";
                break;
            case SpdyProtocol.QUIC /*4*/:
                c0952d.f3242a = "SHARESDK_FAILED_SHARE";
                break;
            case SpdyProtocol.PUBKEY_SEQ_AE /*5*/:
                c0952d.f3242a = "SHARESDK_CANCEL_SHARE";
                break;
        }
        if (platform != null) {
            c0952d.f3243b = platform.getPlatformId();
        }
        C0959d a = C0959d.m4258a(this.f3311b, this.f3312c);
        if (a != null) {
            a.m4265a(c0952d);
        }
    }

    public void m4308a(Handler handler, boolean z, int i) {
        C0959d a = C0959d.m4258a(this.f3311b, this.f3312c);
        if (a != null) {
            a.m4264a(handler);
            a.m4266a(z);
            a.m4263a(i);
            a.startThread();
        }
    }

    public void m4309a(C0970f c0970f) {
    }

    public void m4310a(String str, int i) {
        C0959d a = C0959d.m4258a(this.f3311b, this.f3312c);
        if (a != null) {
            C0949c c0950a = new C0950a();
            c0950a.f3233b = str;
            c0950a.f3232a = i;
            a.m4265a(c0950a);
        }
    }

    public void m4311a(ArrayList<Platform> arrayList) {
        if (arrayList != null) {
            Collections.sort(arrayList, new C09651(this));
        }
    }

    public boolean m4312a(HashMap<String, Object> hashMap, HashMap<Integer, HashMap<String, Object>> hashMap2) {
        if (hashMap == null || hashMap.size() <= 0) {
            return false;
        }
        ArrayList arrayList = (ArrayList) hashMap.get("fakelist");
        if (arrayList == null) {
            return false;
        }
        EventRecorder.addBegin("ShareSDK", "parseDevInfo");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HashMap hashMap3 = (HashMap) it.next();
            if (hashMap3 != null) {
                int parseInt;
                try {
                    parseInt = C4021R.parseInt(String.valueOf(hashMap3.get("snsplat")));
                } catch (Throwable th) {
                    C0979d.m4390a().m4388w(th);
                    parseInt = -1;
                }
                if (parseInt != -1) {
                    hashMap2.put(Integer.valueOf(parseInt), hashMap3);
                }
            }
        }
        EventRecorder.addEnd("ShareSDK", "parseDevInfo");
        return true;
    }

    public void m4313b() {
        C0959d a = C0959d.m4258a(this.f3311b, this.f3312c);
        if (a != null) {
            a.stopThread();
        }
    }

    public String m4314c() {
        return "2.7.10";
    }
}
