package li.huang.rxjava.scene_rxbus;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by huangli on 17/10/5.
 */

public class RxBusActivity extends Activity{

    public static final String TAG = "RxBusActivity";

    private Subscription rxSbscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rxSbscription = RxBus.getInstance().toObserverable(RxEvent.class).subscribe(new Action1<RxEvent>() {
            @Override
            public void call(RxEvent rxEvent) {
                Log.i(TAG,"收到 RxEvent ");
            }
        });
        RxBus.getInstance().post(new RxEvent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!rxSbscription.isUnsubscribed()){
            rxSbscription.unsubscribe();
        }
    }
}
