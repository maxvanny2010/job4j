package ua.annotation.view;

import ua.annotation.models.Car;
import ua.annotation.models.Driver;
import ua.annotation.models.Engine;
import ua.annotation.persistence.StoreBoss;

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
        final StoreBoss storeBoss = StoreBoss.getInstance();
        storeBoss.getDriver().getStore().dropTable("owner");
        storeBoss.getDriver().getStore().dropTable("engine");
        storeBoss.getDriver().getStore().dropTable("car");
        storeBoss.getDriver().getStore().dropTable("driver");
        Engine v40 = new Engine("4.0");
        Engine v50 = new Engine("5.0");
        Engine v60 = new Engine("6.0");
        v40 = storeBoss.getEngine().getStore().save(v40);
        v50 = storeBoss.getEngine().getStore().save(v50);
        v60 = storeBoss.getEngine().getStore().save(v60);
        Car bmw540 = new Car("bmw", "5", v40);
        Car bmw750 = new Car("bmw", "7", v50);
        Car s600 = new Car("mrc", "S", v60);
        storeBoss.getCar().getStore().save(bmw540);
        storeBoss.getCar().getStore().save(bmw750);
        storeBoss.getCar().getStore().save(s600);
        final List<Car> bmwA = storeBoss.getCar().getByBrand("bmw");
        s600.setModel("SL");
        storeBoss.getCar().getStore().update(s600);
        s600 = storeBoss.getCar().getStore().getById(s600.getId(), Car.class);
        final Set<Car> bmw = new HashSet<>(bmwA);
        final Driver max = new Driver("Max", bmw);
        storeBoss.getDriver().getStore().save(max);
        final Driver name = storeBoss.getDriver().getDriverByName("Max");
        final List<Car> carLst = storeBoss.getDriver()
                .getCarsByDriverName("Max");
        System.out.println(s600);
        carLst.forEach(System.out::println);
        System.out.println(name);
    }
}
