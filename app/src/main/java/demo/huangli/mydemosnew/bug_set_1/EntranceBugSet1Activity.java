package demo.huangli.mydemosnew.bug_set_1;

import android.os.Bundle;

import demo.huangli.mydemosnew.BaseListActivity;
import demo.huangli.mydemosnew.bug_set_1.bug_app_oncreate_run_2_times.AppRunActivity;
import demo.huangli.mydemosnew.bug_set_1.bug_date_format.BugDateFormatActivity;
import demo.huangli.mydemosnew.bug_set_1.bug_fragment_state_loss.FragmentStateLossActivity;
import demo.huangli.mydemosnew.bug_set_1.bug_out_of_mem.OutOfMemActivity;
import demo.huangli.mydemosnew.bug_set_1.no_main_process_invoke_getapplicationcontext.NoMainProcessActivity;

/**
 * Created by huangli on 16/9/5.
 */
public class EntranceBugSet1Activity extends BaseListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initItems() {
        addListviewItem("Fragment Transactions & Activity State Loss", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(FragmentStateLossActivity.class);
            }
        });
        addListviewItem("多进程中重写Appliction Oncreate运行2次,如何避免?", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(AppRunActivity.class);
            }
        });
        addListviewItem("非主进程service调用getApplicationContext() == null", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(NoMainProcessActivity.class);
            }
        });
        addListviewItem("时间格式错误", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BugDateFormatActivity.class);
            }
        });
        addListviewItem("匿名内部类导致内存溢出", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(OutOfMemActivity.class);
            }
        });
    }
}
