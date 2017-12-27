package demo.huangli.mydemosnew.ui_set_1.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/12/27.
 */

public class WebLoadActivity extends Activity{

    private WebView mWebview;
    private WebSettings mWebSettings;

    private TextView mtitleTv,progressTv;

    private void findViews(){
        mWebview = findViewById(R.id.web_view);
        mtitleTv = findViewById(R.id.tv_title);
        progressTv = findViewById(R.id.tv_progress);
    }

    private void loadUrl(){
        mWebview.loadUrl("http://www.baidu.com/");
    }

    private void attachClient(){
        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                System.out.println("开始加载了");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("结束加载了");
            }
        });
        //设置WebChromeClient类
        mWebview.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("标题在这里");
                mtitleTv.setText(title);
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    String progress = newProgress + "%";
                    progressTv.setText(progress);
                } else if (newProgress == 100) {
                    String progress = newProgress + "%";
                    progressTv.setText(progress);
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        findViews();
        loadUrl();
        attachClient();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()){
            mWebview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        if (mWebview != null){
            mWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebview.clearHistory();

            ((ViewGroup) mWebview.getParent()).removeView(mWebview);
            mWebview.destroy();
            mWebview = null;
        }
        super.onDestroy();
    }
}
