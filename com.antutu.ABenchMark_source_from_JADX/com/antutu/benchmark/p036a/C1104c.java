package com.antutu.benchmark.p036a;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.model.C1522c;
import com.antutu.benchmark.modelreflact.CmtSendlistBean;
import com.antutu.benchmark.modelreflact.CommentModel;
import com.antutu.benchmark.modelreflact.CommentReplyModel;
import com.antutu.benchmark.modelreflact.CommonResponseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p040c.C1353a;
import com.antutu.benchmark.p043g.C1503b;
import com.antutu.benchmark.view.C1687m;
import com.antutu.benchmark.view.C1687m.C1098c;
import com.antutu.utils.Methods;
import com.antutu.utils.MobclickAgentConstants;
import com.antutu.utils.Utils;
import com.facebook.ads.C2279R;
import com.gc.materialdesign.C2513R;
import com.umeng.analytics.MobclickAgent;
import com.xiaomi.pushsdk.BuildConfig;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.antutu.benchmark.a.c */
public class C1104c extends BaseAdapter implements SectionIndexer {
    private Activity f3706a;
    private SimpleDateFormat f3707b;
    private List<C1101b> f3708c;
    private List<Integer> f3709d;
    private LayoutInflater f3710e;
    private String[] f3711f;
    private C1100a f3712g;
    private boolean f3713h;
    private C1353a f3714i;
    private ForegroundColorSpan f3715j;
    private String f3716k;

    /* renamed from: com.antutu.benchmark.a.c.1 */
    class C10921 implements OnClickListener {
        final /* synthetic */ C1102c f3673a;
        final /* synthetic */ C1522c f3674b;
        final /* synthetic */ C1104c f3675c;

        C10921(C1104c c1104c, C1102c c1102c, C1522c c1522c) {
            this.f3675c = c1104c;
            this.f3673a = c1102c;
            this.f3674b = c1522c;
        }

        public void onClick(View view) {
            this.f3675c.m4856a(this.f3673a, this.f3674b, 0);
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.2 */
    class C10932 implements OnClickListener {
        final /* synthetic */ C1522c f3676a;
        final /* synthetic */ C1104c f3677b;

        C10932(C1104c c1104c, C1522c c1522c) {
            this.f3677b = c1104c;
            this.f3676a = c1522c;
        }

        public void onClick(View view) {
            if (this.f3677b.f3712g != null) {
                MobclickAgent.onEvent(this.f3677b.f3706a, MobclickAgentConstants.click_reply_this_comment);
                this.f3677b.f3712g.m4849a(null, this.f3676a, 0);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.3 */
    class C10943 implements OnClickListener {
        final /* synthetic */ C1102c f3678a;
        final /* synthetic */ C1522c f3679b;
        final /* synthetic */ C1104c f3680c;

        C10943(C1104c c1104c, C1102c c1102c, C1522c c1522c) {
            this.f3680c = c1104c;
            this.f3678a = c1102c;
            this.f3679b = c1522c;
        }

        public void onClick(View view) {
            this.f3680c.m4856a(this.f3678a, this.f3679b, 1);
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.4 */
    class C10974 implements OnClickListener {
        final /* synthetic */ C1522c f3682a;
        final /* synthetic */ C1102c f3683b;
        final /* synthetic */ C1104c f3684c;

        /* renamed from: com.antutu.benchmark.a.c.4.1 */
        class C10961 implements C1095a<CommonResponseModel> {
            final /* synthetic */ C10974 f3681a;

            C10961(C10974 c10974) {
                this.f3681a = c10974;
            }

            public void m4844a(CommonResponseModel commonResponseModel) {
                this.f3681a.f3682a.m6048a(!this.f3681a.f3682a.m6049a());
                if (this.f3681a.f3682a.m6049a()) {
                    this.f3681a.f3682a.m6046a(this.f3681a.f3682a.m6050b() + 1);
                } else {
                    this.f3681a.f3682a.m6046a(this.f3681a.f3682a.m6050b() - 1);
                }
                if (this.f3681a.f3682a.m6049a()) {
                    Drawable drawable = this.f3681a.f3684c.f3706a.getResources().getDrawable(C1082R.drawable.heart_red);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    this.f3681a.f3683b.f3696f.setCompoundDrawables(drawable, null, null, null);
                    this.f3681a.f3683b.f3696f.setText(this.f3681a.f3682a.m6050b() + BuildConfig.FLAVOR);
                    return;
                }
                drawable = this.f3681a.f3684c.f3706a.getResources().getDrawable(C1082R.drawable.heart);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f3681a.f3683b.f3696f.setCompoundDrawables(drawable, null, null, null);
                this.f3681a.f3683b.f3696f.setText(this.f3681a.f3682a.m6050b() + BuildConfig.FLAVOR);
            }

            public void m4846a(String str) {
            }
        }

        C10974(C1104c c1104c, C1522c c1522c, C1102c c1102c) {
            this.f3684c = c1104c;
            this.f3682a = c1522c;
            this.f3683b = c1102c;
        }

        public void onClick(View view) {
            this.f3684c.f3714i.m5416a(!this.f3682a.m6049a(), this.f3682a.m6051c(), new C10961(this));
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.5 */
    class C10995 implements C1098c {
        final /* synthetic */ C1687m f3685a;
        final /* synthetic */ C1522c f3686b;
        final /* synthetic */ int f3687c;
        final /* synthetic */ C1104c f3688d;

        C10995(C1104c c1104c, C1687m c1687m, C1522c c1522c, int i) {
            this.f3688d = c1104c;
            this.f3685a = c1687m;
            this.f3686b = c1522c;
            this.f3687c = i;
        }

        public void m4848a(int i) {
            if (i == 0) {
                if (this.f3688d.f3712g != null) {
                    MobclickAgent.onEvent(this.f3688d.f3706a, MobclickAgentConstants.click_reply_this_comment);
                    this.f3688d.f3712g.m4849a(this.f3685a, this.f3686b, this.f3687c);
                }
            } else if (i == 1) {
                Methods.copy(this.f3688d.f3706a, this.f3686b.m6053e());
                Methods.showToast(this.f3688d.f3706a, (int) C1082R.string.has_copy_note, 0);
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.a */
    public interface C1100a {
        void m4849a(PopupWindow popupWindow, C1522c c1522c, int i);
    }

    /* renamed from: com.antutu.benchmark.a.c.b */
    public static class C1101b {
        public String f3689a;
        public List<C1522c> f3690b;

        public C1101b() {
            this.f3690b = new ArrayList();
        }

        public void m4850a(List<CommentModel> list) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    C1522c transCommentAdapterModel = ((CommentModel) list.get(i)).transCommentAdapterModel();
                    if (transCommentAdapterModel != null) {
                        this.f3690b.add(transCommentAdapterModel);
                    }
                }
            }
        }

        public boolean m4851a() {
            return (this.f3689a == null || BuildConfig.FLAVOR.equals(this.f3689a)) ? false : true;
        }

        public void m4852b(List<CmtSendlistBean> list) {
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    C1522c transCommentAdapterModel = ((CmtSendlistBean) list.get(i)).transCommentAdapterModel();
                    if (transCommentAdapterModel != null) {
                        this.f3690b.add(transCommentAdapterModel);
                    }
                }
            }
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.c */
    static class C1102c {
        TextView f3691a;
        TextView f3692b;
        ImageView f3693c;
        TextView f3694d;
        LinearLayout f3695e;
        TextView f3696f;
        LinearLayout f3697g;
        TextView f3698h;
        LinearLayout f3699i;
        LinearLayout f3700j;
        LinearLayout f3701k;
        LinearLayout f3702l;
        TextView f3703m;

        C1102c() {
        }
    }

    /* renamed from: com.antutu.benchmark.a.c.d */
    static class C1103d {
        TextView f3704a;
        ImageView f3705b;

        C1103d() {
        }
    }

    public C1104c(Activity activity, boolean z, String str) {
        this.f3707b = new SimpleDateFormat("MM-dd HH:MM");
        this.f3708c = new ArrayList();
        this.f3709d = new ArrayList();
        this.f3711f = new String[2];
        this.f3715j = null;
        this.f3716k = null;
        this.f3706a = activity;
        this.f3710e = (LayoutInflater) this.f3706a.getSystemService("layout_inflater");
        this.f3711f[0] = this.f3706a.getString(C1082R.string.reply_this_comment);
        this.f3711f[1] = this.f3706a.getString(C1082R.string.copy_this_comment);
        this.f3713h = z;
        this.f3714i = new C1353a(this.f3706a);
        this.f3715j = new ForegroundColorSpan(this.f3706a.getResources().getColor(C1082R.color.shallow_gray_text));
        this.f3716k = str;
    }

    private View m4853a(int i, View view, ViewGroup viewGroup) {
        C1103d c1103d;
        View view2;
        CharSequence charSequence = ((C1101b) this.f3708c.get(i)).f3689a;
        if (view == null || !(view.getTag() instanceof C1103d)) {
            view = View.inflate(this.f3706a, C1082R.layout.item_header_comment, null);
            c1103d = new C1103d();
            c1103d.f3705b = (ImageView) view.findViewById(C1082R.id.img);
            c1103d.f3704a = (TextView) view.findViewById(C2513R.id.title);
            view.setTag(c1103d);
            view2 = view;
        } else {
            c1103d = (C1103d) view.getTag();
            view2 = view;
        }
        if (charSequence == null) {
            view2.setVisibility(8);
        } else {
            c1103d.f3704a.setText(charSequence);
        }
        return view2;
    }

    private void m4855a(C1102c c1102c, int i) {
        ContextCompat.getDrawable(this.f3706a, C1082R.drawable.pic_1);
        c1102c.f3693c.setBackground(ContextCompat.getDrawable(this.f3706a, Utils.getAvatarid(i)));
    }

    private void m4856a(C1102c c1102c, C1522c c1522c, int i) {
        C1687m c1687m = new C1687m(this.f3706a, this.f3711f);
        if (i == 0) {
            c1687m.showAsDropDown(c1102c.f3699i, 0, -c1102c.f3699i.getHeight());
        } else {
            c1687m.showAsDropDown(c1102c.f3697g, 0, -c1102c.f3697g.getHeight());
        }
        c1687m.m6597a(new C10995(this, c1687m, c1522c, i));
    }

    private void m4858a(C1522c c1522c, C1102c c1102c) {
        int i;
        int d = c1522c.m6052d();
        int level = c1522c.m6058j() != null ? c1522c.m6058j().getLevel() : 0;
        Drawable drawable = this.f3706a.getResources().getDrawable(C1082R.drawable.star_black);
        if (d == 0) {
            c1102c.f3700j.setVisibility(8);
        } else {
            c1102c.f3700j.setVisibility(0);
        }
        if (level == 0) {
            c1102c.f3701k.setVisibility(8);
        } else {
            c1102c.f3701k.setVisibility(0);
        }
        for (i = 0; i < d; i++) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(40, 40);
            layoutParams.setMargins(6, 0, 6, 0);
            View imageView = new ImageView(this.f3706a);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundDrawable(drawable);
            c1102c.f3695e.addView(imageView);
        }
        for (i = 0; i < level; i++) {
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(40, 40);
            layoutParams2.setMargins(6, 0, 6, 0);
            View imageView2 = new ImageView(this.f3706a);
            imageView2.setLayoutParams(layoutParams2);
            imageView2.setBackgroundDrawable(drawable);
            c1102c.f3702l.addView(imageView2);
        }
    }

    private void m4860b() {
        this.f3709d.clear();
        this.f3709d.add(Integer.valueOf(0));
        int i = 0;
        for (int i2 = 0; i2 < this.f3708c.size() - 1; i2++) {
            i += ((C1101b) this.f3708c.get(i2)).f3690b.size() + 1;
            this.f3709d.add(Integer.valueOf(i));
        }
    }

    public void m4862a() {
        this.f3708c.clear();
        this.f3709d.clear();
    }

    public void m4863a(int i, C1101b c1101b) {
        this.f3708c.add(0, c1101b);
        if (c1101b.m4851a()) {
            m4860b();
        }
    }

    public void m4864a(C1100a c1100a) {
        this.f3712g = c1100a;
    }

    public void m4865a(C1101b c1101b) {
        this.f3708c.add(c1101b);
        if (c1101b.m4851a()) {
            m4860b();
        }
    }

    public void m4866a(String str, List<CommentModel> list) {
        if (list != null) {
            for (int i = 0; i < this.f3708c.size(); i++) {
                C1101b c1101b = (C1101b) this.f3708c.get(i);
                if (c1101b.f3689a.equals(str)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        c1101b.f3690b.add(((CommentModel) list.get(i2)).transCommentAdapterModel());
                    }
                }
            }
        }
    }

    public void m4867b(String str, List<CmtSendlistBean> list) {
        if (list != null) {
            for (int i = 0; i < this.f3708c.size(); i++) {
                C1101b c1101b = (C1101b) this.f3708c.get(i);
                if (c1101b.f3689a.equals(str)) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        c1101b.f3690b.add(((CmtSendlistBean) list.get(i2)).transCommentAdapterModel());
                    }
                }
            }
        }
    }

    public int getCount() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3708c.size(); i2++) {
            C1101b c1101b = (C1101b) this.f3708c.get(i2);
            i += c1101b.f3690b.size();
            if (c1101b.m4851a()) {
                i++;
            }
        }
        return i;
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getPositionForSection(int i) {
        return ((Integer) this.f3709d.get(i)).intValue();
    }

    public int getSectionForPosition(int i) {
        if (this.f3709d.size() <= 0) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3708c.size(); i4++) {
            i2 += ((C1101b) this.f3708c.get(i4)).f3690b.size();
            if (((C1101b) this.f3708c.get(i4)).m4851a()) {
                i2++;
            }
            if (i < i2) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public Object[] getSections() {
        return this.f3708c.toArray();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f3709d.contains(Integer.valueOf(i))) {
            return m4853a(this.f3709d.indexOf(Integer.valueOf(i)), view, viewGroup);
        }
        int i2;
        C1102c c1102c;
        int sectionForPosition = getSectionForPosition(i);
        if (sectionForPosition == -1) {
            i2 = 0;
        } else {
            i = (i - ((Integer) this.f3709d.get(sectionForPosition)).intValue()) - 1;
            i2 = sectionForPosition;
        }
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C1102c)) {
            c1102c = new C1102c();
            view = this.f3710e.inflate(C1082R.layout.pinglun_item, null);
            c1102c.f3692b = (TextView) view.findViewById(C1082R.id.pinglun_content);
            c1102c.f3693c = (ImageView) view.findViewById(C1082R.id.headicon);
            c1102c.f3691a = (TextView) view.findViewById(C1082R.id.name);
            c1102c.f3695e = (LinearLayout) view.findViewById(C1082R.id.luobo_container);
            c1102c.f3700j = (LinearLayout) view.findViewById(C1082R.id.start_ll);
            c1102c.f3694d = (TextView) view.findViewById(C2279R.id.time);
            c1102c.f3696f = (TextView) view.findViewById(C1082R.id.tv_love);
            c1102c.f3697g = (LinearLayout) view.findViewById(C1082R.id.ll_reply);
            c1102c.f3698h = (TextView) view.findViewById(C1082R.id.tv_reply);
            c1102c.f3699i = (LinearLayout) view.findViewById(C1082R.id.ll_reply_root);
            c1102c.f3701k = (LinearLayout) view.findViewById(C1082R.id.start_ll_child);
            c1102c.f3702l = (LinearLayout) view.findViewById(C1082R.id.luobo_container_child);
            c1102c.f3703m = (TextView) view.findViewById(C1082R.id.tv_reply_icon);
            view.setTag(c1102c);
        } else {
            c1102c = (C1102c) view.getTag();
        }
        if (i2 + 1 > this.f3708c.size()) {
            return new View(this.f3706a);
        }
        if (((C1101b) this.f3708c.get(i2)).f3690b.size() < i + 1) {
            return new View(this.f3706a);
        }
        C1522c c1522c = (C1522c) ((C1101b) this.f3708c.get(i2)).f3690b.get(i);
        CommentReplyModel j = c1522c.m6058j();
        m4855a(c1102c, c1522c.m6057i());
        c1102c.f3695e.removeAllViews();
        c1102c.f3702l.removeAllViews();
        c1102c.f3694d.setText(this.f3707b.format(new Date(((long) c1522c.m6054f()) * 1000)));
        m4858a(c1522c, c1102c);
        if (!Utils.getLocalLanguage(this.f3706a).equals("CN") || C1503b.m5915c().m5954k() == 1) {
            c1102c.f3691a.setText(c1522c.m6055g());
        } else {
            c1102c.f3691a.setText(c1522c.m6056h());
        }
        c1102c.f3696f.setText(c1522c.m6050b() + BuildConfig.FLAVOR);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        Object obj = BuildConfig.FLAVOR;
        if ("PAGE_COMMENT".equals(this.f3716k)) {
            if (j != null) {
                obj = this.f3706a.getString(C1082R.string.reply) + "@" + j.getRegion() + this.f3706a.getString(C1082R.string.colon);
            }
        } else if ("PAGE_MY_SEND".equals(this.f3716k)) {
            if (j != null) {
                obj = this.f3706a.getString(C1082R.string.reply) + "@" + j.getRegion() + this.f3706a.getString(C1082R.string.colon);
            }
        } else if ("PAGE_MY_RECEIVE".equals(this.f3716k)) {
            obj = this.f3706a.getString(C1082R.string.reply_your_comment) + this.f3706a.getString(C1082R.string.colon);
        }
        spannableStringBuilder.append(obj);
        spannableStringBuilder.append(c1522c.m6053e());
        spannableStringBuilder.setSpan(this.f3715j, 0, obj.length(), 33);
        c1102c.f3692b.setText(spannableStringBuilder);
        if (j == null) {
            c1102c.f3697g.setVisibility(8);
        } else {
            c1102c.f3697g.setVisibility(0);
            spannableStringBuilder = new SpannableStringBuilder();
            obj = BuildConfig.FLAVOR;
            if ("PAGE_COMMENT".equals(this.f3716k)) {
                obj = "@" + j.getRegion() + this.f3706a.getString(C1082R.string.colon);
            } else if ("PAGE_MY_SEND".equals(this.f3716k)) {
                obj = j.getRegion() + this.f3706a.getString(C1082R.string.colon);
            } else if ("PAGE_MY_RECEIVE".equals(this.f3716k)) {
                obj = "@" + this.f3706a.getString(C1082R.string.my) + this.f3706a.getString(C1082R.string.colon);
            }
            spannableStringBuilder.append(obj);
            spannableStringBuilder.append(j.getContent());
            spannableStringBuilder.setSpan(this.f3715j, 0, obj.length(), 33);
            c1102c.f3698h.setText(spannableStringBuilder);
        }
        Drawable drawable;
        if (c1522c.m6049a()) {
            drawable = this.f3706a.getResources().getDrawable(C1082R.drawable.heart_red);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c1102c.f3696f.setCompoundDrawables(drawable, null, null, null);
        } else {
            drawable = this.f3706a.getResources().getDrawable(C1082R.drawable.heart);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            c1102c.f3696f.setCompoundDrawables(drawable, null, null, null);
        }
        if (!this.f3713h) {
            return view;
        }
        c1102c.f3699i.setOnClickListener(new C10921(this, c1102c, c1522c));
        c1102c.f3703m.setOnClickListener(new C10932(this, c1522c));
        c1102c.f3697g.setOnClickListener(new C10943(this, c1102c, c1522c));
        c1102c.f3696f.setOnClickListener(new C10974(this, c1522c, c1102c));
        return view;
    }
}
