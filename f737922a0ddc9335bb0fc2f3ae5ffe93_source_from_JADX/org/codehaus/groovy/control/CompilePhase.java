package org.codehaus.groovy.control;

public enum CompilePhase {
    INITIALIZATION(1),
    PARSING(2),
    CONVERSION(3),
    SEMANTIC_ANALYSIS(4),
    CANONICALIZATION(5),
    INSTRUCTION_SELECTION(6),
    CLASS_GENERATION(7),
    OUTPUT(8),
    FINALIZATION(9);
    
    public static CompilePhase[] tp;
    int EQ;

    static {
        tp = new CompilePhase[]{null, INITIALIZATION, PARSING, CONVERSION, SEMANTIC_ANALYSIS, CANONICALIZATION, INSTRUCTION_SELECTION, CLASS_GENERATION, OUTPUT, FINALIZATION};
    }

    private CompilePhase(int i) {
        this.EQ = i;
    }

    public int j6() {
        return this.EQ;
    }
}
