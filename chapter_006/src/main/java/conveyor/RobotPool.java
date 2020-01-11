package conveyor;

import java.util.HashSet;
import java.util.Set;

/**
 * RobotPool.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
class RobotPool {
    /**
     * field a pool.
     */
    private final Set<Robot> pool = new HashSet<>();

    /**
     * Method to add a robot to pool.
     *
     * @param robot a robot
     */
    final synchronized void add(final Robot robot) {
        this.pool.add(robot);
        notifyAll();
    }

    /**
     * Method to start assembling a car.
     *
     * @param type      a type of part car
     * @param assembler a assembler
     * @throws InterruptedException InterruptedException
     */
    final synchronized void hire(final Class<? extends Robot> type,
                                 final Assembler assembler)
            throws InterruptedException {
        for (Robot robot : this.pool) {
            this.pool.remove(robot);
            robot.setAssembler(assembler);
            robot.doWork();
            return;
        }
        wait();
        hire(type, assembler);

    }

    /**
     * Method to add a robot to pool.
     *
     * @param aRobot a robot
     */
    final synchronized void release(final Robot aRobot) {
        this.add(aRobot);
    }
}
