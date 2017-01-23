package uk.me.lewisdeane.lnavigationdrawer;

public class NavigationItem {
    private int mImg;
    private boolean mIsSelected;
    private String mItem;

    public NavigationItem() {
        this.mImg = 0;
        this.mItem = BuildConfig.VERSION_NAME;
        this.mIsSelected = false;
    }

    public NavigationItem(String _item) {
        this.mImg = 0;
        this.mItem = BuildConfig.VERSION_NAME;
        this.mIsSelected = false;
        setItem(_item);
    }

    public NavigationItem(String _item, int _img) {
        this(_item);
        setImg(_img);
    }

    public NavigationItem(String _item, int _img, boolean _isSelected) {
        this(_item, _img);
        setIsSelected(_isSelected);
    }

    public NavigationItem setItem(String _item) {
        this.mItem = _item;
        return this;
    }

    public NavigationItem setImg(int _img) {
        this.mImg = _img;
        return this;
    }

    public NavigationItem setIsSelected(boolean _isSelected) {
        this.mIsSelected = _isSelected;
        return this;
    }

    public String getItem() {
        return this.mItem;
    }

    public int getImg() {
        return this.mImg;
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }
}
