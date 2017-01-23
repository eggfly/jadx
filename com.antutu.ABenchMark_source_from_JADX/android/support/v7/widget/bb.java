package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.support.v7.appcompat.C0417R;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import org.android.agoo.message.MessageService;
import org.android.spdy.SpdyProtocol;

class bb extends ResourceCursorAdapter implements OnClickListener {
    private final SearchManager f1954a;
    private final SearchView f1955b;
    private final SearchableInfo f1956c;
    private final Context f1957d;
    private final WeakHashMap<String, ConstantState> f1958e;
    private final int f1959f;
    private boolean f1960g;
    private int f1961h;
    private ColorStateList f1962i;
    private int f1963j;
    private int f1964k;
    private int f1965l;
    private int f1966m;
    private int f1967n;
    private int f1968o;

    /* renamed from: android.support.v7.widget.bb.a */
    private static final class C0592a {
        public final TextView f1949a;
        public final TextView f1950b;
        public final ImageView f1951c;
        public final ImageView f1952d;
        public final ImageView f1953e;

        public C0592a(View view) {
            this.f1949a = (TextView) view.findViewById(16908308);
            this.f1950b = (TextView) view.findViewById(16908309);
            this.f1951c = (ImageView) view.findViewById(16908295);
            this.f1952d = (ImageView) view.findViewById(16908296);
            this.f1953e = (ImageView) view.findViewById(C0417R.id.edit_query);
        }
    }

    public bb(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1960g = false;
        this.f1961h = 1;
        this.f1963j = -1;
        this.f1964k = -1;
        this.f1965l = -1;
        this.f1966m = -1;
        this.f1967n = -1;
        this.f1968o = -1;
        this.f1954a = (SearchManager) this.mContext.getSystemService("search");
        this.f1955b = searchView;
        this.f1956c = searchableInfo;
        this.f1959f = searchView.getSuggestionCommitIconResId();
        this.f1957d = context;
        this.f1958e = weakHashMap;
    }

    private Drawable m2473a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1958e.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f1958e.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f1957d.getResources());
        } else {
            Drawable b = m2482b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f1958e.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m2474a(String str) {
        Drawable b;
        if (str == null || str.length() == 0 || MessageService.MSG_DB_READY_REPORT.equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1957d.getPackageName() + "/" + parseInt;
            b = m2485b(str2);
            if (b != null) {
                return b;
            }
            b = ContextCompat.getDrawable(this.f1957d, parseInt);
            m2481a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m2485b(str);
            if (b != null) {
                return b;
            }
            b = m2484b(Uri.parse(str));
            m2481a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private CharSequence m2475a(CharSequence charSequence) {
        if (this.f1962i == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C0417R.attr.textColorSearchUrl, typedValue, true);
            this.f1962i = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1962i, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private static String m2476a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m2477a(Cursor cursor, String str) {
        return m2476a(cursor, cursor.getColumnIndex(str));
    }

    private void m2478a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private void m2479a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m2480a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m2481a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1958e.put(str, drawable.getConstantState());
        }
    }

    private Drawable m2482b(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, SpdyProtocol.SLIGHTSSLV2);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m2483b(Cursor cursor) {
        if (this.f1966m == -1) {
            return null;
        }
        Drawable a = m2474a(cursor.getString(this.f1966m));
        return a == null ? m2487d(cursor) : a;
    }

    private Drawable m2484b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m2489a(uri);
            }
            openInputStream = this.f1957d.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m2485b(String str) {
        ConstantState constantState = (ConstantState) this.f1958e.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private Drawable m2486c(Cursor cursor) {
        return this.f1967n == -1 ? null : m2474a(cursor.getString(this.f1967n));
    }

    private Drawable m2487d(Cursor cursor) {
        Drawable a = m2473a(this.f1956c.getSearchActivity());
        return a != null ? a : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m2488a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    Drawable m2489a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public void m2490a(int i) {
        this.f1961h = i;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        C0592a c0592a = (C0592a) view.getTag();
        int i = this.f1968o != -1 ? cursor.getInt(this.f1968o) : 0;
        if (c0592a.f1949a != null) {
            m2480a(c0592a.f1949a, m2476a(cursor, this.f1963j));
        }
        if (c0592a.f1950b != null) {
            CharSequence a = m2476a(cursor, this.f1965l);
            a = a != null ? m2475a(a) : m2476a(cursor, this.f1964k);
            if (TextUtils.isEmpty(a)) {
                if (c0592a.f1949a != null) {
                    c0592a.f1949a.setSingleLine(false);
                    c0592a.f1949a.setMaxLines(2);
                }
            } else if (c0592a.f1949a != null) {
                c0592a.f1949a.setSingleLine(true);
                c0592a.f1949a.setMaxLines(1);
            }
            m2480a(c0592a.f1950b, a);
        }
        if (c0592a.f1951c != null) {
            m2479a(c0592a.f1951c, m2483b(cursor), 4);
        }
        if (c0592a.f1952d != null) {
            m2479a(c0592a.f1952d, m2486c(cursor), 8);
        }
        if (this.f1961h == 2 || (this.f1961h == 1 && (i & 1) != 0)) {
            c0592a.f1953e.setVisibility(0);
            c0592a.f1953e.setTag(c0592a.f1949a.getText());
            c0592a.f1953e.setOnClickListener(this);
            return;
        }
        c0592a.f1953e.setVisibility(8);
    }

    public void changeCursor(Cursor cursor) {
        if (this.f1960g) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.f1963j = cursor.getColumnIndex("suggest_text_1");
                this.f1964k = cursor.getColumnIndex("suggest_text_2");
                this.f1965l = cursor.getColumnIndex("suggest_text_2_url");
                this.f1966m = cursor.getColumnIndex("suggest_icon_1");
                this.f1967n = cursor.getColumnIndex("suggest_icon_2");
                this.f1968o = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m2477a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1956c.shouldRewriteQueryFromData()) {
            a = m2477a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f1956c.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m2477a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            if (newView != null) {
                ((C0592a) newView.getTag()).f1949a.setText(e.toString());
            }
            return newView;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new C0592a(newView));
        ((ImageView) newView.findViewById(C0417R.id.edit_query)).setImageResource(this.f1959f);
        return newView;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2478a(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2478a(getCursor());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1955b.m1970a((CharSequence) tag);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f1955b.getVisibility() != 0 || this.f1955b.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m2488a(this.f1956c, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }
}
