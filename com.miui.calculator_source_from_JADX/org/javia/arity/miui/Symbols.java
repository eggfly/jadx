package org.javia.arity.miui;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class Symbols {
    private static final Symbol[] f4996a;
    private static Symbol f4997b;
    private static final String[] f4998g;
    private final Compiler f4999c;
    private Hashtable f5000d;
    private HashSet<Symbol> f5001e;
    private Stack<HashSet<Symbol>> f5002f;

    static {
        int i;
        f4997b = new Symbol(null, 0.0d, false);
        Vector vector = new Vector();
        for (byte b : VM.f5023c) {
            vector.addElement(Symbol.m6759b(VM.f5021a[b], b));
        }
        String[] strArr = new String[]{"x", "y", "z"};
        for (i = 0; i < strArr.length; i = (byte) (i + 1)) {
            vector.addElement(Symbol.m6757a(strArr[i], i));
        }
        vector.addElement(new Symbol("pi", 3.141592653589793d, true));
        vector.addElement(new Symbol("\u03c0", 3.141592653589793d, true));
        vector.addElement(new Symbol("e", 2.718281828459045d, true));
        vector.addElement(new Symbol("Infinity", Double.POSITIVE_INFINITY, true));
        vector.addElement(new Symbol("infinity", Double.POSITIVE_INFINITY, true));
        vector.addElement(new Symbol("Inf", Double.POSITIVE_INFINITY, true));
        vector.addElement(new Symbol("inf", Double.POSITIVE_INFINITY, true));
        vector.addElement(new Symbol("\u221e", Double.POSITIVE_INFINITY, true));
        vector.addElement(new Symbol("NaN", Double.NaN, true));
        vector.addElement(new Symbol("nan", Double.NaN, true));
        vector.addElement(new Symbol("i", 0.0d, 1.0d, true));
        vector.addElement(new Symbol("j", 0.0d, 1.0d, false));
        f4996a = new Symbol[vector.size()];
        vector.copyInto(f4996a);
        f4998g = new String[]{"log(x)=ln(x)*0.43429448190325182765", "log10(x)=log(x)", "lg(x)=log(x)", "log2(x)=ln(x)*1.4426950408889634074", "lb(x)=log2(x)", "log(base,x)=ln(x)/ln(base)", "gamma(x)=(x-1)!", "deg=0.017453292519943295", "indeg=57.29577951308232", "sind(x)=sin(x deg)", "cosd(x)=cos(x deg)", "tand(x)=tan(x deg)", "asind(x)=asin(x) indeg", "acosd(x)=acos(x) indeg", "atand(x)=atan(x) indeg", "tg(x)=tan(x)", "tgd(x)=tand(x)"};
    }

    public Symbols() {
        int i = 0;
        this.f4999c = new Compiler();
        this.f5000d = new Hashtable();
        this.f5001e = null;
        this.f5002f = new Stack();
        for (Symbol a : f4996a) {
            m6768a(a);
        }
        while (i < f4998g.length) {
            try {
                m6767a(m6770b(f4998g[i]));
                i++;
            } catch (SyntaxException e) {
                throw new Error("" + e);
            }
        }
    }

    public synchronized double m6762a(String str) {
        return this.f4999c.m6660a(this, str).m6632c();
    }

    public synchronized FunctionAndName m6770b(String str) {
        return this.f4999c.m6662c(this, str);
    }

    public synchronized Function m6772c(String str) {
        return this.f4999c.m6661b(this, str);
    }

    public synchronized void m6766a(String str, Function function) {
        if (function instanceof Constant) {
            m6765a(str, function.m6632c());
        } else {
            m6768a(new Symbol(str, function));
        }
    }

    public synchronized void m6767a(FunctionAndName functionAndName) {
        if (functionAndName.f4940b != null) {
            m6766a(functionAndName.f4940b, functionAndName.f4939a);
        }
    }

    public synchronized void m6765a(String str, double d) {
        m6768a(new Symbol(str, d, 0.0d, false));
    }

    public synchronized void m6764a() {
        this.f5002f.push(this.f5001e);
        this.f5001e = null;
    }

    public synchronized void m6771b() {
        if (this.f5001e != null) {
            Iterator it = this.f5001e.iterator();
            while (it.hasNext()) {
                Symbol symbol = (Symbol) it.next();
                if (symbol.m6760a()) {
                    this.f5000d.remove(symbol);
                } else {
                    this.f5000d.put(symbol, symbol);
                }
            }
        }
        this.f5001e = (HashSet) this.f5002f.pop();
    }

    void m6769a(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            m6768a(Symbol.m6757a(strArr[i], i));
        }
    }

    void m6768a(Symbol symbol) {
        Object obj = (Symbol) this.f5000d.put(symbol, symbol);
        if (obj == null || !obj.f4993e) {
            if (this.f5001e == null) {
                this.f5001e = new HashSet();
            }
            if (!this.f5001e.contains(symbol)) {
                HashSet hashSet = this.f5001e;
                if (obj == null) {
                    obj = Symbol.m6758a(symbol);
                }
                hashSet.add(obj);
                return;
            }
            return;
        }
        this.f5000d.put(obj, obj);
    }

    synchronized Symbol m6763a(String str, int i) {
        return (Symbol) this.f5000d.get(f4997b.m6761c(str, i));
    }
}
