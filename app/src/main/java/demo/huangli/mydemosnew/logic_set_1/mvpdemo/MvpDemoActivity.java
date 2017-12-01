package demo.huangli.mydemosnew.logic_set_1.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.huangli.mydemosnew.logic_set_1.mvpdemo.bean.User;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.view.IUserLoginView;

/**
 * Created by huangli on 17/9/7.
 */

public class MvpDemoActivity extends Activity implements IUserLoginView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
