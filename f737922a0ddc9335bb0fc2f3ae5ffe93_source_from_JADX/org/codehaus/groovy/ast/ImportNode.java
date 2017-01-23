package org.codehaus.groovy.ast;

import groovyjarjarasm.asm.Opcodes;

public class ImportNode extends AnnotatedNode implements Opcodes {
    private final ClassNode DW;
    private final String FH;
    private final String Hw;
    private final boolean VH;
    private final boolean Zo;
    private final String v5;

    public String j6() {
        String Zo = Zo();
        if (this.Zo && !this.VH) {
            return "import " + this.v5 + "*";
        }
        if (this.Zo) {
            return "import static " + Zo + ".*";
        }
        if (this.VH) {
            if (this.FH == null || this.FH.length() == 0 || this.FH.equals(this.Hw)) {
                return "import static " + Zo + "." + this.Hw;
            }
            return "import static " + Zo + "." + this.Hw + " as " + this.FH;
        } else if (this.FH == null || this.FH.length() == 0) {
            return "import " + Zo;
        } else {
            return "import " + Zo + " as " + this.FH;
        }
    }

    public String Zo() {
        return this.DW == null ? null : this.DW.tp();
    }
}
