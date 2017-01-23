package com.umeng.message;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.umeng.analytics.C4156a;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.C4230g;
import com.umeng.message.provider.C4243a;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengMessageCallbackHandlerService extends IntentService {
    public static final String TAG;
    private Context f14189a;

    /* renamed from: com.umeng.message.UmengMessageCallbackHandlerService.1 */
    class C42071 implements Runnable {
        final /* synthetic */ UmengMessageCallbackHandlerService f14188a;

        C42071(UmengMessageCallbackHandlerService umengMessageCallbackHandlerService) {
            this.f14188a = umengMessageCallbackHandlerService;
        }

        public void run() {
            PushAgent.getInstance(this.f14188a.f14189a).onAppStart();
        }
    }

    static {
        TAG = UmengMessageCallbackHandlerService.class.getName();
    }

    public UmengMessageCallbackHandlerService() {
        super("UmengMessageCallbackHandlerService");
        this.f14189a = this;
    }

    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "processName=" + C4230g.m17257a(this.f14189a, Process.myPid()));
        if (intent != null && intent.getAction() != null) {
            if (intent.getAction().equals(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION)) {
                try {
                    String stringExtra = intent.getStringExtra(MsgConstant.KEY_REGISTRATION_ID);
                    boolean booleanExtra = intent.getBooleanExtra(MsgConstant.KEY_STATUS, false);
                    Log.d(TAG, "enable(): register-->:" + stringExtra + ",status:" + booleanExtra);
                    IUmengRegisterCallback registerCallback = PushAgent.getInstance(this.f14189a).getRegisterCallback();
                    if (booleanExtra) {
                        String deviceToken = MessageSharedPrefs.getInstance(this.f14189a).getDeviceToken();
                        if (!(stringExtra == null || deviceToken == null || stringExtra.equals(deviceToken))) {
                            MessageSharedPrefs.getInstance(this.f14189a).setHasResgister(false);
                            MessageSharedPrefs.getInstance(this.f14189a).setDeviceToken(stringExtra);
                            ContentResolver contentResolver = this.f14189a.getContentResolver();
                            C4243a.m17332a(this.f14189a);
                            contentResolver.delete(C4243a.f14478e, null, null);
                        }
                        if (registerCallback != null) {
                            UTrack.getInstance(this.f14189a).trackRegister();
                            registerCallback.onSuccess(stringExtra);
                            new Handler(getMainLooper()).postDelayed(new C42071(this), 10000);
                        }
                    } else if (registerCallback != null) {
                        registerCallback.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (intent.getAction().equals(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION)) {
                try {
                    r0 = intent.getBooleanExtra(MsgConstant.KEY_STATUS, false);
                    r1 = PushAgent.getInstance(this.f14189a).getCallback();
                    Log.d(TAG, "enable()-->status:" + r0);
                    if (r0) {
                        if (r1 != null) {
                            r1.onSuccess();
                        }
                    } else if (r1 != null) {
                        r1.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (intent.getAction().equals(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION)) {
                try {
                    r0 = intent.getBooleanExtra(MsgConstant.KEY_STATUS, false);
                    r1 = PushAgent.getInstance(this.f14189a).getCallback();
                    Log.d(TAG, "disable()-->status:" + r0);
                    if (r0) {
                        if (r1 != null) {
                            r1.onSuccess();
                        }
                    } else if (r1 != null) {
                        r1.onFailure(intent.getStringExtra("s"), intent.getStringExtra("s1"));
                    }
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            } else if (intent.getAction().equals(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION)) {
                try {
                    UHandler messageHandler = PushAgent.getInstance(this.f14189a).getMessageHandler();
                    Log.d(TAG, "messageHandler=" + messageHandler);
                    if (messageHandler != null) {
                        UMessage uMessage = new UMessage(new JSONObject(intent.getStringExtra(C4156a.f13961w)));
                        uMessage.message_id = intent.getStringExtra(AgooConstants.MESSAGE_ID);
                        uMessage.task_id = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
                        messageHandler.handleMessage(this.f14189a, uMessage);
                    }
                } catch (Exception e222) {
                    Log.d(TAG, e222.toString());
                }
            }
        }
    }
}
