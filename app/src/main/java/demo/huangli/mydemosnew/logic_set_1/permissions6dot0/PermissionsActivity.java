package demo.huangli.mydemosnew.logic_set_1.permissions6dot0;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import demo.huangli.mydemosnew.R;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Created by huangli on 16/10/10.
 */
@RuntimePermissions
public class PermissionsActivity extends Activity implements View.OnClickListener{

    public static String TAG = "PermissionsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"PermissionsActivity onCreate");
        setContentView(R.layout.activity_permissions);
        findViewById(R.id.btn_req_permission).setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.i(TAG,"Build.VERSION.SDK_INT >= Build.VERSION_CODES.M");
            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
            Log.i(TAG,"hasWriteContactsPermission "+hasWriteContactsPermission);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG,"hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED");
            }
        }

    }

    @NeedsPermission({Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS})
    void showContacts() {
        // NOTE: Perform action that requires the permission.
        // If this is run by PermissionsDispatcher, the permission will have been granted
        Log.i(TAG,"请求权限读取联系人权限成功");

    }

    @OnShowRationale({Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS})
    void showRationaleForContact(PermissionRequest request) {
        // NOTE: Show a rationale to explain why the permission is needed, e.g. with a dialog.
        // Call proceed() or cancel() on the provided PermissionRequest to continue or abort
        showRationaleDialog("Contacts permissions are needed to demonstrate access to the contacts database.", request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionsActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void showRationaleDialog( String messageRes, final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setPositiveButton("allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton("deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@NonNull DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .setCancelable(false)
                .setMessage(messageRes)
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_req_permission:
                PermissionsActivityPermissionsDispatcher.showContactsWithCheck(this);
                break;
        }
    }
}
