package demo.huangli.mydemosnew;

import android.content.pm.PackageManager;
import android.os.Bundle;

import demo.huangli.mydemosnew.bug_set_1.EntranceBugSet1Activity;
import demo.huangli.mydemosnew.logic_set_1.EntranceLogicSet1Activity;
import demo.huangli.mydemosnew.ui_set_1.EntranceUISet1Activity;

public class MainActivity extends BaseListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER, PackageManager.DONT_KILL_APP);
    }

    @Override
    public void initItems() {
        addListviewItem("Bug集合一", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(EntranceBugSet1Activity.class);
            }
        });
        addListviewItem("UI集合一", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(EntranceUISet1Activity.class);
            }
        });
        addListviewItem("Logic集合一", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(EntranceLogicSet1Activity.class);
            }
        });
    }

}
