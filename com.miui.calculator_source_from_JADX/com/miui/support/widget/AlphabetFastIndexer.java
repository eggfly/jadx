package com.miui.support.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.WrapperListAdapter;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.util.DeviceHelper;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class AlphabetFastIndexer extends ImageView {
    private AdapterView<?> f3955a;
    private TextView f3956b;
    private int f3957c;
    private int f3958d;
    private boolean f3959e;
    private int f3960f;
    private int f3961g;
    private int f3962h;
    private int f3963i;
    private Drawable f3964j;
    private AnimatorUpdateListener f3965k;
    private TextHilighter f3966l;
    private int f3967m;
    private int f3968n;
    private Runnable f3969o;
    private Handler f3970p;

    /* renamed from: com.miui.support.widget.AlphabetFastIndexer.1 */
    class C04521 implements AnimatorUpdateListener {
        final /* synthetic */ AlphabetFastIndexer f3939a;

        C04521(AlphabetFastIndexer alphabetFastIndexer) {
            this.f3939a = alphabetFastIndexer;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3939a.f3966l.m5668a(((float) this.f3939a.getWidth()) / 2.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f3939a.postInvalidate();
        }
    }

    /* renamed from: com.miui.support.widget.AlphabetFastIndexer.2 */
    class C04532 implements Runnable {
        final /* synthetic */ AlphabetFastIndexer f3940a;

        C04532(AlphabetFastIndexer alphabetFastIndexer) {
            this.f3940a = alphabetFastIndexer;
        }

        public void run() {
            this.f3940a.m5674a();
        }
    }

    /* renamed from: com.miui.support.widget.AlphabetFastIndexer.3 */
    class C04543 extends Handler {
        final /* synthetic */ AlphabetFastIndexer f3941a;

        C04543(AlphabetFastIndexer alphabetFastIndexer) {
            this.f3941a = alphabetFastIndexer;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    if (this.f3941a.f3956b != null) {
                        this.f3941a.f3956b.setVisibility(8);
                    }
                default:
            }
        }
    }

    private static class OnScrollerDecorator implements OnScrollListener {
        private final OnScrollListener f3942a;
        private final WeakReference<AlphabetFastIndexer> f3943b;

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AlphabetFastIndexer alphabetFastIndexer = (AlphabetFastIndexer) this.f3943b.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.m5674a();
            }
            if (this.f3942a != null) {
                this.f3942a.onScroll(absListView, i, i2, i3);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            AlphabetFastIndexer alphabetFastIndexer = (AlphabetFastIndexer) this.f3943b.get();
            if (alphabetFastIndexer != null) {
                alphabetFastIndexer.f3967m = i;
            }
            if (this.f3942a != null) {
                this.f3942a.onScrollStateChanged(absListView, i);
            }
        }
    }

    private static class TextHilighter {
        Paint f3944a;
        ValueAnimator f3945b;
        Rect f3946c;
        Rect f3947d;
        String[] f3948e;
        int f3949f;
        int f3950g;
        int f3951h;
        boolean f3952i;
        float f3953j;
        float f3954k;

        TextHilighter(Context context, TypedArray typedArray) {
            int i;
            boolean z = false;
            this.f3944a = new Paint();
            this.f3946c = new Rect();
            this.f3947d = new Rect();
            Resources resources = context.getResources();
            CharSequence[] textArray = typedArray.getTextArray(C0264R.styleable.AlphabetFastIndexer_indexerTable);
            if (textArray != null) {
                this.f3948e = new String[textArray.length];
                int length = textArray.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    this.f3948e[i2] = textArray[i].toString();
                    i++;
                    i2 = i3;
                }
            } else {
                this.f3948e = resources.getStringArray(C0264R.array.alphabet_table);
            }
            if (this.f3948e.length > 1) {
                i = this.f3948e.length;
                String str = this.f3948e[i - 1];
                if (str.equals("#") && str.compareTo(this.f3948e[i - 2]) < 0) {
                    z = true;
                }
                this.f3952i = z;
            }
            this.f3949f = typedArray.getColor(C0264R.styleable.AlphabetFastIndexer_indexerTextColor, resources.getColor(C0264R.color.alphabet_indexer_text_color));
            this.f3950g = typedArray.getColor(C0264R.styleable.AlphabetFastIndexer_indexerTextActivatedColor, resources.getColor(C0264R.color.alphabet_indexer_activated_text_color));
            this.f3951h = typedArray.getColor(C0264R.styleable.AlphabetFastIndexer_indexerTextHighlightColor, resources.getColor(C0264R.color.alphabet_indexer_highlight_text_color));
            this.f3944a.setTextSize(typedArray.getDimension(C0264R.styleable.AlphabetFastIndexer_indexerTextSize, resources.getDimension(C0264R.dimen.alphabet_indexer_text_size)));
            this.f3944a.setAntiAlias(true);
            this.f3944a.setTextAlign(Align.CENTER);
            if (DeviceHelper.f2554f) {
                this.f3944a.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                this.f3944a.setTypeface(Typeface.create("miui", 1));
            }
            m5668a(0.0f, 0.0f);
        }

        void m5668a(float f, float f2) {
            this.f3953j = f;
            this.f3954k = f2;
        }

        void m5670a(Canvas canvas, boolean z, int i, float f, float f2) {
            String str;
            Paint paint = this.f3944a;
            if (TextUtils.equals(this.f3948e[i], "!")) {
                str = "\u2665";
            } else {
                str = this.f3948e[i];
            }
            paint.getTextBounds(str, 0, str.length(), this.f3947d);
            float width = (float) this.f3947d.width();
            float height = (float) this.f3947d.height();
            this.f3946c.set((int) ((this.f3953j - (width / 2.0f)) + 1.0f), (int) (this.f3954k - (height / 2.0f)), (int) ((this.f3953j + (width / 2.0f)) + 1.0f), (int) (this.f3954k + (height / 2.0f)));
            if (z) {
                paint.setColor(this.f3950g);
            } else if (this.f3946c.intersect((int) (f - (width / 2.0f)), (int) (f2 - (height / 2.0f)), (int) ((width / 2.0f) + f), (int) ((height / 2.0f) + f2))) {
                paint.setColor(this.f3951h);
            } else {
                paint.setColor(this.f3949f);
            }
            if (str.equals("\u2665")) {
                paint.setColorFilter(new PorterDuffColorFilter(paint.getColor(), Mode.SRC_IN));
            } else {
                paint.setColorFilter(null);
            }
            canvas.drawText(str, f, f2 - (((float) (this.f3947d.top + this.f3947d.bottom)) / 2.0f), paint);
        }

        void m5669a(float f, AnimatorUpdateListener animatorUpdateListener) {
            float f2;
            if (this.f3945b != null) {
                this.f3945b.cancel();
            }
            if (this.f3946c == null) {
                f2 = f;
            } else {
                f2 = ((float) (this.f3946c.top + this.f3946c.bottom)) / 2.0f;
            }
            this.f3945b = ValueAnimator.ofFloat(new float[]{f2, f});
            this.f3945b.addUpdateListener(animatorUpdateListener);
            this.f3945b.setDuration(DeviceHelper.f2553e ? 200 : 0);
            this.f3945b.start();
        }
    }

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlphabetFastIndexer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3965k = new C04521(this);
        this.f3967m = 0;
        this.f3968n = 0;
        this.f3969o = new C04532(this);
        this.f3970p = new C04543(this);
        Resources resources = context.getResources();
        if (attributeSet.getStyleAttribute() != 0) {
            i = attributeSet.getStyleAttribute();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.AlphabetFastIndexer, 0, i);
        this.f3966l = new TextHilighter(context, obtainStyledAttributes);
        this.f3959e = obtainStyledAttributes.getBoolean(C0264R.styleable.AlphabetFastIndexer_drawOverlay, true);
        if (this.f3959e) {
            this.f3960f = obtainStyledAttributes.getDimensionPixelOffset(C0264R.styleable.AlphabetFastIndexer_overlayMarginLeft, resources.getDimensionPixelOffset(C0264R.dimen.alphabet_indexer_overlay_offset));
            this.f3961g = obtainStyledAttributes.getDimensionPixelOffset(C0264R.styleable.AlphabetFastIndexer_overlayMarginTop, resources.getDimensionPixelOffset(C0264R.dimen.alphabet_indexer_overlay_padding_top));
            this.f3962h = obtainStyledAttributes.getDimensionPixelSize(C0264R.styleable.AlphabetFastIndexer_overlayTextSize, resources.getDimensionPixelSize(C0264R.dimen.alphabet_indexer_overlay_text_size));
            this.f3963i = obtainStyledAttributes.getColor(C0264R.styleable.AlphabetFastIndexer_overlayTextColor, resources.getColor(C0264R.color.alphabet_indexer_overlay_text_color));
            this.f3964j = obtainStyledAttributes.getDrawable(C0264R.styleable.AlphabetFastIndexer_overlayBackground);
            if (this.f3964j == null) {
                this.f3964j = resources.getDrawable(C0264R.drawable.alphabet_indexer_overlay);
            }
        }
        obtainStyledAttributes.recycle();
        this.f3958d = 8388613;
    }

    public void setVerticalPosition(boolean z) {
        this.f3958d = z ? 8388613 : 8388611;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3957c = -1;
        post(this.f3969o);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height > 0) {
            String[] strArr = this.f3966l.f3948e;
            float length = ((float) height) / ((float) strArr.length);
            float width = ((float) getWidth()) / 2.0f;
            float f = ((float) paddingTop) + (length / 2.0f);
            for (int i = 0; i < strArr.length; i++) {
                this.f3966l.m5670a(canvas, isPressed(), i, width, f);
                f += length;
            }
        }
    }

    private void m5674a() {
        if (this.f3955a != null) {
            int i;
            SectionIndexer sectionIndexer = getSectionIndexer();
            if (sectionIndexer != null) {
                int sectionForPosition = sectionIndexer.getSectionForPosition(this.f3955a.getFirstVisiblePosition() - getListOffset());
                if (sectionForPosition != -1) {
                    String str = (String) sectionIndexer.getSections()[sectionForPosition];
                    if (!TextUtils.isEmpty(str)) {
                        int length = this.f3966l.f3948e.length;
                        if (this.f3966l.f3952i) {
                            sectionForPosition = length - 1;
                        } else {
                            sectionForPosition = length;
                        }
                        i = str.equals("#") ? length - 1 : Arrays.binarySearch(this.f3966l.f3948e, 0, sectionForPosition, str);
                        if (this.f3957c != i) {
                            this.f3957c = i;
                            if (1 != this.f3968n) {
                                m5677b(this.f3957c);
                            }
                            invalidate();
                        }
                    }
                }
            }
            i = 0;
            if (this.f3957c != i) {
                this.f3957c = i;
                if (1 != this.f3968n) {
                    m5677b(this.f3957c);
                }
                invalidate();
            }
        }
    }

    public int getIndexerIntrinsicWidth() {
        Drawable background = getBackground();
        return background != null ? background.getIntrinsicWidth() : 0;
    }

    private SectionIndexer getSectionIndexer() {
        if (this.f3955a == null) {
            return null;
        }
        SectionIndexer sectionIndexer;
        Adapter adapter = this.f3955a.getAdapter();
        while (!(adapter instanceof SectionIndexer) && (adapter instanceof WrapperListAdapter)) {
            adapter = ((WrapperListAdapter) adapter).getWrappedAdapter();
        }
        if (adapter instanceof SectionIndexer) {
            sectionIndexer = (SectionIndexer) adapter;
        } else {
            sectionIndexer = null;
        }
        return sectionIndexer;
    }

    private int getListOffset() {
        if (this.f3955a instanceof ListView) {
            return ((ListView) this.f3955a).getHeaderViewsCount();
        }
        return 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3955a == null) {
            m5680a(0);
            return false;
        }
        SectionIndexer sectionIndexer = getSectionIndexer();
        if (sectionIndexer == null) {
            m5680a(0);
            return false;
        }
        switch (motionEvent.getAction() & 255) {
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                this.f3968n = 1;
                setPressed(true);
                break;
            case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
            case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                m5677b(this.f3957c);
                m5680a(1500);
                break;
            case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                break;
            default:
                m5680a(1500);
                break;
        }
        int a = m5671a(motionEvent.getY(), sectionIndexer);
        if (a < 0) {
            this.f3955a.setSelection(0);
        } else {
            m5675a(sectionIndexer, a);
            if (this.f3966l != null && motionEvent.getY() > ((float) (getTop() + getPaddingTop())) && motionEvent.getY() < ((float) (getBottom() - getPaddingBottom()))) {
                this.f3966l.m5668a((float) (getWidth() / 2), motionEvent.getY());
                postInvalidate();
            }
        }
        return true;
    }

    void m5680a(int i) {
        setPressed(false);
        this.f3968n = 0;
        postInvalidate();
        this.f3970p.removeMessages(1);
        if (i > 0) {
            this.f3970p.sendMessageDelayed(this.f3970p.obtainMessage(1), (long) i);
        } else if (this.f3956b != null) {
            this.f3956b.setVisibility(8);
        }
    }

    private int m5671a(float f, SectionIndexer sectionIndexer) {
        Object[] sections = sectionIndexer.getSections();
        if (sections == null) {
            return -1;
        }
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        if (height <= 0) {
            return -1;
        }
        paddingTop = (int) (((f - ((float) paddingTop)) / ((float) height)) * ((float) this.f3966l.f3948e.length));
        if (paddingTop < 0) {
            return -1;
        }
        if (paddingTop >= this.f3966l.f3948e.length) {
            return sections.length;
        }
        int length = sections.length;
        if (length > 1 && this.f3966l.f3952i) {
            if (this.f3966l.f3948e[paddingTop].equals("#")) {
                return sections.length - 1;
            }
            if (sections[sections.length - 1].equals("#")) {
                length = sections.length - 1;
            }
        }
        length = Arrays.binarySearch(sections, 0, length, this.f3966l.f3948e[paddingTop]);
        if (length < 0) {
            length = (-length) - 2;
        }
        if (length < 0) {
            return 0;
        }
        return length;
    }

    private void m5675a(SectionIndexer sectionIndexer, int i) {
        int i2;
        int count = this.f3955a.getCount();
        int listOffset = getListOffset();
        float f = (1.0f / ((float) count)) / 8.0f;
        Object[] sections = sectionIndexer.getSections();
        int round;
        ExpandableListView expandableListView;
        if (sections == null || sections.length <= 1) {
            round = Math.round((float) (i * count));
            if (this.f3955a instanceof ExpandableListView) {
                expandableListView = (ExpandableListView) this.f3955a;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(round + listOffset)), 0);
            } else if (this.f3955a instanceof ListView) {
                ((ListView) this.f3955a).setSelectionFromTop(round + listOffset, 0);
            } else {
                this.f3955a.setSelection(round + listOffset);
            }
            i2 = -1;
        } else {
            int i3;
            int positionForSection;
            int length = sections.length;
            if (i >= length) {
                i3 = length - 1;
            } else {
                i3 = i;
            }
            int positionForSection2 = sectionIndexer.getPositionForSection(i3);
            int i4 = i3 + 1;
            if (i3 < length - 1) {
                positionForSection = sectionIndexer.getPositionForSection(i3 + 1);
            } else {
                positionForSection = count;
            }
            if (positionForSection == positionForSection2) {
                round = positionForSection2;
                i2 = i3;
                while (i2 > 0) {
                    round = i2 - 1;
                    i2 = sectionIndexer.getPositionForSection(round);
                    if (i2 != positionForSection2) {
                        positionForSection2 = i2;
                        i2 = round;
                        break;
                    } else if (round == 0) {
                        positionForSection2 = i2;
                        i2 = 0;
                        round = i3;
                        break;
                    } else {
                        int i5 = i2;
                        i2 = round;
                        round = i5;
                    }
                }
                positionForSection2 = round;
                i2 = i3;
                round = i3;
            } else {
                round = i3;
                i2 = i3;
            }
            int i6 = i4 + 1;
            while (i6 < length && sectionIndexer.getPositionForSection(i6) == positionForSection) {
                i6++;
                i4++;
            }
            float f2 = ((float) round) / ((float) length);
            float f3 = ((float) i4) / ((float) length);
            float f4 = ((float) i) / ((float) length);
            if (round != i3 || f4 - f2 >= f) {
                i3 = Math.round((((float) (positionForSection - positionForSection2)) * (f4 - f2)) / (f3 - f2)) + positionForSection2;
            } else {
                i3 = positionForSection2;
            }
            if (i3 > count - 1) {
                round = count - 1;
            } else {
                round = i3;
            }
            if (this.f3955a instanceof ExpandableListView) {
                expandableListView = (ExpandableListView) this.f3955a;
                expandableListView.setSelectionFromTop(expandableListView.getFlatListPosition(ExpandableListView.getPackedPositionForGroup(round + listOffset)), 0);
            } else if (this.f3955a instanceof ListView) {
                ((ListView) this.f3955a).setSelectionFromTop(round + listOffset, 0);
            } else {
                this.f3955a.setSelection(round + listOffset);
            }
        }
        if (i2 >= 0 && sections != null) {
            Object obj = sections[i2].toString();
            if (!TextUtils.isEmpty(obj)) {
                m5676a(obj.subSequence(0, 1));
            }
        }
    }

    private void m5676a(CharSequence charSequence) {
        if (this.f3955a != null) {
            if (this.f3956b != null) {
                if (TextUtils.equals(charSequence, "!")) {
                    charSequence = "\u2665";
                }
                this.f3956b.setText(charSequence);
            }
            if (getVisibility() == 0) {
                if (this.f3956b != null) {
                    this.f3956b.setVisibility(0);
                }
                this.f3970p.removeMessages(1);
                this.f3970p.sendMessageDelayed(this.f3970p.obtainMessage(1), 1500);
            }
        }
    }

    private void m5677b(int i) {
        if (this.f3966l != null) {
            if (i < 0) {
                i = 0;
            }
            int paddingTop = getPaddingTop();
            float height = ((float) ((getHeight() - paddingTop) - getPaddingBottom())) / ((float) this.f3966l.f3948e.length);
            this.f3966l.m5669a(((((float) paddingTop) + (((float) i) * height)) + (height / 2.0f)) + 1.0f, this.f3965k);
        }
    }
}
