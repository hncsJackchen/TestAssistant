package com.jack.test.assistant.handle;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.jack.test.assistant.TestAssistantManager;
import com.jack.test.assistant.dialog.InfoDialog;

/**
 * Desc:
 * Created by Jack on 2020/7/11 18:36
 **/
public class ClickEventHandler implements IClickEventHandler {
    private static final String TAG = "ClickEventHandler";

    @Override
    public void handle(Context context, ClickEvent clickEvent) {
        String appPackage = TestAssistantManager.getInstance().getAppPackage();
        if (TextUtils.isEmpty(appPackage)) {
            toastInit(context);
            return;
        }

        switch (clickEvent) {
            case APP_INFO:
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(TestAssistantManager.getInstance().getAppPackage(), 0);
                    String versionName = packageInfo.versionName;

                    StringBuilder sb = new StringBuilder();
                    sb.append("应用包名:").append(appPackage).append("\n");
                    sb.append("应用版本名:").append(versionName);
                    show(context, sb.toString());
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case APP_INFO_PACKAGE:
                StringBuilder sb = new StringBuilder();
                sb.append("应用包名:").append(appPackage).append("\n");
                show(context, sb.toString());
                break;
            case APP_INFO_VERSION:
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(TestAssistantManager.getInstance().getAppPackage(), 0);
                    String versionName = packageInfo.versionName;
                    show(context, "应用版本名:" + versionName);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void toastInit(Context context) {
        Log.w(TAG, "请先初始化 TestAssistantManager");
        Toast.makeText(context, "请先初始化 TestAssistantManager", Toast.LENGTH_SHORT).show();
    }

    private void show(Context context, String info) {
        InfoDialog dialog = new InfoDialog(context);
        dialog.setInfo(info);
        dialog.show();
    }
}
