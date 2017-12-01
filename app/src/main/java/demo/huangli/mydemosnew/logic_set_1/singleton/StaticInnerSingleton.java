package demo.huangli.mydemosnew.logic_set_1.singleton;

/**
 * Created by huangli on 17/10/10.
 */

public class StaticInnerSingleton {

    private StaticInnerSingleton(){
    }

    public static StaticInnerSingleton getInstance(){
        return StaticInnerHolder.sInstance;
    }

    public static class StaticInnerHolder{
        public static final StaticInnerSingleton sInstance = new StaticInnerSingleton();
    }
}
