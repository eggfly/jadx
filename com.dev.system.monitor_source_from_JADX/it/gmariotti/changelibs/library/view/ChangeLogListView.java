package it.gmariotti.changelibs.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import it.gmariotti.changelibs.C0216R;
import it.gmariotti.changelibs.library.Constants;
import it.gmariotti.changelibs.library.Util;
import it.gmariotti.changelibs.library.internal.ChangeLog;
import it.gmariotti.changelibs.library.internal.ChangeLogAdapter;
import it.gmariotti.changelibs.library.internal.ChangeLogRow;
import it.gmariotti.changelibs.library.parser.XmlParser;
import java.util.Iterator;

public class ChangeLogListView extends ListView implements OnItemClickListener {
    protected static String TAG;
    protected ChangeLogAdapter mAdapter;
    protected int mChangeLogFileResourceId;
    protected String mChangeLogFileResourceUrl;
    protected int mRowHeaderLayoutId;
    protected int mRowLayoutId;

    protected class ParseAsyncTask extends AsyncTask<Void, Void, ChangeLog> {
        private ChangeLogAdapter mAdapter;
        private XmlParser mParse;

        public ParseAsyncTask(ChangeLogAdapter adapter, XmlParser parse) {
            this.mAdapter = adapter;
            this.mParse = parse;
        }

        protected ChangeLog doInBackground(Void... params) {
            try {
                if (this.mParse != null) {
                    return this.mParse.readChangeLogFile();
                }
            } catch (Exception e) {
                Log.e(ChangeLogListView.TAG, ChangeLogListView.this.getResources().getString(C0216R.string.changelog_internal_error_parsing), e);
            }
            return null;
        }

        protected void onPostExecute(ChangeLog chg) {
            if (chg != null) {
                if (VERSION.SDK_INT >= 11) {
                    this.mAdapter.addAll(chg.getRows());
                } else if (chg.getRows() != null) {
                    Iterator it = chg.getRows().iterator();
                    while (it.hasNext()) {
                        this.mAdapter.add((ChangeLogRow) it.next());
                    }
                }
                this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    static {
        TAG = "ChangeLogListView";
    }

    public ChangeLogListView(Context context) {
        super(context);
        this.mRowLayoutId = Constants.mRowLayoutId;
        this.mRowHeaderLayoutId = Constants.mRowHeaderLayoutId;
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
        init(null, 0);
    }

    public ChangeLogListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mRowLayoutId = Constants.mRowLayoutId;
        this.mRowHeaderLayoutId = Constants.mRowHeaderLayoutId;
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
        init(attrs, 0);
    }

    public ChangeLogListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mRowLayoutId = Constants.mRowLayoutId;
        this.mRowHeaderLayoutId = Constants.mRowHeaderLayoutId;
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);
        initAdapter();
        setDividerHeight(0);
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C0216R.styleable.ChangeLogListView, defStyle, defStyle);
        try {
            this.mRowLayoutId = a.getResourceId(C0216R.styleable.ChangeLogListView_rowLayoutId, this.mRowLayoutId);
            this.mRowHeaderLayoutId = a.getResourceId(C0216R.styleable.ChangeLogListView_rowHeaderLayoutId, this.mRowHeaderLayoutId);
            this.mChangeLogFileResourceId = a.getResourceId(C0216R.styleable.ChangeLogListView_changeLogFileResourceId, this.mChangeLogFileResourceId);
            this.mChangeLogFileResourceUrl = a.getString(C0216R.styleable.ChangeLogListView_changeLogFileResourceUrl);
        } finally {
            a.recycle();
        }
    }

    protected void initAdapter() {
        try {
            XmlParser parse;
            if (this.mChangeLogFileResourceUrl != null) {
                parse = new XmlParser(getContext(), this.mChangeLogFileResourceUrl);
            } else {
                parse = new XmlParser(getContext(), this.mChangeLogFileResourceId);
            }
            ChangeLog chg = new ChangeLog();
            if (chg != null) {
                this.mAdapter = new ChangeLogAdapter(getContext(), chg.getRows());
                this.mAdapter.setmRowLayoutId(this.mRowLayoutId);
                this.mAdapter.setmRowHeaderLayoutId(this.mRowHeaderLayoutId);
                if (this.mChangeLogFileResourceUrl == null || (this.mChangeLogFileResourceUrl != null && Util.isConnected(getContext()))) {
                    new ParseAsyncTask(this.mAdapter, parse).execute(new Void[0]);
                } else {
                    Toast.makeText(getContext(), C0216R.string.changelog_internal_error_internet_connection, 1).show();
                }
                setAdapter(this.mAdapter);
                return;
            }
            setAdapter(null);
        } catch (Exception e) {
            Log.e(TAG, getResources().getString(C0216R.string.changelog_internal_error_parsing), e);
        }
    }

    public void setAdapter(ChangeLogAdapter adapter) {
        super.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
    }
}
