package it.gmariotti.cardslib.library.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtils {
    private static final String TAG = "BitmapUtils";

    public static File createFileFromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, bytes);
        File photoStorage = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        if (photoStorage == null) {
            return null;
        }
        File photoFile = new File(photoStorage, System.currentTimeMillis() + ".png");
        try {
            FileOutputStream fo = new FileOutputStream(photoFile);
            fo.write(bytes.toByteArray());
            fo.flush();
            fo.close();
            return photoFile;
        } catch (IOException e) {
            Log.e(TAG, "Error saving image ", e);
            return photoFile;
        }
    }

    public static Intent createIntentFromImage(File image) {
        Intent share = new Intent("android.intent.action.SEND");
        share.setType("image/*");
        return share.putExtra("android.intent.extra.STREAM", Uri.fromFile(image));
    }
}
