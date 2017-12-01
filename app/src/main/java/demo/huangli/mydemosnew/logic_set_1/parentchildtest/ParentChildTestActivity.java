package demo.huangli.mydemosnew.logic_set_1.parentchildtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by huangli on 16/12/20.
 */

public class ParentChildTestActivity extends Activity{

    private class Parent{
        public Parent() {
            Log.i("tag","Parent()");
        }
    }

    private class Child extends Parent{
        public Child() {
            Log.i("tag","Child()");
        }
    }


    class A{
        Integer i = new Integer(5);
    }

    static class B{
        static Integer i;

        public B(Integer i) {
            this.i = i;
        }
    }

    private static B b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        A a = new A();
        b = new B(a.i);

        a = null;
    }
}
