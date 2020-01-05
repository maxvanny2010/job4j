package deadlock;

/**
 * SingletonField.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/3/2020
 */
final class Deadlock {
    /**
     * Constructor.
     */
    private Deadlock() {
    }

    /**
     * Method deadlock.
     *
     * @param lock1 lock
     * @param lock2 lock
     */
    private static void deadLock(final Object lock1, final Object lock2) {
        new Thread(() -> {
            final String name = Thread.currentThread().getName();
            System.out.println("Waiting " + name + " " + lock1);
            synchronized (lock1) {
                System.out.println("Holding " + name + " " + lock1);
                System.out.println("Waiting " + name + " " + lock2);
                synchronized (lock2) {
                    System.out.println("Holding " + name + " " + lock2);
                }
            }
        }).start();
    }

    /**
     * Method a point to program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadLock(lock1, lock2);
        deadLock(lock2, lock1);
    }

}
