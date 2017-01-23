package com.antutu.utils.downloader;

import anet.channel.util.HttpConstant;
import com.antutu.utils.MLog;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.android.spdy.SpdyRequest;

public class DownloadThread extends Thread {
    private static final int CACHE_SIZE = 8192;
    private static final String TAG = "DownloadThread";
    private boolean bStop;
    private int block;
    private int downLength;
    private URL downUrl;
    private FileDownloader downloader;
    private boolean finish;
    private File saveFile;
    private int threadId;

    public DownloadThread(FileDownloader fileDownloader, URL url, File file, int i, int i2, int i3) {
        this.threadId = -1;
        this.finish = false;
        this.bStop = false;
        this.downUrl = url;
        this.saveFile = file;
        this.block = i;
        this.downloader = fileDownloader;
        this.downLength = i2;
        this.threadId = i3;
        this.bStop = false;
    }

    private static void print(String str) {
        MLog.m6871i(TAG, str);
    }

    public long getDownLength() {
        return (long) this.downLength;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public void run() {
        if (this.downLength < this.block) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.downUrl.openConnection();
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
                httpURLConnection.setRequestProperty(HttpRequest.f14552e, "*/*");
                httpURLConnection.setRequestProperty(HttpRequest.f14567t, this.downUrl.toString());
                httpURLConnection.setRequestProperty("Charset", HttpRequest.f14548a);
                int i = (this.block * (this.threadId - 1)) + this.downLength;
                httpURLConnection.setRequestProperty("Range", "bytes=" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ((this.block * this.threadId) - 1));
                httpURLConnection.setRequestProperty(HttpConstant.CONNECTION, "Keep-Alive");
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[CACHE_SIZE];
                print("Thread " + this.threadId + " start download from position " + i);
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.saveFile, "rwd");
                randomAccessFile.seek((long) i);
                do {
                    i = inputStream.read(bArr, 0, CACHE_SIZE);
                    if (i != -1) {
                        randomAccessFile.write(bArr, 0, i);
                        this.downLength += i;
                        this.downloader.update(this.threadId, this.downLength);
                        this.downloader.append(i);
                    } else {
                        randomAccessFile.close();
                        inputStream.close();
                        print("Thread " + this.threadId + " download finish");
                        this.finish = true;
                        this.downloader.notifyDownloadFinish();
                        return;
                    }
                } while (!this.bStop);
                randomAccessFile.close();
                inputStream.close();
                this.downloader.notifyDownloadInterruptted();
            } catch (Exception e) {
                this.downLength = -1;
                this.downloader.notifyDownloadInterruptted();
            }
        }
    }

    public synchronized void stopDownload() {
        this.bStop = true;
    }
}
