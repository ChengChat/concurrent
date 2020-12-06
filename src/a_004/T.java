package a_004;

import java.util.concurrent.CountDownLatch;

/**
 * 写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印"完成"
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            int j = i;
            new Thread(() -> {
                System.out.println(j);
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("完成");
    }
}
