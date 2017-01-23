package com.aide.ui.build.javascript;

import com.aide.ui.build.b;
import com.aide.ui.e;
import com.aide.ui.h;
import it;
import it$a;

public class a implements b, it {
    public void FH() {
    }

    public void Hw() {
    }

    public void v5() {
    }

    public void j6(boolean z) {
    }

    public void j6(String str) {
    }

    public void Zo() {
    }

    public void VH() {
        gn();
    }

    public int j6() {
        return 20;
    }

    public it$a DW() {
        return it$a.JAVASCRIPT;
    }

    public void gn() {
        u7();
    }

    private void u7() {
        if (!e.sG().v5() && !e.sG().FH()) {
            if (e.aM().Hw(".js")) {
                e.U2().j6(false);
                e.U2().j6("Your code contains errors. Please fix them before running.");
                return;
            }
            e.j3().j6(false, false);
            RunJavaScriptActivity.j6(e.u7(), h.cn(), e.a8().u7() + "/main.js", 15);
        }
    }
}
