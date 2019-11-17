package com.example.algorithmbyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.algorithmbyjava.SearchAlgorithm.SearchBinaryActivity;
import com.example.algorithmbyjava.SearchAlgorithm.SearchLinearActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.search_linear).setOnClickListener(this);
        findViewById(R.id.search_binary).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_linear://线性查找
                startActivity(new Intent(MainActivity.this, SearchLinearActivity.class));
                break;
            case R.id.search_binary://二分查找
                startActivity(new Intent(MainActivity.this, SearchBinaryActivity.class));
                break;
        }
    }
}
