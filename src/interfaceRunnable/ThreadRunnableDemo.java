package interfaceRunnable;

public class ThreadRunnableDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadExample2());
            thread.start();
        }
    }
}
