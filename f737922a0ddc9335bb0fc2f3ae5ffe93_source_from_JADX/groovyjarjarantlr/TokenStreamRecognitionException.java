package groovyjarjarantlr;

public class TokenStreamRecognitionException extends TokenStreamException {
    public RecognitionException j6;

    public TokenStreamRecognitionException(RecognitionException recognitionException) {
        super(recognitionException.getMessage());
        this.j6 = recognitionException;
    }

    public String toString() {
        return this.j6.toString();
    }
}
