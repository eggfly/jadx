package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.C0417R;
import android.support.v7.view.C0423c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import anet.channel.p017a.C0646b;
import com.xiaomi.pushsdk.BuildConfig;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.android.spdy.TnetStatusCode;

public class SearchView extends an implements C0423c {
    static final C0535a f1574a;
    private static final boolean f1575b;
    private boolean f1576A;
    private boolean f1577B;
    private int f1578C;
    private boolean f1579D;
    private CharSequence f1580E;
    private boolean f1581F;
    private int f1582G;
    private SearchableInfo f1583H;
    private Bundle f1584I;
    private Runnable f1585J;
    private final Runnable f1586K;
    private Runnable f1587L;
    private final WeakHashMap<String, ConstantState> f1588M;
    private final SearchAutoComplete f1589c;
    private final View f1590d;
    private final View f1591e;
    private final ImageView f1592f;
    private final ImageView f1593g;
    private final ImageView f1594h;
    private final ImageView f1595i;
    private final ImageView f1596j;
    private final Drawable f1597k;
    private final int f1598l;
    private final int f1599m;
    private final Intent f1600n;
    private final Intent f1601o;
    private final CharSequence f1602p;
    private C0537c f1603q;
    private C0536b f1604r;
    private OnFocusChangeListener f1605s;
    private C0538d f1606t;
    private OnClickListener f1607u;
    private boolean f1608v;
    private boolean f1609w;
    private CursorAdapter f1610x;
    private boolean f1611y;
    private CharSequence f1612z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        boolean f1563a;

        /* renamed from: android.support.v7.widget.SearchView.SavedState.1 */
        static class C05331 implements Creator<SavedState> {
            C05331() {
            }

            public SavedState m1942a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m1943a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1942a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1943a(i);
            }
        }

        static {
            CREATOR = new C05331();
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1563a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1563a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1563a));
        }
    }

    public static class SearchAutoComplete extends C0534f {
        private int f1568a;
        private SearchView f1569b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0417R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1568a = getThreshold();
        }

        public boolean enoughToFilter() {
            return this.f1568a <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1569b.m1974d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1569b.clearFocus();
                        this.f1569b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1569b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m1953a(getContext())) {
                    SearchView.f1574a.m1945a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1569b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1568a = i;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.a */
    private static class C0535a {
        private Method f1570a;
        private Method f1571b;
        private Method f1572c;
        private Method f1573d;

        C0535a() {
            try {
                this.f1570a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1570a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1571b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1571b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1572c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1572c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1573d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1573d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m1944a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1570a != null) {
                try {
                    this.f1570a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m1945a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1572c != null) {
                try {
                    this.f1572c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void m1946b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1571b != null) {
                try {
                    this.f1571b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.b */
    public interface C0536b {
        boolean m1947a();
    }

    /* renamed from: android.support.v7.widget.SearchView.c */
    public interface C0537c {
        boolean m1948a(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView.d */
    public interface C0538d {
    }

    static {
        f1575b = VERSION.SDK_INT >= 8;
        f1574a = new C0535a();
    }

    private Intent m1949a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1580E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1584I != null) {
            intent.putExtra("app_data", this.f1584I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1575b) {
            intent.setComponent(this.f1583H.getSearchActivity());
        }
        return intent;
    }

    private void m1950a(int i, String str, String str2) {
        getContext().startActivity(m1949a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void m1952a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f1609w = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1589c.getText());
        this.f1592f.setVisibility(i2);
        m1955b(z3);
        this.f1590d.setVisibility(z ? 8 : 0);
        if (!(this.f1596j.getDrawable() == null || this.f1608v)) {
            i = 0;
        }
        this.f1596j.setVisibility(i);
        m1960h();
        if (z3) {
            z2 = false;
        }
        m1956c(z2);
        m1959g();
    }

    static boolean m1953a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m1954b(CharSequence charSequence) {
        if (!this.f1608v || this.f1597k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1589c.getTextSize()) * 1.25d);
        this.f1597k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1597k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m1955b(boolean z) {
        int i = 8;
        if (this.f1611y && m1958f() && hasFocus() && (z || !this.f1579D)) {
            i = 0;
        }
        this.f1593g.setVisibility(i);
    }

    private void m1956c(boolean z) {
        int i;
        if (this.f1579D && !m1973c() && z) {
            i = 0;
            this.f1593g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1595i.setVisibility(i);
    }

    @TargetApi(8)
    private boolean m1957e() {
        if (this.f1583H == null || !this.f1583H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1583H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1600n;
        } else if (this.f1583H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1601o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, AccessibilityNodeInfoCompat.ACTION_CUT) == null) ? false : true;
    }

    private boolean m1958f() {
        return (this.f1611y || this.f1579D) && !m1973c();
    }

    private void m1959g() {
        int i = 8;
        if (m1958f() && (this.f1593g.getVisibility() == 0 || this.f1595i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1591e.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0417R.dimen.abc_search_view_preferred_width);
    }

    private void m1960h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1589c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1608v || this.f1581F)) {
            i = 0;
        }
        ImageView imageView = this.f1594h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1594h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m1961i() {
        post(this.f1586K);
    }

    private void m1962k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1589c;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(m1954b(queryHint));
    }

    @TargetApi(8)
    private void m1963l() {
        int i = 1;
        this.f1589c.setThreshold(this.f1583H.getSuggestThreshold());
        this.f1589c.setImeOptions(this.f1583H.getImeOptions());
        int inputType = this.f1583H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1583H.getSuggestAuthority() != null) {
                inputType = (inputType | AccessibilityNodeInfoCompat.ACTION_CUT) | C0646b.MAX_POOL_SIZE;
            }
        }
        this.f1589c.setInputType(inputType);
        if (this.f1610x != null) {
            this.f1610x.changeCursor(null);
        }
        if (this.f1583H.getSuggestAuthority() != null) {
            this.f1610x = new bb(getContext(), this, this.f1583H, this.f1588M);
            this.f1589c.setAdapter(this.f1610x);
            bb bbVar = (bb) this.f1610x;
            if (this.f1576A) {
                i = 2;
            }
            bbVar.m2490a(i);
        }
    }

    private void m1964m() {
        CharSequence text = this.f1589c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f1603q == null || !this.f1603q.m1948a(text.toString())) {
                if (this.f1583H != null) {
                    m1950a(0, null, text.toString());
                }
                setImeVisibility(false);
                m1965n();
            }
        }
    }

    private void m1965n() {
        this.f1589c.dismissDropDown();
    }

    private void m1966o() {
        if (!TextUtils.isEmpty(this.f1589c.getText())) {
            this.f1589c.setText(BuildConfig.FLAVOR);
            this.f1589c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1608v) {
        } else {
            if (this.f1604r == null || !this.f1604r.m1947a()) {
                clearFocus();
                m1952a(true);
            }
        }
    }

    private void m1967p() {
        m1952a(false);
        this.f1589c.requestFocus();
        setImeVisibility(true);
        if (this.f1607u != null) {
            this.f1607u.onClick(this);
        }
    }

    private void m1968q() {
        f1574a.m1944a(this.f1589c);
        f1574a.m1946b(this.f1589c);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1585J);
            return;
        }
        removeCallbacks(this.f1585J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1589c.setText(charSequence);
        this.f1589c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void m1969a() {
        if (!this.f1581F) {
            this.f1581F = true;
            this.f1582G = this.f1589c.getImeOptions();
            this.f1589c.setImeOptions(this.f1582G | 33554432);
            this.f1589c.setText(BuildConfig.FLAVOR);
            setIconified(false);
        }
    }

    void m1970a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m1971a(CharSequence charSequence, boolean z) {
        this.f1589c.setText(charSequence);
        if (charSequence != null) {
            this.f1589c.setSelection(this.f1589c.length());
            this.f1580E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m1964m();
        }
    }

    public void m1972b() {
        m1971a(BuildConfig.FLAVOR, false);
        clearFocus();
        m1952a(true);
        this.f1589c.setImeOptions(this.f1582G);
        this.f1581F = false;
    }

    public boolean m1973c() {
        return this.f1609w;
    }

    public void clearFocus() {
        this.f1577B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1589c.clearFocus();
        this.f1577B = false;
    }

    void m1974d() {
        m1952a(m1973c());
        m1961i();
        if (this.f1589c.hasFocus()) {
            m1968q();
        }
    }

    public int getImeOptions() {
        return this.f1589c.getImeOptions();
    }

    public int getInputType() {
        return this.f1589c.getInputType();
    }

    public int getMaxWidth() {
        return this.f1578C;
    }

    public CharSequence getQuery() {
        return this.f1589c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1612z != null ? this.f1612z : (!f1575b || this.f1583H == null || this.f1583H.getHintId() == 0) ? this.f1602p : getContext().getText(this.f1583H.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f1599m;
    }

    int getSuggestionRowLayout() {
        return this.f1598l;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.f1610x;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1586K);
        post(this.f1587L);
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        if (m1973c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case LinearLayoutManager.INVALID_OFFSET /*-2147483648*/:
                if (this.f1578C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1578C, size);
                    break;
                }
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                if (this.f1578C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1578C;
                    break;
                }
            case 1073741824:
                if (this.f1578C > 0) {
                    size = Math.min(this.f1578C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m1952a(savedState.f1563a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1563a = m1973c();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1961i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1577B || !isFocusable()) {
            return false;
        }
        if (m1973c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1589c.requestFocus(i, rect);
        if (requestFocus) {
            m1952a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1584I = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m1966o();
        } else {
            m1967p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1608v != z) {
            this.f1608v = z;
            m1952a(z);
            m1962k();
        }
    }

    public void setImeOptions(int i) {
        this.f1589c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1589c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1578C = i;
        requestLayout();
    }

    public void setOnCloseListener(C0536b c0536b) {
        this.f1604r = c0536b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f1605s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0537c c0537c) {
        this.f1603q = c0537c;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f1607u = onClickListener;
    }

    public void setOnSuggestionListener(C0538d c0538d) {
        this.f1606t = c0538d;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1612z = charSequence;
        m1962k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1576A = z;
        if (this.f1610x instanceof bb) {
            ((bb) this.f1610x).m2490a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1583H = searchableInfo;
        if (this.f1583H != null) {
            if (f1575b) {
                m1963l();
            }
            m1962k();
        }
        boolean z = f1575b && m1957e();
        this.f1579D = z;
        if (this.f1579D) {
            this.f1589c.setPrivateImeOptions("nm");
        }
        m1952a(m1973c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1611y = z;
        m1952a(m1973c());
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.f1610x = cursorAdapter;
        this.f1589c.setAdapter(this.f1610x);
    }
}
