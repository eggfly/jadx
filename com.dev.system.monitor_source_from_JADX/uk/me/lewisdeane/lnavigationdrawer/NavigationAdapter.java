package uk.me.lewisdeane.lnavigationdrawer;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class NavigationAdapter extends ArrayAdapter<NavigationItem> {
    private Context mContext;
    private ArrayList<NavigationItem> mNavigationItems;

    public NavigationAdapter(Context context, int resource, ArrayList<NavigationItem> drawerItems) {
        super(context, resource, drawerItems);
        this.mNavigationItems = new ArrayList();
        this.mContext = context;
        this.mNavigationItems = drawerItems;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(C0219R.layout.item_navigation, null);
        }
        NavigationItem navigationItem = (NavigationItem) this.mNavigationItems.get(position);
        TextView itemView = (TextView) v.findViewById(C0219R.id.item_navigation_title);
        ImageView imgView = (ImageView) v.findViewById(C0219R.id.item_navigation_img);
        itemView.setText(navigationItem.getItem());
        imgView.setImageDrawable(getColouredDrawable(this.mContext.getResources().getDrawable(navigationItem.getImg()), navigationItem.getIsSelected()));
        itemView.setTextColor(navigationItem.getIsSelected() ? NavigationListView.mSelectedColour : this.mContext.getResources().getColor(C0219R.color.dark_grey));
        return v;
    }

    private Drawable getColouredDrawable(Drawable _drawable, boolean _isSelected) {
        int iColor = _isSelected ? NavigationListView.mSelectedColour : this.mContext.getResources().getColor(C0219R.color.dark_grey);
        int red = (16711680 & iColor) / SupportMenu.USER_MASK;
        int green = (MotionEventCompat.ACTION_POINTER_INDEX_MASK & iColor) / MotionEventCompat.ACTION_MASK;
        int blue = iColor & MotionEventCompat.ACTION_MASK;
        _drawable.setColorFilter(new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) red, 0.0f, 0.0f, 0.0f, 0.0f, (float) green, 0.0f, 0.0f, 0.0f, 0.0f, (float) blue, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        return _drawable;
    }
}
