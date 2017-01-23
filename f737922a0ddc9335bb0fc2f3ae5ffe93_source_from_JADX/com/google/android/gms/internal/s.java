package com.google.android.gms.internal;

import java.io.IOException;

public class s extends IOException {
    public s(String str) {
        super(str);
    }

    static s DW() {
        return new s("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static s FH() {
        return new s("CodedInputStream encountered a malformed varint.");
    }

    static s Hw() {
        return new s("Protocol message contained an invalid tag (zero).");
    }

    static s VH() {
        return new s("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static s Zo() {
        return new s("Protocol message tag had invalid wire type.");
    }

    static s j6() {
        return new s("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static s v5() {
        return new s("Protocol message end-group tag did not match expected tag.");
    }
}
