package com.p105c.p106a.p111c;

import com.p105c.p106a.p107a.p108a.C2084a;
import com.p105c.p106a.p107a.p108a.C2088b;
import java.util.Random;

/* renamed from: com.c.a.c.e */
public class C2105e {
    private static Random f7401b;
    private String f7402a;

    static {
        f7401b = new Random();
    }

    public C2105e() {
        this.f7402a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f7402a = C2088b.m7802b(this.f7402a.getBytes(), 2);
    }

    public String m7909a(String str) {
        return C2084a.m7789a(this.f7402a, str);
    }

    public String m7910a(byte[] bArr) {
        return C2084a.m7789a(this.f7402a, C2088b.m7802b(bArr, 2));
    }

    public String m7911b(String str) {
        return C2084a.m7794b(this.f7402a, str);
    }
}
