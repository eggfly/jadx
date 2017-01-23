package com.aide.common;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class TextToSpeechHelper {
    private Map<String, a> DW;
    private Map<String, Map<String, String>> FH;
    private Context j6;

    private class a {
        private TextToSpeech DW;
        private String FH;
        private boolean Hw;
        private String Zo;
        final /* synthetic */ TextToSpeechHelper j6;
        private Locale v5;

        class 1 implements OnInitListener {
            final /* synthetic */ a DW;
            final /* synthetic */ TextToSpeechHelper j6;

            1(a aVar, TextToSpeechHelper textToSpeechHelper) {
                this.DW = aVar;
                this.j6 = textToSpeechHelper;
            }

            public void onInit(int i) {
                this.DW.Hw = true;
                if (this.DW.DW != null) {
                    int isLanguageAvailable = this.DW.DW.isLanguageAvailable(this.DW.v5);
                    e.j6(this.DW.v5 + " TTS available: " + isLanguageAvailable);
                    if (isLanguageAvailable == -1) {
                        this.DW.DW.shutdown();
                        this.DW.DW = null;
                    } else if (isLanguageAvailable == -2) {
                        this.DW.DW.shutdown();
                        this.DW.DW = null;
                    } else {
                        this.DW.DW.getDefaultEngine();
                        this.DW.DW.setLanguage(this.DW.v5);
                        if (this.DW.FH != null) {
                            this.DW.DW.speak(this.DW.FH, 0, null);
                            this.DW.FH = null;
                        }
                    }
                }
            }
        }

        public a(TextToSpeechHelper textToSpeechHelper, String str) {
            this.j6 = textToSpeechHelper;
            this.Zo = str;
            for (Locale locale : Locale.getAvailableLocales()) {
                if (this.Zo.equals(locale.getLanguage())) {
                    this.v5 = locale;
                    break;
                }
            }
            if (this.v5 != null) {
                this.DW = new TextToSpeech(textToSpeechHelper.j6, new 1(this, textToSpeechHelper));
            }
        }

        public void j6() {
            if (this.DW != null) {
                this.DW.shutdown();
            }
        }

        public void j6(String str) {
            String DW = DW(str);
            if (!this.Hw || this.DW == null) {
                this.FH = DW;
            } else {
                this.DW.speak(DW, 0, null);
            }
        }

        private String DW(String str) {
            String str2;
            String replace = str.replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "");
            Map map = (Map) this.j6.FH.get(this.Zo);
            if (map != null) {
                str2 = replace;
                for (Entry entry : map.entrySet()) {
                    str2 = str2.replace("<b>" + ((String) entry.getKey()) + "</b>", (CharSequence) entry.getValue()).replace(" " + ((String) entry.getKey()) + " ", (CharSequence) entry.getValue());
                }
            } else {
                str2 = replace;
            }
            return FH(str2.replace("<b>a</b>", "A").replace("<b>b</b>", "B").replace("<b>c</b>", "C").replace("<b>i</b>", "I").replace("<b>j</b>", "J").replace("<b>k</b>", "K").replace("<b>android:", "<b>").replace("<i>", "").replace("</i>", "").replace("</b>", "").replace("<b>", ""));
        }

        private String FH(String str) {
            char[] toCharArray = str.toCharArray();
            int i = 1;
            while (i < toCharArray.length - 1) {
                if (toCharArray[i] == '_' && Character.isLetterOrDigit(toCharArray[i - 1]) && Character.isLetterOrDigit(toCharArray[i + 1])) {
                    toCharArray[i] = ' ';
                }
                i++;
            }
            return new String(toCharArray);
        }
    }

    public TextToSpeechHelper(Context context) {
        this.j6 = context;
        this.DW = new HashMap();
        this.FH = new HashMap();
        this.FH.put("en", new HashMap());
        ((Map) this.FH.get("en")).put("println", "printline");
        ((Map) this.FH.get("en")).put(";", "semicolon");
        ((Map) this.FH.get("en")).put("<", "less than");
        ((Map) this.FH.get("en")).put(">", "greater than");
        ((Map) this.FH.get("en")).put("< =", "less than or equal");
        ((Map) this.FH.get("en")).put("> =", "greater than or equal");
        ((Map) this.FH.get("en")).put("==", "equal equal");
        ((Map) this.FH.get("en")).put("!=", "not equal");
        ((Map) this.FH.get("en")).put("--", "minus minus");
        ((Map) this.FH.get("en")).put("++", "plus plus");
        ((Map) this.FH.get("en")).put("+", "plus");
        ((Map) this.FH.get("en")).put("-", "minus");
        ((Map) this.FH.get("en")).put("*", "star");
        ((Map) this.FH.get("en")).put("/", "slash");
        this.FH.put("de", new HashMap());
        ((Map) this.FH.get("de")).put("println", "printlein");
        ((Map) this.FH.get("de")).put(";", "Strichpunkt");
        ((Map) this.FH.get("de")).put("<", "kleiner als");
        ((Map) this.FH.get("de")).put(">", "gr\u00f6sser als");
        ((Map) this.FH.get("de")).put("< =", "kleiner gleich");
        ((Map) this.FH.get("de")).put("> =", "gr\u00f6sser gleich");
        ((Map) this.FH.get("de")).put("==", "gleich gleich");
        ((Map) this.FH.get("de")).put("!=", "ungleich");
        ((Map) this.FH.get("de")).put("--", "minus minus");
        ((Map) this.FH.get("de")).put("++", "plus plus");
        ((Map) this.FH.get("de")).put("+", "plus");
        ((Map) this.FH.get("de")).put("-", "minus");
        ((Map) this.FH.get("de")).put("*", "Stern");
        ((Map) this.FH.get("de")).put("/", "Strich");
    }

    public void j6() {
        for (a j6 : this.DW.values()) {
            j6.j6();
        }
    }

    public void j6(String str, String str2) {
        if (!this.DW.containsKey(str)) {
            this.DW.put(str, new a(this, str));
        }
        ((a) this.DW.get(str)).j6(str2);
    }
}
