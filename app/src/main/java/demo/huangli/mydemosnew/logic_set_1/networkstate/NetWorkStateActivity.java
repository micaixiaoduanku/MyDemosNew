package demo.huangli.mydemosnew.logic_set_1.networkstate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by huangli on 17/9/11.
 */

public class NetWorkStateActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int apntype = NetWorkUtils.getAPNType(this);
        int connectedType = NetWorkUtils.getConnectedType(this);
        boolean isMobileConnected = NetWorkUtils.isMobileConnected(this);
        boolean isNetworkConnected = NetWorkUtils.isNetworkConnected(this);
        boolean isWifiConnected = NetWorkUtils.isWifiConnected(this);
        Log.i("NetWorkStateActivity","apntype "+apntype+" connectedType "+connectedType+" isMobileConnected "+isMobileConnected
        +" isNetworkConnected "+isNetworkConnected+" isWifiConnected "+isWifiConnected);
        test();
    }

    private void test(){
        String str = "转换测试"; //默认环境，已是UTF-8编码
        try {
            String strGBK = URLEncoder.encode(str, "gb2312");
            System.out.println(strGBK);
            String strUTF8 = URLDecoder.decode(str, "UTF-8");
            System.out.println(strUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
