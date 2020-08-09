package com.jack.test.assistant.handle;

/**
 * Desc:测试按钮信息
 * Created by Jack on 2020/6/24 9:28
 **/
public enum ClickEvent {
    APP_INFO("应用信息", "All"),
    APP_INFO_PACKAGE("应用信息", "包名"),
    APP_INFO_VERSION("应用信息", "版本号"),;


    private String groupName;
    private String buttonName;

    ClickEvent(String groupName, String buttonName) {
        this.groupName = groupName;
        this.buttonName = buttonName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getButtonName() {
        return buttonName;
    }

    public static ClickEvent toEnum(int order) {
        for (ClickEvent enumType : ClickEvent.values()) {
            if (enumType != null && (enumType.ordinal() == order)) {
                return enumType;
            }
        }
        return null;
    }
}