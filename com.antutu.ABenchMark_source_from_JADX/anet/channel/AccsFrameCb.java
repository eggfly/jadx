package anet.channel;

import anet.channel.session.AccsSession;

public interface AccsFrameCb {
    void onDataReceive(AccsSession accsSession, byte[] bArr, int i, int i2);

    void onException(int i, int i2, boolean z, String str);
}
