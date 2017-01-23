package com.miui.support.internal.hybrid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class XmlConfigParser implements ConfigParser {
    private XmlResourceParser f2482a;

    private XmlConfigParser(XmlResourceParser xmlResourceParser) {
        this.f2482a = xmlResourceParser;
    }

    public static XmlConfigParser m4091a(Context context) {
        int i = 0;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                i = bundle.getInt("com.miui.sdk.hybrid.config");
            }
            if (i == 0) {
                i = context.getResources().getIdentifier("miui_hybrid_config", "xml", context.getPackageName());
            }
            return m4092a(context, i);
        } catch (NameNotFoundException e) {
            throw new HybridException(201, e.getMessage());
        }
    }

    public static XmlConfigParser m4092a(Context context, int i) {
        try {
            return m4093a(context.getResources().getXml(i));
        } catch (NotFoundException e) {
            throw new HybridException(201, e.getMessage());
        }
    }

    public static XmlConfigParser m4093a(XmlResourceParser xmlResourceParser) {
        return new XmlConfigParser(xmlResourceParser);
    }

    public Config m4100a(Map<String, Object> map) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        }
        Config config = new Config();
        if (this.f2482a != null) {
            try {
                XmlResourceParser xmlResourceParser = this.f2482a;
                int next;
                do {
                    next = xmlResourceParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if ("widget".equals(xmlResourceParser.getName())) {
                    m4094a(config, xmlResourceParser);
                }
                this.f2482a.close();
            } catch (XmlPullParserException e) {
                throw new HybridException(201, e.getMessage());
            } catch (IOException e2) {
                throw new HybridException(201, e2.getMessage());
            } catch (Throwable th) {
                this.f2482a.close();
            }
        }
        return m4089a(config, hashMap);
    }

    private void m4094a(Config config, XmlResourceParser xmlResourceParser) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                return;
            }
            if (!(next == 3 || next == 4)) {
                String name = xmlResourceParser.getName();
                if ("content".equals(name)) {
                    m4096b(config, xmlResourceParser);
                } else if ("feature".equals(name)) {
                    m4097c(config, xmlResourceParser);
                } else if ("preference".equals(name)) {
                    m4098d(config, xmlResourceParser);
                } else if ("access".equals(name)) {
                    m4099e(config, xmlResourceParser);
                }
            }
        }
    }

    private void m4096b(Config config, XmlResourceParser xmlResourceParser) {
        config.m4001b(xmlResourceParser.getAttributeValue(null, "src"));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4097c(com.miui.support.internal.hybrid.Config r6, android.content.res.XmlResourceParser r7) {
        /*
        r5 = this;
        r4 = 3;
        r0 = new com.miui.support.internal.hybrid.Feature;
        r0.<init>();
        r1 = 0;
        r2 = "name";
        r1 = r7.getAttributeValue(r1, r2);
        r0.m4015a(r1);
        r1 = r7.getDepth();
    L_0x0014:
        r2 = r7.next();
        r3 = 1;
        if (r2 == r3) goto L_0x0038;
    L_0x001b:
        if (r2 != r4) goto L_0x0023;
    L_0x001d:
        r3 = r7.getDepth();
        if (r3 <= r1) goto L_0x0038;
    L_0x0023:
        if (r2 == r4) goto L_0x0014;
    L_0x0025:
        r3 = 4;
        if (r2 == r3) goto L_0x0014;
    L_0x0028:
        r2 = r7.getName();
        r3 = "param";
        r2 = r3.equals(r2);
        if (r2 == 0) goto L_0x0014;
    L_0x0034:
        r5.m4095a(r0, r7);
        goto L_0x0014;
    L_0x0038:
        r6.m3995a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.support.internal.hybrid.XmlConfigParser.c(com.miui.support.internal.hybrid.Config, android.content.res.XmlResourceParser):void");
    }

    private void m4095a(Feature feature, XmlResourceParser xmlResourceParser) {
        feature.m4016a(xmlResourceParser.getAttributeValue(null, "name").toLowerCase(), xmlResourceParser.getAttributeValue(null, "value"));
    }

    private void m4098d(Config config, XmlResourceParser xmlResourceParser) {
        String toLowerCase = xmlResourceParser.getAttributeValue(null, "name").toLowerCase();
        String attributeValue = xmlResourceParser.getAttributeValue(null, "value");
        if ("signature".equals(toLowerCase)) {
            m4090a(config).m4074a(attributeValue);
        } else if ("timestamp".equals(toLowerCase)) {
            m4090a(config).m4073a(Long.parseLong(attributeValue));
        } else if ("vendor".equals(toLowerCase)) {
            config.m3998a(attributeValue);
        } else {
            config.m3999a(toLowerCase, attributeValue);
        }
    }

    private Security m4090a(Config config) {
        Security a = config.m3994a();
        if (a != null) {
            return a;
        }
        a = new Security();
        config.m3997a(a);
        return a;
    }

    private void m4099e(Config config, XmlResourceParser xmlResourceParser) {
        Permission permission = new Permission();
        permission.m4066a(xmlResourceParser.getAttributeValue(null, "origin"));
        permission.m4067a(xmlResourceParser.getAttributeBooleanValue(null, "subdomains", false));
        permission.m4068b(false);
        config.m3996a(permission);
    }

    private Config m4089a(Config config, Map<String, Object> map) {
        return config;
    }
}
