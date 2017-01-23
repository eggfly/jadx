package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;
import android.text.TextUtils;
import com.miui.support.internal.C0264R;
import com.miui.support.internal.variable.Android_Graphics_Drawable_Drawable_class;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {

        private static class Proxy implements IMediaControllerCallback {
            private IBinder f546a;

            Proxy(IBinder iBinder) {
                this.f546a = iBinder;
            }

            public IBinder asBinder() {
                return this.f546a;
            }

            public void m743a(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m737a() {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f546a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m741a(PlaybackStateCompat playbackStateCompat) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m739a(MediaMetadataCompat mediaMetadataCompat) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m744a(List<QueueItem> list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList(list);
                    this.f546a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m742a(CharSequence charSequence) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m738a(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void m740a(ParcelableVolumeInfo parcelableVolumeInfo) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        obtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f546a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static IMediaControllerCallback m745a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMediaControllerCallback)) {
                return new Proxy(iBinder);
            }
            return (IMediaControllerCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            ParcelableVolumeInfo parcelableVolumeInfo = null;
            Bundle bundle;
            switch (i) {
                case Android_Graphics_Drawable_Drawable_class.LAYOUT_DIRECTION_RTL /*1*/:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m735a(readString, bundle);
                    return true;
                case C0264R.styleable.Window_windowSplitActionBar /*2*/:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    m729a();
                    return true;
                case C0264R.styleable.Window_windowActionBarMovable /*3*/:
                    PlaybackStateCompat playbackStateCompat;
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        playbackStateCompat = (PlaybackStateCompat) PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                    }
                    m733a(playbackStateCompat);
                    return true;
                case C0264R.styleable.Window_windowDisablePreview /*4*/:
                    MediaMetadataCompat mediaMetadataCompat;
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        mediaMetadataCompat = (MediaMetadataCompat) MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                    }
                    m731a(mediaMetadataCompat);
                    return true;
                case C0264R.styleable.Window_startingWindowOverlay /*5*/:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    m736a(parcel.createTypedArrayList(QueueItem.CREATOR));
                    return true;
                case C0264R.styleable.Window_windowFixedWidthMajor /*6*/:
                    CharSequence charSequence;
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                    }
                    m734a(charSequence);
                    return true;
                case C0264R.styleable.Window_windowFixedHeightMinor /*7*/:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    m730a(bundle);
                    return true;
                case C0264R.styleable.Window_windowFixedWidthMinor /*8*/:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcel.readInt() != 0) {
                        parcelableVolumeInfo = (ParcelableVolumeInfo) ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                    }
                    m732a(parcelableVolumeInfo);
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void m729a();

    void m730a(Bundle bundle);

    void m731a(MediaMetadataCompat mediaMetadataCompat);

    void m732a(ParcelableVolumeInfo parcelableVolumeInfo);

    void m733a(PlaybackStateCompat playbackStateCompat);

    void m734a(CharSequence charSequence);

    void m735a(String str, Bundle bundle);

    void m736a(List<QueueItem> list);
}
