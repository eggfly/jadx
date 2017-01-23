package it.gmariotti.cardslib.library.view.component;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import it.gmariotti.cardslib.library.C0173R;
import it.gmariotti.cardslib.library.Constants.IntentManager;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.CardThumbnail.CustomSource;
import it.gmariotti.cardslib.library.utils.CacheUtil;
import it.gmariotti.cardslib.library.view.base.CardViewInterface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import uk.me.lewisdeane.lnavigationdrawer.BuildConfig;

public class CardThumbnailView extends FrameLayout implements CardViewInterface {
    protected int card_thumbnail_layout_resourceID;
    protected CardThumbnail mCardThumbnail;
    protected boolean mForceReplaceInnerLayout;
    protected ImageView mImageView;
    protected View mInternalOuterView;
    protected boolean mIsRecycle;
    protected boolean mLoadingErrorResource;
    protected LruCache<String, Bitmap> mMemoryCache;

    /* renamed from: it.gmariotti.cardslib.library.view.component.CardThumbnailView.1 */
    class C02051 extends LruCache<String, Bitmap> {
        C02051(int x0) {
            super(x0);
        }

        protected int sizeOf(String key, Bitmap bitmap) {
            if (VERSION.SDK_INT > 12) {
                return bitmap.getByteCount() / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT;
            }
            return (bitmap.getRowBytes() * bitmap.getHeight()) / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT;
        }
    }

    static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;

        public AsyncDrawable(Resources res, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
            super(res, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference(bitmapWorkerTask);
        }

        public BitmapWorkerTask getBitmapWorkerTask() {
            return (BitmapWorkerTask) this.bitmapWorkerTaskReference.get();
        }
    }

    static class AsyncDrawableCustomSource extends BitmapDrawable {
        private final WeakReference<BitmapWorkerCustomSourceTask> bitmapWorkerTaskReference;

        public AsyncDrawableCustomSource(Resources res, Bitmap bitmap, BitmapWorkerCustomSourceTask bitmapWorkerTask) {
            super(res, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference(bitmapWorkerTask);
        }

        public BitmapWorkerCustomSourceTask getBitmapWorkerCustomSourceTask() {
            return (BitmapWorkerCustomSourceTask) this.bitmapWorkerTaskReference.get();
        }
    }

    static class AsyncDrawableUrl extends BitmapDrawable {
        private final WeakReference<BitmapWorkerUrlTask> bitmapWorkerTaskReference;

        public AsyncDrawableUrl(Resources res, Bitmap bitmap, BitmapWorkerUrlTask bitmapWorkerTask) {
            super(res, bitmap);
            this.bitmapWorkerTaskReference = new WeakReference(bitmapWorkerTask);
        }

        public BitmapWorkerUrlTask getBitmapWorkerUrlTask() {
            return (BitmapWorkerUrlTask) this.bitmapWorkerTaskReference.get();
        }
    }

    class BitmapWorkerCustomSourceTask extends AsyncTask<CustomSource, Void, Bitmap> {
        private CustomSource customSource;
        private final WeakReference<ImageView> imageViewReference;

        public BitmapWorkerCustomSourceTask(ImageView imageView) {
            this.customSource = null;
            this.imageViewReference = new WeakReference(imageView);
        }

        protected Bitmap doInBackground(CustomSource... params) {
            this.customSource = params[0];
            ImageView thumbnail = (ImageView) this.imageViewReference.get();
            Bitmap bitmap = this.customSource.getBitmap();
            if (bitmap == null) {
                return (Bitmap) null;
            }
            CardThumbnailView.this.addBitmapToMemoryCache(this.customSource.getTag(), bitmap);
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }
            if (this.imageViewReference == null || bitmap == null) {
                CardThumbnailView.this.sendBroadcast(false);
                if (CardThumbnailView.this.mCardThumbnail != null && CardThumbnailView.this.mCardThumbnail.getErrorResourceId() != 0) {
                    if (!CardThumbnailView.this.mLoadingErrorResource) {
                        CardThumbnailView.this.loadBitmap(CardThumbnailView.this.mCardThumbnail.getErrorResourceId(), CardThumbnailView.this.mImageView);
                    }
                    CardThumbnailView.this.mLoadingErrorResource = true;
                    return;
                }
                return;
            }
            ImageView imageView = (ImageView) this.imageViewReference.get();
            if (this == CardThumbnailView.getBitmapWorkerCustomSourceTask(imageView) && imageView != null) {
                if (!CardThumbnailView.this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                    imageView.setImageBitmap(bitmap);
                }
                CardThumbnailView.this.sendBroadcast();
                CardThumbnailView.this.mLoadingErrorResource = false;
            }
        }
    }

    class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private int resId;

        public BitmapWorkerTask(ImageView imageView) {
            this.resId = 0;
            this.imageViewReference = new WeakReference(imageView);
        }

        protected Bitmap doInBackground(Integer... params) {
            this.resId = params[0].intValue();
            ImageView thumbnail = (ImageView) this.imageViewReference.get();
            Bitmap bitmap = CardThumbnailView.decodeSampledBitmapFromResource(CardThumbnailView.this.getResources(), this.resId, thumbnail.getWidth(), thumbnail.getHeight());
            if (bitmap == null) {
                return (Bitmap) null;
            }
            CardThumbnailView.this.addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }
            if (this.imageViewReference == null || bitmap == null) {
                CardThumbnailView.this.sendBroadcast(false);
                if (CardThumbnailView.this.mCardThumbnail != null && CardThumbnailView.this.mCardThumbnail.getErrorResourceId() != 0) {
                    if (!CardThumbnailView.this.mLoadingErrorResource) {
                        CardThumbnailView.this.loadBitmap(CardThumbnailView.this.mCardThumbnail.getErrorResourceId(), CardThumbnailView.this.mImageView);
                    }
                    CardThumbnailView.this.mLoadingErrorResource = true;
                    return;
                }
                return;
            }
            ImageView imageView = (ImageView) this.imageViewReference.get();
            if (this == CardThumbnailView.getBitmapWorkerTask(imageView) && imageView != null) {
                if (!CardThumbnailView.this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                    imageView.setImageBitmap(bitmap);
                }
                CardThumbnailView.this.sendBroadcast();
                CardThumbnailView.this.mLoadingErrorResource = false;
            }
        }
    }

    class BitmapWorkerUrlTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        private String resUrl;

        public BitmapWorkerUrlTask(ImageView imageView) {
            this.resUrl = BuildConfig.VERSION_NAME;
            this.imageViewReference = new WeakReference(imageView);
        }

        protected Bitmap doInBackground(String... params) {
            this.resUrl = params[0];
            ImageView thumbnail = (ImageView) this.imageViewReference.get();
            Bitmap bitmap = CardThumbnailView.decodeSampledBitmapFromResource(CardThumbnailView.this.getResources(), this.resUrl, thumbnail.getWidth(), thumbnail.getHeight());
            if (bitmap == null) {
                return (Bitmap) null;
            }
            CardThumbnailView.this.addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            if (isCancelled()) {
                bitmap = null;
            }
            if (this.imageViewReference == null || bitmap == null) {
                CardThumbnailView.this.sendBroadcast(false);
                if (CardThumbnailView.this.mCardThumbnail != null && CardThumbnailView.this.mCardThumbnail.getErrorResourceId() != 0) {
                    if (!CardThumbnailView.this.mLoadingErrorResource) {
                        CardThumbnailView.this.loadBitmap(CardThumbnailView.this.mCardThumbnail.getErrorResourceId(), CardThumbnailView.this.mImageView);
                    }
                    CardThumbnailView.this.mLoadingErrorResource = true;
                    return;
                }
                return;
            }
            ImageView imageView = (ImageView) this.imageViewReference.get();
            if (this == CardThumbnailView.getBitmapWorkerUrlTask(imageView) && imageView != null) {
                if (!CardThumbnailView.this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                    imageView.setImageBitmap(bitmap);
                }
                CardThumbnailView.this.sendBroadcast();
                CardThumbnailView.this.mLoadingErrorResource = false;
            }
        }
    }

    public CardThumbnailView(Context context) {
        super(context);
        this.card_thumbnail_layout_resourceID = C0173R.layout.base_thumbnail_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        this.mLoadingErrorResource = false;
        init(null, 0);
    }

    public CardThumbnailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.card_thumbnail_layout_resourceID = C0173R.layout.base_thumbnail_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        this.mLoadingErrorResource = false;
        init(attrs, 0);
    }

    public CardThumbnailView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.card_thumbnail_layout_resourceID = C0173R.layout.base_thumbnail_layout;
        this.mIsRecycle = false;
        this.mForceReplaceInnerLayout = false;
        this.mLoadingErrorResource = false;
        init(attrs, defStyle);
    }

    protected void init(AttributeSet attrs, int defStyle) {
        initAttrs(attrs, defStyle);
        if (!isInEditMode()) {
            initView();
        }
    }

    protected void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, C0173R.styleable.card_options, defStyle, defStyle);
        try {
            this.card_thumbnail_layout_resourceID = a.getResourceId(C0173R.styleable.card_options_card_thumbnail_layout_resourceID, this.card_thumbnail_layout_resourceID);
        } finally {
            a.recycle();
        }
    }

    protected void initView() {
        this.mInternalOuterView = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.card_thumbnail_layout_resourceID, this, true);
        this.mImageView = (ImageView) findViewById(C0173R.id.card_thumbnail_image);
        int cacheSize = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        this.mMemoryCache = CacheUtil.getMemoryCache();
        if (this.mMemoryCache == null) {
            this.mMemoryCache = new C02051(cacheSize);
            CacheUtil.putMemoryCache(this.mMemoryCache);
        }
    }

    public void addCardThumbnail(CardThumbnail cardThumbail) {
        this.mCardThumbnail = cardThumbail;
        buildUI();
    }

    protected void buildUI() {
        if (this.mCardThumbnail != null) {
            if (this.mIsRecycle) {
                this.mLoadingErrorResource = false;
            }
            setupInnerView();
        }
    }

    protected void setupInnerView() {
        if (this.mInternalOuterView != null) {
            this.mCardThumbnail.setupInnerViewElements((ViewGroup) this.mInternalOuterView, this.mImageView);
        }
        if (!this.mCardThumbnail.isExternalUsage()) {
            if (this.mCardThumbnail.getCustomSource() != null) {
                loadBitmap(this.mCardThumbnail.getCustomSource(), this.mImageView);
            } else if (this.mCardThumbnail.getDrawableResource() > 0) {
                loadBitmap(this.mCardThumbnail.getDrawableResource(), this.mImageView);
            } else {
                loadBitmap(this.mCardThumbnail.getUrlResource(), this.mImageView);
            }
        }
    }

    public void loadBitmap(int resId, ImageView imageView) {
        Bitmap bitmap = getBitmapFromMemCache(String.valueOf(resId));
        if (bitmap != null) {
            if (!this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                imageView.setImageBitmap(bitmap);
            }
            sendBroadcast();
        } else if (cancelPotentialWork(resId, imageView)) {
            BitmapWorkerTask task = new BitmapWorkerTask(imageView);
            imageView.setImageDrawable(new AsyncDrawable(getResources(), null, task));
            task.execute(new Integer[]{Integer.valueOf(resId)});
        }
    }

    public void loadBitmap(String url, ImageView imageView) {
        Bitmap bitmap = getBitmapFromMemCache(url);
        if (bitmap != null) {
            if (!this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                imageView.setImageBitmap(bitmap);
            }
            sendBroadcast();
        } else if (cancelPotentialWork(url, imageView)) {
            BitmapWorkerUrlTask task = new BitmapWorkerUrlTask(imageView);
            imageView.setImageDrawable(new AsyncDrawableUrl(getResources(), null, task));
            task.execute(new String[]{url});
        }
    }

    public void loadBitmap(CustomSource customSource, ImageView imageView) {
        Bitmap bitmap = getBitmapFromMemCache(customSource.getTag());
        if (bitmap != null) {
            if (!this.mCardThumbnail.applyBitmap(imageView, bitmap)) {
                imageView.setImageBitmap(bitmap);
            }
            sendBroadcast();
        } else if (cancelPotentialWork(customSource, imageView)) {
            BitmapWorkerCustomSourceTask task = new BitmapWorkerCustomSourceTask(imageView);
            imageView.setImageDrawable(new AsyncDrawableCustomSource(getResources(), null, task));
            task.execute(new CustomSource[]{customSource});
        }
    }

    protected void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (!this.mLoadingErrorResource && getBitmapFromMemCache(key) == null && key != null && bitmap != null) {
            this.mMemoryCache.put(key, bitmap);
        }
    }

    protected Bitmap getBitmapFromMemCache(String key) {
        if (key == null) {
            return null;
        }
        return (Bitmap) this.mMemoryCache.get(key);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, String resUrl, int reqWidth, int reqHeight) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new URL(resUrl).openStream());
            options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeStream(new URL(resUrl).openStream());
        } catch (IOException ioe) {
            Log.w("CardThumbnailView", "Error while retrieving image", ioe);
            return null;
        }
    }

    public static int calculateInSampleSize(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (reqWidth == 0 || reqHeight == 0) {
            return 1;
        }
        if (height > reqHeight || width > reqWidth) {
            int heightRatio = Math.round(((float) height) / ((float) reqHeight));
            int widthRatio = Math.round(((float) width) / ((float) reqWidth));
            if (heightRatio < widthRatio) {
                inSampleSize = heightRatio;
            } else {
                inSampleSize = widthRatio;
            }
        }
        return inSampleSize;
    }

    public static boolean cancelPotentialWork(int resId, ImageView imageView) {
        BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
        if (bitmapWorkerTask == null) {
            return true;
        }
        if (bitmapWorkerTask.resId == resId) {
            return false;
        }
        bitmapWorkerTask.cancel(true);
        return true;
    }

    public static boolean cancelPotentialWork(String url, ImageView imageView) {
        BitmapWorkerUrlTask bitmapWorkerTask = getBitmapWorkerUrlTask(imageView);
        if (bitmapWorkerTask == null) {
            return true;
        }
        if (bitmapWorkerTask.resUrl.equals(url)) {
            return false;
        }
        bitmapWorkerTask.cancel(true);
        return true;
    }

    public static boolean cancelPotentialWork(CustomSource customSource, ImageView imageView) {
        BitmapWorkerCustomSourceTask bitmapWorkerTask = getBitmapWorkerCustomSourceTask(imageView);
        if (bitmapWorkerTask == null || bitmapWorkerTask.customSource == null) {
            return true;
        }
        CustomSource bitmapWorkerTaskCustomSource = bitmapWorkerTask.customSource;
        if (bitmapWorkerTaskCustomSource.getTag() == null) {
            return true;
        }
        if (bitmapWorkerTaskCustomSource.getTag().equals(customSource.getTag())) {
            return false;
        }
        bitmapWorkerTask.cancel(true);
        return true;
    }

    protected static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                return ((AsyncDrawable) drawable).getBitmapWorkerTask();
            }
        }
        return null;
    }

    protected static BitmapWorkerUrlTask getBitmapWorkerUrlTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawableUrl) {
                return ((AsyncDrawableUrl) drawable).getBitmapWorkerUrlTask();
            }
        }
        return null;
    }

    protected static BitmapWorkerCustomSourceTask getBitmapWorkerCustomSourceTask(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawableCustomSource) {
                return ((AsyncDrawableCustomSource) drawable).getBitmapWorkerCustomSourceTask();
            }
        }
        return null;
    }

    protected void sendBroadcast() {
        sendBroadcast(true);
    }

    protected void sendBroadcast(boolean result) {
        if (this.mCardThumbnail.isSendBroadcastAfterAttach()) {
            Intent intent = new Intent();
            intent.setAction(IntentManager.INTENT_ACTION_IMAGE_DOWNLOADED);
            intent.putExtra(IntentManager.INTENT_ACTION_IMAGE_DOWNLOADED_EXTRA_RESULT, result);
            if (this.mLoadingErrorResource) {
                intent.putExtra(IntentManager.INTENT_ACTION_IMAGE_DOWNLOADED_EXTRA_ERROR_LOADING, true);
            } else {
                intent.putExtra(IntentManager.INTENT_ACTION_IMAGE_DOWNLOADED_EXTRA_ERROR_LOADING, false);
            }
            if (!(this.mCardThumbnail == null || this.mCardThumbnail.getParentCard() == null)) {
                intent.putExtra(IntentManager.INTENT_ACTION_IMAGE_DOWNLOADED_EXTRA_CARD_ID, this.mCardThumbnail.getParentCard().getId());
            }
            if (getContext() != null) {
                getContext().sendBroadcast(intent);
            }
        }
    }

    public View getInternalOuterView() {
        return null;
    }

    public boolean isRecycle() {
        return this.mIsRecycle;
    }

    public void setRecycle(boolean isRecycle) {
        this.mIsRecycle = isRecycle;
    }

    public boolean isForceReplaceInnerLayout() {
        return this.mForceReplaceInnerLayout;
    }

    public void setForceReplaceInnerLayout(boolean forceReplaceInnerLayout) {
        this.mForceReplaceInnerLayout = forceReplaceInnerLayout;
    }
}
