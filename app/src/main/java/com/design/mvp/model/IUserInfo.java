package com.design.mvp.model;

/**
 * @author 任益波
 * @date 2016/10/19
 * @description
 */
public interface IUserInfo {

    interface OnChangeListener{
        void onChangeSuccess();
        void onChangeError();
    }

    void chageName(String name,OnChangeListener listener);

}
