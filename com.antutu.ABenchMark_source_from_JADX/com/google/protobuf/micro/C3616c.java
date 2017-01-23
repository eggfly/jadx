package com.google.protobuf.micro;

import java.io.IOException;

/* renamed from: com.google.protobuf.micro.c */
public class C3616c extends IOException {
    public C3616c(String str) {
        super(str);
    }

    static C3616c m14866a() {
        return new C3616c("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static C3616c m14867b() {
        return new C3616c("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static C3616c m14868c() {
        return new C3616c("CodedInputStream encountered a malformed varint.");
    }

    static C3616c m14869d() {
        return new C3616c("Protocol message contained an invalid tag (zero).");
    }

    static C3616c m14870e() {
        return new C3616c("Protocol message end-group tag did not match expected tag.");
    }

    static C3616c m14871f() {
        return new C3616c("Protocol message tag had invalid wire type.");
    }

    static C3616c m14872g() {
        return new C3616c("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
