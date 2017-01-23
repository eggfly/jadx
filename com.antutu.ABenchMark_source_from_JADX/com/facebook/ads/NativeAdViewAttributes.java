package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import com.antutu.utils.widget.SystemBarTintManager;
import com.facebook.ads.internal.util.C2489b;
import com.facebook.ads.internal.util.C2490c;
import org.json.JSONObject;

public class NativeAdViewAttributes {
    private Typeface f7875a;
    private int f7876b;
    private int f7877c;
    private int f7878d;
    private int f7879e;
    private int f7880f;
    private int f7881g;
    private boolean f7882h;

    public NativeAdViewAttributes() {
        this.f7875a = Typeface.DEFAULT;
        this.f7876b = -1;
        this.f7877c = SystemBarTintManager.DEFAULT_TINT_COLOR;
        this.f7878d = -11643291;
        this.f7879e = 0;
        this.f7880f = -12420889;
        this.f7881g = -12420889;
        this.f7882h = AdSettings.isVideoAutoplay();
    }

    public NativeAdViewAttributes(JSONObject jSONObject) {
        int i = 0;
        this.f7875a = Typeface.DEFAULT;
        this.f7876b = -1;
        this.f7877c = SystemBarTintManager.DEFAULT_TINT_COLOR;
        this.f7878d = -11643291;
        this.f7879e = 0;
        this.f7880f = -12420889;
        this.f7881g = -12420889;
        this.f7882h = AdSettings.isVideoAutoplay();
        try {
            int parseColor = jSONObject.getBoolean("background_transparent") ? 0 : Color.parseColor(jSONObject.getString("background_color"));
            int parseColor2 = Color.parseColor(jSONObject.getString("title_text_color"));
            int parseColor3 = Color.parseColor(jSONObject.getString("description_text_color"));
            int parseColor4 = jSONObject.getBoolean("button_transparent") ? 0 : Color.parseColor(jSONObject.getString("button_color"));
            if (!jSONObject.getBoolean("button_border_transparent")) {
                i = Color.parseColor(jSONObject.getString("button_border_color"));
            }
            int parseColor5 = Color.parseColor(jSONObject.getString("button_text_color"));
            Typeface create = Typeface.create(jSONObject.getString("android_typeface"), 0);
            this.f7876b = parseColor;
            this.f7877c = parseColor2;
            this.f7878d = parseColor3;
            this.f7879e = parseColor4;
            this.f7881g = i;
            this.f7880f = parseColor5;
            this.f7875a = create;
        } catch (Throwable e) {
            C2490c.m9456a(C2489b.m9453a(e, "Error retrieving native ui configuration data"));
        }
    }

    public boolean getAutoplay() {
        return this.f7882h;
    }

    public int getBackgroundColor() {
        return this.f7876b;
    }

    public int getButtonBorderColor() {
        return this.f7881g;
    }

    public int getButtonColor() {
        return this.f7879e;
    }

    public int getButtonTextColor() {
        return this.f7880f;
    }

    public int getDescriptionTextColor() {
        return this.f7878d;
    }

    public int getDescriptionTextSize() {
        return 10;
    }

    public int getTitleTextColor() {
        return this.f7877c;
    }

    public int getTitleTextSize() {
        return 16;
    }

    public Typeface getTypeface() {
        return this.f7875a;
    }

    public NativeAdViewAttributes setAutoplay(boolean z) {
        this.f7882h = z;
        return this;
    }

    public NativeAdViewAttributes setBackgroundColor(int i) {
        this.f7876b = i;
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i) {
        this.f7881g = i;
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i) {
        this.f7879e = i;
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i) {
        this.f7880f = i;
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i) {
        this.f7878d = i;
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i) {
        this.f7877c = i;
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.f7875a = typeface;
        return this;
    }
}
