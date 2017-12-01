package demo.huangli.mydemosnew.logic_set_1;

import demo.huangli.mydemosnew.BaseListActivity;
import demo.huangli.mydemosnew.logic_set_1.accessibility.MyAccessibilityActivity;
import demo.huangli.mydemosnew.logic_set_1.activityrelationshipfragment.FragmentRelationShipActivity;
import demo.huangli.mydemosnew.logic_set_1.alarmmanager.AlarmManagerTestActivity;
import demo.huangli.mydemosnew.logic_set_1.algorithm.AlgorithmActivity;
import demo.huangli.mydemosnew.logic_set_1.annotation.AnnotationActivity;
import demo.huangli.mydemosnew.logic_set_1.balancedtree.BalanceTreeActivity;
import demo.huangli.mydemosnew.logic_set_1.batteryinfo.BatteryInfoActivity;
import demo.huangli.mydemosnew.logic_set_1.broadcast.BroadCastTestActivity;
import demo.huangli.mydemosnew.logic_set_1.createshortcut.CreateHideShortCutActivity;
import demo.huangli.mydemosnew.logic_set_1.cryptor.JNCryptorActivity;
import demo.huangli.mydemosnew.logic_set_1.db.DbTestActivity;
import demo.huangli.mydemosnew.logic_set_1.greendao.GreenDaoActivity;
import demo.huangli.mydemosnew.logic_set_1.keepalive.KeepAliveActivity;
import demo.huangli.mydemosnew.logic_set_1.mvpdemo.MvpDemoActivity;
import demo.huangli.mydemosnew.logic_set_1.networkstate.NetWorkStateActivity;
import demo.huangli.mydemosnew.logic_set_1.notiservice.NotiAggregationActivity;
import demo.huangli.mydemosnew.logic_set_1.okhttp.OkHttpActivity;
import demo.huangli.mydemosnew.logic_set_1.parentchildtest.ParentChildTestActivity;
import demo.huangli.mydemosnew.logic_set_1.permissions6dot0.DialogPermissionActivity;
import demo.huangli.mydemosnew.logic_set_1.permissions6dot0.PermissionsActivity;
import demo.huangli.mydemosnew.logic_set_1.phoneboost.PhoneBoostActivity;
import demo.huangli.mydemosnew.logic_set_1.proxy.ProxyActivity;
import demo.huangli.mydemosnew.logic_set_1.retrofit.RetrofitActivity;
import demo.huangli.mydemosnew.logic_set_1.strictmode.StrictModeActivity;
import demo.huangli.mydemosnew.logic_set_1.threadstop.ThreadStopActivity;
import demo.huangli.mydemosnew.logic_set_1.volley.VolleyActivity;

/**
 * Created by huangli on 16/9/7.
 */
public class EntranceLogicSet1Activity extends BaseListActivity {
    @Override
    public void initItems() {
        addListviewItem("Volley演示", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(VolleyActivity.class);
            }
        });
        addListviewItem("KeepALive", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(KeepAliveActivity.class);
            }
        });
        addListviewItem("GreenDao 案例", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(GreenDaoActivity.class);
            }
        });
        addListviewItem("数据库Demo", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(DbTestActivity.class);
            }
        });
        addListviewItem("电池信息获取", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BatteryInfoActivity.class);
            }
        });
        addListviewItem("权限获取", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(PermissionsActivity.class);
            }
        });
        addListviewItem("6.0全局弹窗权限获取", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(DialogPermissionActivity.class);
            }
        });
        addListviewItem("Accessibility Service测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(MyAccessibilityActivity.class);
            }
        });
        addListviewItem("BroadCast测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BroadCastTestActivity.class);
            }
        });
        addListviewItem("StrictMode 测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(StrictModeActivity.class);
            }
        });
        addListviewItem("父类子类调用测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ParentChildTestActivity.class);
            }
        });
        addListviewItem("Activity和Fragment生命周期测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(FragmentRelationShipActivity.class);
            }
        });
        addListviewItem("NotificationListenerService使用", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(NotiAggregationActivity.class);
            }
        });
        addListviewItem("手机加速测试和自启动管理", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(PhoneBoostActivity.class);
            }
        });
        addListviewItem("RxJava测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
//                intentActivity(RxJavaTestActivity.class);
            }
        });
        addListviewItem("RxJava2测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
//                intentActivity(RxJava2TestActivity.class);
            }
        });
        addListviewItem("创建快捷方式", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(CreateHideShortCutActivity.class);
            }
        });
        addListviewItem("AlarmManager测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(AlarmManagerTestActivity.class);
            }
        });
        addListviewItem("OKHttp", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(OkHttpActivity.class);
            }
        });
        addListviewItem("Retrofit使用", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(RetrofitActivity.class);
            }
        });
        addListviewItem("文件加密解密", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(JNCryptorActivity.class);
            }
        });
        addListviewItem("MvpDemo运行", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(MvpDemoActivity.class);
            }
        });
        addListviewItem("网络状态获取", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(NetWorkStateActivity.class);
            }
        });
        addListviewItem("线程终止Demo", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ThreadStopActivity.class);
            }
        });
        addListviewItem("注解Demo", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(AnnotationActivity.class);
            }
        });
        addListviewItem("二叉树实现", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BalanceTreeActivity.class);
            }
        });
        addListviewItem("面试常考算法", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(AlgorithmActivity.class);
            }
        });
        addListviewItem("动态代理模式", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ProxyActivity.class);
            }
        });
    }
}
