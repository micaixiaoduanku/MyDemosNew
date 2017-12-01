package demo.huangli.mydemosnew.logic_set_1.singleton;

/**
 * Created by huangli on 17/10/9.
 */

public class HungerSingleton {
    private static HungerSingleton singleton = new HungerSingleton();
    private HungerSingleton() {
    }
    public static HungerSingleton getHungerSingletonInstance(){
        return singleton;
    }
}
