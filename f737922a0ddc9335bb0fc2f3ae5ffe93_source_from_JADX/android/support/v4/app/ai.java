package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.ah.a;

class ai {
    static Bundle j6(a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", aVar.j6());
        bundle.putCharSequence("label", aVar.DW());
        bundle.putCharSequenceArray("choices", aVar.FH());
        bundle.putBoolean("allowFreeFormInput", aVar.Hw());
        bundle.putBundle("extras", aVar.v5());
        return bundle;
    }

    static Bundle[] j6(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            bundleArr[i] = j6(aVarArr[i]);
        }
        return bundleArr;
    }
}
