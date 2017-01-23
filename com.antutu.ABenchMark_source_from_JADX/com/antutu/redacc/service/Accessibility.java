package com.antutu.redacc.service;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.antutu.redacc.activity.AccelerateActivity;
import com.antutu.redacc.p067f.C1762r;
import java.util.List;

public class Accessibility extends AccessibilityService {
    public static final String[] f6214a;
    public static final String[] f6215b;
    public static final String[] f6216c;
    public static final String[] f6217d;
    public static final String[] f6218e;
    public static final String[] f6219f;
    String[] f6220g;
    private boolean f6221h;

    static {
        f6214a = new String[]{"android.app.AlertDialog", "com.letv.leui.widget.LeBottomSheet", "com.htc.lib1.cc.widget.HtcAlertDialog", "com.htc.widget.HtcAlertDialog"};
        f6215b = new String[]{"com.android.settings.applications.InstalledAppDetailsTop", "com.android.settings.SubSettings"};
        f6216c = new String[]{"com.android.settings:id/force_stop_button", "miui:id/v5_icon_menu_bar_primary_item"};
        f6217d = new String[]{"com.android.settings:id/button1", "android:id/button1"};
        f6218e = new String[]{"\u7ed3\u675f\u8fd0\u884c", "\u5f3a\u5236\u505c\u6b62", "\u5f3a\u884c\u505c\u6b62"};
        f6219f = new String[]{"\u5f3a\u5236\u505c\u6b62", "\u786e\u5b9a", "OK"};
    }

    public Accessibility() {
        this.f6220g = new String[]{"com.android.settings"};
        this.f6221h = false;
    }

    @SuppressLint({"NewApi"})
    private boolean m6812b(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            try {
                if (child.getClassName().equals("android.widget.Button")) {
                    CharSequence text = child.getText();
                    if (text != null) {
                        String charSequence = text.toString();
                        for (Object equals : f6218e) {
                            if (charSequence.equals(equals)) {
                                this.f6221h = m6815a(child);
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
            if (child != null && m6812b(child)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private boolean m6813c(AccessibilityNodeInfo accessibilityNodeInfo) {
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            try {
                if (child.getClassName().equals("android.widget.Button")) {
                    CharSequence text = child.getText();
                    if (text != null) {
                        for (Object equals : f6219f) {
                            if (text.toString().equals(equals)) {
                                this.f6221h = m6815a(child);
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
            if (child != null && m6813c(child)) {
                return true;
            }
        }
        return false;
    }

    public void m6814a() {
        try {
            Intent intent = new Intent(this, AccelerateActivity.class);
            intent.putExtra("EXTRA_START_CLEAN", true);
            intent.setFlags(805306368);
            startActivity(intent);
        } catch (Exception e) {
        }
    }

    @SuppressLint({"NewApi"})
    public boolean m6815a(AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            if (accessibilityNodeInfo.getChildCount() == 0 && accessibilityNodeInfo.getClassName().toString().equals("android.widget.Button") && accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.isEnabled()) {
                accessibilityNodeInfo.performAction(16);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            if (C1762r.m6776e().m6795b() && accessibilityEvent.getEventType() == 32) {
                Object obj;
                String charSequence = accessibilityEvent.getClassName().toString();
                for (String equals : f6215b) {
                    if (equals.equals(charSequence)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    int i = 0;
                    obj = null;
                    while (i < 5) {
                        try {
                            Thread.sleep(200);
                        } catch (Exception e) {
                        }
                        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();
                        if (rootInActiveWindow != null) {
                            List list;
                            Object obj2;
                            List list2 = null;
                            if (VERSION.SDK_INT > 17) {
                                for (String findAccessibilityNodeInfosByViewId : f6216c) {
                                    list2 = rootInActiveWindow.findAccessibilityNodeInfosByViewId(findAccessibilityNodeInfosByViewId);
                                    if (list2 != null && list2.size() > 0) {
                                        list = list2;
                                        obj2 = 1;
                                        break;
                                    }
                                }
                                List list3 = list2;
                                obj2 = obj;
                                list = list3;
                            } else {
                                obj2 = obj;
                                list = null;
                            }
                            if (obj2 != null) {
                                this.f6221h = m6815a((AccessibilityNodeInfo) list.get(0));
                            } else {
                                m6812b(rootInActiveWindow);
                                int i2 = 1;
                            }
                            rootInActiveWindow.recycle();
                            if (obj2 == null) {
                                i++;
                                obj = obj2;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                } else if (this.f6221h) {
                    for (String equals2 : f6214a) {
                        if (equals2.equals(charSequence)) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        this.f6221h = false;
                        try {
                            Thread.sleep(50);
                        } catch (Exception e2) {
                        }
                        AccessibilityNodeInfo rootInActiveWindow2 = getRootInActiveWindow();
                        if (rootInActiveWindow2 != null) {
                            if (VERSION.SDK_INT > 17) {
                                for (String equals22 : f6217d) {
                                    List findAccessibilityNodeInfosByViewId2 = rootInActiveWindow2.findAccessibilityNodeInfosByViewId(equals22);
                                    if (findAccessibilityNodeInfosByViewId2 != null && findAccessibilityNodeInfosByViewId2.size() > 0) {
                                        m6815a((AccessibilityNodeInfo) findAccessibilityNodeInfosByViewId2.get(0));
                                        obj = 1;
                                        break;
                                    }
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                m6813c(rootInActiveWindow2);
                            }
                            rootInActiveWindow2.recycle();
                            C1762r.m6776e().m6790a(false);
                        }
                    }
                }
            }
        } catch (Exception e3) {
        }
    }

    public void onCreate() {
        boolean l = C1762r.m6776e().m6810l();
        C1762r.m6776e().m6797c(true);
        if (l) {
            m6814a();
        }
        super.onCreate();
    }

    public void onDestroy() {
        C1762r.m6776e().m6797c(false);
        super.onDestroy();
    }

    public void onInterrupt() {
    }

    protected void onServiceConnected() {
        try {
            AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
            accessibilityServiceInfo.packageNames = this.f6220g;
            accessibilityServiceInfo.eventTypes = 32;
            accessibilityServiceInfo.feedbackType = 16;
            accessibilityServiceInfo.notificationTimeout = 0;
            setServiceInfo(accessibilityServiceInfo);
        } catch (Exception e) {
        }
    }
}
