package it.gmariotti.cardslib.library.internal.multichoice;

public abstract class OptionMultiChoice {
    protected boolean selectItemClickInActionMode;

    public OptionMultiChoice() {
        this.selectItemClickInActionMode = true;
    }

    public boolean isSelectItemClickInActionMode() {
        return this.selectItemClickInActionMode;
    }
}
