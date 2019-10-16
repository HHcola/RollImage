package com.rollimage.rollimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rollimage.R;

public class RollImageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RollImageAdapter adapter;
    private RollImagePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_image);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler);
        presenter = new RollImagePresenter(this);
        adapter = new RollImageAdapter(presenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter.getData();
        adapter.notifyDataSetChanged();
    }
}
