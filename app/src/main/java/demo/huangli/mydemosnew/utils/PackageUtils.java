package demo.huangli.mydemosnew.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by Steve Yang on 2016/6/6.
 */
public class PackageUtils {
    public static String getProcessNameByPID(Context context, int pid){
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfos = manager.getRunningAppProcesses();
        //android 5.0 killed this way
        if (runningAppProcessInfos != null){
            for(ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()){
                if(processInfo.pid == pid){
                    return processInfo.processName;
                }
            }
        }
        return "";
    }
}
