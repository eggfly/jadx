package uk.me.lewisdeane.lnavigationdrawer;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

public class NavigationListView extends ListView {
    public static int mSelectedColour;
    private NavigationItemClickListener mCallbacks;
    private Context mContext;
    public NavigationAdapter mNavigationAdapter;
    private ArrayList<NavigationItem> mNavigationItems;

    /* renamed from: uk.me.lewisdeane.lnavigationdrawer.NavigationListView.1 */
    class C02181 implements OnItemClickListener {
        C02181() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            if (NavigationListView.this.mCallbacks != null) {
                NavigationListView.this.mCallbacks.onNavigationItemSelected(((NavigationItem) NavigationListView.this.mNavigationItems.get(i)).getItem(), NavigationListView.this.mNavigationItems, i);
            }
            Iterator it = NavigationListView.this.mNavigationItems.iterator();
            while (it.hasNext()) {
                ((NavigationItem) it.next()).setIsSelected(false);
            }
            ((NavigationItem) NavigationListView.this.mNavigationItems.get(i)).setIsSelected(true);
            NavigationListView.this.mNavigationAdapter.notifyDataSetChanged();
        }
    }

    public interface NavigationItemClickListener {
        void onNavigationItemSelected(String str, ArrayList<NavigationItem> arrayList, int i);
    }

    public NavigationListView(Context _context) {
        this(_context, null, 0);
    }

    public NavigationListView(Context _context, AttributeSet _attrs) {
        this(_context, _attrs, 0);
    }

    public NavigationListView(Context _context, AttributeSet _attrs, int _defStyle) {
        super(_context, _attrs, _defStyle);
        this.mNavigationItems = new ArrayList();
        this.mContext = _context;
        init(_attrs);
    }

    private void init(AttributeSet _attrs) {
        this.mNavigationAdapter = new NavigationAdapter(this.mContext, C0219R.layout.item_navigation, this.mNavigationItems);
        mSelectedColour = getResources().getColor(C0219R.color.blue);
        setAdapter(this.mNavigationAdapter);
        try {
            this.mCallbacks = (NavigationItemClickListener) this.mContext;
        } catch (ClassCastException e) {
            Log.w("L Navigation Drawer", this.mContext.getClass() + " should implement NavigationListView.NavigationItemClickListener");
        }
        setOnItemClickListener(new C02181());
    }

    public NavigationListView setNavigationItemClickListener(NavigationItemClickListener _navigationItemClickListener) {
        this.mCallbacks = _navigationItemClickListener;
        return this;
    }

    public NavigationListView setItems(String[] _items) {
        for (int i = 0; i < _items.length; i++) {
            try {
                ((NavigationItem) this.mNavigationItems.get(i)).setItem(_items[i]);
            } catch (Exception e) {
                this.mNavigationItems.add(new NavigationItem(_items[i]));
            }
        }
        if (this.mNavigationAdapter != null) {
            this.mNavigationAdapter.notifyDataSetChanged();
        }
        return this;
    }

    public NavigationListView setImages(int[] _res) {
        for (int i = 0; i < _res.length; i++) {
            try {
                ((NavigationItem) this.mNavigationItems.get(i)).setImg(_res[i]);
            } catch (Exception e) {
                this.mNavigationItems.add(new NavigationItem(BuildConfig.VERSION_NAME, _res[i]));
            }
        }
        if (this.mNavigationAdapter != null) {
            this.mNavigationAdapter.notifyDataSetChanged();
        }
        return this;
    }

    public NavigationListView addNavigationItem(NavigationItem _navigationItem) {
        this.mNavigationItems.add(_navigationItem);
        this.mNavigationAdapter.notifyDataSetChanged();
        return this;
    }

    public NavigationListView addNavigationItem(String _title, int _res, boolean _isSelected) {
        this.mNavigationItems.add(new NavigationItem(_title, _res, _isSelected));
        this.mNavigationAdapter.notifyDataSetChanged();
        return this;
    }

    public NavigationListView setSelectedItem(int _position) {
        try {
            Iterator it = this.mNavigationItems.iterator();
            while (it.hasNext()) {
                ((NavigationItem) it.next()).setIsSelected(false);
            }
            ((NavigationItem) this.mNavigationItems.get(_position)).setIsSelected(true);
            this.mNavigationAdapter.notifyDataSetChanged();
        } catch (IndexOutOfBoundsException e) {
            Log.e("L Navigation Drawer", "Index specified in setSelectedItem doesn't exist in the list.");
        }
        return this;
    }

    public NavigationListView setSelectedColor(String _colour) {
        try {
            mSelectedColour = Color.parseColor(_colour);
        } catch (Exception e) {
            Log.e("L Navigation Drawer", "Invalid hex code " + _colour);
        }
        if (this.mNavigationAdapter != null) {
            this.mNavigationAdapter.notifyDataSetChanged();
        }
        return this;
    }
}
