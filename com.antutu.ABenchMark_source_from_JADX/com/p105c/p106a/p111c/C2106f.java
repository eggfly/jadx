package com.p105c.p106a.p111c;

import com.p105c.p106a.p107a.p108a.C2084a;
import com.p105c.p106a.p107a.p108a.C2088b;
import com.p105c.p106a.p107a.p108a.C2091e;

/* renamed from: com.c.a.c.f */
public class C2106f {
    private String f7403a;

    public C2106f() {
        this.f7403a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f7403a = C2088b.m7802b(this.f7403a.getBytes(), 0);
    }

    public String m7912a(String str) {
        return C2084a.m7794b(this.f7403a, str);
    }

    public String m7913b(String str) {
        String b = C2084a.m7794b(this.f7403a, str);
        if (C2091e.m7809a(b)) {
            return null;
        }
        try {
            return new String(C2088b.m7799a(b, 0));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
