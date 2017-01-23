package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.CustomerLogo;
import com.mob.tools.gui.ViewPagerAdapter;
import com.mob.tools.utils.C4021R;
import com.xiaomi.pushsdk.BuildConfig;
import java.util.ArrayList;

public abstract class PlatformPageAdapter extends ViewPagerAdapter implements OnClickListener {
    public static final int DESIGN_BOTTOM_HEIGHT = 52;
    protected static final int MIN_CLICK_INTERVAL = 1000;
    protected int bottomHeight;
    protected int cellHeight;
    protected Object[][] cells;
    private long lastClickTime;
    protected int lineSize;
    protected int logoHeight;
    protected int paddingTop;
    private PlatformPage page;
    protected int panelHeight;
    protected int sepLineWidth;
    private IndicatorView vInd;

    public PlatformPageAdapter(PlatformPage platformPage, ArrayList<Object> arrayList) {
        this.page = platformPage;
        if (arrayList != null && !arrayList.isEmpty()) {
            calculateSize(platformPage.getContext(), arrayList);
            collectCells(arrayList);
        }
    }

    private View createPanel(Context context) {
        int i;
        int i2 = 0;
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-855310);
        int i3 = this.panelHeight / this.cellHeight;
        Object obj = new LinearLayout[(this.lineSize * i3)];
        linearLayout.setTag(obj);
        int bitmapRes = C4021R.getBitmapRes(context, "ssdk_oks_classic_platform_cell_back");
        for (int i4 = 0; i4 < i3; i4++) {
            View linearLayout2 = new LinearLayout(context);
            linearLayout.addView(linearLayout2, new LayoutParams(-1, this.cellHeight));
            for (i = 0; i < this.lineSize; i++) {
                obj[(this.lineSize * i4) + i] = new LinearLayout(context);
                obj[(this.lineSize * i4) + i].setBackgroundResource(bitmapRes);
                obj[(this.lineSize * i4) + i].setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, this.cellHeight);
                layoutParams.weight = 1.0f;
                linearLayout2.addView(obj[(this.lineSize * i4) + i], layoutParams);
                if (i < this.lineSize - 1) {
                    linearLayout2.addView(new View(context), new LayoutParams(this.sepLineWidth, -1));
                }
            }
            linearLayout.addView(new View(context), new LayoutParams(-1, this.sepLineWidth));
        }
        i = obj.length;
        while (i2 < i) {
            LinearLayout linearLayout3 = obj[i2];
            View imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, this.logoHeight);
            layoutParams2.topMargin = this.paddingTop;
            linearLayout3.addView(imageView, layoutParams2);
            imageView = new TextView(context);
            imageView.setTextColor(-10197916);
            imageView.setTextSize(2, 14.0f);
            imageView.setGravity(17);
            layoutParams2 = new LayoutParams(-1, -2);
            layoutParams2.weight = 1.0f;
            linearLayout3.addView(imageView, layoutParams2);
            i2++;
        }
        return linearLayout;
    }

    private void refreshPanel(LinearLayout[] linearLayoutArr, Object[] objArr) {
        int bitmapRes = C4021R.getBitmapRes(this.page.getContext(), "ssdk_oks_classic_platform_cell_back");
        int bitmapRes2 = C4021R.getBitmapRes(this.page.getContext(), "ssdk_oks_classic_platfrom_cell_back_nor");
        for (int i = 0; i < objArr.length; i++) {
            ImageView imageView = (ImageView) C4021R.forceCast(linearLayoutArr[i].getChildAt(0));
            TextView textView = (TextView) C4021R.forceCast(linearLayoutArr[i].getChildAt(1));
            if (objArr[i] == null) {
                imageView.setVisibility(4);
                textView.setVisibility(4);
                linearLayoutArr[i].setBackgroundResource(bitmapRes2);
                linearLayoutArr[i].setOnClickListener(null);
            } else {
                imageView.setVisibility(0);
                textView.setVisibility(0);
                linearLayoutArr[i].setBackgroundResource(bitmapRes);
                linearLayoutArr[i].setOnClickListener(this);
                linearLayoutArr[i].setTag(objArr[i]);
                if (objArr[i] instanceof CustomerLogo) {
                    CustomerLogo customerLogo = (CustomerLogo) C4021R.forceCast(objArr[i]);
                    if (customerLogo.logo != null) {
                        imageView.setImageBitmap(customerLogo.logo);
                    } else {
                        imageView.setImageBitmap(null);
                    }
                    if (customerLogo.label != null) {
                        textView.setText(customerLogo.label);
                    } else {
                        textView.setText(BuildConfig.FLAVOR);
                    }
                } else {
                    String toLowerCase = ((Platform) C4021R.forceCast(objArr[i])).getName().toLowerCase();
                    int bitmapRes3 = C4021R.getBitmapRes(imageView.getContext(), "ssdk_oks_classic_" + toLowerCase);
                    if (bitmapRes3 > 0) {
                        imageView.setImageResource(bitmapRes3);
                    } else {
                        imageView.setImageBitmap(null);
                    }
                    int stringRes = C4021R.getStringRes(textView.getContext(), "ssdk_" + toLowerCase);
                    if (stringRes > 0) {
                        textView.setText(stringRes);
                    } else {
                        textView.setText(BuildConfig.FLAVOR);
                    }
                }
            }
        }
    }

    protected abstract void calculateSize(Context context, ArrayList<Object> arrayList);

    protected abstract void collectCells(ArrayList<Object> arrayList);

    public int getBottomHeight() {
        return this.bottomHeight;
    }

    public int getCount() {
        return this.cells == null ? 0 : this.cells.length;
    }

    public int getPanelHeight() {
        return this.panelHeight;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createPanel(viewGroup.getContext());
        }
        refreshPanel((LinearLayout[]) C4021R.forceCast(((LinearLayout) C4021R.forceCast(view)).getTag()), this.cells[i]);
        return view;
    }

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 1000) {
            this.lastClickTime = currentTimeMillis;
            if (view.getTag() instanceof CustomerLogo) {
                this.page.performCustomLogoClick(view, (CustomerLogo) C4021R.forceCast(view.getTag()));
                return;
            }
            this.page.showEditPage((Platform) C4021R.forceCast(view.getTag()));
        }
    }

    public void onScreenChange(int i, int i2) {
        if (this.vInd != null) {
            this.vInd.setScreenCount(getCount());
            this.vInd.onScreenChange(i, i2);
        }
    }

    public void setIndicator(IndicatorView indicatorView) {
        this.vInd = indicatorView;
    }
}
