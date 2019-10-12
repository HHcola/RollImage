package com.rollimagelib.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.rollimagelib.listener.RollListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RollImageView extends View implements RollListener {
    private Bitmap mBitmap;
    private int mDrawableWidth;
    private int mDrawableHeight;
    private float mScale = 1;
    private float mOffsetX = 0;
    private float mOffsetY = 0;
    private Drawable defaultDrawable;
    private Drawable mDrawable;
    private boolean isAttachedWindow = false;
    private Rect tempVisibilityRect = new Rect();
    private Rect tempImageRect = new Rect();
    int[] location = new int[2];
    private Rect mWindowVisibleDisplayFrame = new Rect();

    private BlockImageLoader mBlockImageLoader;
    private BitmapRegionDecoder bitmapRegionDecoder;


    public RollImageView(Context context) {
        super(context);
        init();
    }

    public RollImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mBlockImageLoader = new BlockImageLoader();
    }

    public void setScale(float scale, float offsetX, float offsetY) {
        this.mScale = scale;
        this.mOffsetX = offsetX;
        this.mOffsetY = offsetY;
        notifyInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int viewWidth = getWidth();
        int viewHeight = getHeight();
        if (viewWidth == 0) {
            return;
        }
        Rect visibilityRect = tempVisibilityRect;
        getVisibilityRect(visibilityRect);
        float width = mScale * viewWidth;
        int imgWidth = mBitmap.getWidth();
        float imageScale = imgWidth / width;

        Rect imageRect = tempImageRect;
        imageRect.left = (int) Math.ceil((visibilityRect.left - mOffsetX) * imageScale);
        imageRect.top = (int) Math.ceil((visibilityRect.top - mOffsetY) * imageScale);
        imageRect.right = (int) Math.ceil((visibilityRect.right - mOffsetX) * imageScale);
        imageRect.bottom = (int) Math.ceil((visibilityRect.bottom - mOffsetY) * imageScale);

        int saveCount = canvas.save();
        Bitmap data = mBlockImageLoader.getRegionBitmap(imageRect);
        canvas.drawBitmap(data, imageRect, imageRect, null);
        canvas.restoreToCount(saveCount);
    }


    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        try {
            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(byteArray,0, byteArray.length, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mBlockImageLoader.setBitmapRegionDecoder(bitmapRegionDecoder);
    }


    public void setImageDrawable(Drawable drawable) {
        mScale = 1;
        mOffsetX = 0;
        mOffsetY = 0;
        if (mDrawable != drawable) {
            final int oldWidth = mDrawableWidth;
            final int oldHeight = mDrawableHeight;
            updateDrawable(drawable);
            onLoadImageSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (oldWidth != mDrawableWidth || oldHeight != mDrawableHeight) {
                requestLayout();
            }
            invalidate();
        }
    }

    public void onLoadImageSize(final int imageWidth, final int imageHeight) {
        mDrawableWidth = imageWidth;
        mDrawableHeight = imageHeight;
        notifyInvalidate();
    }

    private void updateDrawable(Drawable d) {
        boolean sameDrawable = false;
        if (mDrawable != null) {
            sameDrawable = mDrawable == d;
            mDrawable.setCallback(null);
            unscheduleDrawable(mDrawable);
            if (!sameDrawable && isAttachedWindow) {
                mDrawable.setVisible(false, false);
            }
        }
        mDrawable = d;
        if (d != null) {
            d.setCallback(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                d.setLayoutDirection(getLayoutDirection());
            }
            if (d.isStateful()) {
                d.setState(getDrawableState());
            }
            if (!sameDrawable ) {
                final boolean visible =  isAttachedWindow && getWindowVisibility() == VISIBLE && isShown();
                d.setVisible(visible, true);
            }
            mDrawableWidth = d.getIntrinsicWidth();
            mDrawableHeight = d.getIntrinsicHeight();
        } else {
            mDrawableWidth = mDrawableHeight = -1;
        }
    }


    protected void getVisibilityRect(Rect visibleRect) {
        getGlobalVisibleRect(visibleRect);

        getWindowVisibleDisplayFrame(mWindowVisibleDisplayFrame);

        if (visibleRect.left < mWindowVisibleDisplayFrame.left) {
            visibleRect.left = mWindowVisibleDisplayFrame.left;
        }
        if (visibleRect.right > mWindowVisibleDisplayFrame.right) {
            visibleRect.right = mWindowVisibleDisplayFrame.right;
        }
        if (visibleRect.top < mWindowVisibleDisplayFrame.top) {
            visibleRect.top = mWindowVisibleDisplayFrame.top;
        }
        if (visibleRect.bottom > mWindowVisibleDisplayFrame.bottom) {
            visibleRect.bottom = mWindowVisibleDisplayFrame.bottom;
        }
        getLocationInWindow(location);
        visibleRect.left = visibleRect.left - location[0];
        visibleRect.right = visibleRect.right - location[0];
        visibleRect.top = visibleRect.top - location[1];
        visibleRect.bottom = visibleRect.bottom - location[1];
    }

    private void notifyInvalidate() {
        ViewCompat.postInvalidateOnAnimation(this);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        isAttachedWindow = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        isAttachedWindow = false;

    }

    @Override
    public void onScrolled(int dy) {

    }
}
