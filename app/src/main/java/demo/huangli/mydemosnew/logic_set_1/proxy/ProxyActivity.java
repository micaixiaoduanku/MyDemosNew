package demo.huangli.mydemosnew.logic_set_1.proxy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.reflect.Proxy;

/**
 * Created by huangli on 17/11/7.
 */

public class ProxyActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    public void test(){
        XiaoMing xiaoMing = new XiaoMing();
        ProxyHandler proxyHandler = new ProxyHandler(xiaoMing);
        RentSubjectImpl rentSubject = (RentSubjectImpl) Proxy.newProxyInstance(xiaoMing.getClass().getClassLoader(),xiaoMing.getClass().getInterfaces(),proxyHandler);
        rentSubject.rentHouse("huangli");
    }

}
