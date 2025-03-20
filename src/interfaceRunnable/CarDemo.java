package interfaceRunnable;

public class CarDemo {
    public static void main(String[] args) {

        Car ferrari = new Car("Ferrari");
        Car bmw = new Car("Bmw");
        Car mercedes = new Car("Mercedes");
        Car tesla = new Car("Tesla");



        Thread ferrariThread = new Thread(ferrari);
        Thread bmwThread = new Thread(bmw);
        Thread mercedesThread = new Thread(mercedes);
        Thread teslaThread = new Thread(tesla);


        ferrariThread.start();
        bmwThread.start();
        mercedesThread.start();
        teslaThread.start();

        System.out.println("Метод main продолжил свою работу... Метод main выполняется в потоке с названием " + Thread.currentThread().getName());

    }
}
