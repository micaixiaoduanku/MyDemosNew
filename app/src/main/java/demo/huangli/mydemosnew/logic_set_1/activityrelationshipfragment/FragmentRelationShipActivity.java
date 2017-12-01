package demo.huangli.mydemosnew.logic_set_1.activityrelationshipfragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/12/21.
 */

public class FragmentRelationShipActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity);
        findViewById(R.id.btn_finish).setOnClickListener(this);
        Log.i("LIFECYCLE","FragmentRelationShipActivity onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFECYCLE","FragmentRelationShipActivity onResume()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE","FragmentRelationShipActivity onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFECYCLE","FragmentRelationShipActivity onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFECYCLE","FragmentRelationShipActivity onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFECYCLE","FragmentRelationShipActivity onStop()");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_finish){
            finish();
        }
    }
}
