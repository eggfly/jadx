package cn.sharesdk.onekeyshare.themes.classic.port;

import android.content.Context;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import com.mob.tools.utils.C4021R;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlatformPageAdapterPort extends PlatformPageAdapter {
    private static final int DESIGN_LOGO_HEIGHT = 76;
    private static final int DESIGN_PADDING_TOP = 20;
    private static final int DESIGN_SCREEN_WIDTH_P = 720;
    private static final int DESIGN_SEP_LINE_WIDTH = 1;
    private static final int LINE_SIZE_P = 4;
    private static final int PAGE_SIZE_P = 12;

    public PlatformPageAdapterPort(PlatformPage platformPage, ArrayList<Object> arrayList) {
        super(platformPage, arrayList);
    }

    protected void calculateSize(Context context, ArrayList<Object> arrayList) {
        int i = DESIGN_SEP_LINE_WIDTH;
        int screenWidth = C4021R.getScreenWidth(context);
        this.lineSize = LINE_SIZE_P;
        float f = ((float) screenWidth) / 720.0f;
        this.sepLineWidth = (int) (1.0f * f);
        if (this.sepLineWidth >= DESIGN_SEP_LINE_WIDTH) {
            i = this.sepLineWidth;
        }
        this.sepLineWidth = i;
        this.logoHeight = (int) (76.0f * f);
        this.paddingTop = (int) (20.0f * f);
        this.bottomHeight = (int) (52.0f * f);
        this.cellHeight = (screenWidth - (this.sepLineWidth * 3)) / LINE_SIZE_P;
        if (arrayList.size() <= this.lineSize) {
            this.panelHeight = this.cellHeight + this.sepLineWidth;
        } else if (arrayList.size() <= 12 - this.lineSize) {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 2;
        } else {
            this.panelHeight = (this.cellHeight + this.sepLineWidth) * 3;
        }
    }

    protected void collectCells(ArrayList<Object> arrayList) {
        int i;
        int size = arrayList.size();
        if (size < PAGE_SIZE_P) {
            i = size / this.lineSize;
            if (size % this.lineSize != 0) {
                i += DESIGN_SEP_LINE_WIDTH;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, new int[]{DESIGN_SEP_LINE_WIDTH, i * this.lineSize});
        } else {
            i = size / PAGE_SIZE_P;
            if (size % PAGE_SIZE_P != 0) {
                i += DESIGN_SEP_LINE_WIDTH;
            }
            this.cells = (Object[][]) Array.newInstance(Object.class, new int[]{i, PAGE_SIZE_P});
        }
        for (i = 0; i < size; i += DESIGN_SEP_LINE_WIDTH) {
            int i2 = i / PAGE_SIZE_P;
            this.cells[i2][i - (i2 * PAGE_SIZE_P)] = arrayList.get(i);
        }
    }
}
