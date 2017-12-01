package demo.huangli.mydemosnew.logic_set_1.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by huangli on 17/11/7.
 */

public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler( Object target )
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (target instanceof RentSubjectImpl){
            System.out.println("按照要求寻找 要求大小15平方，在内环里面，独立卫生间，精装修");
        }
        return method.invoke( target, args);
    }
}
