package patterns.structure.adapters.adaptertrack.carwash;

import patterns.structure.adapters.adaptertrack.cars.Cars;

/**
 * CarWash.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
class CarWash {
    /**
     * field a car.
     */
    private final Cars cars;

    /**
     * Constructor.
     *
     * @param aCars a car
     */
    CarWash(final Cars aCars) {
        this.cars = aCars;
    }

    /**
     * Method to wash a car.
     */
    final void washCar() {
        this.cars.wash();
    }
}
