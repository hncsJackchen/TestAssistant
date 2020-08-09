package com.jack.test.assistant.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Desc: 显示信息对话框
 * Created by Jack on 2020/8/9 16:50
 **/
public class InfoDialog extends Dialog {
    private TextView textView;

    public InfoDialog(Context context) {
        this(context, 0);
    }

    public InfoDialog(Context context, int themeResId) {
        super(context, themeResId);
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setWidth(200);
        textView.setHeight(100);

        setContentView(textView);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void setInfo(String info) {
        textView.setText(info);
    }

}
