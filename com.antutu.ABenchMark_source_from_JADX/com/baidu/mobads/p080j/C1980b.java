package com.baidu.mobads.p080j;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;

/* renamed from: com.baidu.mobads.j.b */
public class C1980b implements IXAdActivityUtils {
    public Boolean isFullScreen(Activity activity) {
        if (activity == null) {
            return Boolean.valueOf(false);
        }
        try {
            return Boolean.valueOf((activity.getWindow().getAttributes().flags & IXAdIOUtils.BUFFER_SIZE) == IXAdIOUtils.BUFFER_SIZE);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    public void showAlertDialog(Activity activity, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (activity != null) {
            try {
                new Builder(activity).setCancelable(z).setTitle(str).setMessage(str2).setPositiveButton(str3, onClickListener).setNegativeButton(str4, onClickListener2).create().show();
            } catch (Throwable e) {
                C1991m.m7449a().m7457f().m7395d(e);
            }
        }
    }
}
