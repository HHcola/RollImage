package com.rollimage.rollimage;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.rollimage.R;

/**
 * Created by timothyhe on 2019/10/12
 */
public class RollImageViewHolder extends RecyclerView.ViewHolder implements RollImageView {
    private ImageView imageView;
    public RollImageViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.roll_image_id);
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setImageView(Bitmap bitmap) {
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
