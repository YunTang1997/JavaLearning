package senior.java.thread;

import start.java.IfElseTest1;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决线程的安全问题？同步机制,有三种方法
 * 4.是否涉及线程的通信？是
 * @author YunTang
 * @create 2020-07-27 19:14
 */

public class ProductTest {

    public static void main(String[] args){

        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        producer.setName("生产者");
        producer.start();

        Customer1 customer1 = new Customer1(clerk);
        customer1.setName("消费者");
        customer1.start();
    }

}

class Clerk{

    private int productCount = 0;
    // 生产产品
    public synchronized void produceProduct() {

            if (productCount < 20) {
                productCount++;
                System.out.println(Thread.currentThread().getName() + "开始生产第" + productCount + "个产品");

                notify(); // 只要生产了一个产品就可以将消费者线程唤醒
            }
            else{ // 等待
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    // 消费产品
    public synchronized void consumeProduct() {

        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productCount + "个产品");
            productCount--;

            notify(); // 只要消费了一个产品就可以将生产者线程唤醒
        }
        else{ // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{ // 生产者

    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName() + "开始生产");
        while(true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}

class Customer1 extends Thread{ // 消费者

    private Clerk clerk;

    public Customer1(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println(getName() + "开始消费");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}






