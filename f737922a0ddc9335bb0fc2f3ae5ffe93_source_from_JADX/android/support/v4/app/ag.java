package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.ah.a;

class ag {
    static RemoteInput[] j6(a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            remoteInputArr[i] = new Builder(aVar.j6()).setLabel(aVar.DW()).setChoices(aVar.FH()).setAllowFreeFormInput(aVar.Hw()).addExtras(aVar.v5()).build();
        }
        return remoteInputArr;
    }
}
