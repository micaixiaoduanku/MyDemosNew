package demo.huangli.mydemosnew.logic_set_1.enumpkg;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by huangli on 17/11/28.
 */

public class Constant {
    /**
     * 这种定义对于getLevel中的level是不安全的，因为可以传入非0和1的常量，导致抛出异常.
     */
    public static class ConstantDef1{
        public final int UI_PERF_LEVEL_0 = 0;
        public final int UI_PERF_LEVEL_1 = 1;

        public int getLevel(int level){
            switch (level){
                case UI_PERF_LEVEL_0:
                    return 0;
                case UI_PERF_LEVEL_1:
                    return 1;
                    default:
                        throw new IllegalArgumentException("Unkonw");
            }
        }
    }

    /**
     * 输入参数被限制在PER_LEVEL中，这样就不用再做容错处理。
     * 枚举最大的优点就是内存安全，但在Android平台上，枚举的内存开销直接定义常量的3倍以上
     */
    public static class ConstantDef2{
        public enum PER_LEVEL{
            UI_PERF_LEVEL_0,
            UI_PERF_LEVEL_1
        }

        public static int getLevel(PER_LEVEL level){
            switch (level){
                case UI_PERF_LEVEL_0:
                    return 0;
                case UI_PERF_LEVEL_1:
                    return 1;
                    default:
                        throw new IllegalArgumentException("Unkonw");
            }
        }
    }

    /**
     * 目前最好的常量定义方式，第一是安全，第二比枚举方式节约内存
     */
    public static class ConstantDef3{
        public static final int UI_PERF_LEVEL_0 = 0;
        public static final int UI_PERF_LEVEL_1 = 1;
        @IntDef({UI_PERF_LEVEL_0,UI_PERF_LEVEL_1})
        @Retention(RetentionPolicy.SOURCE)
        public @interface PER_LEVEL {
        }

        public static int getLevel(@PER_LEVEL int level){
            switch (level){
                case UI_PERF_LEVEL_0:
                    return 0;
                case UI_PERF_LEVEL_1:
                    return 1;
                    default:
                        throw new IllegalArgumentException("Unkonw");
            }
        }
    }

}
