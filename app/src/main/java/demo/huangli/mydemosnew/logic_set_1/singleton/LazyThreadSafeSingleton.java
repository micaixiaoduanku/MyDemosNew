package demo.huangli.mydemosnew.logic_set_1.singleton;

/**
 * Created by huangli on 17/10/9.
 */

public class LazyThreadSafeSingleton {
    private static LazyThreadSafeSingleton singleton;
    private LazyThreadSafeSingleton() {
    }
    public synchronized static LazyThreadSafeSingleton getLazyThreadSafeSingletonInstance(){
        if (singleton == null){
            singleton = new LazyThreadSafeSingleton();
        }
        return singleton;
    }
}
