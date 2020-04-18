package ua.autos.model.auto;

import org.junit.Assert;
import org.junit.Test;

import static ua.autos.logic.action.ActionAbs.getAuto;
import static ua.autos.model.TestModelsAll.wrapper;

/**
 * AutoTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/29/2020
 */
public class AutoTest {

    @Test
    public void whenSaveAutoOk() {
        wrapper(session -> {
            final Brands brand = new Brands("bmw");
            final Models aModel = new Models("5");
            final Engines aVolume = new Engines("4.0");
            final Colors red = new Colors("red");
            final Years aYear = new Years("2020");
            final Auto bmw = new Auto(brand, aModel, aVolume, red, aYear);
            final int id = getAuto().save(bmw);
            final Auto result = getAuto().getById(id);
            final Auto expected = new Auto(brand, aModel, aVolume, red, aYear);
            expected.setId(id);
            Assert.assertEquals(expected, result);
        });
    }

}
