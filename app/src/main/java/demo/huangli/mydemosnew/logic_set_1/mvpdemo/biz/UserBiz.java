package demo.huangli.mydemosnew.logic_set_1.mvpdemo.biz;

import demo.huangli.mydemosnew.logic_set_1.mvpdemo.bean.User;

/**
 * Created by huangli on 17/9/8.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username,final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("zhy".equals(username) && "123".equals(password)){
                    User user = new User();
                    user.setPassword(password);
                    user.setUsername(username);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFail();
                }
            }
        }.start();
    }
}
