package com.aide.appwizard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aide.appwizard.runtime.a.c;
import com.aide.common.UndoManager;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.uidesigner.b;
import com.aide.uidesigner.f;
import com.aide.uidesigner.g;
import com.aide.uidesigner.k;
import com.aide.uidesigner.l;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class a extends Fragment {
    private l j6;

    class 1 extends l {
        final /* synthetic */ a DW;
        final /* synthetic */ int j6;

        class 1 implements y<b> {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void j6(b bVar) {
                this.j6.DW.j6.j6(bVar);
            }
        }

        1(a aVar, ViewGroup viewGroup, String str, String str2, UndoManager undoManager, int i) {
            this.DW = aVar;
            this.j6 = i;
            super(viewGroup, str, str2, undoManager);
        }

        protected void j6() {
            k.j6(this.DW.gn(), "Add...", new 1(this));
        }

        protected void j6(f fVar) {
            g.j6(this.DW.gn(), fVar);
        }

        protected void j6(boolean z) {
            if (this.DW.j6.FH() == null) {
                this.DW.j6.j6(this.DW.dx().j6(this.j6));
            }
            this.DW.j6(this.DW.j6.FH());
        }

        protected void DW() {
        }
    }

    public View j6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.c.appwizard_section, viewGroup, false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.b.appwizardSectionContainer);
        viewGroup2.setClipChildren(false);
        int i = VH().getInt("ARG_SECTION_ID");
        String VH = dx().VH();
        String j6 = dx().j6(VH().getString("ARG_SECTION_LAYOUT"));
        if (!(cb() == null || this.j6 == null)) {
            cb().DW(this.j6);
        }
        this.j6 = new 1(this, viewGroup3, j6, VH, cb(), i);
        this.j6.Hw();
        this.j6.DW(false);
        j6();
        return viewGroup2;
    }

    public void aM() {
        super.aM();
        if (cb() != null && this.j6 != null) {
            cb().DW(this.j6);
        }
    }

    private void j6(String str) {
        try {
            new File(str).getParentFile().mkdirs();
            FileWriter fileWriter = new FileWriter(str);
            fileWriter.write(this.j6.v5());
            fileWriter.close();
        } catch (IOException e) {
        }
    }

    private UndoManager cb() {
        return dx().J8();
    }

    private AppWizardDesignActivity dx() {
        return (AppWizardDesignActivity) gn();
    }

    public void j6() {
        this.j6.FH(dx().we());
    }

    public static a j6(c cVar) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_SECTION_TITLE", cVar.Hw());
        bundle.putString("ARG_SECTION_LAYOUT", cVar.DW());
        bundle.putInt("ARG_SECTION_ID", cVar.j6());
        aVar.VH(bundle);
        return aVar;
    }
}
