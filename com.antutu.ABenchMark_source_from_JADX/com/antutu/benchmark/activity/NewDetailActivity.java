package com.antutu.benchmark.activity;

import android.os.Bundle;
import android.webkit.WebView;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.p038b.C1197a;

public class NewDetailActivity extends C1197a {
    private WebView f4355a;
    private int f4356b;
    private String f4357c;

    public NewDetailActivity() {
        this.f4356b = -1;
        this.f4357c = "http://www.baidu.com";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.news_detail);
        this.f4355a = (WebView) findViewById(C1082R.id.web_view);
        try {
            this.f4356b = getIntent().getIntExtra("news_index", -1);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
        if (this.f4356b != -1) {
            this.f4355a.getSettings().setCacheMode(2);
            this.f4355a.getSettings().setJavaScriptEnabled(true);
            this.f4355a.loadUrl(this.f4357c);
        }
    }
}
