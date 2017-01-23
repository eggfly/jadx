package com.miui.support.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.miui.support.internal.C0264R;

public class MessageView extends LinearLayout {
    private TextView f4200a;

    /* renamed from: com.miui.support.widget.MessageView.1 */
    class C04921 implements OnClickListener {
        final /* synthetic */ MessageView f4199a;

        C04921(MessageView messageView) {
            this.f4199a = messageView;
        }

        public void onClick(View view) {
            this.f4199a.setVisibility(8);
        }
    }

    public MessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5877a(context, attributeSet, i);
    }

    public void setMessage(CharSequence charSequence) {
        this.f4200a.setText(charSequence);
    }

    private void m5877a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.MessageView, i, 0);
        CharSequence string = obtainStyledAttributes.getString(C0264R.styleable.MessageView_android_text);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0264R.styleable.MessageView_android_textColor);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0264R.styleable.MessageView_closeBackground);
        obtainStyledAttributes.recycle();
        this.f4200a = new TextView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(C0264R.dimen.message_view_text_margin_left);
        layoutParams.weight = 1.0f;
        this.f4200a.setId(16908308);
        this.f4200a.setText(string);
        this.f4200a.setTextColor(colorStateList);
        this.f4200a.setTextSize(0, (float) getResources().getDimensionPixelSize(C0264R.dimen.message_view_text_size));
        addView(this.f4200a, layoutParams);
        View imageView = new ImageView(getContext());
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = getResources().getDimensionPixelSize(C0264R.dimen.message_view_text_margin_right);
        layoutParams2.rightMargin = getResources().getDimensionPixelSize(C0264R.dimen.message_view_close_margin_right);
        imageView.setId(C0264R.id.close);
        imageView.setBackground(drawable);
        imageView.setOnClickListener(new C04921(this));
        addView(imageView, layoutParams2);
        setGravity(16);
    }
}
