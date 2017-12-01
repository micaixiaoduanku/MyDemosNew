package demo.huangli.mydemosnew.utils;


import android.util.Log;

/**
 * Created by huangli on 16/8/24.
 */
public class TimeDebugUtils {

    public static String TAG = "TimeDebugUtils";

    public static class UiThread{
        public static long time = 0;
        public static void labelCurTime(){
            time = System.currentTimeMillis();
        }

        public static long logConsTime(){
            long cons = System.currentTimeMillis() - time;
            Log.i(TAG,"耗时 "+cons +" 毫秒");
            return cons;
        }

        public static long logConsTime(String tag,String info){
            long cons = System.currentTimeMillis() - time;
            Log.i(tag,info+" 耗时 "+cons +" 毫秒");
            return cons;
        }
    }

    public static class NoUiThread{
        public static long time = 0;
        public static void labelCurTime(){
            time = System.currentTimeMillis();
        }
        public static long logConsTime(){
            long cons = System.currentTimeMillis() - time;
            Log.i(TAG,"耗时 "+cons +" 毫秒");
            return cons;
        }

        public static long logConsTime(String tag){
            long cons = System.currentTimeMillis() - time;
            Log.i(tag,"耗时 "+cons +" 毫秒");
            return cons;
        }
    }
}
