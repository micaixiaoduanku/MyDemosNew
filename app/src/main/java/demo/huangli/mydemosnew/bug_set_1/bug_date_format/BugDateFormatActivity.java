package demo.huangli.mydemosnew.bug_set_1.bug_date_format;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.text.SimpleDateFormat;

import demo.huangli.mydemosnew.BaseActivity;
import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/9/25.
 */

public class BugDateFormatActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_date_format);
        test();
    }

    private void test(){
        long time = DateUtil.fromateDateStringToLong("2017.06", new SimpleDateFormat("yyyy.MM"));
        Log.i("tag","time "+time);
        time = DateUtil.fromateDateStringToLong("1917.06", new SimpleDateFormat("yyyy.MM"));
        Log.i("tag","time "+time);
        time = DateUtil.fromateDateStringToLong("1817.06", new SimpleDateFormat("yyyy.MM"));
        Log.i("tag","time "+time);
        time = DateUtil.fromateDateStringToLong("33", new SimpleDateFormat("yyyy.MM"));
        Log.i("tag","time "+time);
    }
}
