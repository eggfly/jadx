package it.gmariotti.cardslib.library.prototypes;

public class CardSection {
    int firstPosition;
    int sectionedPosition;
    CharSequence title;

    public CardSection(int firstPosition, CharSequence title) {
        this.firstPosition = firstPosition;
        this.title = title;
    }

    public CharSequence getTitle() {
        return this.title;
    }
}
