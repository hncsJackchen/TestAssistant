package com.jack.test.assistant;

import android.content.Context;
import android.content.IntentFilter;

import com.jack.test.assistant.receiver.CommonReceiver;

/**
 * Desc: 测试助手管理者
 * Created by Jack on 2020/7/11 18:46
 **/
public class TestAssistantManager {
    private static TestAssistantManager instance = new TestAssistantManager();
    private String appPackage;

    public static TestAssistantManager getInstance() {
        return instance;
    }

    public void init(Context context) {
        appPackage = context.getPackageName();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.jack.test.assistant.action.open");
        context.registerReceiver(new CommonReceiver(), intentFilter);
    }

    public String getAppPackage() {
        return appPackage;
    }
}
