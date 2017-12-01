package demo.huangli.mydemosnew.ui_set_1.fragmentdynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/12/27.
 */

public class CustomFragment extends Fragment{

    public static CustomFragment newInstance() {
        CustomFragment fragment = new CustomFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, container, false);
        return view;
    }
}
