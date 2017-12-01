package li.huang.rxjava.helper;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import li.huang.rxjava.R;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by huangli on 17/10/4.
 */

public class RxJavaMapHelper {

    public final static String TAG = "RxJavaMapHelper";

    public RxJavaMapHelper() {
    }

    /**
     * 简单转换
     * @param context
     * @param imageView
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void mapDemo(final Context context, final ImageView imageView){
        Integer[] resIds = new Integer[]{R.mipmap.demo1,R.mipmap.demo2,R.mipmap.demo3,R.mipmap.demo4};
        Observable.from(resIds).map(new Func1<Integer, Drawable>() {
            @Override
            public Drawable call(Integer integer) {
                try {
                    Thread.sleep(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return context.getDrawable(integer);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Drawable>() {
            @Override
            public void call(Drawable drawable) {
                imageView.setImageDrawable(drawable);
            }
        });
    }

    class Teacher{
        public String name;
        public Teacher(String name) {
            this.name = name;
        }
    }

    class Course{
        public String name;
        public List<Teacher> teachers = new ArrayList<>();
        public Course(String name) {
            this.name = name;
            teachers.add(new Teacher("张老师"));
            teachers.add(new Teacher("王老师"));
        }
    }

    class Student{
        public List<Course> courses = new ArrayList<>();
        public String name;

        public Student(String name) {
            this.name = name;
            courses.add(new Course("语文"));
            courses.add(new Course("数学"));
            courses.add(new Course("英语"));
        }
    }

    /**
     * 平铺转换
     */
    public void flatMapDemo(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("小白"));
        students.add(new Student("小红"));
        students.add(new Student("小黑"));
        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.i(TAG,"course name "+course.name);
            }
        };
        Observable.from(students).flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                return Observable.from(student.courses);
            }
        }).subscribe(subscriber);
    }

    public void multipleMapDemo(){
        /**
         * 多次简单转换
         */
        Observable.just(1,2,3,4).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer+"";
            }
        }).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer s) {
                Log.i(TAG,"输出  "+s);
            }
        });
        /**
         * 多次平铺转换
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student("小白"));
        students.add(new Student("小红"));
        students.add(new Student("小黑"));
        Observable.from(students).flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                return Observable.from(student.courses);
            }
        }).flatMap(new Func1<Course, Observable<Teacher>>() {
            @Override
            public Observable<Teacher> call(Course course) {
                return Observable.from(course.teachers);
            }
        }).subscribe(new Action1<Teacher>() {
            @Override
            public void call(Teacher teacher) {
                Log.i(TAG,"teacher "+teacher.name);
            }
        });
    }

    public void doOnSubscribe(){
        Observable.just(1).subscribeOn(Schedulers.io()).doOnSubscribe(new Action0() {
            @Override
            public void call() {
                /**
                 * 这个地方可以控制线程的执行，我们让它执行在ui线程去做一些初始化操作
                 */
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(TAG,"输出结果");
            }
        });
    }
}
