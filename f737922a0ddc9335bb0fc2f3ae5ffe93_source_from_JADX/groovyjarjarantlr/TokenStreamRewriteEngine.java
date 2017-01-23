package groovyjarjarantlr;

import groovyjarjarantlr.ASdebug.IASDebugStream;
import groovyjarjarantlr.collections.impl.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TokenStreamRewriteEngine implements IASDebugStream, TokenStream {
    protected Map DW;
    protected int FH;
    protected TokenStream Hw;
    protected List j6;
    protected BitSet v5;

    class 1 implements Comparator {
        public int compare(Object obj, Object obj2) {
            RewriteOperation rewriteOperation = (RewriteOperation) obj;
            RewriteOperation rewriteOperation2 = (RewriteOperation) obj2;
            if (rewriteOperation.DW < rewriteOperation2.DW) {
                return -1;
            }
            if (rewriteOperation.DW > rewriteOperation2.DW) {
                return 1;
            }
            return 0;
        }
    }

    static class RewriteOperation {
        protected int DW;
        protected String FH;

        public int j6(StringBuffer stringBuffer) {
            return this.DW;
        }

        public String toString() {
            String name = getClass().getName();
            return new StringBuffer().append(name.substring(name.indexOf(36) + 1, name.length())).append("@").append(this.DW).append('\"').append(this.FH).append('\"').toString();
        }
    }

    static class ReplaceOp extends RewriteOperation {
        protected int j6;

        public int j6(StringBuffer stringBuffer) {
            if (this.FH != null) {
                stringBuffer.append(this.FH);
            }
            return this.j6 + 1;
        }
    }

    static class DeleteOp extends ReplaceOp {
    }

    static class InsertBeforeOp extends RewriteOperation {
        public int j6(StringBuffer stringBuffer) {
            stringBuffer.append(this.FH);
            return this.DW;
        }
    }

    public Token j6() {
        TokenWithIndex tokenWithIndex;
        do {
            tokenWithIndex = (TokenWithIndex) this.Hw.j6();
            if (tokenWithIndex != null) {
                tokenWithIndex.Hw(this.FH);
                if (tokenWithIndex.Hw() != 1) {
                    this.j6.add(tokenWithIndex);
                }
                this.FH++;
            }
            if (tokenWithIndex == null) {
                break;
            }
        } while (this.v5.Hw(tokenWithIndex.Hw()));
        return tokenWithIndex;
    }

    public TokenWithIndex j6(int i) {
        return (TokenWithIndex) this.j6.get(i);
    }

    public int DW() {
        return this.j6.size();
    }

    public String j6(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        while (i >= 0 && i <= i2 && i < this.j6.size()) {
            stringBuffer.append(j6(i).FH());
            i++;
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return DW(0, DW() - 1);
    }

    public String DW(int i, int i2) {
        return j6("default", i, i2);
    }

    public String j6(String str, int i, int i2) {
        List list = (List) this.DW.get(str);
        if (list == null || list.size() == 0) {
            return j6(i, i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        int i4 = i;
        while (i4 >= 0 && i4 <= i2 && i4 < this.j6.size()) {
            RewriteOperation rewriteOperation;
            int i5;
            if (i3 < list.size()) {
                rewriteOperation = (RewriteOperation) list.get(i3);
                while (rewriteOperation.DW < i4 && i3 < list.size()) {
                    i3++;
                    if (i3 < list.size()) {
                        rewriteOperation = (RewriteOperation) list.get(i3);
                    }
                }
                i5 = i4;
                i4 = i3;
                i3 = i5;
                while (i3 == rewriteOperation.DW && i4 < list.size()) {
                    i3 = rewriteOperation.j6(stringBuffer);
                    i4++;
                    if (i4 < list.size()) {
                        rewriteOperation = (RewriteOperation) list.get(i4);
                    }
                }
            } else {
                i5 = i4;
                i4 = i3;
                i3 = i5;
            }
            if (i3 <= i2) {
                stringBuffer.append(j6(i3).FH());
                i = i3 + 1;
                i3 = i4;
                i4 = i;
            } else {
                i5 = i3;
                i3 = i4;
                i4 = i5;
            }
        }
        while (i3 < list.size()) {
            rewriteOperation = (RewriteOperation) list.get(i3);
            if (rewriteOperation.DW >= FH()) {
                rewriteOperation.j6(stringBuffer);
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    public int FH() {
        return this.j6.size();
    }
}
