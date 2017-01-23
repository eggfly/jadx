package org.codehaus.groovy.vmplugin.v5;

import com.aide.uidesigner.ProxyTextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import org.codehaus.groovy.GroovyBugError;
import org.codehaus.groovy.ast.AnnotatedNode;
import org.codehaus.groovy.ast.AnnotationNode;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.CompileUnit;
import org.codehaus.groovy.ast.FieldNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.MethodNode;
import org.codehaus.groovy.ast.Parameter;
import org.codehaus.groovy.ast.expr.ClassExpression;
import org.codehaus.groovy.ast.expr.ConstantExpression;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.ast.expr.ListExpression;
import org.codehaus.groovy.ast.expr.PropertyExpression;
import org.codehaus.groovy.ast.stmt.ReturnStatement;
import org.codehaus.groovy.vmplugin.VMPlugin;

public class Java5 implements VMPlugin {
    private static final Class[] DW;
    private static Class[] j6;

    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] DW;
        static final /* synthetic */ int[] j6;

        static {
            DW = new int[ElementType.values().length];
            try {
                DW[ElementType.TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                DW[ElementType.CONSTRUCTOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                DW[ElementType.METHOD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                DW[ElementType.FIELD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                DW[ElementType.PARAMETER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                DW[ElementType.LOCAL_VARIABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                DW[ElementType.ANNOTATION_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                DW[ElementType.PACKAGE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            j6 = new int[RetentionPolicy.values().length];
            try {
                j6[RetentionPolicy.RUNTIME.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                j6[RetentionPolicy.SOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                j6[RetentionPolicy.CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    static {
        j6 = new Class[0];
        DW = new Class[]{PluginDefaultGroovyMethods.class};
    }

    public void j6(ClassNode classNode) {
        DW(classNode);
    }

    private void DW(ClassNode classNode) {
        classNode.j6(j6(classNode.a8().getTypeParameters()));
    }

    private GenericsType[] j6(TypeVariable[] typeVariableArr) {
        if (typeVariableArr.length == 0) {
            return null;
        }
        GenericsType[] genericsTypeArr = new GenericsType[typeVariableArr.length];
        for (int i = 0; i < typeVariableArr.length; i++) {
            genericsTypeArr[i] = j6(typeVariableArr[i]);
        }
        return genericsTypeArr;
    }

    private GenericsType j6(TypeVariable typeVariable) {
        GenericsType genericsType;
        ClassNode DW = DW(typeVariable);
        ClassNode Zo = DW.Zo();
        DW.DW(null);
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            genericsType = new GenericsType(DW);
        } else {
            genericsType = new GenericsType(DW, j6(bounds), null);
            genericsType.j6(DW.tp());
            genericsType.j6(true);
        }
        DW.DW(Zo);
        return genericsType;
    }

    private ClassNode[] j6(Type[] typeArr) {
        if (typeArr.length == 0) {
            return null;
        }
        ClassNode[] classNodeArr = new ClassNode[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            classNodeArr[i] = j6(typeArr[i]);
        }
        return classNodeArr;
    }

    private ClassNode j6(Type type) {
        if (type instanceof WildcardType) {
            return j6((WildcardType) type);
        }
        if (type instanceof ParameterizedType) {
            return j6((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return j6((GenericArrayType) type);
        }
        if (type instanceof TypeVariable) {
            return DW((TypeVariable) type);
        }
        if (type instanceof Class) {
            return j6((Class) type);
        }
        if (type == null) {
            throw new GroovyBugError("Type is null. Most probably you let a transform reuse existing ClassNodes with generics information, that is now used in a wrong context.");
        }
        throw new GroovyBugError("unknown type: " + type + " := " + type.getClass());
    }

    private ClassNode j6(Class cls) {
        if (cls.isPrimitive()) {
            return ClassHelper.DW(cls);
        }
        return ClassHelper.DW(cls, false);
    }

    private ClassNode j6(GenericArrayType genericArrayType) {
        return j6(genericArrayType.getGenericComponentType()).VH();
    }

    private ClassNode j6(WildcardType wildcardType) {
        ClassNode j6 = ClassHelper.j6("?");
        j6.DW(ClassHelper.DW);
        ClassNode[] j62 = j6(wildcardType.getLowerBounds());
        ClassNode classNode = null;
        if (j62 != null) {
            classNode = j62[0];
        }
        new GenericsType(j6, j6(wildcardType.getUpperBounds()), classNode).DW(true);
        classNode = ClassHelper.DW(Object.class, false);
        classNode.j6(new GenericsType[]{r3});
        return classNode;
    }

    private ClassNode j6(ParameterizedType parameterizedType) {
        ClassNode j6 = j6(parameterizedType.getRawType());
        j6.j6(DW(parameterizedType.getActualTypeArguments()));
        return j6;
    }

    private ClassNode DW(TypeVariable typeVariable) {
        ClassNode j6 = ClassHelper.j6(typeVariable.getName());
        j6.FH(true);
        ClassHelper.j6(typeVariable.getName()).FH(true);
        j6.j6(new GenericsType[]{new GenericsType(r1)});
        j6.DW(ClassHelper.DW);
        return j6;
    }

    private GenericsType[] DW(Type[] typeArr) {
        if (typeArr.length == 0) {
            return null;
        }
        GenericsType[] genericsTypeArr = new GenericsType[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            ClassNode j6 = j6(typeArr[i]);
            if (typeArr[i] instanceof WildcardType) {
                genericsTypeArr[i] = j6.lg()[0];
            } else {
                genericsTypeArr[i] = new GenericsType(j6);
            }
        }
        return genericsTypeArr;
    }

    private void j6(Annotation[] annotationArr, AnnotatedNode annotatedNode) {
        for (Annotation annotation : annotationArr) {
            AnnotationNode annotationNode = new AnnotationNode(ClassHelper.DW(annotation.annotationType()));
            j6(annotationNode, annotation);
            annotatedNode.j6(annotationNode);
        }
    }

    private void j6(AnnotationNode annotationNode, Annotation annotation) {
        int i = 0;
        Class annotationType = annotation.annotationType();
        if (annotationType == Retention.class) {
            RetentionPolicy value = ((Retention) annotation).value();
            j6(value, annotationNode);
            annotationNode.j6("value", new PropertyExpression(new ClassExpression(ClassHelper.DW(RetentionPolicy.class, false)), value.toString()));
        } else if (annotationType == Target.class) {
            ElementType[] value2 = ((Target) annotation).value();
            Expression listExpression = new ListExpression();
            int length = value2.length;
            while (i < length) {
                listExpression.j6(new PropertyExpression(new ClassExpression(ClassHelper.vJ), value2[i].name()));
                i++;
            }
            annotationNode.j6("value", listExpression);
        } else {
            Method[] declaredMethods;
            try {
                declaredMethods = annotationType.getDeclaredMethods();
            } catch (SecurityException e) {
                declaredMethods = new Method[0];
            }
            int length2 = declaredMethods.length;
            while (i < length2) {
                Method method = declaredMethods[i];
                try {
                    Expression j6 = j6(method.invoke(annotation, new Object[0]));
                    if (j6 != null) {
                        annotationNode.j6(method.getName(), j6);
                    }
                } catch (IllegalAccessException e2) {
                } catch (InvocationTargetException e3) {
                }
                i++;
            }
        }
    }

    private Expression j6(Object obj) {
        if (obj == null || (obj instanceof String) || (obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean)) {
            return new ConstantExpression(obj);
        }
        if (obj instanceof Class) {
            return new ClassExpression(ClassHelper.FH((Class) obj));
        }
        if (!obj.getClass().isArray()) {
            return null;
        }
        Expression listExpression = new ListExpression();
        int length = Array.getLength(obj);
        for (int i = 0; i != length; i++) {
            listExpression.j6(j6(Array.get(obj, i)));
        }
        return listExpression;
    }

    private void j6(RetentionPolicy retentionPolicy, AnnotationNode annotationNode) {
        switch (1.j6[retentionPolicy.ordinal()]) {
            case ProxyTextView.TYPEFACE_SANS /*1*/:
                annotationNode.j6(true);
            case ProxyTextView.TYPEFACE_SERIF /*2*/:
                annotationNode.DW(true);
            case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                annotationNode.FH(true);
            default:
                throw new GroovyBugError("unsupported Retention " + retentionPolicy);
        }
    }

    private void j6(MethodNode methodNode, Method method) {
        Object defaultValue = method.getDefaultValue();
        Expression expression = ConstantExpression.DW;
        if (defaultValue != null) {
            expression = new ConstantExpression(defaultValue);
        }
        methodNode.j6(new ReturnStatement(expression));
        methodNode.DW(true);
    }

    public void j6(CompileUnit compileUnit, ClassNode classNode) {
        try {
            Class a8 = classNode.a8();
            for (Field field : a8.getDeclaredFields()) {
                FieldNode fieldNode = new FieldNode(field.getName(), field.getModifiers(), j6(compileUnit, field.getGenericType(), field.getType()), classNode, null);
                j6(field.getAnnotations(), (AnnotatedNode) fieldNode);
                classNode.j6(fieldNode);
            }
            for (Method method : a8.getDeclaredMethods()) {
                MethodNode methodNode = new MethodNode(method.getName(), method.getModifiers(), j6(compileUnit, method.getGenericReturnType(), method.getReturnType()), j6(compileUnit, method.getGenericParameterTypes(), method.getParameterTypes(), method.getParameterAnnotations()), j6(compileUnit, method.getGenericExceptionTypes(), method.getExceptionTypes()), null);
                methodNode.j6(method.isSynthetic());
                j6(methodNode, method);
                j6(method.getAnnotations(), (AnnotatedNode) methodNode);
                methodNode.j6(j6(method.getTypeParameters()));
                classNode.j6(methodNode);
            }
            for (Constructor constructor : a8.getDeclaredConstructors()) {
                classNode.j6(constructor.getModifiers(), j6(compileUnit, constructor.getGenericParameterTypes(), constructor.getParameterTypes(), constructor.getParameterAnnotations()), j6(compileUnit, constructor.getGenericExceptionTypes(), constructor.getExceptionTypes()), null);
            }
            Class superclass = a8.getSuperclass();
            if (superclass != null) {
                classNode.FH(j6(compileUnit, a8.getGenericSuperclass(), superclass));
            }
            j6(compileUnit, classNode, a8);
            j6(classNode.a8().getAnnotations(), (AnnotatedNode) classNode);
            AnnotatedNode J8 = classNode.J8();
            if (J8 != null) {
                j6(classNode.a8().getPackage().getAnnotations(), J8);
            }
        } catch (NoClassDefFoundError e) {
            throw new NoClassDefFoundError("Unable to load class " + classNode.DW(false) + " due to missing dependency " + e.getMessage());
        }
    }

    private void j6(CompileUnit compileUnit, ClassNode classNode, Class cls) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces.length == 0) {
            classNode.j6(ClassNode.DW);
            return;
        }
        ClassNode[] classNodeArr = new ClassNode[genericInterfaces.length];
        for (int i = 0; i < genericInterfaces.length; i++) {
            Type type = genericInterfaces[i];
            while (!(type instanceof Class)) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType == type) {
                    throw new GroovyBugError("Cannot transform generic signature of " + cls + " with generic interface " + genericInterfaces[i] + " to a class.");
                }
                type = rawType;
            }
            classNodeArr[i] = j6(compileUnit, genericInterfaces[i], (Class) type);
        }
        classNode.j6(classNodeArr);
    }

    private ClassNode[] j6(CompileUnit compileUnit, Type[] typeArr, Class[] clsArr) {
        ClassNode[] classNodeArr = new ClassNode[typeArr.length];
        for (int i = 0; i < classNodeArr.length; i++) {
            classNodeArr[i] = j6(compileUnit, typeArr[i], clsArr[i]);
        }
        return classNodeArr;
    }

    private ClassNode j6(CompileUnit compileUnit, Type type, Class cls) {
        ClassNode classNode = null;
        if (compileUnit != null) {
            classNode = compileUnit.j6(cls.getName());
        }
        if (classNode == null) {
            classNode = ClassHelper.DW(cls);
        }
        if (type instanceof Class) {
            return classNode.yS();
        }
        ClassNode j6 = j6(type);
        j6.DW(classNode);
        return j6;
    }

    private Parameter[] j6(CompileUnit compileUnit, Type[] typeArr, Class[] clsArr, Annotation[][] annotationArr) {
        Parameter[] parameterArr = Parameter.DW;
        if (typeArr.length <= 0) {
            return parameterArr;
        }
        Parameter[] parameterArr2 = new Parameter[typeArr.length];
        for (int i = 0; i < parameterArr2.length; i++) {
            parameterArr2[i] = j6(compileUnit, typeArr[i], clsArr[i], annotationArr[i], i);
        }
        return parameterArr2;
    }

    private Parameter j6(CompileUnit compileUnit, Type type, Class cls, Annotation[] annotationArr, int i) {
        AnnotatedNode parameter = new Parameter(j6(compileUnit, type, cls), "param" + i);
        j6(annotationArr, parameter);
        return parameter;
    }
}
