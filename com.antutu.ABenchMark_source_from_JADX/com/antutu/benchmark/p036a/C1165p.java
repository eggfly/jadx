package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.C0510a;
import android.support.v7.widget.RecyclerView.C0532u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.OtherCommentActivity;
import com.antutu.benchmark.modelreflact.OtherCommentModel;
import com.antutu.benchmark.view.MaterialRippleLayout;
import com.antutu.utils.MobclickAgentConstants;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.p */
public class C1165p extends C0510a<C1164a> {
    List<List<OtherCommentModel>> f3941a;
    private Activity f3942b;

    /* renamed from: com.antutu.benchmark.a.p.1 */
    class C11631 implements OnClickListener {
        final /* synthetic */ OtherCommentModel f3938a;
        final /* synthetic */ C1165p f3939b;

        C11631(C1165p c1165p, OtherCommentModel otherCommentModel) {
            this.f3939b = c1165p;
            this.f3938a = otherCommentModel;
        }

        public void onClick(View view) {
            MobclickAgent.onEvent(this.f3939b.f3942b, MobclickAgentConstants.click_other_phone_comment);
            Intent intent = new Intent(this.f3939b.f3942b, OtherCommentActivity.class);
            intent.putExtra("INTENT_ACTION_MODEL_ID", this.f3938a.getModel_id());
            intent.putExtra("INTENT_ACTION_PHONE_NAME", this.f3938a.getName());
            this.f3939b.f3942b.startActivity(intent);
        }
    }

    /* renamed from: com.antutu.benchmark.a.p.a */
    static class C1164a extends C0532u {
        LinearLayout f3940a;

        public C1164a(View view) {
            super(view);
            this.f3940a = (LinearLayout) view.findViewById(C1082R.id.ll_bg);
        }
    }

    public C1165p(Activity activity) {
        this.f3941a = new ArrayList();
        this.f3942b = activity;
    }

    public C1164a m4927a(ViewGroup viewGroup, int i) {
        return new C1164a(LayoutInflater.from(this.f3942b).inflate(C1082R.layout.adapter_other_phone, viewGroup, false));
    }

    public void m4928a(C1164a c1164a, int i) {
        List list = (List) this.f3941a.get(i);
        c1164a.f3940a.removeAllViews();
        for (int i2 = 0; i2 < list.size(); i2++) {
            OtherCommentModel otherCommentModel = (OtherCommentModel) list.get(i2);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.f3942b.getResources().getDimensionPixelOffset(C1082R.dimen.other_comment_textview_height), (float) otherCommentModel.getStyle().intValue());
            int dimensionPixelOffset = list.size() == 3 ? this.f3942b.getResources().getDimensionPixelOffset(C1082R.dimen.other_comment_textview_margin) : list.size() == 2 ? this.f3942b.getResources().getDimensionPixelOffset(C1082R.dimen.other_comment_textview_margin_2) : this.f3942b.getResources().getDimensionPixelOffset(C1082R.dimen.other_comment_textview_margin);
            layoutParams.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            View inflate = View.inflate(this.f3942b, C1082R.layout.other_phone_block, null);
            inflate.setLayoutParams(layoutParams);
            TextView textView = (TextView) inflate.findViewById(C1082R.id.textView);
            CardView cardView = (CardView) inflate.findViewById(C1082R.id.card_view);
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) inflate.findViewById(C1082R.id.mr_bg);
            textView.setText(otherCommentModel.getName());
            try {
                textView.setBackgroundColor(Color.parseColor(otherCommentModel.getColor()));
                cardView.setCardBackgroundColor(Color.parseColor(otherCommentModel.getColor()));
            } catch (Exception e) {
                textView.setBackgroundResource(C1082R.color.light_red);
                cardView.setCardBackgroundColor(this.f3942b.getResources().getColor(C1082R.color.light_red));
            }
            c1164a.f3940a.addView(inflate);
            materialRippleLayout.setOnClickListener(new C11631(this, otherCommentModel));
        }
    }

    public void m4929a(List<OtherCommentModel> list) {
        this.f3941a.clear();
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            OtherCommentModel otherCommentModel = (OtherCommentModel) list.get(i2);
            i += otherCommentModel.getStyle().intValue();
            if (i > 3) {
                this.f3941a.add(arrayList);
                arrayList = new ArrayList();
                i = otherCommentModel.getStyle().intValue();
                arrayList.add(otherCommentModel);
            } else {
                arrayList.add(otherCommentModel);
            }
        }
        if (arrayList.size() > 0) {
            this.f3941a.add(arrayList);
        }
    }

    public int getItemCount() {
        return this.f3941a.size();
    }

    public /* synthetic */ void onBindViewHolder(C0532u c0532u, int i) {
        m4928a((C1164a) c0532u, i);
    }

    public /* synthetic */ C0532u onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m4927a(viewGroup, i);
    }
}
