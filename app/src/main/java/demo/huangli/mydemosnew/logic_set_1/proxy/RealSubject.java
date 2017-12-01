package demo.huangli.mydemosnew.logic_set_1.proxy;

/**
 * Created by huangli on 17/11/7.
 */

public class RealSubject implements Subject{
    @Override
    public void doSomething() {
        System.out.println( "call doSomething()" );
    }
}
