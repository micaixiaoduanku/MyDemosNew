package demo.huangli.mydemosnew.logic_set_1.notiservice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangli on 17/1/22.
 */

@SuppressLint("OverrideAbstract")
@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class NotificationMonitor extends NotificationListenerService {

    public static final String TAG = "NotificationMonitor";

    //用于存储当前所有的Notification的StatusBarNotification对象数组
    public static List<StatusBarNotification[]> mCurrentNotifications = new ArrayList<StatusBarNotification[]>();
    public static int mCurrentNotificationsCounts = 0;

    private MyBinder mBinder = new MyBinder();

    public class MyBinder extends Binder {
        public NotificationMonitor getService(){
            return NotificationMonitor.this;
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        /**
         * 这里注意，一般情况下service的onBind方法返回要么是null要么是Binder对象，
         * 可这里直接调用父类NotificationListenerService的onBind方法，
         * 而父类返回的是INotificationListenerWrapper的对象。
         * 这说明Binder对象已经被指定了，不能再给NotificationMonitor指定其它的Binder对象。
         * 如果你非要给NotificationMonitor指定其它的Binder对象，那么就无法使用INotificationListenerWrapper提供的方法。
         * 也就是说要么就用系统NotificationListenerService提供的方法，要么就把NotificationMonitor当一个普通的Service来用，系统提供的方法都不能使用。
         */
        return mBinder;
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        Log.i(TAG,"onNotificationPosted()");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        Log.i(TAG,"onNotificationRemoved()");
    }
}
