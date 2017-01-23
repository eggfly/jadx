package org.codehaus.groovy.control.messages;

import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.SyntaxException;

public class SyntaxErrorMessage extends Message {
    protected SourceUnit DW;
    protected SyntaxException j6;

    public SyntaxErrorMessage(SyntaxException syntaxException, SourceUnit sourceUnit) {
        this.j6 = syntaxException;
        this.DW = sourceUnit;
        syntaxException.j6(sourceUnit.Hw());
    }
}
