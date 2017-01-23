package com.aide.ui;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import com.aide.analytics.a;
import com.aide.engine.SyntaxError;
import qg;
import qk;
import qm;

public class g {
    private MainActivity DW;
    private ActionMode FH;
    private boolean Hw;
    private int j6;

    class 1 implements OnMenuItemClickListener {
        final /* synthetic */ g j6;

        1(g gVar) {
            this.j6 = gVar;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.j6.j6(menuItem);
            return true;
        }
    }

    class 2 implements Callback {
        final /* synthetic */ g j6;

        2(g gVar) {
            this.j6 = gVar;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(this.j6.j6, menu);
            this.j6.j6(menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            this.j6.j6(menu);
            return true;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (this.j6.j6(menuItem)) {
                actionMode.finish();
            }
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.j6.FH = null;
            this.j6.DW.FH(false);
            e.u7().sh().j3();
        }
    }

    public g(MainActivity mainActivity, int i) {
        this.DW = mainActivity;
        this.j6 = i;
    }

    public void j6(View view, boolean z) {
        DW();
        this.Hw = z;
        PopupMenu popupMenu = new PopupMenu(this.DW, view);
        popupMenu.getMenuInflater().inflate(this.j6, popupMenu.getMenu());
        j6(popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new 1(this));
        popupMenu.show();
    }

    public void j6(boolean z) {
        if (this.FH == null) {
            this.Hw = z;
            this.FH = this.DW.startActionMode(new 2(this));
            this.DW.FH(true);
        }
    }

    public void j6() {
        if (this.FH != null) {
            this.FH.invalidate();
        }
    }

    public void DW() {
        if (this.FH != null) {
            this.FH.finish();
            this.FH = null;
        }
    }

    private boolean j6(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        int j6 = j6(itemId);
        qk j62 = f.j6(itemId);
        if (j6 >= 0) {
            SyntaxError FH = FH();
            if (!(FH == null || FH.gn == null || FH.gn.length <= j6)) {
                e.u7().we();
                e.XL().j6(FH, j6);
            }
            return true;
        } else if (j62 == null) {
            return false;
        } else {
            a.DW("Quick Action Menu: " + menuItem.getTitle());
            return j62.DW();
        }
    }

    private boolean j6(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            DW(item);
            if (item.getSubMenu() != null) {
                j6(item.getSubMenu());
            }
        }
        return true;
    }

    private void DW(MenuItem menuItem) {
        boolean z = true;
        int itemId = menuItem.getItemId();
        int j6 = j6(itemId);
        qk j62 = f.j6(itemId);
        SyntaxError FH;
        if (itemId == R.b.editorMenuFix) {
            boolean z2;
            FH = FH();
            if (FH == null || FH.gn == null || FH.gn.length <= 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            menuItem.setVisible(z2);
        } else if (j6 >= 0) {
            FH = FH();
            if (FH == null || FH.gn == null || FH.gn.length <= j6) {
                menuItem.setVisible(false);
                return;
            }
            menuItem.setTitle(FH.gn[j6]);
            menuItem.setVisible(true);
        } else if (j62 != null) {
            menuItem.setEnabled(j62.g_());
            if (j62 instanceof qm) {
                qm qmVar = (qm) j62;
                if (this.Hw) {
                    z = false;
                }
                menuItem.setVisible(qmVar.j6(z));
            }
        }
    }

    private SyntaxError FH() {
        qg currentFileSpan = e.u7().sh().getCurrentFileSpan();
        return e.aM().DW(currentFileSpan.j6, currentFileSpan.DW, currentFileSpan.FH, currentFileSpan.Hw, currentFileSpan.v5);
    }

    private int j6(int i) {
        switch (i) {
            case R.b.editorMenuFix0 /*2131558685*/:
                return 0;
            case R.b.editorMenuFix1 /*2131558686*/:
                return 1;
            case R.b.editorMenuFix2 /*2131558687*/:
                return 2;
            case R.b.editorMenuFix3 /*2131558688*/:
                return 3;
            case R.b.editorMenuFix4 /*2131558689*/:
                return 4;
            case R.b.editorMenuFix5 /*2131558690*/:
                return 5;
            default:
                return -1;
        }
    }
}
