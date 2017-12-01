package demo.huangli.mydemosnew.bug_set_1.no_main_process_invoke_getapplicationcontext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import demo.huangli.mydemosnew.R;

public class NoMainProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_main_process);
        Log.i("pid","pid "+android.os.Process.myPid());
        startService(new Intent(this,NoMainProcessService.class));
    }
}
