package org.codehaus.groovy.ast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VariableScope {
    private Map<String, Variable> DW;
    private Map<String, Variable> FH;
    private boolean Hw;
    private Map<String, Variable> j6;
    private boolean v5;

    public VariableScope() {
        this.j6 = Collections.emptyMap();
        this.DW = Collections.emptyMap();
        this.FH = Collections.emptyMap();
        this.Hw = false;
        this.v5 = false;
    }

    public void j6(boolean z) {
        this.Hw = z;
    }

    public void j6(Variable variable) {
        if (this.j6 == Collections.EMPTY_MAP) {
            this.j6 = new HashMap();
        }
        this.j6.put(variable.t_(), variable);
    }
}
