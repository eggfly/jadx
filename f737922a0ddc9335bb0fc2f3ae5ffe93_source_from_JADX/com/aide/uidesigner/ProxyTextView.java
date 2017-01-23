package com.aide.uidesigner;

import android.R.attr;
import android.R.style;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;

public class ProxyTextView {
    public static final int INPUTTYPE_date = 20;
    public static final int INPUTTYPE_datetime = 4;
    public static final int INPUTTYPE_none = 0;
    public static final int INPUTTYPE_number = 2;
    public static final int INPUTTYPE_numberDecimal = 8194;
    public static final int INPUTTYPE_numberPassword = 18;
    public static final int INPUTTYPE_numberSigned = 4098;
    public static final int INPUTTYPE_phone = 3;
    public static final int INPUTTYPE_text = 1;
    public static final int INPUTTYPE_textAutoComplete = 65537;
    public static final int INPUTTYPE_textAutoCorrect = 32769;
    public static final int INPUTTYPE_textCapCharacters = 4097;
    public static final int INPUTTYPE_textCapSentences = 16385;
    public static final int INPUTTYPE_textCapWords = 8193;
    public static final int INPUTTYPE_textEmailAddress = 33;
    public static final int INPUTTYPE_textEmailSubject = 49;
    public static final int INPUTTYPE_textFilter = 177;
    public static final int INPUTTYPE_textImeMultiLine = 262145;
    public static final int INPUTTYPE_textLongMessage = 81;
    public static final int INPUTTYPE_textMultiLine = 131073;
    public static final int INPUTTYPE_textNoSuggestions = 524289;
    public static final int INPUTTYPE_textPassword = 129;
    public static final int INPUTTYPE_textPersonName = 97;
    public static final int INPUTTYPE_textPhonetic = 193;
    public static final int INPUTTYPE_textPostalAddress = 113;
    public static final int INPUTTYPE_textShortMessage = 65;
    public static final int INPUTTYPE_textUri = 17;
    public static final int INPUTTYPE_textVisiblePassword = 145;
    public static final int INPUTTYPE_textWebEditText = 161;
    public static final int INPUTTYPE_textWebEmailAddress = 209;
    public static final int INPUTTYPE_textWebPassword = 225;
    public static final int INPUTTYPE_time = 36;
    public static final int TEXTSTYLE_bold = 1;
    public static final int TEXTSTYLE_italic = 2;
    public static final int TEXTSTYLE_normal = 0;
    public static final int TYPEFACE_MONOSPACE = 3;
    public static final int TYPEFACE_NORMAL = 0;
    public static final int TYPEFACE_SANS = 1;
    public static final int TYPEFACE_SERIF = 2;
    private String fontFamily;
    private int shadowColor;
    private float shadowDx;
    private float shadowDy;
    private float shadowRadius;
    private int textStyle;
    private final TextView textView;
    private int typeface;

    public ProxyTextView(Object obj) {
        this.textStyle = TYPEFACE_NORMAL;
        this.typeface = TYPEFACE_NORMAL;
        this.fontFamily = null;
        this.textView = (TextView) obj;
    }

    public void setInputType(int i) {
        this.textView.setInputType(i);
    }

    public void setTextAppearance(String str) {
        try {
            if (str.startsWith("?android:attr/")) {
                int intValue = ((Integer) attr.class.getField(str.substring("?android:attr/".length())).get(null)).intValue();
                Theme theme = this.textView.getContext().getTheme();
                TypedValue typedValue = new TypedValue();
                if (theme.resolveAttribute(intValue, typedValue, true)) {
                    this.textView.setTextAppearance(this.textView.getContext(), typedValue.data);
                }
            } else if (str.startsWith("@android:style/")) {
                this.textView.setTextAppearance(this.textView.getContext(), ((Integer) style.class.getField(str.substring("@android:style/".length()).replace(".", "_")).get(null)).intValue());
            }
        } catch (Throwable th) {
        }
    }

    public void setShadowRadius(float f) {
        this.shadowRadius = f;
        updateShadow();
    }

    public void setShadowDx(float f) {
        this.shadowDx = f;
        updateShadow();
    }

    public void setShadowDy(float f) {
        this.shadowDy = f;
        updateShadow();
    }

    public void setShadowColor(int i) {
        this.shadowColor = i;
        updateShadow();
    }

    private void updateShadow() {
        this.textView.setShadowLayer(this.shadowRadius, this.shadowDx, this.shadowDy, this.shadowColor);
    }

    public void setTextStyle(int i) {
        this.textStyle = i;
        updateFont();
    }

    public void setTypeface(int i) {
        this.typeface = i;
        updateFont();
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
        updateFont();
    }

    private void updateFont() {
        Typeface typeface = null;
        if (this.fontFamily != null) {
            typeface = Typeface.create(this.fontFamily, this.textStyle);
            if (typeface != null) {
                this.textView.setTypeface(typeface);
                return;
            }
        }
        switch (this.typeface) {
            case TYPEFACE_SANS /*1*/:
                typeface = Typeface.SANS_SERIF;
                break;
            case TYPEFACE_SERIF /*2*/:
                typeface = Typeface.SERIF;
                break;
            case TYPEFACE_MONOSPACE /*3*/:
                typeface = Typeface.MONOSPACE;
                break;
        }
        this.textView.setTypeface(typeface, this.textStyle);
    }
}
