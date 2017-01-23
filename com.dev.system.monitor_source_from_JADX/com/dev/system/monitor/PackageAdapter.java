package com.dev.system.monitor;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.fortysevendeg.swipelistview.SwipeListView;
import java.util.List;

public class PackageAdapter extends BaseAdapter {
    private Context context;
    private List<PackageItem> data;
    private Fragment fragmentContext;
    private SwipeListView swipeListView;

    /* renamed from: com.dev.system.monitor.PackageAdapter.1 */
    class C01301 implements OnClickListener {
        final /* synthetic */ PackageItem val$item;

        C01301(PackageItem packageItem) {
            this.val$item = packageItem;
        }

        public void onClick(View v) {
            ((ActivityManager) PackageAdapter.this.context.getSystemService("activity")).killBackgroundProcesses(this.val$item.getPackageName());
            PackageAdapter.this.data.remove(this.val$item);
            PackageAdapter.this.notifyDataSetChanged();
            PackageAdapter.this.swipeListView.closeOpenedItems();
            Toast.makeText(PackageAdapter.this.context, this.val$item.getName() + " closed", 1).show();
        }
    }

    /* renamed from: com.dev.system.monitor.PackageAdapter.2 */
    class C01312 implements OnClickListener {
        final /* synthetic */ PackageItem val$item;

        C01312(PackageItem packageItem) {
            this.val$item = packageItem;
        }

        public void onClick(View v) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("package:" + this.val$item.getPackageName()));
            PackageAdapter.this.context.startActivity(intent);
        }
    }

    /* renamed from: com.dev.system.monitor.PackageAdapter.3 */
    class C01323 implements OnClickListener {
        final /* synthetic */ PackageItem val$item;

        C01323(PackageItem packageItem) {
            this.val$item = packageItem;
        }

        @TargetApi(14)
        public void onClick(View v) {
            Intent uninstallIntent;
            Uri packageUri = Uri.parse("package:" + this.val$item.getPackageName());
            if (VERSION.SDK_INT < 14) {
                uninstallIntent = new Intent("android.intent.action.DELETE", packageUri);
            } else {
                uninstallIntent = new Intent("android.intent.action.UNINSTALL_PACKAGE", packageUri);
            }
            ((AppManagement) PackageAdapter.this.fragmentContext).operatingThirdPackage = this.val$item.getPackageName();
            PackageAdapter.this.fragmentContext.startActivityForResult(uninstallIntent, 3);
        }
    }

    static class ViewHolder {
        Button bAction1;
        Button bAction2;
        Button bAction3;
        TextView cpuUsage;
        ImageView ivImage;
        TextView ramUsage;
        TextView tvDescription;
        TextView tvTitle;

        ViewHolder() {
        }
    }

    public PackageAdapter(Context context, List<PackageItem> data, SwipeListView swipeListView, Fragment fragmentContext) {
        this.context = context;
        this.data = data;
        this.swipeListView = swipeListView;
        this.fragmentContext = fragmentContext;
    }

    public int getCount() {
        return this.data.size();
    }

    public PackageItem getItem(int position) {
        return (PackageItem) this.data.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        PackageItem item = getItem(position);
        if (convertView == null) {
            convertView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0133R.layout.package_row, parent, false);
            holder = new ViewHolder();
            holder.ivImage = (ImageView) convertView.findViewById(C0133R.id.example_row_iv_image);
            holder.tvTitle = (TextView) convertView.findViewById(C0133R.id.example_row_tv_title);
            holder.tvDescription = (TextView) convertView.findViewById(C0133R.id.example_row_tv_description);
            holder.ramUsage = (TextView) convertView.findViewById(C0133R.id.textView1);
            holder.bAction1 = (Button) convertView.findViewById(C0133R.id.example_row_b_action_1);
            holder.bAction2 = (Button) convertView.findViewById(C0133R.id.example_row_b_action_2);
            holder.bAction3 = (Button) convertView.findViewById(C0133R.id.example_row_b_action_3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ((SwipeListView) parent).recycle(convertView, position);
        holder.ivImage.setImageDrawable(item.getIcon());
        holder.tvTitle.setText(item.getName());
        holder.tvDescription.setText(item.getPackageName());
        holder.ramUsage.setText((item.getMemoryInKByte() / AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) + " MB");
        holder.bAction1.setOnClickListener(new C01301(item));
        holder.bAction2.setOnClickListener(new C01312(item));
        holder.bAction3.setOnClickListener(new C01323(item));
        return convertView;
    }
}
