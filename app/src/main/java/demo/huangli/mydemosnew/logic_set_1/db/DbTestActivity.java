package demo.huangli.mydemosnew.logic_set_1.db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/14.
 */
public class DbTestActivity extends Activity implements View.OnClickListener{

    public static String TAG = "DbTestActivity";

    private FeedReaderDbProxy feedReaderDbProxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_test);
        findViewById(R.id.btn_put_info).setOnClickListener(this);
        findViewById(R.id.btn_read_info).setOnClickListener(this);
        findViewById(R.id.btn_delete_info).setOnClickListener(this);
        findViewById(R.id.btn_update_info).setOnClickListener(this);
        feedReaderDbProxy = new FeedReaderDbProxy(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_put_info:
                //TODO implement
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("1","11"));
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("2","22"));
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("3","33"));
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("4","44"));
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("5","55"));
                feedReaderDbProxy.insertEntry(new FeedReaderDbItem("6","66"));
                break;
            case R.id.btn_read_info:
                List<FeedReaderDbItem> list = feedReaderDbProxy.query("1");
                for (FeedReaderDbItem feedReaderDbItem : list){
                    Log.i(TAG,feedReaderDbItem.getTitle()+" "+feedReaderDbItem.getSubtitle());
                }
                //TODO implement
                break;
            case R.id.btn_delete_info:
                //TODO implement
                break;
            case R.id.btn_update_info:
                //TODO implement
                break;
        }
    }
}
