package com.lxd.updatecurrenttime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Liuxd on 2016/10/25 17:27.
 * 用Handler方式更新当前时间
 */

public class Way2Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_current_time2;
    private boolean goOn = true;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x01:
                    tv_current_time2.setText(TimeUtils.getCurrentTime());
                    if (goOn)
                        mHandler.sendEmptyMessageDelayed(0x01, 1);
                    break;
                case 0x00:
                    goOn = false;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_way2);
        tv_current_time2 = (TextView) findViewById(R.id.current_time2);
        Button start_update2 = (Button) findViewById(R.id.start_update2);
        Button stop_update2 = (Button) findViewById(R.id.stop_update2);
        Button way1 = (Button) findViewById(R.id.way1);

        start_update2.setOnClickListener(this);
        stop_update2.setOnClickListener(this);
        way1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_update2:
                goOn = true;
                mHandler.sendEmptyMessage(0x01);
                break;
            case R.id.stop_update2:
                mHandler.sendEmptyMessage(0x00);
                break;
            case R.id.way1:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeMessages(0x01);
        mHandler.removeMessages(0x00);
    }
}
