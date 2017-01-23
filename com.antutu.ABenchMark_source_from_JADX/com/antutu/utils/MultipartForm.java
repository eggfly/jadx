package com.antutu.utils;

import android.content.Context;
import com.umeng.message.util.HttpRequest;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.android.spdy.SpdyProtocol;
import org.apache.http.entity.AbstractHttpEntity;

public class MultipartForm extends AbstractHttpEntity {
    private static final String boundary = "FlPm4LpSXsE";
    private final int UpbuffSize;
    private String charSet;
    private long contetLength;
    private FormData[] datas;
    private final boolean isDebug;

    private class FormData {
        private byte[] data;
        private String fileName;

        private FormData() {
        }
    }

    private MultipartForm(String str) {
        this.isDebug = false;
        this.UpbuffSize = SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        this.charSet = str;
    }

    public static MultipartForm GetInstance(String str, Context context) {
        return new MultipartForm(str);
    }

    private void addNnexLine() {
        byte[] bytes = "\r\n".getBytes();
        this.contetLength += (long) bytes.length;
        FormData formData = new FormData();
        formData.data = bytes;
        setFomDatas(formData);
    }

    private void setFomDatas(FormData formData) {
        if (formData != null) {
            if (this.datas == null) {
                this.datas = new FormData[1];
            } else {
                Object obj = new FormData[(this.datas.length + 1)];
                System.arraycopy(this.datas, 0, obj, 0, this.datas.length);
                this.datas = obj;
            }
            this.datas[this.datas.length - 1] = formData;
        }
    }

    private void upLoadFile(java.io.OutputStream r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:51:0x0004 in [B:28:0x003b, B:51:0x0004, B:21:0x0032, B:11:0x0021]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:62)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0004;
    L_0x0002:
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new java.io.File;
        r0.<init>(r6);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0004;
    L_0x0010:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0041 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0041 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];
    L_0x0019:
        r2 = r1.read(r0);	 Catch:{ Exception -> 0x002f, all -> 0x0038 }
        if (r2 > 0) goto L_0x0027;
    L_0x001f:
        if (r1 == 0) goto L_0x0004;
    L_0x0021:
        r1.close();	 Catch:{ Exception -> 0x0025 }
        goto L_0x0004;
    L_0x0025:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0027:
        r3 = 0;
        r5.write(r0, r3, r2);	 Catch:{ Exception -> 0x002f, all -> 0x0038 }
        r5.flush();	 Catch:{ Exception -> 0x002f, all -> 0x0038 }
        goto L_0x0019;
    L_0x002f:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0004;
    L_0x0032:
        r1.close();	 Catch:{ Exception -> 0x0036 }
        goto L_0x0004;
    L_0x0036:
        r0 = move-exception;
        goto L_0x0004;
    L_0x0038:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0004;
    L_0x003b:
        r1.close();	 Catch:{ Exception -> 0x003f }
    L_0x003e:
        throw r0;
    L_0x003f:
        r1 = move-exception;
        goto L_0x003e;
    L_0x0041:
        r0 = move-exception;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.MultipartForm.upLoadFile(java.io.OutputStream, java.lang.String):void");
    }

    private void writeContent(OutputStream outputStream, FormData formData) {
        int i = 0;
        try {
            int length = formData.data.length;
            do {
                outputStream.write(formData.data);
                outputStream.flush();
                i += length;
            } while (i <= length - 1);
        } catch (Exception e) {
        }
    }

    private void writeFile(OutputStream outputStream, FormData formData) {
        try {
            outputStream.write(formData.data);
            upLoadFile(outputStream, formData.fileName);
        } catch (Exception e) {
        }
    }

    public boolean Add_BytesData(String str, byte[] bArr, String str2, String str3) {
        if (str == null || bArr == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--");
        stringBuffer.append(boundary);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Disposition: form-data; name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\";filename=\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"\r\n");
        stringBuffer.append("Content-Type:");
        if (str3 == null) {
            str3 = "image/jpg";
        }
        stringBuffer.append(str3);
        stringBuffer.append("\r\n\r\n");
        try {
            Object bytes = stringBuffer.toString().getBytes(this.charSet == null ? HttpRequest.f14548a : this.charSet);
            Object obj = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, obj, 0, bytes.length);
            System.arraycopy(bArr, 0, obj, bytes.length, bArr.length);
            this.contetLength += (long) obj.length;
            FormData formData = new FormData();
            formData.data = obj;
            setFomDatas(formData);
            addNnexLine();
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public boolean Add_Data(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--");
        stringBuffer.append(boundary);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Disposition: form-data; name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"\r\n\r\n");
        stringBuffer.append(str2);
        stringBuffer.append("\r\n");
        try {
            byte[] bytes = stringBuffer.toString().getBytes(this.charSet == null ? HttpRequest.f14548a : this.charSet);
            this.contetLength += (long) bytes.length;
            FormData formData = new FormData();
            formData.data = bytes;
            setFomDatas(formData);
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public boolean Add_FileData(String str, String str2, String str3, String str4) {
        if (str == null || str2 == null) {
            return false;
        }
        long length = new File(str2).length();
        if (length < 1) {
            return false;
        }
        StringBuilder append = new StringBuilder().append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        if (str4 == null) {
            str4 = ".jpg";
        }
        String stringBuilder = append.append(str4).toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("--");
        stringBuffer.append(boundary);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Disposition: form-data; name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\";filename=\"");
        stringBuffer.append(stringBuilder);
        stringBuffer.append("\"\r\n");
        stringBuffer.append("Content-Type:");
        if (str3 == null) {
            str3 = "image/jpg";
        }
        stringBuffer.append(str3);
        stringBuffer.append("\r\n\r\n");
        try {
            byte[] bytes = stringBuffer.toString().getBytes(this.charSet == null ? HttpRequest.f14548a : this.charSet);
            this.contetLength = (length + ((long) bytes.length)) + this.contetLength;
            FormData formData = new FormData();
            formData.data = bytes;
            formData.fileName = str2;
            setFomDatas(formData);
            addNnexLine();
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    public void Add_Over() {
        byte[] bytes = "--FlPm4LpSXsE--\r\n".getBytes();
        this.contetLength += (long) bytes.length;
        FormData formData = new FormData();
        formData.data = bytes;
        setFomDatas(formData);
    }

    String Get_Boundary() {
        return boundary;
    }

    public InputStream getContent() {
        return null;
    }

    public long getContentLength() {
        return this.contetLength;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        if (outputStream != null && this.datas != null) {
            for (int i = 0; i < this.datas.length; i++) {
                if (this.datas[i].fileName == null) {
                    writeContent(outputStream, this.datas[i]);
                    outputStream.flush();
                } else {
                    writeFile(outputStream, this.datas[i]);
                    outputStream.flush();
                }
            }
            this.datas = null;
            System.gc();
        }
    }
}
