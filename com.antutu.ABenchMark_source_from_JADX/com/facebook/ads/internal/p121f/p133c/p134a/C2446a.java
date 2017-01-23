package com.facebook.ads.internal.p121f.p133c.p134a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.f.c.a.a */
public class C2446a extends TextureView implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, SurfaceTextureListener {
    private static final String f8416h;
    private Uri f8417a;
    private C2448c f8418b;
    private Surface f8419c;
    private MediaPlayer f8420d;
    private C2447b f8421e;
    private C2447b f8422f;
    private int f8423g;

    static {
        f8416h = C2446a.class.getSimpleName();
    }

    public C2446a(Context context) {
        super(context);
        this.f8421e = C2447b.IDLE;
        this.f8422f = C2447b.IDLE;
    }

    private void setVideoState(C2447b c2447b) {
        if (c2447b != this.f8421e) {
            this.f8421e = c2447b;
            if (this.f8418b != null) {
                this.f8418b.m9316a(this.f8420d, c2447b);
            }
        }
    }

    public void m9314a() {
        this.f8422f = C2447b.STARTED;
        if (this.f8421e == C2447b.PREPARED || this.f8421e == C2447b.PAUSED || this.f8421e == C2447b.PLAYBACK_COMPLETED) {
            this.f8420d.start();
            setVideoState(C2447b.STARTED);
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    public void m9315b() {
        this.f8422f = C2447b.IDLE;
        if (this.f8420d != null) {
            int currentPosition = this.f8420d.getCurrentPosition();
            if (currentPosition > 0) {
                this.f8423g = currentPosition;
            }
            this.f8420d.stop();
            this.f8420d.reset();
            this.f8420d.release();
            this.f8420d = null;
        }
        setVideoState(C2447b.IDLE);
    }

    public int getCurrentPosition() {
        return this.f8420d != null ? this.f8420d.getCurrentPosition() : 0;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        setVideoState(C2447b.PLAYBACK_COMPLETED);
        m9315b();
        this.f8423g = 0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        setVideoState(C2447b.ERROR);
        return false;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 701:
                setVideoState(C2447b.BUFFERING);
                break;
            case 702:
                setVideoState(C2447b.STARTED);
                break;
        }
        return false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(C2447b.PREPARED);
        if (this.f8423g > 0) {
            if (this.f8423g >= this.f8420d.getDuration()) {
                this.f8423g = 0;
            }
            this.f8420d.seekTo(this.f8423g);
            this.f8423g = 0;
        }
        if (this.f8422f == C2447b.STARTED) {
            m9314a();
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f8419c = new Surface(surfaceTexture);
        if (this.f8420d != null) {
            this.f8420d.setSurface(this.f8419c);
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getContext(), this.f8417a);
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setSurface(this.f8419c);
            mediaPlayer.prepareAsync();
            this.f8420d = mediaPlayer;
            setVideoState(C2447b.PREPARING);
        } catch (Exception e) {
            mediaPlayer.release();
            Log.e(f8416h, "Cannot prepare media player with SurfaceTexture: " + e);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m9315b();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setVideoStateChangeListener(C2448c c2448c) {
        this.f8418b = c2448c;
    }

    public void setup(Uri uri) {
        this.f8417a = uri;
        setSurfaceTextureListener(this);
    }
}
