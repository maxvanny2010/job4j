package ua.driver.services;

/**
 * Service.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class Service {
    /**
     * field a service.
     */
    private static final Service SERVICE = new Service();
    /**
     * field a car.
     */
    private final StoreCar car = new StoreCar();
    /**
     * field a engine.
     */
    private final StoreEngine engine = new StoreEngine();
    /**
     * field a driver.
     */
    private final StoreDriver driver = new StoreDriver();

    /**
     * Method to get.
     *
     * @return service
     */
    public static Service getInstance() {
        return SERVICE;
    }

    /**
     * Method to get.
     *
     * @return a car
     */
    public final StoreCar getCar() {
        return this.car;
    }

    /**
     * Method to get.
     *
     * @return a engine
     */
    public final StoreEngine getEngine() {
        return this.engine;
    }

    /**
     * Method to get.
     *
     * @return a driver
     */
    public final StoreDriver getDriver() {
        return this.driver;
    }
}
