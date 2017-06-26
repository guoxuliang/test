package com.gxl.okhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.test.R;

/**
 * Created by Administrator on 2017/6/27 0027.
 */

public class OkHttpUtilsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button get;
    private Button post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhtputils);
        initView();
    }

    private void initView() {
        get=(Button)findViewById(R.id.get);
        post=(Button) findViewById(R.id.post);
        get.setOnClickListener(this);
        post.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get:

                break;
            case R.id.post:

                break;
        }

    }
}
