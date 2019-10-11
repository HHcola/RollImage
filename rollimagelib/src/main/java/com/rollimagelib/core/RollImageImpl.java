package com.rollimagelib.core;

import android.graphics.Rect;

import com.rollimagelib.listener.RollListener;

public class RollImageImpl implements RollListener {
    private RollImageBuilder rollImageBuilder;
    private RollImageHelper rollImageHelper;

    public RollImageImpl(RollImageBuilder rollImageBuilder) {
        this.rollImageBuilder = rollImageBuilder;
        rollImageHelper = new RollImageHelper();
        rollImageHelper.calcImageData(this.rollImageBuilder);
    }

    @Override
    public void onScrolled(int dy) {

    }

}
