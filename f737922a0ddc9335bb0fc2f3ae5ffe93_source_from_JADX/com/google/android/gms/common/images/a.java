package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.ae;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.internal.hi;
import java.lang.ref.WeakReference;

public abstract class a {
    protected int DW;
    final a j6;

    static final class a {
        public final Uri j6;

        public a(Uri uri) {
            this.j6 = uri;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof a) ? false : this == obj ? true : ae.j6(((a) obj).j6, this.j6);
        }

        public int hashCode() {
            return ae.j6(this.j6);
        }
    }

    public static final class b extends a {
        private WeakReference<com.google.android.gms.common.images.ImageManager.a> FH;

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            b bVar = (b) obj;
            com.google.android.gms.common.images.ImageManager.a aVar = (com.google.android.gms.common.images.ImageManager.a) this.FH.get();
            com.google.android.gms.common.images.ImageManager.a aVar2 = (com.google.android.gms.common.images.ImageManager.a) bVar.FH.get();
            boolean z = aVar2 != null && aVar != null && ae.j6(aVar2, aVar) && ae.j6(bVar.j6, this.j6);
            return z;
        }

        public int hashCode() {
            return ae.j6(this.j6);
        }

        protected void j6(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                com.google.android.gms.common.images.ImageManager.a aVar = (com.google.android.gms.common.images.ImageManager.a) this.FH.get();
                if (aVar != null) {
                    aVar.j6(this.j6.j6, drawable, z3);
                }
            }
        }
    }

    private Drawable j6(Context context, hi hiVar, int i) {
        return context.getResources().getDrawable(i);
    }

    void j6(Context context, Bitmap bitmap, boolean z) {
        i.j6((Object) bitmap);
        j6(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void j6(Context context, hi hiVar, boolean z) {
        Drawable drawable = null;
        if (this.DW != 0) {
            drawable = j6(context, hiVar, this.DW);
        }
        j6(drawable, z, false, false);
    }

    protected abstract void j6(Drawable drawable, boolean z, boolean z2, boolean z3);
}
