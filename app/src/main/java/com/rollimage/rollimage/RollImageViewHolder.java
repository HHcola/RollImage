package com.rollimage.rollimage;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by timothyhe on 2019/10/12
 */
public class RollImageViewHolder extends RecyclerView.ViewHolder implements RollImageView {
    public RollImageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setImageView(Bitmap bitmap) {

    }
}
