package ua.driver.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.driver.models.Engine;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * StoreEngineTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/10/2020
 */
public class StoreEngineTest {
    private final Service service = Service.getInstance();
    private Engine v40;
    private Engine v50;

    @Before
    public void setUp() {
        this.v40 = new Engine("4.0");
        this.v50 = new Engine("5.0");
    }

    @After
    public void tearDown() {
        this.service.getEngine().getStore().dropTable("engine");
    }

    @Test
    public void engineSaveOK() {
        final Engine v40 = this.service.getEngine().getStore().save(this.v40);
        final Engine expected = new Engine(v40.getId(), "4.0");
        assertEquals(v40, expected);
    }

    @Test
    public void engineUpdateOK() {
        final Engine v40 = this.service.getEngine().getStore().save(this.v40);
        v40.setVolume("4.2");
        this.service.getEngine().getStore().update(v40);
        final Engine result = this.service.getEngine().getStore()
                .getById(v40.getId(), Engine.class);
        final Engine expected = new Engine(v40.getId(), "4.2");
        assertEquals(result, expected);
    }

    @Test
    public void engineGetByVolumeOK() {
        final Engine v50 = this.service.getEngine().getStore().save(this.v50);
        final Engine result = this.service.getEngine().getEngineByVolume("5.0");
        assertThat(result, is(v50));
    }

    @Test
    public void engineDeleteByVolumeOK() {
        final Engine v50 = this.service.getEngine().getStore().save(this.v50);
        this.service.getEngine().getStore().delete(v50);
    }

    @Test(expected = RuntimeException.class)
    public void engineDeleteByVolumeException() {
        this.service.getEngine().getStore().save(this.v50);
        this.service.getEngine().delete();
    }

}
