package com.aide.uidesigner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.aide.common.i;
import com.aide.common.y;
import com.aide.uidesigner.h.a;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class f extends i {
    private c DW;
    private c FH;
    private l Hw;
    private int Zo;
    private Element j6;
    private f v5;

    public f(Context context, View view, Element element, c cVar, c cVar2, f fVar, int i, l lVar) {
        super(context, view);
        this.j6 = element;
        this.DW = cVar;
        this.FH = cVar2;
        this.Hw = lVar;
        this.v5 = fVar;
        this.Zo = i;
    }

    protected void j6() {
        this.Hw.DW(this);
    }

    public int getSourceLine() {
        return Integer.parseInt((String) this.j6.getUserData("line"));
    }

    public int getSourceColumn() {
        return Integer.parseInt((String) this.j6.getUserData("column"));
    }

    public String getNodeName() {
        return this.j6.getNodeName();
    }

    public List<String> getAllUserDrawables() {
        return this.Hw.J8();
    }

    public String DW() {
        return this.Hw.J0();
    }

    public void j6(String str, Intent intent) {
        this.Hw.j6(str, intent);
    }

    public List<String> getAllUserStyles() {
        return this.Hw.Ws();
    }

    public String getStyle() {
        return this.Hw.FH(this.j6);
    }

    public void setStyle(String str) {
        this.Hw.DW(this.j6, str);
    }

    public List<a> getAttributes() {
        return this.Hw.j6(this.DW, this.FH, this.j6);
    }

    public String getViewID() {
        return this.Hw.j6(this.j6);
    }

    public void setViewID(String str) {
        this.Hw.j6(this.j6, str);
    }

    public void j6(a aVar, f fVar, String str) {
        this.Hw.j6(this.j6, aVar.j6, fVar == null ? null : fVar.j6, str);
    }

    public String FH() {
        return this.Hw.j6(this.j6);
    }

    public List<String> getAllIDs() {
        return this.Hw.we();
    }

    public boolean Hw() {
        return we();
    }

    private boolean we() {
        return (this.DW == null || !(this.DW.j6 instanceof ViewGroup) || (this.DW.j6 instanceof AdapterView)) ? false : true;
    }

    public f getParentView() {
        return this.v5;
    }

    public boolean v5() {
        return this.j6.getParentNode() instanceof Document;
    }

    public boolean Zo() {
        return this.DW != null && (this.DW.j6 instanceof RelativeLayout);
    }

    public void j6(a aVar, String str) {
        this.Hw.j6(this.j6, aVar.j6, str);
    }

    public void j6(b bVar) {
        this.Hw.Hw(this.j6, bVar);
    }

    public void DW(b bVar) {
        this.Hw.j6(this.j6, bVar);
    }

    public void FH(b bVar) {
        if (getParentView().Zo()) {
            j6(bVar, h.j6);
        } else {
            this.Hw.DW(this.j6, bVar);
        }
    }

    private void j6(b bVar, a aVar) {
        String viewID = getViewID();
        if (viewID == null) {
            viewID = FH();
        }
        this.Hw.j6(getParentView().j6, bVar, this.j6, aVar, viewID);
    }

    public void Hw(b bVar) {
        if (getParentView().Zo()) {
            j6(bVar, h.DW);
        } else {
            this.Hw.FH(this.j6, bVar);
        }
    }

    public void v5(b bVar) {
        j6(bVar, h.Hw);
    }

    public void Zo(b bVar) {
        j6(bVar, h.FH);
    }

    public boolean VH() {
        return !v5() && getParentView().Zo();
    }

    public boolean gn() {
        return !v5() && getParentView().Zo();
    }

    public boolean u7() {
        return !v5();
    }

    public boolean tp() {
        return !v5();
    }

    public void EQ() {
        this.Hw.DW(this.j6);
    }

    public void j6(XmlLayoutDesignActivity xmlLayoutDesignActivity) {
        xmlLayoutDesignActivity.j6(getSourceLine(), getSourceColumn());
    }

    public String getPath() {
        if (this.v5 != null) {
            return this.v5.getPath() + " > " + getNodeName();
        }
        return getNodeName();
    }

    public int getDepth() {
        return this.Zo;
    }

    public void j6(y<f> yVar) {
        this.Hw.j6(this.j6, (y) yVar);
    }
}
