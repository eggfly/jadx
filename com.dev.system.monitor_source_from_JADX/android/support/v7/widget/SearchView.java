package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.appcompat.C0056R;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import it.gmariotti.cardslib.library.internal.Card;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class SearchView extends LinearLayout implements CollapsibleActionView {
    private static final boolean DBG = false;
    static final AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    private static final String LOG_TAG = "SearchView";
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    private ImageView mCloseButton;
    private int mCollapsedImeOptions;
    private View mDropDownAnchor;
    private boolean mExpandedInActionView;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final OnClickListener mOnClickListener;
    private OnCloseListener mOnCloseListener;
    private final OnEditorActionListener mOnEditorActionListener;
    private final OnItemClickListener mOnItemClickListener;
    private final OnItemSelectedListener mOnItemSelectedListener;
    private OnQueryTextListener mOnQueryChangeListener;
    private OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private OnClickListener mOnSearchClickListener;
    private OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private SearchAutoComplete mQueryTextView;
    private Runnable mReleaseCursorRunnable;
    private View mSearchButton;
    private View mSearchEditFrame;
    private ImageView mSearchHintIcon;
    private View mSearchPlate;
    private SearchableInfo mSearchable;
    private Runnable mShowImeRunnable;
    private View mSubmitArea;
    private View mSubmitButton;
    private boolean mSubmitButtonEnabled;
    private CursorAdapter mSuggestionsAdapter;
    OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    private View mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    /* renamed from: android.support.v7.widget.SearchView.1 */
    class C00771 implements Runnable {
        C00771() {
        }

        public void run() {
            InputMethodManager imm = (InputMethodManager) SearchView.this.getContext().getSystemService("input_method");
            if (imm != null) {
                SearchView.HIDDEN_METHOD_INVOKER.showSoftInputUnchecked(imm, SearchView.this, 0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.2 */
    class C00782 implements Runnable {
        C00782() {
        }

        public void run() {
            SearchView.this.updateFocusedState();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.3 */
    class C00793 implements Runnable {
        C00793() {
        }

        public void run() {
            if (SearchView.this.mSuggestionsAdapter != null && (SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter)) {
                SearchView.this.mSuggestionsAdapter.changeCursor(null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.4 */
    class C00804 implements OnFocusChangeListener {
        C00804() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (SearchView.this.mOnQueryTextFocusChangeListener != null) {
                SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.5 */
    class C00815 implements OnLayoutChangeListener {
        C00815() {
        }

        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            SearchView.this.adjustDropDownSizeAndPosition();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.6 */
    class C00826 implements OnGlobalLayoutListener {
        C00826() {
        }

        public void onGlobalLayout() {
            SearchView.this.adjustDropDownSizeAndPosition();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.7 */
    class C00837 implements OnClickListener {
        C00837() {
        }

        public void onClick(View v) {
            if (v == SearchView.this.mSearchButton) {
                SearchView.this.onSearchClicked();
            } else if (v == SearchView.this.mCloseButton) {
                SearchView.this.onCloseClicked();
            } else if (v == SearchView.this.mSubmitButton) {
                SearchView.this.onSubmitQuery();
            } else if (v == SearchView.this.mVoiceButton) {
                SearchView.this.onVoiceClicked();
            } else if (v == SearchView.this.mQueryTextView) {
                SearchView.this.forceSuggestionQuery();
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.8 */
    class C00848 implements OnKeyListener {
        C00848() {
        }

        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (SearchView.this.mSearchable == null) {
                return SearchView.DBG;
            }
            if (SearchView.this.mQueryTextView.isPopupShowing() && SearchView.this.mQueryTextView.getListSelection() != -1) {
                return SearchView.this.onSuggestionsKey(v, keyCode, event);
            }
            if (SearchView.this.mQueryTextView.isEmpty() || !KeyEventCompat.hasNoModifiers(event) || event.getAction() != 1 || keyCode != 66) {
                return SearchView.DBG;
            }
            v.cancelLongPress();
            SearchView.this.launchQuerySearch(0, null, SearchView.this.mQueryTextView.getText().toString());
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.9 */
    class C00859 implements OnEditorActionListener {
        C00859() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            SearchView.this.onSubmitQuery();
            return true;
        }
    }

    private static class AutoCompleteTextViewReflector {
        private Method doAfterTextChanged;
        private Method doBeforeTextChanged;
        private Method ensureImeVisible;
        private Method showSoftInputUnchecked;

        AutoCompleteTextViewReflector() {
            try {
                this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.doBeforeTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.doAfterTextChanged.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.ensureImeVisible.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.showSoftInputUnchecked.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void doBeforeTextChanged(AutoCompleteTextView view) {
            if (this.doBeforeTextChanged != null) {
                try {
                    this.doBeforeTextChanged.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void doAfterTextChanged(AutoCompleteTextView view) {
            if (this.doAfterTextChanged != null) {
                try {
                    this.doAfterTextChanged.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void ensureImeVisible(AutoCompleteTextView view, boolean visible) {
            if (this.ensureImeVisible != null) {
                try {
                    this.ensureImeVisible.invoke(view, new Object[]{Boolean.valueOf(visible)});
                } catch (Exception e) {
                }
            }
        }

        void showSoftInputUnchecked(InputMethodManager imm, View view, int flags) {
            if (this.showSoftInputUnchecked != null) {
                try {
                    this.showSoftInputUnchecked.invoke(imm, new Object[]{Integer.valueOf(flags), null});
                    return;
                } catch (Exception e) {
                }
            }
            imm.showSoftInput(view, flags);
        }
    }

    public interface OnCloseListener {
        boolean onClose();
    }

    public interface OnQueryTextListener {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    public interface OnSuggestionListener {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    public static class SearchAutoComplete extends AutoCompleteTextView {
        private SearchView mSearchView;
        private int mThreshold;

        public SearchAutoComplete(Context context) {
            super(context);
            this.mThreshold = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.mThreshold = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            this.mThreshold = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            this.mThreshold = threshold;
        }

        private boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0 ? true : SearchView.DBG;
        }

        protected void replaceText(CharSequence text) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
            if (hasWindowFocus && this.mSearchView.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.isLandscapeMode(getContext())) {
                    SearchView.HIDDEN_METHOD_INVOKER.ensureImeVisible(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            this.mSearchView.onTextFocusChanged();
        }

        public boolean enoughToFilter() {
            return (this.mThreshold <= 0 || super.enoughToFilter()) ? true : SearchView.DBG;
        }

        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == 4) {
                DispatcherState state;
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    state = getKeyDispatcherState();
                    if (state == null) {
                        return true;
                    }
                    state.startTracking(event, this);
                    return true;
                } else if (event.getAction() == 1) {
                    state = getKeyDispatcherState();
                    if (state != null) {
                        state.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        this.mSearchView.clearFocus();
                        this.mSearchView.setImeVisibility(SearchView.DBG);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }
    }

    static {
        HIDDEN_METHOD_INVOKER = new AutoCompleteTextViewReflector();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mShowImeRunnable = new C00771();
        this.mUpdateDrawableStateRunnable = new C00782();
        this.mReleaseCursorRunnable = new C00793();
        this.mOutsideDrawablesCache = new WeakHashMap();
        this.mOnClickListener = new C00837();
        this.mTextKeyListener = new C00848();
        this.mOnEditorActionListener = new C00859();
        this.mOnItemClickListener = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                SearchView.this.onItemClicked(position, 0, null);
            }
        };
        this.mOnItemSelectedListener = new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                SearchView.this.onItemSelected(position);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.mTextWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int after) {
                SearchView.this.onTextChanged(s);
            }

            public void afterTextChanged(Editable s) {
            }
        };
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0056R.layout.abc_search_view, this, true);
        this.mSearchButton = findViewById(C0056R.id.search_button);
        this.mQueryTextView = (SearchAutoComplete) findViewById(C0056R.id.search_src_text);
        this.mQueryTextView.setSearchView(this);
        this.mSearchEditFrame = findViewById(C0056R.id.search_edit_frame);
        this.mSearchPlate = findViewById(C0056R.id.search_plate);
        this.mSubmitArea = findViewById(C0056R.id.submit_area);
        this.mSubmitButton = findViewById(C0056R.id.search_go_btn);
        this.mCloseButton = (ImageView) findViewById(C0056R.id.search_close_btn);
        this.mVoiceButton = findViewById(C0056R.id.search_voice_btn);
        this.mSearchHintIcon = (ImageView) findViewById(C0056R.id.search_mag_icon);
        this.mSearchButton.setOnClickListener(this.mOnClickListener);
        this.mCloseButton.setOnClickListener(this.mOnClickListener);
        this.mSubmitButton.setOnClickListener(this.mOnClickListener);
        this.mVoiceButton.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.setOnClickListener(this.mOnClickListener);
        this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
        this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
        this.mQueryTextView.setOnItemClickListener(this.mOnItemClickListener);
        this.mQueryTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
        this.mQueryTextView.setOnKeyListener(this.mTextKeyListener);
        this.mQueryTextView.setOnFocusChangeListener(new C00804());
        TypedArray a = context.obtainStyledAttributes(attrs, C0056R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(3, true));
        int maxWidth = a.getDimensionPixelSize(0, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        CharSequence queryHint = a.getText(4);
        if (!TextUtils.isEmpty(queryHint)) {
            setQueryHint(queryHint);
        }
        int imeOptions = a.getInt(2, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a.getInt(1, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }
        a.recycle();
        a = context.obtainStyledAttributes(attrs, C0056R.styleable.View, 0, 0);
        boolean focusable = a.getBoolean(0, true);
        a.recycle();
        setFocusable(focusable);
        this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
        this.mVoiceWebSearchIntent.addFlags(268435456);
        this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.mVoiceAppSearchIntent.addFlags(268435456);
        this.mDropDownAnchor = findViewById(this.mQueryTextView.getDropDownAnchor());
        if (this.mDropDownAnchor != null) {
            if (VERSION.SDK_INT >= 11) {
                addOnLayoutChangeListenerToDropDownAnchorSDK11();
            } else {
                addOnLayoutChangeListenerToDropDownAnchorBase();
            }
        }
        updateViewsVisibility(this.mIconifiedByDefault);
        updateQueryHint();
    }

    private void addOnLayoutChangeListenerToDropDownAnchorSDK11() {
        this.mDropDownAnchor.addOnLayoutChangeListener(new C00815());
    }

    private void addOnLayoutChangeListenerToDropDownAnchorBase() {
        this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new C00826());
    }

    public void setSearchableInfo(SearchableInfo searchable) {
        this.mSearchable = searchable;
        if (this.mSearchable != null) {
            updateSearchAutoComplete();
            updateQueryHint();
        }
        this.mVoiceButtonEnabled = hasVoiceSearch();
        if (this.mVoiceButtonEnabled) {
            this.mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        }
        updateViewsVisibility(isIconified());
    }

    public void setAppSearchData(Bundle appSearchData) {
        this.mAppSearchData = appSearchData;
    }

    public void setImeOptions(int imeOptions) {
        this.mQueryTextView.setImeOptions(imeOptions);
    }

    public int getImeOptions() {
        return this.mQueryTextView.getImeOptions();
    }

    public void setInputType(int inputType) {
        this.mQueryTextView.setInputType(inputType);
    }

    public int getInputType() {
        return this.mQueryTextView.getInputType();
    }

    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (this.mClearingFocus) {
            return DBG;
        }
        if (!isFocusable()) {
            return DBG;
        }
        if (isIconified()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        boolean result = this.mQueryTextView.requestFocus(direction, previouslyFocusedRect);
        if (!result) {
            return result;
        }
        updateViewsVisibility(DBG);
        return result;
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        setImeVisibility(DBG);
        super.clearFocus();
        this.mQueryTextView.clearFocus();
        this.mClearingFocus = DBG;
    }

    public void setOnQueryTextListener(OnQueryTextListener listener) {
        this.mOnQueryChangeListener = listener;
    }

    public void setOnCloseListener(OnCloseListener listener) {
        this.mOnCloseListener = listener;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        this.mOnQueryTextFocusChangeListener = listener;
    }

    public void setOnSuggestionListener(OnSuggestionListener listener) {
        this.mOnSuggestionListener = listener;
    }

    public void setOnSearchClickListener(OnClickListener listener) {
        this.mOnSearchClickListener = listener;
    }

    public CharSequence getQuery() {
        return this.mQueryTextView.getText();
    }

    public void setQuery(CharSequence query, boolean submit) {
        this.mQueryTextView.setText(query);
        if (query != null) {
            this.mQueryTextView.setSelection(this.mQueryTextView.length());
            this.mUserQuery = query;
        }
        if (submit && !TextUtils.isEmpty(query)) {
            onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence hint) {
        this.mQueryHint = hint;
        updateQueryHint();
    }

    public CharSequence getQueryHint() {
        if (this.mQueryHint != null) {
            return this.mQueryHint;
        }
        if (this.mSearchable == null) {
            return null;
        }
        int hintId = this.mSearchable.getHintId();
        if (hintId != 0) {
            return getContext().getString(hintId);
        }
        return null;
    }

    public void setIconifiedByDefault(boolean iconified) {
        if (this.mIconifiedByDefault != iconified) {
            this.mIconifiedByDefault = iconified;
            updateViewsVisibility(iconified);
            updateQueryHint();
        }
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public void setIconified(boolean iconify) {
        if (iconify) {
            onCloseClicked();
        } else {
            onSearchClicked();
        }
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public void setSubmitButtonEnabled(boolean enabled) {
        this.mSubmitButtonEnabled = enabled;
        updateViewsVisibility(isIconified());
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void setQueryRefinementEnabled(boolean enable) {
        this.mQueryRefinement = enable;
        if (this.mSuggestionsAdapter instanceof SuggestionsAdapter) {
            ((SuggestionsAdapter) this.mSuggestionsAdapter).setQueryRefinement(enable ? 2 : 1);
        }
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public void setSuggestionsAdapter(CursorAdapter adapter) {
        this.mSuggestionsAdapter = adapter;
        this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public void setMaxWidth(int maxpixels) {
        this.mMaxWidth = maxpixels;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (isIconified()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        switch (widthMode) {
            case ExploreByTouchHelper.INVALID_ID /*-2147483648*/:
                if (this.mMaxWidth <= 0) {
                    width = Math.min(getPreferredWidth(), width);
                    break;
                } else {
                    width = Math.min(this.mMaxWidth, width);
                    break;
                }
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                width = this.mMaxWidth > 0 ? this.mMaxWidth : getPreferredWidth();
                break;
            case 1073741824:
                if (this.mMaxWidth > 0) {
                    width = Math.min(this.mMaxWidth, width);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, 1073741824), heightMeasureSpec);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0056R.dimen.abc_search_view_preferred_width);
    }

    private void updateViewsVisibility(boolean collapsed) {
        int visCollapsed;
        boolean hasText;
        int i;
        boolean z = true;
        int i2 = 8;
        this.mIconified = collapsed;
        if (collapsed) {
            visCollapsed = 0;
        } else {
            visCollapsed = 8;
        }
        if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
            hasText = DBG;
        } else {
            hasText = true;
        }
        this.mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        View view = this.mSearchEditFrame;
        if (collapsed) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        ImageView imageView = this.mSearchHintIcon;
        if (!this.mIconifiedByDefault) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        updateCloseButton();
        if (hasText) {
            z = DBG;
        }
        updateVoiceButton(z);
        updateSubmitArea();
    }

    private boolean hasVoiceSearch() {
        if (this.mSearchable == null || !this.mSearchable.getVoiceSearchEnabled()) {
            return DBG;
        }
        Intent testIntent = null;
        if (this.mSearchable.getVoiceSearchLaunchWebSearch()) {
            testIntent = this.mVoiceWebSearchIntent;
        } else if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
            testIntent = this.mVoiceAppSearchIntent;
        }
        if (testIntent == null || getContext().getPackageManager().resolveActivity(testIntent, AccessibilityNodeInfoCompat.ACTION_CUT) == null) {
            return DBG;
        }
        return true;
    }

    private boolean isSubmitAreaEnabled() {
        return ((this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !isIconified()) ? true : DBG;
    }

    private void updateSubmitButton(boolean hasText) {
        int visibility = 8;
        if (this.mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus() && (hasText || !this.mVoiceButtonEnabled)) {
            visibility = 0;
        }
        this.mSubmitButton.setVisibility(visibility);
    }

    private void updateSubmitArea() {
        int visibility = 8;
        if (isSubmitAreaEnabled() && (this.mSubmitButton.getVisibility() == 0 || this.mVoiceButton.getVisibility() == 0)) {
            visibility = 0;
        }
        this.mSubmitArea.setVisibility(visibility);
    }

    private void updateCloseButton() {
        boolean hasText;
        boolean showClose = true;
        int i = 0;
        if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
            hasText = DBG;
        } else {
            hasText = true;
        }
        if (!hasText && (!this.mIconifiedByDefault || this.mExpandedInActionView)) {
            showClose = DBG;
        }
        ImageView imageView = this.mCloseButton;
        if (!showClose) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    private void postUpdateFocusedState() {
        post(this.mUpdateDrawableStateRunnable);
    }

    private void updateFocusedState() {
        boolean focused = this.mQueryTextView.hasFocus();
        this.mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        this.mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mUpdateDrawableStateRunnable);
        post(this.mReleaseCursorRunnable);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean visible) {
        if (visible) {
            post(this.mShowImeRunnable);
            return;
        }
        removeCallbacks(this.mShowImeRunnable);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void onQueryRefine(CharSequence queryText) {
        setQuery(queryText);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mSearchable == null) {
            return DBG;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        if (this.mSearchable == null || this.mSuggestionsAdapter == null || event.getAction() != 0 || !KeyEventCompat.hasNoModifiers(event)) {
            return DBG;
        }
        if (keyCode == 66 || keyCode == 84 || keyCode == 61) {
            return onItemClicked(this.mQueryTextView.getListSelection(), 0, null);
        }
        if (keyCode != 21 && keyCode != 22) {
            return (keyCode == 19 && this.mQueryTextView.getListSelection() == 0) ? DBG : DBG;
        } else {
            int selPoint;
            if (keyCode == 21) {
                selPoint = 0;
            } else {
                selPoint = this.mQueryTextView.length();
            }
            this.mQueryTextView.setSelection(selPoint);
            this.mQueryTextView.setListSelection(0);
            this.mQueryTextView.clearListSelection();
            HIDDEN_METHOD_INVOKER.ensureImeVisible(this.mQueryTextView, true);
            return true;
        }
    }

    private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C0056R.attr.searchViewSearchIcon, outValue, true);
        return outValue.resourceId;
    }

    private CharSequence getDecoratedHint(CharSequence hintText) {
        if (!this.mIconifiedByDefault) {
            return hintText;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (((double) this.mQueryTextView.getTextSize()) * 1.25d);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, 33);
        return ssb;
    }

    private void updateQueryHint() {
        if (this.mQueryHint != null) {
            this.mQueryTextView.setHint(getDecoratedHint(this.mQueryHint));
        } else if (this.mSearchable != null) {
            CharSequence hint = null;
            int hintId = this.mSearchable.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            if (hint != null) {
                this.mQueryTextView.setHint(getDecoratedHint(hint));
            }
        } else {
            this.mQueryTextView.setHint(getDecoratedHint(BuildConfig.VERSION_NAME));
        }
    }

    private void updateSearchAutoComplete() {
        int i = 1;
        this.mQueryTextView.setThreshold(this.mSearchable.getSuggestThreshold());
        this.mQueryTextView.setImeOptions(this.mSearchable.getImeOptions());
        int inputType = this.mSearchable.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.mSearchable.getSuggestAuthority() != null) {
                inputType = (inputType | AccessibilityNodeInfoCompat.ACTION_CUT) | AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
            }
        }
        this.mQueryTextView.setInputType(inputType);
        if (this.mSuggestionsAdapter != null) {
            this.mSuggestionsAdapter.changeCursor(null);
        }
        if (this.mSearchable.getSuggestAuthority() != null) {
            this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
            this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
            SuggestionsAdapter suggestionsAdapter = (SuggestionsAdapter) this.mSuggestionsAdapter;
            if (this.mQueryRefinement) {
                i = 2;
            }
            suggestionsAdapter.setQueryRefinement(i);
        }
    }

    private void updateVoiceButton(boolean empty) {
        int visibility = 8;
        if (this.mVoiceButtonEnabled && !isIconified() && empty) {
            visibility = 0;
            this.mSubmitButton.setVisibility(8);
        }
        this.mVoiceButton.setVisibility(visibility);
    }

    private void onTextChanged(CharSequence newText) {
        boolean hasText;
        boolean z = true;
        CharSequence text = this.mQueryTextView.getText();
        this.mUserQuery = text;
        if (TextUtils.isEmpty(text)) {
            hasText = DBG;
        } else {
            hasText = true;
        }
        updateSubmitButton(hasText);
        if (hasText) {
            z = DBG;
        }
        updateVoiceButton(z);
        updateCloseButton();
        updateSubmitArea();
        if (!(this.mOnQueryChangeListener == null || TextUtils.equals(newText, this.mOldQueryText))) {
            this.mOnQueryChangeListener.onQueryTextChange(newText.toString());
        }
        this.mOldQueryText = newText.toString();
    }

    private void onSubmitQuery() {
        CharSequence query = this.mQueryTextView.getText();
        if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            if (this.mOnQueryChangeListener == null || !this.mOnQueryChangeListener.onQueryTextSubmit(query.toString())) {
                if (this.mSearchable != null) {
                    launchQuerySearch(0, null, query.toString());
                    setImeVisibility(DBG);
                }
                dismissSuggestions();
            }
        }
    }

    private void dismissSuggestions() {
        this.mQueryTextView.dismissDropDown();
    }

    private void onCloseClicked() {
        if (!TextUtils.isEmpty(this.mQueryTextView.getText())) {
            this.mQueryTextView.setText(BuildConfig.VERSION_NAME);
            this.mQueryTextView.requestFocus();
            setImeVisibility(true);
        } else if (!this.mIconifiedByDefault) {
        } else {
            if (this.mOnCloseListener == null || !this.mOnCloseListener.onClose()) {
                clearFocus();
                updateViewsVisibility(true);
            }
        }
    }

    private void onSearchClicked() {
        updateViewsVisibility(DBG);
        this.mQueryTextView.requestFocus();
        setImeVisibility(true);
        if (this.mOnSearchClickListener != null) {
            this.mOnSearchClickListener.onClick(this);
        }
    }

    private void onVoiceClicked() {
        if (this.mSearchable != null) {
            SearchableInfo searchable = this.mSearchable;
            try {
                if (searchable.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, searchable));
                } else if (searchable.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, searchable));
                }
            } catch (ActivityNotFoundException e) {
                Log.w(LOG_TAG, "Could not find voice search activity");
            }
        }
    }

    void onTextFocusChanged() {
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if (this.mQueryTextView.hasFocus()) {
            forceSuggestionQuery();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
    }

    public void onActionViewCollapsed() {
        clearFocus();
        updateViewsVisibility(true);
        this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions);
        this.mExpandedInActionView = DBG;
    }

    public void onActionViewExpanded() {
        if (!this.mExpandedInActionView) {
            this.mExpandedInActionView = true;
            this.mCollapsedImeOptions = this.mQueryTextView.getImeOptions();
            this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions | 33554432);
            this.mQueryTextView.setText(BuildConfig.VERSION_NAME);
            setIconified(DBG);
        }
    }

    private void adjustDropDownSizeAndPosition() {
        if (this.mDropDownAnchor.getWidth() > 1) {
            Resources res = getContext().getResources();
            int anchorPadding = this.mSearchPlate.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            int iconOffset = this.mIconifiedByDefault ? res.getDimensionPixelSize(C0056R.dimen.abc_dropdownitem_icon_width) + res.getDimensionPixelSize(C0056R.dimen.abc_dropdownitem_text_padding_left) : 0;
            this.mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
            this.mQueryTextView.setDropDownHorizontalOffset(anchorPadding - (dropDownPadding.left + iconOffset));
            this.mQueryTextView.setDropDownWidth((((this.mDropDownAnchor.getWidth() + dropDownPadding.left) + dropDownPadding.right) + iconOffset) - anchorPadding);
        }
    }

    private boolean onItemClicked(int position, int actionKey, String actionMsg) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionClick(position)) {
            return DBG;
        }
        launchSuggestion(position, 0, null);
        setImeVisibility(DBG);
        dismissSuggestions();
        return true;
    }

    private boolean onItemSelected(int position) {
        if (this.mOnSuggestionListener != null && this.mOnSuggestionListener.onSuggestionSelect(position)) {
            return DBG;
        }
        rewriteQueryFromSuggestion(position);
        return true;
    }

    private void rewriteQueryFromSuggestion(int position) {
        CharSequence oldQuery = this.mQueryTextView.getText();
        Cursor c = this.mSuggestionsAdapter.getCursor();
        if (c != null) {
            if (c.moveToPosition(position)) {
                CharSequence newQuery = this.mSuggestionsAdapter.convertToString(c);
                if (newQuery != null) {
                    setQuery(newQuery);
                    return;
                } else {
                    setQuery(oldQuery);
                    return;
                }
            }
            setQuery(oldQuery);
        }
    }

    private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        Cursor c = this.mSuggestionsAdapter.getCursor();
        if (c == null || !c.moveToPosition(position)) {
            return DBG;
        }
        launchIntent(createIntentFromSuggestion(c, actionKey, actionMsg));
        return true;
    }

    private void launchIntent(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException ex) {
                Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
            }
        }
    }

    private void setQuery(CharSequence query) {
        this.mQueryTextView.setText(query);
        this.mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        getContext().startActivity(createIntent("android.intent.action.SEARCH", null, null, query, actionKey, actionMsg));
    }

    private Intent createIntent(String action, Uri data, String extraData, String query, int actionKey, String actionMsg) {
        Intent intent = new Intent(action);
        intent.addFlags(268435456);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.mUserQuery);
        if (query != null) {
            intent.putExtra("query", query);
        }
        if (extraData != null) {
            intent.putExtra("intent_extra_data_key", extraData);
        }
        if (this.mAppSearchData != null) {
            intent.putExtra("app_data", this.mAppSearchData);
        }
        if (actionKey != 0) {
            intent.putExtra("action_key", actionKey);
            intent.putExtra("action_msg", actionMsg);
        }
        intent.setComponent(this.mSearchable.getSearchActivity());
        return intent;
    }

    private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return voiceIntent;
    }

    private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        ComponentName searchActivity = searchable.getSearchActivity();
        Intent queryIntent = new Intent("android.intent.action.SEARCH");
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent, 1073741824);
        Bundle queryExtras = new Bundle();
        if (this.mAppSearchData != null) {
            queryExtras.putParcelable("app_data", this.mAppSearchData);
        }
        Intent voiceIntent = new Intent(baseIntent);
        String languageModel = "free_form";
        String prompt = null;
        String language = null;
        int maxResults = 1;
        Resources resources = getResources();
        if (searchable.getVoiceLanguageModeId() != 0) {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        }
        if (searchable.getVoicePromptTextId() != 0) {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        }
        if (searchable.getVoiceLanguageId() != 0) {
            language = resources.getString(searchable.getVoiceLanguageId());
        }
        if (searchable.getVoiceMaxResults() != 0) {
            maxResults = searchable.getVoiceMaxResults();
        }
        voiceIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", languageModel);
        voiceIntent.putExtra("android.speech.extra.PROMPT", prompt);
        voiceIntent.putExtra("android.speech.extra.LANGUAGE", language);
        voiceIntent.putExtra("android.speech.extra.MAX_RESULTS", maxResults);
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pending);
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", queryExtras);
        return voiceIntent;
    }

    private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        try {
            String action = SuggestionsAdapter.getColumnString(c, "suggest_intent_action");
            if (action == null) {
                action = this.mSearchable.getSuggestIntentAction();
            }
            if (action == null) {
                action = "android.intent.action.SEARCH";
            }
            String data = SuggestionsAdapter.getColumnString(c, "suggest_intent_data");
            if (data == null) {
                data = this.mSearchable.getSuggestIntentData();
            }
            if (data != null) {
                String id = SuggestionsAdapter.getColumnString(c, "suggest_intent_data_id");
                if (id != null) {
                    data = data + "/" + Uri.encode(id);
                }
            }
            return createIntent(action, data == null ? null : Uri.parse(data), SuggestionsAdapter.getColumnString(c, "suggest_intent_extra_data"), SuggestionsAdapter.getColumnString(c, "suggest_intent_query"), actionKey, actionMsg);
        } catch (RuntimeException e) {
            int rowNum;
            try {
                rowNum = c.getPosition();
            } catch (RuntimeException e2) {
                rowNum = -1;
            }
            Log.w(LOG_TAG, "Search suggestions cursor at row " + rowNum + " returned exception.", e);
            return null;
        }
    }

    private void forceSuggestionQuery() {
        HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mQueryTextView);
        HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mQueryTextView);
    }

    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? true : DBG;
    }
}
