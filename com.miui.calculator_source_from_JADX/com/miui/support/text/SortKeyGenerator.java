package com.miui.support.text;

import com.miui.support.util.SoftReferenceSingleton;

public class SortKeyGenerator {
    private static final SoftReferenceSingleton<SortKeyGenerator> f3596a;
    private BaseGenerator[] f3597b;

    /* renamed from: com.miui.support.text.SortKeyGenerator.1 */
    final class C04231 extends SoftReferenceSingleton<SortKeyGenerator> {
        C04231() {
        }

        protected /* synthetic */ Object createInstance() {
            return m5256a();
        }

        protected SortKeyGenerator m5256a() {
            return new SortKeyGenerator();
        }
    }

    private class BaseGenerator {
        final /* synthetic */ SortKeyGenerator f3588a;

        private BaseGenerator(SortKeyGenerator sortKeyGenerator) {
            this.f3588a = sortKeyGenerator;
        }
    }

    private class ChineseLocaleUtils extends BaseGenerator {
    }

    private enum NameStyle {
        UNDEFINED,
        WESTERN,
        CJK,
        CHINESE,
        JAPANESE,
        KOREAN
    }

    static {
        f3596a = new C04231();
    }

    private SortKeyGenerator() {
        this.f3597b = new BaseGenerator[NameStyle.values().length];
        this.f3597b[NameStyle.UNDEFINED.ordinal()] = new BaseGenerator();
    }
}
