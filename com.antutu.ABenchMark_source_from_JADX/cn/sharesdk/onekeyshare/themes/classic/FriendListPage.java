package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anet.channel.strategy.dispatch.C0714a;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.Following;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.C4021R;
import com.umeng.message.proguard.C4233j;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class FriendListPage extends OnekeySharePage implements OnClickListener, OnItemClickListener {
    private static final int DESIGN_LEFT_PADDING = 40;
    private FriendAdapter adapter;
    private int checkNum;
    private int lastPosition;
    private LinearLayout llPage;
    private Platform platform;
    private RelativeLayout rlTitle;
    private TextView tvCancel;
    private TextView tvConfirm;

    public FriendListPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.lastPosition = -1;
        this.checkNum = 0;
    }

    private void initTitle(RelativeLayout relativeLayout, float f) {
        this.tvCancel = new TextView(this.activity);
        this.tvCancel.setTextColor(-12895429);
        this.tvCancel.setTextSize(2, 18.0f);
        this.tvCancel.setGravity(17);
        int stringRes = C4021R.getStringRes(this.activity, "ssdk_oks_cancel");
        if (stringRes > 0) {
            this.tvCancel.setText(stringRes);
        }
        stringRes = (int) (40.0f * f);
        this.tvCancel.setPadding(stringRes, 0, stringRes, 0);
        relativeLayout.addView(this.tvCancel, new LayoutParams(-2, -1));
        this.tvCancel.setOnClickListener(this);
        View textView = new TextView(this.activity);
        textView.setTextColor(-12895429);
        textView.setTextSize(2, 22.0f);
        textView.setGravity(17);
        int stringRes2 = C4021R.getStringRes(this.activity, "ssdk_oks_contacts");
        if (stringRes2 > 0) {
            textView.setText(stringRes2);
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -1);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        this.tvConfirm = new TextView(this.activity);
        this.tvConfirm.setTextColor(-37615);
        this.tvConfirm.setTextSize(2, 18.0f);
        this.tvConfirm.setGravity(17);
        int stringRes3 = C4021R.getStringRes(this.activity, "ssdk_oks_confirm");
        if (stringRes3 > 0) {
            this.tvConfirm.setText(stringRes3);
        }
        this.tvConfirm.setPadding(stringRes, 0, stringRes, 0);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.tvConfirm, layoutParams2);
        this.tvConfirm.setOnClickListener(this);
    }

    private void updateConfirmView() {
        int stringRes = C4021R.getStringRes(this.activity, "ssdk_oks_confirm");
        Object obj = "Confirm";
        if (stringRes > 0) {
            obj = getContext().getResources().getString(stringRes);
        }
        if (this.checkNum == 0) {
            this.tvConfirm.setText(obj);
        } else if (this.checkNum > 0) {
            this.tvConfirm.setText(obj + C4233j.f14396s + this.checkNum + C4233j.f14397t);
        }
    }

    protected abstract int getDesignTitleHeight();

    protected abstract float getRatio();

    public void onClick(View view) {
        if (view.equals(this.tvCancel)) {
            finish();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int count = this.adapter.getCount();
        for (int i = 0; i < count; i++) {
            if (this.adapter.getItem(i).checked) {
                arrayList.add(this.adapter.getItem(i).atName);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("selected", arrayList);
        hashMap.put(C0714a.PLATFORM, this.platform);
        setResult(hashMap);
        finish();
    }

    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(-789517));
        this.llPage = new LinearLayout(this.activity);
        this.llPage.setOrientation(1);
        this.activity.setContentView(this.llPage);
        this.rlTitle = new RelativeLayout(this.activity);
        float ratio = getRatio();
        this.llPage.addView(this.rlTitle, new LinearLayout.LayoutParams(-1, (int) (((float) getDesignTitleHeight()) * ratio)));
        initTitle(this.rlTitle, ratio);
        View view = new View(this.activity);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) (ratio < 1.0f ? 1.0f : ratio));
        view.setBackgroundColor(-2434599);
        this.llPage.addView(view, layoutParams);
        View frameLayout = new FrameLayout(getContext());
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        frameLayout.setLayoutParams(layoutParams2);
        this.llPage.addView(frameLayout);
        View pullToRequestView = new PullToRequestView(getContext());
        pullToRequestView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(pullToRequestView);
        this.adapter = new FriendAdapter(this, pullToRequestView);
        this.adapter.setPlatform(this.platform);
        this.adapter.setRatio(ratio);
        this.adapter.setOnItemClickListener(this);
        pullToRequestView.setAdapter(this.adapter);
        pullToRequestView.performPullingDown(true);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = false;
        if ("FacebookMessenger".equals(this.platform.getName())) {
            if (this.lastPosition >= 0) {
                this.adapter.getItem(this.lastPosition).checked = false;
            }
            this.lastPosition = i;
        }
        Following item = this.adapter.getItem(i);
        if (!item.checked) {
            z = true;
        }
        item.checked = z;
        if (item.checked) {
            this.checkNum++;
        } else {
            this.checkNum--;
        }
        updateConfirmView();
        this.adapter.notifyDataSetChanged();
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
