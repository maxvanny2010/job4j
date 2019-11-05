package patterns.generate.singleton;

/**
 * Main.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/26/2019
 */
final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Method the main.
     *
     * @param args the args
     */
    public static void main(final String[] args) {
        final Thread firstSingleton = new Thread(new FirstSingletonThread());
        final Thread secondSingleton = new Thread(new SecondSingletonThread());
        firstSingleton.start();
        secondSingleton.start();
    }

    /**
     * FirstSingletonThread.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 10/26/2019
     */
    private static class FirstSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Some text");
            System.out.println(singleton.getValue());
        }
    }

    /**
     * SecondSingletonThread.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 10/26/2019
     */
    private static class SecondSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("another text");
            System.out.println(singleton.getValue());
        }
    }
}
