package Part2;

public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterThread(counter));

        Thread thread2 = new Thread(new CounterThread(counter));

        thread1.start();
        thread2.start();

        //Thread.sleep(1); - не решение проблемы

        thread1.join();
        thread2.join();

        System.out.println("Итоговый показатель счетчика = " + counter.getCount());

        // JVisualVM - программа, которая показывает состояние потоков

    }
}