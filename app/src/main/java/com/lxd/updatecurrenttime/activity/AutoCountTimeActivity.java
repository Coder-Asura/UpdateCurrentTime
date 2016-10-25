package com.lxd.updatecurrenttime.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lxd.updatecurrenttime.R;
import com.lxd.updatecurrenttime.view.AutoCountTimeView;

/**
 * Created by Liuxd on 2016/10/25 20:43.
 * 自动计时Activity
 */

public class AutoCountTimeActivity extends AppCompatActivity {
    private AutoCountTimeView count_time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocounttime);
        count_time = (AutoCountTimeView) findViewById(R.id.count_time);
        Button start = (Button) findViewById(R.id.start);
        Button pause = (Button) findViewById(R.id.pause);
        Button goOn = (Button) findViewById(R.id.goOn);
        Button stop = (Button) findViewById(R.id.stop);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time.pause();
            }
        });
        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time.goOn();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_time.stop();
            }
        });

    }
}
