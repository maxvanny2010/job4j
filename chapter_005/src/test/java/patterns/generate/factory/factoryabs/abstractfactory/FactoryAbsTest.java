package patterns.generate.factory.factoryabs.abstractfactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import patterns.generate.factory.factoryabs.adidas.AdidasProduct;
import patterns.generate.factory.factoryabs.nike.NikeProduct;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactoryAbsTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/25/2019
 */
public class FactoryAbsTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private FactoryAbs adidas;
    private FactoryAbs nike;

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void whenAfter() {
        System.setOut(System.out);
    }


    @Test
    public void whenFactoryGetFactoryAdidas() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        System.out.print(Objects.requireNonNull(this.adidas).toString());
        assertThat(this.bos.toString(), is("AdidasFactory"));
    }

    @Test
    public void whenFactoryGetFactoryNike() {
        this.nike = FactoryGenerator.getFactory("nike");
        System.out.print(Objects.requireNonNull(this.nike).toString());
        assertThat(this.bos.toString(), is("NikeFactory"));
    }

    @Test
    public void whenFactoryGetFactoryAdidasProductOutWear() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        final AdidasProduct adidas_wear = Objects.requireNonNull(this.adidas).getAdidasProduct("adidas outwear");
        System.out.print(adidas_wear.toString());
        assertThat(this.bos.toString(), is("AdidasOutWear"));
    }

    @Test
    public void whenFactoryGetFactoryAdidasProductCaps() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        final AdidasProduct adidas_caps = Objects.requireNonNull(this.adidas).getAdidasProduct("adidas caps");
        System.out.print(adidas_caps.toString());
        assertThat(this.bos.toString(), is("AdidasNull"));
    }


    @Test
    public void whenFactoryGetFactoryAdidasProductShoes() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        final AdidasProduct adidas_shoes = Objects.requireNonNull(this.adidas).getAdidasProduct("adidas shoes");
        System.out.print(adidas_shoes.toString());
        assertThat(this.bos.toString(), is("AdidasShoes"));
    }

    @Test
    public void whenFactoryGetFactoryNikeProductCaps() {
        this.nike = FactoryGenerator.getFactory("nike");
        final NikeProduct nike_caps = Objects.requireNonNull(this.nike).getNikeProduct("nike caps");
        System.out.print(nike_caps.toString());
        assertThat(this.bos.toString(), is("NikeNull"));
    }

    @Test
    public void whenFactoryGetFactoryNikeProductShoes() {
        this.nike = FactoryGenerator.getFactory("nike");
        final NikeProduct nike_shoes = Objects.requireNonNull(this.nike).getNikeProduct("nike shoes");
        System.out.print(nike_shoes.toString());
        assertThat(this.bos.toString(), is("NikeShoes"));
    }

    @Test
    public void whenFactoryGetFactoryNikeProductOutWear() {
        this.nike = FactoryGenerator.getFactory("nike");
        final NikeProduct nike_wear = Objects.requireNonNull(this.nike).getNikeProduct("nike outwear");
        System.out.print(nike_wear.toString());
        assertThat(this.bos.toString(), is("NikeOutWear"));
    }

    @Test
    public void whenFactoryGetAdidasProductMakeOutWear() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        final AdidasProduct adidas_wear = Objects.requireNonNull(this.adidas).getAdidasProduct("adidas outwear");
        System.out.print(adidas_wear.makeAdidasProduct());
        assertThat(this.bos.toString(), is("adidas outwear"));
    }

    @Test
    public void whenFactoryGetAdidasProductMakeShoes() {
        this.adidas = FactoryGenerator.getFactory("adidas");
        final AdidasProduct adidas_shoes = Objects.requireNonNull(this.adidas).getAdidasProduct("adidas shoes");
        System.out.print(adidas_shoes.makeAdidasProduct());
        assertThat(this.bos.toString(), is("adidas shoes"));
    }

    @Test
    public void whenFactoryGetNikeProductMakeShoes() {
        this.nike = FactoryGenerator.getFactory("nike");
        final NikeProduct nike_shoes = Objects.requireNonNull(this.nike).getNikeProduct("nike shoes");
        System.out.print(nike_shoes.makeNikeProduct());
        assertThat(this.bos.toString(), is("nike shoes"));
    }

    @Test
    public void whenFactoryGetNikeProductMakeOutWear() {
        this.nike = FactoryGenerator.getFactory("nike");
        final NikeProduct nike_outwear = Objects.requireNonNull(this.nike).getNikeProduct("nike outwear");
        System.out.print(nike_outwear.makeNikeProduct());
        assertThat(this.bos.toString(), is("nike outwear"));
    }

}
