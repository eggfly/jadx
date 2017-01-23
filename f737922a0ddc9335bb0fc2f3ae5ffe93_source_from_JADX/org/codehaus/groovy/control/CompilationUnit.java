package org.codehaus.groovy.control;

import groovy.lang.GroovyClassLoader;
import groovy.transform.CompilationUnitAware;
import groovyjarjarasm.asm.ClassWriter;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.codehaus.groovy.ast.CompileUnit;
import org.codehaus.groovy.classgen.Verifier;
import org.codehaus.groovy.tools.GroovyClass;
import org.codehaus.groovy.transform.ASTTransformationVisitor;

public class CompilationUnit extends ProcessingUnit {
    private SourceUnitOperation BT;
    protected Map<String, SourceUnit> DW;
    protected boolean EQ;
    protected Map FH;
    protected Map Hw;
    protected ClassgenCallback J0;
    protected ResolveVisitor J8;
    private SourceUnitOperation P8;
    protected OptimizerVisitor QX;
    protected LinkedList<SourceUnit> VH;
    protected StaticImportVisitor Ws;
    protected ClassNodeResolver XL;
    protected List<String> Zo;
    LinkedList[] aM;
    private PrimaryClassNodeOperation er;
    private GroovyClassOperation gW;
    protected CompileUnit gn;
    LinkedList[] j3;
    protected ASTTransformationsContext j6;
    private final SourceUnitOperation rN;
    protected Verifier tp;
    protected List<GroovyClass> u7;
    protected Map v5;
    private PrimaryClassNodeOperation vy;
    protected boolean we;
    private SourceUnitOperation yS;

    class 10 implements Iterator<SourceUnit> {
        final /* synthetic */ CompilationUnit DW;
        Iterator<String> j6;

        public /* synthetic */ Object next() {
            return j6();
        }

        public boolean hasNext() {
            return this.j6.hasNext();
        }

        public SourceUnit j6() {
            return (SourceUnit) this.DW.DW.get((String) this.j6.next());
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static abstract class SourceUnitOperation {
    }

    class 11 extends SourceUnitOperation {
        final /* synthetic */ CompilationUnit j6;

        11(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    public static abstract class PrimaryClassNodeOperation {
    }

    class 12 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        12(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 13 extends SourceUnitOperation {
        final /* synthetic */ CompilationUnit j6;

        13(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    public static abstract class GroovyClassOperation {
    }

    class 14 extends GroovyClassOperation {
        final /* synthetic */ CompilationUnit j6;

        14(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 15 extends SourceUnitOperation {
        final /* synthetic */ CompilationUnit j6;

        15(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 16 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        16(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 17 extends ClassWriter {
    }

    class 18 extends SourceUnitOperation {
        final /* synthetic */ CompilationUnit j6;

        18(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 1 extends SourceUnitOperation {
        final /* synthetic */ CompilationUnit j6;

        1(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 2 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        2(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 3 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        3(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 4 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        4(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 5 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        5(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 6 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        6(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 7 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        7(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 8 extends PrimaryClassNodeOperation {
        final /* synthetic */ CompilationUnit j6;

        8(CompilationUnit compilationUnit) {
            this.j6 = compilationUnit;
        }
    }

    class 9 extends PrimaryClassNodeOperation {
    }

    public static abstract class ClassgenCallback {
    }

    public static abstract class ProgressCallback {
    }

    public CompilationUnit() {
        this(null, null, null);
    }

    public CompilationUnit(CompilerConfiguration compilerConfiguration, CodeSource codeSource, GroovyClassLoader groovyClassLoader) {
        this(compilerConfiguration, codeSource, groovyClassLoader, null);
    }

    public CompilationUnit(CompilerConfiguration compilerConfiguration, CodeSource codeSource, GroovyClassLoader groovyClassLoader, GroovyClassLoader groovyClassLoader2) {
        super(compilerConfiguration, groovyClassLoader, null);
        this.rN = new 11(this);
        this.er = new 12(this);
        this.yS = new 13(this);
        this.gW = new 14(this);
        this.BT = new 15(this);
        this.vy = new 16(this);
        this.P8 = new 18(this);
        this.j6 = new ASTTransformationsContext(this, groovyClassLoader2);
        this.Zo = new ArrayList();
        this.VH = new LinkedList();
        this.DW = new HashMap();
        this.FH = new HashMap();
        this.Hw = new HashMap();
        this.v5 = new HashMap();
        this.gn = new CompileUnit(this.a8, codeSource, this.U2);
        this.u7 = new ArrayList();
        this.tp = new Verifier();
        this.J8 = new ResolveVisitor(this);
        this.Ws = new StaticImportVisitor();
        this.QX = new OptimizerVisitor(this);
        this.aM = new LinkedList[10];
        this.j3 = new LinkedList[10];
        for (int i = 0; i < this.aM.length; i++) {
            this.aM[i] = new LinkedList();
            this.j3[i] = new LinkedList();
        }
        j6(new 1(this), 2);
        j6(this.yS, 3);
        j6(new 2(this), 3);
        j6(this.rN, 4);
        j6(this.er, 4);
        j6(new 3(this), 4);
        j6(new 4(this), 5);
        j6(this.BT, 5);
        j6(this.vy, 7);
        j6(this.gW);
        j6(new 5(this), 4);
        ASTTransformationVisitor.addPhaseOperations(this);
        j6(new 6(this), 4);
        j6(new 7(this), 5);
        j6(new 8(this), 5);
        if (compilerConfiguration != null) {
            for (PrimaryClassNodeOperation primaryClassNodeOperation : compilerConfiguration.Hw()) {
                if (primaryClassNodeOperation instanceof CompilationUnitAware) {
                    ((CompilationUnitAware) primaryClassNodeOperation).setCompilationUnit(this);
                }
                j6(primaryClassNodeOperation, primaryClassNodeOperation.DW().j6());
            }
        }
        this.J0 = null;
        this.XL = new ClassNodeResolver();
    }

    public void j6(SourceUnitOperation sourceUnitOperation, int i) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("phase " + i + " is unknown");
        }
        this.aM[i].add(sourceUnitOperation);
    }

    public void j6(PrimaryClassNodeOperation primaryClassNodeOperation, int i) {
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("phase " + i + " is unknown");
        }
        this.aM[i].add(primaryClassNodeOperation);
    }

    public void j6(GroovyClassOperation groovyClassOperation) {
        this.aM[8].addFirst(groovyClassOperation);
    }

    public void j6(CompilerConfiguration compilerConfiguration) {
        super.j6(compilerConfiguration);
        this.EQ = compilerConfiguration.DW();
        if (!this.we && (this.a8 instanceof GroovyClassLoader)) {
            j6(compilerConfiguration, this.a8);
        }
        this.we = true;
    }

    private void j6(CompilerConfiguration compilerConfiguration, GroovyClassLoader groovyClassLoader) {
    }
}
