package interfaceRunnable;

public class Car implements Runnable {
    private String model;

    public Car(String model) {
        this.model = model;
    }


    @Override
    public void run() {

        try {
            Thread.sleep(1000); // "усыпим" наш поток на 1 сек (1000 миллисек) -
        } catch (InterruptedException e) {
        }
        // временно остановим выполнение кода нашего потока

        System.out.println("Car " + model + " is being driven by thread " + Thread.currentThread().getName());

    }
}
