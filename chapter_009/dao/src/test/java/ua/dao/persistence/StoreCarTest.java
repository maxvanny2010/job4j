package ua.dao.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.dao.models.Car;
import ua.dao.models.Engine;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * StoreCarTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreCarTest {
    private final StoreCar car = new StoreCar();
    private final StoreEngine engine = new StoreEngine();
    private Engine v40;
    private Engine v60;
    private Car bmw540;
    private Car bmw750;

    @Before
    public void setUp() {
        Engine v40 = new Engine("4.0");
        Engine v50 = new Engine("5.0");
        Engine v60 = new Engine("6.0");
        this.v40 = this.engine.save(v40);
        final Engine v501 = this.engine.save(v50);
        this.v60 = this.engine.save(v60);
        final Car bmw540 = new Car("bmw", "5", this.v40);
        final Car bmw750 = new Car("bmw", "7", v501);
        this.bmw540 = this.car.save(bmw540);
        this.bmw750 = this.car.save(bmw750);
    }

    @After
    public void tearDown() {
        this.car.dropTable("car");
    }

    @Test
    public void carSaveOK() {
        final Car mrc = new Car("mrc", "S", this.v60);
        final Car result = this.car.save(mrc);
        final Car expected = new Car(
                result.getId(), "mrc", "S", this.v60);
        assertEquals(result, expected);
    }

    @Test
    public void carUpdateOK() {
        final Car mrc = new Car("mrc", "S", this.v60);
        final Car s600 = this.car.save(mrc);
        s600.setModel("SL");
        this.car.update(s600);
        final Car result = this.car.getById(s600.getId(), Car.class);
        final Car expected = new Car(
                s600.getId(), "mrc", "SL", this.v60);
        assertEquals(result, expected);
    }

    @Test
    public void carDeleteOK() {
        final Car mrc = new Car("mrc", "S", this.v60);
        final Car s600 = this.car.save(mrc);
        this.car.delete(s600);
        final Car result = this.car.getById(s600.getId(), Car.class);
        assertNull(result);
    }

    @Test
    public void carGetByIdOK() {
        final Car result = this.car.getById(this.bmw540.getId(), Car.class);
        final Car expected = new Car(result.getId(), "bmw", "5", this.v40);
        assertEquals(result, expected);
    }

    @Test
    public void carCarByIdNO() {
        final Car result = this.car.getById(100, Car.class);
        assertNull(result);
    }

    @Test
    public void carGetCarsByBrandOK() {
        final List<Car> result = this.car.getByBrand("bmw");
        final List<Car> expected = new ArrayList<>();
        expected.add(this.bmw540);
        expected.add(this.bmw750);
        assertThat(result.toString(), is(expected.toString()));
    }
}

