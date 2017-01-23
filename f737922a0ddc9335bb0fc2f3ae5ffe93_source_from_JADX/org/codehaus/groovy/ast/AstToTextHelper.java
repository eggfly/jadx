package org.codehaus.groovy.ast;

import java.lang.reflect.Modifier;

public class AstToTextHelper {
    public static String j6(ClassNode classNode) {
        if (classNode == null) {
            return "<unknown>";
        }
        if (classNode.tp() == null) {
            return "<unknown>";
        }
        return classNode.tp();
    }

    public static String j6(Parameter parameter) {
        if (parameter == null) {
            return "<unknown>";
        }
        String t_ = parameter.t_() == null ? "<unknown>" : parameter.t_();
        String j6 = j6(parameter.s_());
        if (parameter.VH() != null) {
            return j6 + " " + t_ + " = " + parameter.VH().j6();
        }
        return j6 + " " + t_;
    }

    public static String j6(Parameter[] parameterArr) {
        if (parameterArr == null) {
            return "";
        }
        if (parameterArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = parameterArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(j6(parameterArr[i]));
            if (i < length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public static String j6(ClassNode[] classNodeArr) {
        if (classNodeArr == null) {
            return "";
        }
        if (classNodeArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("throws ");
        int length = classNodeArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(j6(classNodeArr[i]));
            if (i < length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public static String j6(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Modifier.isPrivate(i)) {
            stringBuilder.append("private ");
        }
        if (Modifier.isProtected(i)) {
            stringBuilder.append("protected ");
        }
        if (Modifier.isPublic(i)) {
            stringBuilder.append("public ");
        }
        if (Modifier.isStatic(i)) {
            stringBuilder.append("static ");
        }
        if (Modifier.isAbstract(i)) {
            stringBuilder.append("abstract ");
        }
        if (Modifier.isFinal(i)) {
            stringBuilder.append("final ");
        }
        if (Modifier.isInterface(i)) {
            stringBuilder.append("interface ");
        }
        if (Modifier.isNative(i)) {
            stringBuilder.append("native ");
        }
        if (Modifier.isSynchronized(i)) {
            stringBuilder.append("synchronized ");
        }
        if (Modifier.isTransient(i)) {
            stringBuilder.append("transient ");
        }
        if (Modifier.isVolatile(i)) {
            stringBuilder.append("volatile ");
        }
        return stringBuilder.toString().trim();
    }
}
