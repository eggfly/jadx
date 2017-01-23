package com.google.android.gms.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzabu {
    public static final Integer DW;
    public static final Integer j6;
    private final Context FH;
    private final ExecutorService Hw;

    static {
        j6 = Integer.valueOf(0);
        DW = Integer.valueOf(1);
    }

    public zzabu(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzabu(Context context, ExecutorService executorService) {
        this.FH = context;
        this.Hw = executorService;
    }
}
