package so;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class main{
    public static void main(String[] args) {
        ProcessSync sync = new ProcessSync();

        Thread threadA = new Thread(() -> {
            sync.processA();
        });

        Thread threadB = new Thread(() -> {
            sync.processB();
        });

        threadA.start();
        threadB.start();
    }
}
