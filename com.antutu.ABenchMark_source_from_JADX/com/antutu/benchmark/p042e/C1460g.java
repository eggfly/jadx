package com.antutu.benchmark.p042e;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.modelreflact.OtherCommentModel;
import com.antutu.benchmark.modelreflact.OtherCommentResponseModel;
import com.antutu.benchmark.p036a.C1091a;
import com.antutu.benchmark.p036a.C1165p;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1338c;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.view.CustomSwipeRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.e.g */
public class C1460g extends C1338c implements OnRefreshListener {
    private RecyclerView f5002b;
    private CustomSwipeRefreshLayout f5003c;
    private TextView f5004d;
    private C1165p f5005e;
    private List<OtherCommentModel> f5006f;
    private C1353a f5007g;

    /* renamed from: com.antutu.benchmark.e.g.1 */
    class C14541 implements C1095a<OtherCommentResponseModel> {
        final /* synthetic */ C1460g f4996a;

        C14541(C1460g c1460g) {
            this.f4996a = c1460g;
        }

        public void m5741a(OtherCommentResponseModel otherCommentResponseModel) {
            this.f4996a.f5006f.clear();
            this.f4996a.f5006f.addAll(otherCommentResponseModel.getData());
            this.f4996a.f5005e.m4929a(this.f4996a.f5006f);
            this.f4996a.f5005e.notifyDataSetChanged();
            this.f4996a.f5003c.setRefreshing(false);
            this.f4996a.m5747a(this.f4996a.getString(C1082R.string.tips_other_phone, Integer.valueOf(otherCommentResponseModel.getData().size())));
        }

        public void m5743a(String str) {
            this.f4996a.f5003c.setRefreshing(false);
        }
    }

    /* renamed from: com.antutu.benchmark.e.g.2 */
    class C14552 implements AnimatorUpdateListener {
        final /* synthetic */ C1460g f4997a;

        C14552(C1460g c1460g) {
            this.f4997a = c1460g;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f4997a.f5004d.setTranslationY(((float) (-this.f4997a.f5004d.getHeight())) * (1.0f - floatValue));
            this.f4997a.f5004d.setAlpha(floatValue);
        }
    }

    /* renamed from: com.antutu.benchmark.e.g.3 */
    class C14573 implements AnimatorListener {
        final /* synthetic */ C1460g f4999a;

        /* renamed from: com.antutu.benchmark.e.g.3.1 */
        class C14561 implements Runnable {
            final /* synthetic */ C14573 f4998a;

            C14561(C14573 c14573) {
                this.f4998a = c14573;
            }

            public void run() {
                this.f4998a.f4999a.m5752d();
            }
        }

        C14573(C1460g c1460g) {
            this.f4999a = c1460g;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            new Handler().postDelayed(new C14561(this), 400);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            this.f4999a.f5004d.setVisibility(0);
        }
    }

    /* renamed from: com.antutu.benchmark.e.g.4 */
    class C14584 implements AnimatorUpdateListener {
        final /* synthetic */ C1460g f5000a;

        C14584(C1460g c1460g) {
            this.f5000a = c1460g;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f5000a.f5004d.setTranslationY(((float) (-this.f5000a.f5004d.getHeight())) * floatValue);
            this.f5000a.f5004d.setAlpha(1.0f - floatValue);
        }
    }

    /* renamed from: com.antutu.benchmark.e.g.5 */
    class C14595 implements AnimatorListener {
        final /* synthetic */ C1460g f5001a;

        C14595(C1460g c1460g) {
            this.f5001a = c1460g;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f5001a.f5004d.setVisibility(8);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            this.f5001a.f5004d.setVisibility(0);
        }
    }

    public C1460g() {
        this.f5005e = null;
        this.f5006f = new ArrayList();
    }

    private void m5745a(View view) {
        this.f5003c = (CustomSwipeRefreshLayout) view.findViewById(C1082R.id.sr_ll_refresh);
        this.f5002b = (RecyclerView) view.findViewById(C1082R.id.list);
        this.f5004d = (TextView) view.findViewById(C1082R.id.update_text);
        this.f5003c.setColorSchemeResources(C1082R.color.colorPrimary_day);
    }

    private void m5747a(String str) {
        this.f5004d.setText(str);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(800);
        ofFloat.addUpdateListener(new C14552(this));
        ofFloat.addListener(new C14573(this));
        ofFloat.start();
    }

    private void m5750c() {
        this.f5003c.setOnRefreshListener(this);
        this.f5003c.setRefreshing(true);
        this.f5007g.m5415a(new C14541(this));
    }

    private void m5752d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(500);
        ofFloat.addUpdateListener(new C14584(this));
        ofFloat.addListener(new C14595(this));
        ofFloat.start();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1082R.layout.fragment_other_comment, null);
        this.f5007g = new C1353a(this.a);
        m5745a(inflate);
        this.f5002b.setLayoutManager(new LinearLayoutManager(this.a));
        this.f5005e = new C1165p(this.a);
        this.f5002b.setAdapter(new C1091a(this.f5005e));
        m5750c();
        return inflate;
    }

    public void onRefresh() {
        m5750c();
    }
}
