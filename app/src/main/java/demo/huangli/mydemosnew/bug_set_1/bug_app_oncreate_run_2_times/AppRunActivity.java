package demo.huangli.mydemosnew.bug_set_1.bug_app_oncreate_run_2_times;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import demo.huangli.mydemosnew.BaseActivity;
import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/6.
 */
public class AppRunActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_app);
        findViewById(R.id.run_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.run_btn:
                Intent s = new Intent(this,BgService.class);
                startService(s);
                break;
        }
    }
}
