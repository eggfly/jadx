package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.Following;
import com.antutu.utils.widget.SystemBarTintManager;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.C4021R;

public class FriendListItem extends LinearLayout {
    private static final int DESIGN_AVATAR_PADDING = 24;
    private static final int DESIGN_AVATAR_WIDTH = 64;
    private static final int DESIGN_ITEM_HEIGHT = 96;
    private static final int DESIGN_ITEM_PADDING = 20;
    private AsyncImageView aivIcon;
    private Bitmap bmChd;
    private Bitmap bmUnch;
    private ImageView ivCheck;
    private TextView tvName;

    public FriendListItem(Context context, float f) {
        super(context);
        int i = (int) (20.0f * f);
        setPadding(i, 0, i, 0);
        setMinimumHeight((int) (96.0f * f));
        setBackgroundColor(-1);
        this.ivCheck = new ImageView(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.ivCheck, layoutParams);
        this.aivIcon = new AsyncImageView(context);
        i = (int) (64.0f * f);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        layoutParams2.gravity = 16;
        i = (int) (24.0f * f);
        layoutParams2.setMargins(i, 0, i, 0);
        addView(this.aivIcon, layoutParams2);
        this.tvName = new TextView(context);
        this.tvName.setTextColor(SystemBarTintManager.DEFAULT_TINT_COLOR);
        this.tvName.setTextSize(2, 18.0f);
        this.tvName.setSingleLine();
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        addView(this.tvName, layoutParams);
        i = C4021R.getBitmapRes(context, "ssdk_oks_classic_check_checked");
        if (i > 0) {
            this.bmChd = BitmapFactory.decodeResource(context.getResources(), i);
        }
        i = C4021R.getBitmapRes(getContext(), "ssdk_oks_classic_check_default");
        if (i > 0) {
            this.bmUnch = BitmapFactory.decodeResource(context.getResources(), i);
        }
    }

    public void update(Following following, boolean z) {
        this.tvName.setText(following.screenName);
        this.ivCheck.setImageBitmap(following.checked ? this.bmChd : this.bmUnch);
        if (this.aivIcon == null) {
            return;
        }
        if (z) {
            Bitmap bitmapFromCache = BitmapProcessor.getBitmapFromCache(following.icon);
            if (bitmapFromCache == null || bitmapFromCache.isRecycled()) {
                this.aivIcon.execute(null, 0);
                return;
            } else {
                this.aivIcon.setImageBitmap(bitmapFromCache);
                return;
            }
        }
        this.aivIcon.execute(following.icon, 0);
    }
}
