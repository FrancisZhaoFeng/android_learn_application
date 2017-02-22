package com.meizu.layout.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.meizu.layout.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class KnifeActivity extends AppCompatActivity {
    @Bind(R.id.btn_knifer)
    Button btnKnife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knife);
        ButterKnife.bind(this);//初始化ButterKnife
    }

    @OnClick(R.id.btn_knifer)
    public void showToast() {
        Toast.makeText(this, btnKnife.getText().toString(), Toast.LENGTH_LONG).show();
        if (btnKnife.getText().toString().equals("Butter Knife")) {
            btnKnife.setText("test");
        } else {
            btnKnife.setText("Butter Knife");
        }
    }
}
