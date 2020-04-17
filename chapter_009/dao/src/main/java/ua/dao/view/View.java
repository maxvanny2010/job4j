package ua.dao.view;

import ua.dao.models.Car;
import ua.dao.models.Driver;
import ua.dao.models.Engine;
import ua.dao.persistence.StoreCar;
import ua.dao.persistence.StoreDriver;
import ua.dao.persistence.StoreEngine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * View.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/5/2020
 */
public final class View {

    /**
     * Constructor.
     */
    private View() {
    }

    /**
     * Method to enter to program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final StoreDriver driver = new StoreDriver();
        final StoreEngine engine = new StoreEngine();
        final StoreCar car = new StoreCar();
        driver.dropTable("owner");
        driver.dropTable("engine");
        driver.dropTable("car");
        driver.dropTable("driver");
        Engine v40 = new Engine("4.0");
        Engine v50 = new Engine("5.0");
        Engine v60 = new Engine("6.0");
        v40 = engine.save(v40);
        v50 = engine.save(v50);
        v60 = engine.save(v60);
        Car bmw540 = new Car("bmw", "5", v40);
        Car bmw750 = new Car("bmw", "7", v50);
        Car s600 = new Car("mrc", "S", v60);
        car.save(bmw540);
        car.save(bmw750);
        car.save(s600);
        final List<Car> bmwA = car.getByBrand("bmw");
        s600.setModel("SL");
        car.update(s600);
        s600 = car.getById(s600.getId(), Car.class);
        final Set<Car> bmw = new HashSet<>(bmwA);
        final Driver max = new Driver("Max", bmw);
        driver.save(max);
        final Driver name = driver.getDriverByName("Max");
        final List<Car> carLst = driver.getCarsByDriverName("Max");
        System.out.println(s600);
        carLst.forEach(System.out::println);
        System.out.println(name);
    }
}
