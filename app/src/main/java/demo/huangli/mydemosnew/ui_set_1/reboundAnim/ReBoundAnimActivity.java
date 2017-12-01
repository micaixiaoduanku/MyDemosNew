package demo.huangli.mydemosnew.ui_set_1.reboundAnim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/2/23.
 */

public class ReBoundAnimActivity extends Activity{

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebound);
        btn = (Button)findViewById(R.id.btn_test_get);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSpringAnim();
            }
        });
    }

    private void playSpringAnim(){
        SpringSystem springSystem = SpringSystem.create();
        Spring spring = springSystem.createSpring();
        spring.addListener(new SimpleSpringListener() {

            @Override
            public void onSpringUpdate(Spring spring) {
                // You can observe the updates in the spring
                // state by asking its current value in onSpringUpdate.
                float value = (float) spring.getCurrentValue();
                float scale = 1f - (value * 0.5f);
                btn.setScaleX(scale);
                btn.setScaleY(scale);
            }
        });

        spring.setEndValue(1);
    }
}
