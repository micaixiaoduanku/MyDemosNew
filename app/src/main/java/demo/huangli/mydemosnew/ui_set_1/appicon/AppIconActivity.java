package demo.huangli.mydemosnew.ui_set_1.appicon;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/12/5.
 */

public class AppIconActivity extends Activity{
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_icon);
        imageView = (ImageView)findViewById(R.id.image_view);
        imageView.setImageDrawable(getQuickNameIcon("com.mediatek.voicecommand"));
    }

    /**
     *
     * 12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.ue.service
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.android.defcontainer
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.safebox
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.android.stk
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.wandoujia.phoenix2.usbproxy
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.safe.powercenter
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.android.phone
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.wifiswitch
     12-06 01:47:36.987 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.lightsettings
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.ideafriend
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.facebook.katana
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.leos.appstore
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.sohu.inputmethod.sogou
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.amap.android.location
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.android.systemui
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.kingroot.kinguser
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.lsf.device
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.safecenter
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.tencent.wstt.gt
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.wandoujia.phoenix2
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.mediatek.voicecommand
     12-06 01:47:36.988 20795-20795/mobi.supo.battery I/yb APPM: com.lenovo.batterywarning
     */

    private Drawable getQuickNameIcon(String pkgName) {

        Drawable icon = null;
        PackageManager pm = getPackageManager();
        try {
            ApplicationInfo appInfo = pm.getApplicationInfo(pkgName, 0);
            icon = appInfo.loadIcon(pm);// pm.getApplicationIcon(appInfo);
//            name = appInfo.loadLabel(pm).toString();// pm.getApplicationLabel(appInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
//            name = pkgName;
            e.printStackTrace();
        }
        return icon;
    }
}
