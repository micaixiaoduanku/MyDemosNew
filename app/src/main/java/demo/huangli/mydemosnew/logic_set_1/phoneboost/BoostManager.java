package demo.huangli.mydemosnew.logic_set_1.phoneboost;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by huangli on 17/2/3.
 */

public class BoostManager {

    public static long clearMemoryWay1(Context context){
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infoList = am.getRunningAppProcesses();
        List<ActivityManager.RunningServiceInfo> serviceInfos = am.getRunningServices(100);

        long beforeMem = getAvailMemory(context);
        int count = 0;

        if (infoList != null){
            for (int i = 0; i < infoList.size(); ++i){
                ActivityManager.RunningAppProcessInfo appProcessInfo = infoList.get(i);

                //一般大于RunningAppProcessInfo.IMPORTANCE_VISIBLE都是飞可见进程
                if (appProcessInfo.importance > ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE){
                    String[] pkgList = appProcessInfo.pkgList;
                    for (int j = 0; j < pkgList.length ; ++j){
                        am.killBackgroundProcesses(pkgList[j]);
                        count++;
                    }
                }
            }
        }

        long afterMem = getAvailMemory(context);
        Toast.makeText(context,"清理数量 "+count + " process, 清理内存 "+(afterMem - beforeMem)+"M",Toast.LENGTH_SHORT).show();
        return afterMem - beforeMem;
    }


    public static long clearMemoryWay2(Context context){
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infoList = am.getRunningAppProcesses();

        long beforeMem = getAvailMemory(context);
        int count = 0;
        boolean iskill;
        if (infoList != null){
            for (int i = 0; i < infoList.size(); ++i){
                ActivityManager.RunningAppProcessInfo appProcessInfo = infoList.get(i);
                String[] pkgList = appProcessInfo.pkgList;
                iskill = true;
                for (int j = 0; j < pkgList.length ; ++j){
                    if (pkgList[j].equals(context.getPackageName())){
                        iskill = false;
                        break;
                    }
                }
                if (iskill){
                    Process.killProcess(appProcessInfo.pid);
                    count++;
                }
            }
        }

        long afterMem = getAvailMemory(context);
        Toast.makeText(context,"清理数量 "+count + " process, 清理内存 "+(afterMem - beforeMem)+"M",Toast.LENGTH_SHORT).show();
        return afterMem - beforeMem;
    }


    /**
     *
     * A.在使用forceStopPackage接口时需要声明FORCE_STOP_PACKAGES权限。
       B.forceStopPackage是一个隐藏接口，需要通过反射等手段实现调用。
       C.使用forceStopPackage接口需要系统签名.
       D.forceStopPackage接口除了可以用来杀死进程外，还可以达到禁止开机自启动和后台自启动的目的。
       E.在使用forceStopPackage接口时可能会有不想要发生的副作用（清空定时器等），慎重使用。
       F.Package的stopped状态是在Android4.0以后增加的，也就是说在2.3之前的版本forceStopPackage并不能禁用开机广播
     * @param context
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static long clearMemoryWay3(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infoList = am.getRunningAppProcesses();
        long beforeMem = getAvailMemory(context);
        int count = 0;

        if (infoList != null){
            for (int i = 0; i < infoList.size(); ++i){
                ActivityManager.RunningAppProcessInfo appProcessInfo = infoList.get(i);

                //一般大于RunningAppProcessInfo.IMPORTANCE_VISIBLE都是飞可见进程
                if (appProcessInfo.importance > ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE){
                    String[] pkgList = appProcessInfo.pkgList;
                    for (int j = 0; j < pkgList.length ; ++j){
                        Method method = Class.forName("android.app.ActivityManager").getMethod("forceStopPackage", String.class);
                        method.invoke(am, pkgList[j]);  //packageName是需要强制停止的应用程序包名
                        count++;
                    }
                }
            }
        }

        long afterMem = getAvailMemory(context);
        Toast.makeText(context,"清理数量 "+count + " process, 清理内存 "+(afterMem - beforeMem)+"M",Toast.LENGTH_SHORT).show();
        return afterMem - beforeMem;
    }

    private static long getAvailMemory(Context context){
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        am.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem/(1024*1024);
    }
}
