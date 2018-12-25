package com.zhaoshiji.pininputdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tapapk.pininputview.PinInputView;

public class MainActivity extends AppCompatActivity {
    private PinInputView pinInputView;
    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinInputView = findViewById(R.id.pinInputView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        pinInputView.setOnCancelClickListener(new PinInputView.OnCancelClickListener() {
            @Override
            public void OnCancelClick() {
                Toast.makeText(MainActivity.this, "点击取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        pinInputView.setOnFullListener(new PinInputView.OnFullListener() {
            @Override
            public void OnFull(String vaule) {
                Toast.makeText(MainActivity.this, "输入完成"+vaule, Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinInputView.ClearAll();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinInputView.Error();
            }
        });
    }
}
