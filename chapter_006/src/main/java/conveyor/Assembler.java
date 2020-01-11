package conveyor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Assembler.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class Assembler implements Runnable {
    /**
     * field a chassis.
     */
    private final CarQueue chassisQueue;
    /**
     * field a finish.
     */
    private final CarQueue finishQueue;
    /**
     * field a pool.
     */
    private final RobotPool pool;
    /**
     * field a barrier.
     */
    private final CyclicBarrier barrier;
    /**
     * field a car.
     */
    private Car car;

    /**
     * Constructor.
     *
     * @param aChassisQueue a chassis
     * @param aFinishQueue  a finish
     * @param aPool         a pool
     */
    Assembler(final CarQueue aChassisQueue,
              final CarQueue aFinishQueue,
              final RobotPool aPool) {
        this.chassisQueue = aChassisQueue;
        this.finishQueue = aFinishQueue;
        this.pool = aPool;
        final int parties = 4;
        this.barrier = new CyclicBarrier(parties);
    }

    /**
     * Method to get.
     *
     * @return a barrier
     */
    final CyclicBarrier getBarrier() {
        return this.barrier;
    }

    /**
     * Method to get.
     *
     * @return a car
     */
    final Car getCar() {
        return this.car;
    }

    @Override
    public final void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                this.car = this.chassisQueue.take();
                this.pool.hire(RobotEngine.class, this);
                this.pool.hire(RobotDriveTrain.class, this);
                this.pool.hire(RobotWheel.class, this);
                this.barrier.await();
                this.finishQueue.put(this.car);
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Assembler off ");
    }
}
