package demo.huangli.mydemosnew.logic_set_1.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/8/11.
 */

public class AlarmManagerTestActivity extends Activity implements View.OnClickListener{

    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
        findViewById(R.id.btn_run_alarm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_run_alarm:
                if (pendingIntent == null){
                    Intent startIntent = new Intent(this, TaskService.class);
                    pendingIntent = PendingIntent.getService(this, 0, startIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                }
                AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
                alarm.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 60 * 1000, 60 * 1000, pendingIntent);

                break;
        }
    }
}
