package demo.huangli.mydemosnew.logic_set_1.alarmmanager;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by huangli on 17/8/11.
 */

public class TaskService extends IntentService {

    public static String TAG = "TaskService";

    public TaskService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG," onHandleIntent ");
    }
}
