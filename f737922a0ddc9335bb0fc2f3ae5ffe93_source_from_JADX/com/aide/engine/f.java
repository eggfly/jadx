package com.aide.engine;

import android.content.Context;

public enum f {
    PLAIN("Plain", 2131230798, 2131230797, 0),
    KEYWORD("Keyword", 2131230790, 2131230789, 1),
    IDENTIFIER("Identifier", 2131230788, 2131230787, 0),
    NAMESPACE_IDENTIFIER("Namespace/Package Identifier", 2131230796, 2131230795, 2),
    TYPE_IDENTIFIER("Type Identifier", 2131230802, 2131230801, 0),
    DELEGATE_IDENTIFIER("Delegate Identifier", 2131230802, 2131230801, 2),
    OPERATOR("Operator", 2131230794, 2131230793, 0),
    SEPARATOR("Separator/Punctuator", 2131230800, 2131230799, 0),
    LITERAL("Literal", 2131230792, 2131230791, 0),
    PREPROCESSOR("Preprocessor", 2131230798, 2131230797, 0),
    COMMENT("Comment", 2131230786, 2131230785, 0),
    DOC_COMMENT("Documentation Comment", 2131230786, 2131230785, 2),
    SCRIPT_BACKGROUND("Script Background", 2131230798, 2131230797, 0),
    SCRIPT("Script", 2131230798, 2131230797, 0);
    
    private final int QX;
    private final int Ws;
    private final int XL;
    private final String aM;

    private f(String str, int i, int i2, int i3) {
        this.aM = str;
        this.QX = i;
        this.Ws = i2;
        this.XL = i3;
    }

    public int j6() {
        return this.XL;
    }

    public int j6(Context context, boolean z) {
        return context.getResources().getColor(z ? this.QX : this.Ws);
    }
}
