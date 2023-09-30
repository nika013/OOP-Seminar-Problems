import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trees {
    private int[] trees;
    private Semaphore semaphore;
    private Lock lock;
    private Condition condition;
    public Trees(int[] trees) {
        this.trees = trees;
        semaphore = new Semaphore(1);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }
    private static class GrowThread extends Thread {
        private int i;

        public GrowThread(int i) {
            super();
            this.i = i;
        }
        @Override
        public void run() {
            try {
                condition.await();
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
            semaphore.release();
        }
    }

    public void grow() {
        while (!notEqual(trees)) {
            GrowThread[] arr = new GrowThread[trees.length];
            for (int i = 0; i < trees.length; i++) {
                arr[i] = new GrowThread(i);
                arr[i].start();
            }

            for (int i = 0; i < trees.length; i++) {
                try {
                    arr[i].join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean notEqual(int[] trees) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int cur = trees[0];
        for (int i = 0; i < trees.length; i++) {
            if (cur != trees[i]) {
                semaphore.release();
                return false;
            }
        }
        semaphore.release();
        return true;
    }
}
