package org.codehaus.groovy.reflection;

import groovy.lang.ExpandoMetaClass;
import org.codehaus.groovy.runtime.metaclass.NewInstanceMetaMethod;
import org.codehaus.groovy.util.ManagedConcurrentMap;
import org.codehaus.groovy.util.ReferenceBundle;

public class MixinInMetaClass extends ManagedConcurrentMap {
    private static ReferenceBundle gn;
    final CachedClass DW;
    final CachedConstructor FH;
    final ExpandoMetaClass j6;

    static class 1 extends NewInstanceMetaMethod {
    }

    static {
        gn = ReferenceBundle.FH();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MixinInMetaClass)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        MixinInMetaClass mixinInMetaClass = (MixinInMetaClass) obj;
        if (this.DW != null) {
            if (this.DW.equals(mixinInMetaClass.DW)) {
                return true;
            }
        } else if (mixinInMetaClass.DW == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = super.hashCode() * 31;
        if (this.j6 != null) {
            hashCode = this.j6.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.DW != null) {
            hashCode = this.DW.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (this.FH != null) {
            i = this.FH.hashCode();
        }
        return hashCode + i;
    }
}
