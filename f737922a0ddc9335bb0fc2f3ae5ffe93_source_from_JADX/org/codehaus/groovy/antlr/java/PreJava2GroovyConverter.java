package org.codehaus.groovy.antlr.java;

import java.util.Stack;
import org.codehaus.groovy.antlr.GroovySourceAST;
import org.codehaus.groovy.antlr.treewalker.VisitorAdapter;

public class PreJava2GroovyConverter extends VisitorAdapter {
    private Stack j6;

    public void DW(GroovySourceAST groovySourceAST, int i) {
        if (i != 1) {
            return;
        }
        if (groovySourceAST.Hw() == 114) {
            FH(groovySourceAST);
        } else if (groovySourceAST.Hw() == 28) {
            Hw(groovySourceAST);
        }
    }

    private void FH(GroovySourceAST groovySourceAST) {
        j6(groovySourceAST);
    }

    private void Hw(GroovySourceAST groovySourceAST) {
        if (this.j6.size() > 2) {
            GroovySourceAST Hw = Hw();
            if (Hw.Hw() == 27) {
                Hw.j6(28);
                Hw.FH(groovySourceAST);
                groovySourceAST.j6(33);
            }
        }
    }

    public void j6(GroovySourceAST groovySourceAST) {
        GroovySourceAST groovySourceAST2 = (GroovySourceAST) groovySourceAST.j6();
        GroovySourceAST groovySourceAST3 = (GroovySourceAST) groovySourceAST2.DW();
        groovySourceAST.FH(groovySourceAST3);
        groovySourceAST2.Hw(null);
        groovySourceAST3.Hw(groovySourceAST2);
    }

    public void DW(GroovySourceAST groovySourceAST) {
        this.j6.push(groovySourceAST);
    }

    public GroovySourceAST j6() {
        if (this.j6.empty()) {
            return null;
        }
        return (GroovySourceAST) this.j6.pop();
    }

    private GroovySourceAST Hw() {
        Object pop = this.j6.pop();
        Object pop2 = this.j6.pop();
        Object peek = this.j6.peek();
        this.j6.push(pop2);
        this.j6.push(pop);
        return (GroovySourceAST) peek;
    }
}
