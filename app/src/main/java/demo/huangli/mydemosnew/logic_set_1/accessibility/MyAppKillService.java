package demo.huangli.mydemosnew.logic_set_1.accessibility;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;

import java.util.List;

/**
 * Created by huangli on 16/11/2.
 */

public class MyAppKillService extends AccessibilityService {

    public final static String TAG = "MyAppKillService";

    private static final String forceBtnResId = "com.android.settings:id/force_stop_button";

    private boolean api18;
    private static final String[] b = new String[0];
    private static volatile boolean mEnabled = true;

    @Override
    public void onCreate() {
        super.onCreate();
        AccessibilityServiceInfo accessibilityServiceInfo = getServiceInfo();
    }

    @TargetApi(value = 18)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.i(TAG,"收到 accessibility event");
        Log.i(TAG,"event 包名 "+event.getPackageName());
        Log.i(TAG,"event 类名 "+event.getClassName());
        int weight;
        AccessibilityNodeInfo accessibilityNodeInfo = event.getSource();
        if (accessibilityNodeInfo != null && event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            CharSequence packageName = event.getPackageName();
            if (packageName == null){
                return;
            }
            if (!packageName.equals("com.android.settings") && !packageName.equals(getPackageName())) {
                Log.d(TAG, "State: packageName!=settings package: " + event.getPackageName());
                return;
            }
            CharSequence eventClassName = event.getClassName();
            if (eventClassName != null) {
                String eventClassName_str = eventClassName.toString();
                if (!eventClassName_str.endsWith("InstalledAppDetailsTop") && !"com.android.settings.applications.InstalledAppDetailsActivity"
                        .equals(eventClassName_str)) {
                    if (eventClassName_str.endsWith("AlertDialog")) {
                        //弹出是否强制停止对话框
                        weight = this.closeApp18plus(accessibilityNodeInfo, b);
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i(TAG,"AccessibilityService 连接成功");
    }

    @TargetApi(value = 18)
    private int closeApp18plus(AccessibilityNodeInfo arg4, String[] arg5) {
        int v1;
        if (!this.api18) {
            v1 = -4;
            return v1;
        }

        v1 = -3;
        int i = 0;
        while (i < arg5.length) {
            v1 = Math.max(v1, this.clickButton(arg4.findAccessibilityNodeInfosByViewId(arg5[i])));
            if (v1 == 1) {
                return v1;
            }

            i++;
        }

        return v1;
    }

    @TargetApi(16)
    private int clickButton(List NodeInfoList) {
        int ret = 0;
        int v0 = -3;
        if (NodeInfoList == null || (NodeInfoList.isEmpty())) {
            ret = v0;
        } else {
            int index = 0;
            int v3 = v0;
            while (index < NodeInfoList.size()) {
                AccessibilityNodeInfo node = (AccessibilityNodeInfo) NodeInfoList.get(index);
                if (node != null) {
                    if (node.getClassName().equals(TextView.class.getName()) && node.getParent() != null) {
                        node = node.getParent();
                    }
                    if (!node.isEnabled()) {
                        v3 = Math.max(v3, -2);
                    } else if (mEnabled) {
                        int v4 = node.performAction(AccessibilityNodeInfo.ACTION_CLICK) ? 1 : -1;
                        v3 = Math.max(v3, v4);
                        node.recycle();
                    } else {
                        return ret;
                    }
                }

                ++index;
            }

            ret = v3;
        }

        return ret;
    }
}
