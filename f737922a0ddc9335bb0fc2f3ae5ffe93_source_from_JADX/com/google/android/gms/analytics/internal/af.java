package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class af<T extends ae> extends s {
    a<T> j6;

    public interface a<U extends ae> {
        U DW();

        void DW(String str, String str2);

        void j6(String str, int i);

        void j6(String str, String str2);

        void j6(String str, boolean z);
    }

    public af(v vVar, a<T> aVar) {
        super(vVar);
        this.j6 = aVar;
    }

    private T j6(XmlResourceParser xmlResourceParser) {
        Object trim;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim2;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim2))) {
                            this.j6.j6(toLowerCase, trim2);
                        }
                    } else if (toLowerCase.equals("string")) {
                        Object attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        trim2 = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(attributeValue) || trim2 == null)) {
                            this.j6.DW(attributeValue, trim2);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.j6.j6(toLowerCase, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                FH("Error parsing bool configuration value", trim, e);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.j6.j6(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                FH("Error parsing int configuration value", trim, e2);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            v5("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            v5("Error parsing tracker configuration file", e4);
        }
        return this.j6.DW();
    }

    public T j6(int i) {
        try {
            return j6(EQ().FH().getResources().getXml(i));
        } catch (NotFoundException e) {
            Hw("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
