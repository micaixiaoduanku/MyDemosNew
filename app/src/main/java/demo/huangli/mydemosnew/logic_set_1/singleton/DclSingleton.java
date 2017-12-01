package demo.huangli.mydemosnew.logic_set_1.singleton;

/**
 * Created by huangli on 17/10/9.
 */

public class DclSingleton {
    private static volatile DclSingleton mInstance = null;

    public static DclSingleton getInstance() {
        if (mInstance == null){
            synchronized (DclSingleton.class){
                if (mInstance == null){
                    mInstance = new DclSingleton();
                }
            }
        }
        return mInstance;
    }
}
