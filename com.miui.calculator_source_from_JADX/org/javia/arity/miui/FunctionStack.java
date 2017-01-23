package org.javia.arity.miui;

class FunctionStack {
    private Function[] f4941a;
    private int f4942b;

    FunctionStack() {
        this.f4941a = new Function[8];
        this.f4942b = 0;
    }

    void m6721a() {
        this.f4942b = 0;
    }

    void m6722a(Function function) {
        if (this.f4942b >= this.f4941a.length) {
            Object obj = new Function[(this.f4941a.length << 1)];
            System.arraycopy(this.f4941a, 0, obj, 0, this.f4941a.length);
            this.f4941a = obj;
        }
        Function[] functionArr = this.f4941a;
        int i = this.f4942b;
        this.f4942b = i + 1;
        functionArr[i] = function;
    }

    Function m6723b() {
        Function[] functionArr = this.f4941a;
        int i = this.f4942b - 1;
        this.f4942b = i;
        return functionArr[i];
    }

    Function[] m6724c() {
        Object obj = new Function[this.f4942b];
        System.arraycopy(this.f4941a, 0, obj, 0, this.f4942b);
        return obj;
    }
}
