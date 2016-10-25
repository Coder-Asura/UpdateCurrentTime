package com.lxd.updatecurrenttime.utils;

import android.os.Handler;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Liuxd on 2016/10/25 16:03.
 * 计时器
 */
public class CurrentTimeTimer {
    private Timer mTimer;
    private TimeTask timeTask;
    private Handler mHandler;
    private boolean isStart;

    /**
     * @param handler handler
     */
    public CurrentTimeTimer(Handler handler) {
        mTimer = new Timer();
        this.mHandler = handler;
    }

    private class TimeTask extends TimerTask {
        @Override
        public void run() {
            sendMsgToView();
        }
    }

    private void sendMsgToView() {
        Message msg = mHandler.obtainMessage();
        msg.what = 0x1000;
        mHandler.sendMessage(msg);
    }

    public void start() {
        if (mTimer == null) {
            mTimer = new Timer();
        }
        if (timeTask == null) {
            timeTask = new TimeTask();
        }
        if (!isStart) {
            mTimer.schedule(timeTask, 0, 1000);
            isStart = true;
        }
    }

    public void cancelTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
        if (timeTask != null) {
            timeTask.cancel();
            timeTask = null;
        }
        isStart = false;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isCancel() {
        return mTimer == null;
    }
}
