package demo.huangli.mydemosnew.ui_set_1.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/9/30.
 */

public class GlideActivity extends Activity implements View.OnClickListener{

    private ImageView imageView;

    private MyLayout myLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        findViewById(R.id.btn_simple_target).setOnClickListener(this);
        findViewById(R.id.btn_view_target).setOnClickListener(this);
        findViewById(R.id.btn_preLoad).setOnClickListener(this);
        findViewById(R.id.btn_circle_crop).setOnClickListener(this);
        findViewById(R.id.btn_download_only_width_height).setOnClickListener(this);
        findViewById(R.id.btn_download_only_target).setOnClickListener(this);
        findViewById(R.id.btn_listener).setOnClickListener(this);
        findViewById(R.id.btn_transformation).setOnClickListener(this);
        imageView = findViewById(R.id.image_view);
        myLayout = findViewById(R.id.myLayout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_simple_target:
                SimpleTargetDemo();
                break;
            case R.id.btn_view_target:
                viewTargetDemo();
                break;
            case R.id.btn_preLoad:
                preload();
                break;
            case R.id.btn_download_only_width_height:
                try {
                    downloadOnlyByWidthHeight();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_download_only_target:
                downloadOnlyByTarget();
                break;
            case R.id.btn_listener:
                listener();
                break;
            case R.id.btn_circle_crop:
                circleCrop();
                break;
            case R.id.btn_transformation:
                transformation();
                break;
        }
    }

    public static int sCorner = 15;
    public static int sMargin = 2;

    private void transformation() {
        Log.i("Listener","触发");
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
//                .bitmapTransform(new RoundedCornersTransformation( GlideActivity.this,sCorner, sMargin))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Log.i("Listener","Exception "+e.getLocalizedMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.i("Listener","onResourceReady");
                        return false;
                    }
                })
                .into(imageView);

//        Glide.with(this)
//                .load(url)
//                .bitmapTransform(new BlurTransformation(this))
//                .into(imageView);
    }

    private void listener(){
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        Log.i("Listener","Exception "+e.getLocalizedMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        Log.i("Listener","onResourceReady");
                        return false;
                    }
                })
                .into(imageView);
    }

    private void viewTargetDemo(){
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .into(myLayout.getTarget());
    }

    private void SimpleTargetDemo(){
        SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                imageView.setImageBitmap(resource);
            }
        };
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .asBitmap()
                .into(simpleTarget);
    }

    private void preload(){
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .preload();
        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }

    private void downloadOnlyByTarget(){
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .downloadOnly(new DownloadImageTarget());
    }

    private void downloadOnlyByWidthHeight() throws ExecutionException, InterruptedException {
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        final Context context = getApplicationContext();
        final FutureTarget<File> target = Glide.with(context)
                .load(url)
                .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
        new Thread(){
            @Override
            public void run() {
                super.run();
                final File imageFile;
                try {
                    imageFile = target.get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, imageFile.getPath(), Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void circleCrop(){
        String url = "http://a.hiphotos.baidu.com/baike/pic/item/8ad4b31c8701a18b4f7365d3942f07082938fe96.jpg";
        Glide.with(this)
                .load(url)
                .transform(new CircleCrop(this))
                .into(imageView);
    }
}
