package com.design.mvp.model;

/**
 * @author 任益波
 * @date 2016/10/19
 * @description
 */
public class UserInfoImpl implements IUserInfo {

    @Override
    public void chageName(String name, OnChangeListener listener) {

        if (null == name || name.length() == 0) {
            listener.onChangeError();
        } else {
            listener.onChangeSuccess();
        }

    }
}
