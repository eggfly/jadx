package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    ListAdapter f293a;
    private final Runnable aj;
    private final OnItemClickListener ak;
    ListView f294b;
    View f295c;
    TextView f296d;
    View f297e;
    View f298f;
    CharSequence f299g;
    boolean f300h;
    private final Handler f301i;

    /* renamed from: android.support.v4.app.ListFragment.1 */
    class C00281 implements Runnable {
        final /* synthetic */ ListFragment f291a;

        C00281(ListFragment listFragment) {
            this.f291a = listFragment;
        }

        public void run() {
            this.f291a.f294b.focusableViewAvailable(this.f291a.f294b);
        }
    }

    /* renamed from: android.support.v4.app.ListFragment.2 */
    class C00292 implements OnItemClickListener {
        final /* synthetic */ ListFragment f292a;

        C00292(ListFragment listFragment) {
            this.f292a = listFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f292a.m426a((ListView) adapterView, view, i, j);
        }
    }

    public ListFragment() {
        this.f301i = new Handler();
        this.aj = new C00281(this);
        this.ak = new C00292(this);
    }

    public View m423a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context g = m184g();
        View frameLayout = new FrameLayout(g);
        View linearLayout = new LinearLayout(g);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(g, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(g);
        linearLayout.setId(16711683);
        View textView = new TextView(m184g());
        textView.setId(16711681);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(m184g());
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void m424a(View view, Bundle bundle) {
        super.m163a(view, bundle);
        m421a();
    }

    public void m427e() {
        this.f301i.removeCallbacks(this.aj);
        this.f294b = null;
        this.f300h = false;
        this.f298f = null;
        this.f297e = null;
        this.f295c = null;
        this.f296d = null;
        super.m180e();
    }

    public void m426a(ListView listView, View view, int i, long j) {
    }

    public void m425a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f293a != null;
        this.f293a = listAdapter;
        if (this.f294b != null) {
            this.f294b.setAdapter(listAdapter);
            if (!this.f300h && !z2) {
                if (m195n().getWindowToken() != null) {
                    z = true;
                }
                m422a(true, z);
            }
        }
    }

    private void m422a(boolean z, boolean z2) {
        m421a();
        if (this.f297e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f300h != z) {
            this.f300h = z;
            if (z) {
                if (z2) {
                    this.f297e.startAnimation(AnimationUtils.loadAnimation(m184g(), 17432577));
                    this.f298f.startAnimation(AnimationUtils.loadAnimation(m184g(), 17432576));
                } else {
                    this.f297e.clearAnimation();
                    this.f298f.clearAnimation();
                }
                this.f297e.setVisibility(8);
                this.f298f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f297e.startAnimation(AnimationUtils.loadAnimation(m184g(), 17432576));
                this.f298f.startAnimation(AnimationUtils.loadAnimation(m184g(), 17432577));
            } else {
                this.f297e.clearAnimation();
                this.f298f.clearAnimation();
            }
            this.f297e.setVisibility(0);
            this.f298f.setVisibility(8);
        }
    }

    private void m421a() {
        if (this.f294b == null) {
            View n = m195n();
            if (n == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (n instanceof ListView) {
                this.f294b = (ListView) n;
            } else {
                this.f296d = (TextView) n.findViewById(16711681);
                if (this.f296d == null) {
                    this.f295c = n.findViewById(16908292);
                } else {
                    this.f296d.setVisibility(8);
                }
                this.f297e = n.findViewById(16711682);
                this.f298f = n.findViewById(16711683);
                n = n.findViewById(16908298);
                if (n instanceof ListView) {
                    this.f294b = (ListView) n;
                    if (this.f295c != null) {
                        this.f294b.setEmptyView(this.f295c);
                    } else if (this.f299g != null) {
                        this.f296d.setText(this.f299g);
                        this.f294b.setEmptyView(this.f296d);
                    }
                } else if (n == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f300h = true;
            this.f294b.setOnItemClickListener(this.ak);
            if (this.f293a != null) {
                ListAdapter listAdapter = this.f293a;
                this.f293a = null;
                m425a(listAdapter);
            } else if (this.f297e != null) {
                m422a(false, false);
            }
            this.f301i.post(this.aj);
        }
    }
}
