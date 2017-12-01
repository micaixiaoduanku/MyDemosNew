package demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz;

/**
 * Created by huangli on 17/9/8.
 */

public interface IUserBiz {
    void login(final String username,final String password, final OnLoginListener loginListener);
}
