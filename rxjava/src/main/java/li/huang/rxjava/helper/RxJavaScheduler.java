package li.huang.rxjava.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import li.huang.rxjava.R;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by huangli on 17/10/4.
 */

public class RxJavaScheduler {

    public final static String TAG = "RxJavaScheduler";

    public RxJavaScheduler() {
    }

    public void rxJavaSchedulerDemo(final Context context, final ImageView imageView){
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
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
