package com.antutu.benchmark.platform.p049b.p050a;

import com.antutu.redacc.C1692R;
import com.antutu.utils.jni;
import com.facebook.ads.C2279R;
import com.handmark.pulltorefresh.library.C3628R;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.C4209a;
import org.android.spdy.SpdyProtocol;

/* renamed from: com.antutu.benchmark.platform.b.a.n */
public class C1562n {
    public static C1550m m6180a(int i, int i2, int i3) {
        if ((C1558i.f5422a & i) == C1558i.f5422a) {
            switch (i) {
                case SpdyProtocol.CUSTOM /*16*/:
                    return new C1559j(i, i2, i3);
                case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
                case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                    return new C1551b(i, i2, i3);
                case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
                case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                    return new C1553d(i, i2, i3);
                case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
                case C4209a.f14215r /*22*/:
                    return new C1560k(i, i2, i3);
                case C2279R.styleable.Toolbar_titleTextColor /*23*/:
                case C4209a.f14216s /*24*/:
                    return new C1566r(i, i2, i3);
                case C2279R.styleable.ActionBar_popupTheme /*25*/:
                case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                    return new C1554e(i, i2, i3);
                case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
                case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                case C1692R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                case jni.SID_RAM /*30*/:
                case jni.SID_CPU_MATH /*31*/:
                    return new C1565q(i, i2, i3);
                default:
                    return new C1556g(i, i2, i3);
            }
        }
        switch (i - C1558i.f5422a) {
            case SpdyProtocol.CUSTOM /*16*/:
                return new C1559j(i, i2, i3);
            case C3628R.styleable.PullToRefresh_ptrDrawableTop /*17*/:
            case C3628R.styleable.PullToRefresh_ptrDrawableBottom /*18*/:
                return new C1551b(i, i2, i3);
            case C2279R.styleable.Toolbar_collapseContentDescription /*19*/:
            case MsgConstant.CACHE_LOG_COUNT_MAX /*20*/:
                return new C1553d(i, i2, i3);
            case MsgConstant.ACTION_MIPUSH_MSG_CLICK /*21*/:
            case C4209a.f14215r /*22*/:
                return new C1560k(i, i2, i3);
            case C2279R.styleable.Toolbar_titleTextColor /*23*/:
            case C4209a.f14216s /*24*/:
                return new C1566r(i, i2, i3);
            case C2279R.styleable.ActionBar_popupTheme /*25*/:
            case C2279R.styleable.ActionBar_homeAsUpIndicator /*26*/:
                return new C1554e(i, i2, i3);
            case C1692R.styleable.AppCompatTheme_actionModeStyle /*27*/:
            case C1692R.styleable.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
            case C1692R.styleable.AppCompatTheme_actionModeBackground /*29*/:
            case jni.SID_RAM /*30*/:
            case jni.SID_CPU_MATH /*31*/:
                return new C1565q(i, i2, i3);
            default:
                return new C1556g(i, i2, i3);
        }
    }
}
