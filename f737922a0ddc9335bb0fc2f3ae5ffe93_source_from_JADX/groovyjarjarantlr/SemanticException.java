package groovyjarjarantlr;

public class SemanticException extends RecognitionException {
    public SemanticException(String str) {
        super(str);
    }

    public SemanticException(String str, String str2, int i, int i2) {
        super(str, str2, i, i2);
    }
}
