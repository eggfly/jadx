import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.text.Html;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.ui.R;
import com.aide.ui.e;

public class nw extends m {
    private AlertDialog j6;

    protected Dialog j6(Activity activity) {
        CharSequence fromHtml = Html.fromHtml(e.a8().XL());
        View textView = new TextView(activity);
        textView.setPadding((int) (activity.getResources().getDisplayMetrics().density * 10.0f), (int) (activity.getResources().getDisplayMetrics().density * 10.0f), (int) (activity.getResources().getDisplayMetrics().density * 10.0f), (int) (activity.getResources().getDisplayMetrics().density * 10.0f));
        textView.setText(fromHtml);
        View scrollView = new ScrollView(activity);
        scrollView.addView(textView);
        Builder builder = new Builder(activity);
        builder.setView(scrollView).setCancelable(true).setPositiveButton(R.f.dialog_ok, new nw$2(this)).setNeutralButton(R.f.dialog_project_properties_build_variants, new nw$1(this));
        builder.setTitle(activity.getResources().getString(R.f.dialog_project_properties_title, new Object[]{"'" + qh.Zo(e.a8().u7()) + "'"}));
        this.j6 = builder.create();
        return this.j6;
    }
}
