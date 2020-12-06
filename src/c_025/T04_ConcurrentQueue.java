package c_025;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 同步队列，ConcurrentQueue
 */
public class T04_ConcurrentQueue {


    public static void main(String[] args) {
        // LinkedQueue，无界队列
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < 10; i++) {
            // 有返回值，返回false代表没有加入成功，true 代表成功，并且此方法不会阻塞
            queue.offer("a" + i);
        }

        System.out.println(queue);
        System.out.println(queue.size());
        // 取出队头
        System.out.println(queue.poll());
        System.out.println(queue.size());
        // 取出队头，但是不删除队头
        System.out.println(queue.peek());
        System.out.println(queue.size());
        
        // 双端队列 Deque 发音： dai ke
        //Deque<String> deque = new ConcurrentLinkedDeque<>();
        //deque.addFirst();
        //deque.addLast();
        //deque.pollFirst();
        //deque.pollLast();
        //deque.peekFirst();
        //deque.peekLast();
    }
    
}
