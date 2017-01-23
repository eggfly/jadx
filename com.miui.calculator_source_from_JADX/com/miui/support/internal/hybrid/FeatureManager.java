package com.miui.support.internal.hybrid;

import com.miui.support.hybrid.HybridFeature;
import com.miui.support.internal.util.ClassTransformer;
import java.util.HashMap;
import java.util.Map;

public class FeatureManager {
    private Map<String, HybridFeature> f2431a;
    private Config f2432b;
    private ClassLoader f2433c;

    public FeatureManager(Config config, ClassLoader classLoader) {
        this.f2431a = new HashMap();
        this.f2432b = config;
        this.f2433c = classLoader;
    }

    private HybridFeature m4019b(String str) {
        try {
            return (HybridFeature) this.f2433c.loadClass(ClassTransformer.m4218a(str)).newInstance();
        } catch (ClassNotFoundException e) {
            throw new HybridException(204, "feature not found: " + str);
        } catch (InstantiationException e2) {
            throw new HybridException(204, "feature cannot be instantiated: " + str);
        } catch (IllegalAccessException e3) {
            throw new HybridException(204, "feature cannot be accessed: " + str);
        }
    }

    public HybridFeature m4020a(String str) {
        HybridFeature hybridFeature = (HybridFeature) this.f2431a.get(str);
        if (hybridFeature != null) {
            return hybridFeature;
        }
        Feature c = this.f2432b.m4002c(str);
        if (c == null) {
            throw new HybridException(204, "feature not declared: " + str);
        }
        hybridFeature = m4019b(str);
        hybridFeature.m3505a(c.m4018b());
        this.f2431a.put(str, hybridFeature);
        return hybridFeature;
    }
}
