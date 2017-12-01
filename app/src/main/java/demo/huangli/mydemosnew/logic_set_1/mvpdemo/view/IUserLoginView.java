package demo.huangli.mydemosnew.logic_set_1.mvpdemo.view;

import demo.huangli.mydemosnew.logic_set_1.mvpdemo.bean.User;

/**
 * Created by huangli on 17/9/8.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassword();
    void clearUserName();
    void clearPassword();
    void showLoading();
    void hideLoading();
    void toMainActivity(User user);
    void showFailedError();
}
