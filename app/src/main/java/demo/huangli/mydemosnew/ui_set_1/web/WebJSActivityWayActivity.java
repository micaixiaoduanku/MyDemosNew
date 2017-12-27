package demo.huangli.mydemosnew.ui_set_1.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/12/27.
 *
 * 总结：android 调用 js 代码有两种方法，一个是通过WebView调用loadUrl，另外一个是调用evaluateJavascript
 * 这两种方法的区别是loadUrl，效率比调用evaluateJavascript低，而且获取返回值必需从WebChromeClient种的回调获取，比较麻烦，evaluateJavascript获取返回值就比较方便
 * 直接通过ValueCallback回调获取.evaluateJavascript必需在4.4以上的版本才能使用(不过现在5.0以上的手机都已经普及了)
 */

public class WebJSActivityWayActivity extends Activity implements View.OnClickListener{

    public static final String TAG = "WebJSActivityWay";

    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webjsway1);
        findViews();
        loadSetting();
        loadUrl();
        attachClient();
    }

    private void loadSetting(){
        WebSettings webSettings = webView.getSettings();
        // 设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }

    private void loadUrl(){
        // 先载入JS代码
        // 格式规定为:file:///android_asset/文件名.html
        webView.loadUrl("file:///android_asset/javascript_load.html");
    }

    private void findViews() {
        webView = findViewById(R.id.webView);
        findViewById(R.id.btn_js_way1).setOnClickListener(this);
        findViewById(R.id.btn_js_way2).setOnClickListener(this);
    }

    private void attachClient(){
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                AlertDialog.Builder b = new AlertDialog.Builder(WebJSActivityWayActivity.this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_js_way1:
                // 注意调用的JS方法名要对应上
                // 调用javascript的callJS()方法
                webView.post(new Runnable() {
                    @Override
                    public void run() {

                        // 注意调用的JS方法名要对应上
                        // 调用javascript的callJS()方法
                        webView.loadUrl("javascript:callJS()");
                    }
                });
                break;
            case R.id.btn_js_way2:
                webView.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
                        Log.i(TAG,"JS back value "+value);
                    }
                });
                break;
        }
    }
}
