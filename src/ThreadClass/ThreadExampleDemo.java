package ThreadClass;

public class ThreadExampleDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadExample1 thread = new ThreadExample1();
            thread.start();
        }
    }
}
