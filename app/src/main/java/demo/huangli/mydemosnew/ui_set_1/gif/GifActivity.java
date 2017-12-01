package demo.huangli.mydemosnew.ui_set_1.gif;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import demo.huangli.mydemosnew.BaseActivity;
import demo.huangli.mydemosnew.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by huangli on 16/9/6.
 * 详细文档 https://github.com/koral--/android-gif-drawable
 */
public class GifActivity extends BaseActivity implements View.OnClickListener{

    public final static String TAG = "GifActivity";

    private GifImageView gifImageView;
    private GifDrawable gifDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        gifImageView = (GifImageView)findViewById(R.id.git_image);
        findViewById(R.id.btn_play_again).setOnClickListener(this);
        try {
            gifDrawable = new GifDrawable( getResources(), R.drawable.white_floatball );
            gifImageView.setImageDrawable(gifDrawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_play_again:
                if (gifDrawable != null){
                    gifDrawable.reset(); //实现gif重播
                }
                break;
        }
    }
}
