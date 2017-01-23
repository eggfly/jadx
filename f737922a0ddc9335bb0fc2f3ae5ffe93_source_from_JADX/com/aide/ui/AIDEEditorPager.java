package com.aide.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.aide.common.d;
import com.aide.engine.SyntaxError;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import pl$a;
import pl$b;
import qg;
import qi;

public class AIDEEditorPager extends ViewPager implements pl$b {
    private boolean DW;
    private b FH;
    private boolean Hw;
    private g Zo;
    private List<View> j6;
    private g v5;

    class 1 implements Runnable {
        final /* synthetic */ AIDEEditorPager DW;
        final /* synthetic */ int j6;

        1(AIDEEditorPager aIDEEditorPager, int i) {
            this.DW = aIDEEditorPager;
            this.j6 = i;
        }

        public void run() {
            this.DW.setCurrentItem(this.j6);
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ AIDEEditorPager j6;

        2(AIDEEditorPager aIDEEditorPager) {
            this.j6 = aIDEEditorPager;
        }

        public void run() {
            this.j6.getActivity().u7();
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ AIDEEditorPager j6;

        3(AIDEEditorPager aIDEEditorPager) {
            this.j6 = aIDEEditorPager;
        }

        public void run() {
            this.j6.FH.DW(this.j6.Hw);
            if (this.j6.getCurrentEditor() != null) {
                this.j6.getCurrentEditor().j6(this.j6.Hw);
            }
        }
    }

    private class a extends v {
        private int DW;
        final /* synthetic */ AIDEEditorPager j6;

        private a(AIDEEditorPager aIDEEditorPager) {
            this.j6 = aIDEEditorPager;
            this.DW = -1;
        }

        public void j6(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int DW() {
            return this.j6.j6.size();
        }

        public int j6(Object obj) {
            return -2;
        }

        public boolean j6(View view, Object obj) {
            return view.equals(obj);
        }

        public void DW(ViewGroup viewGroup) {
        }

        public void j6(Parcelable parcelable, ClassLoader classLoader) {
        }

        public Parcelable j6() {
            return null;
        }

        public void j6(ViewGroup viewGroup) {
        }

        public void DW(ViewGroup viewGroup, int i, Object obj) {
            super.DW(viewGroup, i, obj);
            if (this.DW != i) {
                this.DW = i;
                this.j6.getActivity().DW(i);
                this.j6.gn();
                this.j6.ei();
            }
        }

        public Object j6(ViewGroup viewGroup, int i) {
            View view = (View) this.j6.j6.get(i);
            viewGroup.addView(view, 0);
            return view;
        }
    }

    public interface b {
        void DW(boolean z);

        void j6(boolean z);
    }

    public AIDEEditorPager(Context context) {
        super(context);
        this.j6 = new ArrayList();
        P8();
    }

    public AIDEEditorPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j6 = new ArrayList();
        P8();
    }

    private void P8() {
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mTouchSlop");
            declaredField.setAccessible(true);
            declaredField.setInt(this, 10);
        } catch (Exception e) {
        }
        e.j3().j6((pl$b) this);
        setAdapter(new a());
        setVisible(false);
        setPageMargin(1);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.a.color_page_separator});
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        setPageMarginDrawable(new ColorDrawable(color));
        this.v5 = new g(e.u7(), R.d.editor_context_menu);
        this.Zo = new g(e.u7(), R.d.editor_small_context_menu);
    }

    public void j6(Rect rect) {
        this.v5.j6(e.u7().j6(rect), false);
    }

    public void DW(Rect rect) {
        this.Zo.j6(e.u7().j6(rect), false);
    }

    public void VH() {
        this.v5.j6();
    }

    public void gn() {
        this.v5.DW();
    }

    public void u7() {
        this.v5.j6(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (d.j6(motionEvent)) {
            return false;
        }
        if (motionEvent.getAction() == 0 && getCurrentEditor() != null && getCurrentEditor().j6(motionEvent)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private MainActivity getActivity() {
        return (MainActivity) getContext();
    }

    private void setVisible(boolean z) {
        int i = 4;
        View rootView = getRootView();
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.b.mainCodePageView);
            if (findViewById != null) {
                findViewById.setVisibility(z ? 0 : 4);
            }
            View findViewById2 = rootView.findViewById(R.b.mainCodeEmptyView);
            if (findViewById2 != null) {
                if (!z) {
                    i = 0;
                }
                findViewById2.setVisibility(i);
            }
        }
    }

    public List<AIDEEditor> getFileEditors() {
        List<AIDEEditor> arrayList = new ArrayList();
        for (int i = 0; i < this.j6.size(); i++) {
            arrayList.add(v5(i));
        }
        return arrayList;
    }

    private AIDEEditor getCurrentEditor() {
        int currentItem = getCurrentItem();
        if (currentItem < 0) {
            return null;
        }
        return v5(currentItem);
    }

    public void j6(String str) {
        int v5 = v5(str);
        if (v5 >= 0) {
            v5(v5).b_();
            this.j6.remove(v5);
            getAdapter().FH();
            if (this.j6.size() == 0) {
                setVisible(false);
            }
            getActivity().j6(v5);
            ei();
        }
    }

    public pl$a DW(String str) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.c.editor, null);
        AIDEEditor aIDEEditor = (AIDEEditor) inflate.findViewById(R.b.editorCodeEditor);
        aIDEEditor.setIdentifierClickingEnabled(this.DW);
        pl$a j6 = aIDEEditor.j6(str);
        setVisible(true);
        getActivity().j6(str);
        ei();
        this.j6.add(inflate);
        getAdapter().FH();
        e.sG().j6((ViewGroup) inflate.findViewById(R.b.editorAdView));
        return j6;
    }

    public void FH(String str) {
        int v5 = v5(str);
        setCurrentItem(v5);
        postDelayed(new 1(this, v5), 10);
        j3();
        getActivity().DW(v5);
    }

    public String getVisibleFile() {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().getFilePath();
        }
        return null;
    }

    private void ei() {
        postDelayed(new 2(this), 50);
    }

    private List<AIDEEditor> getEditors() {
        List<AIDEEditor> arrayList = new ArrayList();
        for (int i = 0; i < this.j6.size(); i++) {
            arrayList.add(v5(i));
        }
        return arrayList;
    }

    private AIDEEditor v5(int i) {
        if (i < 0 || i >= this.j6.size()) {
            return null;
        }
        return (AIDEEditor) ((View) this.j6.get(i)).findViewById(R.b.editorCodeEditor);
    }

    private int v5(String str) {
        for (int i = 0; i < this.j6.size(); i++) {
            if (v5(i).getFilePath().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float VH = d.VH(getContext());
        if (VH > 0.0f) {
            boolean z = d.gn(getContext()) - VH > 100.0f;
            if (this.Hw != z) {
                this.Hw = z;
                if (this.FH != null) {
                    this.FH.j6(z);
                    postDelayed(new 3(this), 100);
                }
            }
        }
    }

    public void tp() {
        for (AIDEEditor b_ : getEditors()) {
            b_.b_();
        }
    }

    public void EQ() {
        for (AIDEEditor j6 : getEditors()) {
            j6.j6();
        }
    }

    public void we() {
        for (AIDEEditor DW : getEditors()) {
            DW.DW();
        }
    }

    public String getQuickKeys() {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().getQuickKeys();
        }
        return null;
    }

    public void j6(String str, String str2, String... strArr) {
        for (AIDEEditor aIDEEditor : getFileEditors()) {
            if (aIDEEditor.getFilePath().equals(str)) {
                aIDEEditor.j6(str2, strArr);
            }
        }
    }

    public boolean Hw(String str) {
        if (!isInTouchMode()) {
            return false;
        }
        for (AIDEEditor aIDEEditor : getFileEditors()) {
            if (aIDEEditor.getFilePath().equals(str)) {
                return aIDEEditor.u7();
            }
        }
        return false;
    }

    public void j6(String str, String str2, int i, boolean z, String str3, String str4, boolean z2, String str5, String str6, int i2, boolean z3) {
        QX();
        e.j3().v5(str);
        for (AIDEEditor aIDEEditor : getFileEditors()) {
            if (str == null || aIDEEditor.getFilePath().equals(str)) {
                aIDEEditor.j6(str2, i, z, str3, str4, z2, str5, str6, i2, z3);
            } else {
                aIDEEditor.j6(str2, i, z, null, null, false, null, null, -1, false);
            }
        }
    }

    public qg getCurrentFileSpan() {
        AIDEEditor currentEditor = getCurrentEditor();
        if (currentEditor == null) {
            return new qg(null, 0, 0, 0, 0);
        }
        return new qg(currentEditor.getFilePath(), currentEditor.getSelectionStartLine(), currentEditor.getSelectionStartColumn(), currentEditor.getSelectionEndLine(), currentEditor.getSelectionEndColumn());
    }

    public void J0() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().nw();
        }
    }

    public boolean J8() {
        return getCurrentEditor() != null && getCurrentEditor().SI();
    }

    public void setSoftKeyboardListener(b bVar) {
        this.FH = bVar;
    }

    public boolean Ws() {
        return this.Hw;
    }

    public void QX() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().XL();
        }
    }

    public void XL() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().j3();
        }
    }

    public void setIdentifierClickingEnabled(boolean z) {
        this.DW = z;
        for (AIDEEditor identifierClickingEnabled : getEditors()) {
            identifierClickingEnabled.setIdentifierClickingEnabled(z);
        }
    }

    public void j6(int i, int i2, int i3, int i4) {
        AIDEEditor currentEditor = getCurrentEditor();
        if (currentEditor != null) {
            currentEditor.j6(i, i2, i3, i4);
            if (i == i3 && i2 == i4) {
                currentEditor.lg();
            }
        }
    }

    public void aM() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().gn();
        }
    }

    public String getSelectionContent() {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().getSelectionContent();
        }
        return "";
    }

    public void j3() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().tp();
        }
    }

    public void Mr() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().yS();
        }
    }

    public void U2() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().er();
        }
    }

    public void Hw(int i) {
        if (getCurrentEditor() != null) {
            getCurrentEditor().DW(i);
        }
    }

    public void a8() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().KD();
        }
    }

    public List<qi> getBasicEditorCommands() {
        return new AIDEEditor(getContext()).getBasicEditorCommands();
    }

    public boolean j6(int i, int i2, String str) {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().j6(i, i2, str);
        }
        return false;
    }

    public int getCurrentFileLineCount() {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().getLineCount();
        }
        return 0;
    }

    public int getTabSize() {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().getTabSize();
        }
        return 4;
    }

    public void lg() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().P8();
        }
    }

    public boolean rN() {
        return getCurrentEditor() != null && getCurrentEditor().ei();
    }

    public void er() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().J0();
        }
    }

    public void yS() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().J8();
        }
    }

    public void gW() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().gW();
        }
    }

    public void BT() {
        if (getCurrentEditor() != null) {
            getCurrentEditor().U2();
        }
    }

    public SyntaxError DW(int i, int i2) {
        if (getCurrentEditor() != null) {
            return getCurrentEditor().v5(i, i2);
        }
        return null;
    }

    public void j6(int i, int i2, int i3, int i4, String str) {
        if (getCurrentEditor() != null) {
            getCurrentEditor().j6(i, i2, i3, i4, str);
        }
    }

    public boolean vy() {
        if (getCurrentEditor() == null || !this.Hw || e.u7().Sf()) {
            return false;
        }
        return true;
    }
}
