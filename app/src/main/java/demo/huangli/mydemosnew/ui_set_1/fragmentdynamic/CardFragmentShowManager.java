package demo.huangli.mydemosnew.ui_set_1.fragmentdynamic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by huangli on 16/12/27.
 */

public class CardFragmentShowManager {

    public static String TAG = "CardFragmentShowManager";

    private static int CONTENT_VIEW_ID = 10101010;

    private LinearLayout linearLayout;

    public CardFragmentShowManager() {

    }

    public void showFragmentsInActivity(FragmentActivity fragmentActivity, LinearLayout linearLayout, List<Fragment> cardFragments){
        for (Fragment cardFragment : cardFragments){
            FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
            FrameLayout frame = new FrameLayout(fragmentActivity);
            int frameId = CONTENT_VIEW_ID++;
            frame.setId(frameId);
            ft.add(frameId, cardFragment).commitAllowingStateLoss();
            linearLayout.addView(frame);
        }
    }

    public void showFragmentsInFragment(Fragment fragment, LinearLayout linearLayout, List<Fragment> cardFragments){
        for (Fragment cardFragment : cardFragments){
            FragmentTransaction ft = fragment.getChildFragmentManager().beginTransaction();
            FrameLayout frame = new FrameLayout(fragment.getActivity());
            int frameId = CONTENT_VIEW_ID++;
            frame.setId(frameId);
            ft.add(frameId, cardFragment).commitAllowingStateLoss();
            linearLayout.addView(frame);
        }
    }

}
