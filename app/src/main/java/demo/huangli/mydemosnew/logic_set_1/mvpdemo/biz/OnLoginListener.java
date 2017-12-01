package demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz;

import demo.huangli.mydemosnew.logic_set_1.mvpdemo.bean.User;

/**
 * Created by huangli on 17/9/8.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFail();
}
