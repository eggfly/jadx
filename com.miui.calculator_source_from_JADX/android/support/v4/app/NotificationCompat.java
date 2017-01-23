package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompatBase.Action.Factory;
import java.util.ArrayList;

public class NotificationCompat {
    private static final NotificationCompatImpl f346a;

    public static class Action extends android.support.v4.app.NotificationCompatBase.Action {
        public static final Factory f329a;

        /* renamed from: android.support.v4.app.NotificationCompat.Action.1 */
        final class C00311 implements Factory {
            C00311() {
            }
        }

        public static final class Builder {
        }

        public interface Extender {
        }

        public static final class WearableExtender implements Extender {
            private int f325a;
            private CharSequence f326b;
            private CharSequence f327c;
            private CharSequence f328d;

            public /* synthetic */ Object clone() {
                return m457a();
            }

            public WearableExtender() {
                this.f325a = 1;
            }

            public WearableExtender m457a() {
                WearableExtender wearableExtender = new WearableExtender();
                wearableExtender.f325a = this.f325a;
                wearableExtender.f326b = this.f326b;
                wearableExtender.f327c = this.f327c;
                wearableExtender.f328d = this.f328d;
                return wearableExtender;
            }
        }

        static {
            f329a = new C00311();
        }
    }

    public static abstract class Style {
        boolean f330b;

        public Style() {
            this.f330b = false;
        }
    }

    public static class BigPictureStyle extends Style {
    }

    public static class BigTextStyle extends Style {
    }

    public static class Builder {
    }

    protected static class BuilderExtender {
        protected BuilderExtender() {
        }
    }

    public interface Extender {
    }

    public static final class CarExtender implements Extender {
        private int f332a;

        public static class UnreadConversation extends android.support.v4.app.NotificationCompatBase.UnreadConversation {
            static final android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory f331a;

            /* renamed from: android.support.v4.app.NotificationCompat.CarExtender.UnreadConversation.1 */
            final class C00321 implements android.support.v4.app.NotificationCompatBase.UnreadConversation.Factory {
                C00321() {
                }
            }

            public static class Builder {
            }

            static {
                f331a = new C00321();
            }
        }

        public CarExtender() {
            this.f332a = 0;
        }
    }

    public static class InboxStyle extends Style {
        ArrayList<CharSequence> f333a;

        public InboxStyle() {
            this.f333a = new ArrayList();
        }
    }

    interface NotificationCompatImpl {
    }

    static class NotificationCompatImplBase implements NotificationCompatImpl {
        NotificationCompatImplBase() {
        }
    }

    static class NotificationCompatImplJellybean extends NotificationCompatImplBase {
        NotificationCompatImplJellybean() {
        }
    }

    static class NotificationCompatImplKitKat extends NotificationCompatImplJellybean {
        NotificationCompatImplKitKat() {
        }
    }

    static class NotificationCompatImplApi20 extends NotificationCompatImplKitKat {
        NotificationCompatImplApi20() {
        }
    }

    static class NotificationCompatImplApi21 extends NotificationCompatImplApi20 {
        NotificationCompatImplApi21() {
        }
    }

    static class NotificationCompatImplGingerbread extends NotificationCompatImplBase {
        NotificationCompatImplGingerbread() {
        }
    }

    static class NotificationCompatImplHoneycomb extends NotificationCompatImplBase {
        NotificationCompatImplHoneycomb() {
        }
    }

    static class NotificationCompatImplIceCreamSandwich extends NotificationCompatImplBase {
        NotificationCompatImplIceCreamSandwich() {
        }
    }

    public static final class WearableExtender implements Extender {
        private ArrayList<Action> f334a;
        private int f335b;
        private PendingIntent f336c;
        private ArrayList<Notification> f337d;
        private Bitmap f338e;
        private int f339f;
        private int f340g;
        private int f341h;
        private int f342i;
        private int f343j;
        private int f344k;
        private int f345l;

        public /* synthetic */ Object clone() {
            return m458a();
        }

        public WearableExtender() {
            this.f334a = new ArrayList();
            this.f335b = 1;
            this.f337d = new ArrayList();
            this.f340g = 8388613;
            this.f341h = -1;
            this.f342i = 0;
            this.f344k = 80;
        }

        public WearableExtender m458a() {
            WearableExtender wearableExtender = new WearableExtender();
            wearableExtender.f334a = new ArrayList(this.f334a);
            wearableExtender.f335b = this.f335b;
            wearableExtender.f336c = this.f336c;
            wearableExtender.f337d = new ArrayList(this.f337d);
            wearableExtender.f338e = this.f338e;
            wearableExtender.f339f = this.f339f;
            wearableExtender.f340g = this.f340g;
            wearableExtender.f341h = this.f341h;
            wearableExtender.f342i = this.f342i;
            wearableExtender.f343j = this.f343j;
            wearableExtender.f344k = this.f344k;
            wearableExtender.f345l = this.f345l;
            return wearableExtender;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f346a = new NotificationCompatImplApi21();
        } else if (VERSION.SDK_INT >= 20) {
            f346a = new NotificationCompatImplApi20();
        } else if (VERSION.SDK_INT >= 19) {
            f346a = new NotificationCompatImplKitKat();
        } else if (VERSION.SDK_INT >= 16) {
            f346a = new NotificationCompatImplJellybean();
        } else if (VERSION.SDK_INT >= 14) {
            f346a = new NotificationCompatImplIceCreamSandwich();
        } else if (VERSION.SDK_INT >= 11) {
            f346a = new NotificationCompatImplHoneycomb();
        } else if (VERSION.SDK_INT >= 9) {
            f346a = new NotificationCompatImplGingerbread();
        } else {
            f346a = new NotificationCompatImplBase();
        }
    }
}
