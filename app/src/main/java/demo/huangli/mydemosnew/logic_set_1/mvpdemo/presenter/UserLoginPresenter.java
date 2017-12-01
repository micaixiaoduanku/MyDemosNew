package demo.huangli.mydemosnew.logic_set_1.mvpdemo.presenter;


import android.os.Handler;

import demo.huangli.mydemosnew.logic_set_1.mvpdemo.bean.User;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz.IUserBiz;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz.OnLoginListener;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz.UserBiz;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.view.IUserLoginView;

/**
 * Created by huangli on 17/9/8.
 */

public class UserLoginPresenter {
    private IUserLoginView iUserLoginView;
    private IUserBiz userBiz;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
        userBiz = new UserBiz();
    }

    public void login(){
        iUserLoginView.showLoading();
        userBiz.login(iUserLoginView.getUserName(), iUserLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserLoginView.toMainActivity(user);
                        iUserLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFail() {
                iUserLoginView.showFailedError();
                iUserLoginView.hideLoading();
            }
        });
    }
}
