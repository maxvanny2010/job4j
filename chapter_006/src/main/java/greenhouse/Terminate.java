package greenhouse;

/**
 * Terminate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/13/2020
 */
class Terminate extends GreenHouseScheduler implements Runnable {
    @Override
    public final void run() {
        System.out.println("Termination");
        super.getScheduler().shutdownNow();
        new Thread(() -> CollectData.DATA.forEach(System.out::println)).start();
    }
}
