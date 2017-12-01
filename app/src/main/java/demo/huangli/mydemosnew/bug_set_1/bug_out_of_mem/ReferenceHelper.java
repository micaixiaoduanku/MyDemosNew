package demo.huangli.mydemosnew.bug_set_1.bug_out_of_mem;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * Created by huangli on 17/10/19.
 */

public class ReferenceHelper {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> ref = null;
        while ((ref = rq.poll()) != null) {
            if (ref != null) {
                System.out.println("In queue: "	+ ((VeryBigWeakReference) (ref)).id);
            }
        }
    }

    public static void run(){
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            weakList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
            System.out.println("Just created weak: " + weakList.getLast());

        }

        System.gc();
        try { // 下面休息几分钟，让上面的垃圾回收线程运行完成
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

    public static class VeryBig {
        public String id;
        // 占用空间,让线程进行回收
        byte[] b = new byte[2 * 1024];

        public VeryBig(String id) {
            this.id = id;
        }

        protected void finalize() {
            System.out.println("Finalizing VeryBig " + id);
        }
    }
    public static class VeryBigWeakReference extends WeakReference<VeryBig> {

        public String id;

        public VeryBigWeakReference(VeryBig referent, ReferenceQueue<? super VeryBig> q) {
            super(referent, q);
            this.id = referent.id;
        }

        protected void finalize() {
            System.out.println("Finalizing VeryBigWeakReference " + id);
        }
    }
}
