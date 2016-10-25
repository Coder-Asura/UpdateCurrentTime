package com.lxd.updatecurrenttime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lxd.updatecurrenttime.R;

/**
 * Created by Liuxd on 2016/10/25 16:07.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button way1 = (Button) findViewById(R.id.way1);
        Button way2 = (Button) findViewById(R.id.way2);
        Button way3 = (Button) findViewById(R.id.way3);

        way1.setOnClickListener(this);
        way2.setOnClickListener(this);
        way3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.way1:
                intent = new Intent(MainActivity.this, AutoCountTimeActivity.class);
                break;
            case R.id.way2:
                intent = new Intent(MainActivity.this, AutoCountTimeActivity.class);
                break;
            case R.id.way3:
                intent = new Intent(MainActivity.this, AutoCountTimeActivity.class);
                break;
        }
        startActivity(intent);
    }
}
