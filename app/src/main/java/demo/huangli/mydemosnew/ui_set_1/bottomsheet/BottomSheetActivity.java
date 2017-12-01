package demo.huangli.mydemosnew.ui_set_1.bottomsheet;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.Button;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/8/14.
 */

public class BottomSheetActivity extends Activity{

    private Button mShowBottomSheet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        //获取到Bottom Sheet对象
        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        mShowBottomSheet = (Button) findViewById(R.id.button);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });
    }


    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mShowBottomSheet.setText("隐藏");
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            mShowBottomSheet.setText("展示");
        }
    }

}
