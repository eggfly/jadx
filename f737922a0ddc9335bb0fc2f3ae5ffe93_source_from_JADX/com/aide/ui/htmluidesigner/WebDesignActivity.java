package com.aide.ui.htmluidesigner;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.SoundPool;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.Html;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aide.analytics.b;
import com.aide.common.TextToSpeechHelper;
import com.aide.common.m;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.e;
import com.aide.ui.h;
import com.aide.ui.l;
import com.aide.ui.trainer.c.d;
import com.aide.uidesigner.ProxyTextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebDesignActivity extends Activity {
    private static boolean j6;
    private l DW;
    private WebView FH;
    private SoundPool Hw;
    private TextToSpeechHelper VH;
    private int Zo;
    private int v5;

    class 10 extends WebChromeClient {
        final /* synthetic */ WebDesignActivity j6;

        class 1 implements Runnable {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsResult j6;

            1(10 10, JsResult jsResult) {
                this.DW = 10;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.confirm();
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsResult j6;

            2(10 10, JsResult jsResult) {
                this.DW = 10;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.confirm();
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsResult j6;

            3(10 10, JsResult jsResult) {
                this.DW = 10;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsResult j6;

            4(10 10, JsResult jsResult) {
                this.DW = 10;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        class 5 implements y<String> {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsPromptResult j6;

            5(10 10, JsPromptResult jsPromptResult) {
                this.DW = 10;
                this.j6 = jsPromptResult;
            }

            public void j6(String str) {
                this.j6.confirm(str);
            }
        }

        class 6 implements Runnable {
            final /* synthetic */ 10 DW;
            final /* synthetic */ JsPromptResult j6;

            6(10 10, JsPromptResult jsPromptResult) {
                this.DW = 10;
                this.j6 = jsPromptResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        10(WebDesignActivity webDesignActivity) {
            this.j6 = webDesignActivity;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            m.j6(this.j6, null, str2, new 1(this, jsResult));
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            m.j6(this.j6, null, str2, "Ok", new 2(this, jsResult), "Cancel", new 3(this, jsResult), new 4(this, jsResult));
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            m.j6(this.j6, null, str2, str3, new 5(this, jsPromptResult), new 6(this, jsPromptResult));
            return true;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            switch (2.j6[consoleMessage.messageLevel().ordinal()]) {
                case ProxyTextView.TYPEFACE_MONOSPACE /*3*/:
                    Log.d("console.log", consoleMessage.message());
                    break;
                case ProxyTextView.INPUTTYPE_datetime /*4*/:
                    Log.e("console.log", consoleMessage.message());
                    break;
                case 5:
                    Log.w("console.log", consoleMessage.message());
                    break;
                default:
                    Log.i("console.log", consoleMessage.message());
                    break;
            }
            return true;
        }
    }

    class 1 implements b {
        final /* synthetic */ WebDesignActivity j6;

        1(WebDesignActivity webDesignActivity) {
            this.j6 = webDesignActivity;
        }

        public boolean j6() {
            return h.DW(this.j6);
        }
    }

    static /* synthetic */ class 2 {
        static final /* synthetic */ int[] j6;

        static {
            j6 = new int[MessageLevel.values().length];
            try {
                j6[MessageLevel.LOG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                j6[MessageLevel.TIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                j6[MessageLevel.DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                j6[MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                j6[MessageLevel.WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    class 3 implements OnClickListener {
        final /* synthetic */ WebDesignActivity j6;

        3(WebDesignActivity webDesignActivity) {
            this.j6 = webDesignActivity;
        }

        public void onClick(View view) {
            this.j6.gn();
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ WebDesignActivity j6;

        4(WebDesignActivity webDesignActivity) {
            this.j6 = webDesignActivity;
        }

        public void run() {
            Intent intent = new Intent();
            intent.putExtra("EXTRA_TRAINER_ACTION", true);
            this.j6.setResult(-1, intent);
            this.j6.finish();
        }
    }

    class 5 implements OnClickListener {
        final /* synthetic */ WebDesignActivity DW;
        final /* synthetic */ Runnable j6;

        5(WebDesignActivity webDesignActivity, Runnable runnable) {
            this.DW = webDesignActivity;
            this.j6 = runnable;
        }

        public void onClick(View view) {
            this.j6.run();
        }
    }

    class 6 extends TranslateAnimation {
        final /* synthetic */ WebDesignActivity DW;
        final /* synthetic */ View j6;

        6(WebDesignActivity webDesignActivity, float f, float f2, float f3, float f4, View view) {
            this.DW = webDesignActivity;
            this.j6 = view;
            super(f, f2, f3, f4);
        }

        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            this.j6.invalidate();
        }
    }

    static class 7 implements Runnable {
        final /* synthetic */ Context j6;

        7(Context context) {
            this.j6 = context;
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -v threadtime").getInputStream()), 20);
                String str = "";
                while (true) {
                    str = bufferedReader.readLine();
                    if (str == null) {
                        return;
                    }
                    if (str.contains("console.log")) {
                        Intent intent = new Intent();
                        intent.setPackage("com.aide.ui");
                        intent.setAction("com.aide.runtime.VIEW_LOGCAT_ENTRY");
                        intent.putExtra("lines", new String[]{str});
                        this.j6.sendBroadcast(intent);
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    class 8 extends WebView {
        final /* synthetic */ WebDesignActivity j6;

        8(WebDesignActivity webDesignActivity, Context context) {
            this.j6 = webDesignActivity;
            super(context);
        }

        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (i2 == 0 && i4 > 0) {
                this.j6.DW.j6(true);
            } else if (i2 > 0) {
                this.j6.DW.j6(false);
            }
        }
    }

    class 9 extends WebViewClient {
        final /* synthetic */ WebDesignActivity j6;

        9(WebDesignActivity webDesignActivity) {
            this.j6 = webDesignActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(WebDesignActivity.u7())) {
                return false;
            }
            this.j6.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.j6.FH()) {
                this.j6.j6();
            }
        }
    }

    private static class a extends m {
        private String DW;
        private String j6;

        class 1 implements OnClickListener {
            final /* synthetic */ a DW;
            final /* synthetic */ Activity j6;

            1(a aVar, Activity activity) {
                this.DW = aVar;
                this.j6 = activity;
            }

            public void onClick(View view) {
                this.j6.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.DW.j6)));
            }
        }

        class 2 implements DialogInterface.OnClickListener {
            final /* synthetic */ a j6;

            2(a aVar) {
                this.j6 = aVar;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        class 3 implements OnCancelListener {
            final /* synthetic */ a j6;

            3(a aVar) {
                this.j6 = aVar;
            }

            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        }

        public a(String str, String str2) {
            this.j6 = str2;
            this.DW = str;
        }

        protected Dialog j6(Activity activity) {
            Builder builder = new Builder(activity);
            View textView = new TextView(activity);
            textView.setText(Html.fromHtml(this.DW + "<br/><br/><a href='" + this.j6 + "'>" + this.j6 + "</a><br/>"));
            textView.setOnClickListener(new 1(this, activity));
            textView.setTextIsSelectable(true);
            int i = (int) (10.0f * activity.getResources().getDisplayMetrics().density);
            textView.setPadding(i, i, i, i);
            textView.setTextSize(16.0f);
            builder.setTitle("Cast website").setView(textView).setCancelable(true);
            builder.setPositiveButton("Ok", new 2(this));
            builder.setOnCancelListener(new 3(this));
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }
    }

    public static void j6(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, WebDesignActivity.class);
        intent.putExtra("EXTRA_FILE", str2);
        intent.putExtra("EXTRA_ROOTDIR", str);
        if (i == 0 || !e.VH()) {
            intent.addFlags(268435456);
            intent.addFlags(4096);
            intent.addFlags(134217728);
            activity.startActivity(intent);
            return;
        }
        com.aide.ui.trainer.c.a er = e.QX().er();
        d gW = e.QX().gW();
        intent.putExtra("EXTRA_TRAINER", true);
        intent.putExtra("EXTRA_SOUND", h.XL());
        intent.putExtra("EXTRA_SPEAK", h.QX());
        intent.putExtra("EXTRA_HEADER", er.VH());
        intent.putExtra("EXTRA_TRAINER_LOCALE", gW.j6());
        intent.putExtra("EXTRA_TRAINER_OUTPUT", gW.Zo());
        intent.putExtra("EXTRA_TRAINER_FAIL", gW.Hw());
        intent.putExtra("EXTRA_TRAINER_FAIL_BUTTON", e.QX().j3());
        intent.putExtra("EXTRA_TRAINER_SUCCESS", gW.u7());
        intent.putExtra("EXTRA_TRAINER_FAIL_TITLE", e.QX().XL());
        intent.putExtra("EXTRA_TRAINER_SUCCESS_TITLE", e.QX().rN());
        intent.putExtra("EXTRA_TRAINER_SUCCESS_BUTTON", e.QX().U2());
        activity.startActivityForResult(intent, i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        VH();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.aide.analytics.a.j6()) {
            com.aide.analytics.a.j6((Context) this, new 1(this));
        }
        setContentView(R.c.webpreview);
        this.DW = new l(this, R.b.webpreviewMasterButton);
        this.DW.j6(true);
        this.DW.j6(new 3(this));
        if (FH()) {
            j6(getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS_TITLE"), getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS"), getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS_BUTTON"), new 4(this));
            this.Hw = new SoundPool(1, 3, 0);
            this.v5 = this.Hw.load(this, R.e.success_task, 1);
            this.Zo = this.Hw.load(this, R.e.fail, 1);
            this.VH = new TextToSpeechHelper(this);
        }
        Zo();
        ((LinearLayout) findViewById(R.b.webpreviewContainer)).addView(this.FH);
        j6(getApplicationContext());
    }

    private boolean FH() {
        return getIntent().getBooleanExtra("EXTRA_TRAINER", false);
    }

    private boolean Hw() {
        return getIntent().getBooleanExtra("EXTRA_SPEAK", false);
    }

    private boolean v5() {
        return getIntent().getBooleanExtra("EXTRA_SOUND", true);
    }

    private void j6(String str, String str2, String str3, Runnable runnable) {
        View findViewById = findViewById(R.b.webpreviewHeaderLearnTask);
        findViewById.setVisibility(4);
        TextView textView = (TextView) findViewById.findViewById(R.b.webpreviewHeaderLearnMessage);
        TextView textView2 = (TextView) findViewById.findViewById(R.b.webpreviewHeaderLearnTitle);
        TextView textView3 = (TextView) findViewById.findViewById(R.b.webpreviewHeaderButton);
        if (str2.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(Html.fromHtml(str2));
        }
        textView2.setText(str);
        textView3.setText(str3);
        textView2.setTextSize(com.aide.common.d.J0(this));
        textView.setTextSize(com.aide.common.d.EQ(this));
        textView3.setTextSize(com.aide.common.d.we(this));
        findViewById.findViewById(R.b.webpreviewHeaderLearnTaskInner).setOnClickListener(new 5(this, runnable));
        textView.getLayoutParams().width = com.aide.common.d.Zo(this);
        textView.requestLayout();
        findViewById.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void j6() {
        if (v5()) {
            this.Hw.play(this.v5, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        if (Hw()) {
            this.VH.j6(getIntent().getStringExtra("EXTRA_TRAINER_LOCALE"), getIntent().getStringExtra("EXTRA_TRAINER_SUCCESS"));
        }
        View findViewById = findViewById(R.b.webpreviewHeaderLearnTask);
        findViewById.setVisibility(0);
        Animation 6 = new 6(this, 0.0f, 0.0f, -(getResources().getDisplayMetrics().density * 150.0f), 0.0f, findViewById);
        6.setDuration(500);
        findViewById.startAnimation(6);
    }

    private static void j6(Context context) {
        if (!j6) {
            j6 = true;
            new Thread(new 7(context)).start();
        }
    }

    private WebView Zo() {
        this.FH = new 8(this, this);
        this.FH.setInitialScale(100);
        this.FH.setVerticalScrollBarEnabled(false);
        this.FH.getSettings().setJavaScriptEnabled(true);
        this.FH.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.FH.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
        if (FH()) {
            this.FH.getSettings().setDefaultFontSize(50);
        }
        this.FH.setBackgroundColor(-1);
        this.FH.setWebViewClient(new 9(this));
        this.FH.setWebChromeClient(new 10(this));
        VH();
        return this.FH;
    }

    private void VH() {
        if ((getIntent().getFlags() & 1048576) == 0) {
            String string = getIntent().getExtras().getString("EXTRA_FILE");
            String string2 = getIntent().getExtras().getString("EXTRA_ROOTDIR");
            a.j6(string2);
            string = j6(string2, string);
            this.FH.clearCache(true);
            this.FH.loadUrl(string);
        }
    }

    private void gn() {
        try {
            String u7 = u7();
            String url = this.FH.getUrl();
            if (url.startsWith(u7)) {
                WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null || connectionInfo.getIpAddress() == 0) {
                    m.j6((Activity) this, new a("Click the url to open the website in a browser. Connect to WiFi to view it on other devices & computers!", url));
                    return;
                }
                String ssid = connectionInfo.getSSID();
                m.j6((Activity) this, new a("On other devices & computers connected to WiFi " + ssid + " open this url in a browser:", j6(Formatter.formatIpAddress(connectionInfo.getIpAddress())) + url.substring(u7.length(), url.length())));
                return;
            }
            m.j6((Activity) this, new a("Click the url to open the website in a browser:", url));
        } catch (Exception e) {
        }
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    protected void onStart() {
        super.onStart();
        com.aide.analytics.a.j6((Activity) this, "Web Designer");
    }

    protected void onStop() {
        super.onStop();
        com.aide.analytics.a.DW(this, "Web Designer");
    }

    private static String j6(String str, String str2) {
        String u7 = u7();
        if (str2 == null || !str2.startsWith(str + "/")) {
            return u7;
        }
        String substring = str2.substring(str.length(), str2.length());
        if (substring.equals("/index.html")) {
            return u7;
        }
        return u7 + substring;
    }

    private static String j6(String str) {
        return "http://" + str + ":" + 8099;
    }

    private static String u7() {
        return "http://localhost:8099";
    }
}
