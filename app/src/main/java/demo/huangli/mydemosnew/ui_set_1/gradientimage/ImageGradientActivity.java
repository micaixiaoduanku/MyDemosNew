package demo.huangli.mydemosnew.ui_set_1.gradientimage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import demo.huangli.mydemosnew.R;

/**
 * Created by huangli on 17/5/19.
 */

public class ImageGradientActivity extends Activity implements View.OnClickListener{

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_gradient);
        imageView = (ImageView)findViewById(R.id.imageview);
        findViewById(R.id.btn_play).setOnClickListener(this);
        viewAnim();
    }

    private void viewAnim(){
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setFloatValues(1,2);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                imageView.getDrawable();
            }
        });
        valueAnimator.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                ObjectAnimator anim01 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 2f);
                ObjectAnimator anim02 = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 2f);
                ObjectAnimator anim03 = ObjectAnimator.ofInt(imageView, "imageAlpha", 255, 50);
                AnimatorSet animSet0 = new AnimatorSet();
                animSet0.play(anim01).with(anim02).with(anim03);
                animSet0.setDuration(3000);
                animSet0.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        imageView.setScaleX(1);
                        imageView.setScaleY(1);
                        imageView.setImageAlpha(255);
                        imageView.setImageResource(R.mipmap.demo2);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animSet0.start();
                break;
        }
    }
}
