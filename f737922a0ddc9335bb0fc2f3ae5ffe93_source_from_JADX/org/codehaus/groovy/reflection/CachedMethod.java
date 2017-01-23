package org.codehaus.groovy.reflection;

import groovy.lang.MetaMethod;
import java.lang.reflect.Method;
import java.util.Comparator;

public class CachedMethod extends MetaMethod implements Comparable {
    private static MyComparator Hw;
    private final Method DW;
    private int FH;
    public final CachedClass j6;

    private static class MyComparator implements Comparator {
        private MyComparator() {
        }

        public int compare(Object obj, Object obj2) {
            if (obj instanceof CachedMethod) {
                return ((CachedMethod) obj).compareTo(obj2);
            }
            if (obj2 instanceof CachedMethod) {
                return -((CachedMethod) obj2).compareTo(obj);
            }
            throw new ClassCastException("One of the two comparables must be a CachedMethod");
        }
    }

    static {
        Hw = new MyComparator();
    }

    public CachedMethod(CachedClass cachedClass, Method method) {
        this.DW = method;
        this.j6 = cachedClass;
    }

    public String j6() {
        return this.DW.getName();
    }

    public Class DW() {
        return this.DW.getReturnType();
    }

    public int compareTo(Object obj) {
        if (obj instanceof CachedMethod) {
            return j6((CachedMethod) obj);
        }
        return j6((Method) obj);
    }

    private int j6(CachedMethod cachedMethod) {
        if (cachedMethod == null) {
            return -1;
        }
        int compareTo = j6().compareTo(cachedMethod.j6());
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = DW().getName().compareTo(cachedMethod.DW().getName());
        if (compareTo != 0) {
            return compareTo;
        }
        CachedClass[] parameterTypes = getParameterTypes();
        CachedClass[] parameterTypes2 = cachedMethod.getParameterTypes();
        compareTo = parameterTypes.length - parameterTypes2.length;
        if (compareTo != 0) {
            return compareTo;
        }
        for (compareTo = 0; compareTo != parameterTypes.length; compareTo++) {
            int compareTo2 = parameterTypes[compareTo].v5().compareTo(parameterTypes2[compareTo].v5());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        throw new RuntimeException("Should never happen");
    }

    private int j6(Method method) {
        if (method == null) {
            return -1;
        }
        int compareTo = j6().compareTo(method.getName());
        if (compareTo != 0) {
            return compareTo;
        }
        compareTo = DW().getName().compareTo(method.getReturnType().getName());
        if (compareTo != 0) {
            return compareTo;
        }
        CachedClass[] parameterTypes = getParameterTypes();
        Class[] parameterTypes2 = method.getParameterTypes();
        compareTo = parameterTypes.length - parameterTypes2.length;
        if (compareTo != 0) {
            return compareTo;
        }
        for (compareTo = 0; compareTo != parameterTypes.length; compareTo++) {
            int compareTo2 = parameterTypes[compareTo].v5().compareTo(parameterTypes2[compareTo].getName());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        return 0;
    }

    public boolean j6(Object obj) {
        return ((obj instanceof CachedMethod) && this.DW.equals(((CachedMethod) obj).DW)) || ((obj instanceof Method) && this.DW.equals(obj));
    }

    public int FH() {
        if (this.FH == 0) {
            this.FH = this.DW.hashCode();
            if (this.FH == 0) {
                this.FH = -889274690;
            }
        }
        return this.FH;
    }

    public String Hw() {
        return this.DW.toString();
    }
}
