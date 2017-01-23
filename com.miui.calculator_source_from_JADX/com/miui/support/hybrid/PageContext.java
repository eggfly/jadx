package com.miui.support.hybrid;

public class PageContext {
    private String f2064a;
    private String f2065b;

    public void m3548a(String str) {
        this.f2064a = str;
    }

    public String m3547a() {
        return this.f2065b;
    }

    public void m3549b(String str) {
        this.f2065b = str;
    }

    public int hashCode() {
        return (this.f2064a == null ? 0 : this.f2064a.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PageContext pageContext = (PageContext) obj;
        if (this.f2064a == pageContext.f2064a) {
            return true;
        }
        if (this.f2064a == null || pageContext.f2064a == null || !this.f2064a.equals(pageContext.f2064a)) {
            return false;
        }
        return true;
    }
}
