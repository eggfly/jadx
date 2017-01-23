package com.aide.ui.marketing;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.ui.R;
import com.aide.ui.marketing.a.a;
import java.util.ArrayList;
import java.util.List;

public class WhatsNewDialog {

    static class 1 extends DialogFragment {
        final /* synthetic */ Runnable DW;
        final /* synthetic */ Activity j6;

        class 1 implements OnClickListener {
            final /* synthetic */ 1 j6;

            1(1 1) {
                this.j6 = 1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        1(Activity activity, Runnable runnable) {
            this.j6 = activity;
            this.DW = runnable;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            View listView = new ListView(this.j6);
            listView.setAdapter(new PromotedAppListAdapter(this.j6));
            Dialog create = new Builder(this.j6).setView(listView).create();
            create.setButton(-1, getString(R.f.dialog_ok), new 1(this));
            return create;
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (this.DW != null) {
                this.DW.run();
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            super.onDismiss(dialogInterface);
            if (this.DW != null) {
                this.DW.run();
            }
        }
    }

    private static class PromotedAppListAdapter extends BaseAdapter {
        private Context DW;
        private List<a> j6;

        public PromotedAppListAdapter(Context context) {
            this.j6 = new ArrayList();
            this.DW = context;
            this.j6 = new ArrayList();
            for (a aVar : a.j6) {
                if (aVar.DW.equals(context.getPackageName())) {
                    this.j6.add(aVar);
                }
            }
        }

        public int getCount() {
            return this.j6.size();
        }

        public Object getItem(int i) {
            return this.j6.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            int i3 = 0;
            if (view == null) {
                view = LayoutInflater.from(this.DW).inflate(R.c.dialog_whatsnew_item, viewGroup, false);
            }
            a aVar = (a) this.j6.get(i);
            TextView textView = (TextView) view.findViewById(R.b.whatsNewItemHeader);
            textView.setText(i == 0 ? "What's new" : "New app");
            if (i <= 1) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            ((ImageView) view.findViewById(R.b.whatsNewItemIcon)).setImageResource(aVar.j6);
            textView = (TextView) view.findViewById(R.b.whatsNewItemTitle);
            textView.setText(aVar.FH);
            if (i != 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            textView = (TextView) view.findViewById(R.b.whatsNewItemSubTitle);
            textView.setText(aVar.Hw);
            if (i != 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView.setVisibility(i2);
            textView = (TextView) view.findViewById(R.b.whatsNewItemText);
            List j6 = aVar.j6(this.DW);
            String str = WhatsNewDialog.FH(this.DW) + "<br/>";
            for (i2 = 0; i2 < j6.size(); i2++) {
                String str2 = (String) j6.get(i2);
                int indexOf = str2.indexOf(58);
                if (indexOf > 0) {
                    str2 = "<b>" + str2.substring(0, indexOf + 1) + "</b>" + str2.substring(indexOf + 1, str2.length());
                }
                str = str + str2;
                if (i2 < j6.size() - 1) {
                    str = str + "<br/>";
                }
            }
            textView.setText(Html.fromHtml(str));
            if (i != 0) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            return view;
        }
    }

    public static boolean j6(Activity activity, Runnable runnable) {
        if (activity.getSharedPreferences("WhatsNew", 0).getInt("ShownVersion", 0) == DW(activity)) {
            return false;
        }
        DW(activity, runnable);
        return true;
    }

    private static int DW(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return i;
        }
    }

    private static String FH(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static void DW(Activity activity, Runnable runnable) {
        activity.getSharedPreferences("WhatsNew", 0).edit().putInt("ShownVersion", DW(activity)).commit();
        new 1(activity, runnable).show(activity.getFragmentManager(), "whatsnew");
    }
}
