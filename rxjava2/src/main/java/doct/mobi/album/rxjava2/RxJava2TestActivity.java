package doct.mobi.album.rxjava2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import doct.mobi.album.rxjava2.helper.RxJavaBasicHelper;
import li.huang.rxjava.R;

/**
 * Created by huangli on 17/10/5.
 */

public class RxJava2TestActivity extends Activity implements View.OnClickListener{

    private RxJavaBasicHelper rxJavaBasicHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava2_test);
        findViewById(R.id.btn_rxjava_basic).setOnClickListener(this);
        rxJavaBasicHelper = new RxJavaBasicHelper();
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_rxjava_basic) {
        }
    }
}
