package demo.huangli.mydemosnew.ui_set_1.fragmentdynamic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/12/27.
 */

public class FragmentLoadActivity extends FragmentActivity{

    private LinearLayout linearLayout = null;

    private CardFragmentShowManager cardFragmentShowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_load);
        linearLayout = (LinearLayout)findViewById(R.id.fragment_contains);
        cardFragmentShowManager = new CardFragmentShowManager();
        CustomFragment customFragment1 = CustomFragment.newInstance();
        CustomFragment customFragment2 = CustomFragment.newInstance();
        CustomFragment customFragment3 = CustomFragment.newInstance();
        CustomFragment customFragment4 = CustomFragment.newInstance();
        List<Fragment> customFragments = new ArrayList<>();
        customFragments.add(customFragment1);
        customFragments.add(customFragment2);
        customFragments.add(customFragment3);
        customFragments.add(customFragment4);
        cardFragmentShowManager.showFragmentsInActivity(this,linearLayout,customFragments);
    }
}
