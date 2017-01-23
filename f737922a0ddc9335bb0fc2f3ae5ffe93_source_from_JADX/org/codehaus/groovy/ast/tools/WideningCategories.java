package org.codehaus.groovy.ast.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.ast.ClassHelper;
import org.codehaus.groovy.ast.ClassNode;
import org.codehaus.groovy.ast.GenericsType;
import org.codehaus.groovy.ast.MethodNode;

public class WideningCategories {
    private static final Map<ClassNode, Integer> DW;
    private static final Comparator<ClassNode> FH;
    private static final List<ClassNode> j6;

    static class 1 extends HashMap<ClassNode, Integer> {
        1() {
            put(ClassHelper.j3, Integer.valueOf(0));
            put(ClassHelper.Mr, Integer.valueOf(1));
            put(ClassHelper.XL, Integer.valueOf(2));
            put(ClassHelper.QX, Integer.valueOf(3));
            put(ClassHelper.aM, Integer.valueOf(4));
            put(ClassHelper.Ws, Integer.valueOf(5));
        }
    }

    static class 2 implements Comparator<ClassNode> {
        2() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return j6((ClassNode) obj, (ClassNode) obj2);
        }

        public int j6(ClassNode classNode, ClassNode classNode2) {
            int length = classNode.gn().length;
            int length2 = classNode2.gn().length;
            if (length > length2) {
                return -1;
            }
            if (length < length2) {
                return 1;
            }
            length = classNode.u7().size();
            length2 = classNode2.u7().size();
            if (length > length2) {
                return -1;
            }
            if (length < length2) {
                return 1;
            }
            return classNode.tp().compareTo(classNode2.tp());
        }
    }

    public static class LowestUpperBoundClassNode extends ClassNode {
        private static final Comparator<ClassNode> gn;
        private final String EQ;
        private final ClassNode[] J0;
        private final String tp;
        private final ClassNode u7;
        private final ClassNode we;

        static class 1 implements Comparator<ClassNode> {
            1() {
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return j6((ClassNode) obj, (ClassNode) obj2);
            }

            public int j6(ClassNode classNode, ClassNode classNode2) {
                return (classNode instanceof LowestUpperBoundClassNode ? ((LowestUpperBoundClassNode) classNode).tp : classNode.tp()).compareTo(classNode2 instanceof LowestUpperBoundClassNode ? ((LowestUpperBoundClassNode) classNode2).tp : classNode2.tp());
            }
        }

        static {
            gn = new 1();
        }

        public LowestUpperBoundClassNode(String str, ClassNode classNode, ClassNode... classNodeArr) {
            super(str, 17, classNode, classNodeArr, null);
            this.we = classNode;
            this.J0 = classNodeArr;
            Arrays.sort(classNodeArr, gn);
            ClassNode classNode2 = (!classNode.equals(ClassHelper.DW) || classNodeArr.length <= 0) ? classNode : classNodeArr[0];
            this.u7 = classNode2;
            this.tp = str;
            boolean er = classNode.er();
            List<GenericsType[]> linkedList = new LinkedList();
            linkedList.add(classNode.lg());
            int length = classNodeArr.length;
            int i = 0;
            boolean z = er;
            while (i < length) {
                ClassNode classNode3 = classNodeArr[i];
                boolean er2 = z | classNode3.er();
                linkedList.add(classNode3.lg());
                for (MethodNode methodNode : classNode3.u7()) {
                    j6(methodNode.u7(), methodNode.gn(), methodNode.EQ(), methodNode.tp(), methodNode.J0(), methodNode.VH()).j6(classNode3);
                }
                i++;
                z = er2;
            }
            Hw(z);
            if (z) {
                List arrayList = new ArrayList();
                for (GenericsType[] genericsTypeArr : linkedList) {
                    if (genericsTypeArr != null) {
                        Collections.addAll(arrayList, genericsTypeArr);
                    }
                }
                j6((GenericsType[]) arrayList.toArray(new GenericsType[arrayList.size()]));
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (!classNode.equals(ClassHelper.DW)) {
                stringBuilder.append(classNode.tp());
            }
            for (ClassNode classNode4 : classNodeArr) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(" or ");
                }
                stringBuilder.append(classNode4.tp());
            }
            this.EQ = stringBuilder.toString();
        }

        public String tp() {
            return this.u7.tp();
        }

        public Class a8() {
            return this.u7.a8();
        }

        public int hashCode() {
            return (this.tp != null ? this.tp.hashCode() : 0) + (super.hashCode() * 31);
        }

        public String j6() {
            return this.EQ;
        }

        public ClassNode yS() {
            ClassNode[] classNodeArr = this.J0 == null ? null : new ClassNode[this.J0.length];
            if (classNodeArr != null) {
                for (int i = 0; i < this.J0.length; i++) {
                    classNodeArr[i] = this.J0[i].yS();
                }
            }
            return new LowestUpperBoundClassNode(this.tp, this.we.yS(), classNodeArr);
        }
    }

    static {
        j6 = Collections.emptyList();
        DW = Collections.unmodifiableMap(new 1());
        FH = new 2();
    }
}
