package so;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProcessSync {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean resourceReady = false;

    public void processA() {
        lock.lock();
        try {
            while (!resourceReady) {
                condition.await();
            }
            System.out.println("\n" + "Procesi A qasje në burim të përbashkët.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void processB() {
        lock.lock();
        try {
            System.out.println("Procesi B qasje në burim të përbashkët.");
            resourceReady = true;
            condition.signal();
        } finally {
            lock.unlock();
        }
    }}
