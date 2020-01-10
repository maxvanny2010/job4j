package pool;

/**
 * Element.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/4/2020
 */
class Element extends Thread {
    /**
     * field tasks.
     */
    private final BlockingQueue<Runnable> tasks;

    /**
     * Constructor.
     *
     * @param aTasks task
     */
    Element(final BlockingQueue<Runnable> aTasks) {
        this.tasks = aTasks;
    }

    @Override
    public final void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.tasks.poll().run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
