package com.aide.ui.build.javascript;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.aide.common.m;
import com.aide.common.w;
import com.aide.common.y;
import com.aide.ui.R;
import com.aide.ui.build.OutputConsoleActivity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintStream;

public class RunJavaScriptActivity extends OutputConsoleActivity {

    class 1 extends WebChromeClient {
        final /* synthetic */ RunJavaScriptActivity DW;
        final /* synthetic */ PrintStream j6;

        class 1 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsResult j6;

            1(1 1, JsResult jsResult) {
                this.DW = 1;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.confirm();
            }
        }

        class 2 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsResult j6;

            2(1 1, JsResult jsResult) {
                this.DW = 1;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.confirm();
            }
        }

        class 3 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsResult j6;

            3(1 1, JsResult jsResult) {
                this.DW = 1;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        class 4 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsResult j6;

            4(1 1, JsResult jsResult) {
                this.DW = 1;
                this.j6 = jsResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        class 5 implements y<String> {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsPromptResult j6;

            5(1 1, JsPromptResult jsPromptResult) {
                this.DW = 1;
                this.j6 = jsPromptResult;
            }

            public void j6(String str) {
                this.j6.confirm(str);
            }
        }

        class 6 implements Runnable {
            final /* synthetic */ 1 DW;
            final /* synthetic */ JsPromptResult j6;

            6(1 1, JsPromptResult jsPromptResult) {
                this.DW = 1;
                this.j6 = jsPromptResult;
            }

            public void run() {
                this.j6.cancel();
            }
        }

        1(RunJavaScriptActivity runJavaScriptActivity, PrintStream printStream) {
            this.DW = runJavaScriptActivity;
            this.j6 = printStream;
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.d("js", consoleMessage.message());
            this.j6.append(consoleMessage.message());
            this.j6.append("\n");
            return true;
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if ("$$$FINISHED$$$".equals(str2)) {
                this.DW.FH();
                jsResult.confirm();
            } else {
                m.j6(this.DW, null, str2, new 1(this, jsResult));
            }
            return true;
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            m.j6(this.DW, null, str2, "Ok", new 2(this, jsResult), "Cancel", new 3(this, jsResult), new 4(this, jsResult));
            return true;
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            m.j6(this.DW, null, str2, str3, new 5(this, jsPromptResult), new 6(this, jsPromptResult));
            return true;
        }
    }

    class 2 implements Runnable {
        final /* synthetic */ File DW;
        final /* synthetic */ RunJavaScriptActivity FH;
        final /* synthetic */ WebView j6;

        2(RunJavaScriptActivity runJavaScriptActivity, WebView webView, File file) {
            this.FH = runJavaScriptActivity;
            this.j6 = webView;
            this.DW = file;
        }

        public void run() {
            this.j6.loadUrl("file://" + this.DW.getPath());
        }
    }

    public static void j6(Activity activity, boolean z, String str, int i) {
        Intent intent = new Intent(activity, RunJavaScriptActivity.class);
        intent.putExtra("EXTRA_DEX", str);
        OutputConsoleActivity.j6(activity, z, i, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected int DW() {
        return R.drawable.ic_launcher_javascript;
    }

    protected void j6() {
        String str = "$$$FINISHED$$$";
        PrintStream printStream = this.j6.getPrintStream();
        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new 1(this, printStream));
        str = getIntent().getExtras().getString("EXTRA_DEX");
        String str2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<body> <script>\n (function () {\n" + w.j6(new FileInputStream(str)) + "\n})();alert('" + "$$$FINISHED$$$" + "');\n</script> </body>";
        File file = new File(new File(str).getParentFile(), "bin");
        file.mkdirs();
        File file2 = new File(file, "script.html");
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(str2);
        fileWriter.close();
        new Handler().postDelayed(new 2(this, webView, file2), 200);
    }
}
