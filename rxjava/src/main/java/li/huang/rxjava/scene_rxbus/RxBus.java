package li.huang.rxjava.scene_rxbus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by huangli on 17/10/5.
 */

public class RxBus {
    private static volatile RxBus mInstance;

    private final Subject bus;

    public RxBus()
    {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 单例模式RxBus
     *
     * @return
     */

    public static RxBus getInstance(){
        /**
         * rxBus2 保证了mInstance实例化是一个原子操作
         */
        RxBus rxBus2 = mInstance;
        if (mInstance == null)
        {
            synchronized (RxBus.class)
            {
                rxBus2 = mInstance;
                if (mInstance == null)
                {
                    rxBus2 = new RxBus();
                    mInstance = rxBus2;
                }
            }
        }

        return rxBus2;
    }

    /**
     * 发送消息
     */
    public void post(Object object){
        bus.onNext(object);
    }

    /**
     * 接收消息
     */
    public <T> Observable<T> toObserverable(Class<T> eventType)
    {
        return bus.ofType(eventType);
    }
}
