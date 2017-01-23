package com.antutu.utils.update;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.utils.downloader.DownloadInfos;
import com.antutu.utils.downloader.DownloadsService;
import com.xiaomi.pushsdk.C4459R;

public class UpdateActivity extends Activity {

    /* renamed from: com.antutu.utils.update.UpdateActivity.1 */
    class C18301 implements OnItemClickListener {
        final /* synthetic */ Dialog val$dlg;

        C18301(Dialog dialog) {
            this.val$dlg = dialog;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == 0) {
                UpdateActivity.this.downloadFromMarket();
            } else {
                UpdateActivity.this.downloadFromWeb();
            }
            this.val$dlg.dismiss();
            UpdateActivity.this.finish();
        }
    }

    /* renamed from: com.antutu.utils.update.UpdateActivity.2 */
    class C18312 implements OnClickListener {
        final /* synthetic */ Dialog val$dlg;

        C18312(Dialog dialog) {
            this.val$dlg = dialog;
        }

        public void onClick(View view) {
            this.val$dlg.dismiss();
            UpdateActivity.this.finish();
        }
    }

    /* renamed from: com.antutu.utils.update.UpdateActivity.3 */
    class C18323 implements OnCancelListener {
        C18323() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            UpdateActivity.this.finish();
        }
    }

    private static class ListAdapter extends BaseAdapter {
        private String[] mData;
        private LayoutInflater mInflater;

        static class ViewHolder {
            TextView numberText;

            ViewHolder() {
            }
        }

        ListAdapter(Context context, String[] strArr) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = strArr;
        }

        public int getCount() {
            return this.mData.length;
        }

        public Object getItem(int i) {
            return this.mData == null ? null : this.mData[i];
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = this.mInflater.inflate(C1082R.layout.download_from_item, null);
                ViewHolder viewHolder2 = new ViewHolder();
                viewHolder2.numberText = (TextView) view.findViewById(C1082R.id.number_text);
                view.setTag(viewHolder2);
                viewHolder = viewHolder2;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.numberText.setText(this.mData[i]);
            return view;
        }
    }

    private void downloadFromMarket() {
        try {
            String str = Update.newPkg;
            if (str == null || str.length() < 5) {
                str = getPackageName();
            }
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (Exception e) {
        }
    }

    private void downloadFromWeb() {
        try {
            DownloadInfos downloadInfos = new DownloadInfos();
            downloadInfos.setUrl(Update.newUrl);
            downloadInfos.setNeedRename(true);
            DownloadsService.startDownload(this, downloadInfos);
        } catch (Exception e) {
        }
    }

    private void showDialog() {
        String[] strArr = new String[]{getString(C1082R.string.download_market), getString(C1082R.string.download_website)};
        CharSequence charSequence = getString(C1082R.string.prompt_download) + "\n" + getString(C4459R.string.app_name) + Update.newVersion;
        Dialog dialog = new Dialog(this, C1082R.style.DialogTheme);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(C1082R.layout.download_from_dialog, null);
        ((TextView) linearLayout.findViewById(C1082R.id.download_from_title)).setText(charSequence);
        ListView listView = (ListView) linearLayout.findViewById(C1082R.id.number_listview);
        listView.setAdapter(new ListAdapter(this, strArr));
        listView.setOnItemClickListener(new C18301(dialog));
        linearLayout.findViewById(C1082R.id.negative_btn).setOnClickListener(new C18312(dialog));
        dialog.setContentView(linearLayout);
        dialog.setOnCancelListener(new C18323());
        Window window = dialog.getWindow();
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = defaultDisplay.getWidth();
        window.setAttributes(attributes);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getIntent().getAction().endsWith(Update.UPDATE_DIALOG)) {
                showDialog();
                return;
            }
            Update.CheckUpdate(getApplicationContext(), true);
            finish();
        } catch (Exception e) {
            Update.CheckUpdate(getApplicationContext(), true);
            finish();
        }
    }
}
