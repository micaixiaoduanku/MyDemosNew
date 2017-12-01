package demo.huangli.mydemosnew.ui_set_1.swiperefreshlayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/4/27.
 */

public class SwipeRefreshLayoutActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshView swipeLayout;
    private ListView listView;
    private List<String> datas;
    private MyAdpter myAdpter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh);
        datas = new ArrayList<>();
        initdata();
        swipeLayout = (SwipeRefreshView) findViewById(R.id.swipe_container);
        listView = (ListView)findViewById(R.id.listview);
        myAdpter = new MyAdpter(this);
        listView.setAdapter(myAdpter);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light));
        swipeLayout.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
            @Override
            public void onLoad() {
                datas.add("下拉加载");
                swipeLayout.setLoading(false);
            }
        });
    }

    private void initdata(){
        for (int i = 0 ;i < 200; i++){
            datas.add("测试 "+i);
        }
    }

    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                datas.add(0,"上拉刷新");
                myAdpter.notifyDataSetChanged();
                swipeLayout.setRefreshing(false);
            }
        }, 5000);
    }

    private class MyAdpter extends BaseAdapter{

        private Context mContext;

        public MyAdpter(Context context) {
            super();
            mContext = context;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(mContext);
            tv.setText(datas.get(position));
            return tv;
        }
    }
}
