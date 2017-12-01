package demo.huangli.mydemosnew.logic_set_1.createshortcut;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.database.Cursor;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import java.util.Arrays;

import demo.huangli.mydemosnew.MainActivity;
import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/3/31.
 */

public class CreateHideShortCutActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_cut);
        findViewById(R.id.btn_dynamic).setOnClickListener(this);
    }

    public void OnClickCreateShortCut(View view){
        createShortcut();
    }

    public void OnClickHideAppIcon(View view){
        hideAppIcon();
    }

    public void OnClickShowAppIcon(View view){
        showAppIcon();
    }

    private void showAppIcon(){
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DEFAULT, PackageManager.DONT_KILL_APP);
    }

    private void hideAppIcon(){
//        PackageManager p = getPackageManager();
//        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        PackageManager p = getPackageManager();
        p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER, PackageManager.DONT_KILL_APP);
    }

    private void createShortcut(){
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
        shortcut.putExtra("duplicate", false);//设置是否重复创建
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setClass(this, MainActivity.class);//设置第一个页面
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(this, R.mipmap.ic_launcher);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        sendBroadcast(shortcut);
    }

    // 判读是否已经存在快捷方式
    public boolean isExistShortCut() {
        boolean isInstallShortcut = false;
        final ContentResolver cr = getContentResolver();
        // 本人的2.2系统是”com.android.launcher2.settings”,网上见其他的为"com.android.launcher.settings"
        final String AUTHORITY = "com.android.launcher2.settings";
        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
        Cursor c = cr.query(CONTENT_URI, new String[] { "title", "iconResource" }, "title=?", new String[] { getString(R.string.app_name) }, null);
        if (c != null && c.getCount() > 0) {
            isInstallShortcut = true;
            System.out.println("已经存在快捷方式");
        }
        return isInstallShortcut;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dynamic:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N_MR1)
    public void createDynamicShortCut(){
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                .setShortLabel("Web site")
                .setLongLabel("Open the web site")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.mysite.example.com/")))
                .build();
        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));

    }
}
