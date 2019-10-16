package com.rollimage.rollimage;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rollimage.R;

/**
 * Created by timothyhe on 2019/10/12
 */
public class RollImageTextViewHolder extends RecyclerView.ViewHolder implements RollImageView {
    private TextView textView;
    public RollImageTextViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.roll_text_id);
    }

    @Override
    public void setTitle(String title) {
        textView.setText(title);
    }

    @Override
    public void setImageView(Bitmap bitmap) {

    }
}