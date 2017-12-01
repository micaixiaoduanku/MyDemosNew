package li.huang.rxjava.scene_rxbinding;

import android.util.Log;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

/**
 * Created by huangli on 17/10/5.
 */

public class RxBindingHelper {

    public static final String TAG = "RxBindingHelper";

    public RxBindingHelper() {
    }

    public void bindView(Button button){
        RxView.clicks(button) // 以 Observable 形式来反馈点击事件
        .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.i(TAG,"button click");
                    }
        });
    }
}
