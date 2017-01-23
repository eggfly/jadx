package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.C4021R;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlatformPageAdapterLand extends PlatformPageAdapter {
    private static final int DESIGN_CELL_WIDTH_L = 160;
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_L = 1280;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;

    public PlatformPageAdapterLand(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    protected void calculateSize(Context context, ArrayList<Object> arrayList) {
        int i = DESIGN_SEP_LINE_WIDTH;
        int screenWidth = C4021R.getScreenWidth(context);
        float f = ((float) screenWidth) / 1280.0f;
        this.lineSize = screenWidth / ((int) (160.0f * f));
        this.sepLineWidth = (int) (1.0f * f);
        if (this.sepLineWidth >= DESIGN_SEP_LINE_WIDTH) {
            i = this.sepLineWidth;
        }
        this.sepLineWidth = i;
        this.logoHeight = (int) (76.0f * f);
        this.paddingTop = (int) (20.0f * f);
        this.bottomHeight = (int) (52.0f * f);
        this.cellHeight = (screenWidth - (this.sepLineWidth * 3)) / (this.lineSize - 1);
        this.panelHeight = this.cellHeight + this.sepLineWidth;
    }

    protected void collectCells(ArrayList<Object> arrayList) {
        int i;
        int size = arrayList.size();
        if (size < this.lineSize) {
            i = size / this.lineSize;
            if (size % this.lineSize != 0) {
                i += DESIGN_SEP_LINE_WIDTH;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, new int[]{DESIGN_SEP_LINE_WIDTH, i * this.lineSize});
        } else {
            i = size / this.lineSize;
            if (size % this.lineSize != 0) {
                i += DESIGN_SEP_LINE_WIDTH;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, new int[]{i, this.lineSize});
        }
        for (i = 0; i < size; i += DESIGN_SEP_LINE_WIDTH) {
            int i2 = i / this.lineSize;
            this.cells[i2][i - (i2 * this.lineSize)] = arrayList.get(i);
        }
    }
}
