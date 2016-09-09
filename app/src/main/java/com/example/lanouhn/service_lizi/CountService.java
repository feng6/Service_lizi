package com.example.lanouhn.service_lizi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by lanouhn on 2016/9/9.
 * 没有UI交互的服务，不传值
 *后台运行
 */
public class CountService extends Service {
    private boolean threadDisable;

    private int count;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!threadDisable) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    count++;
                    Log.v("CountService", "Count is " + count);
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.threadDisable = true;
        Log.v("CountService", "on destroy");
    }

    public int getCount() {
        return count;
    }

}