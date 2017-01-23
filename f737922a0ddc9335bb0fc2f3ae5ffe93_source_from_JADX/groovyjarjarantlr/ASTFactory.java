package groovyjarjarantlr;

import groovyjarjarantlr.collections.AST;
import groovyjarjarantlr.collections.impl.ASTArray;
import java.util.Hashtable;

public class ASTFactory {
    static Class Hw;
    protected Class DW;
    protected Hashtable FH;
    protected String j6;

    public ASTFactory() {
        this.j6 = null;
        this.DW = null;
        this.FH = null;
    }

    public ASTFactory(Hashtable hashtable) {
        this.j6 = null;
        this.DW = null;
        this.FH = null;
        j6(hashtable);
    }

    public Class j6(int i) {
        Class cls;
        if (this.FH != null) {
            cls = (Class) this.FH.get(new Integer(i));
            if (cls != null) {
                return cls;
            }
        }
        if (this.DW != null) {
            return this.DW;
        }
        if (Hw != null) {
            return Hw;
        }
        cls = DW("groovyjarjarantlr.CommonAST");
        Hw = cls;
        return cls;
    }

    static Class DW(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public void j6(ASTPair aSTPair, AST ast) {
        if (ast != null) {
            if (aSTPair.j6 == null) {
                aSTPair.j6 = ast;
            } else if (aSTPair.DW == null) {
                aSTPair.j6.FH(ast);
            } else {
                aSTPair.DW.Hw(ast);
            }
            aSTPair.DW = ast;
            aSTPair.j6();
        }
    }

    public AST DW(int i) {
        AST j6 = j6(j6(i));
        if (j6 != null) {
            j6.j6(i, "");
        }
        return j6;
    }

    public AST j6(int i, String str) {
        AST DW = DW(i);
        if (DW != null) {
            DW.j6(i, str);
        }
        return DW;
    }

    public AST j6(Token token) {
        AST DW = DW(token.Hw());
        if (DW != null) {
            DW.j6(token);
        }
        return DW;
    }

    protected AST j6(Class cls) {
        try {
            return (AST) cls.newInstance();
        } catch (Exception e) {
            j6(new StringBuffer().append("Can't create AST Node ").append(cls.getName()).toString());
            return null;
        }
    }

    public AST j6(AST ast) {
        if (ast == null) {
            return null;
        }
        AST j6 = j6(ast.getClass());
        j6.DW(ast);
        return j6;
    }

    public AST DW(AST ast) {
        AST FH = FH(ast);
        AST ast2 = FH;
        while (ast != null) {
            ast = ast.DW();
            ast2.Hw(FH(ast));
            ast2 = ast2.DW();
        }
        return FH;
    }

    public AST FH(AST ast) {
        AST j6 = j6(ast);
        if (ast != null) {
            j6.FH(DW(ast.j6()));
        }
        return j6;
    }

    public AST j6(AST[] astArr) {
        AST ast = null;
        if (!(astArr == null || astArr.length == 0)) {
            AST ast2 = astArr[0];
            if (ast2 != null) {
                ast2.FH(null);
            }
            AST ast3 = null;
            ast = ast2;
            for (int i = 1; i < astArr.length; i++) {
                if (astArr[i] != null) {
                    if (ast == null) {
                        ast3 = astArr[i];
                        ast = ast3;
                    } else if (ast3 == null) {
                        ast.FH(astArr[i]);
                        ast3 = ast.j6();
                    } else {
                        ast3.Hw(astArr[i]);
                        ast3 = ast3.DW();
                    }
                    while (ast3.DW() != null) {
                        ast3 = ast3.DW();
                    }
                }
            }
        }
        return ast;
    }

    public AST j6(ASTArray aSTArray) {
        return j6(aSTArray.DW);
    }

    public void DW(ASTPair aSTPair, AST ast) {
        if (ast != null) {
            ast.j6(aSTPair.j6);
            aSTPair.DW = aSTPair.j6;
            aSTPair.j6();
            aSTPair.j6 = ast;
        }
    }

    public void DW(Class cls) {
        if (cls != null) {
            this.DW = cls;
            this.j6 = cls.getName();
        }
    }

    public void j6(Hashtable hashtable) {
        this.FH = hashtable;
    }

    public void j6(String str) {
        System.err.println(str);
    }
}
