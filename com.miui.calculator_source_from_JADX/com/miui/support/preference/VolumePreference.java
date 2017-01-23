package com.miui.support.preference;

import android.app.Dialog;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.Preference.BaseSavedState;
import android.preference.PreferenceManager;
import android.preference.PreferenceManager.OnActivityStopListener;
import android.provider.Settings.System;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import com.miui.support.reflect.Field;
import com.miui.support.reflect.Method;

public class VolumePreference extends SeekBarDialogPreference implements OnActivityStopListener, OnKeyListener {
    private static final Method f3535a;
    private static final Method f3536b;
    private static final int f3537c;
    private int f3538d;
    private SeekBarVolumizer f3539e;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        VolumeStore f3520a;

        /* renamed from: com.miui.support.preference.VolumePreference.SavedState.1 */
        final class C04141 implements Creator<SavedState> {
            C04141() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m5209a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m5210a(i);
            }

            public SavedState m5209a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m5210a(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3520a = new VolumeStore();
            this.f3520a.f3533a = parcel.readInt();
            this.f3520a.f3534b = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3520a.f3533a);
            parcel.writeInt(this.f3520a.f3534b);
        }

        VolumeStore m5211a() {
            return this.f3520a;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f3520a = new VolumeStore();
        }

        static {
            CREATOR = new C04141();
        }
    }

    public class SeekBarVolumizer implements Callback, OnSeekBarChangeListener {
        final /* synthetic */ VolumePreference f3522a;
        private Context f3523b;
        private Handler f3524c;
        private AudioManager f3525d;
        private int f3526e;
        private int f3527f;
        private Ringtone f3528g;
        private int f3529h;
        private SeekBar f3530i;
        private int f3531j;
        private ContentObserver f3532k;

        /* renamed from: com.miui.support.preference.VolumePreference.SeekBarVolumizer.1 */
        class C04151 extends ContentObserver {
            final /* synthetic */ SeekBarVolumizer f3521a;

            C04151(SeekBarVolumizer seekBarVolumizer, Handler handler) {
                this.f3521a = seekBarVolumizer;
                super(handler);
            }

            public void onChange(boolean z) {
                super.onChange(z);
                if (this.f3521a.f3530i != null && this.f3521a.f3525d != null) {
                    this.f3521a.f3530i.setProgress(this.f3521a.f3525d.getStreamVolume(this.f3521a.f3526e));
                }
            }
        }

        public SeekBarVolumizer(VolumePreference volumePreference, Context context, SeekBar seekBar, int i) {
            this(volumePreference, context, seekBar, i, null);
        }

        public SeekBarVolumizer(VolumePreference volumePreference, Context context, SeekBar seekBar, int i, Uri uri) {
            this.f3522a = volumePreference;
            this.f3529h = -1;
            this.f3531j = -1;
            this.f3532k = new C04151(this, this.f3524c);
            this.f3523b = context;
            this.f3525d = (AudioManager) context.getSystemService("audio");
            this.f3526e = i;
            this.f3530i = seekBar;
            HandlerThread handlerThread = new HandlerThread("VolumePreference.CallbackHandler");
            handlerThread.start();
            this.f3524c = new Handler(handlerThread.getLooper(), this);
            m5212a(seekBar, uri);
        }

        private void m5212a(SeekBar seekBar, Uri uri) {
            seekBar.setMax(this.f3525d.getStreamMaxVolume(this.f3526e));
            this.f3527f = this.f3525d.getStreamVolume(this.f3526e);
            seekBar.setProgress(this.f3527f);
            seekBar.setOnSeekBarChangeListener(this);
            this.f3523b.getContentResolver().registerContentObserver(System.getUriFor(System.VOLUME_SETTINGS[this.f3526e]), false, this.f3532k);
            if (uri == null) {
                if (this.f3526e == 2) {
                    uri = System.DEFAULT_RINGTONE_URI;
                } else if (this.f3526e == 5) {
                    uri = System.DEFAULT_NOTIFICATION_URI;
                } else {
                    uri = System.DEFAULT_ALARM_ALERT_URI;
                }
            }
            this.f3528g = RingtoneManager.getRingtone(this.f3523b, uri);
            if (this.f3528g != null) {
                this.f3528g.setStreamType(this.f3526e);
            }
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_LTR /*0*/:
                    this.f3525d.setStreamVolume(this.f3526e, this.f3529h, 0);
                    break;
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    m5218g();
                    break;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    m5220i();
                    break;
                default:
                    Log.e("VolumePreference", "invalid SeekBarVolumizer message: " + message.what);
                    break;
            }
            return true;
        }

        private void m5217f() {
            this.f3524c.removeMessages(1);
            this.f3524c.sendMessageDelayed(this.f3524c.obtainMessage(1), m5227c() ? 1000 : 0);
        }

        private void m5218g() {
            if (!m5227c()) {
                this.f3522a.m5232a(this);
                if (this.f3528g != null) {
                    this.f3528g.play();
                }
            }
        }

        private void m5219h() {
            this.f3524c.removeMessages(1);
            this.f3524c.removeMessages(2);
            this.f3524c.sendMessage(this.f3524c.obtainMessage(2));
        }

        private void m5220i() {
            if (this.f3528g != null) {
                this.f3528g.stop();
            }
        }

        public void m5221a() {
            m5219h();
            this.f3523b.getContentResolver().unregisterContentObserver(this.f3532k);
            this.f3530i.setOnSeekBarChangeListener(null);
        }

        public void m5224b() {
            this.f3525d.setStreamVolume(this.f3526e, this.f3527f, 0);
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                m5222a(i);
            }
        }

        void m5222a(int i) {
            this.f3529h = i;
            this.f3524c.removeMessages(0);
            this.f3524c.sendMessage(this.f3524c.obtainMessage(0));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            m5217f();
        }

        public boolean m5227c() {
            return this.f3528g != null && this.f3528g.isPlaying();
        }

        public void m5228d() {
            m5219h();
        }

        public void m5225b(int i) {
            this.f3530i.incrementProgressBy(i);
            m5222a(this.f3530i.getProgress());
            m5217f();
            this.f3531j = -1;
        }

        public void m5229e() {
            if (this.f3531j != -1) {
                this.f3530i.setProgress(this.f3531j);
                m5222a(this.f3531j);
                m5217f();
                this.f3531j = -1;
                return;
            }
            this.f3531j = this.f3530i.getProgress();
            this.f3530i.setProgress(0);
            m5219h();
            m5222a(0);
        }

        public void m5223a(VolumeStore volumeStore) {
            if (this.f3529h >= 0) {
                volumeStore.f3533a = this.f3529h;
                volumeStore.f3534b = this.f3527f;
            }
        }

        public void m5226b(VolumeStore volumeStore) {
            if (volumeStore.f3533a != -1) {
                this.f3527f = volumeStore.f3534b;
                this.f3529h = volumeStore.f3533a;
                m5222a(this.f3529h);
            }
        }
    }

    public static class VolumeStore {
        public int f3533a;
        public int f3534b;

        public VolumeStore() {
            this.f3533a = -1;
            this.f3534b = -1;
        }
    }

    static {
        f3535a = Method.of(PreferenceManager.class, "registerOnActivityStopListener", "(Landroid/preference/PreferenceManager$OnActivityStopListener;)V");
        f3536b = Method.of(PreferenceManager.class, "unregisterOnActivityStopListener", "(Landroid/preference/PreferenceManager$OnActivityStopListener;)V");
        f3537c = m5230a();
    }

    private static int m5230a() {
        try {
            return Field.of("android.R.styleable", "VolumePreference_streamType", Field.INT_SIGNATURE_PRIMITIVE).getInt(null);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected void onBindDialogView(View view) {
        super.onBindDialogView(view);
        this.f3539e = new SeekBarVolumizer(this, getContext(), (SeekBar) view.findViewById(C0264R.id.seekbar), this.f3538d);
        f3535a.invoke(PreferenceManager.class, getPreferenceManager(), this);
        view.setOnKeyListener(this);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f3539e == null) {
            return true;
        }
        boolean z = keyEvent.getAction() == 0;
        switch (i) {
            case C0264R.styleable.Window_immersionViewItemBackground /*24*/:
                if (!z) {
                    return true;
                }
                this.f3539e.m5225b(1);
                return true;
            case C0264R.styleable.Window_immersionTextColor /*25*/:
                if (!z) {
                    return true;
                }
                this.f3539e.m5225b(-1);
                return true;
            case 164:
                if (!z) {
                    return true;
                }
                this.f3539e.m5229e();
                return true;
            default:
                return false;
        }
    }

    protected void onDialogClosed(boolean z) {
        super.onDialogClosed(z);
        if (!(z || this.f3539e == null)) {
            this.f3539e.m5224b();
        }
        m5231b();
    }

    public void onActivityStop() {
        if (this.f3539e != null) {
            this.f3539e.m5219h();
        }
    }

    private void m5231b() {
        f3536b.invoke(PreferenceManager.class, getPreferenceManager(), this);
        if (this.f3539e != null) {
            Dialog dialog = getDialog();
            if (dialog != null && dialog.isShowing()) {
                View findViewById = dialog.getWindow().getDecorView().findViewById(C0264R.id.seekbar);
                if (findViewById != null) {
                    findViewById.setOnKeyListener(null);
                }
                this.f3539e.m5224b();
            }
            this.f3539e.m5221a();
            this.f3539e = null;
        }
    }

    protected void m5232a(SeekBarVolumizer seekBarVolumizer) {
        if (this.f3539e != null && seekBarVolumizer != this.f3539e) {
            this.f3539e.m5228d();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (isPersistent()) {
            return onSaveInstanceState;
        }
        SavedState savedState = new SavedState(onSaveInstanceState);
        if (this.f3539e != null) {
            this.f3539e.m5223a(savedState.m5211a());
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.f3539e != null) {
            this.f3539e.m5226b(savedState.m5211a());
        }
    }
}
