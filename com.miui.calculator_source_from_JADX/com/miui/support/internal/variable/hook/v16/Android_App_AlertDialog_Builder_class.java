package com.miui.support.internal.variable.hook.v16;

import android.app.AlertDialog.Builder;
import android.content.Context;
import com.miui.support.internal.variable.AlertControllerWrapper.AlertParams;
import com.miui.support.internal.variable.VariableExceptionHandler;
import com.miui.support.reflect.Field;

public class Android_App_AlertDialog_Builder_class extends com.miui.support.internal.variable.hook.Android_App_AlertDialog_Builder_class {
    private static final Field f2582P;

    static {
        f2582P = Field.of(Builder.class, "P", "Lcom/android/internal/app/AlertController$AlertParams;");
    }

    public void buildProxy() {
        attachConstructor("(Landroid/content/Context;I)V");
    }

    protected void handle() {
        handle_init_(0, null, null, 0);
    }

    protected void handle_init_(long j, Builder builder, Context context, int i) {
        original_init_(j, builder, context, i);
        try {
            f2582P.set((Object) builder, new AlertParams(builder.getContext()));
        } catch (Throwable e) {
            VariableExceptionHandler.getInstance().onThrow("P", e);
        }
    }

    protected void original_init_(long j, Builder builder, Context context, int i) {
        throw new IllegalStateException("com.miui.internal.variable.hook.v16.Android_App_AlertDialog_Builder_class.original_init_(long, AlertDialog.Builder, Context, int)");
    }
}
