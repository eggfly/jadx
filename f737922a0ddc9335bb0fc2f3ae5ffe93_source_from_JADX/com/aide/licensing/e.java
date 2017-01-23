package com.aide.licensing;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class e {
    private static final SecureRandom j6;

    static class 1 implements Comparator<Account> {
        1() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((Account) obj, (Account) obj2);
        }

        public int j6(Account account, Account account2) {
            return e.DW(account.name).compareTo(e.DW(account2.name));
        }
    }

    static {
        j6 = new SecureRandom();
    }

    public static long j6(Context context) {
        return (j6.nextLong() << 32) | DW(context);
    }

    public static boolean j6(Context context, long j) {
        return (4294967295L & j) == DW(context);
    }

    public static long DW(Context context) {
        byte[] FH = FH(context);
        return (((((long) FH[3]) & 255) << 24) | (((((long) FH[0]) & 255) | ((((long) FH[1]) & 255) << 8)) | ((((long) FH[2]) & 255) << 16))) & 268435455;
    }

    private static byte[] FH(Context context) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(Hw(context).getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String Hw(Context context) {
        String simSerialNumber;
        String str = "(default)";
        String str2 = "(default)";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            try {
                str = telephonyManager.getDeviceId();
            } catch (Exception e) {
            }
            try {
                simSerialNumber = telephonyManager.getSimSerialNumber();
            } catch (Exception e2) {
                simSerialNumber = str2;
            }
            str2 = str;
        } catch (Exception e3) {
            simSerialNumber = str2;
            str2 = str;
        }
        str = "(default)";
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e4) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android id: ");
        stringBuilder.append(str);
        stringBuilder.append(";");
        stringBuilder.append("tel device id: ");
        stringBuilder.append(str2);
        stringBuilder.append(";");
        stringBuilder.append("tel sim serial no: ");
        stringBuilder.append(simSerialNumber);
        stringBuilder.append(";");
        stringBuilder.append("accounts: ");
        try {
            Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.google");
            Arrays.sort(accountsByType, new 1());
            for (Account account : accountsByType) {
                try {
                    stringBuilder.append(DW(account.name));
                    stringBuilder.append(",");
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
        }
        return stringBuilder.toString();
    }

    private static String DW(String str) {
        if (str == null) {
            return "";
        }
        return str.trim().toLowerCase(Locale.US);
    }
}
