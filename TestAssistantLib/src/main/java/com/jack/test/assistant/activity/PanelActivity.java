package com.jack.test.assistant.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.jack.test.assistant.handle.ClickEventHandler;
import com.jack.test.assistant.handle.IClickEventHandler;
import com.jack.test.assistant.handle.ClickEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc: 面板
 * Created by Jack on 2020/7/11 18:05
 **/
public class PanelActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "PanelActivity";
    private Map<String, List<ClickEvent>> linkedHashMap = new LinkedHashMap<>();
    private IClickEventHandler clickEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clickEventHandler = new ClickEventHandler();
        initData();
        setContentView(initView());
    }

    private View initView() {
        LinearLayout mLlBtnContainer = new LinearLayout(this);
        mLlBtnContainer.setOrientation(LinearLayout.VERTICAL);
        mLlBtnContainer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Iterator<Map.Entry<String, List<ClickEvent>>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<ClickEvent>> next = iterator.next();
            String key = next.getKey();
            TextView tvGroup = new TextView(this);
            tvGroup.setText(key);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 6, 10, 6);
            mLlBtnContainer.addView(tvGroup, params);

            List<ClickEvent> value = next.getValue();
            if (value != null && value.size() > 0) {
                LinearLayout llBtnContainer = new LinearLayout(this);
                llBtnContainer.setOrientation(LinearLayout.HORIZONTAL);
                for (int i = 0; i < value.size(); i++) {
                    ClickEvent clickEvent = value.get(i);
                    Button btn = new Button(this);
                    btn.setText(clickEvent.getButtonName());
                    btn.setId(clickEvent.ordinal());
                    btn.setOnClickListener(this);
                    llBtnContainer.addView(btn, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                }
                mLlBtnContainer.addView(llBtnContainer, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            }
        }

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        scrollView.addView(mLlBtnContainer);

        LinearLayout mRlRoot = new LinearLayout(this);
        mRlRoot.addView(scrollView);
        return mRlRoot;
    }

    private void initData() {
        for (ClickEvent clickEvent : ClickEvent.values()) {
            String groupName = clickEvent.getGroupName();
            List<ClickEvent> list = linkedHashMap.get(groupName);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(groupName, list);
            }
            list.add(clickEvent);
        }
    }

    @Override
    public void onClick(View view) {
        ClickEvent clickEvent = ClickEvent.toEnum(view.getId());
        if (clickEvent != null && clickEventHandler != null) {
            clickEventHandler.handle(this, clickEvent);
        }
    }


}
