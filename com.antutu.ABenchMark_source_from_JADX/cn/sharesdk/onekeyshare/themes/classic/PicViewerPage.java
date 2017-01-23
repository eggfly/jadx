package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView.ScaleType;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import com.mob.tools.gui.ScaledImageView;

public class PicViewerPage extends OnekeySharePage implements OnGlobalLayoutListener {
    private Bitmap pic;
    private ScaledImageView sivViewer;

    /* renamed from: cn.sharesdk.onekeyshare.themes.classic.PicViewerPage.1 */
    class C09881 implements Runnable {
        C09881() {
        }

        public void run() {
            PicViewerPage.this.sivViewer.setBitmap(PicViewerPage.this.pic);
        }
    }

    public PicViewerPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(1275068416));
        this.sivViewer = new ScaledImageView(this.activity);
        this.sivViewer.setScaleType(ScaleType.MATRIX);
        this.activity.setContentView(this.sivViewer);
        if (this.pic != null) {
            this.sivViewer.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    public void onGlobalLayout() {
        this.sivViewer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.sivViewer.post(new C09881());
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.pic = bitmap;
    }
}
