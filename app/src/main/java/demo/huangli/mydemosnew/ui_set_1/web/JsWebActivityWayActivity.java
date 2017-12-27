package demo.huangli.mydemosnew.ui_set_1.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Set;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/12/27.
 * 总结:js调用android有三个方法，一个是定义本地对象，js调用本地对象带有@JavascriptInterface的方法, 二是通过WebViewClient的回调去解析js中url协议
 * 三和二比较类似，区别是使用WebChromeClient中的onJsAlert，onJsConfirm，onJsPrompt三个回调去解析alert,confirm,prompt调用的协议.
 * 三种方法的比较: 方法二和三都需要约定协议，方法二返回结果给js比较困难。方法一比较简单方便，就是有一个漏洞问题，不过4.2以下才会出现，所以不必担心.
 * 关于漏洞 link : https://www.jianshu.com/p/3a345d27cd42
 */

public class JsWebActivityWayActivity extends Activity implements View.OnClickListener{

    public static final String TAG = "JsWebActivity";

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_web);
        findViews();
        mWebView = findViewById(R.id.webview);
        jsInvokeAndroidWay3();
    }

    private void findViews() {
        findViewById(R.id.btn_load).setOnClickListener(this);
    }

    private void jsInvokeAndroidWay3(){
        WebSettings webSettings = mWebView.getSettings();

        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        // 先加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.loadUrl("file:///android_asset/javascript_js3.html");

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                Log.i(TAG,"onJsConfirm message "+message);
                return super.onJsConfirm(view, url, message, result);
            }

            //拦截输入框（原理同方式2）
            //参数message:代表promt()的内容（不是url）
            //参数result:代表输入框的返回值


            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                Log.i(TAG,"onJsPrompt url "+url+" message "+message+" result "+result.toString());
                // 根据协议的参数，判断是否是所需要的url(原理同方式2)
                //一般根据scheme（协议格式） & authority（协议名）判断(前两个参数)
                //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
                Uri uri = Uri.parse(message);
                //如果url的协议 ＝ 预先约定的js协议
                //就解析往下解析参数
                Log.i(TAG,"uri Scheme "+uri.getScheme()+" Authority "+uri.getAuthority());
                if (uri.getScheme().equals("js")){
                    //如果authority = 预先协议里的webview,即代表都符合约定的协议
                    //所以拦截url,下面js开始调用Android需要的方法
                    if (uri.getAuthority().equals("demo")){
                        // 执行JS所需要调用的逻辑
                        Log.i(TAG,"js调用了Android的方法");
                        // 可以在协议上带有参数并传递到Android上
                        HashMap<String, String> params = new HashMap<>();
                        Set<String> collection = uri.getQueryParameterNames();
                        //参数result:代表消息框的返回值(输入值)
                        result.confirm("js调用了Android的方法成功啦");
                    }
                    return true;
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });
    }

    /**
     * 这个demo展示了js去调用了android,然后android又去调用js
     */
    private void jsInvokeAndroidWay2() {
        WebSettings webSettings = mWebView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 步骤1：加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                //步骤2 ：根据协议的参数，判断是否是所需要的url
                //一般根据scheme (协议格式) & authority(协议名)判断(前两个参数)
                Uri uri = Uri.parse(url);
                //如果url的协议 ＝ 预先约定的js协议
                //就解析往下解析参数
                if (uri.getScheme().equals("js")) {
                    //如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                    //所以拦截url,下面js开始调用Android需要的方法
                    if (uri.getAuthority().equals("webview")) {
                        System.out.println("js调用了Android的方法");
                    }
                    mWebView.loadUrl("javascript:callJS()");
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(JsWebActivityWayActivity.this);
                b.setTitle("Alert");
                b.setMessage(message);
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                b.setCancelable(false);
                b.create().show();
                return true;
            }

        });

    }

    private void jsInvokeAndroidWay1() {
        WebSettings webSettings = mWebView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 通过addJavascriptInterface()将Java对象映射到JS对象
        //参数1：Java对象名
        //参数2：Javascript对象名
        mWebView.addJavascriptInterface(new AndroidtoJs(), "test");//AndroidtoJS类对象映射到js的test对象
        // 加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebView.loadUrl("file:///android_asset/javascript_js1.html");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_load:
                mWebView.loadUrl("file:///android_asset/javascript_js2.html");
                break;
        }
    }
}
