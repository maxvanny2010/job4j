package ua.driver.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.driver.models.Car;
import ua.driver.models.Driver;
import ua.driver.models.Engine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.Is.is;

/**
 * StoreDriverTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreDriverTest {
    private final Service service = Service.getInstance();
    private Engine v60;

    @Before
    public void setUp() {
        Engine v40 = new Engine("4.0");
        Engine v50 = new Engine("5.0");
        Engine v60 = new Engine("6.0");
        v40 = this.service.getEngine().getStore().save(v40);
        v50 = this.service.getEngine().getStore().save(v50);
        this.v60 = this.service.getEngine().getStore().save(v60);
        final Car bmw540 = new Car("bmw", "5", v40);
        final Car bmw750 = new Car("bmw", "7", v50);
        this.service.getCar().getStore().save(bmw540);
        this.service.getCar().getStore().save(bmw750);
    }

    @After
    public void tearDown() {
        this.service.getDriver().getStore().dropTable("owner");
        this.service.getDriver().getStore().dropTable("car");
        this.service.getDriver().getStore().dropTable("driver");
    }

    @Test
    public void driverSaveOK() {
        final List<Car> bmw = this.service.getCar().getByBrand("bmw");
        final Set<Car> cars = new HashSet<>(bmw);
        final Driver driver = new Driver("Max", cars);
        final Driver result = this.service.getCar().getStore().save(driver);
        final Driver expected = new Driver(result.getId(), "Max", cars);
        assertThat(expected, is(result));
    }

    @Test
    public void driverUpdateOK() {
        final List<Car> bmw = this.service.getCar().getByBrand("bmw");
        final Set<Car> cars = new HashSet<>(bmw);
        final Driver max = new Driver("Max", cars);
        final Driver driver = this.service.getCar().getStore().save(max);

        final Car mrc = new Car("mrc", "S", this.v60);
        final Car s600 = this.service.getCar().getStore().save(mrc);
        cars.add(s600);

        driver.getCars().add(s600);

        this.service.getCar().getStore().update(driver);
        final Driver result = this.service.getCar().getStore()
                .getById(driver.getId(), Driver.class);

        final Driver expected = new Driver(driver.getId(), "Max", cars);
        assertThat(result, is(expected));
    }

    @Test
    public void driverGetByName() {
        final List<Car> bmw = this.service.getCar().getByBrand("bmw");
        final Set<Car> cars = new HashSet<>(bmw);
        final Driver driver = new Driver("Max", cars);
        this.service.getCar().getStore().save(driver);
        final Driver result = this.service.getDriver().getDriverByName("Max");
        final Driver expected = new Driver(result.getId(), "Max", cars);
        assertThat(result, is(expected));
    }

    @Test
    public void driverGetCarsByDriverName() {
        final List<Car> bmw = this.service.getCar().getByBrand("bmw");
        final Set<Car> cars = new HashSet<>(bmw);
        final Driver max = new Driver("Max", cars);
        final Driver driver = this.service.getCar().getStore().save(max);

        final Car mrc = new Car("mrc", "S", this.v60);
        final Car s600 = this.service.getCar().getStore().save(mrc);

        cars.add(s600);
        driver.setCars(cars);
        this.service.getCar().getStore().update(driver);

        final List<Car> result = this.service.getDriver().getCarsByDriverName("Max");
        assertThat(result, containsInAnyOrder(bmw.get(1), bmw.get(0), mrc));
    }

}
