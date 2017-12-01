package demo.huangli.mydemosnew.logic_set_1.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/11/11.
 */

public class BroadCastTestActivity extends Activity implements View.OnClickListener{

    public static final String ACTION = "demo.huangli.mydemosnew.BroadCastTestActivity";

    public static final String TAG = "BroadCastTestActivity";

    private UrlSwitchReceiver urlSwitchReceiver ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcasttest);
        Log.i("BroadCastTestActivity","onCreate ");
        urlSwitchReceiver = new UrlSwitchReceiver();
        findViewById(R.id.btn_register).setOnClickListener(this);
        findViewById(R.id.btn_send).setOnClickListener(this);
        findViewById(R.id.btn_register_2).setOnClickListener(this);
        findViewById(R.id.btn_send_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                Log.i("BroadCastTestActivity","注册 ");
                registerReceiver(this);
                break;
            case R.id.btn_send:
                Intent intent = new Intent();
                intent.setAction(UrlSwitchReceiver.ACTION_SWITCH_ALL_URL_TO_TEST);
                sendBroadcast(intent);
                Log.i("BroadCastTestActivity","发送 action ");
                break;
            case R.id.btn_register_2:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_AD_URL_TO_TEST);
                registerReceiver(new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        String action2 = intent.getAction();
                        Log.i("BroadCastTestActivity","收到 "+action2);
                    }
                },intentFilter);
                Log.i("BroadCastTestActivity","注册 action 2");
                break;
            case R.id.btn_send_2:
                Intent intent2 = new Intent();
                intent2.setAction("mobi.supo.battery.ACTION_SWITCH_AD_URL_TO_TEST");
                sendBroadcast(intent2);
                Log.i("BroadCastTestActivity","发送 action 2");
                break;
        }
    }

    private static class UrlSwitchReceiver extends BroadcastReceiver{

        public static final String ACTION_SWITCH_AD_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_AD_URL_TO_TEST";
        public static final String ACTION_SWITCH_AIO_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_AIO_URL_TO_TEST";
        public static final String ACTION_SWITCH_UPDATE_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_UPDATE_URL_TO_TEST";
        public static final String ACTION_SWITCH_PROMOTE_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_PROMOTE_URL_TO_TEST";
        public static final String ACTION_SWITCH_ANALYTICS_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_ANALYTICS_URL_TO_TEST";
        public static final String ACTION_SWITCH_GET_CONFIG_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_GET_CONFIG_URL_TO_TEST";
        public static final String ACTION_SWITCH_ALL_URL_TO_TEST = "mobi.supo.battery.ACTION_SWITCH_ALL_URL_TO_TEST";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.i(TAG,"收到 广播 action = "+action);
            if (ACTION_SWITCH_AD_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 广告切换到测试地址");
            }else if (ACTION_SWITCH_AIO_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 4大sdk切换到测试地址");
            }else if (ACTION_SWITCH_UPDATE_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 更新切换到测试地址");
            }else if (ACTION_SWITCH_PROMOTE_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 更新切换到测试地址");
            }else if (ACTION_SWITCH_ANALYTICS_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 统计切换到测试地址");
            }else if (ACTION_SWITCH_GET_CONFIG_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 获取配置切换到测试地址");
            }else if(ACTION_SWITCH_ALL_URL_TO_TEST.equals(action)){
                Log.i(TAG,"收到 广播 所有地址切换到测试地址");
            }
            System.exit(0);
        }
    }


    public  void unRegisterReceiver(Context context){
        if (urlSwitchReceiver != null){
            context.unregisterReceiver(urlSwitchReceiver);
        }
    }

    public  void registerReceiver(Context context){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_AD_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_AIO_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_UPDATE_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_PROMOTE_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_ANALYTICS_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_GET_CONFIG_URL_TO_TEST);
        intentFilter.addAction(UrlSwitchReceiver.ACTION_SWITCH_ALL_URL_TO_TEST);
        context.registerReceiver(urlSwitchReceiver,intentFilter);

    }

}
