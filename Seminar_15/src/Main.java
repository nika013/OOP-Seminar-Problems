import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        List<Character> arr = new ArrayList<>(10);
        Semaphore semaphore = new Semaphore(0);
        Thread reader = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphore.acquire();
                        char ch = arr.get(i);
                        System.out.println("reading: " + ch);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread writer = new Thread() {
            @Override
            public void run() {
                char ch = 'a';
                for (int i = 0; i < 10; i++) {
                    arr.add(ch);
                    System.out.println("writing: " + ch);
                    ch++;
                    semaphore.release();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        writer.start();
        reader.start();

        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            System.out.println("Also interrupted here");
            throw new RuntimeException(e);
        }
    }
}