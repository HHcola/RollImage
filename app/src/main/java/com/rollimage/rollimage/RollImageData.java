package com.rollimage.rollimage;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by timothyhe on 2019/10/16
 */
public class RollImageData {

    private Context context;
    public RollImageData(Context context) {
        this.context = context;
    }

    public ArrayList<RollImageModel> getData() {
        ArrayList<RollImageModel> rollImageModels = new ArrayList<>();
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getImgData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        rollImageModels.add(getTextData());
        return rollImageModels;
    }

    private RollImageModel getTextData() {
        RollImageModel model = new RollImageModel();
        model.type = RollImageModel.TEXT_TYPE;
        model.text = "for test";
        return model;
    }

    private RollImageModel getImgData() {
        RollImageModel model = new RollImageModel();
        model.type = RollImageModel.TEXT_IMG;
        model.text = "for test";
        AssetManager manager = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = manager.open("test.jpg");
            model.img = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return model;
    }
}
