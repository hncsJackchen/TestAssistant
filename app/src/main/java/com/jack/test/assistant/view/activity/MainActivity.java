package com.jack.test.assistant.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jack.test.assistant.activity.PanelActivity;
import com.jack.test.assistant.view.R;

/**
 * 示例代码界面
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private Button mBtnOpen, mBtnOpenByBroadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnOpen = (Button) findViewById(R.id.btn_main_open);
        mBtnOpen.setOnClickListener(this);
        mBtnOpenByBroadcast = (Button) findViewById(R.id.btn_main_open_by_broadcast);
        mBtnOpenByBroadcast.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_open:
                open();
                break;
            case R.id.btn_main_open_by_broadcast:
                openByBroadcast();
                break;
        }
    }

    private void open() {
        Intent intent = new Intent(this, PanelActivity.class);
        startActivity(intent);
    }

    private void openByBroadcast() {
        Intent intent = new Intent();
        intent.setAction("com.jack.test.assistant.action.open");
        sendBroadcast(intent);
    }
}
