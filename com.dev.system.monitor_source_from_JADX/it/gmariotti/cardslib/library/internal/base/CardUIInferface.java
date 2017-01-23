package it.gmariotti.cardslib.library.internal.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public interface CardUIInferface {
    View getInnerView(Context context, ViewGroup viewGroup);

    void setupInnerViewElements(ViewGroup viewGroup, View view);
}
