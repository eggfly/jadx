package org.codehaus.groovy.antlr;

import com.thoughtworks.xstream.XStream;
import groovyjarjarantlr.collections.AST;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.groovy.antlr.parser.GroovyTokenTypes;
import org.codehaus.groovy.antlr.treewalker.CompositeVisitor;
import org.codehaus.groovy.antlr.treewalker.MindMapPrinter;
import org.codehaus.groovy.antlr.treewalker.NodeAsHTMLPrinter;
import org.codehaus.groovy.antlr.treewalker.PreOrderTraversal;
import org.codehaus.groovy.antlr.treewalker.SourceCodeTraversal;
import org.codehaus.groovy.antlr.treewalker.SourcePrinter;
import org.codehaus.groovy.ast.expr.Expression;
import org.codehaus.groovy.control.ParserPlugin;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.syntax.ASTHelper;

public class AntlrParserPlugin extends ASTHelper implements GroovyTokenTypes, ParserPlugin {
    private String[] FH;
    private int Hw;
    private boolean VH;
    private boolean Zo;
    private boolean gn;
    protected AST j6;
    private boolean v5;

    class 1 implements PrivilegedAction {
        final /* synthetic */ SourceBuffer DW;
        final /* synthetic */ AntlrParserPlugin FH;
        final /* synthetic */ SourceUnit j6;

        public Object run() {
            this.FH.j6(this.j6, this.DW);
            return null;
        }
    }

    private static class AnonymousInnerClassCarrier extends Expression {
        private AnonymousInnerClassCarrier() {
        }
    }

    public AntlrParserPlugin() {
        this.Hw = 1;
        this.v5 = false;
        this.Zo = false;
        this.VH = false;
        this.gn = false;
    }

    private void j6(SourceUnit sourceUnit, SourceBuffer sourceBuffer) {
        String property = System.getProperty("ANTLR.AST".toLowerCase());
        if ("xml".equals(property)) {
            j6(sourceUnit.Hw(), this.j6);
        }
        if ("groovy".equals(property)) {
            try {
                new SourceCodeTraversal(new SourcePrinter(new PrintStream(new FileOutputStream(sourceUnit.Hw() + ".pretty.groovy")), this.FH)).j6(this.j6);
            } catch (FileNotFoundException e) {
                System.out.println("Cannot create " + sourceUnit.Hw() + ".pretty.groovy");
            }
        }
        if ("mindmap".equals(property)) {
            try {
                new PreOrderTraversal(new MindMapPrinter(new PrintStream(new FileOutputStream(sourceUnit.Hw() + ".mm")), this.FH)).j6(this.j6);
            } catch (FileNotFoundException e2) {
                System.out.println("Cannot create " + sourceUnit.Hw() + ".mm");
            }
        }
        if ("extendedMindmap".equals(property)) {
            try {
                new PreOrderTraversal(new MindMapPrinter(new PrintStream(new FileOutputStream(sourceUnit.Hw() + ".mm")), this.FH, sourceBuffer)).j6(this.j6);
            } catch (FileNotFoundException e3) {
                System.out.println("Cannot create " + sourceUnit.Hw() + ".mm");
            }
        }
        if ("html".equals(property)) {
            try {
                PrintStream printStream = new PrintStream(new FileOutputStream(sourceUnit.Hw() + ".html"));
                List arrayList = new ArrayList();
                arrayList.add(new NodeAsHTMLPrinter(printStream, this.FH));
                arrayList.add(new SourcePrinter(printStream, this.FH));
                new SourceCodeTraversal(new CompositeVisitor(arrayList)).j6(this.j6);
            } catch (FileNotFoundException e4) {
                System.out.println("Cannot create " + sourceUnit.Hw() + ".html");
            }
        }
    }

    private void j6(String str, AST ast) {
        try {
            new XStream().toXML(ast, new FileWriter(str + ".antlr.xml"));
            System.out.println("Written AST to " + str + ".antlr.xml");
        } catch (Exception e) {
            System.out.println("Couldn't write to " + str + ".antlr.xml");
            e.printStackTrace();
        }
    }
}
