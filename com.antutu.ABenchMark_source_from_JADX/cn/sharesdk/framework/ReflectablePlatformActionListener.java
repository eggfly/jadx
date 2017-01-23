package cn.sharesdk.framework;

import android.os.Handler.Callback;
import android.os.Message;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;

public class ReflectablePlatformActionListener implements PlatformActionListener {
    private int f3163a;
    private Callback f3164b;
    private int f3165c;
    private Callback f3166d;
    private int f3167e;
    private Callback f3168f;

    public void onCancel(Platform platform, int i) {
        if (this.f3168f != null) {
            Message message = new Message();
            message.what = this.f3167e;
            message.obj = new Object[]{platform, Integer.valueOf(i)};
            UIHandler.sendMessage(message, this.f3168f);
        }
    }

    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        if (this.f3164b != null) {
            Message message = new Message();
            message.what = this.f3163a;
            message.obj = new Object[]{platform, Integer.valueOf(i), hashMap};
            UIHandler.sendMessage(message, this.f3164b);
        }
    }

    public void onError(Platform platform, int i, Throwable th) {
        if (this.f3166d != null) {
            Message message = new Message();
            message.what = this.f3165c;
            message.obj = new Object[]{platform, Integer.valueOf(i), th};
            UIHandler.sendMessage(message, this.f3166d);
        }
    }

    public void setOnCancelCallback(int i, Callback callback) {
        this.f3167e = i;
        this.f3168f = callback;
    }

    public void setOnCompleteCallback(int i, Callback callback) {
        this.f3163a = i;
        this.f3164b = callback;
    }

    public void setOnErrorCallback(int i, Callback callback) {
        this.f3165c = i;
        this.f3166d = callback;
    }
}
