package demo.huangli.mydemosnew.logic_set_1.accessibility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/11/2.
 */

public class MyAccessibilityActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_my_accessibility);
        findViewById(R.id.btn_detail).setOnClickListener(this);
        findViewById(R.id.btn_authorize).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_detail:
                forceStopApp(this,"mobi.supo.battery");
                break;
            case R.id.btn_authorize:
                showAccessibilitySettings(this,0x30);
                break;
        }
    }

    public static void forceStopApp(Activity context, String packageName) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING | Intent.FLAG_ACTIVITY_NO_ANIMATION);
        int i = Build.VERSION.SDK_INT;
        if (i >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
        } else {
            String string = i == 8 ? "pkg" : "com.android.settings.ApplicationPkgName";
            intent.setAction("android.intent.action.VIEW");
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra(string, packageName);
        }
        context.startActivityForResult(intent, 0x400);
    }

    public static boolean showAccessibilitySettings(Activity activity, int requestCode) {
        boolean ret;
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        try {
            activity.startActivityForResult(intent, requestCode);
            ret = true;
        } catch (ActivityNotFoundException e) {
            ret = false;
        }

        return ret;
    }
}
