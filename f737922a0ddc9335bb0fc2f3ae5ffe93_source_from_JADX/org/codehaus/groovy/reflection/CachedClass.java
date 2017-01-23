package org.codehaus.groovy.reflection;

import groovy.lang.MetaMethod;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.codehaus.groovy.runtime.callsite.CallSiteClassLoader;
import org.codehaus.groovy.util.LazyReference;
import org.codehaus.groovy.util.ReferenceBundle;

public class CachedClass {
    static final MetaMethod[] DW;
    private static ReferenceBundle J0;
    public static final CachedClass[] v5;
    public final boolean EQ;
    int FH;
    public CachedMethod[] Hw;
    private final LazyReference<CachedField[]> J8;
    private final LazyReference<Set<CachedClass>> Mr;
    private LazyReference<CachedMethod[]> QX;
    private final LazyReference<Set<CachedClass>> U2;
    public final boolean VH;
    private LazyReference<CachedConstructor[]> Ws;
    private LazyReference<CachedClass> XL;
    public final boolean Zo;
    private final LazyReference<CallSiteClassLoader> aM;
    public final int gn;
    private final LazyReference<LinkedList<ClassInfo>> j3;
    public ClassInfo j6;
    public final boolean tp;
    int u7;
    private final Class we;

    class 1 extends LazyReference<CachedField[]> {
        final /* synthetic */ CachedClass j6;

        class 1 implements PrivilegedAction {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public Object run() {
                Object declaredFields = this.j6.j6.Zo().getDeclaredFields();
                try {
                    AccessibleObject.setAccessible(declaredFields, true);
                } catch (SecurityException e) {
                }
                return declaredFields;
            }
        }

        1(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public CachedField[] j6() {
            Field[] fieldArr = (Field[]) AccessController.doPrivileged(new 1(this));
            CachedField[] cachedFieldArr = new CachedField[fieldArr.length];
            for (int i = 0; i != cachedFieldArr.length; i++) {
                cachedFieldArr[i] = new CachedField(fieldArr[i]);
            }
            return cachedFieldArr;
        }
    }

    class 2 extends LazyReference<CachedConstructor[]> {
        final /* synthetic */ CachedClass j6;

        class 1 implements PrivilegedAction {
            final /* synthetic */ 2 j6;

            1(2 2) {
                this.j6 = 2;
            }

            public Object run() {
                return this.j6.j6.Zo().getDeclaredConstructors();
            }
        }

        2(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public CachedConstructor[] j6() {
            Constructor[] constructorArr = (Constructor[]) AccessController.doPrivileged(new 1(this));
            CachedConstructor[] cachedConstructorArr = new CachedConstructor[constructorArr.length];
            for (int i = 0; i != cachedConstructorArr.length; i++) {
                cachedConstructorArr[i] = new CachedConstructor(this.j6, constructorArr[i]);
            }
            return cachedConstructorArr;
        }
    }

    class 3 extends LazyReference<CachedMethod[]> {
        final /* synthetic */ CachedClass j6;

        class 1 implements PrivilegedAction {
            final /* synthetic */ 3 j6;

            1(3 3) {
                this.j6 = 3;
            }

            public Object run() {
                Object declaredMethods = this.j6.j6.Zo().getDeclaredMethods();
                try {
                    AccessibleObject.setAccessible(declaredMethods, true);
                } catch (SecurityException e) {
                }
                return declaredMethods;
            }
        }

        3(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public CachedMethod[] j6() {
            int i = 0;
            Method[] methodArr = (Method[]) AccessController.doPrivileged(new 1(this));
            List arrayList = new ArrayList(methodArr.length);
            List arrayList2 = new ArrayList(methodArr.length);
            for (int i2 = 0; i2 != methodArr.length; i2++) {
                CachedMethod cachedMethod = new CachedMethod(this.j6, methodArr[i2]);
                String j6 = cachedMethod.j6();
                if (!methodArr[i2].isBridge() && j6.indexOf(43) < 0) {
                    if (j6.startsWith("this$") || j6.startsWith("super$")) {
                        arrayList2.add(cachedMethod);
                    } else {
                        arrayList.add(cachedMethod);
                    }
                }
            }
            CachedMethod[] cachedMethodArr = (CachedMethod[]) arrayList.toArray(new CachedMethod[arrayList.size()]);
            Arrays.sort(cachedMethodArr);
            CachedClass j62 = this.j6.j6();
            if (j62 != null) {
                j62.Hw();
                CachedMethod[] cachedMethodArr2 = j62.Hw;
                while (i != cachedMethodArr2.length) {
                    arrayList2.add(cachedMethodArr2[i]);
                    i++;
                }
            }
            this.j6.Hw = (CachedMethod[]) arrayList2.toArray(new CachedMethod[arrayList2.size()]);
            Arrays.sort(this.j6.Hw, CachedMethodComparatorByName.j6);
            return cachedMethodArr;
        }
    }

    class 4 extends LazyReference<CachedClass> {
        final /* synthetic */ CachedClass j6;

        4(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public CachedClass j6() {
            if (!this.j6.Zo) {
                return ReflectionCache.j6(this.j6.Zo().getSuperclass());
            }
            if (this.j6.we.getComponentType().isPrimitive() || this.j6.we.getComponentType() == Object.class) {
                return ReflectionCache.FH;
            }
            return ReflectionCache.Hw;
        }
    }

    class 5 extends LazyReference<CallSiteClassLoader> {
        final /* synthetic */ CachedClass j6;

        class 1 implements PrivilegedAction<CallSiteClassLoader> {
            final /* synthetic */ 5 j6;

            1(5 5) {
                this.j6 = 5;
            }

            public /* synthetic */ Object run() {
                return j6();
            }

            public CallSiteClassLoader j6() {
                return new CallSiteClassLoader(this.j6.j6.we);
            }
        }

        5(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public CallSiteClassLoader j6() {
            return (CallSiteClassLoader) AccessController.doPrivileged(new 1(this));
        }
    }

    class 6 extends LazyReference<LinkedList<ClassInfo>> {
        final /* synthetic */ CachedClass j6;

        6(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public LinkedList<ClassInfo> j6() {
            Collection linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(this.j6.j6);
            for (CachedClass VH : this.j6.FH()) {
                linkedHashSet.addAll(VH.VH());
            }
            CachedClass VH2 = this.j6.j6();
            if (VH2 != null) {
                linkedHashSet.addAll(VH2.VH());
            }
            if (this.j6.tp) {
                linkedHashSet.add(ReflectionCache.FH.j6);
            }
            return new LinkedList(linkedHashSet);
        }
    }

    class 7 extends LazyReference<Set<CachedClass>> {
        final /* synthetic */ CachedClass j6;

        7(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public Set<CachedClass> j6() {
            int i = 0;
            Set<CachedClass> hashSet = new HashSet(0);
            Class[] interfaces = this.j6.Zo().getInterfaces();
            int length = interfaces.length;
            while (i < length) {
                hashSet.add(ReflectionCache.j6(interfaces[i]));
                i++;
            }
            return hashSet;
        }
    }

    class 8 extends LazyReference<Set<CachedClass>> {
        final /* synthetic */ CachedClass j6;

        8(CachedClass cachedClass, ReferenceBundle referenceBundle) {
            this.j6 = cachedClass;
            super(referenceBundle);
        }

        public /* synthetic */ Object DW() {
            return j6();
        }

        public Set<CachedClass> j6() {
            int i = 0;
            Set<CachedClass> hashSet = new HashSet(0);
            if (this.j6.Zo().isInterface()) {
                hashSet.add(this.j6);
            }
            Class[] interfaces = this.j6.Zo().getInterfaces();
            int length = interfaces.length;
            while (i < length) {
                CachedClass j6 = ReflectionCache.j6(interfaces[i]);
                if (!hashSet.contains(j6)) {
                    hashSet.addAll(j6.DW());
                }
                i++;
            }
            CachedClass j62 = this.j6.j6();
            if (j62 != null) {
                hashSet.addAll(j62.DW());
            }
            return hashSet;
        }
    }

    public static class CachedMethodComparatorByName implements Comparator {
        public static final Comparator j6;

        static {
            j6 = new CachedMethodComparatorByName();
        }

        public int compare(Object obj, Object obj2) {
            return ((CachedMethod) obj).j6().compareTo(((CachedMethod) obj2).j6());
        }
    }

    public static class CachedMethodComparatorWithString implements Comparator {
        public static final Comparator j6;

        static {
            j6 = new CachedMethodComparatorWithString();
        }

        public int compare(Object obj, Object obj2) {
            if (obj instanceof CachedMethod) {
                return ((CachedMethod) obj).j6().compareTo((String) obj2);
            }
            return ((String) obj).compareTo(((CachedMethod) obj2).j6());
        }
    }

    static {
        J0 = ReferenceBundle.FH();
        DW = new MetaMethod[0];
        v5 = new CachedClass[0];
    }

    public CachedClass(Class cls, ClassInfo classInfo) {
        this.J8 = new 1(this, J0);
        this.Ws = new 2(this, J0);
        this.QX = new 3(this, J0);
        this.XL = new 4(this, J0);
        this.aM = new 5(this, J0);
        this.j3 = new 6(this, J0);
        this.Mr = new 7(this, J0);
        this.U2 = new 8(this, J0);
        this.u7 = -1;
        this.we = cls;
        this.j6 = classInfo;
        this.Zo = cls.isArray();
        this.VH = cls.isPrimitive();
        this.gn = cls.getModifiers();
        this.tp = cls.isInterface();
        this.EQ = Number.class.isAssignableFrom(cls);
        for (CachedClass cachedClass : DW()) {
            ReflectionCache.DW(cls, cachedClass.we);
        }
        while (this != null) {
            ReflectionCache.j6(this.we, cls);
            this = j6();
        }
    }

    public CachedClass j6() {
        return (CachedClass) this.XL.FH();
    }

    public Set<CachedClass> DW() {
        return (Set) this.U2.FH();
    }

    public Set<CachedClass> FH() {
        return (Set) this.Mr.FH();
    }

    public CachedMethod[] Hw() {
        return (CachedMethod[]) this.QX.FH();
    }

    public int hashCode() {
        if (this.FH == 0) {
            this.FH = super.hashCode();
            if (this.FH == 0) {
                this.FH = -889274690;
            }
        }
        return this.FH;
    }

    public String v5() {
        return Zo().getName();
    }

    public final Class Zo() {
        return this.we;
    }

    public Collection<ClassInfo> VH() {
        return (Collection) this.j3.FH();
    }

    public String toString() {
        return this.we.toString();
    }
}
