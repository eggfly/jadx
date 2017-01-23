package com.github.amlcurran.showcaseview;

public interface OnShowcaseEventListener {
    public static final OnShowcaseEventListener NONE;

    /* renamed from: com.github.amlcurran.showcaseview.OnShowcaseEventListener.1 */
    static class C02441 implements OnShowcaseEventListener {
        C02441() {
        }

        public void onShowcaseViewHide(ShowcaseView showcaseView) {
        }

        public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
        }

        public void onShowcaseViewShow(ShowcaseView showcaseView) {
        }
    }

    void onShowcaseViewDidHide(ShowcaseView showcaseView);

    void onShowcaseViewHide(ShowcaseView showcaseView);

    void onShowcaseViewShow(ShowcaseView showcaseView);

    static {
        NONE = new C02441();
    }
}
