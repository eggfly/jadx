package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.media.session.MediaSessionCompat.Token;

/* renamed from: android.support.v7.app.n */
public class C0395n extends NotificationCompat {

    /* renamed from: android.support.v7.app.n.a */
    public static class C0390a extends Builder {
        public C0390a(Context context) {
            super(context);
        }

        protected BuilderExtender getExtender() {
            return VERSION.SDK_INT >= 21 ? new C0393d() : VERSION.SDK_INT >= 16 ? new C0392c() : VERSION.SDK_INT >= 14 ? new C0391b() : super.getExtender();
        }
    }

    /* renamed from: android.support.v7.app.n.b */
    private static class C0391b extends BuilderExtender {
        private C0391b() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            C0395n.m1090b(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.n.c */
    private static class C0392c extends BuilderExtender {
        private C0392c() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            C0395n.m1090b(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            C0395n.m1089b(build, builder);
            return build;
        }
    }

    /* renamed from: android.support.v7.app.n.d */
    private static class C0393d extends BuilderExtender {
        private C0393d() {
        }

        public Notification build(Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            C0395n.m1091b(notificationBuilderWithBuilderAccessor, builder.mStyle);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* renamed from: android.support.v7.app.n.e */
    public static class C0394e extends Style {
        int[] f983a;
        Token f984b;
        boolean f985c;
        PendingIntent f986d;

        public C0394e() {
            this.f983a = null;
        }
    }

    private static void m1089b(Notification notification, Builder builder) {
        if (builder.mStyle instanceof C0394e) {
            C0394e c0394e = (C0394e) builder.mStyle;
            Notification notification2 = notification;
            C0397p.m1098a(notification2, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, c0394e.f985c, c0394e.f986d);
        }
    }

    private static void m1090b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Builder builder) {
        if (builder.mStyle instanceof C0394e) {
            C0394e c0394e = (C0394e) builder.mStyle;
            NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor2 = notificationBuilderWithBuilderAccessor;
            C0397p.m1099a(notificationBuilderWithBuilderAccessor2, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.mNotification.when, builder.mActions, c0394e.f983a, c0394e.f985c, c0394e.f986d);
        }
    }

    private static void m1091b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Style style) {
        if (style instanceof C0394e) {
            C0394e c0394e = (C0394e) style;
            C0396o.m1092a(notificationBuilderWithBuilderAccessor, c0394e.f983a, c0394e.f984b != null ? c0394e.f984b.getToken() : null);
        }
    }
}
