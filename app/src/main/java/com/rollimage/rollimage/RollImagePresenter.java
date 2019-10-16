package com.rollimage.rollimage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by timothyhe on 2019/10/12
 */
public class RollImagePresenter {

    private ArrayList<RollImageModel> rollData;
    private RollImageData rollImageData;
    private Context context;

    public RollImagePresenter(Context context) {
        this.context = context;
        rollImageData = new RollImageData(context);
    }

    public void getData() {
        rollData = rollImageData.getData();
    }

    public int getDataSize() {
        if (rollData != null) {
            return rollData.size();
        }
        return 0;
    }

    public int getItemViewType(int position) {
        if (rollData != null) {
            RollImageModel rollImageModel = rollData.get(position);
            return rollImageModel.type;
        }

        return 0;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (rollData == null) {
            return;
        }
        RollImageModel model = rollData.get(position);
        if (model.type == RollImageModel.TEXT_TYPE && viewHolder instanceof  RollImageTextViewHolder) {
            RollImageTextViewHolder holder = (RollImageTextViewHolder)viewHolder;
            holder.setTitle(model.text);
        } else if (model.type == RollImageModel.TEXT_IMG && viewHolder instanceof  RollImageViewHolder) {
            RollImageViewHolder holder = (RollImageViewHolder)viewHolder;
            holder.setImageView(model.img);
        }
    }
}
