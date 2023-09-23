public class Counter {
    private static int count = 0;
    public static synchronized void increment(){
        count++;
    }


    public static int getValue(){
        return count;
    }
    public static class Mythread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                Thread thread = new Thread(() -> {
                    for (int j = 0; j < 1000; j++) {
                        Counter.increment();
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.printf("Итоговое число: %d\n", Counter.getValue());
        }

        }
        public static class Main{
            public static void main(String[] args){
                Mythread thread = new Mythread();
                thread.start();

            }
        }
        }