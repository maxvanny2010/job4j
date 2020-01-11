package conveyor;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.StringJoiner;

/**
 * Car.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/11/2020
 */
@ThreadSafe
class Car {
    /**
     * field a id.
     */
    private final int id;
    /**
     * field a engine.
     */
    @GuardedBy("this")
    private boolean engine = false;
    /**
     * field a train.
     */
    @GuardedBy("this")
    private boolean train = false;
    /**
     * field a wheel.
     */
    @GuardedBy("this")
    private boolean wheels = false;

    /**
     * Constructor.
     *
     * @param aId a id
     */
    Car(final int aId) {
        this.id = aId;
    }

    /**
     * Method to add a engine.
     */
    final synchronized void addEngine() {
        this.engine = true;
    }

    /**
     * Method to add a train.
     */
    final synchronized void addDriveTrain() {
        this.train = true;
    }

    /**
     * Method to add a wheels.
     */
    final synchronized void addWheels() {
        this.wheels = true;
    }

    @Override
    public final synchronized String toString() {
        return new StringJoiner(", ",
                Car.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("engine=" + this.engine)
                .add("train=" + this.train)
                .add("wheels=" + this.wheels)
                .toString();
    }
}
