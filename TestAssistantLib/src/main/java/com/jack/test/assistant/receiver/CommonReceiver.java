package com.jack.test.assistant.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.jack.test.assistant.activity.PanelActivity;
import com.jack.test.assistant.util.LogUtils;

/**
 * Desc: 广播接收者
 * Created by Jack on 2020/8/9 16:14
 **/
public class CommonReceiver extends BroadcastReceiver {
    private static final String TAG = "CommonReceiver";
    private static final String ACTION_OPEN = "com.jack.test.assistant.action.open";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            LogUtils.w(TAG, "param invalid,intent is null.");
            return;
        }

        String action = intent.getAction();
        if (ACTION_OPEN.equals(action)) {//打开测试面板
            try {
                Intent openIntent = new Intent(context, PanelActivity.class);
                openIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(openIntent);
            } catch (Exception e) {
                LogUtils.e(TAG, "exception happen when  open test panel fail." + e);
            }
        }
    }
}
