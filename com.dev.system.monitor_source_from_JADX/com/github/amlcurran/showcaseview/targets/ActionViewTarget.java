package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;
import android.support.v4.media.TransportMediator;
import it.gmariotti.cardslib.library.internal.Card;

public class ActionViewTarget implements Target {
    ActionBarViewWrapper mActionBarWrapper;
    private final Activity mActivity;
    Reflector mReflector;
    private final Type mType;

    /* renamed from: com.github.amlcurran.showcaseview.targets.ActionViewTarget.1 */
    static /* synthetic */ class C01601 {
        static final /* synthetic */ int[] f6xa3716ac1;

        static {
            f6xa3716ac1 = new int[Type.values().length];
            try {
                f6xa3716ac1[Type.SPINNER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6xa3716ac1[Type.HOME.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6xa3716ac1[Type.OVERFLOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6xa3716ac1[Type.TITLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6xa3716ac1[Type.MEDIA_ROUTE_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public enum Type {
        SPINNER,
        HOME,
        TITLE,
        OVERFLOW,
        MEDIA_ROUTE_BUTTON
    }

    public ActionViewTarget(Activity activity, Type type) {
        this.mActivity = activity;
        this.mType = type;
    }

    protected void setUp() {
        this.mReflector = ReflectorFactory.getReflectorForActivity(this.mActivity);
        this.mActionBarWrapper = new ActionBarViewWrapper(this.mReflector.getActionBarView());
    }

    public Point getPoint() {
        Target internal = null;
        setUp();
        switch (C01601.f6xa3716ac1[this.mType.ordinal()]) {
            case Card.CLICK_LISTENER_THUMBNAIL_VIEW /*1*/:
                internal = new ViewTarget(this.mActionBarWrapper.getSpinnerView());
                break;
            case Card.CLICK_LISTENER_HEADER_VIEW /*2*/:
                internal = new ViewTarget(this.mReflector.getHomeButton());
                break;
            case FragmentManagerImpl.ANIM_STYLE_CLOSE_ENTER /*3*/:
                internal = new ViewTarget(this.mActionBarWrapper.getOverflowView());
                break;
            case TransportMediator.FLAG_KEY_MEDIA_PLAY /*4*/:
                internal = new ViewTarget(this.mActionBarWrapper.getTitleView());
                break;
            case FragmentManagerImpl.ANIM_STYLE_FADE_ENTER /*5*/:
                internal = new ViewTarget(this.mActionBarWrapper.getMediaRouterButtonView());
                break;
        }
        return internal.getPoint();
    }
}
