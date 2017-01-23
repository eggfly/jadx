package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdView.Type;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.q */
public class C2334q extends C2299a {
    private final C2307r f8129b;
    private Type f8130c;
    private boolean f8131d;
    private boolean f8132e;
    private boolean f8133f;
    private View f8134g;
    private List<View> f8135h;

    public C2334q(Context context, C2268b c2268b, C2307r c2307r) {
        super(context, c2268b);
        this.f8129b = c2307r;
    }

    private String m9004b(View view) {
        try {
            return m9005c(view).toString();
        } catch (JSONException e) {
            return "Json exception";
        }
    }

    private JSONObject m9005c(View view) {
        boolean z = true;
        int i = 0;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(AgooConstants.MESSAGE_ID, Integer.valueOf(view.getId()));
        jSONObject.putOpt("class", view.getClass());
        jSONObject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[]{Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())}));
        jSONObject.putOpt("size", String.format("{h:%d, w:%d}", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())}));
        if (this.f8135h == null || !this.f8135h.contains(view)) {
            z = false;
        }
        jSONObject.putOpt("clickable", Boolean.valueOf(z));
        Object obj = UtilityImpl.NET_TYPE_UNKNOWN;
        if (view instanceof TextView) {
            obj = "text";
        } else if (view instanceof Button) {
            obj = "button";
        } else if (view instanceof ImageView) {
            obj = "image";
        } else if (view instanceof MediaView) {
            obj = "mediaview";
        } else if (view instanceof ViewGroup) {
            obj = "viewgroup";
        }
        jSONObject.putOpt(C4233j.f14402y, obj);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            JSONArray jSONArray = new JSONArray();
            while (i < viewGroup.getChildCount()) {
                jSONArray.put(m9005c(viewGroup.getChildAt(i)));
                i++;
            }
            jSONObject.putOpt("list", jSONArray);
        }
        return jSONObject;
    }

    private String m9006d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return BuildConfig.FLAVOR;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            createBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(createBitmap));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, this.f8129b.m8737h(), byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }

    public void m9007a(View view) {
        this.f8134g = view;
    }

    public void m9008a(Type type) {
        this.f8130c = type;
    }

    public void m9009a(List<View> list) {
        this.f8135h = list;
    }

    public void m9010a(boolean z) {
        this.f8131d = z;
    }

    protected void m9011b() {
        if (this.f8129b != null) {
            Map hashMap = new HashMap();
            if (this.a != null) {
                hashMap.put("mil", Boolean.valueOf(this.a.m8575a()));
                hashMap.put("eil", Boolean.valueOf(this.a.m8576b()));
                hashMap.put("eil_source", this.a.m8577c());
            }
            if (this.f8130c != null) {
                hashMap.put("nti", String.valueOf(this.f8130c.getValue()));
            }
            if (this.f8131d) {
                hashMap.put("nhs", String.valueOf(this.f8131d));
            }
            if (this.f8132e) {
                hashMap.put("nmv", String.valueOf(this.f8132e));
            }
            if (this.f8133f) {
                hashMap.put("nmvap", String.valueOf(this.f8133f));
            }
            if (this.f8134g != null && this.f8129b.m8734e()) {
                hashMap.put("view", m9004b(this.f8134g));
            }
            if (this.f8134g != null && this.f8129b.m8733d()) {
                hashMap.put("snapshot", m9006d(this.f8134g));
            }
            this.f8129b.m8729a(hashMap);
        }
    }

    public void m9012b(boolean z) {
        this.f8132e = z;
    }

    public void m9013c(boolean z) {
        this.f8133f = z;
    }
}
