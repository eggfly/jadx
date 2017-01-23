package android.support.v4.print;

public final class PrintHelper {

    public interface OnPrintFinishCallback {
        void m1011a();
    }

    interface PrintHelperVersionImpl {
    }

    private static final class PrintHelperKitkatImpl implements PrintHelperVersionImpl {

        /* renamed from: android.support.v4.print.PrintHelper.PrintHelperKitkatImpl.1 */
        class C00671 implements android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback {
            final /* synthetic */ OnPrintFinishCallback f637a;

            public void m1013a() {
                this.f637a.m1011a();
            }
        }

        /* renamed from: android.support.v4.print.PrintHelper.PrintHelperKitkatImpl.2 */
        class C00682 implements android.support.v4.print.PrintHelperKitkat.OnPrintFinishCallback {
            final /* synthetic */ OnPrintFinishCallback f638a;

            public void m1014a() {
                this.f638a.m1011a();
            }
        }
    }

    private static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int f639a;
        int f640b;
        int f641c;

        private PrintHelperStubImpl() {
            this.f639a = 2;
            this.f640b = 2;
            this.f641c = 1;
        }
    }
}
