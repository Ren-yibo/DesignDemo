package com.design.mvp.Presenter;

import com.design.mvp.model.IUserInfo;
import com.design.mvp.model.UserInfoImpl;
import com.design.mvp.view.IUserInfoView;

/**
 * @author 任益波
 * @date 2016/10/19
 * @description
 */
public class UserInfoPresenterImpl implements IUserInfoPresenter {

    private IUserInfoView userInfoView;
    private IUserInfo userInfoModel;

    public UserInfoPresenterImpl(IUserInfoView userInfoView) {
        this.userInfoView = userInfoView;
        this.userInfoModel = new UserInfoImpl();
    }

    @Override
    public void changeName(String name) {
        if(null != userInfoView){
            userInfoView.showNameInput();
        }
    }
}
