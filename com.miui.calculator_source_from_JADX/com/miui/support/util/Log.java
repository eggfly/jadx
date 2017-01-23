package com.miui.support.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.miui.support.internal.log.Logger;
import com.miui.support.internal.log.receiver.DumpReceiver;

public class Log {

    public static class DumpLogReceiver extends BroadcastReceiver {
        private DumpReceiver f3676a;

        public DumpLogReceiver() {
            this.f3676a = new DumpReceiver();
        }

        public void onReceive(Context context, Intent intent) {
            this.f3676a.onReceive(context, intent);
        }
    }

    public static class Facade {
        private Logger f3677a;

        private Facade(Logger logger) {
            this.f3677a = logger;
        }
    }

    private static class FileLoggerInstance {
        static final Facade f3678a;

        private FileLoggerInstance() {
        }

        static {
            f3678a = new Facade(null);
        }
    }

    private static class FullFacade extends Facade {
        private FullFacade() {
            super(null);
        }
    }

    private static class FullLoggerInstance {
        static final Facade f3679a;

        private FullLoggerInstance() {
        }

        static {
            f3679a = new FullFacade();
        }
    }

    private static class LogcatLoggerInstance {
        static final Facade f3680a;

        private LogcatLoggerInstance() {
        }

        static {
            f3680a = new Facade(null);
        }
    }

    protected Log() {
        throw new InstantiationException("Cannot instantiate utility class");
    }
}
