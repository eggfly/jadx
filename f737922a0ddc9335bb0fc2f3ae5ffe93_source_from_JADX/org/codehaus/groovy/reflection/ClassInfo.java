package org.codehaus.groovy.reflection;

import groovy.lang.Closure;
import groovy.lang.ExpandoMetaClass;
import groovy.lang.ExpandoMetaClassCreationHandle;
import groovy.lang.GroovySystem;
import groovy.lang.MetaClass;
import groovy.lang.MetaClassRegistry;
import groovy.lang.MetaClassRegistry.MetaClassCreationHandle;
import groovy.lang.MetaMethod;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.codehaus.groovy.reflection.stdclasses.ArrayCachedClass;
import org.codehaus.groovy.reflection.stdclasses.BigDecimalCachedClass;
import org.codehaus.groovy.reflection.stdclasses.BigIntegerCachedClass;
import org.codehaus.groovy.reflection.stdclasses.BooleanCachedClass;
import org.codehaus.groovy.reflection.stdclasses.ByteCachedClass;
import org.codehaus.groovy.reflection.stdclasses.CachedClosureClass;
import org.codehaus.groovy.reflection.stdclasses.CachedSAMClass;
import org.codehaus.groovy.reflection.stdclasses.CharacterCachedClass;
import org.codehaus.groovy.reflection.stdclasses.DoubleCachedClass;
import org.codehaus.groovy.reflection.stdclasses.FloatCachedClass;
import org.codehaus.groovy.reflection.stdclasses.IntegerCachedClass;
import org.codehaus.groovy.reflection.stdclasses.LongCachedClass;
import org.codehaus.groovy.reflection.stdclasses.NumberCachedClass;
import org.codehaus.groovy.reflection.stdclasses.ObjectCachedClass;
import org.codehaus.groovy.reflection.stdclasses.ShortCachedClass;
import org.codehaus.groovy.reflection.stdclasses.StringCachedClass;
import org.codehaus.groovy.util.LazyReference;
import org.codehaus.groovy.util.LockableObject;
import org.codehaus.groovy.util.ManagedConcurrentMap;
import org.codehaus.groovy.util.ManagedConcurrentMap.Entry;
import org.codehaus.groovy.util.ManagedConcurrentMap.Segment;
import org.codehaus.groovy.util.ManagedReference;
import org.codehaus.groovy.util.ReferenceBundle;

public class ClassInfo extends Entry<Class, ClassInfo> {
    private static ReferenceBundle EQ;
    private static final Set<ClassInfo> Hw;
    private static final ClassInfoSet J0;
    private static final WeakReference<ThreadLocalMapHandler> J8;
    private static ReferenceBundle we;
    MetaMethod[] DW;
    MetaMethod[] FH;
    private final LockableObject VH;
    private final LazyClassLoaderRef Zo;
    private volatile int gn;
    public final int j6;
    private ManagedReference<MetaClass> tp;
    private MetaClass u7;
    private final LazyCachedClassRef v5;

    public static class ClassInfoSet extends ManagedConcurrentMap<Class, ClassInfo> {

        static final class Segment extends org.codehaus.groovy.util.ManagedConcurrentMap.Segment<Class, ClassInfo> {
            Segment(ReferenceBundle referenceBundle, int i) {
                super(referenceBundle, i);
            }

            protected ClassInfo j6(Class cls, int i, ClassInfo classInfo) {
                return new ClassInfo(this, cls, i);
            }
        }

        protected /* synthetic */ org.codehaus.groovy.util.ManagedConcurrentMap.Segment DW(Object obj, int i) {
            return j6(obj, i);
        }

        protected /* synthetic */ org.codehaus.groovy.util.AbstractConcurrentMapBase.Segment FH(Object obj, int i) {
            return j6(obj, i);
        }

        public ClassInfoSet(ReferenceBundle referenceBundle) {
            super(referenceBundle);
        }

        protected Segment j6(Object obj, int i) {
            ReferenceBundle referenceBundle = (ReferenceBundle) obj;
            if (referenceBundle != null) {
                return new Segment(referenceBundle, i);
            }
            throw new IllegalArgumentException("bundle must not be null ");
        }
    }

    private static class DebugRef extends ManagedReference<Class> {
        private static final AtomicInteger j6;

        static {
            j6 = new AtomicInteger();
        }
    }

    private static class LazyCachedClassRef extends LazyReference<CachedClass> {
        private final ClassInfo j6;

        public /* synthetic */ Object DW() {
            return j6();
        }

        LazyCachedClassRef(ReferenceBundle referenceBundle, ClassInfo classInfo) {
            super(referenceBundle);
            this.j6 = classInfo;
        }

        public CachedClass j6() {
            return ClassInfo.DW((Class) this.j6.J0(), this.j6);
        }
    }

    private static class LazyClassLoaderRef extends LazyReference<ClassLoaderForClassArtifacts> {
        private final ClassInfo j6;

        public /* synthetic */ Object DW() {
            return j6();
        }

        LazyClassLoaderRef(ReferenceBundle referenceBundle, ClassInfo classInfo) {
            super(referenceBundle);
            this.j6 = classInfo;
        }

        public ClassLoaderForClassArtifacts j6() {
            return new ClassLoaderForClassArtifacts((Class) this.j6.J0());
        }
    }

    private static final class LocalMap extends HashMap<Class, ClassInfo> {
        private static final ClassInfo Hw;
        private int DW;
        private final ClassInfo[] FH;
        private final PhantomReference<Thread> j6;

        static {
            Hw = new ClassInfo(null, null, 0);
        }

        private LocalMap() {
            this.j6 = new PhantomReference(Thread.currentThread(), null);
            this.FH = new ClassInfo[5];
            for (int i = 0; i < this.FH.length; i++) {
                this.FH[i] = Hw;
            }
        }

        public ClassInfo j6(Class cls) {
            ClassInfo DW = DW(cls);
            if (DW != null) {
                return DW;
            }
            DW = (ClassInfo) super.get(cls);
            if (DW != null) {
                return j6(DW);
            }
            return j6((ClassInfo) ClassInfo.J0.j6(cls, null));
        }

        private ClassInfo DW(Class cls) {
            int i = this.DW - 1;
            int i2 = 0;
            while (i2 < this.FH.length) {
                if (i < 0) {
                    i += 5;
                }
                ClassInfo classInfo = this.FH[i];
                if (cls == classInfo.J0()) {
                    this.DW = i + 1;
                    if (this.DW == 5) {
                        this.DW = 0;
                    }
                    return classInfo;
                }
                i2++;
                i--;
            }
            return null;
        }

        private ClassInfo j6(ClassInfo classInfo) {
            ClassInfo[] classInfoArr = this.FH;
            int i = this.DW;
            this.DW = i + 1;
            classInfoArr[i] = classInfo;
            if (this.DW == 5) {
                this.DW = 0;
            }
            return classInfo;
        }
    }

    private static class ThreadLocalMapHandler extends ThreadLocal<SoftReference<LocalMap>> {
        SoftReference<LocalMap> j6;

        private ThreadLocalMapHandler() {
        }

        public /* synthetic */ Object get() {
            return DW();
        }

        protected /* synthetic */ Object initialValue() {
            return j6();
        }

        protected SoftReference<LocalMap> j6() {
            return new SoftReference(new LocalMap(), null);
        }

        public SoftReference<LocalMap> DW() {
            SoftReference<LocalMap> softReference = this.j6;
            LocalMap localMap = null;
            if (softReference != null) {
                localMap = (LocalMap) softReference.get();
            }
            if (localMap != null && localMap.j6.get() == Thread.currentThread()) {
                return softReference;
            }
            SoftReference<LocalMap> softReference2 = (SoftReference) super.get();
            this.j6 = softReference2;
            return softReference2;
        }
    }

    static {
        Hw = new HashSet();
        EQ = ReferenceBundle.FH();
        we = ReferenceBundle.Hw();
        J0 = new ClassInfoSet(EQ);
        J8 = new WeakReference(new ThreadLocalMapHandler(), null);
    }

    ClassInfo(Segment segment, Class cls, int i) {
        super(EQ, segment, cls, i);
        this.VH = new LockableObject();
        this.DW = CachedClass.DW;
        this.FH = CachedClass.DW;
        this.j6 = i;
        this.v5 = new LazyCachedClassRef(EQ, this);
        this.Zo = new LazyClassLoaderRef(EQ, this);
    }

    public CachedClass j6() {
        return (CachedClass) this.v5.FH();
    }

    public static ClassInfo j6(Class cls) {
        LocalMap Ws = Ws();
        if (Ws != null) {
            return Ws.j6(cls);
        }
        return (ClassInfo) J0.j6(cls, null);
    }

    private static LocalMap Ws() {
        SoftReference DW;
        ThreadLocalMapHandler threadLocalMapHandler = (ThreadLocalMapHandler) J8.get();
        if (threadLocalMapHandler != null) {
            DW = threadLocalMapHandler.DW();
        } else {
            DW = null;
        }
        if (DW != null) {
            return (LocalMap) DW.get();
        }
        return null;
    }

    public MetaClass DW() {
        return this.u7;
    }

    public void j6(MetaClass metaClass) {
        this.gn++;
        MetaClass metaClass2 = this.u7;
        if (metaClass2 instanceof ExpandoMetaClass) {
            ((ExpandoMetaClass) metaClass2).inRegistry = false;
            Hw.remove(this);
        }
        this.u7 = metaClass;
        if (metaClass instanceof ExpandoMetaClass) {
            ((ExpandoMetaClass) metaClass).inRegistry = true;
            Hw.add(this);
        }
        j6(null);
    }

    public MetaClass FH() {
        ManagedReference managedReference = this.tp;
        return managedReference == null ? null : (MetaClass) managedReference.J0();
    }

    public void DW(MetaClass metaClass) {
        ManagedReference managedReference = null;
        this.gn++;
        this.u7 = null;
        if (metaClass != null) {
            managedReference = new ManagedReference(EQ, metaClass);
        }
        j6(managedReference);
    }

    private void j6(ManagedReference<MetaClass> managedReference) {
        ManagedReference managedReference2 = this.tp;
        if (managedReference2 != null) {
            managedReference2.J8();
        }
        this.tp = managedReference;
    }

    public MetaClass Hw() {
        MetaClass metaClass = this.u7;
        if (metaClass != null) {
            return metaClass;
        }
        metaClass = FH();
        return !FH(metaClass) ? null : metaClass;
    }

    private MetaClass QX() {
        MetaClass DW = DW();
        if (DW == null) {
            DW = FH();
            MetaClassRegistry metaClassRegistry = GroovySystem.getMetaClassRegistry();
            MetaClassCreationHandle metaClassCreationHandler = metaClassRegistry.getMetaClassCreationHandler();
            if (!j6(DW, metaClassCreationHandler)) {
                DW = metaClassCreationHandler.create((Class) J0(), metaClassRegistry);
                DW.initialize();
                if (GroovySystem.isKeepJavaMetaClasses()) {
                    j6(DW);
                } else {
                    DW(DW);
                }
            }
        }
        return DW;
    }

    private boolean FH(MetaClass metaClass) {
        return j6(metaClass, GroovySystem.getMetaClassRegistry().getMetaClassCreationHandler());
    }

    private boolean j6(MetaClass metaClass, MetaClassCreationHandle metaClassCreationHandle) {
        if (metaClass == null) {
            return false;
        }
        boolean z = metaClass instanceof ExpandoMetaClass;
        if (!(metaClassCreationHandle instanceof ExpandoMetaClassCreationHandle) || z) {
            return true;
        }
        return false;
    }

    public final MetaClass v5() {
        MetaClass Hw = Hw();
        if (Hw == null) {
            Zo();
            try {
                Hw = QX();
            } finally {
                VH();
            }
        }
        return Hw;
    }

    private static CachedClass DW(Class cls, ClassInfo classInfo) {
        boolean z = true;
        if (cls == Object.class) {
            return new ObjectCachedClass(classInfo);
        }
        if (cls == String.class) {
            return new StringCachedClass(classInfo);
        }
        if (Number.class.isAssignableFrom(cls) || cls.isPrimitive()) {
            if (cls == Number.class) {
                return new NumberCachedClass(cls, classInfo);
            }
            if (cls == Integer.class || cls == Integer.TYPE) {
                if (cls != Integer.class) {
                    z = false;
                }
                return new IntegerCachedClass(cls, classInfo, z);
            } else if (cls == Double.class || cls == Double.TYPE) {
                if (cls != Double.class) {
                    z = false;
                }
                return new DoubleCachedClass(cls, classInfo, z);
            } else if (cls == BigDecimal.class) {
                return new BigDecimalCachedClass(cls, classInfo);
            } else {
                if (cls == Long.class || cls == Long.TYPE) {
                    if (cls != Long.class) {
                        z = false;
                    }
                    return new LongCachedClass(cls, classInfo, z);
                } else if (cls == Float.class || cls == Float.TYPE) {
                    if (cls != Float.class) {
                        z = false;
                    }
                    return new FloatCachedClass(cls, classInfo, z);
                } else if (cls == Short.class || cls == Short.TYPE) {
                    if (cls != Short.class) {
                        z = false;
                    }
                    return new ShortCachedClass(cls, classInfo, z);
                } else if (cls == Boolean.TYPE) {
                    return new BooleanCachedClass(cls, classInfo, false);
                } else {
                    if (cls == Character.TYPE) {
                        return new CharacterCachedClass(cls, classInfo, false);
                    }
                    if (cls == BigInteger.class) {
                        return new BigIntegerCachedClass(cls, classInfo);
                    }
                    if (cls != Byte.class && cls != Byte.TYPE) {
                        return new CachedClass(cls, classInfo);
                    }
                    if (cls != Byte.class) {
                        z = false;
                    }
                    return new ByteCachedClass(cls, classInfo, z);
                }
            }
        } else if (cls.getName().charAt(0) == '[') {
            return new ArrayCachedClass(cls, classInfo);
        } else {
            if (cls == Boolean.class) {
                return new BooleanCachedClass(cls, classInfo, true);
            }
            if (cls == Character.class) {
                return new CharacterCachedClass(cls, classInfo, true);
            }
            if (Closure.class.isAssignableFrom(cls)) {
                return new CachedClosureClass(cls, classInfo);
            }
            if (DW(cls)) {
                return new CachedSAMClass(cls, classInfo);
            }
            return new CachedClass(cls, classInfo);
        }
    }

    private static boolean DW(Class<?> cls) {
        return CachedSAMClass.j6((Class) cls) != null;
    }

    public void Zo() {
        this.VH.Hw();
    }

    public void VH() {
        this.VH.v5();
    }
}
