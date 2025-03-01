package basic_multithreading;



public class AppRunnable {
    static class Runner implements Runnable{

        @Override
        public void run() {
            for (int i=0; i < 10; i++){
                System.out.println("Hello: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread threadOne = new Thread(new Runner());
        Thread threadTwo = new Thread(new Runner());

        threadOne.start();
        threadTwo.start();
    }
}
