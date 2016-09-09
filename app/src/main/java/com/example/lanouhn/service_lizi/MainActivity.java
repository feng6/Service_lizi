package com.example.lanouhn.service_lizi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.startService(new Intent(this, CountService.class));//连接服务
        initview();
        initLinstener();
    }

    //监听事件
    private void initLinstener() {
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(it);
            }
        });
    }

    //找到控件
    private void initview() {
        sa = (Button) findViewById(R.id.sa);
    }
//解绑服务
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.stopService(new Intent(this, CountService.class));
    }
}