package com.antutu.benchmark.averify.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.antutu.ABenchMark.C1082R;
import com.antutu.benchmark.activity.CommentActivity;
import com.antutu.benchmark.averify.logic.Verifier.VerifiedResult;
import com.antutu.benchmark.modelreflact.PraiseModel;
import com.antutu.benchmark.p037f.C1095a;
import com.antutu.benchmark.p038b.C1197a;
import com.antutu.benchmark.p040c.C1371d;
import com.antutu.utils.DateUtil;
import com.antutu.utils.InfocUtil;
import com.antutu.utils.MLog;
import com.antutu.utils.NetUtils;
import com.facebook.ads.C2279R;
import com.umeng.message.proguard.C4233j;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;

public class ActivityVerifySuccess extends C1197a implements OnClickListener, C1095a<PraiseModel> {
    private static final String f4530a;
    private static final int[] f4531b;
    private TextView f4532A;
    private TextView f4533B;
    private TextView f4534C;
    private C1371d f4535D;
    private SensorManager f4536E;
    private String f4537F;
    private String f4538G;
    private ImageButton f4539c;
    private TextView f4540d;
    private Button f4541e;
    private ScrollView f4542f;
    private TextView f4543g;
    private Button f4544h;
    private TextView f4545i;
    private TextView f4546k;
    private LinearLayout f4547l;
    private TextView f4548m;
    private TextView f4549n;
    private TextView f4550o;
    private TextView f4551p;
    private TextView f4552q;
    private TextView f4553r;
    private TextView f4554s;
    private TextView f4555t;
    private TextView f4556u;
    private TextView f4557v;
    private TextView f4558w;
    private TextView f4559x;
    private TextView f4560y;
    private TextView f4561z;

    /* renamed from: com.antutu.benchmark.averify.activity.ActivityVerifySuccess.a */
    private class C1326a extends AsyncTask<Bitmap, Void, File> {
        final /* synthetic */ ActivityVerifySuccess f4528a;
        private final String f4529b;

        private C1326a(ActivityVerifySuccess activityVerifySuccess) {
            this.f4528a = activityVerifySuccess;
            this.f4529b = ActivityVerifySuccess.f4530a + "." + C1326a.class.getSimpleName();
        }

        protected File m5326a(Bitmap... bitmapArr) {
            FileOutputStream fileOutputStream;
            Throwable e;
            try {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "yanji-result.jpg");
                fileOutputStream = new FileOutputStream(file);
                try {
                    bitmapArr[0].compress(CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    if (fileOutputStream == null) {
                        return file;
                    }
                    try {
                        fileOutputStream.close();
                        return file;
                    } catch (Throwable e2) {
                        MLog.m6869e(this.f4529b, "save screenshot error...", e2);
                        return file;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        MLog.m6869e(this.f4529b, "save screenshot error...", e);
                        if (fileOutputStream != null) {
                            return null;
                        }
                        try {
                            fileOutputStream.close();
                            return null;
                        } catch (Throwable e4) {
                            MLog.m6869e(this.f4529b, "save screenshot error...", e4);
                            return null;
                        }
                    } catch (Throwable th) {
                        e4 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e22) {
                                MLog.m6869e(this.f4529b, "save screenshot error...", e22);
                            }
                        }
                        throw e4;
                    }
                }
            } catch (Exception e5) {
                e4 = e5;
                fileOutputStream = null;
                MLog.m6869e(this.f4529b, "save screenshot error...", e4);
                if (fileOutputStream != null) {
                    return null;
                }
                fileOutputStream.close();
                return null;
            } catch (Throwable th2) {
                e4 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e4;
            }
        }

        protected void m5327a(File file) {
            if (file != null) {
                this.f4528a.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE").setData(Uri.fromFile(file)));
                Toast.makeText(this.f4528a, this.f4528a.getString(C1082R.string.screenshot_save_to, new Object[]{file.getPath()}), 0).show();
            } else {
                Toast.makeText(this.f4528a, C1082R.string.no_enough_disk, 0).show();
            }
            this.f4528a.f4541e.setEnabled(true);
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m5326a((Bitmap[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m5327a((File) obj);
        }

        protected void onPreExecute() {
            this.f4528a.f4541e.setEnabled(false);
            Toast.makeText(this.f4528a, C1082R.string.saving_screenshot, 0).show();
        }
    }

    static {
        f4530a = ActivityVerifySuccess.class.getSimpleName();
        f4531b = new int[]{1, 13, 12, 9, 5, 2, 18, 6, 3, 8};
    }

    public static Intent m5328a(Context context) {
        return new Intent(context, ActivityVerifySuccess.class);
    }

    private void m5331b() {
        this.f4535D = new C1371d(this);
        this.f4536E = (SensorManager) getSystemService("sensor");
        this.f4537F = getString(C1082R.string.do_support);
        this.f4538G = getString(C1082R.string.not_support);
    }

    private void m5332c() {
        this.f4539c = (ImageButton) findViewById(C1082R.id.imageButtonBack);
        this.f4540d = (TextView) findViewById(C1082R.id.textViewTitle);
        this.f4541e = (Button) findViewById(C1082R.id.buttonSaveScreenshot);
        this.f4542f = (ScrollView) findViewById(C2279R.id.scrollView);
        this.f4543g = (TextView) findViewById(C1082R.id.textViewDeviceModel);
        this.f4544h = (Button) findViewById(C1082R.id.buttonRevalidate);
        this.f4545i = (TextView) findViewById(C1082R.id.textViewRating);
        this.f4546k = (TextView) findViewById(C1082R.id.textViewCommentCount);
        this.f4547l = (LinearLayout) findViewById(C1082R.id.linearLayoutGoToComment);
        this.f4548m = (TextView) findViewById(C1082R.id.textViewDeviceModel1);
        this.f4549n = (TextView) findViewById(C1082R.id.textViewCPUName);
        this.f4550o = (TextView) findViewById(C1082R.id.textViewCoreNum);
        this.f4551p = (TextView) findViewById(C1082R.id.textViewGPUName);
        this.f4552q = (TextView) findViewById(C1082R.id.textViewScreenResolution);
        this.f4553r = (TextView) findViewById(C1082R.id.textViewAccelerometer);
        this.f4554s = (TextView) findViewById(C1082R.id.textViewAmbientTemperature);
        this.f4555t = (TextView) findViewById(C1082R.id.textViewRelativeHumidity);
        this.f4556u = (TextView) findViewById(C1082R.id.textViewGravity);
        this.f4557v = (TextView) findViewById(C1082R.id.textViewLight);
        this.f4558w = (TextView) findViewById(C1082R.id.textViewMagneticField);
        this.f4559x = (TextView) findViewById(C1082R.id.textViewStepDetector);
        this.f4560y = (TextView) findViewById(C1082R.id.textViewPressure);
        this.f4561z = (TextView) findViewById(C1082R.id.textViewOrientation);
        this.f4532A = (TextView) findViewById(C1082R.id.textViewProximity);
        this.f4533B = (TextView) findViewById(C1082R.id.textViewVerifyId);
        this.f4534C = (TextView) findViewById(C1082R.id.textViewVerifyDatetime);
        this.f4539c.setOnClickListener(this);
        this.f4541e.setOnClickListener(this);
        this.f4540d.setText(C1082R.string.verify_report);
        this.f4544h.setOnClickListener(this);
        this.f4547l.setOnClickListener(this);
    }

    private void m5333d() {
        int width = this.f4542f.getChildAt(0).getWidth();
        float min = (float) Math.min(720, width);
        float f = min / ((float) width);
        Canvas canvas = new Canvas(Bitmap.createBitmap((int) min, (int) (((float) this.f4542f.getChildAt(0).getHeight()) * f), Config.ARGB_8888));
        canvas.save();
        canvas.scale(f, f);
        this.f4542f.draw(canvas);
        canvas.restore();
        new C1326a().execute(new Bitmap[]{r1});
    }

    public void m5334a(PraiseModel praiseModel) {
        try {
            this.f4545i.setText(praiseModel.getGoodpercent().replaceAll("%", BuildConfig.FLAVOR));
            this.f4546k.setText(praiseModel.getComment_count());
        } catch (Throwable e) {
            MLog.m6869e(f4530a, C4233j.f14375B, e);
        }
    }

    public void m5336a(String str) {
        MLog.m6877w(f4530a, str);
    }

    public void onClick(View view) {
        if (this.f4539c.getId() == view.getId()) {
            finish();
        } else if (this.f4541e.getId() == view.getId()) {
            m5333d();
            InfocUtil.antutu_yanji_new(view.getContext(), 12);
        } else if (this.f4544h.getId() == view.getId()) {
            InfocUtil.antutu_yanji_new(view.getContext(), 4);
            if (NetUtils.isNetworkAvailable()) {
                startActivity(ActivityVerifying.m5353b(view.getContext()));
                finish();
                return;
            }
            Toast.makeText(view.getContext(), C1082R.string.verifying_net_error, 0).show();
        } else if (this.f4547l.getId() == view.getId()) {
            InfocUtil.antutu_yanji_new(view.getContext(), 7);
            startActivity(new Intent(view.getContext(), CommentActivity.class));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1082R.layout.activity_verify_success);
        m5331b();
        m5332c();
        this.f4535D.m5429a(this);
        for (int i : f4531b) {
            if (this.f4536E.getDefaultSensor(i) != null) {
                if (1 == i) {
                    this.f4553r.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (13 == i) {
                    this.f4554s.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (12 == i) {
                    this.f4555t.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (9 == i) {
                    this.f4556u.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (5 == i) {
                    this.f4557v.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (2 == i) {
                    this.f4558w.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (18 == i) {
                    this.f4559x.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (6 == i) {
                    this.f4560y.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (3 == i) {
                    this.f4561z.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                } else if (8 == i) {
                    this.f4532A.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4537F, this.f4537F}));
                }
            } else if (1 == i) {
                this.f4553r.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (13 == i) {
                this.f4554s.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (12 == i) {
                this.f4555t.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (9 == i) {
                this.f4556u.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (5 == i) {
                this.f4557v.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (2 == i) {
                this.f4558w.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (18 == i) {
                this.f4559x.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (6 == i) {
                this.f4560y.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (3 == i) {
                this.f4561z.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            } else if (8 == i) {
                this.f4532A.setText(getString(C1082R.string.official_and_local, new Object[]{this.f4538G, this.f4538G}));
            }
        }
        VerifiedResult verifiedResult = (VerifiedResult) getIntent().getParcelableExtra("Extra.Verify.Result");
        if (verifiedResult != null) {
            this.f4543g.setText(verifiedResult.m5368e() + " " + verifiedResult.m5366d());
            this.f4548m.setText(getString(C1082R.string.official_and_local, new Object[]{verifiedResult.m5366d(), verifiedResult.m5366d()}));
            this.f4549n.setText(getString(C1082R.string.official_and_local, new Object[]{verifiedResult.m5370f(), verifiedResult.m5370f()}));
            this.f4550o.setText(getString(C1082R.string.official_and_local, new Object[]{verifiedResult.m5371g(), verifiedResult.m5371g()}));
            this.f4551p.setText(getString(C1082R.string.official_and_local, new Object[]{verifiedResult.m5372h(), verifiedResult.m5372h()}));
            this.f4552q.setText(getString(C1082R.string.official_and_local, new Object[]{verifiedResult.m5373i(), verifiedResult.m5373i()}));
            this.f4533B.setText(verifiedResult.m5364c());
            this.f4534C.setText(DateUtil.formatDate(verifiedResult.m5374j()));
        }
        InfocUtil.antutu_yanji_new(this, 1);
    }
}
