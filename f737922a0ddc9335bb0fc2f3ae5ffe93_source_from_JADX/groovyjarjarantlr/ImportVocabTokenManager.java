package groovyjarjarantlr;

class ImportVocabTokenManager extends SimpleTokenManager implements Cloneable {
    private String Zo;
    protected Grammar j6;

    public Object clone() {
        ImportVocabTokenManager importVocabTokenManager = (ImportVocabTokenManager) super.clone();
        importVocabTokenManager.Zo = this.Zo;
        importVocabTokenManager.j6 = this.j6;
        return importVocabTokenManager;
    }
}
