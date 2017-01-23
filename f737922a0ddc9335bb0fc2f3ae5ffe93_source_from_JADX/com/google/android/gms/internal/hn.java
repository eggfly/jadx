package com.google.android.gms.internal;

import agg;
import agh;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.i;
import java.lang.reflect.Field;

public final class hn {
    public static final b DW;
    public static final b FH;
    public static final b Hw;
    private static final a VH;
    private static ho Zo;
    public static final b j6;
    public static final b v5;
    private final Context gn;

    class 1 implements a {
        1() {
        }

        public int j6(Context context, String str) {
            return hn.j6(context, str);
        }

        public int j6(Context context, String str, boolean z) {
            return hn.j6(context, str, z);
        }
    }

    public interface b {

        public interface a {
            int j6(Context context, String str);

            int j6(Context context, String str, boolean z);
        }

        public static class b {
            public int DW;
            public int FH;
            public int j6;

            public b() {
                this.j6 = 0;
                this.DW = 0;
                this.FH = 0;
            }
        }

        b j6(Context context, String str, a aVar);
    }

    class 2 implements b {
        2() {
        }

        public b j6(Context context, String str, a aVar) {
            b bVar = new b();
            bVar.DW = aVar.j6(context, str, true);
            if (bVar.DW != 0) {
                bVar.FH = 1;
            } else {
                bVar.j6 = aVar.j6(context, str);
                if (bVar.j6 != 0) {
                    bVar.FH = -1;
                }
            }
            return bVar;
        }
    }

    class 3 implements b {
        3() {
        }

        public b j6(Context context, String str, a aVar) {
            b bVar = new b();
            bVar.j6 = aVar.j6(context, str);
            if (bVar.j6 != 0) {
                bVar.FH = -1;
            } else {
                bVar.DW = aVar.j6(context, str, true);
                if (bVar.DW != 0) {
                    bVar.FH = 1;
                }
            }
            return bVar;
        }
    }

    class 4 implements b {
        4() {
        }

        public b j6(Context context, String str, a aVar) {
            b bVar = new b();
            bVar.j6 = aVar.j6(context, str);
            bVar.DW = aVar.j6(context, str, true);
            if (bVar.j6 == 0 && bVar.DW == 0) {
                bVar.FH = 0;
            } else if (bVar.j6 >= bVar.DW) {
                bVar.FH = -1;
            } else {
                bVar.FH = 1;
            }
            return bVar;
        }
    }

    class 5 implements b {
        5() {
        }

        public b j6(Context context, String str, a aVar) {
            b bVar = new b();
            bVar.j6 = aVar.j6(context, str);
            bVar.DW = aVar.j6(context, str, true);
            if (bVar.j6 == 0 && bVar.DW == 0) {
                bVar.FH = 0;
            } else if (bVar.DW >= bVar.j6) {
                bVar.FH = 1;
            } else {
                bVar.FH = -1;
            }
            return bVar;
        }
    }

    class 6 implements b {
        6() {
        }

        public b j6(Context context, String str, a aVar) {
            b bVar = new b();
            bVar.j6 = aVar.j6(context, str);
            if (bVar.j6 != 0) {
                bVar.DW = aVar.j6(context, str, false);
            } else {
                bVar.DW = aVar.j6(context, str, true);
            }
            if (bVar.j6 == 0 && bVar.DW == 0) {
                bVar.FH = 0;
            } else if (bVar.DW >= bVar.j6) {
                bVar.FH = 1;
            } else {
                bVar.FH = -1;
            }
            return bVar;
        }
    }

    class 7 implements a {
        final /* synthetic */ int j6;

        7(int i) {
            this.j6 = i;
        }

        public int j6(Context context, String str) {
            return this.j6;
        }

        public int j6(Context context, String str, boolean z) {
            return 0;
        }
    }

    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        VH = new 1();
        j6 = new 2();
        DW = new 3();
        FH = new 4();
        Hw = new 5();
        v5 = new 6();
    }

    private hn(Context context) {
        this.gn = (Context) com.google.android.gms.common.internal.b.j6((Object) context);
    }

    private static hn DW(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        String valueOf = String.valueOf(str);
        Log.i(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        return new hn(context.getApplicationContext());
    }

    public static int j6(Context context, String str) {
        String valueOf;
        String valueOf2;
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            valueOf2 = String.valueOf("ModuleDescriptor");
            Class loadClass = classLoader.loadClass(new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()) + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (Exception e) {
            valueOf = "DynamiteModule";
            valueOf2 = "Failed to load module descriptor class: ";
            String valueOf3 = String.valueOf(e.getMessage());
            Log.e(valueOf, valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2));
            return 0;
        }
    }

    public static int j6(Context context, String str, boolean z) {
        ho j6 = j6(context);
        if (j6 == null) {
            return 0;
        }
        try {
            return j6.j6(agh.j6((Object) context), str, z);
        } catch (RemoteException e) {
            String str2 = "DynamiteModule";
            String str3 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            return 0;
        }
    }

    public static hn j6(Context context, b bVar, String str) {
        b j6 = bVar.j6(context, str, VH);
        Log.i("DynamiteModule", new StringBuilder((String.valueOf(str).length() + 68) + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(j6.j6).append(" and remote module ").append(str).append(":").append(j6.DW).toString());
        if (j6.FH == 0 || ((j6.FH == -1 && j6.j6 == 0) || (j6.FH == 1 && j6.DW == 0))) {
            throw new a(null);
        } else if (j6.FH == -1) {
            return DW(context, str);
        } else {
            if (j6.FH == 1) {
                try {
                    return j6(context, str, j6.DW);
                } catch (Throwable e) {
                    Throwable th = e;
                    String str2 = "DynamiteModule";
                    String str3 = "Failed to load remote module: ";
                    String valueOf = String.valueOf(th.getMessage());
                    Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    if (j6.j6 != 0 && bVar.j6(context, str, new 7(j6.j6)).FH == -1) {
                        return DW(context, str);
                    }
                    throw new a(th, null);
                }
            }
            throw new a(null);
        }
    }

    private static hn j6(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        ho j6 = j6(context);
        if (j6 == null) {
            throw new a(null);
        }
        try {
            agg j62 = j6.j6(agh.j6((Object) context), str, i);
            if (agh.j6(j62) != null) {
                return new hn((Context) agh.j6(j62));
            }
            throw new a(null);
        } catch (Throwable e) {
            throw new a(e, null);
        }
    }

    private static ho j6(Context context) {
        synchronized (hn.class) {
            ho hoVar;
            if (Zo != null) {
                hoVar = Zo;
                return hoVar;
            } else if (i.DW().j6(context) != 0) {
                return null;
            } else {
                try {
                    hoVar = com.google.android.gms.internal.ho.a.j6((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (hoVar != null) {
                        Zo = hoVar;
                        return hoVar;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
                return null;
            }
        }
    }

    public Context j6() {
        return this.gn;
    }
}
