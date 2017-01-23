package anet.channel.entity;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.taobao.accs.data.Message;
import org.android.spdy.SpdyProtocol;

public enum EventType {
    CONNECTED(1),
    DISCONNECTED(2),
    HEADER_SEND(4),
    DATA_SEND(8),
    HEADER_RECEIVE(16),
    DATA_RECEIVE(32),
    PING_SEND(64),
    PIND_RECEIVE(SpdyProtocol.SLIGHTSSLV2),
    CONNECT_FAIL(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY),
    AUTH_SUCC(AccessibilityNodeInfoCompat.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY),
    AUTH_FAIL(IXAdIOUtils.BUFFER_SIZE),
    DATA_TIMEOUT(Message.FLAG_RET),
    HORSE_RIDE(SpdyProtocol.SLIGHTSSL_0_RTT_MODE),
    ALL(8191);
    
    private int value;

    private EventType(int i) {
        this.value = i;
    }

    public int getType() {
        return this.value;
    }
}
