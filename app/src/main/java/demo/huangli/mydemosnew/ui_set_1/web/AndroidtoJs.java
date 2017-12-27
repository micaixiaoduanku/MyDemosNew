package demo.huangli.mydemosnew.ui_set_1.web;

import android.webkit.JavascriptInterface;

/**
 * Created by huangli on 17/12/27.
 */

public class AndroidtoJs extends Object{
    @JavascriptInterface
    public void hello(String msg) {
        System.out.println("JS调用了Android的hello方法");
    }
}
