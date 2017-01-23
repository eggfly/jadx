package cn.sharesdk.sina.weibo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.C0979d;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import org.android.spdy.SpdyProtocol;
import org.android.spdy.TnetStatusCode;

/* renamed from: cn.sharesdk.sina.weibo.a */
public class C0997a extends FakeActivity implements Callback {
    private long f3368a;
    private boolean f3369b;
    private String f3370c;
    private ShareParams f3371d;
    private AuthorizeListener f3372e;

    /* renamed from: cn.sharesdk.sina.weibo.a.1 */
    class C09961 implements Callback {
        final /* synthetic */ C0997a f3367a;

        C09961(C0997a c0997a) {
            this.f3367a = c0997a;
        }

        public boolean handleMessage(Message message) {
            this.f3367a.m4410a();
            return true;
        }
    }

    public C0997a() {
        this.f3368a = 2097152;
    }

    private Bitmap m4408a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double sqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) / sqrt), (int) (((double) height) / sqrt), true);
    }

    private String m4409a(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return Data.MD5(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private void m4410a() {
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        bundle.putString("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (!TextUtils.isEmpty(this.f3371d.getText())) {
            bundle.putParcelable("_weibo_message_text", m4419d());
            bundle.putString("_weibo_message_text_extra", BuildConfig.FLAVOR);
        }
        if (!(this.f3371d.getImageData() == null && TextUtils.isEmpty(this.f3371d.getImagePath()))) {
            this.f3368a = 2097152;
            Parcelable e = m4420e();
            if (e.checkArgs()) {
                bundle.putParcelable("_weibo_message_image", e);
                bundle.putString("_weibo_message_image_extra", BuildConfig.FLAVOR);
            }
        }
        try {
            m4413a(this.activity, C1005e.m4469a(this.activity).m4476a(), this.f3370c, bundle);
        } catch (Throwable th) {
            if (this.f3372e != null) {
                this.f3372e.onError(new Throwable(th));
            }
        }
    }

    private void m4411a(int i, String str) {
        switch (i) {
            case TnetStatusCode.EASY_REQ_STATE_OK /*0*/:
                if (this.f3372e != null) {
                    this.f3372e.onComplete(null);
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_ON /*1*/:
                if (this.f3372e != null) {
                    this.f3372e.onCancel();
                    break;
                }
                break;
            case SpdyProtocol.TNET_IPV4_TO_IPV6_OFF /*2*/:
                if (this.f3372e != null) {
                    this.f3372e.onError(new Throwable(str));
                    break;
                }
                break;
        }
        finish();
    }

    private boolean m4413a(Activity activity, String str, String str2, Bundle bundle) {
        Object obj = "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY";
        if (activity == null || TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C0979d.m4390a().m4378e("launchWeiboActivity fail, invalid arguments", new Object[0]);
            return false;
        }
        String packageName = activity.getPackageName();
        Intent intent = new Intent();
        intent.setPackage(str);
        intent.setAction(obj);
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", str2);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m4409a((Context) activity, packageName));
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            C0979d.m4390a().m4375d("launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
            activity.startActivityForResult(intent, 765);
            return true;
        } catch (ActivityNotFoundException e) {
            C0979d.m4390a().m4378e(e.getMessage(), new Object[0]);
            return false;
        }
    }

    private byte[] m4414a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        } else if (!bitmap.isRecycled()) {
            return m4416b(context, bitmap);
        } else {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
    }

    private void m4415b() {
        UIHandler.sendEmptyMessageDelayed(1, 200, this);
    }

    private byte[] m4416b(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        } else if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        } else {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            int length = toByteArray.length;
            while (((long) length) > this.f3368a) {
                bitmap = m4408a(bitmap, ((double) length) / ((double) this.f3368a));
                byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                toByteArray = byteArrayOutputStream.toByteArray();
                length = toByteArray.length;
            }
            return toByteArray;
        }
    }

    private byte[] m4417b(Context context, String str) {
        if (new File(str).exists()) {
            return m4416b(context, BitmapHelper.getBitmap(str));
        }
        throw new FileNotFoundException();
    }

    private boolean m4418c() {
        Intent intent = new Intent();
        intent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
        String packageName = this.activity.getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", this.f3370c);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", m4409a(this.activity, packageName));
        C0979d.m4390a().m4375d("intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
        this.activity.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
        return true;
    }

    private TextObject m4419d() {
        TextObject textObject = new TextObject();
        textObject.text = this.f3371d.getText();
        return textObject;
    }

    private ImageObject m4420e() {
        ImageObject imageObject = new ImageObject();
        try {
            if (this.f3371d.getImageData() != null) {
                imageObject.imageData = m4414a(this.activity, this.f3371d.getImageData());
            } else if (!TextUtils.isEmpty(this.f3371d.getImagePath())) {
                DeviceHelper instance = DeviceHelper.getInstance(this.activity);
                if (instance.getSdcardState() && this.f3371d.getImagePath().startsWith(instance.getSdcardPath())) {
                    File file = new File(this.f3371d.getImagePath());
                    if (file.exists() && file.length() != 0 && file.length() < 10485760) {
                        imageObject.imagePath = this.f3371d.getImagePath();
                    }
                }
                imageObject.imageData = m4417b(this.activity, this.f3371d.getImagePath());
            }
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        return imageObject;
    }

    public void m4421a(ShareParams shareParams) {
        this.f3371d = shareParams;
    }

    public void m4422a(AuthorizeListener authorizeListener) {
        this.f3372e = authorizeListener;
    }

    public void m4423a(String str) {
        this.f3370c = str;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (!(this.f3369b || this.f3372e == null)) {
                this.f3372e.onCancel();
            }
            finish();
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C0979d.m4390a().m4375d("sina activity requestCode = %s, resultCode = %s", Integer.valueOf(i), Integer.valueOf(i));
        m4415b();
    }

    public void onCreate() {
        try {
            Intent intent = new Intent();
            intent.setAction("com.sina.weibo.action.browser.share");
            startActivity(intent);
        } catch (Throwable th) {
            C0979d.m4390a().m4376d(th);
        }
        if (m4418c()) {
            UIHandler.sendEmptyMessageDelayed(1, 700, new C09961(this));
        }
    }

    public void onNewIntent(Intent intent) {
        this.f3369b = true;
        Bundle extras = intent.getExtras();
        C0979d.m4390a().m4381i("onNewIntent ==>>", extras.toString());
        String stringExtra = intent.getStringExtra("_weibo_appPackage");
        CharSequence stringExtra2 = intent.getStringExtra("_weibo_transaction");
        if (TextUtils.isEmpty(stringExtra)) {
            C0979d.m4390a().m4378e("handleWeiboResponse faild appPackage is null", new Object[0]);
            return;
        }
        C0979d.m4390a().m4375d("handleWeiboResponse getCallingPackage : " + this.activity.getCallingPackage(), new Object[0]);
        if (TextUtils.isEmpty(stringExtra2)) {
            C0979d.m4390a().m4378e("handleWeiboResponse faild intent _weibo_transaction is null", new Object[0]);
        } else if (C1005e.m4470a(this.activity, stringExtra) || stringExtra.equals(this.activity.getPackageName())) {
            m4411a(extras.getInt("_weibo_resp_errcode"), extras.getString("_weibo_resp_errstr"));
        } else {
            C0979d.m4390a().m4378e("handleWeiboResponse faild appPackage validateSign faild", new Object[0]);
        }
    }
}
