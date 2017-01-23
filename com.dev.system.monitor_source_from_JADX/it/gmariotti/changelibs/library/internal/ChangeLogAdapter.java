package it.gmariotti.changelibs.library.internal;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.changelibs.C0216R;
import it.gmariotti.changelibs.library.Constants;
import java.util.List;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class ChangeLogAdapter extends ArrayAdapter<ChangeLogRow> {
    protected static final int TYPE_HEADER = 1;
    protected static final int TYPE_ROW = 0;
    private final Context mContext;
    private int mRowHeaderLayoutId;
    private int mRowLayoutId;
    private int mStringVersionHeader;

    static class ViewHolderHeader {
        TextView date;
        TextView version;

        public ViewHolderHeader(TextView version, TextView date) {
            this.version = version;
            this.date = date;
        }
    }

    static class ViewHolderRow {
        TextView bulletText;
        TextView text;

        public ViewHolderRow(TextView text, TextView bulletText) {
            this.text = text;
            this.bulletText = bulletText;
        }
    }

    public ChangeLogAdapter(Context context, List<ChangeLogRow> items) {
        super(context, 0, items);
        this.mRowLayoutId = Constants.mRowLayoutId;
        this.mRowHeaderLayoutId = Constants.mRowHeaderLayoutId;
        this.mStringVersionHeader = Constants.mStringVersionHeader;
        this.mContext = context;
    }

    public boolean isEnabled(int position) {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChangeLogRow item = (ChangeLogRow) getItem(position);
        View view = convertView;
        LayoutInflater mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        switch (getItemViewType(position)) {
            case Card.CLICK_LISTENER_ALL_VIEW /*0*/:
                ViewHolderRow viewHolder = null;
                if (view != null) {
                    ViewHolderRow obj = view.getTag();
                    if (obj instanceof ViewHolderRow) {
                        viewHolder = obj;
                    } else {
                        viewHolder = null;
                    }
                }
                if (view == null || viewHolder == null) {
                    view = mInflater.inflate(this.mRowLayoutId, parent, false);
                    viewHolder = new ViewHolderRow((TextView) view.findViewById(C0216R.id.chg_text), (TextView) view.findViewById(C0216R.id.chg_textbullet));
                    view.setTag(viewHolder);
                }
                if (!(item == null || viewHolder == null)) {
                    if (viewHolder.text != null) {
                        viewHolder.text.setText(Html.fromHtml(item.getChangeText(this.mContext)));
                        viewHolder.text.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                    if (viewHolder.bulletText != null) {
                        if (!item.isBulletedList()) {
                            viewHolder.bulletText.setVisibility(8);
                            break;
                        }
                        viewHolder.bulletText.setVisibility(0);
                        break;
                    }
                }
                break;
            case TYPE_HEADER /*1*/:
                ViewHolderHeader viewHolderHeader = null;
                if (view != null) {
                    ViewHolderHeader obj2 = view.getTag();
                    if (obj2 instanceof ViewHolderHeader) {
                        viewHolderHeader = obj2;
                    } else {
                        viewHolderHeader = null;
                    }
                }
                if (view == null || viewHolderHeader == null) {
                    view = mInflater.inflate(this.mRowHeaderLayoutId, parent, false);
                    TextView textHeader = (TextView) view.findViewById(C0216R.id.chg_headerVersion);
                    textHeader.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    TextView textDate = (TextView) view.findViewById(C0216R.id.chg_headerDate);
                    textDate.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    viewHolderHeader = new ViewHolderHeader(textHeader, textDate);
                    view.setTag(viewHolderHeader);
                }
                if (!(item == null || viewHolderHeader == null)) {
                    if (viewHolderHeader.version != null) {
                        StringBuilder sb = new StringBuilder();
                        String versionHeaderString = getContext().getString(this.mStringVersionHeader);
                        if (versionHeaderString != null) {
                            sb.append(versionHeaderString);
                        }
                        sb.append(item.versionName);
                        viewHolderHeader.version.setText(sb.toString());
                    }
                    if (viewHolderHeader.date != null) {
                        if (item.changeDate == null) {
                            viewHolderHeader.date.setText(BuildConfig.VERSION_NAME);
                            viewHolderHeader.date.setVisibility(8);
                            break;
                        }
                        viewHolderHeader.date.setText(item.changeDate);
                        viewHolderHeader.date.setVisibility(0);
                        break;
                    }
                }
                break;
        }
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int position) {
        if (((ChangeLogRow) getItem(position)).isHeader()) {
            return TYPE_HEADER;
        }
        return 0;
    }

    public int getmRowLayoutId() {
        return this.mRowLayoutId;
    }

    public void setmRowLayoutId(int mRowLayoutId) {
        this.mRowLayoutId = mRowLayoutId;
    }

    public int getmRowHeaderLayoutId() {
        return this.mRowHeaderLayoutId;
    }

    public void setmRowHeaderLayoutId(int mRowHeaderLayoutId) {
        this.mRowHeaderLayoutId = mRowHeaderLayoutId;
    }

    public int getmStringVersionHeader() {
        return this.mStringVersionHeader;
    }

    public void setmStringVersionHeader(int mStringVersionHeader) {
        this.mStringVersionHeader = mStringVersionHeader;
    }
}
