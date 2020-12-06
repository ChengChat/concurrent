package a_005;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 证明AtomicXX类比synchronized更高效
 */
public class T {

    int count = 0;

    AtomicInteger count2 = new AtomicInteger(0);

    synchronized void m() {
        count++;
    }

    void m2() {
        count2.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(t::m);
            thread.start();
            // 子线程调用了join()方法之后，主线程被阻塞，等待子线程执行结束之后，主线程继续执行。
            thread.join();
        }
        long end = System.currentTimeMillis();
        System.out.println("m 所 耗用时间 " + (end - start));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(t::m2);
            thread.start();
            thread.join();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("m2 所耗用时间 " + (end2 - start2));
    }
}
