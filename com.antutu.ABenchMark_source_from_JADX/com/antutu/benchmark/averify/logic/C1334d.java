package com.antutu.benchmark.averify.logic;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.antutu.benchmark.averify.logic.Verifier.VerifiedResult;
import com.antutu.utils.MLog;
import com.xiaomi.pushsdk.BuildConfig;

/* renamed from: com.antutu.benchmark.averify.logic.d */
public class C1334d extends AsyncTask<Void, String, VerifiedResult> {
    private static final String f4595a;
    private Context f4596b;
    private VerifiedResult f4597c;
    private C1327a f4598d;
    private boolean f4599e;

    /* renamed from: com.antutu.benchmark.averify.logic.d.a */
    public interface C1327a {
        void m5343a(VerifiedResult verifiedResult);
    }

    static {
        f4595a = C1334d.class.getSimpleName();
    }

    public C1334d(Context context, boolean z, C1327a c1327a) {
        this.f4598d = null;
        this.f4599e = false;
        this.f4596b = context;
        this.f4598d = c1327a;
        this.f4599e = z;
    }

    protected VerifiedResult m5392a(Void... voidArr) {
        Object obj = BuildConfig.FLAVOR;
        if (!this.f4599e) {
            obj = C1333c.m5390a(this.f4596b);
        }
        MLog.m6868e(f4595a, "server: " + obj);
        if (TextUtils.isEmpty(obj)) {
            this.f4597c = new Verifier(this.f4596b).m5384b();
            if (this.f4597c != null) {
                C1333c.m5391a(this.f4596b, this.f4597c.m5360a());
            }
        } else {
            this.f4597c = new VerifiedResult();
            this.f4597c.m5361a(obj);
            MLog.m6868e(f4595a, "local:" + this.f4597c.toString());
        }
        return null;
    }

    protected void m5393a(VerifiedResult verifiedResult) {
        super.onPostExecute(verifiedResult);
        if (this.f4598d != null) {
            this.f4598d.m5343a(this.f4597c);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5392a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5393a((VerifiedResult) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }
}
