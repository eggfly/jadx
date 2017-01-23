package com.aide.ui.trainer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aide.common.x;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.trainer.c.c;
import java.util.ArrayList;
import java.util.List;

public class d {

    static class 1 implements OnClickListener {
        final /* synthetic */ c DW;
        final /* synthetic */ y j6;

        1(y yVar, c cVar) {
            this.j6 = yVar;
            this.DW = cVar;
        }

        public void onClick(View view) {
            this.j6.j6(this.DW);
        }
    }

    static class 2 implements OnClickListener {
        final /* synthetic */ Runnable j6;

        2(Runnable runnable) {
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    static class 3 implements OnClickListener {
        final /* synthetic */ Runnable j6;

        3(Runnable runnable) {
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    static class 4 implements OnClickListener {
        final /* synthetic */ c DW;
        final /* synthetic */ y j6;

        4(y yVar, c cVar) {
            this.j6 = yVar;
            this.DW = cVar;
        }

        public void onClick(View view) {
            this.j6.j6(this.DW);
        }
    }

    static class 5 implements OnClickListener {
        final /* synthetic */ Runnable j6;

        5(Runnable runnable) {
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    static class 6 implements OnClickListener {
        final /* synthetic */ Runnable j6;

        6(Runnable runnable) {
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    public static void j6(LinearLayout linearLayout, List<c> list, boolean z, boolean z2, y<c> yVar, Runnable runnable, Runnable runnable2, Runnable runnable3, Runnable runnable4) {
        linearLayout.removeAllViews();
        List<c> arrayList = new ArrayList();
        List<c> arrayList2 = new ArrayList();
        for (c cVar : list) {
            if (cVar.Ws()) {
                arrayList.add(cVar);
            } else {
                arrayList2.add(cVar);
            }
        }
        j6(linearLayout, R.f.trainer_option_learn);
        int i = 0;
        for (c cVar2 : arrayList) {
            int i2;
            j6(linearLayout, cVar2.u7(), cVar2.VH()[0], cVar2.VH()[1]).setOnClickListener(new 1(yVar, cVar2));
            if (z) {
                i2 = i + 1;
                if (i2 >= 2) {
                    break;
                }
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (z && arrayList.size() > 2) {
            j6(linearLayout, R.drawable.ic_menu_moreoverflow_normal_holo_light, R.f.trainer_option_learn_more).setOnClickListener(new 2(runnable));
        } else if (runnable2 != null && arrayList2.size() > 0) {
            if (z2) {
                j6(linearLayout, R.drawable.ic_menu_moreoverflow_normal_holo_light, R.f.trainer_option_learn_other).setOnClickListener(new 3(runnable2));
            } else {
                for (c cVar22 : arrayList2) {
                    j6(linearLayout, cVar22.u7(), cVar22.VH()[0], cVar22.VH()[1]).setOnClickListener(new 4(yVar, cVar22));
                }
            }
        }
        if (!(runnable4 == null || com.aide.common.d.DW(linearLayout.getContext()))) {
            j6(linearLayout, R.f.trainer_option_interact);
            j6(linearLayout, R.drawable.community_googleplus, R.f.trainer_option_interact_gplus_community).setOnClickListener(new 5(runnable4));
        }
        if (!e.v5()) {
            j6(linearLayout, R.f.trainer_option_code);
            j6(linearLayout, R.drawable.ic_launcher, R.f.trainer_option_code_for_experts).setOnClickListener(new 6(runnable3));
        }
    }

    private static View j6(LinearLayout linearLayout, int i) {
        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.c.trainer_course_list_header, null);
        ((TextView) inflate.findViewById(R.b.trainerCourseListHeaderText)).setText(i);
        linearLayout.addView(inflate);
        return inflate;
    }

    private static View j6(LinearLayout linearLayout, int i, int i2) {
        String string = linearLayout.getResources().getString(i2);
        return j6(linearLayout, i, string.split(" ")[0], string.split(" ")[1]);
    }

    private static View j6(LinearLayout linearLayout, int i, String str, String str2) {
        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.c.trainer_course_list_entry, null);
        ((ImageView) inflate.findViewById(R.b.trainerCourseListEntryLogo)).setImageDrawable(new x(linearLayout.getContext(), i, new String[]{str, str2}));
        linearLayout.addView(inflate);
        return inflate.findViewById(R.b.trainerCourseListEntryLayout);
    }
}
