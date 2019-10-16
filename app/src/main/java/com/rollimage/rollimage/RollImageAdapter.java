package com.rollimage.rollimage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rollimage.R;

/**
 * Created by timothyhe on 2019/10/12
 */
public class RollImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private RollImagePresenter presenter;


    public RollImageAdapter(RollImagePresenter presenter) {
        this.presenter = presenter;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        if (type == RollImageModel.TEXT_TYPE) {
            return new RollImageTextViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.roll_image_text, viewGroup, false));
        } else if (type == RollImageModel.TEXT_IMG) {
            return new RollImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.roll_image, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (presenter != null) {
            presenter.onBindViewHolder(viewHolder, i);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (presenter != null) {
            return presenter.getItemViewType(position);
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        if (presenter != null) {
            return presenter.getDataSize();
        }
        return 0;
    }
}
