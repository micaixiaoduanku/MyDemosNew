package demo.huangli.mydemosnew.logic_set_1.strictmode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by huangli on 16/11/22.
 */

public class StrictModeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        writeToExternalStorage();
    }

    public void writeToExternalStorage() {
        File path = Environment.getExternalStorageDirectory();
        File destFile = new File(path, "strictmode.txt");
        try {
            OutputStream output = new FileOutputStream(destFile, true);
            output.write("测试strictmnode".getBytes());
            output.flush();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
