package com.aide.ui.marketing;

import android.content.Context;
import android.text.TextUtils;
import com.aide.ui.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class a {
    static a[] j6;

    public static class a {
        public String DW;
        public String FH;
        public String Hw;
        public int j6;
        public String v5;

        public a(int i, String str, String str2, String str3, String str4) {
            this.j6 = i;
            this.DW = str;
            this.FH = str2;
            this.Hw = str3;
            this.v5 = str4;
        }

        public List<String> j6(Context context) {
            return j6(context, this.v5);
        }

        public String DW(Context context) {
            return TextUtils.join("\n", j6(context));
        }

        private List<String> j6(Context context, String str) {
            List<String> arrayList = new ArrayList();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                bufferedReader.close();
            } catch (IOException e) {
            }
            return arrayList;
        }
    }

    static {
        j6 = new a[]{new a(R.drawable.ic_launcher, "com.aide.ui", "AIDE - Android IDE for Java/C++", "Develop programs and apps directly on your Android devices", "whatsnew/aide-whatsnew.txt"), new a(R.drawable.ic_launcher_web, "com.aide.web", "AIDE Web - Html, Css, JavaScript", "Develop websites directly on your Android devices", "whatsnew/aide-web-whatsnew.txt"), new a(R.drawable.ic_launcher_phonegap, "com.aide.phonegap", "AIDE for Phonegap", "Develop Phonegap apps with Html & JavaScript directly on your Android devices", "whatsnew/aide-phonegap-whatsnew.txt")};
    }

    public static String j6(Context context) {
        for (a aVar : j6) {
            if (aVar.DW.equals(context.getPackageName())) {
                return aVar.DW(context);
            }
        }
        return "";
    }
}
