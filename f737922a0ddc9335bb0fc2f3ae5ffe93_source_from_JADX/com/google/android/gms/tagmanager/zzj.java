package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.g;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj extends aq {
    private static final String DW;
    private static final String FH;
    private static final String Hw;
    private static final Set<String> Zo;
    static final String j6;
    private static final String v5;
    private final a VH;
    private final Context gn;

    public interface a {
        l j6();
    }

    class 1 implements a {
        final /* synthetic */ Context j6;

        1(Context context) {
            this.j6 = context;
        }

        public l j6() {
            return ba.j6(this.j6);
        }
    }

    static {
        DW = f.ARBITRARY_PIXEL.toString();
        FH = g.URL.toString();
        Hw = g.ADDITIONAL_PARAMS.toString();
        v5 = g.UNREPEATABLE.toString();
        String str = DW;
        j6 = new StringBuilder(String.valueOf(str).length() + 17).append("gtm_").append(str).append("_unrepeatable").toString();
        Zo = new HashSet();
    }

    public zzj(Context context) {
        this(context, new 1(context));
    }

    zzj(Context context, a aVar) {
        super(DW, FH);
        this.VH = aVar;
        this.gn = context;
    }

    private synchronized boolean FH(String str) {
        boolean z = true;
        synchronized (this) {
            if (!DW(str)) {
                if (j6(str)) {
                    Zo.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void DW(Map<String, com.google.android.gms.internal.h.a> map) {
        String j6 = map.get(v5) != null ? as.j6((com.google.android.gms.internal.h.a) map.get(v5)) : null;
        if (j6 == null || !FH(j6)) {
            String valueOf;
            Builder buildUpon = Uri.parse(as.j6((com.google.android.gms.internal.h.a) map.get(FH))).buildUpon();
            com.google.android.gms.internal.h.a aVar = (com.google.android.gms.internal.h.a) map.get(Hw);
            if (aVar != null) {
                Object FH = as.FH(aVar);
                if (FH instanceof List) {
                    for (Object FH2 : (List) FH2) {
                        if (FH2 instanceof Map) {
                            for (Entry entry : ((Map) FH2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            j6 = "ArbitraryPixel: additional params contains non-map: not sending partial hit: ";
                            valueOf = String.valueOf(buildUpon.build().toString());
                            r.j6(valueOf.length() != 0 ? j6.concat(valueOf) : new String(j6));
                            return;
                        }
                    }
                }
                j6 = "ArbitraryPixel: additional params not a list: not sending partial hit: ";
                valueOf = String.valueOf(buildUpon.build().toString());
                r.j6(valueOf.length() != 0 ? j6.concat(valueOf) : new String(j6));
                return;
            }
            valueOf = buildUpon.build().toString();
            this.VH.j6().j6(valueOf);
            String str = "ArbitraryPixel: url = ";
            valueOf = String.valueOf(valueOf);
            r.Hw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            if (j6 != null) {
                synchronized (zzj.class) {
                    Zo.add(j6);
                    ao.j6(this.gn, j6, j6, "true");
                }
            }
        }
    }

    boolean DW(String str) {
        return Zo.contains(str);
    }

    boolean j6(String str) {
        return this.gn.getSharedPreferences(j6, 0).contains(str);
    }
}
