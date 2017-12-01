package demo.huangli.mydemosnew.ui_set_1.bitmaprecycle;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/9/21.
 * 验证 ：一张bitmap设置到imageView里面后，这张bitmap可以回收了掉吗？
 */

public class BitmapRecycleActivity extends Activity implements View.OnClickListener{

    private ImageView imageView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_recycle);
        findViewById(R.id.btn_recycle).setOnClickListener(this);
        findViewById(R.id.btn_analysis).setOnClickListener(this);
        imageView = (ImageView)findViewById(R.id.image_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_analysis:
                bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.demo1);
                imageView.setImageBitmap(bitmap);
                bitmap.recycle();
                break;
            case R.id.btn_recycle:
                if (bitmap != null){
                    Log.i("TAG","bitmap 是否已经回收 "+bitmap.isRecycled());
                    bitmap.recycle();
                }
                Drawable drawable = imageView.getDrawable();
                if (drawable instanceof BitmapDrawable){
                    Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                    if (bitmap2 != null){
                        Log.i("TAG","bitmap2 是否已经回收 "+bitmap2.isRecycled());
                    }
                }
                break;
        }
    }
}
