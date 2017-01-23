package cn.sharesdk.onekeyshare.themes.classic.land;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.EditPage;
import cn.sharesdk.onekeyshare.themes.classic.XView;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C4021R;
import java.io.File;

public class EditPageLand extends EditPage implements TextWatcher, OnClickListener, Runnable {
    private static final int DESIGN_BOTTOM_HEIGHT = 75;
    private static final int DESIGN_LEFT_PADDING = 40;
    private static final int DESIGN_REMOVE_THUMB_HEIGHT_L = 60;
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_THUMB_HEIGHT_L = 280;
    private static final int DESIGN_TITLE_HEIGHT_L = 70;

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand.1 */
    class C09931 extends AsyncImageView {
        C09931(Context context) {
            super(context);
        }

        public void onImageGot(String str, Bitmap bitmap) {
            EditPageLand.this.thumb = bitmap;
            super.onImageGot(str, bitmap);
        }
    }

    public EditPageLand(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    private void initBody(RelativeLayout relativeLayout, float f) {
        this.svContent = new ScrollView(this.activity);
        relativeLayout.addView(this.svContent, new LayoutParams(-1, -2));
        View linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        this.svContent.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        this.etContent = new EditText(this.activity);
        int i = (int) (40.0f * f);
        this.etContent.setPadding(i, i, i, i);
        this.etContent.setBackgroundDrawable(null);
        this.etContent.setTextColor(-12895429);
        this.etContent.setTextSize(2, 21.0f);
        this.etContent.setText(this.sp.getText());
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.etContent, layoutParams);
        this.etContent.addTextChangedListener(this);
        this.rlThumb = new RelativeLayout(this.activity);
        this.rlThumb.setBackgroundColor(-13553359);
        int i2 = (int) (280.0f * f);
        int i3 = (int) (60.0f * f);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams2.topMargin = i;
        layoutParams2.bottomMargin = i;
        layoutParams2.rightMargin = i;
        linearLayout.addView(this.rlThumb, layoutParams2);
        this.aivThumb = new C09931(this.activity);
        this.aivThumb.setScaleToCropCenter(true);
        this.rlThumb.addView(this.aivThumb, new LayoutParams(i2, i2));
        this.aivThumb.setOnClickListener(this);
        initThumb(this.aivThumb);
        this.xvRemove = new XView(this.activity);
        this.xvRemove.setRatio(f);
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(i3, i3);
        layoutParams3.addRule(10);
        layoutParams3.addRule(11);
        this.rlThumb.addView(this.xvRemove, layoutParams3);
        this.xvRemove.setOnClickListener(this);
    }

    private void initBottom(LinearLayout linearLayout, float f) {
        View linearLayout2 = new LinearLayout(this.activity);
        linearLayout2.setPadding(0, 0, 0, 5);
        linearLayout2.setBackgroundColor(-1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, (int) (75.0f * f)));
        this.tvAt = new TextView(this.activity);
        this.tvAt.setTextColor(-12895429);
        this.tvAt.setTextSize(2, 21.0f);
        this.tvAt.setGravity(80);
        this.tvAt.setText("@");
        int i = (int) (40.0f * f);
        this.tvAt.setPadding(i, 0, i, 0);
        linearLayout2.addView(this.tvAt, new LinearLayout.LayoutParams(-2, -1));
        this.tvAt.setOnClickListener(this);
        if (isShowAtUserLayout(this.platform.getName())) {
            this.tvAt.setVisibility(0);
        } else {
            this.tvAt.setVisibility(4);
        }
        this.tvTextCouter = new TextView(this.activity);
        this.tvTextCouter.setTextColor(-12895429);
        this.tvTextCouter.setTextSize(2, 18.0f);
        this.tvTextCouter.setGravity(85);
        onTextChanged(this.etContent.getText(), 0, 0, 0);
        this.tvTextCouter.setPadding(i, 0, i, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.weight = 1.0f;
        linearLayout2.addView(this.tvTextCouter, layoutParams);
        View view = new View(this.activity);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, f > 1.0f ? (int) f : 1));
    }

    private void initShadow(LinearLayout linearLayout, float f) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, f > 1.0f ? (int) f : 1);
        View view = new View(this.activity);
        view.setBackgroundColor(687865856);
        linearLayout.addView(view, layoutParams);
        view = new View(this.activity);
        view.setBackgroundColor(335544320);
        linearLayout.addView(view, layoutParams);
        view = new View(this.activity);
        view.setBackgroundColor(117440512);
        linearLayout.addView(view, layoutParams);
    }

    private void initThumb(AsyncImageView asyncImageView) {
        String imageUrl = this.sp.getImageUrl();
        String imagePath = this.sp.getImagePath();
        String[] imageArray = this.sp.getImageArray();
        Bitmap bitmap = null;
        this.rlThumb.setVisibility(0);
        if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
            try {
                bitmap = BitmapHelper.getBitmap(imagePath);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (bitmap != null) {
            this.thumb = bitmap;
            asyncImageView.setBitmap(bitmap);
        } else if (imageArray != null && imageArray.length > 0 && !TextUtils.isEmpty(imageArray[0]) && new File(imageArray[0]).exists()) {
            try {
                bitmap = BitmapHelper.getBitmap(imagePath);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (bitmap != null) {
            this.thumb = bitmap;
            asyncImageView.setBitmap(bitmap);
        } else if (bitmap != null || TextUtils.isEmpty(imageUrl)) {
            this.rlThumb.setVisibility(8);
        } else {
            asyncImageView.execute(imageUrl, 0);
        }
    }

    private void initTitle(RelativeLayout relativeLayout, float f) {
        this.tvCancel = new TextView(this.activity);
        this.tvCancel.setTextColor(-12895429);
        this.tvCancel.setTextSize(2, 18.0f);
        this.tvCancel.setGravity(17);
        int stringRes = C4021R.getStringRes(this.activity, "ssdk_oks_cancel");
        if (stringRes > 0) {
            this.tvCancel.setText(stringRes);
        }
        stringRes = (int) (40.0f * f);
        this.tvCancel.setPadding(stringRes, 0, stringRes, 0);
        relativeLayout.addView(this.tvCancel, new LayoutParams(-2, -1));
        this.tvCancel.setOnClickListener(this);
        View textView = new TextView(this.activity);
        textView.setTextColor(-12895429);
        textView.setTextSize(2, 22.0f);
        textView.setGravity(17);
        int stringRes2 = C4021R.getStringRes(this.activity, "ssdk_oks_multi_share");
        if (stringRes2 > 0) {
            textView.setText(stringRes2);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        this.tvShare = new TextView(this.activity);
        this.tvShare.setTextColor(-37615);
        this.tvShare.setTextSize(2, 18.0f);
        this.tvShare.setGravity(17);
        int stringRes3 = C4021R.getStringRes(this.activity, "ssdk_oks_share");
        if (stringRes3 > 0) {
            this.tvShare.setText(stringRes3);
        }
        this.tvShare.setPadding(stringRes, 0, stringRes, 0);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.tvShare, layoutParams2);
        this.tvShare.setOnClickListener(this);
    }

    public void onCreate() {
        super.onCreate();
        float screenHeight = ((float) C4021R.getScreenHeight(this.activity)) / 720.0f;
        this.maxBodyHeight = 0;
        this.llPage = new LinearLayout(this.activity);
        this.llPage.setOrientation(1);
        this.activity.setContentView(this.llPage);
        this.rlTitle = new RelativeLayout(this.activity);
        this.rlTitle.setBackgroundColor(-1644052);
        this.llPage.addView(this.rlTitle, new LinearLayout.LayoutParams(-1, (int) (70.0f * screenHeight)));
        initTitle(this.rlTitle, screenHeight);
        View relativeLayout = new RelativeLayout(this.activity);
        relativeLayout.setBackgroundColor(-1);
        this.llPage.addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
        initBody(relativeLayout, screenHeight);
        View linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(1);
        relativeLayout.addView(linearLayout, new LayoutParams(-1, -2));
        initShadow(linearLayout, screenHeight);
        this.llBottom = new LinearLayout(this.activity);
        this.llBottom.setOrientation(1);
        this.llPage.addView(this.llBottom, new LinearLayout.LayoutParams(-1, -2));
        initBottom(this.llBottom, screenHeight);
    }
}
