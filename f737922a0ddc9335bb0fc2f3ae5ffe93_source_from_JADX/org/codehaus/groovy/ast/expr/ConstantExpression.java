package org.codehaus.groovy.ast.expr;

import org.codehaus.groovy.ast.ClassHelper;

public class ConstantExpression extends Expression {
    public static final ConstantExpression DW;
    public static final ConstantExpression FH;
    public static final ConstantExpression Hw;
    public static final ConstantExpression VH;
    public static final ConstantExpression Zo;
    public static final ConstantExpression gn;
    public static final ConstantExpression u7;
    public static final ConstantExpression v5;
    private Object tp;

    static {
        DW = new ConstantExpression(null);
        FH = new ConstantExpression(Boolean.TRUE);
        Hw = new ConstantExpression(Boolean.FALSE);
        v5 = new ConstantExpression("");
        Zo = new ConstantExpression(Boolean.TRUE, true);
        VH = new ConstantExpression(Boolean.FALSE, true);
        gn = new ConstantExpression(Void.class);
        u7 = new ConstantExpression(null);
    }

    public ConstantExpression(Object obj) {
        this(obj, false);
    }

    public ConstantExpression(Object obj, boolean z) {
        this.tp = obj;
        if (obj == null) {
            return;
        }
        if (!z) {
            DW(ClassHelper.DW(obj.getClass()));
        } else if (obj instanceof Integer) {
            DW(ClassHelper.QX);
        } else if (obj instanceof Long) {
            DW(ClassHelper.XL);
        } else if (obj instanceof Boolean) {
            DW(ClassHelper.J0);
        } else if (obj instanceof Double) {
            DW(ClassHelper.j3);
        } else if (obj instanceof Float) {
            DW(ClassHelper.Mr);
        } else {
            DW(ClassHelper.DW(obj.getClass()));
        }
    }

    public String toString() {
        return "ConstantExpression[" + this.tp + "]";
    }

    public Object Zo() {
        return this.tp;
    }

    public String j6() {
        return this.tp == null ? "null" : this.tp.toString();
    }
}
