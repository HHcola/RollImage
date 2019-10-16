package com.rollimage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rollimage.rollimage.RollImageActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button = findViewById(R.id.roll_image);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.roll_image) {
            startRollImage();
        }
    }

    private void startRollImage() {
        Intent intent = new Intent(this, RollImageActivity.class);
        this.startActivity(intent);
    }
}
