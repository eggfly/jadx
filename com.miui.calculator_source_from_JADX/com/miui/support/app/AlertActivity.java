package com.miui.support.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import com.android.internal.app.AlertController;
import com.android.internal.app.AlertController.AlertParams;
import com.miui.support.internal.variable.AlertControllerWrapper;

public abstract class AlertActivity extends Activity implements DialogInterface {
    protected AlertController f1903a;
    protected AlertParams f1904b;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1903a = new AlertControllerWrapper(this, this, getWindow());
        this.f1904b = new AlertControllerWrapper.AlertParams(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1903a.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1903a.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
