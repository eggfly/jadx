package com.umeng.message.tag;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.common.impl.json.C4213a;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.common.inter.ITagManager.Result;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TagManager {
    private static final String f14500a;
    private static final String f14501b = "ok";
    private static final String f14502c = "fail";
    private static TagManager f14503d;
    private static ITagManager f14504f;
    private Context f14505e;

    public interface TCallBack {
        void onMessage(boolean z, Result result);
    }

    /* renamed from: com.umeng.message.tag.TagManager.1 */
    class C42441 implements Runnable {
        final /* synthetic */ TCallBack f14487a;
        final /* synthetic */ String[] f14488b;
        final /* synthetic */ TagManager f14489c;

        C42441(TagManager tagManager, TCallBack tCallBack, String[] strArr) {
            this.f14489c = tagManager;
            this.f14487a = tCallBack;
            this.f14488b = strArr;
        }

        public void run() {
            Exception e;
            Result result = null;
            if (this.f14489c.m17345d()) {
                try {
                    throw new Exception("Tag API is disabled by the server.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f14487a.onMessage(false, null);
                }
            } else if (!this.f14489c.m17343c()) {
                try {
                    throw new Exception("No utdid or device_token");
                } catch (Exception e22) {
                    e22.printStackTrace();
                    this.f14487a.onMessage(false, null);
                }
            } else if (this.f14488b == null || this.f14488b.length == 0) {
                try {
                    throw new Exception("No tags");
                } catch (Exception e222) {
                    e222.printStackTrace();
                    this.f14487a.onMessage(false, null);
                }
            } else {
                List arrayList = new ArrayList();
                for (String str : this.f14488b) {
                    if (!(MessageSharedPrefs.getInstance(this.f14489c.f14505e).isTagSet(str) || arrayList.contains(str))) {
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() == 0) {
                    this.f14487a.onMessage(true, this.f14489c.m17346e());
                    return;
                }
                JSONObject e3;
                try {
                    e3 = this.f14489c.m17340b();
                    try {
                        e3.put(MsgConstant.KEY_TAGS, TagManager.m17338b(arrayList));
                        result = TagManager.f14504f.add(e3, true, this.f14488b);
                        this.f14487a.onMessage(true, result);
                    } catch (Exception e4) {
                        e222 = e4;
                        e222.printStackTrace();
                        if (e222 == null && e222.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                            try {
                                result = TagManager.f14504f.add(e3, false, this.f14488b);
                                this.f14487a.onMessage(true, result);
                                return;
                            } catch (Exception e2222) {
                                this.f14487a.onMessage(false, result);
                                e2222.printStackTrace();
                                return;
                            }
                        }
                        this.f14487a.onMessage(false, result);
                    }
                } catch (Exception e5) {
                    e2222 = e5;
                    e3 = null;
                    e2222.printStackTrace();
                    if (e2222 == null) {
                    }
                    this.f14487a.onMessage(false, result);
                }
            }
        }
    }

    /* renamed from: com.umeng.message.tag.TagManager.2 */
    class C42452 implements Runnable {
        final /* synthetic */ TCallBack f14490a;
        final /* synthetic */ String[] f14491b;
        final /* synthetic */ TagManager f14492c;

        C42452(TagManager tagManager, TCallBack tCallBack, String[] strArr) {
            this.f14492c = tagManager;
            this.f14490a = tCallBack;
            this.f14491b = strArr;
        }

        public void run() {
            Exception e;
            Result result = null;
            if (this.f14492c.m17345d()) {
                try {
                    throw new Exception("Tag API is disabled by the server.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f14490a.onMessage(false, null);
                }
            } else if (!this.f14492c.m17343c()) {
                try {
                    throw new Exception("No utdid or device_token");
                } catch (Exception e22) {
                    e22.printStackTrace();
                    this.f14490a.onMessage(false, null);
                }
            } else if (this.f14491b == null || this.f14491b.length == 0) {
                try {
                    throw new Exception("No tags");
                } catch (Exception e222) {
                    e222.printStackTrace();
                    this.f14490a.onMessage(false, null);
                }
            } else {
                List arrayList = new ArrayList();
                for (Object add : this.f14491b) {
                    arrayList.add(add);
                }
                if (arrayList.size() == 0) {
                    this.f14490a.onMessage(true, this.f14492c.m17346e());
                    return;
                }
                JSONObject e3;
                try {
                    e3 = this.f14492c.m17340b();
                    try {
                        e3.put(MsgConstant.KEY_TAGS, TagManager.m17338b(arrayList));
                        result = TagManager.f14504f.update(e3, true, this.f14491b);
                        this.f14490a.onMessage(true, result);
                    } catch (Exception e4) {
                        e222 = e4;
                        e222.printStackTrace();
                        if (e222 == null) {
                        }
                        this.f14490a.onMessage(false, result);
                    }
                } catch (Exception e5) {
                    e222 = e5;
                    e3 = null;
                    e222.printStackTrace();
                    if (e222 == null && e222.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                        try {
                            result = TagManager.f14504f.update(e3, false, this.f14491b);
                            this.f14490a.onMessage(true, result);
                            return;
                        } catch (Exception e2222) {
                            this.f14490a.onMessage(false, result);
                            e2222.printStackTrace();
                            return;
                        }
                    }
                    this.f14490a.onMessage(false, result);
                }
            }
        }
    }

    /* renamed from: com.umeng.message.tag.TagManager.3 */
    class C42463 implements Runnable {
        final /* synthetic */ TCallBack f14493a;
        final /* synthetic */ String[] f14494b;
        final /* synthetic */ TagManager f14495c;

        C42463(TagManager tagManager, TCallBack tCallBack, String[] strArr) {
            this.f14495c = tagManager;
            this.f14493a = tCallBack;
            this.f14494b = strArr;
        }

        public void run() {
            Exception e;
            Result result = null;
            if (this.f14495c.m17345d()) {
                try {
                    throw new Exception("Tag API is disabled by the server.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f14493a.onMessage(false, null);
                }
            } else if (this.f14495c.m17343c()) {
                if (this.f14494b == null || this.f14494b.length == 0) {
                    try {
                        throw new Exception("No tags");
                    } catch (Exception e22) {
                        e22.printStackTrace();
                        this.f14493a.onMessage(false, null);
                    }
                }
                JSONObject e3;
                try {
                    e3 = this.f14495c.m17340b();
                    try {
                        e3.put(MsgConstant.KEY_TAGS, TagManager.m17339b(this.f14494b));
                        result = TagManager.f14504f.delete(e3, true, this.f14494b);
                        this.f14493a.onMessage(true, result);
                    } catch (Exception e4) {
                        e22 = e4;
                        e22.printStackTrace();
                        if (e22 == null && e22.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                            try {
                                result = TagManager.f14504f.delete(e3, false, this.f14494b);
                                this.f14493a.onMessage(true, result);
                                return;
                            } catch (Exception e222) {
                                this.f14493a.onMessage(false, result);
                                e222.printStackTrace();
                                return;
                            }
                        }
                        this.f14493a.onMessage(false, result);
                    }
                } catch (Exception e5) {
                    e222 = e5;
                    e3 = null;
                    e222.printStackTrace();
                    if (e222 == null) {
                    }
                    this.f14493a.onMessage(false, result);
                }
            } else {
                try {
                    throw new Exception("No utdid or device_token");
                } catch (Exception e2222) {
                    e2222.printStackTrace();
                    this.f14493a.onMessage(false, null);
                }
            }
        }
    }

    /* renamed from: com.umeng.message.tag.TagManager.4 */
    class C42474 implements Runnable {
        final /* synthetic */ TCallBack f14496a;
        final /* synthetic */ TagManager f14497b;

        C42474(TagManager tagManager, TCallBack tCallBack) {
            this.f14497b = tagManager;
            this.f14496a = tCallBack;
        }

        public void run() {
            Exception e;
            Result result = null;
            if (this.f14497b.m17345d()) {
                try {
                    throw new Exception("Tag API is disabled by the server.");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.f14496a.onMessage(false, null);
                }
            } else if (this.f14497b.m17343c()) {
                JSONObject e3;
                try {
                    e3 = this.f14497b.m17340b();
                    try {
                        result = TagManager.f14504f.reset(e3, true);
                        this.f14496a.onMessage(true, result);
                    } catch (Exception e4) {
                        e2 = e4;
                        e2.printStackTrace();
                        if (e2 == null) {
                        }
                        this.f14496a.onMessage(false, result);
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    e3 = null;
                    e2.printStackTrace();
                    if (e2 == null && e2.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                        try {
                            result = TagManager.f14504f.reset(e3, false);
                            this.f14496a.onMessage(true, result);
                            return;
                        } catch (Exception e22) {
                            this.f14496a.onMessage(false, result);
                            e22.printStackTrace();
                            return;
                        }
                    }
                    this.f14496a.onMessage(false, result);
                }
            } else {
                try {
                    throw new Exception("No utdid or device_token");
                } catch (Exception e222) {
                    e222.printStackTrace();
                    this.f14496a.onMessage(false, null);
                }
            }
        }
    }

    /* renamed from: com.umeng.message.tag.TagManager.5 */
    class C42485 implements Runnable {
        final /* synthetic */ TagListCallBack f14498a;
        final /* synthetic */ TagManager f14499b;

        C42485(TagManager tagManager, TagListCallBack tagListCallBack) {
            this.f14499b = tagManager;
            this.f14498a = tagListCallBack;
        }

        public void run() {
            Exception e;
            JSONObject e2;
            List list = null;
            if (this.f14499b.m17345d()) {
                try {
                    throw new Exception("Tag API is disabled by the server.");
                } catch (Exception e3) {
                    e3.printStackTrace();
                    this.f14498a.onMessage(false, null);
                }
            } else if (this.f14499b.m17343c()) {
                try {
                    e2 = this.f14499b.m17340b();
                    try {
                        list = TagManager.f14504f.list(e2, true);
                        this.f14498a.onMessage(true, list);
                    } catch (Exception e4) {
                        e3 = e4;
                        if (e3 != null) {
                            this.f14498a.onMessage(false, list);
                        } else if (e3.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                            try {
                                list = TagManager.f14504f.list(e2, false);
                                this.f14498a.onMessage(true, list);
                            } catch (Exception e5) {
                                this.f14498a.onMessage(false, list);
                            }
                        } else {
                            this.f14498a.onMessage(false, list);
                        }
                    }
                } catch (Exception e6) {
                    e3 = e6;
                    e2 = null;
                    if (e3 != null) {
                        this.f14498a.onMessage(false, list);
                    } else if (e3.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                        list = TagManager.f14504f.list(e2, false);
                        this.f14498a.onMessage(true, list);
                    } else {
                        this.f14498a.onMessage(false, list);
                    }
                }
            } else {
                try {
                    throw new Exception("No utdid or device_token");
                } catch (Exception e32) {
                    e32.printStackTrace();
                    this.f14498a.onMessage(false, null);
                }
            }
        }
    }

    public interface TagListCallBack {
        void onMessage(boolean z, List<String> list);
    }

    static {
        f14500a = TagManager.class.getName();
    }

    private TagManager(Context context) {
        this.f14505e = context.getApplicationContext();
    }

    private static JSONObject m17336a(JSONObject jSONObject, String str) {
        String b = HttpRequest.m17396c((CharSequence) str).m17423H().m17522r(HttpRequest.f14550c).m17502i(jSONObject.toString()).m17474b(HttpRequest.f14548a);
        UmLog.m17136d(f14500a, "postJson() url=" + str + "\n request = " + jSONObject + "\n response = " + b);
        return new JSONObject(b);
    }

    private static String m17338b(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(append).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static String m17339b(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private JSONObject m17340b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, UTrack.getInstance(this.f14505e).getHeader());
        jSONObject.put(MsgConstant.KEY_UTDID, UmengMessageDeviceConfig.getUtdid(this.f14505e));
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(this.f14505e).getDeviceToken());
        jSONObject.put(MsgConstant.KEY_TS, System.currentTimeMillis());
        return jSONObject;
    }

    private boolean m17343c() {
        if (TextUtils.isEmpty(UmengMessageDeviceConfig.getUtdid(this.f14505e))) {
            UmLog.m17138e(f14500a, "UTDID is empty");
            return false;
        } else if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f14505e).getDeviceToken())) {
            return true;
        } else {
            UmLog.m17138e(f14500a, "RegistrationId is empty");
            return false;
        }
    }

    private boolean m17345d() {
        boolean z = true;
        if (MessageSharedPrefs.getInstance(this.f14505e).getTagSendPolicy() != 1) {
            z = false;
        }
        if (z) {
            UmLog.m17136d(f14500a, "tag is disabled by the server");
        }
        return z;
    }

    private Result m17346e() {
        Result result = new Result(new JSONObject());
        result.remain = MessageSharedPrefs.getInstance(this.f14505e).getTagRemain();
        result.status = f14501b;
        result.jsonString = "status:" + result.status + Constants.ACCEPT_TIME_SEPARATOR_SP + " remain:" + result.remain + Constants.ACCEPT_TIME_SEPARATOR_SP + "description:" + result.status;
        return result;
    }

    public static synchronized TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (f14503d == null) {
                f14503d = new TagManager(context.getApplicationContext());
                try {
                    f14504f = (ITagManager) Class.forName(C4213a.f14290c).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            tagManager = f14503d;
        }
        return tagManager;
    }

    public void add(TCallBack tCallBack, String... strArr) {
        new Thread(new C42441(this, tCallBack, strArr)).start();
    }

    public void delete(TCallBack tCallBack, String... strArr) {
        new Thread(new C42463(this, tCallBack, strArr)).start();
    }

    public void list(TagListCallBack tagListCallBack) {
        new Thread(new C42485(this, tagListCallBack)).start();
    }

    public void reset(TCallBack tCallBack) {
        new Thread(new C42474(this, tCallBack)).start();
    }

    public void update(TCallBack tCallBack, String... strArr) {
        new Thread(new C42452(this, tCallBack, strArr)).start();
    }
}
