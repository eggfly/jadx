package com.antutu.benchmark.p036a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1521a.C1518a;
import com.antutu.benchmark.view.SuggestAppSelectView;
import com.antutu.benchmark.view.SuggestAppSelectView.C1178a;
import com.antutu.utils.cache.ImageControl;
import com.antutu.utils.cache.ImageTaskBack;
import com.antutu.utils.widget.WebBrowserActivity;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.u */
public class C1183u extends BaseAdapter {
    private Context f3986a;
    private List<C1518a> f3987b;
    private Handler f3988c;
    private boolean[] f3989d;

    /* renamed from: com.antutu.benchmark.a.u.1 */
    class C11791 implements C1178a {
        final /* synthetic */ int f3979a;
        final /* synthetic */ C1183u f3980b;

        C11791(C1183u c1183u, int i) {
            this.f3980b = c1183u;
            this.f3979a = i;
        }

        public void m4946a(boolean z) {
            this.f3980b.f3989d[this.f3979a] = z;
        }
    }

    /* renamed from: com.antutu.benchmark.a.u.a */
    private class C1181a implements ImageTaskBack {
        final /* synthetic */ C1183u f3983a;
        private C1182b f3984b;

        /* renamed from: com.antutu.benchmark.a.u.a.1 */
        class C11801 implements Runnable {
            final /* synthetic */ Bitmap f3981a;
            final /* synthetic */ C1181a f3982b;

            C11801(C1181a c1181a, Bitmap bitmap) {
                this.f3982b = c1181a;
                this.f3981a = bitmap;
            }

            public void run() {
                if (this.f3981a != null) {
                    this.f3982b.f3984b.f3985a.setImage(this.f3981a);
                }
            }
        }

        public C1181a(C1183u c1183u, C1182b c1182b) {
            this.f3983a = c1183u;
            this.f3984b = c1182b;
        }

        public void imageBack(String str, Bitmap bitmap) {
            this.f3983a.f3988c.post(new C11801(this, bitmap));
        }
    }

    /* renamed from: com.antutu.benchmark.a.u.b */
    static class C1182b {
        SuggestAppSelectView f3985a;

        C1182b() {
        }
    }

    public C1183u(Context context) {
        this.f3987b = new ArrayList();
        this.f3989d = new boolean[this.f3987b.size()];
        this.f3986a = context;
        this.f3988c = new Handler(Looper.getMainLooper());
        m4950b();
    }

    private void m4950b() {
        this.f3989d = new boolean[this.f3987b.size()];
        for (int i = 0; i < this.f3989d.length; i++) {
            this.f3989d[i] = true;
        }
    }

    public void m4951a(List<C1518a> list) {
        this.f3987b.clear();
        this.f3987b.addAll(list);
        m4950b();
    }

    public boolean m4952a() {
        boolean z = false;
        int i = 0;
        while (i < this.f3989d.length) {
            boolean z2;
            if (this.f3989d[i]) {
                z2 = true;
                WebBrowserActivity.openURL(this.f3986a, ((C1518a) this.f3987b.get(i)).f5209g, BuildConfig.FLAVOR);
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        return z;
    }

    public int getCount() {
        return this.f3987b.size();
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C1182b c1182b;
        C1518a c1518a = (C1518a) this.f3987b.get(i);
        if (view == null) {
            C1182b c1182b2 = new C1182b();
            view = View.inflate(this.f3986a, C1082R.layout.item_suggest_app, null);
            c1182b2.f3985a = (SuggestAppSelectView) view.findViewById(C1082R.id.suggestappselectview);
            view.setTag(c1182b2);
            c1182b = c1182b2;
        } else {
            c1182b = (C1182b) view.getTag();
        }
        c1182b.f3985a.setText(c1518a.f5207e);
        ImageControl.getInstance().getImage(c1518a.f5206d, new C1181a(this, c1182b));
        c1182b.f3985a.setOnChangeCheckListener(new C11791(this, i));
        return view;
    }
}
