package demo.huangli.mydemosnew.ui_set_1.circularimage;

import android.app.Activity;
import android.os.Bundle;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 16/9/19.
 */
public class CircularActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        CircularImage cover_user_photo = (CircularImage) findViewById(R.id.cover_user_photo);
        cover_user_photo.setImageResource(R.mipmap.ic_launcher);
    }
}
