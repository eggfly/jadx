package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import it.gmariotti.cardslib.library.internal.base.BaseCard;
import it.gmariotti.cardslib.library.view.component.CardThumbnailView;

public class CardThumbnail extends BaseCard {
    protected CustomSource customSource;
    protected int drawableResource;
    protected int errorResourceId;
    protected boolean mExternalUsage;
    protected boolean sendBroadcastAfterAttach;
    protected String urlResource;

    public interface CustomSource {
        Bitmap getBitmap();

        String getTag();
    }

    public CardThumbnail(Context context) {
        super(context);
        this.mExternalUsage = false;
        this.errorResourceId = 0;
        this.customSource = null;
        this.sendBroadcastAfterAttach = true;
    }

    public CardThumbnail(Context context, int innerLayout) {
        super(context);
        this.mExternalUsage = false;
        this.errorResourceId = 0;
        this.customSource = null;
        this.sendBroadcastAfterAttach = true;
    }

    public void setupInnerViewElements(ViewGroup parent, View imageView) {
    }

    public boolean applyBitmap(View imageView, Bitmap bitmap) {
        return false;
    }

    public int getDrawableResource() {
        return this.drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getUrlResource() {
        return this.urlResource;
    }

    public void setUrlResource(String urlResource) {
        this.urlResource = urlResource;
    }

    public CustomSource getCustomSource() {
        return this.customSource;
    }

    public void setCustomSource(CustomSource customSource) {
        this.customSource = customSource;
    }

    public boolean isExternalUsage() {
        return this.mExternalUsage;
    }

    public void setExternalUsage(boolean externalUsage) {
        this.mExternalUsage = externalUsage;
    }

    public int getErrorResourceId() {
        return this.errorResourceId;
    }

    public void setErrorResource(int errorResourceId) {
        this.errorResourceId = errorResourceId;
    }

    public boolean isSendBroadcastAfterAttach() {
        return this.sendBroadcastAfterAttach;
    }

    public void setSendBroadcastAfterAttach(boolean sendBroadcastAfterAttach) {
        this.sendBroadcastAfterAttach = sendBroadcastAfterAttach;
    }

    public CardThumbnailView getCardThumbnailView() {
        if (getParentCard() != null) {
            return getParentCard().getCardView().getInternalThumbnailLayout();
        }
        return null;
    }
}
