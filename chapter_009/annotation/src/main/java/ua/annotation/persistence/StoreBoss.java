package ua.annotation.persistence;

/**
 * Service.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreBoss {
    /**
     * field a service.
     */
    private static final StoreBoss STORE_BOSS = new StoreBoss();
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
    public static StoreBoss getInstance() {
        return STORE_BOSS;
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
