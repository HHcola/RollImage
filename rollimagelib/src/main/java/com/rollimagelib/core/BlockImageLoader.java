package com.rollimagelib.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;

/**
 * Created by timothyhe on 2019/10/12
 */
public class BlockImageLoader {

    BitmapRegionDecoder bitmapRegionDecoder;

    public void setBitmapRegionDecoder(BitmapRegionDecoder bitmapRegionDecoder) {
        this.bitmapRegionDecoder = bitmapRegionDecoder;
    }

    public Bitmap getRegionBitmap(Rect rect) {
        if (bitmapRegionDecoder == null) {
            return null;
        }

        BitmapFactory.Options options =  new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return bitmapRegionDecoder.decodeRegion(rect, options);
    }
}
