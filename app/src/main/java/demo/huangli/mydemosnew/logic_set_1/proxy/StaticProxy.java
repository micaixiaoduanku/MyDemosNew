package demo.huangli.mydemosnew.logic_set_1.proxy;

/**
 * Created by huangli on 17/11/7.
 */

public class StaticProxy implements RentSubjectImpl{

    private RentSubjectImpl rentSubject;

    public StaticProxy(RentSubjectImpl rentSubject) {
        this.rentSubject = rentSubject;
    }

    @Override
    public void rentHouse() {
        System.out.println("按照要求寻找 要求大小15平方，在内环里面，独立卫生间，精装修");
    }
}
