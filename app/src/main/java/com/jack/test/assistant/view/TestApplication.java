package com.jack.test.assistant.view;

import android.app.Application;

import com.jack.test.assistant.TestAssistantManager;

/**
 * Desc: 测试助手应用入口
 * Created by Jack on 2020/8/9 16:02
 **/
public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TestAssistantManager.getInstance().init(this);
    }
}
