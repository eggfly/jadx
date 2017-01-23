package com.github.amlcurran.showcaseview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.DynamicLayout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import it.gmariotti.cardslib.library.internal.Card;

class TextDrawer {
    private final float actionBarOffset;
    private final ShowcaseAreaCalculator calculator;
    private final Context context;
    private boolean hasRecalculated;
    private float[] mBestTextPosition;
    private TextAppearanceSpan mDetailSpan;
    private CharSequence mDetails;
    private DynamicLayout mDynamicDetailLayout;
    private DynamicLayout mDynamicTitleLayout;
    private CharSequence mTitle;
    private TextAppearanceSpan mTitleSpan;
    private final float padding;
    private final TextPaint textPaint;
    private final TextPaint titlePaint;

    public TextDrawer(Resources resources, ShowcaseAreaCalculator calculator, Context context) {
        this.mBestTextPosition = new float[3];
        this.padding = resources.getDimension(C0158R.dimen.text_padding);
        this.actionBarOffset = resources.getDimension(C0158R.dimen.action_bar_offset);
        this.calculator = calculator;
        this.context = context;
        this.titlePaint = new TextPaint();
        this.titlePaint.setAntiAlias(true);
        this.textPaint = new TextPaint();
        this.textPaint.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        if (shouldDrawText()) {
            float[] textPosition = getBestTextPosition();
            if (!TextUtils.isEmpty(this.mTitle)) {
                canvas.save();
                if (this.hasRecalculated) {
                    this.mDynamicTitleLayout = new DynamicLayout(this.mTitle, this.titlePaint, (int) textPosition[2], Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
                }
                if (this.mDynamicTitleLayout != null) {
                    canvas.translate(textPosition[0], textPosition[1]);
                    this.mDynamicTitleLayout.draw(canvas);
                    canvas.restore();
                }
            }
            if (!TextUtils.isEmpty(this.mDetails)) {
                canvas.save();
                if (this.hasRecalculated) {
                    this.mDynamicDetailLayout = new DynamicLayout(this.mDetails, this.textPaint, (int) textPosition[2], Alignment.ALIGN_NORMAL, 1.2f, 1.0f, true);
                }
                float offsetForTitle = this.mDynamicTitleLayout != null ? (float) this.mDynamicTitleLayout.getHeight() : 0.0f;
                if (this.mDynamicDetailLayout != null) {
                    canvas.translate(textPosition[0], textPosition[1] + offsetForTitle);
                    this.mDynamicDetailLayout.draw(canvas);
                    canvas.restore();
                }
            }
        }
        this.hasRecalculated = false;
    }

    public void setContentText(CharSequence details) {
        if (details != null) {
            SpannableString ssbDetail = new SpannableString(details);
            ssbDetail.setSpan(this.mDetailSpan, 0, ssbDetail.length(), 0);
            this.mDetails = ssbDetail;
        }
    }

    public void setContentTitle(CharSequence title) {
        if (title != null) {
            SpannableString ssbTitle = new SpannableString(title);
            ssbTitle.setSpan(this.mTitleSpan, 0, ssbTitle.length(), 0);
            this.mTitle = ssbTitle;
        }
    }

    public void calculateTextPosition(int canvasW, int canvasH, ShowcaseView showcaseView, boolean shouldCentreText) {
        Rect showcase;
        if (showcaseView.hasShowcaseView()) {
            showcase = this.calculator.getShowcaseRect();
        } else {
            showcase = new Rect();
        }
        int[] areas = new int[]{showcase.left * canvasH, showcase.top * canvasW, (canvasW - showcase.right) * canvasH, (canvasH - showcase.bottom) * canvasW};
        int largest = 0;
        for (int i = 1; i < areas.length; i++) {
            if (areas[i] > areas[largest]) {
                largest = i;
            }
        }
        switch (largest) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                this.mBestTextPosition[0] = this.padding;
                this.mBestTextPosition[1] = this.padding;
                this.mBestTextPosition[2] = ((float) showcase.left) - (this.padding * 2.0f);
                break;
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                this.mBestTextPosition[0] = this.padding;
                this.mBestTextPosition[1] = this.padding + this.actionBarOffset;
                this.mBestTextPosition[2] = ((float) canvasW) - (this.padding * 2.0f);
                break;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                this.mBestTextPosition[0] = ((float) showcase.right) + this.padding;
                this.mBestTextPosition[1] = this.padding;
                this.mBestTextPosition[2] = ((float) (canvasW - showcase.right)) - (this.padding * 2.0f);
                break;
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                this.mBestTextPosition[0] = this.padding;
                this.mBestTextPosition[1] = ((float) showcase.bottom) + this.padding;
                this.mBestTextPosition[2] = ((float) canvasW) - (this.padding * 2.0f);
                break;
        }
        if (!shouldCentreText) {
            switch (largest) {
                case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                    float[] fArr = this.mBestTextPosition;
                    fArr[1] = fArr[1] + this.actionBarOffset;
                    break;
                default:
                    break;
            }
        }
        switch (largest) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                fArr = this.mBestTextPosition;
                fArr[1] = fArr[1] + ((float) (canvasH / 4));
                break;
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                fArr = this.mBestTextPosition;
                fArr[2] = fArr[2] / 2.0f;
                fArr = this.mBestTextPosition;
                fArr[0] = fArr[0] + ((float) (canvasW / 4));
                break;
        }
        this.hasRecalculated = true;
    }

    public void setTitleStyling(int styleId) {
        this.mTitleSpan = new TextAppearanceSpan(this.context, styleId);
        setContentTitle(this.mTitle);
    }

    public void setDetailStyling(int styleId) {
        this.mDetailSpan = new TextAppearanceSpan(this.context, styleId);
        setContentText(this.mDetails);
    }

    public CharSequence getContentTitle() {
        return this.mTitle;
    }

    public CharSequence getContentText() {
        return this.mDetails;
    }

    public float[] getBestTextPosition() {
        return this.mBestTextPosition;
    }

    public boolean shouldDrawText() {
        return (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mDetails)) ? false : true;
    }
}
