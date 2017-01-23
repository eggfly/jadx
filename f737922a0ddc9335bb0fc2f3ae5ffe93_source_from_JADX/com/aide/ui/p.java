package com.aide.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import com.aide.uidesigner.ProxyTextView;
import qg;

public class p {
    private MenuItem j6;

    class 1 implements OnQueryTextListener {
        final /* synthetic */ p DW;
        private long FH;
        final /* synthetic */ SearchView j6;

        1(p pVar, SearchView searchView) {
            this.DW = pVar;
            this.j6 = searchView;
        }

        public boolean onQueryTextSubmit(String str) {
            if (!this.j6.isIconified()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.FH > 100) {
                    this.FH = currentTimeMillis;
                    qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
                    if (!e.u7().sh().j6(currentFileSpan.DW, currentFileSpan.FH + 1, str.trim())) {
                        Toast.makeText(e.u7(), R.f.view_toast_passed_end_of_file, 0).show();
                        e.u7().sh().j6(1, 1, str.trim());
                    }
                }
            }
            return true;
        }

        public boolean onQueryTextChange(String str) {
            if (!(this.j6.isIconified() || str.trim().length() == 0)) {
                e.u7().sh().j6(1, 1, str);
            }
            return true;
        }
    }

    class 2 implements OnCloseListener {
        final /* synthetic */ p j6;

        2(p pVar) {
            this.j6 = pVar;
        }

        public boolean onClose() {
            e.u7().sh().j3();
            return true;
        }
    }

    public p(Menu menu) {
        this.j6 = menu.findItem(R.b.mainMenuSearchWidget);
        SearchView searchView = (SearchView) this.j6.getActionView();
        searchView.setInputType(ProxyTextView.INPUTTYPE_textVisiblePassword);
        searchView.setOnQueryTextListener(new 1(this, searchView));
        searchView.setOnCloseListener(new 2(this));
    }

    public boolean j6() {
        return (this.j6 == null || ((SearchView) this.j6.getActionView()).isIconified()) ? false : true;
    }

    public void DW() {
        this.j6.expandActionView();
    }

    public void FH() {
        this.j6.setVisible(e.u7().ca());
        this.j6.setEnabled(e.j3().VH());
    }
}
