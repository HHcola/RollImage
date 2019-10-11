package com.rollimagelib.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;


/**
 * RollImage Params
 * bitmap, padding
 */
public class RollImageBuilder {
    private Context context;
    private ImageView imageView;
    private int padddingTop;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private Bitmap srcBitmap;

    public int getPadddingTop() {
        return padddingTop;
    }

    public void setPadddingTop(int padddingTop) {
        this.padddingTop = padddingTop;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public Bitmap getSrcBitmap() {
        return srcBitmap;
    }

    public void setSrcBitmap(Bitmap srcBitmap) {
        this.srcBitmap = srcBitmap;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
