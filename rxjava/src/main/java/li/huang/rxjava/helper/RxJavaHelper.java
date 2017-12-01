package li.huang.rxjava.helper;

/**
 * Created by huangli on 17/2/24.
 */


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import li.huang.rxjava.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * rxJava是一套流式的api lib.
 * 下面是它的一些简单创建和使用
 */
public class RxJavaHelper {

    public final static String TAG = "RxJavaHelper";
    /**
     * rxJava的基本流程
     */
    public void basicRxJava(){
        /**
         * 创建observer  (创建观察者方式一)
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"observer onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"observer onError");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG,"observer onNext " +s);
            }
        };
        /**
         * 创建Subscriber  (创建观察者方式二)
         */
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"subscriber onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"subscriber onError");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG,"subscriber onNext "+s);
            }
        };
        /**
         * 创建 Observable 方式一
         */
        Observable observableStyleOne = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("World");
                subscriber.onCompleted();
            }
        });
        /**
         * RxJava 还提供了一些方法用来快捷创建事件队列
         */
        /**
         * 方式二
         */
        Observable observableStyleTwo = Observable.just(1,2,3,4);
        /**
         * 方式三
         */
        String[] array = new String[]{"Hello","World","Mine"};
        Observable observableStyleThree = Observable.from(array);

        /**
         * 订阅 subscribe
         */
//        observableStyleOne.subscribe(observer);
        observableStyleOne.subscribe(subscriber);


        /**
         * 不完整订阅回调 风格一
         */
        observableStyleOne.subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                Log.i(TAG,"call "+o);
            }
        });
        /**
         * 不完整订阅回调 风格二
         */
        observableStyleOne.subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                Log.i(TAG,"call "+o);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.i(TAG,"call "+throwable.getMessage());
            }
        });
        /**
         * 不完整订阅回调 风格三
         */
        observableStyleOne.subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                Log.i(TAG, "call " + o);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.i(TAG, "call " + throwable.getMessage());
            }
        }, new Action0() {
            @Override
            public void call() {
                Log.i(TAG, "call 完成");
            }
        });
    }

    public void rxJavaBasicDemo(final Context context, final ImageView imageView){
        String[] names = new String[]{"Hello","How","Your"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG,"打印 "+s);
            }
        });
        Observer<Drawable> observer = new Observer<Drawable>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }
        };
        Observable.create(new Observable.OnSubscribe<Drawable>() {

            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    drawable = context.getDrawable(R.mipmap.demo1);
                    subscriber.onNext(drawable);
                    subscriber.onCompleted();
                }else{
                    subscriber.onError(new Throwable("android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP"));
                }
            }
        }).subscribe(observer);
    }

}
