package demo.huangli.mydemosnew.ui_set_1;

import demo.huangli.mydemosnew.BaseListActivity;
import demo.huangli.mydemosnew.logic_set_1.gsonandjson.GsonJsonActivity;
import demo.huangli.mydemosnew.ui_set_1.appicon.AppIconActivity;
import demo.huangli.mydemosnew.ui_set_1.arabiauifit.ArabiaufitActivity;
import demo.huangli.mydemosnew.ui_set_1.bitmaprecycle.BitmapRecycleActivity;
import demo.huangli.mydemosnew.ui_set_1.bottomsheet.BottomSheetActivity;
import demo.huangli.mydemosnew.ui_set_1.circularimage.CircularActivity;
import demo.huangli.mydemosnew.ui_set_1.constraintlayout.ConstraintActivity;
import demo.huangli.mydemosnew.ui_set_1.fragmentdynamic.FragmentLoadActivity;
import demo.huangli.mydemosnew.ui_set_1.gesturedetector.GestureActivity;
import demo.huangli.mydemosnew.ui_set_1.gif.GifActivity;
import demo.huangli.mydemosnew.ui_set_1.glide.GlideActivity;
import demo.huangli.mydemosnew.ui_set_1.gradientimage.ImageGradientActivity;
import demo.huangli.mydemosnew.ui_set_1.immersingstatusbar.ImmersingStatusBarActivity;
import demo.huangli.mydemosnew.ui_set_1.meminfo.MemInfoActivity;
import demo.huangli.mydemosnew.ui_set_1.reboundAnim.ReBoundAnimActivity;
import demo.huangli.mydemosnew.ui_set_1.recyclerview.RecyclerViewActivity;
import demo.huangli.mydemosnew.ui_set_1.scroller.ScrollerTestActivity;
import demo.huangli.mydemosnew.ui_set_1.spannablestring.SpannableStringActivity;
import demo.huangli.mydemosnew.ui_set_1.swiperefreshlayout.SwipeRefreshLayoutActivity;
import demo.huangli.mydemosnew.ui_set_1.translucent.ColorTranslucentBarActivity;
import demo.huangli.mydemosnew.ui_set_1.translucent.ImageTranslucentBarActivity;
import demo.huangli.mydemosnew.ui_set_1.viewflipper.ViewFlipperActivity;
import demo.huangli.mydemosnew.ui_set_1.viewgroup.CustomViewGroupActivity;
import li.huang.poptextscreen.PopScreenModule;

/**
 * Created by huangli on 16/9/6.
 */
public class EntranceUISet1Activity extends BaseListActivity {
    @Override
    public void initItems() {
        addListviewItem("Gif动画播放", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(GifActivity.class);
            }
        });
        addListviewItem("原型头像", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(CircularActivity.class);
            }
        });
        addListviewItem("内存计算", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(MemInfoActivity.class);
            }
        });
        addListviewItem("一个字符串大小颜色不同", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(SpannableStringActivity.class);
            }
        });
        addListviewItem("RecyclerView的运用", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(RecyclerViewActivity.class);
            }
        });
        addListviewItem("阿拉伯语言测试(阿拉伯语言从右到左排序)", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ArabiaufitActivity.class);
            }
        });
        addListviewItem("通过包名获取应用图标", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(AppIconActivity.class);
            }
        });
        addListviewItem("沉浸式状态栏 实现方式一", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ImageTranslucentBarActivity.class);
            }
        });
        addListviewItem("沉浸式状态栏 实现方式二", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ColorTranslucentBarActivity.class);
            }
        });
        addListviewItem("Fragment 动态加载", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(FragmentLoadActivity.class);
            }
        });
        addListviewItem("BiliBili 弹幕", new ItemClickListener() {
            @Override
            public void itemClicked() {
                PopScreenModule.startScreenModule(EntranceUISet1Activity.this);
            }
        });
        addListviewItem("Gson和Json的互转", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(GsonJsonActivity.class);
            }
        });
        addListviewItem("Constraint Layout测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ConstraintActivity.class);
            }
        });
        addListviewItem("Facebook rebound 动画测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ReBoundAnimActivity.class);
            }
        });
        addListviewItem("自定义ViewGroup ", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(CustomViewGroupActivity.class);
            }
        });
        addListviewItem("SwipeRefreshLayout", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(SwipeRefreshLayoutActivity.class);
            }
        });
        addListviewItem("ViewFlipperActivity", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ViewFlipperActivity.class);
            }
        });
        addListviewItem("ViewGroup滑动测试通过Scroller", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ScrollerTestActivity.class);
            }
        });
        addListviewItem("Image渐变", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ImageGradientActivity.class);
            }
        });
        addListviewItem("手势识别", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(GestureActivity.class);
            }
        });
        addListviewItem("BottomSheet Dialog 展示", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BottomSheetActivity.class);
            }
        });

        addListviewItem("Glide 框架使用", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(GlideActivity.class);
            }
        });

        addListviewItem("沉浸式状态栏", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(ImmersingStatusBarActivity.class);
            }
        });
        addListviewItem("bitmap回收测试", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(BitmapRecycleActivity.class);
            }
        });
    }
}