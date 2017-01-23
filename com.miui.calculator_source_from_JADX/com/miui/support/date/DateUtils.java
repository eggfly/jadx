package com.miui.support.date;

import android.content.Context;
import android.text.format.DateFormat;
import com.miui.support.internal.C0264R;
import com.miui.support.util.AppConstants;
import com.miui.support.util.Pools;
import com.miui.support.util.Pools.Manager;
import com.miui.support.util.Pools.Pool;
import java.util.TimeZone;

public class DateUtils {
    private static final Pool<Calendar> f1973a;

    /* renamed from: com.miui.support.date.DateUtils.1 */
    final class C02421 extends Manager<Calendar> {
        C02421() {
        }

        public /* synthetic */ Object m3425b() {
            return m3424a();
        }

        public Calendar m3424a() {
            return new Calendar();
        }
    }

    static {
        f1973a = Pools.m5435b(new C02421(), 1);
    }

    protected DateUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static String m3428a(long j, int i) {
        StringBuilder stringBuilder = (StringBuilder) Pools.m5430a().m5400b();
        String stringBuilder2 = m3429a(stringBuilder, j, i, null).toString();
        Pools.m5430a().m5401b(stringBuilder);
        return stringBuilder2;
    }

    public static StringBuilder m3429a(StringBuilder stringBuilder, long j, int i, TimeZone timeZone) {
        Context a = AppConstants.m4227a();
        if ((i & 16) == 0 && (i & 32) == 0) {
            i |= DateFormat.is24HourFormat(a) ? 32 : 16;
        }
        String string = a.getString(m3431c(i));
        CharSequence charSequence = (StringBuilder) Pools.m5430a().m5400b();
        Calendar calendar = (Calendar) f1973a.m5400b();
        calendar.m3386a(timeZone);
        calendar.m3385a(j);
        int length = string.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = string.charAt(i2);
            switch (charAt) {
                case 'D':
                    charSequence.append(a.getString(m3426a(i)));
                    break;
                case 'T':
                    charSequence.append(a.getString(m3427a(calendar, i)));
                    break;
                case 'W':
                    charSequence.append(a.getString(m3430b(i)));
                    break;
                default:
                    charSequence.append(charAt);
                    break;
            }
        }
        calendar.m3389a(stringBuilder, charSequence);
        Pools.m5430a().m5401b(charSequence);
        f1973a.m5401b(calendar);
        return stringBuilder;
    }

    private static int m3427a(Calendar calendar, int i) {
        if ((i & 16384) == 16384 && (((i & 1) != 1 || calendar.m3380a(22) == 0) && (i & 14) != 0)) {
            i &= -2;
            if (((i & 2) != 2 || calendar.m3380a(21) == 0) && (i & 12) != 0) {
                i &= -3;
                if (calendar.m3380a(20) == 0 && (i & 8) != 0) {
                    i &= -5;
                }
            }
        }
        if ((i & 8) == 8) {
            if ((i & 16) == 16) {
                if ((i & 64) == 64) {
                    if ((i & 4) != 4) {
                        return C0264R.string.fmt_time_12hour;
                    }
                    if ((i & 2) != 2) {
                        return C0264R.string.fmt_time_12hour_minute;
                    }
                    if ((i & 1) == 1) {
                        return C0264R.string.fmt_time_12hour_minute_second_millis;
                    }
                    return C0264R.string.fmt_time_12hour_minute_second;
                } else if ((i & 4) != 4) {
                    return C0264R.string.fmt_time_12hour_pm;
                } else {
                    if ((i & 2) != 2) {
                        return C0264R.string.fmt_time_12hour_minute_pm;
                    }
                    if ((i & 1) == 1) {
                        return C0264R.string.fmt_time_12hour_minute_second_millis_pm;
                    }
                    return C0264R.string.fmt_time_12hour_minute_second_pm;
                }
            } else if ((i & 4) != 4) {
                return C0264R.string.fmt_time_24hour;
            } else {
                if ((i & 2) != 2) {
                    return C0264R.string.fmt_time_24hour_minute;
                }
                if ((i & 1) == 1) {
                    return C0264R.string.fmt_time_24hour_minute_second_millis;
                }
                return C0264R.string.fmt_time_24hour_minute_second;
            }
        } else if ((i & 4) == 4) {
            if ((i & 2) != 2) {
                return C0264R.string.fmt_time_minute;
            }
            if ((i & 1) == 1) {
                return C0264R.string.fmt_time_minute_second_millis;
            }
            return C0264R.string.fmt_time_minute_second;
        } else if ((i & 2) == 2) {
            if ((i & 1) == 1) {
                return C0264R.string.fmt_time_second_millis;
            }
            return C0264R.string.fmt_time_second;
        } else if ((i & 1) == 1) {
            return C0264R.string.fmt_time_millis;
        } else {
            throw new IllegalArgumentException("no any time date");
        }
    }

    private static int m3426a(int i) {
        if ((i & 32768) == 32768) {
            if ((i & 512) == 512) {
                if ((i & 256) != 256) {
                    return C0264R.string.fmt_date_numeric_year;
                }
                if ((i & 128) == 128) {
                    return C0264R.string.fmt_date_numeric_year_month_day;
                }
                return C0264R.string.fmt_date_numeric_year_month;
            } else if ((i & 256) == 256) {
                if ((i & 128) == 128) {
                    return C0264R.string.fmt_date_numeric_month_day;
                }
                return C0264R.string.fmt_date_numeric_month;
            } else if ((i & 128) == 128) {
                return C0264R.string.fmt_date_numeric_day;
            } else {
                throw new IllegalArgumentException("no any time date");
            }
        } else if ((i & 4096) == 4096) {
            if ((i & 512) == 512) {
                if ((i & 256) != 256) {
                    return C0264R.string.fmt_date_year;
                }
                if ((i & 128) == 128) {
                    return C0264R.string.fmt_date_short_year_month_day;
                }
                return C0264R.string.fmt_date_short_year_month;
            } else if ((i & 256) == 256) {
                if ((i & 128) == 128) {
                    return C0264R.string.fmt_date_short_month_day;
                }
                return C0264R.string.fmt_date_short_month;
            } else if ((i & 128) == 128) {
                return C0264R.string.fmt_date_day;
            } else {
                throw new IllegalArgumentException("no any time date");
            }
        } else if ((i & 512) == 512) {
            if ((i & 256) != 256) {
                return C0264R.string.fmt_date_year;
            }
            if ((i & 128) == 128) {
                return C0264R.string.fmt_date_long_year_month_day;
            }
            return C0264R.string.fmt_date_long_year_month;
        } else if ((i & 256) == 256) {
            if ((i & 128) == 128) {
                return C0264R.string.fmt_date_long_month_day;
            }
            return C0264R.string.fmt_date_long_month;
        } else if ((i & 128) == 128) {
            return C0264R.string.fmt_date_day;
        } else {
            throw new IllegalArgumentException("no any time date");
        }
    }

    private static int m3430b(int i) {
        return (i & 8192) == 8192 ? C0264R.string.fmt_weekday_short : C0264R.string.fmt_weekday_long;
    }

    private static int m3431c(int i) {
        if ((i & 1024) != 1024) {
            return (i & 896) != 0 ? (i & 15) != 0 ? (i & 2048) == 2048 ? C0264R.string.fmt_date_time_timezone : C0264R.string.fmt_date_time : (i & 2048) == 2048 ? C0264R.string.fmt_date_timezone : C0264R.string.fmt_date : (i & 15) != 0 ? (i & 2048) == 2048 ? C0264R.string.fmt_time_timezone : C0264R.string.fmt_time : (i & 2048) == 2048 ? C0264R.string.fmt_timezone : C0264R.string.empty;
        } else {
            if ((i & 896) == 0) {
                return (i & 15) != 0 ? (i & 2048) == 2048 ? C0264R.string.fmt_weekday_time_timezone : C0264R.string.fmt_weekday_time : (i & 2048) == 2048 ? C0264R.string.fmt_weekday_timezone : C0264R.string.fmt_weekday;
            } else {
                if ((i & 15) == 0) {
                    return (i & 2048) == 2048 ? C0264R.string.fmt_weekday_date_timezone : C0264R.string.fmt_weekday_date;
                } else {
                    if ((i & 2048) == 2048) {
                        return C0264R.string.fmt_weekday_date_time_timezone;
                    }
                    return C0264R.string.fmt_weekday_date_time;
                }
            }
        }
    }
}
