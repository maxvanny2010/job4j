package patterns.behavior.state.statewater;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * WaterTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/23/2019
 */
public class WaterStateTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Water water = new Water();

    private final WaterLiquid liquid = new WaterLiquid();
    private final WaterSolid solid = new WaterSolid();
    private final WaterVapor vapor = new WaterVapor();


    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenWaterStateIsLiquid() {
        this.liquid.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("water is liquid")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenWaterStateIsSolid() {
        this.solid.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("water is solid")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenWaterStateIsVapor() {
        this.vapor.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("water is vapor")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenWaterStateIsVaporEnum() {
        WaterStates.VAPOR_STATE.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("VAPOR_STATE")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenWaterStateIsSolidEnum() {
        WaterStates.SOLID_STATE.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("SOLID_STATE")
                .append(System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenWaterStateIsLiquidEnum() {
        WaterStates.LIQUID_STATE.changeState(this.water);
        System.out.println(this.water.getState().toString());
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("LIQUID_STATE")
                .append(System.lineSeparator())
                .toString()
        ));
    }

}
