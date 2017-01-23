package com.aide.uidesigner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.aide.appwizard.AppWizardDesignActivity;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k {

    static class 1 extends m {
        final /* synthetic */ String DW;
        final /* synthetic */ boolean FH;
        final /* synthetic */ y Hw;
        final /* synthetic */ List j6;

        class 1 implements OnChildClickListener {
            final /* synthetic */ 1 DW;
            final /* synthetic */ AlertDialog j6;

            1(1 1, AlertDialog alertDialog) {
                this.DW = 1;
                this.j6 = alertDialog;
            }

            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                this.j6.dismiss();
                a aVar = (a) ((List) this.DW.j6.get(i)).get(i2);
                Map hashMap = new HashMap();
                hashMap.putAll(aVar.j6());
                if (this.DW.FH) {
                    if (!hashMap.containsKey("android:layout_width")) {
                        hashMap.put("android:layout_width", "match_parent");
                    }
                    if (!hashMap.containsKey("android:layout_height")) {
                        hashMap.put("android:layout_height", "match_parent");
                    }
                } else {
                    if (!hashMap.containsKey("android:layout_width")) {
                        hashMap.put("android:layout_width", "wrap_content");
                    }
                    if (!hashMap.containsKey("android:layout_height")) {
                        hashMap.put("android:layout_height", "wrap_content");
                    }
                }
                this.DW.Hw.j6(new b(aVar.DW(), hashMap));
                return true;
            }
        }

        1(List list, String str, boolean z, y yVar) {
            this.j6 = list;
            this.DW = str;
            this.FH = z;
            this.Hw = yVar;
        }

        public Dialog j6(Activity activity) {
            View expandableListView = new ExpandableListView(activity);
            expandableListView.setAdapter(new b(activity, this.j6));
            Dialog create = new Builder(activity).setCancelable(true).setView(expandableListView).setTitle(this.DW).create();
            expandableListView.setOnChildClickListener(new 1(this, create));
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    private interface c {
        View j6(Context context);
    }

    private enum a {
        Button("Button", "Widget", new 1(), "Button", "android:text", "Button"),
        ButtonSmall("Button (small)", "Widget", new 12(), "Button", "style", "?android:attr/buttonStyleSmall", "android:text", "Small Button"),
        ImageButton("ImageButton", "Widget", new 14(), "ImageButton", "android:src", "@android:drawable/ic_menu_close_clear_cancel"),
        BarButton("Bar Button", "Widget", new 15(), "Button", "style", "?android:attr/buttonBarButtonStyle", "android:text", "Bar Button"),
        BarImageButton("BarImageButton", "Widget", new 16(), "ImageButton", "style", "?android:attr/buttonBarButtonStyle", "android:src", "@android:drawable/ic_menu_close_clear_cancel"),
        ToggleButton("ToggleButton", "Widget", new 17()),
        Switch("Switch", "Widget", new 18()),
        CheckBox("CheckBox", "Widget", new 19()),
        RadioButton("RadioButton", "Widget", new 20()),
        SeekBar("SeekBar", "Widget", new 2()),
        TextView("TextView", "View", new 3(), "TextView", "android:text", "Text"),
        TextViewSmall("TextView (small)", "View", new 4(), "TextView", "android:textAppearance", "?android:attr/textAppearanceSmall", "android:text", "Small Text"),
        TextViewMedium("TextView (medium)", "View", new 5(), "TextView", "android:textAppearance", "?android:attr/textAppearanceMedium", "android:text", "Medium Text"),
        TextViewLarge("TextView (large)", "View", new 6(), "TextView", "android:textAppearance", "?android:attr/textAppearanceLarge", "android:text", "Large Text"),
        DividerVertical("Vertical Divider", "View", new 7(), "View", "android:background", "?android:attr/dividerVertical", "android:layout_height", "1dp", "android:layout_width", "match_parent"),
        DividerHorizontal("Horizontal Divider", "View", new 8(), "View", "android:background", "?android:attr/dividerHorizontal", "android:layout_width", "1dp", "android:layout_height", "match_parent"),
        ImageView("ImageView", "View", new 9(), "ImageView", "android:src", "@android:drawable/ic_delete"),
        ProgressBar("ProgressBar", "View", new 10()),
        ProgressBarLarge("ProgressBar (large)", "View", new 11(), "ProgressBar", "style", "?android:attr/progressBarStyleLarge"),
        ProgressBarHorizontal("ProgressBar (horizontal)", "View", new 13(), "ProgressBar", "style", "?android:attr/progressBarStyleHorizontal"),
        EditText("EditText", "Text Field", "EditText", "android:ems", "10"),
        EditTextMultiLine("EditText (multiline)", "Text Field", "EditText", "android:inputType", "textMultiLine", "android:ems", "10"),
        EditTextPassword("EditText (password)", "Text Field", "EditText", "android:inputType", "textPassword", "android:ems", "10"),
        EditTextNumberPassword("EditText (number password)", "Text Field", "EditText", "android:inputType", "numberPassword", "android:ems", "10"),
        EditTextEMail("EditText (email)", "Text Field", "EditText", "android:inputType", "textEmailAddress", "android:ems", "10"),
        EditTextPasswordName("EditText (name)", "Text Field", "EditText", "android:inputType", "textPersonName", "android:ems", "10"),
        EditTextPasswordPhone("EditText (phone)", "Text Field", "EditText", "android:inputType", "phone", "android:ems", "10"),
        EditTextAddress("EditText (address)", "Text Field", "EditText", "android:inputType", "textPostalAddress", "android:ems", "10"),
        EditTextTime("EditText (time)", "Text Field", "EditText", "android:inputType", "time", "android:ems", "10"),
        EditTextDate("EditText (date)", "Text Field", "EditText", "android:inputType", "date", "android:ems", "10"),
        EditTextNumber("EditText (number)", "Text Field", "EditText", "android:inputType", "number", "android:ems", "10"),
        EditTextNumberSigned("EditText (signed number)", "Text Field", "EditText", "android:inputType", "numberSigned", "android:ems", "10"),
        EditTextDecimal("EditText (decimal)", "Text Field", "EditText", "android:inputType", "numberDecimal", "android:ems", "10"),
        DatePicker("DatePicker", "Advanced Widget"),
        TimePicker("TimePicker", "Advanced Widget"),
        NumberPicker("NumberPicker", "Advanced Widget"),
        RatingBar("RatingBar", "Advanced Widget"),
        ListView("List View", "Adapter View", "ListView", new String[0]),
        ExpandableListView("Expandable List View", "Adapter View", "ExpandableListView", new String[0]),
        Spinner("Spinner", "Adapter View"),
        RelativeLayout("RelativeLayout", "Layout"),
        LinearLayoutH("LinearLayout (horizontal)", "Layout", "LinearLayout", "android:orientation", "horizontal"),
        LinearLayoutV("LinearLayout (vertical)", "Layout", "LinearLayout", "android:orientation", "vertical"),
        ScrollView("ScrollView", "Scroll View"),
        HorizontalScrollView("HorizontalScrollView", "Scroll View"),
        ButtonBar("Button Bar", "Advanced Layout", "LinearLayout", "style", "?android:attr/buttonBarStyle", "android:orientation", "horizontal"),
        GridLayout("GridLayout", "Advanced Layout", "GridLayout", "rowCount", "1", "columnCount", "1"),
        FrameLayout("FrameLayout", "Advanced Layout"),
        RadioGroup("RadioGroup", "Advanced Layout", "RadioGroup", "android:orientation", "vertical"),
        TableLayout("TableLayout", "Advanced Layout"),
        TableRow("TableRow", "Advanced Layout"),
        AbsoluteLayout("AbsoluteLayout", "Advanced Layout"),
        DrawerLayout("Drawer Layout", "App Layout", "android.support.v4.widget.DrawerLayout", new String[0]),
        ViewPager("View Pager", "App Layout", "android.support.v4.widget.ViewPager", new String[0]);
        
        private Map<String, String> XG;
        private String XX;
        private c jJ;
        private String kQ;
        private String yO;

        static class 10 implements c {
            10() {
            }

            public View j6(Context context) {
                return new ProgressBar(context);
            }
        }

        static class 11 implements c {
            11() {
            }

            public View j6(Context context) {
                return new ProgressBar(context, null, 16842874);
            }
        }

        static class 12 implements c {
            12() {
            }

            public View j6(Context context) {
                View button = new Button(context, null, 16842825);
                button.setText("Small Button");
                button.setFocusable(false);
                return button;
            }
        }

        static class 13 implements c {
            13() {
            }

            public View j6(Context context) {
                View progressBar = new ProgressBar(context, null, 16842872);
                progressBar.setMax(100);
                progressBar.setProgress(50);
                return progressBar;
            }
        }

        static class 14 implements c {
            14() {
            }

            public View j6(Context context) {
                View imageButton = new ImageButton(context);
                imageButton.setImageResource(17301560);
                imageButton.setFocusable(false);
                return imageButton;
            }
        }

        static class 15 implements c {
            15() {
            }

            public View j6(Context context) {
                View button = new Button(context, null, 16843567);
                button.setText("Bar Button");
                button.setFocusable(false);
                return button;
            }
        }

        static class 16 implements c {
            16() {
            }

            public View j6(Context context) {
                View imageButton = new ImageButton(context, null, 16843567);
                imageButton.setImageResource(17301560);
                imageButton.setFocusable(false);
                return imageButton;
            }
        }

        static class 17 implements c {
            17() {
            }

            public View j6(Context context) {
                View toggleButton = new ToggleButton(context);
                toggleButton.setFocusable(false);
                return toggleButton;
            }
        }

        static class 18 implements c {
            18() {
            }

            public View j6(Context context) {
                View view = new Switch(context);
                view.setFocusable(false);
                return view;
            }
        }

        static class 19 implements c {
            19() {
            }

            public View j6(Context context) {
                View checkBox = new CheckBox(context);
                checkBox.setFocusable(false);
                checkBox.setText("CheckBox");
                return checkBox;
            }
        }

        static class 1 implements c {
            1() {
            }

            public View j6(Context context) {
                View button = new Button(context);
                button.setText("Button");
                button.setFocusable(false);
                return button;
            }
        }

        static class 20 implements c {
            20() {
            }

            public View j6(Context context) {
                View radioButton = new RadioButton(context);
                radioButton.setFocusable(false);
                radioButton.setText("RadioButton");
                return radioButton;
            }
        }

        static class 2 implements c {
            2() {
            }

            public View j6(Context context) {
                View seekBar = new SeekBar(context);
                seekBar.setFocusable(false);
                View linearLayout = new LinearLayout(context);
                linearLayout.addView(seekBar, new LayoutParams((int) (150.0f * context.getResources().getDisplayMetrics().density), -2));
                return linearLayout;
            }
        }

        static class 3 implements c {
            3() {
            }

            public View j6(Context context) {
                View textView = new TextView(context);
                textView.setText("Text");
                return textView;
            }
        }

        static class 4 implements c {
            4() {
            }

            public View j6(Context context) {
                View textView = new TextView(context);
                textView.setText("Small Text");
                k.DW(textView, 16842818);
                return textView;
            }
        }

        static class 5 implements c {
            5() {
            }

            public View j6(Context context) {
                View textView = new TextView(context);
                textView.setText("Medium Text");
                k.DW(textView, 16842817);
                return textView;
            }
        }

        static class 6 implements c {
            6() {
            }

            public View j6(Context context) {
                View textView = new TextView(context);
                textView.setText("Large Text");
                k.DW(textView, 16842816);
                return textView;
            }
        }

        static class 7 implements c {

            class 1 extends View {
                final /* synthetic */ 7 DW;
                final /* synthetic */ Context j6;

                1(7 7, Context context, Context context2) {
                    this.DW = 7;
                    this.j6 = context2;
                    super(context);
                }

                protected void onMeasure(int i, int i2) {
                    setMeasuredDimension((int) (30.0f * this.j6.getResources().getDisplayMetrics().density), (int) (1.0f * this.j6.getResources().getDisplayMetrics().density));
                }
            }

            7() {
            }

            public View j6(Context context) {
                View 1 = new 1(this, context, context);
                1.setBackgroundDrawable(context.obtainStyledAttributes(new int[]{16843530}).getDrawable(0));
                return 1;
            }
        }

        static class 8 implements c {

            class 1 extends View {
                final /* synthetic */ 8 DW;
                final /* synthetic */ Context j6;

                1(8 8, Context context, Context context2) {
                    this.DW = 8;
                    this.j6 = context2;
                    super(context);
                }

                protected void onMeasure(int i, int i2) {
                    setMeasuredDimension((int) (1.0f * this.j6.getResources().getDisplayMetrics().density), (int) (30.0f * this.j6.getResources().getDisplayMetrics().density));
                }
            }

            8() {
            }

            public View j6(Context context) {
                View 1 = new 1(this, context, context);
                1.setBackgroundDrawable(context.obtainStyledAttributes(new int[]{16843564}).getDrawable(0));
                return 1;
            }
        }

        static class 9 implements c {
            9() {
            }

            public View j6(Context context) {
                View imageView = new ImageView(context);
                imageView.setImageResource(17301533);
                return imageView;
            }
        }

        private a(String str, String str2) {
            this(r8, r9, str, str2, str, new String[0]);
        }

        private a(String str, String str2, c cVar) {
            this(r9, r10, str, str2, cVar, str, new String[0]);
        }

        private a(String str, String str2, String str3, String... strArr) {
            this(r9, r10, str, str2, null, str3, strArr);
        }

        private a(String str, String str2, c cVar, String str3, String... strArr) {
            this.yO = str;
            this.kQ = str3;
            this.XX = str2;
            this.jJ = cVar;
            this.XG = new HashMap();
            for (int i = 0; i < strArr.length; i += 2) {
                this.XG.put(strArr[i], strArr[i + 1]);
            }
        }

        public Map<String, String> j6() {
            return this.XG;
        }

        public String DW() {
            return this.kQ;
        }

        public String FH() {
            return this.yO;
        }

        public boolean Hw() {
            return "App Layout".equals(this.XX);
        }

        public boolean v5() {
            return Zo() || "Adapter View".equals(this.XX);
        }

        public boolean Zo() {
            return "Layout".equals(this.XX) || "Advanced Layout".equals(this.XX) || "Scroll View".equals(this.XX) || "App Layout".equals(this.XX);
        }

        public String VH() {
            return this.XX;
        }

        public View j6(Context context) {
            if (this.jJ != null) {
                try {
                    View j6 = this.jJ.j6(context);
                    if (j6 == null) {
                        return j6;
                    }
                    j6.setClickable(false);
                    return j6;
                } catch (Throwable th) {
                }
            }
            return null;
        }

        public String gn() {
            return "android/widget/" + this.kQ + ".html";
        }
    }

    private static class b extends BaseExpandableListAdapter {
        private Context DW;
        private List<List<a>> j6;

        class 1 implements OnClickListener {
            final /* synthetic */ b DW;
            final /* synthetic */ String j6;

            1(b bVar, String str) {
                this.DW = bVar;
                this.j6 = str;
            }

            public void onClick(View view) {
                ((XmlLayoutDesignActivity) this.DW.DW).j6(this.j6);
            }
        }

        public b(Context context, List<List<a>> list) {
            this.DW = context;
            this.j6 = list;
        }

        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.DW).inflate(R.c.designer_widgetlist_group, viewGroup, false);
            }
            ((TextView) view.findViewById(R.b.widgetlistGroupName)).setText(((a) getChild(i, 0)).VH());
            return view;
        }

        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            int i3;
            int i4 = 8;
            if (view == null) {
                view = LayoutInflater.from(this.DW).inflate(R.c.designer_widgetlist_entry, viewGroup, false);
            }
            a aVar = (a) getChild(i, i2);
            View j6 = aVar.j6(this.DW);
            TextView textView = (TextView) view.findViewById(R.b.widgetlistName);
            textView.setText(aVar.FH());
            textView.setVisibility(j6 == null ? 0 : 8);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.b.widgetlistPreview);
            if (j6 != null) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            viewGroup2.setVisibility(i3);
            viewGroup2.removeAllViews();
            if (j6 != null) {
                viewGroup2.addView(j6, new ViewGroup.LayoutParams(-2, -2));
            }
            String gn = aVar.gn();
            View findViewById = view.findViewById(R.b.widgetlistHelp);
            if (gn != null) {
                i4 = 0;
            }
            findViewById.setVisibility(i4);
            if (gn != null) {
                findViewById.setOnClickListener(new 1(this, gn));
            }
            return view;
        }

        public Object getGroup(int i) {
            return this.j6.get(i);
        }

        public Object getChild(int i, int i2) {
            return ((List) this.j6.get(i)).get(i2);
        }

        public int getGroupCount() {
            return this.j6.size();
        }

        public int getChildrenCount(int i) {
            return ((List) this.j6.get(i)).size();
        }

        public long getGroupId(int i) {
            return (long) i;
        }

        public long getChildId(int i, int i2) {
            return 0;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int i, int i2) {
            return true;
        }
    }

    public static void j6(Activity activity, String str, y<b> yVar) {
        j6(activity, str, false, true, yVar);
    }

    public static void DW(Activity activity, String str, y<b> yVar) {
        j6(activity, str, true, false, yVar);
    }

    public static void FH(Activity activity, String str, y<b> yVar) {
        j6(activity, str, false, false, yVar);
    }

    private static void DW(TextView textView, int i) {
        Theme theme = textView.getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        if (theme.resolveAttribute(i, typedValue, true)) {
            textView.setTextAppearance(textView.getContext(), typedValue.data);
        }
    }

    private static void j6(Activity activity, String str, boolean z, boolean z2, y<b> yVar) {
        m.j6(activity, new 1(j6(z, z2, activity instanceof AppWizardDesignActivity), str, z2, yVar));
    }

    private static List<List<a>> j6(boolean z, boolean z2, boolean z3) {
        List<List<a>> arrayList = new ArrayList();
        String str = "";
        for (a aVar : a.values()) {
            if ((!z || aVar.Zo()) && ((!z2 || aVar.v5()) && !(z3 && aVar.Hw()))) {
                String str2;
                if (str.equals(aVar.VH())) {
                    str2 = str;
                } else {
                    arrayList.add(new ArrayList());
                    str2 = aVar.VH();
                }
                ((List) arrayList.get(arrayList.size() - 1)).add(aVar);
                str = str2;
            }
        }
        return arrayList;
    }
}
