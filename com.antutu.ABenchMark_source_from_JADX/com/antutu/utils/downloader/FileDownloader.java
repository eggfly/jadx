package com.antutu.utils.downloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseIntArray;
import anet.channel.util.HttpConstant;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.android.spdy.SpdyRequest;

@SuppressLint({"DefaultLocale"})
public class FileDownloader {
    private int block;
    private Context context;
    private SparseIntArray data;
    private String downloadFilename;
    private int downloadSize;
    private String downloadUrl;
    private FileService fileService;
    private int fileSize;
    private int finishedCount;
    private boolean isAPK;
    private boolean isLocalFile;
    private long lastModify;
    private DownloadProgressListener mDownloadProgressListener;
    private File saveFile;
    private DownloadThread[] threads;

    public FileDownloader(Context context, String str, boolean z, FileService fileService, File file, int i, DownloadProgressListener downloadProgressListener) {
        this.downloadFilename = BuildConfig.FLAVOR;
        this.isLocalFile = true;
        this.downloadSize = 0;
        this.fileSize = 0;
        this.lastModify = 0;
        this.data = new SparseIntArray();
        this.isAPK = false;
        this.finishedCount = 0;
        this.context = context;
        this.downloadUrl = str;
        this.isAPK = z;
        if (fileService == null) {
            fileService = new FileService(this.context);
        }
        this.fileService = fileService;
        this.mDownloadProgressListener = downloadProgressListener;
        try {
            URL url = new URL(this.downloadUrl);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.threads = new DownloadThread[i];
            this.downloadFilename = BuildConfig.FLAVOR;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            DownloadFile(httpURLConnection, str, file);
        } catch (Exception e) {
        }
    }

    private void DownloadFile(HttpURLConnection httpURLConnection, String str, File file) {
        int i = 0;
        try {
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.setRequestProperty(HttpRequest.f14552e, "*/*");
            httpURLConnection.setRequestProperty(HttpRequest.f14567t, str);
            httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "Keep-Alive");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == Constants.COMMAND_HANDSHAKE) {
                this.fileSize = httpURLConnection.getContentLength();
                this.lastModify = httpURLConnection.getLastModified();
                if (this.fileSize > 0) {
                    getFileName(httpURLConnection, true);
                    this.saveFile = new File(file, this.downloadFilename);
                    boolean exists = this.saveFile.exists();
                    if (exists) {
                        if (this.saveFile.length() != ((long) this.fileSize)) {
                            exists = false;
                        } else if (this.lastModify != this.fileService.getLastModify(this.downloadUrl)) {
                            exists = false;
                        } else if (this.fileService.getTimes(this.downloadUrl) > 3) {
                            exists = false;
                        }
                        if (!exists) {
                            this.saveFile.delete();
                        }
                    }
                    if (exists) {
                        SparseIntArray data = this.fileService.getData(this.downloadUrl);
                        int size = data.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            this.data.put(data.keyAt(i2), data.valueAt(i2));
                        }
                        if (this.data.size() == this.threads.length) {
                            while (i < this.threads.length) {
                                this.downloadSize += this.data.get(i + 1);
                                i++;
                            }
                        }
                    } else {
                        this.fileService.delete(this.downloadUrl);
                    }
                    this.block = this.fileSize % this.threads.length == 0 ? this.fileSize / this.threads.length : (this.fileSize / this.threads.length) + 1;
                }
            } else if (httpURLConnection.getResponseCode() == ErrorCode.DM_DEVICEID_INVALID || httpURLConnection.getResponseCode() == Constants.COMMAND_STOP_FOR_ELECTION) {
                getFileName(httpURLConnection, false);
                String headerField = httpURLConnection.getHeaderField(MsgConstant.KEY_LOCATION_PARAMS);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                httpURLConnection2.setInstanceFollowRedirects(true);
                DownloadFile(httpURLConnection2, headerField, file);
            }
        } catch (Exception e) {
        }
    }

    public static String SHA1(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("iso-8859-1"), 0, str.length());
            return convertToHex(instance.digest());
        } catch (Exception e) {
            return UUID.randomUUID().toString();
        }
    }

    private static String convertToHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = (b >>> 4) & 15;
            int i2 = 0;
            while (true) {
                char c = (i < 0 || i > 9) ? (char) ((i - 10) + 97) : (char) (i + 48);
                stringBuilder.append(c);
                int i3 = b & 15;
                i = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i;
                i = i3;
            }
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getFileName(java.net.HttpURLConnection r6, boolean r7) {
        /*
        r5 = this;
        r1 = "";
        r0 = 0;
    L_0x0003:
        r2 = r6.getHeaderField(r0);
        if (r2 != 0) goto L_0x0017;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x0014;
    L_0x000c:
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x0014;
    L_0x0012:
        r5.downloadFilename = r0;
    L_0x0014:
        if (r7 != 0) goto L_0x004e;
    L_0x0016:
        return;
    L_0x0017:
        r3 = r6.getHeaderFieldKey(r0);
        if (r3 == 0) goto L_0x004b;
    L_0x001d:
        r3 = "content-disposition";
        r4 = r1.toLowerCase();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x004b;
    L_0x0029:
        r3 = ".*filename=(.*)";
        r3 = java.util.regex.Pattern.compile(r3);
        r2 = r2.toLowerCase();
        r2 = r3.matcher(r2);
        r3 = r2.find();
        if (r3 == 0) goto L_0x004b;
    L_0x003d:
        r0 = 1;
        r0 = r2.group(r0);
        r1 = "\"";
        r2 = "";
        r0 = r0.replace(r1, r2);
        goto L_0x000a;
    L_0x004b:
        r0 = r0 + 1;
        goto L_0x0003;
    L_0x004e:
        r0 = r5.downloadFilename;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0016;
    L_0x0056:
        r0 = r5.downloadUrl;
        r1 = r5.downloadUrl;
        r2 = 47;
        r1 = r1.lastIndexOf(r2);
        r1 = r1 + 1;
        r0 = r0.substring(r1);
        if (r0 == 0) goto L_0x007a;
    L_0x0068:
        r1 = r0.trim();
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x007a;
    L_0x0072:
        r1 = "?";
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x0080;
    L_0x007a:
        r0 = r5.downloadUrl;
        r0 = SHA1(r0);
    L_0x0080:
        r1 = r5.isAPK;
        if (r1 == 0) goto L_0x00a3;
    L_0x0084:
        r1 = r0.toLowerCase();
        r2 = ".apk";
        r1 = r1.endsWith(r2);
        if (r1 != 0) goto L_0x00a3;
    L_0x0090:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r1 = ".apk";
        r0 = r0.append(r1);
        r0 = r0.toString();
    L_0x00a3:
        r5.downloadFilename = r0;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.antutu.utils.downloader.FileDownloader.getFileName(java.net.HttpURLConnection, boolean):void");
    }

    public static Map<String, String> getHttpResponseHeader(HttpURLConnection httpURLConnection) {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (true) {
            String headerField = httpURLConnection.getHeaderField(i);
            if (headerField == null) {
                return linkedHashMap;
            }
            linkedHashMap.put(httpURLConnection.getHeaderFieldKey(i), headerField);
            i++;
        }
    }

    protected synchronized void append(int i) {
        this.downloadSize += i;
        if (this.downloadSize == this.fileSize) {
        }
        if (this.mDownloadProgressListener != null) {
            this.mDownloadProgressListener.onDownloadSize(this.downloadSize, this.fileSize);
        }
    }

    public int download() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.saveFile, "rw");
            if (this.fileSize > 0 && randomAccessFile.length() != ((long) this.fileSize)) {
                randomAccessFile.setLength((long) this.fileSize);
            }
            randomAccessFile.close();
            URL url = new URL(this.downloadUrl);
            if (this.data.size() != this.threads.length) {
                this.data.clear();
                for (int i = 0; i < this.threads.length; i++) {
                    this.data.put(i + 1, 0);
                }
            }
            for (int i2 = 0; i2 < this.threads.length; i2++) {
                int i3 = this.data.get(i2 + 1);
                if (i3 < this.block && this.downloadSize < this.fileSize) {
                    if (this.isLocalFile) {
                        this.isLocalFile = false;
                    }
                    this.threads[i2] = new DownloadThread(this, url, this.saveFile, this.block, this.data.get(i2 + 1), i2 + 1);
                    this.threads[i2].setPriority(7);
                    this.threads[i2].start();
                } else if (i3 == this.block && this.downloadSize == this.fileSize) {
                    if (this.mDownloadProgressListener != null) {
                        this.mDownloadProgressListener.onDownloadSize(this.downloadSize, this.fileSize);
                        this.mDownloadProgressListener.onFinished(this.isLocalFile);
                    }
                    this.fileService.updateTimes(this.downloadUrl);
                    return this.downloadSize;
                } else {
                    this.threads[i2] = null;
                }
            }
            this.fileService.delete(this.downloadUrl);
            this.fileService.save(this.downloadUrl, this.lastModify, this.data);
            return this.downloadSize;
        } catch (Exception e) {
            throw new Exception("file download fail");
        }
    }

    public String getDownloadFilename() {
        return this.downloadFilename;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public File getSaveFile() {
        return this.saveFile;
    }

    public int getThreadSize() {
        return this.threads.length;
    }

    void notifyDownloadFinish() {
        synchronized (this) {
            this.finishedCount++;
            if (this.finishedCount == getThreadSize() && this.mDownloadProgressListener != null) {
                this.mDownloadProgressListener.onFinished(false);
            }
        }
    }

    void notifyDownloadInterruptted() {
        synchronized (this) {
            this.mDownloadProgressListener.onInterrupted();
        }
    }

    public void restartThreadById(int i) {
        Thread thread = this.threads[i];
        if (thread != null) {
            thread.setPriority(7);
            thread.start();
        }
    }

    public void stopDownload() {
        try {
            int length = this.threads.length;
            for (int i = 0; i < length; i++) {
                if (this.threads[i] != null) {
                    this.threads[i].stopDownload();
                }
            }
        } catch (Exception e) {
        }
    }

    protected void update(int i, int i2) {
        this.data.put(i, i2);
        this.fileService.update(this.downloadUrl, this.data);
    }
}
