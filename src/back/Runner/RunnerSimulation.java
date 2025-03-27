package back.Runner;

import java.util.Random;

public class RunnerSimulation {

    private static volatile boolean raceOver = false;

    public static void main(String[] args) {

        Thread runner1 = new Thread(new Runner("Runner1"));
        Thread runner2 = new Thread(new Runner("Runner2"));


        runner1.start();
        runner2.start();
    }


    static class Runner implements Runnable {
        private final String name;
        private final Random random = new Random();

        public Runner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            int position = 0;
            while (!raceOver && position < 100) {

                int step = random.nextInt(10) + 1;
                position += step;


                System.out.println(name + " на " + position + " метрах");


                if (position >= 100 && !raceOver) {
                    raceOver = true;
                    System.out.println("🏁 " + name + " побеждает в гонке!");
                    break;
                }

                try {

                    Thread.sleep(random.nextInt(201) + 100);
                } catch (InterruptedException e) {
                    System.out.println(name + " был прерван.");
                }
            }
        }
    }
}
