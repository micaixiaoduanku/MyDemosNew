package demo.huangli.mydemosnew.logic_set_1.activityrelationshipfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huangli on 16/12/21.
 */

public class MyFragment extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LIFECYCLE","MyFragment onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("LIFECYCLE","MyFragment onCreateView()");
        super.onCreateView(inflater, container, savedInstanceState);
        TextView textView = new TextView(getActivity());
        textView.setText("我是一个测试Fragment");
        return textView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LIFECYCLE","MyFragment onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LIFECYCLE","MyFragment onPause()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LIFECYCLE","MyFragment onStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("LIFECYCLE","MyFragment onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("LIFECYCLE","MyFragment onDestroyView()");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("LIFECYCLE","MyFragment onViewCreated()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LIFECYCLE","MyFragment onDestroy()");
    }

}
