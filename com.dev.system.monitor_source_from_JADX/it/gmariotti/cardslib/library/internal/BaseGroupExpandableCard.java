package it.gmariotti.cardslib.library.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class BaseGroupExpandableCard<T> extends Card {
    protected List<T> children;

    public BaseGroupExpandableCard(Context context, List<T> children) {
        super(context);
        this.children = new ArrayList();
        this.children = children;
    }

    public BaseGroupExpandableCard(Context context, int innerLayout, List<T> children) {
        super(context, innerLayout);
        this.children = new ArrayList();
        this.children = children;
    }
}
