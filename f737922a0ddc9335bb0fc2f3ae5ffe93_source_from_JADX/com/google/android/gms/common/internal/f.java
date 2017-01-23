package com.google.android.gms.common.internal;

import agh;
import agi;
import agi$a;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ab.a;

public final class f extends agi<ab> {
    private static final f j6;

    static {
        j6 = new f();
    }

    private f() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    private View DW(Context context, int i, int i2, Scope[] scopeArr) {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, scopeArr);
            return (View) agh.j6(((ab) j6(context)).j6(agh.j6((Object) context), signInButtonConfig));
        } catch (Throwable e) {
            throw new agi$a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public static View j6(Context context, int i, int i2, Scope[] scopeArr) {
        return j6.DW(context, i, i2, scopeArr);
    }

    public /* synthetic */ Object DW(IBinder iBinder) {
        return j6(iBinder);
    }

    public ab j6(IBinder iBinder) {
        return a.j6(iBinder);
    }
}
