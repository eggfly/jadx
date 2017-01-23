package com.google.gson.internal.bind.util;

import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.android.spdy.SpdyProtocol;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC;
    private static final String UTC_ID = "UTC";

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        Calendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder stringBuilder = new StringBuilder((timeZone.getRawOffset() == 0 ? "Z".length() : "+hh:mm".length()) + ("yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0)));
        padInt(stringBuilder, gregorianCalendar.get(1), "yyyy".length());
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(2) + 1, "MM".length());
        stringBuilder.append('-');
        padInt(stringBuilder, gregorianCalendar.get(5), "dd".length());
        stringBuilder.append('T');
        padInt(stringBuilder, gregorianCalendar.get(11), "hh".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(12), "mm".length());
        stringBuilder.append(':');
        padInt(stringBuilder, gregorianCalendar.get(13), "ss".length());
        if (z) {
            stringBuilder.append('.');
            padInt(stringBuilder, gregorianCalendar.get(14), "sss".length());
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int abs = Math.abs((offset / 60000) / 60);
            int abs2 = Math.abs((offset / 60000) % 60);
            stringBuilder.append(offset < 0 ? '-' : '+');
            padInt(stringBuilder, abs, "hh".length());
            stringBuilder.append(':');
            padInt(stringBuilder, abs2, "mm".length());
        } else {
            stringBuilder.append('Z');
        }
        return stringBuilder.toString();
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder stringBuilder, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(num);
    }

    public static Date parse(String str, ParsePosition parsePosition) {
        Throwable th;
        String message;
        ParseException parseException;
        String substring;
        try {
            int index = parsePosition.getIndex();
            int i = index + 4;
            int parseInt = parseInt(str, index, i);
            index = checkOffset(str, i, '-') ? i + 1 : i;
            i = index + 2;
            int parseInt2 = parseInt(str, index, i);
            index = checkOffset(str, i, '-') ? i + 1 : i;
            i = index + 2;
            int parseInt3 = parseInt(str, index, i);
            boolean checkOffset = checkOffset(str, i, 'T');
            if (checkOffset || str.length() > i) {
                int parseInt4;
                int i2;
                int i3;
                if (checkOffset) {
                    index = i + 1;
                    i = index + 2;
                    parseInt4 = parseInt(str, index, i);
                    index = checkOffset(str, i, ':') ? i + 1 : i;
                    i = index + 2;
                    index = parseInt(str, index, i);
                    if (checkOffset(str, i, ':')) {
                        i++;
                    }
                    if (str.length() > i) {
                        char charAt = str.charAt(i);
                        if (!(charAt == 'Z' || charAt == '+' || charAt == '-')) {
                            i2 = i + 2;
                            i = parseInt(str, i, i2);
                            if (i > 59 && i < 63) {
                                i = 59;
                            }
                            if (checkOffset(str, i2, '.')) {
                                i3 = i2 + 1;
                                i2 = indexOfNonDigit(str, i3 + 1);
                                int min = Math.min(i2, i3 + 3);
                                int parseInt5 = parseInt(str, i3, min);
                                switch (min - i3) {
                                    case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                                        parseInt5 *= 100;
                                        break;
                                    case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                                        parseInt5 *= 10;
                                        break;
                                }
                                i3 = parseInt4;
                                parseInt4 = i;
                                i = i2;
                                i2 = index;
                                index = parseInt5;
                            } else {
                                i3 = parseInt4;
                                parseInt4 = i;
                                i = i2;
                                i2 = index;
                                index = 0;
                            }
                        }
                    }
                    i2 = index;
                    i3 = parseInt4;
                    index = 0;
                    parseInt4 = 0;
                } else {
                    index = 0;
                    parseInt4 = 0;
                    i2 = 0;
                    i3 = 0;
                }
                if (str.length() <= i) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                TimeZone timeZone;
                char charAt2 = str.charAt(i);
                if (charAt2 == 'Z') {
                    timeZone = TIMEZONE_UTC;
                    i++;
                } else if (charAt2 == '+' || charAt2 == '-') {
                    substring = str.substring(i);
                    if (substring.length() < 5) {
                        substring = substring + "00";
                    }
                    i += substring.length();
                    if ("+0000".equals(substring) || "+00:00".equals(substring)) {
                        timeZone = TIMEZONE_UTC;
                    } else {
                        String str2 = "GMT" + substring;
                        timeZone = TimeZone.getTimeZone(str2);
                        String id = timeZone.getID();
                        if (!(id.equals(str2) || id.replace(":", BuildConfig.FLAVOR).equals(str2))) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str2 + " given, resolves to " + timeZone.getID());
                        }
                    }
                } else {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                }
                Calendar gregorianCalendar = new GregorianCalendar(timeZone);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, parseInt);
                gregorianCalendar.set(2, parseInt2 - 1);
                gregorianCalendar.set(5, parseInt3);
                gregorianCalendar.set(11, i3);
                gregorianCalendar.set(12, i2);
                gregorianCalendar.set(13, parseInt4);
                gregorianCalendar.set(14, index);
                parsePosition.setIndex(i);
                return gregorianCalendar.getTime();
            }
            Calendar gregorianCalendar2 = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
            parsePosition.setIndex(i);
            return gregorianCalendar2.getTime();
        } catch (Throwable e) {
            th = e;
            substring = str == null ? null : '\"' + str + "'";
            message = th.getMessage();
            if (message == null || message.isEmpty()) {
                message = C4233j.f14396s + th.getClass().getName() + C4233j.f14397t;
            }
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e2) {
            th = e2;
            if (str == null) {
            }
            message = th.getMessage();
            message = C4233j.f14396s + th.getClass().getName() + C4233j.f14397t;
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e22) {
            th = e22;
            if (str == null) {
            }
            message = th.getMessage();
            message = C4233j.f14396s + th.getClass().getName() + C4233j.f14397t;
            parseException = new ParseException("Failed to parse date [" + substring + "]: " + message, parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i, int i2) {
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        int i3;
        int i4 = 0;
        if (i < i2) {
            i3 = i + 1;
            i4 = Character.digit(str.charAt(i), 10);
            if (i4 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = -i4;
        } else {
            i3 = i;
        }
        while (i3 < i2) {
            int i5 = i3 + 1;
            i3 = Character.digit(str.charAt(i3), 10);
            if (i3 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i4 = (i4 * 10) - i3;
            i3 = i5;
        }
        return -i4;
    }
}
