package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;

public interface ImageDecoder {
    Bitmap decode(ImageDecodingInfo imageDecodingInfo);
}
