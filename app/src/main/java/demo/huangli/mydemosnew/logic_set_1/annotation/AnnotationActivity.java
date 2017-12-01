package demo.huangli.mydemosnew.logic_set_1.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.lang.annotation.Annotation;

/**
 * Created by huangli on 17/10/17.
 */

public class AnnotationActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Class demoCls = Demo.class;
        Annotation annotation = demoCls.getAnnotation(MyAnnotation.class);
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        myAnnotation.color();
        myAnnotation.info();
        myAnnotation.like();
        myAnnotation.name();
        Log.i("tag","name "+myAnnotation.name());
    }
}
