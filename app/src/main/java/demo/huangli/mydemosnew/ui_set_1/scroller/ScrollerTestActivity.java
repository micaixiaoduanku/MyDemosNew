package demo.huangli.mydemosnew.ui_set_1.scroller;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/5/9.
 */

public class ScrollerTestActivity extends Activity{

    private ScrollerViewGroup scrollerViewGroup;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_test);
        scrollerViewGroup = (ScrollerViewGroup)findViewById(R.id.view_scroller_view);
        btn = (Button)findViewById(R.id.btn_move);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollerViewGroup.smoothScrollTo(-100);
            }
        });
    }
}
