package demo.huangli.mydemosnew.logic_set_1.singleton;

/**
 * Created by huangli on 17/10/9.
 */

public class LazySingleton {
    private static LazySingleton singleton;
    private LazySingleton() {
    }
    public static LazySingleton getLazySingletonInstance(){
        if (singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}
