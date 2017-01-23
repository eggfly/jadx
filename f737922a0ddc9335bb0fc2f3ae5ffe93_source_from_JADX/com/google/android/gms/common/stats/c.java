package com.google.android.gms.common.stats;

import com.google.android.gms.internal.hh;

public final class c {
    public static hh<Integer> DW;
    public static hh<Integer> j6;

    public static final class a {
        public static hh<String> DW;
        public static hh<String> FH;
        public static hh<String> Hw;
        public static hh<Long> Zo;
        public static hh<Integer> j6;
        public static hh<String> v5;

        static {
            j6 = hh.j6("gms:common:stats:connections:level", Integer.valueOf(d.DW));
            DW = hh.j6("gms:common:stats:connections:ignored_calling_processes", "");
            FH = hh.j6("gms:common:stats:connections:ignored_calling_services", "");
            Hw = hh.j6("gms:common:stats:connections:ignored_target_processes", "");
            v5 = hh.j6("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
            Zo = hh.j6("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
        }
    }

    public static final class b {
        public static hh<Long> DW;
        public static hh<Integer> j6;

        static {
            j6 = hh.j6("gms:common:stats:wakeLocks:level", Integer.valueOf(d.DW));
            DW = hh.j6("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
        }
    }

    static {
        j6 = hh.j6("gms:common:stats:max_num_of_events", Integer.valueOf(100));
        DW = hh.j6("gms:common:stats:max_chunk_size", Integer.valueOf(100));
    }
}
