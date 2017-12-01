package demo.huangli.mydemosnew.logic_set_1.phoneboost;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by huangli on 17/2/3.
 */

public class BootBroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("BootBroadCastReceiver","收到自动启动应用的广播");
    }
}
