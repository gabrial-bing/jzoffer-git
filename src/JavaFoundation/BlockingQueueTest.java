package JavaFoundation;

import com.oracle.jrockit.jfr.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest {

    public static class Basket{
        /*
        定义一个装苹果的篮子
        */
        BlockingQueue<String> basket = new ArrayBlockingQueue<>(3);

        //生产苹果
        public void produce() throws InterruptedException {
            basket.put("an apple");
        }
        //销售苹果
        public String consume() throws InterruptedException {
            String apple = basket.take();
            return apple;
        }

        public int getAppleNumber(){
            return basket.size();
        }

    }

    //　测试方法
    public static void testBasket() {
        //建立一个装苹果的篮子(实例化)
        final Basket basket = new Basket();
        //定义苹果的生产者
        class Producer implements Runnable{
            public void run() {
                try {
                while(true){
                    //生产苹果
                    System.out.println("生产者准备生产苹果：" + System.currentTimeMillis());
                        basket.produce();
                    System.out.println("生产者生产苹果完毕：" + System.currentTimeMillis());
                    System.out.println("生产完后有苹果：" + basket.getAppleNumber() + "个");
                    //休眠300ms

                        Thread.sleep(300);
                }
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
            }
        }

        //定义苹果的消费者
        class Consumer implements Runnable{
            public void run() {
                while(true){
                    //消费苹果
                    System.out.println("消费者准备消费苹果：" + System.currentTimeMillis());
                    try {
                        basket.consume();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                    System.out.println("消费者消费苹果完毕：" + System.currentTimeMillis());
                    System.out.println("消费完后有苹果：" + basket.getAppleNumber() + "个");
                    //休眠1000ms
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit( producer);
        service.submit( consumer);
        //程序运行10s后，所有任务停止
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){

        }
        service.shutdownNow();
    }

    public static void main(String[] args)  {
        BlockingQueueTest.testBasket();
    }
}
