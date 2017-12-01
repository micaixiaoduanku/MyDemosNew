package doct.mobi.album.rxjava2.helper;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by huangli on 17/10/6.
 */

public class RxJavaBasicHelper {

    public static final String TAG = "RxjavaBasicHelper";

    public RxJavaBasicHelper() {
    }

    public void rxJavaBasicDemo(){
        //创建一个上游 Observable：
        Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter observableEmitter) throws Exception {
                observableEmitter.onNext("1");
                observableEmitter.onNext("2");
                observableEmitter.onNext("3");
                observableEmitter.onComplete();
            }
        }).subscribe(new Observer<String>() {

            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                mDisposable = disposable;
            }

            @Override
            public void onNext(String o) {
                Log.i(TAG,"onNext "+o);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                Log.i(TAG,"onComplete ");
            }
        });
    }
}
