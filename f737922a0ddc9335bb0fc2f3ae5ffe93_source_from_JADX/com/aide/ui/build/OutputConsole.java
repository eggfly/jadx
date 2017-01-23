package com.aide.ui.build;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import com.aide.common.KeyStrokeDetector;
import com.aide.common.k;
import com.aide.ui.R;
import com.aide.ui.views.CodeEditText;
import com.aide.ui.views.CodeEditText.d;
import com.aide.ui.views.editor.f;
import com.aide.ui.views.editor.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.LinkedList;
import java.util.Queue;
import qf;

public class OutputConsole extends CodeEditText {
    private f DW;
    private ActionMode FH;
    private a Hw;
    private OutputStream VH;
    private StringBuilder Zo;
    private boolean gn;
    private KeyStrokeDetector j6;
    private Handler v5;

    class 1 implements d {
        final /* synthetic */ OutputConsole j6;

        1(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public void j6(int i, int i2, int i3, int i4) {
            if (!(this.j6.u7(i, i2) || this.j6.u7(i, i4))) {
                this.j6.j6(i, i2, i, i4);
            }
            this.j6.a8();
            this.j6.tp();
        }
    }

    class 2 implements d {
        final /* synthetic */ OutputConsole j6;

        2(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public void j6(int i, int i2, int i3, int i4) {
            this.j6.VH();
        }
    }

    class 3 extends f {
        final /* synthetic */ OutputConsole j6;

        3(OutputConsole outputConsole, long j) {
            this.j6 = outputConsole;
            super(j);
        }

        public void j6() {
            this.j6.gn();
        }
    }

    class 4 implements Runnable {
        final /* synthetic */ OutputConsole j6;

        4(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public void run() {
            this.j6.VH();
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ OutputConsole j6;

        5(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public void run() {
            this.j6.gn();
        }
    }

    class 6 implements Callback {
        final /* synthetic */ OutputConsole j6;

        6(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.d.javaconsole_context_menu, menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() == R.b.javaconsoleMenuCopy) {
                this.j6.yS();
            }
            this.j6.FH.finish();
            return true;
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.j6.FH = null;
            this.j6.getOEditorView().setSelectionVisibility(false);
            this.j6.gn();
        }
    }

    private class a extends InputStream {
        private Queue<Integer> DW;
        private CharBuffer FH;
        private ByteBuffer Hw;
        private boolean Zo;
        final /* synthetic */ OutputConsole j6;
        private CharsetEncoder v5;

        private a(OutputConsole outputConsole) {
            this.j6 = outputConsole;
            this.DW = new LinkedList();
            this.FH = CharBuffer.allocate(1);
            this.Hw = ByteBuffer.allocate(5);
            this.v5 = Charset.defaultCharset().newEncoder();
        }

        public int read() {
            int intValue;
            if (!this.Zo) {
                this.Zo = true;
                this.j6.DW();
            }
            synchronized (this.DW) {
                try {
                    if (this.DW.size() == 0) {
                        this.DW.wait();
                    }
                } catch (InterruptedException e) {
                }
                intValue = ((Integer) this.DW.poll()).intValue();
            }
            return intValue;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read(byte[] r5, int r6, int r7) {
            /*
            r4 = this;
            r0 = r4.Zo;
            if (r0 != 0) goto L_0x000c;
        L_0x0004:
            r0 = 1;
            r4.Zo = r0;
            r0 = r4.j6;
            r0.DW();
        L_0x000c:
            r2 = r4.DW;
            monitor-enter(r2);
        L_0x000f:
            r0 = r4.DW;	 Catch:{ InterruptedException -> 0x001d }
            r0 = r0.size();	 Catch:{ InterruptedException -> 0x001d }
            if (r0 != 0) goto L_0x001e;
        L_0x0017:
            r0 = r4.DW;	 Catch:{ InterruptedException -> 0x001d }
            r0.wait();	 Catch:{ InterruptedException -> 0x001d }
            goto L_0x000f;
        L_0x001d:
            r0 = move-exception;
        L_0x001e:
            r0 = 0;
            r1 = r0;
        L_0x0020:
            r0 = r4.DW;	 Catch:{ all -> 0x0041 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x003f;
        L_0x0028:
            if (r1 >= r7) goto L_0x003f;
        L_0x002a:
            r3 = r6 + r1;
            r0 = r4.DW;	 Catch:{ all -> 0x0041 }
            r0 = r0.poll();	 Catch:{ all -> 0x0041 }
            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0041 }
            r0 = r0.intValue();	 Catch:{ all -> 0x0041 }
            r0 = (byte) r0;	 Catch:{ all -> 0x0041 }
            r5[r3] = r0;	 Catch:{ all -> 0x0041 }
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0020;
        L_0x003f:
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            return r1;
        L_0x0041:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.build.OutputConsole.a.read(byte[], int, int):int");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void j6(java.lang.StringBuilder r8) {
            /*
            r7 = this;
            r1 = 0;
            r3 = r7.DW;
            monitor-enter(r3);
            r2 = r1;
        L_0x0005:
            r0 = r8.length();	 Catch:{ all -> 0x0065 }
            if (r2 >= r0) goto L_0x006c;
        L_0x000b:
            r0 = r7.FH;	 Catch:{ all -> 0x0065 }
            r0.rewind();	 Catch:{ all -> 0x0065 }
            r0 = r7.FH;	 Catch:{ all -> 0x0065 }
            r4 = r8.charAt(r2);	 Catch:{ all -> 0x0065 }
            r0.append(r4);	 Catch:{ all -> 0x0065 }
            r0 = r7.FH;	 Catch:{ all -> 0x0065 }
            r0.rewind();	 Catch:{ all -> 0x0065 }
            r0 = r7.Hw;	 Catch:{ all -> 0x0065 }
            r0.rewind();	 Catch:{ all -> 0x0065 }
            r0 = r7.v5;	 Catch:{ all -> 0x0065 }
            r4 = r7.FH;	 Catch:{ all -> 0x0065 }
            r5 = r7.Hw;	 Catch:{ all -> 0x0065 }
            r6 = 0;
            r0.encode(r4, r5, r6);	 Catch:{ all -> 0x0065 }
            r0 = r7.Hw;	 Catch:{ all -> 0x0065 }
            r4 = r0.position();	 Catch:{ all -> 0x0065 }
            r0 = r7.Hw;	 Catch:{ all -> 0x0065 }
            r0.rewind();	 Catch:{ all -> 0x0065 }
            r0 = r1;
        L_0x0039:
            if (r0 >= r4) goto L_0x0068;
        L_0x003b:
            r5 = r7.j6;	 Catch:{ all -> 0x0065 }
            r5 = r5.VH;	 Catch:{ all -> 0x0065 }
            if (r5 == 0) goto L_0x0055;
        L_0x0043:
            r5 = r7.j6;	 Catch:{ IOException -> 0x009d }
            r5 = r5.VH;	 Catch:{ IOException -> 0x009d }
            r6 = r7.Hw;	 Catch:{ IOException -> 0x009d }
            r6 = r6.get();	 Catch:{ IOException -> 0x009d }
            r5.write(r6);	 Catch:{ IOException -> 0x009d }
        L_0x0052:
            r0 = r0 + 1;
            goto L_0x0039;
        L_0x0055:
            r5 = r7.DW;	 Catch:{ all -> 0x0065 }
            r6 = r7.Hw;	 Catch:{ all -> 0x0065 }
            r6 = r6.get();	 Catch:{ all -> 0x0065 }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0065 }
            r5.add(r6);	 Catch:{ all -> 0x0065 }
            goto L_0x0052;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0065 }
            throw r0;
        L_0x0068:
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x0005;
        L_0x006c:
            r0 = r7.j6;	 Catch:{ all -> 0x0065 }
            r0 = r0.VH;	 Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x008f;
        L_0x0074:
            r0 = r7.j6;	 Catch:{ IOException -> 0x009b }
            r0 = r0.VH;	 Catch:{ IOException -> 0x009b }
            r1 = 10;
            r0.write(r1);	 Catch:{ IOException -> 0x009b }
            r0 = r7.j6;	 Catch:{ IOException -> 0x009b }
            r0 = r0.VH;	 Catch:{ IOException -> 0x009b }
            r0.flush();	 Catch:{ IOException -> 0x009b }
        L_0x0088:
            r0 = r7.DW;	 Catch:{ all -> 0x0065 }
            r0.notifyAll();	 Catch:{ all -> 0x0065 }
            monitor-exit(r3);	 Catch:{ all -> 0x0065 }
            return;
        L_0x008f:
            r0 = r7.DW;	 Catch:{ all -> 0x0065 }
            r1 = 10;
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0065 }
            r0.add(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x0088;
        L_0x009b:
            r0 = move-exception;
            goto L_0x0088;
        L_0x009d:
            r5 = move-exception;
            goto L_0x0052;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.aide.ui.build.OutputConsole.a.j6(java.lang.StringBuilder):void");
        }
    }

    private class b extends OutputStream {
        final /* synthetic */ OutputConsole j6;

        private b(OutputConsole outputConsole) {
            this.j6 = outputConsole;
        }

        public void write(byte[] bArr) {
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr, int i, int i2) {
            this.j6.j6(bArr, i, i2);
        }

        public void write(int i) {
            this.j6.DW((char) i);
        }
    }

    private class c extends com.aide.ui.views.editor.d {
        private qf<StringBuilder> DW;
        final /* synthetic */ OutputConsole j6;

        public c(OutputConsole outputConsole) {
            this.j6 = outputConsole;
            this.DW = new qf(2000);
            this.DW.j6(new StringBuilder());
        }

        public void j6(byte[] bArr, int i, int i2) {
            synchronized (this.DW) {
                String str = new String(bArr, i, i2);
                for (int i3 = 0; i3 < str.length(); i3++) {
                    DW(str.charAt(i3));
                }
            }
            this.j6.DW.DW();
        }

        public void j6(char c) {
            synchronized (this.DW) {
                DW(c);
            }
            this.j6.DW.DW();
        }

        private void DW(char c) {
            if (c == '\n') {
                this.DW.j6(new StringBuilder());
            } else {
                StringBuilder stringBuilder = (StringBuilder) this.DW.Hw();
                stringBuilder.append(c);
                if (stringBuilder.length() >= 1000) {
                    this.DW.j6(new StringBuilder());
                }
            }
            J0();
        }

        public void j6() {
            synchronized (this.DW) {
                StringBuilder stringBuilder = (StringBuilder) this.DW.Hw();
                if (stringBuilder.length() > 0) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                    J0();
                }
            }
        }

        public int FH() {
            int max;
            synchronized (this.DW) {
                max = Math.max(1, this.DW.j6());
            }
            return max;
        }

        public int e_() {
            synchronized (this.DW) {
            }
            return 1000;
        }

        public int Hw(int i) {
            int length;
            synchronized (this.DW) {
                if (i >= 0) {
                    if (i < this.DW.j6()) {
                        length = ((StringBuilder) this.DW.j6(i)).length();
                    }
                }
                length = DW().length();
            }
            return length;
        }

        private String DW() {
            return "";
        }

        public char j6(int i, int i2) {
            char c;
            synchronized (this.DW) {
                if (i2 >= 0) {
                    if (i2 < this.DW.j6()) {
                        CharSequence charSequence = (CharSequence) this.DW.j6(i2);
                        if (i >= charSequence.length()) {
                            c = ' ';
                        } else {
                            c = charSequence.charAt(i);
                        }
                    }
                }
                c = DW().charAt(i);
            }
            return c;
        }

        public void j6(int i, char[] cArr) {
            synchronized (this.DW) {
                CharSequence charSequence;
                int min;
                int i2;
                if (i >= 0) {
                    if (i < this.DW.j6()) {
                        charSequence = (CharSequence) this.DW.j6(i);
                        min = Math.min(cArr.length, charSequence.length());
                        for (i2 = 0; i2 < min; i2++) {
                            cArr[i2] = charSequence.charAt(i2);
                        }
                    }
                }
                charSequence = DW();
                min = Math.min(cArr.length, charSequence.length());
                for (i2 = 0; i2 < min; i2++) {
                    cArr[i2] = charSequence.charAt(i2);
                }
            }
        }

        public boolean v5(int i) {
            return false;
        }

        public int DW(int i, int i2) {
            return 0;
        }

        public int v5() {
            return 1;
        }

        public n Zo(int i) {
            return new n(this.j6.rN() ? -16777216 : -3355444, 0);
        }
    }

    public OutputConsole(Context context) {
        super(context);
        j6();
    }

    public OutputConsole(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j6();
    }

    public OutputConsole(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j6();
    }

    private void j6() {
        try {
            getOEditorView().setHidden(false);
            getOEditorView().setEditable(true);
            getOEditorView().setModel(new c(this));
        } catch (IOException e) {
        }
        this.Zo = new StringBuilder();
        this.v5 = new Handler();
        this.j6 = new KeyStrokeDetector(getContext());
        j6(new 1(this));
        Zo(new 2(this));
        this.DW = new 3(this, 100);
        this.Hw = new a();
    }

    private void DW() {
        this.v5.postDelayed(new 4(this), 500);
    }

    private void VH() {
        if (this.FH != null) {
            this.FH.finish();
        }
        BT();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        inputMethodManager.restartInput(getOEditorView());
        inputMethodManager.showSoftInput(getOEditorView(), 2);
        this.v5.postDelayed(new 5(this), 500);
    }

    public boolean j6(String str) {
        try {
            return str.replace("\r", "").trim().equals(j6(getOEditorView().getEditorModel().Ws()).replace("\r", "").trim());
        } catch (IOException e) {
            return false;
        }
    }

    private static String j6(Reader reader) {
        char[] cArr = new char[4096];
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = reader.read(cArr);
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(cArr, 0, read);
        }
    }

    public PrintStream getPrintStream() {
        return new PrintStream(getOutputStream());
    }

    public OutputStream getOutputStream() {
        return new b();
    }

    public InputStream getInputStream() {
        return this.Hw;
    }

    public synchronized void setProcessOutputStream(OutputStream outputStream) {
        this.VH = outputStream;
    }

    private void gn() {
        getOEditorView().Zo(v5(getLineCount()), getLineCount() - 1);
        getScrollView().FH();
    }

    public void j6(boolean z, boolean z2) {
        setIsLightTheme(z);
        this.gn = z2;
        getOEditorView().setShowCaretLine(false);
        if (!z2) {
            getOEditorView().setFontSize((float) com.aide.common.d.j6(getContext(), 14));
        } else if (com.aide.common.d.v5(getContext()) >= 400.0f) {
            getOEditorView().setFontSize(21.0f);
        } else {
            getOEditorView().setFontSize(14.0f);
        }
    }

    protected float getSideBarPadding() {
        if (u7()) {
            return getResources().getDisplayMetrics().density * 48.0f;
        }
        return 0.0f;
    }

    private boolean u7() {
        return this.gn && com.aide.common.d.DW(getContext());
    }

    private void tp() {
        if (this.FH == null) {
            this.FH = ((Activity) getContext()).startActionMode(new 6(this));
        }
    }

    public KeyStrokeDetector getKeyStrokeDetector() {
        return this.j6;
    }

    public void j6(char c) {
        if (c == '\n') {
            this.Hw.j6(this.Zo);
            this.Zo.setLength(0);
        } else {
            this.Zo.append(c);
        }
        DW(c);
        gn();
    }

    protected boolean j6(k kVar) {
        int FH = kVar.FH();
        if (FH == 85 && VERSION.SDK_INT >= 15) {
            getRootView().findViewById(R.b.outputHeaderLearnTask).callOnClick();
        }
        if (FH == 67 && this.Zo.length() > 0) {
            this.Zo.setLength(this.Zo.length() - 1);
            getOutputModel().j6();
            gn();
        }
        return super.j6(kVar);
    }

    protected boolean FH() {
        return false;
    }

    private void j6(byte[] bArr, int i, int i2) {
        getOutputModel().j6(bArr, i, i2);
    }

    private void DW(char c) {
        getOutputModel().j6(c);
    }

    private c getOutputModel() {
        return (c) getOEditorView().getModel();
    }
}
