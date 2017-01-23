package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleCursorAdapter extends ResourceCursorAdapter {
    protected int[] f1178j;
    protected int[] f1179k;
    String[] f1180l;
    private int f1181m;
    private CursorToStringConverter f1182n;
    private ViewBinder f1183o;

    public interface CursorToStringConverter {
        CharSequence m2401a(Cursor cursor);
    }

    public interface ViewBinder {
        boolean m2402a(View view, Cursor cursor, int i);
    }

    public void m2404a(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.f1183o;
        int length = this.f1179k.length;
        int[] iArr = this.f1178j;
        int[] iArr2 = this.f1179k;
        for (int i = 0; i < length; i++) {
            View findViewById = view.findViewById(iArr2[i]);
            if (findViewById != null) {
                boolean a;
                if (viewBinder != null) {
                    a = viewBinder.m2402a(findViewById, cursor, iArr[i]);
                } else {
                    a = false;
                }
                if (a) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (findViewById instanceof TextView) {
                        m2406a((TextView) findViewById, string);
                    } else if (findViewById instanceof ImageView) {
                        m2405a((ImageView) findViewById, string);
                    } else {
                        throw new IllegalStateException(findViewById.getClass().getName() + " is not a " + " view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    public void m2405a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void m2406a(TextView textView, String str) {
        textView.setText(str);
    }

    public CharSequence m2408c(Cursor cursor) {
        if (this.f1182n != null) {
            return this.f1182n.m2401a(cursor);
        }
        if (this.f1181m > -1) {
            return cursor.getString(this.f1181m);
        }
        return super.m2063c(cursor);
    }

    private void m2403a(String[] strArr) {
        if (this.c != null) {
            int length = strArr.length;
            if (this.f1178j == null || this.f1178j.length != length) {
                this.f1178j = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.f1178j[i] = this.c.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.f1178j = null;
    }

    public Cursor m2407b(Cursor cursor) {
        Cursor b = super.m2060b(cursor);
        m2403a(this.f1180l);
        return b;
    }
}
