package org.codehaus.groovy.control.customizers;

import java.util.LinkedList;
import java.util.List;
import org.codehaus.groovy.control.CompilePhase;

public class ImportCustomizer extends CompilationCustomizer {
    private final List<Import> j6;

    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[ImportType.values().length];
            try {
                j6[ImportType.regular.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[ImportType.staticImport.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[ImportType.staticStar.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[ImportType.star.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private static class Import {
    }

    private enum ImportType {
        regular,
        staticImport,
        staticStar,
        star
    }

    public ImportCustomizer() {
        super(CompilePhase.CONVERSION);
        this.j6 = new LinkedList();
    }
}
