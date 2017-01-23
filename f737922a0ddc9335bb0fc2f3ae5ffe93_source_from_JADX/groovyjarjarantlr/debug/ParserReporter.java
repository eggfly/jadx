package groovyjarjarantlr.debug;

public class ParserReporter extends Tracer implements ParserListener {
    public void j6(ParserTokenEvent parserTokenEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserTokenEvent).toString());
    }

    public void DW(ParserTokenEvent parserTokenEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserTokenEvent).toString());
    }

    public void j6(ParserMatchEvent parserMatchEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserMatchEvent).toString());
    }

    public void DW(ParserMatchEvent parserMatchEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserMatchEvent).toString());
    }

    public void FH(ParserMatchEvent parserMatchEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserMatchEvent).toString());
    }

    public void Hw(ParserMatchEvent parserMatchEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(parserMatchEvent).toString());
    }

    public void j6(MessageEvent messageEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(messageEvent).toString());
    }

    public void DW(MessageEvent messageEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(messageEvent).toString());
    }

    public void j6(SemanticPredicateEvent semanticPredicateEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(semanticPredicateEvent).toString());
    }

    public void j6(SyntacticPredicateEvent syntacticPredicateEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(syntacticPredicateEvent).toString());
    }

    public void DW(SyntacticPredicateEvent syntacticPredicateEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(syntacticPredicateEvent).toString());
    }

    public void FH(SyntacticPredicateEvent syntacticPredicateEvent) {
        System.out.println(new StringBuffer().append(this.j6).append(syntacticPredicateEvent).toString());
    }
}
