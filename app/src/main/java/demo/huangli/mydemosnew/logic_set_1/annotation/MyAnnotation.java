package demo.huangli.mydemosnew.logic_set_1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static demo.huangli.mydemosnew.logic_set_1.annotation.Color.RED;

/**
 * Created by huangli on 17/10/17.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)     //指定范围
public @interface MyAnnotation {
    String name() default "jay";
    String info() default "msg";
    String[] like() default {"football","basketball"};  //数组
    Color color() default RED;      //枚举
}
