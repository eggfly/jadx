package com.baidu.mobads.p080j;

import android.content.Context;
import com.baidu.mobads.aj;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.p088c.C2014d;
import com.baidu.mobads.p090e.C1931a;

/* renamed from: com.baidu.mobads.j.m */
public class C1991m {
    private static final C1991m f6938o;
    private C1986g f6939a;
    private C1900l f6940b;
    private IBase64 f6941c;
    private IXAdLogger f6942d;
    private IXAdViewUtils f6943e;
    private IXAdBitmapUtils f6944f;
    private IXAdURIUitls f6945g;
    private IXAdIOUtils f6946h;
    private IXAdPackageUtils f6947i;
    private IXAdActivityUtils f6948j;
    private IXAdSystemUtils f6949k;
    private C1982d f6950l;
    private IXAdConstants f6951m;
    private IXAdErrorCode f6952n;
    private Context f6953p;
    private IXAdContainerFactory f6954q;

    static {
        f6938o = new C1991m();
    }

    private C1991m() {
        this.f6941c = new C1979a();
        this.f6942d = C1989j.m7430a();
        this.f6940b = new C1900l();
        this.f6943e = new C1997s();
        this.f6944f = new C1981c();
        this.f6945g = new C1996r();
        this.f6949k = new C1992n();
        this.f6950l = new C1982d();
        this.f6946h = new C1988i();
        this.f6947i = new C1990k();
        this.f6948j = new C1980b();
        this.f6951m = new aj();
        this.f6952n = new C1931a(this.f6942d);
    }

    public static C1991m m7449a() {
        return f6938o;
    }

    public void m7450a(Context context) {
        if (this.f6953p == null) {
            this.f6953p = context;
        }
        this.f6939a = new C1986g(this.f6953p);
    }

    public void m7451a(IXAdContainerFactory iXAdContainerFactory) {
        if (iXAdContainerFactory == null) {
            this.f6954q = iXAdContainerFactory;
        }
    }

    public C1986g m7452b() {
        return this.f6939a;
    }

    public IOAdDownloaderManager m7453b(Context context) {
        return C2014d.m7517a(context);
    }

    public IXAdContainerFactory m7454c() {
        return this.f6954q;
    }

    public Context m7455d() {
        return this.f6953p;
    }

    public IBase64 m7456e() {
        return this.f6941c;
    }

    public IXAdLogger m7457f() {
        return this.f6942d;
    }

    public C1900l m7458g() {
        return this.f6940b;
    }

    public IXAdBitmapUtils m7459h() {
        return this.f6944f;
    }

    public IXAdURIUitls m7460i() {
        return this.f6945g;
    }

    public IXAdViewUtils m7461j() {
        return this.f6943e;
    }

    public IXAdIOUtils m7462k() {
        return this.f6946h;
    }

    public IXAdPackageUtils m7463l() {
        return this.f6947i;
    }

    public C1982d m7464m() {
        return this.f6950l;
    }

    public IXAdSystemUtils m7465n() {
        return this.f6949k;
    }

    public IXAdActivityUtils m7466o() {
        return this.f6948j;
    }

    public IXAdConstants m7467p() {
        return this.f6951m;
    }

    public IXAdErrorCode m7468q() {
        return this.f6952n;
    }
}
