package li.huang.rxjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import li.huang.rxjava.helper.RxJavaHelper;
import li.huang.rxjava.helper.RxJavaMapHelper;
import li.huang.rxjava.helper.RxJavaScheduler;
import li.huang.rxjava.scene_retrofit.RetrofitHelper;
import li.huang.rxjava.scene_rxbinding.RxBindingHelper;
import li.huang.rxjava.scene_rxbus.RxBusActivity;

/**
 * Created by huangli on 17/2/23.
 */

public class RxJavaTestActivity extends Activity implements View.OnClickListener{

    private RxJavaHelper rxJavaHelper = new RxJavaHelper();
    private RxJavaScheduler rxJavaScheduler = new RxJavaScheduler();
    private RxJavaMapHelper rxJavaMapHelper = new RxJavaMapHelper();
    private RetrofitHelper retrofitHelper = new RetrofitHelper();
    private RxBindingHelper rxBindingHelper = new RxBindingHelper();

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        findViews();

    }

    private void findViews(){
        findViewById(R.id.btn_rx_java_basic).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_basic_demo).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_scheduler_demo).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_map).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_flat_map).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_multiple_map).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_do_on_subscribe).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_retrofit).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_rxbinding).setOnClickListener(this);
        findViewById(R.id.btn_rx_java_rxbus).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.image_demo);

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_rx_java_basic) {
            rxJavaHelper.basicRxJava();
        }else if (i == R.id.btn_rx_java_basic_demo){
            rxJavaHelper.rxJavaBasicDemo(this,imageView);
        }else if (i == R.id.btn_rx_java_scheduler_demo){
            rxJavaScheduler.rxJavaSchedulerDemo(this,imageView);
        }else if (i == R.id.btn_rx_java_map){
            rxJavaMapHelper.mapDemo(this,imageView);
        }else if (i == R.id.btn_rx_java_flat_map){
            rxJavaMapHelper.flatMapDemo();
        }else if (i == R.id.btn_rx_java_multiple_map){
            rxJavaMapHelper.multipleMapDemo();
        }else if (i == R.id.btn_rx_java_do_on_subscribe){
            rxJavaMapHelper.doOnSubscribe();
        }else if (i == R.id.btn_rx_java_retrofit){
            retrofitHelper.requestGet();
            retrofitHelper.requestPost();
        }else if (i == R.id.btn_rx_java_rxbinding){
            rxBindingHelper.bindView((Button) findViewById(R.id.btn_rx_java_rxbinding));
        }else if (i == R.id.btn_rx_java_rxbus){
            Intent intent = new Intent(this, RxBusActivity.class);
            startActivity(intent);
        }
    }
}
