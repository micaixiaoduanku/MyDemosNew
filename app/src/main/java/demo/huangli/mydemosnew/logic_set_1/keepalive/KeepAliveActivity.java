package demo.huangli.mydemosnew.logic_set_1.keepalive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/7.
 */
public class KeepAliveActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alive);
        findViewById(R.id.btn_run).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_run:
                startService(new Intent(this,AliveService.class));
                break;
        }
    }
}
