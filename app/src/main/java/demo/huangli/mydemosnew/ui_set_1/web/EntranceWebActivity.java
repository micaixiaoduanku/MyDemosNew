package demo.huangli.mydemosnew.ui_set_1.web;

import demo.huangli.mydemosnew.BaseListActivity;

/**
 * Created by huangli on 17/12/27.
 * WebView的加载 link : https://www.jianshu.com/p/3c94ae673e2a
 * js和WebView交互link : https://www.jianshu.com/p/345f4d8a5cfa
 * WebView存在的一些漏洞 : https://www.jianshu.com/p/3a345d27cd42
 */

public class EntranceWebActivity extends BaseListActivity {
    @Override
    public void initItems() {
        addListviewItem("WebView的加载", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(WebLoadActivity.class);
            }
        });
        addListviewItem("WebView和JS交互方式", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(WebJSActivityWayActivity.class);
            }
        });
        addListviewItem("JS通过WebView调用 Android 代码", new ItemClickListener() {
            @Override
            public void itemClicked() {
                intentActivity(JsWebActivityWayActivity.class);
            }
        });
    }
}
