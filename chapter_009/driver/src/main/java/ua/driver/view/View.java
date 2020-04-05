package ua.driver.view;

import ua.driver.models.Car;
import ua.driver.models.Driver;
import ua.driver.models.Engine;
import ua.driver.services.StoreCar;
import ua.driver.services.StoreDriver;
import ua.driver.services.StoreEngine;

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
        final StoreEngine engine = new StoreEngine();
        final StoreCar car = new StoreCar();
        final StoreDriver drivers = new StoreDriver();
        drivers.getStore().dropTable("owner");
        drivers.getStore().dropTable("engine");
        drivers.getStore().dropTable("car");
        drivers.getStore().dropTable("driver");
        Engine v40 = new Engine("4.0");
        Engine v50 = new Engine("5.0");
        Engine v60 = new Engine("6.0");
        v40 = engine.getStore().save(v40);
        v50 = engine.getStore().save(v50);
        v60 = engine.getStore().save(v60);
        Car bmw540 = new Car("bmw", "5", v40);
        Car bmw750 = new Car("bmw", "7", v50);
        Car s600 = new Car("mrc", "S", v60);
        car.getStore().save(bmw540);
        car.getStore().save(bmw750);
        car.getStore().save(s600);
        final List<Car> bmwA = car.getByBrand("bmw");
        s600.setModel("SL");
        car.getStore().update(s600);
        s600 = car.getStore().getById(s600.getId(), Car.class);
        final Set<Car> bmw = new HashSet<>(bmwA);
        final Driver max = new Driver("Max", bmw);
        drivers.getStore().save(max);
        final Driver name = drivers.getDriverByName("Max");
        final List<Car> carLst = drivers.getCarsByDriverName("Max");
        System.out.println(s600);
        System.out.println(name);
        carLst.forEach(System.out::println);
    }
}
