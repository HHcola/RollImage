package com.rollimage.rollimage;

import android.graphics.Bitmap;

/**
 * Created by timothyhe on 2019/10/14
 */
public class RollImageModel {

    public String text;
    public Bitmap img;
    public static final int TEXT_TYPE = 1;
    public static final int TEXT_IMG = 2;
    public int type;
}
