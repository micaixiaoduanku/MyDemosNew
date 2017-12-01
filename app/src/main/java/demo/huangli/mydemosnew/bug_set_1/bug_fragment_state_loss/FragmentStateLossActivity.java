package demo.huangli.mydemosnew.bug_set_1.bug_fragment_state_loss;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;

import demo.huangli.mydemosnew.BaseActivity;
import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/5.
 * 问题描述:有时候我们异步加载fragment的时候可能会抛出IllegalStateException异常
 * 问题原因:因为android不允许在onSaveInstanceState(Bundle)之后去进行commit操作,因为这样会导致state丢失,所以采取抛出异常来防止此类操作,在android 3.0之前onSaveInstanceState会在
 * onpause之前调用,在android 3.0之后onSaveInstanceState会在onstop之前调用,如果在android 3.0之前commit操作在onpause之前是相当容易的导致这种问题的,Android官方团队就忽略support
 * 包在android 3.0之前commit操作抛出的异常,那么最后的结论是,如果在onstop之后去commit都会抛出此类异常.
 *
 * 如何避免这类错误:
 * 1,保证commit在onCreate()或者FragmentActivity#onResumeFragments()或者Activity#onPostResume()中调用
 * 2,避免在异步方法中调用
 * 3,可以用commitAllowingStateLoss()忽略该类错误
 * http://www.androiddesignpatterns.com/2013/08/fragment-transaction-commit-state-loss.html
 */

/**
 * 该demo重现抛出该异常的操作
 */
public class FragmentStateLossActivity extends BaseActivity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_loss);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                LossStateFragment fragment = new LossStateFragment();
                ft.add(R.id.layout_fragment, fragment);
                ft.commit();
            }
        },3000);
    }
}
