package org.codehaus.groovy.control;

import java.util.LinkedList;
import org.codehaus.groovy.control.messages.Message;

public class ErrorCollector {
    protected LinkedList DW;
    protected CompilerConfiguration FH;
    protected LinkedList j6;

    public ErrorCollector(CompilerConfiguration compilerConfiguration) {
        this.j6 = null;
        this.DW = null;
        this.FH = compilerConfiguration;
    }

    public void j6(Message message) {
        if (this.DW == null) {
            this.DW = new LinkedList();
        }
        this.DW.add(message);
    }
}
