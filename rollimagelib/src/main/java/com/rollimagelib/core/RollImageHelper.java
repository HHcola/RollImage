package com.rollimagelib.core;

public class RollImageHelper {
    private int imageViewHeight;
    private int imageViewWidth;

    private int bitmapHeight;
    private int bitmapWidth;
    private float scale;

    public void calcImageData(RollImageBuilder rollImageBuilder) {
        if (rollImageBuilder == null
            || rollImageBuilder.getImageView() == null
            || rollImageBuilder.getSrcBitmap() == null) {
            return;
        }

        imageViewHeight = rollImageBuilder.getImageView().getMeasuredHeight();
        imageViewWidth = rollImageBuilder.getImageView().getMeasuredWidth();
        bitmapHeight = rollImageBuilder.getSrcBitmap().getHeight();
        bitmapWidth = rollImageBuilder.getSrcBitmap().getWidth();
        calcImageScale(rollImageBuilder);
    }

    private void calcImageScale(RollImageBuilder rollImageBuilder) {
        float realImageViewWidth = imageViewWidth - rollImageBuilder.getPaddingLeft() - rollImageBuilder.getPaddingRight();
        scale = realImageViewWidth / bitmapWidth;
    }

    public int getImageViewHeight() {
        return imageViewHeight;
    }
    public int getBitmapHeight() {
        return bitmapHeight;
    }

    private float getScale() {
        return scale;
    }
}
