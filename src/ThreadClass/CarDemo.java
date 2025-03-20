package ThreadClass;

public class CarDemo {
    public static void main(String[] args) {

        Car ferrari = new Car("Ferrari");
        Car bmw = new Car("Bmw");
        Car mercedes = new Car("Mercedes");
        Car tesla = new Car("Tesla");


        ferrari.start();
        bmw.start();
        mercedes.start();
        tesla.start();

        System.out.println("Метод main продолжил свою работу... Метод main выполняется в потоке с названием " + Thread.currentThread().getName());

    }
}
