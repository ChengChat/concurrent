package a_003;

/**
 * 模拟一个死锁
 */
public class DeadLock {
    Object o1 = new Object();
    Object o2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();
        Thread thread = new Thread(() -> {
            deadLock.method1();
        });
        thread.start();
        thread.join(500);

        new Thread(() -> {
            deadLock.method2();
        }).start();
    }

    public void method1(){
        synchronized (o1){
            try {
                System.out.println("我得到了o1,我想要o2");
                Thread.sleep(1000);
//                o1.wait();
                synchronized(o2){
                    System.out.println("我得到了o2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2(){
        synchronized (o2){
            System.out.println("我得到了o2，我想要o1");
            synchronized (o1){
//                o1.notify();
                System.out.println("我得到了o1");
            }
        }
    }
}
