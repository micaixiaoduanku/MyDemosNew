package demo.huangli.mydemosnew.logic_set_1.notiservice;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/1/23.
 */

public class NotiAggregationActivity extends Activity implements View.OnClickListener{

    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String ACTION_NOTIFICATION_LISTENER_SETTINGS = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti_aggregation);
        findViewById(R.id.btn_noti_access).setOnClickListener(this);
        findViewById(R.id.btn_open_noti_access).setOnClickListener(this);
        findViewById(R.id.btn_create_noti).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_noti_access:
                if (isEnabled()){
                    Toast.makeText(this,"通知访问权限已经打开",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"通知访问权限还没有打开",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_open_noti_access:
                if (!isEnabled()){
                    openNotificationAccess();
                }else {
                    Toast.makeText(this,"通知访问权限已经打开",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_create_noti:
                createNoti();
                break;
        }
    }

    private void createNoti(){
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("Basic Notification");
        builder.setContentText("I am a basic notification");
        builder.setSubText("it is really basic");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());
    }

    private void bindService(){
        bindService(new Intent(this, NotificationMonitor.class), new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                NotificationMonitor.MyBinder localBinder = (NotificationMonitor.MyBinder)service;
                NotificationMonitor mMonitor = localBinder.getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        },BIND_AUTO_CREATE);
    }

    /**
     * 判断是否有通知访问权限
     * 使用NotificationListenerService的应用如果开启了Notification access，
     * 系统会将包名等相关信息写入SettingsProver数据库中，
     * 因此可以从数据库中获取相关信息并过滤，从而判断应用是否开启了Notification access
     * @return
     */
    private boolean isEnabled() {
        String pkgName = getPackageName();
        final String flat = Settings.Secure.getString(getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 主动跳转到Notification access监听页面
     */
    private void openNotificationAccess() {
        startActivity(new Intent(ACTION_NOTIFICATION_LISTENER_SETTINGS));
    }
}
