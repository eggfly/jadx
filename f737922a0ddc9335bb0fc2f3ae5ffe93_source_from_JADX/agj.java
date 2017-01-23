import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.internal.i;
import com.google.android.gms.internal.j;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class agj {
    private static final List<String> DW;
    private static final List<String> FH;
    private static final List<String> Hw;
    private static final Object Zo;
    static final Map<String, agj> j6;
    private static final Set<String> v5;
    private final AtomicBoolean EQ;
    private final List<agj$a> J0;
    private final List<Object> J8;
    private final Context VH;
    private final String gn;
    private final AtomicBoolean tp;
    private final agk u7;
    private final List<Object> we;

    static {
        DW = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
        FH = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
        Hw = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
        v5 = Collections.emptySet();
        Zo = new Object();
        j6 = new l();
    }

    protected agj(Context context, String str, agk agk) {
        this.tp = new AtomicBoolean(true);
        this.EQ = new AtomicBoolean();
        this.we = new CopyOnWriteArrayList();
        this.J0 = new CopyOnWriteArrayList();
        this.J8 = new CopyOnWriteArrayList();
        this.VH = (Context) b.j6((Object) context);
        this.gn = b.j6(str);
        this.u7 = (agk) b.j6((Object) agk);
    }

    private static String DW(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void DW(Context context) {
        if (agb.FH() && (context.getApplicationContext() instanceof Application)) {
            i.j6((Application) context.getApplicationContext());
        }
    }

    private void DW(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (agj$a j6 : this.J0) {
            j6.j6(z);
        }
    }

    public static agj Hw() {
        return j6("[DEFAULT]");
    }

    private static List<String> VH() {
        Collection afm = new afm();
        synchronized (Zo) {
            for (agj DW : j6.values()) {
                afm.add(DW.DW());
            }
            j j6 = j.j6();
            if (j6 != null) {
                afm.addAll(j6.DW());
            }
        }
        List<String> arrayList = new ArrayList(afm);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void Zo() {
        b.j6(!this.EQ.get(), (Object) "FirebaseApp was deleted");
    }

    public static agj j6(Context context) {
        agk j6 = agk.j6(context);
        return j6 == null ? null : j6(context, j6);
    }

    public static agj j6(Context context, agk agk) {
        return j6(context, agk, "[DEFAULT]");
    }

    public static agj j6(Context context, agk agk, String str) {
        Object agj;
        j j6 = j.j6(context);
        DW(context);
        String DW = DW(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (Zo) {
            b.j6(!j6.containsKey(DW), new StringBuilder(String.valueOf(DW).length() + 33).append("FirebaseApp name ").append(DW).append(" already exists!").toString());
            b.j6(applicationContext, (Object) "Application context cannot be null.");
            agj = new agj(applicationContext, DW, agk);
            j6.put(DW, agj);
        }
        j6.j6((agj) agj);
        j6(agj.class, agj, DW);
        if (agj.v5()) {
            j6(agj.class, agj, FH);
            j6(Context.class, agj.j6(), Hw);
        }
        return agj;
    }

    public static agj j6(String str) {
        agj agj;
        synchronized (Zo) {
            agj = (agj) j6.get(DW(str));
            if (agj != null) {
            } else {
                String str2;
                Iterable VH = VH();
                if (VH.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(ac.j6(", ").j6(VH));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return agj;
    }

    private static <T> void j6(Class<T> cls, T t, Iterable<String> iterable) {
        for (String str : iterable) {
            String str2;
            try {
                Class cls2 = Class.forName(str2);
                Method method = cls2.getMethod("getInstance", new Class[]{cls});
                if ((method.getModifiers() & 9) == 9) {
                    method.invoke(null, new Object[]{t});
                }
                String valueOf = String.valueOf(cls2);
                Log.d("FirebaseApp", new StringBuilder(String.valueOf(valueOf).length() + 13).append("Initialized ").append(valueOf).append(".").toString());
            } catch (ClassNotFoundException e) {
                if (v5.contains(str2)) {
                    throw new IllegalStateException(String.valueOf(str2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(str2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(str2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str3 = "FirebaseApp";
                String str4 = "Failed to initialize ";
                str2 = String.valueOf(str2);
                Log.wtf(str3, str2.length() != 0 ? str4.concat(str2) : new String(str4), e4);
            }
        }
    }

    public static void j6(boolean z) {
        synchronized (Zo) {
            Iterator it = new ArrayList(j6.values()).iterator();
            while (it.hasNext()) {
                agj agj = (agj) it.next();
                if (agj.tp.get()) {
                    agj.DW(z);
                }
            }
        }
    }

    public String DW() {
        Zo();
        return this.gn;
    }

    public agk FH() {
        Zo();
        return this.u7;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof agj) ? false : this.gn.equals(((agj) obj).DW());
    }

    public int hashCode() {
        return this.gn.hashCode();
    }

    public Context j6() {
        Zo();
        return this.VH;
    }

    public String toString() {
        return ae.j6((Object) this).j6("name", this.gn).j6("options", this.u7).toString();
    }

    public boolean v5() {
        return "[DEFAULT]".equals(DW());
    }
}
