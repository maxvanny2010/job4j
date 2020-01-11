package conveyor;

import java.util.concurrent.BrokenBarrierException;

/**
 * Robot.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
abstract class Robot implements Runnable {
    /**
     * field a pool.
     */
    private final RobotPool pool;
    /**
     * field a assembler.
     */
    private Assembler assembler;
    /**
     * field a work.
     */
    private boolean work = false;

    /**
     * Constructor.
     *
     * @param aPool a pool
     */
    Robot(final RobotPool aPool) {
        this.pool = aPool;
    }

    /**
     * Method to get.
     *
     * @return a assembler
     */
    final Assembler getAssembler() {
        return this.assembler;
    }

    /**
     * Method to set.
     *
     * @param aAssembler aAssembler
     **/

    final void setAssembler(final Assembler aAssembler) {
        this.assembler = aAssembler;
    }

    /**
     * Method to set do work true.
     **/

    final synchronized void doWork() {
        this.work = true;
        notifyAll();
    }

    /**
     * Method abstract do work for each part of the car.
     */
    abstract void performService();

    /**
     * Method to set power by null and waiting a signal for a work.
     *
     * @throws InterruptedException InterruptedException
     */
    final synchronized void powerDown() throws InterruptedException {
        this.work = false;
        this.assembler = null;
        this.pool.release(this);
        while (!this.work) {
            wait();
        }
    }

    @Override
    public final void run() {
        try {
            this.powerDown();
            while (!Thread.currentThread().isInterrupted()) {
                this.performService();
                this.assembler.getBarrier().await();
                this.powerDown();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(this + " off");
    }

    @Override
    public final String toString() {
        return getClass().getName();
    }
}
