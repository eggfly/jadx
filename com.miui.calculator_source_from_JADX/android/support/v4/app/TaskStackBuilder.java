package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskStackBuilder implements Iterable<Intent> {
    private static final TaskStackBuilderImpl f380a;
    private final ArrayList<Intent> f381b;

    public interface SupportParentable {
    }

    interface TaskStackBuilderImpl {
    }

    static class TaskStackBuilderImplBase implements TaskStackBuilderImpl {
        TaskStackBuilderImplBase() {
        }
    }

    static class TaskStackBuilderImplHoneycomb implements TaskStackBuilderImpl {
        TaskStackBuilderImplHoneycomb() {
        }
    }

    static class TaskStackBuilderImplJellybean implements TaskStackBuilderImpl {
        TaskStackBuilderImplJellybean() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f380a = new TaskStackBuilderImplHoneycomb();
        } else {
            f380a = new TaskStackBuilderImplBase();
        }
    }

    public Iterator<Intent> iterator() {
        return this.f381b.iterator();
    }
}
