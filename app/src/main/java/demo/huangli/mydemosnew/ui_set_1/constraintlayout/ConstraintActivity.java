package demo.huangli.mydemosnew.ui_set_1.constraintlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/2/22.
 */

public class ConstraintActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Debug.startMethodTracing("ui_performance");
        setContentView(R.layout.activity_constraint);
        Debug.stopMethodTracing();
    }
}
