package com.lxd.updatecurrenttime.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lxd.updatecurrenttime.R;
import com.lxd.updatecurrenttime.utils.CurrentTimeTimer;
import com.lxd.updatecurrenttime.utils.TimeUtils;

/**
 * Created by Liuxd on 2016/10/25 21:47.
 * 用Timer方式更新当前时间
 */

public class Way1Activity extends AppCompatActivity implements View.OnClickListener {
    private CurrentTimeTimer currentTimeTimer;
    private TextView tv_current_time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way1);
        tv_current_time1 = (TextView) findViewById(R.id.current_time1);
        Button start_update1 = (Button) findViewById(R.id.start_update1);
        Button stop_update1 = (Button) findViewById(R.id.stop_update1);

        start_update1.setOnClickListener(this);
        stop_update1.setOnClickListener(this);

        currentTimeTimer = new CurrentTimeTimer(new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x1000) {
                    tv_current_time1.setText(TimeUtils.getDate() + "  " + TimeUtils.getTime());
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
//        currentTimeTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentTimeTimer.cancelTimer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_update1:
                currentTimeTimer.start();
                break;
            case R.id.stop_update1:
                currentTimeTimer.cancelTimer();
                break;
        }
    }
}
