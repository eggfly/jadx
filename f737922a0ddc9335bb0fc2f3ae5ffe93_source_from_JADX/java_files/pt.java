import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.SoundPool;
import android.os.Handler;
import com.aide.common.TextToSpeechHelper;
import com.aide.common.d;
import com.aide.common.m;
import com.aide.common.v;
import com.aide.ui.R;
import com.aide.ui.activities.TrainerCourseActivity;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.ui.trainer.TrainerNotificationAlarmReceiver;
import com.aide.ui.trainer.TrainerState;
import com.aide.ui.trainer.c;
import com.aide.ui.trainer.c.a;
import com.aide.ui.trainer.c.f;
import com.aide.ui.trainer.c.g;
import com.aide.ui.trainer.c.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pt {
    private Map<String, String> DW;
    private a EQ;
    private SoundPool FH;
    private int Hw;
    private int VH;
    private int Zo;
    private int gn;
    private TrainerState j6;
    private c tp;
    private TextToSpeechHelper u7;
    private int v5;

    public void j6(String str, String str2) {
        e.EQ().j6(str, str2, v5(e.QX().gW().tp()));
    }

    public void j6() {
        this.tp = new c();
        this.j6 = new TrainerState();
        KD();
    }

    private void SI() {
        new Handler().postDelayed(new pt$1(this), 1000);
    }

    private void KD() {
        String j6 = this.tp.j6(this.j6.getCurrentLessonId());
        if (!j6.equals(this.j6.getCurrentLessonId())) {
            this.j6.startLesson(j6);
        }
    }

    public void j6(String str) {
        this.j6.startLesson(this.tp.DW(str));
        KD();
    }

    public void j6(i iVar) {
        this.j6.startLesson(iVar.XL());
    }

    public void DW() {
        this.FH = new SoundPool(1, 3, 0);
        this.Hw = this.FH.load(e.gn(), R.e.fail, 1);
        this.v5 = this.FH.load(e.gn(), R.e.success_task, 1);
        this.Zo = this.FH.load(e.gn(), R.e.success_lesson, 1);
        this.VH = this.FH.load(e.gn(), R.e.task, 1);
        this.gn = this.FH.load(e.gn(), R.e.click, 1);
        SI();
        ro();
        cn();
        if (!e.EQ().j6(e.gn())) {
            if (this.j6.getCurrentExercise() == 0) {
                vJ();
            }
            if (h.QX()) {
                this.u7.j6(gW().j6(), gW().EQ());
            }
            if (h.XL()) {
                this.FH.play(this.VH, 1.0f, 1.0f, 0, 0, 1.0f);
            }
            VH(yS());
            Sf();
        }
    }

    private void ro() {
        this.EQ = this.tp.FH(this.j6.getCurrentLessonId());
        this.u7 = new TextToSpeechHelper(e.gn());
    }

    private void cn() {
        try {
            e.u7().OW();
            c.h j6 = yS().j6();
            String Zo = Zo(yS());
            this.DW = new HashMap();
            InputStream DW = this.EQ.DW(j6.FH() + ".zip");
            this.DW.putAll(e.vy().j6(DW, Zo, j6.Hw(), g3(), j6.j6()));
            DW.close();
            if (j6.DW().length() > 0) {
                DW = this.EQ.DW(j6.DW() + ".zip");
                this.DW.putAll(e.vy().j6(DW, Zo, j6.Hw(), g3(), j6.j6()));
                DW.close();
            }
            if (j6.Zo().length() > 0) {
                Zo = Zo + "/" + j6.Zo();
            }
            e.a8().j6(Zo, false);
            for (String str : j6.j6()) {
                e.j3().j6((String) this.DW.get(str), false);
            }
        } catch (Exception e) {
            if (this.DW == null) {
                this.DW = new HashMap();
            }
            m.j6(e.u7(), "Lesson error", e.toString());
        }
    }

    private String Zo(i iVar) {
        return (e.er().DW() + "/Lessons/") + iVar.XL();
    }

    public boolean FH() {
        return yS().j6().j6().size() > 1;
    }

    public void Hw() {
        c cVar = this.tp;
        DW(c.Hw(), e.j6((int) R.f.trainer_on_build_errors, new Object[0]));
    }

    public void v5() {
        c cVar = this.tp;
        DW(c.Hw(), e.j6((int) R.f.trainer_on_no_main, new Object[0]));
    }

    public void DW(String str) {
        if (h.QX()) {
            TextToSpeechHelper textToSpeechHelper = this.u7;
            c cVar = this.tp;
            textToSpeechHelper.j6(c.Hw(), str);
        }
    }

    public void Zo() {
        if (h.XL()) {
            this.FH.play(this.gn, 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public void VH() {
        if (h.XL()) {
            this.FH.play(this.v5, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        if (h.QX()) {
            this.u7.j6(gW().j6(), gW().u7());
        }
    }

    public void gn() {
        this.j6.restartLesson(yS());
        sh();
    }

    public void j6(i iVar, boolean z) {
        if (z) {
            this.j6.restartLesson(iVar);
            try {
                qh.j3(Zo(iVar));
            } catch (IOException e) {
            }
        }
        if (e.VH()) {
            if (iVar.gn().equals(this.EQ)) {
                this.j6.startLesson(iVar.XL());
            } else {
                this.j6.startLesson(iVar.XL());
                ro();
            }
            sh();
            return;
        }
        e.u7().j6(true, null, iVar);
    }

    private void sh() {
        e.u7().sh().postDelayed(new pt$2(this), 100);
    }

    private boolean cb() {
        if (this.j6.getCurrentExercise() + 1 < yS().DW()) {
            return false;
        }
        i dx = dx();
        if (dx == null || !dx.j3() || e.Mr().XL()) {
            return false;
        }
        return true;
    }

    private i dx() {
        int i;
        int i2 = 0;
        g yS = yS();
        a er = er();
        for (i = 0; i < yS.aM(); i++) {
            i j6 = er.j6(i);
            if (!this.j6.isLessonInProgress(j6) && DW(j6)) {
                return j6;
            }
        }
        for (i = yS.aM() + 1; i < er.Hw(); i++) {
            j6 = er.j6(i);
            if (!this.j6.isLessonInProgress(j6)) {
                return j6;
            }
        }
        for (i = 0; i < er.Hw(); i++) {
            j6 = er.j6(i);
            if (!this.j6.isLessonInProgress(j6)) {
                return j6;
            }
        }
        while (i2 < er.Hw()) {
            i j62 = er.j6(i2);
            if (!this.j6.isLessonFinished(j62)) {
                return j62;
            }
            i2++;
        }
        return null;
    }

    public void u7() {
        if (cb()) {
            TrainerCourseActivity.j6(e.u7());
        } else if (this.j6.getCurrentExercise() + 1 >= yS().DW()) {
            i dx = dx();
            if (dx == null) {
                TrainerCourseActivity.j6(e.u7());
                return;
            }
            this.j6.startLesson(dx.XL());
            sh();
        } else {
            int i = (gW().VH() || gW().XL()) ? 1 : 0;
            this.j6.startNextExercise();
            if (QX()) {
                this.j6.setLessonFinished(yS());
                i dx2 = dx();
                if (dx2 != null) {
                    VH(dx2);
                }
            }
            if (h.QX()) {
                this.u7.j6(gW().j6(), gW().EQ());
            }
            if (h.XL()) {
                if (QX()) {
                    this.FH.play(this.Zo, 1.0f, 1.0f, 0, 0, 1.0f);
                } else if (i != 0) {
                    this.FH.play(this.VH, 1.0f, 1.0f, 0, 0, 1.0f);
                } else {
                    this.FH.play(this.v5, 1.0f, 1.0f, 0, 0, 1.0f);
                }
            }
            vJ();
            Sf();
        }
    }

    private void VH(i iVar) {
        if (!e.Mr().XL() && !e.Mr().gn()) {
            TrainerNotificationAlarmReceiver.j6(e.gn(), 86400000, 4, iVar.gn().u7(), "", e.j6((int) R.f.trainer_notification_title, iVar.QX()), e.gn().getResources().getString(R.f.trainer_notification_text, new Object[]{iVar.gn().VH()[0] + " " + iVar.gn().VH()[1]}));
        }
    }

    public void tp() {
        this.j6.retryCurrentExercise(gW().J8());
        if (h.XL()) {
            this.FH.play(this.VH, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        Sf();
        sG();
    }

    private void sG() {
        if (this.j6.showSkipLesson(yS()) && e.Mr().XL() && dx() != null) {
            com.aide.analytics.a.DW("Skip Lesson Dialog Shown");
            v.DW(e.u7(), e.j6((int) R.f.trainer_ask_a_question, new Object[0]), e.j6((int) R.f.trainer_ask_a_question_message_2, new Object[0]), new pt$3(this));
        }
    }

    public void EQ() {
        if (QX()) {
            this.j6.runCurrentExercise();
            e.j3().j6(false, false);
            e.a8().j6(false);
            return;
        }
        J0();
    }

    public boolean we() {
        return !QX() && gW().VH();
    }

    public void J0() {
        e.j3().j6(!we());
        if (!ef()) {
            return;
        }
        if (gW().XL() && e.u7().sh().Hw(Ws())) {
            c cVar = this.tp;
            DW(c.Hw(), e.j6((int) R.f.trainer_on_arrow_pending, new Object[0]));
        } else if (we()) {
            com.aide.analytics.a.DW("Exercise was run: " + e.QX().P8());
            this.j6.runCurrentExercise();
            e.j3().j6(false, false);
            e.a8().j6(false);
        } else if (cb()) {
            e.Mr().j6(e.u7(), 14, (int) R.f.shop_feature_lessons_and_updates, "continueToNextLessonInCourse:" + er().gn(), false);
        } else if (this.j6.getCurrentExercise() + 1 >= yS().DW() && yS().j3() && !this.j6.exerciseHasRun()) {
            m.j6(e.u7(), e.j6((int) R.f.trainer_next_lesson, new Object[0]), e.j6((int) R.f.trainer_next_lesson_no_changes_message, new Object[0]), new pt$4(this), null, null);
        } else if (this.j6.getCurrentExercise() + 1 >= yS().DW() && yS().VH() && !d.j6() && !d.DW(e.gn())) {
            e.u7().j6(e.j6((int) R.f.trainer_rate_title, new Object[0]), e.j6((int) R.f.trainer_rate_message, new Object[0]), new pt$5(this));
        } else if (this.j6.getCurrentExercise() + 1 < yS().DW() || !yS().Zo() || d.DW(e.gn())) {
            u7();
        } else {
            v.DW(e.u7(), e.j6((int) R.f.trainer_share_title, new Object[0]), e.gn().getResources().getString(R.f.trainer_share_message, new Object[]{yS().FH().j6(), J8()}), "https://play.google.com/store/apps/details?id=" + e.j6, new pt$6(this));
        }
    }

    public String J8() {
        try {
            PackageManager packageManager = e.gn().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(e.gn().getApplicationInfo().packageName, 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    private boolean ef() {
        String str;
        List<String> Hw = e.j3().DW(Ws()).Hw();
        List<String> arrayList = new ArrayList();
        for (String str2 : Hw) {
            arrayList.add(str2.replace(" ", "").replace("\t", ""));
        }
        int i = 0;
        while (i < gW().QX()) {
            c.e DW = gW().DW(i);
            String replace = DW.DW().replace(" ", "").replace("\t", "");
            int Hw2 = DW.Hw();
            int FH = DW.FH();
            int j6 = DW.j6();
            int i2 = 0;
            int i3 = 1;
            for (String str22 : arrayList) {
                if (str22.length() > 0 && i3 >= FH && i3 <= j6) {
                    if (str22.contains(replace)) {
                        i2++;
                    } else if (replace.startsWith(str22)) {
                        Object obj;
                        String substring = replace.substring(str22.length());
                        for (int i4 = i3; i4 < arrayList.size(); i4++) {
                            str22 = (String) arrayList.get(i4);
                            if (str22.length() != 0) {
                                if (!str22.startsWith(substring)) {
                                    if (!substring.startsWith(str22)) {
                                        break;
                                    }
                                    substring = substring.substring(str22.length());
                                    if (substring.length() == 0) {
                                        obj = 1;
                                        break;
                                    }
                                } else {
                                    obj = 1;
                                    break;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            i2++;
                        }
                    }
                }
                i3++;
            }
            if (!(Hw2 == -1 && i2 == 0) && (Hw2 < 0 || i2 == Hw2)) {
                i++;
            } else {
                DW(gW().j6(), DW.v5());
                return false;
            }
        }
        return true;
    }

    private void DW(String str, String str2) {
        this.j6.retryCurrentExercise(str2, gW().J8());
        if (h.XL()) {
            this.FH.play(this.Hw, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        if (h.QX()) {
            this.u7.j6(str, str2);
        }
        Sf();
        sG();
    }

    private void Sf() {
        boolean z;
        boolean z2 = true;
        e.u7().u7();
        String str = "";
        if (this.j6.getCurrentExercise() == 0) {
            str = str + yS().we() + " ";
        }
        String str2 = str + gW().EQ();
        if (this.j6.showHintForCurrentExercise()) {
            str2 = str2 + " " + gW().v5();
        }
        String aM = aM();
        String str3 = "\ud83d\ude1e";
        String str4 = null;
        if (this.j6.showErrorForCurrentExercise()) {
            str4 = this.j6.getCurrentExerciseErrorText();
        }
        String Ws = Ws();
        String lg = lg();
        int FH = gW().FH();
        boolean z3 = !gW().XL();
        int currentExercise = ((this.j6.getCurrentExercise() + 1) * 100) / Math.max(1, yS().DW());
        if (this.j6.getCurrentExercise() == 0 && DW(yS())) {
            z = true;
        } else {
            z = false;
        }
        if (this.j6.getCurrentExercise() != 0 || FH >= 0 || yS().DW() <= 1) {
            z2 = false;
        }
        e.u7().sh().j6(Ws, aM, currentExercise, z, str2, lg, z2, str3, str4, FH, z3);
    }

    private void vJ() {
        List arrayList = new ArrayList();
        for (int i = 0; i < gW().Ws(); i++) {
            f j6 = gW().j6(i);
            String j62 = j6.j6();
            if (this.DW.containsKey(j62)) {
                j62 = (String) this.DW.get(j62);
            } else {
                j62 = Ws();
            }
            String replace = j6.DW().replace("$package_name$", g3()).replace("$project_name$", yS().j6().Hw());
            e.u7().sh().j6(j62, replace, "$code_hint$", "$code_hint_1$", "$code_hint_2$", "$code_hint_3$", "$code_hint_4$", "$code_hint_5$", "$code_hint_6$", "$code_hint_7$", "$code_hint_8$", "$code_hint_9$", "$code_hint_10$");
            arrayList.add(j62);
        }
        if (arrayList.size() > 0) {
            e.a8().j6(arrayList, false);
        }
    }

    private String g3() {
        return "com.aide.trainer." + yS().j6().v5();
    }

    public String Ws() {
        String v5 = v5(gW().DW());
        return v5.length() > 0 ? v5 : v5((String) yS().j6().j6().get(0));
    }

    private String v5(String str) {
        if (this.DW.containsKey(str)) {
            return (String) this.DW.get(str);
        }
        return "";
    }

    public boolean QX() {
        return this.EQ != null && this.j6.getCurrentExercise() >= yS().DW() - 1;
    }

    public String XL() {
        return "\ud83d\ude1e";
    }

    public String aM() {
        if (!QX() || yS().DW() <= 1) {
            return yS().QX();
        }
        return Mz();
    }

    public String j3() {
        return "\u226a " + e.j6((int) R.f.trainer_try_again, new Object[0]);
    }

    public String Mr() {
        return e.j6((int) R.f.trainer_press_back, new Object[0]) + " \u21a9";
    }

    public String U2() {
        if (QX()) {
            return e.j6((int) R.f.trainer_continue, new Object[0]) + " \u226b";
        }
        if (QX()) {
            return e.j6((int) R.f.trainer_next_lesson, new Object[0]) + " \u226b";
        }
        return e.j6((int) R.f.trainer_next_exercise, new Object[0]) + " \u226b";
    }

    public String a8() {
        if (this.EQ == null) {
            return null;
        }
        if (QX() || gW().VH()) {
            return e.j6((int) R.f.trainer_run, new Object[0]);
        }
        return e.j6((int) R.f.trainer_continue, new Object[0]);
    }

    public String lg() {
        if (QX()) {
            return e.j6((int) R.f.trainer_next_lesson, new Object[0]) + " \u226b";
        }
        if (!we()) {
            return e.j6((int) R.f.trainer_continue, new Object[0]) + " \u226b";
        }
        String j6 = e.j6((int) R.f.trainer_run, new Object[0]);
        if (this.j6.getCurrentExercise() == 0 && d.FH(e.gn())) {
            j6 = j6 + " (Ctrl+E)";
        }
        return j6 + " \u25ba";
    }

    public boolean FH(String str) {
        return QX() || str.equals(e.QX().Ws());
    }

    public String rN() {
        return "\ud83d\ude03";
    }

    private String Mz() {
        return yS().QX() + "  " + j6(this.j6.calculateLessonAverageFailures(yS()));
    }

    private String j6(float f) {
        int floor = (int) Math.floor((double) Math.max(0.0f, 3.0f - (1.5f * f)));
        String str = "";
        int i = 0;
        while (i < floor) {
            i++;
            str = str + "\u2605";
        }
        while (floor < 3) {
            str = str + "\u2606";
            floor++;
        }
        return str;
    }

    public boolean DW(i iVar) {
        if (this.j6.isLessonFinished(iVar)) {
            return false;
        }
        Date tp = iVar.tp();
        if (tp == null || System.currentTimeMillis() - tp.getTime() >= 5184000000L) {
            return false;
        }
        return true;
    }

    public boolean FH(i iVar) {
        return this.j6.isLessonInProgress(iVar);
    }

    public boolean Hw(i iVar) {
        return this.j6.isLessonFinished(iVar);
    }

    public String v5(i iVar) {
        return j6(this.j6.getLessonAverageFailures(iVar));
    }

    public a er() {
        return this.EQ;
    }

    public g yS() {
        return er().j6(this.j6.getCurrentLessonId());
    }

    public c.d gW() {
        return yS().j6(this.j6.getCurrentExercise());
    }

    public List<c.c> BT() {
        return this.tp.FH();
    }

    public boolean vy() {
        for (c.c Ws : BT()) {
            if (Ws.Ws()) {
                return true;
            }
        }
        return false;
    }

    public String P8() {
        return yS().XL() + " " + this.j6.getCurrentExercise();
    }

    public String ei() {
        return this.tp.j6();
    }

    public c.c Hw(String str) {
        return this.tp.Hw(str);
    }

    public c.c nw() {
        return Hw(this.tp.DW());
    }
}
