package com.lxd.updatecurrenttime.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lxd.updatecurrenttime.utils.CurrentTimeTimer;

/**
 * Created by Liuxd on 2016/10/25 20:47.
 * 自动计时TextView(写完去百度才发现还有个Chronometer，瞬间感觉我的Low爆了，还是不要脸的push了)
 */

public class AutoCountTimeView extends TextView {
    private CurrentTimeTimer currentTimeTimer;
    private int hour = 0, min = 0, sec = 0;
    private int maxHour = 99;

    public AutoCountTimeView(Context context) {
        super(context);
        init();
    }

    public AutoCountTimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoCountTimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AutoCountTimeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        currentTimeTimer = new CurrentTimeTimer(new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0x1000) {
                    setText(getTime());
                }
            }
        });
    }

    /**
     * 开始计时
     */
    public void start() {
        if (currentTimeTimer.isCancel())
            setText("00:00:00");
        currentTimeTimer.start();
    }

    /**
     * 暂停计时
     */
    public void pause() {
        currentTimeTimer.cancelTimer();
    }

    /**
     * 继续计时
     */
    public void goOn() {
        if (currentTimeTimer.isCancel()) {
            currentTimeTimer.start();
        }
    }

    /**
     * 停止计时
     */
    public void stop() {
        setText("00:00:00");
        currentTimeTimer.cancelTimer();
        hour = 0;
        min = 0;
        sec = 0;
    }

    /**
     * 获取当前计时
     *
     * @return 当前计时
     */
    private String getTime() {
        sec++;
        if (sec >= 60) {
            min++;
            sec = 0;
        }
        if (min >= 60) {
            hour++;
            min = 0;
        }
        String secs = sec < 10 ? "0" + sec : sec + "";
        String mins = min < 10 ? "0" + min : min + "";
        String hours = hour < 10 ? "0" + hour : hour + "";
        String result = hour > maxHour ? "超出最大值" : hours + ":" + mins + ":" + secs;
        return hours + ":" + mins + ":" + secs;
    }

    /**
     * 设置支持的最大小时数
     *
     * @param maxHour 最大小时数
     */
    public void setMaxHour(int maxHour) {
        this.maxHour = maxHour;
    }
}
