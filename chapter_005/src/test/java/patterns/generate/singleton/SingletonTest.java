package patterns.generate.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SingletonTest.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/26/2019
 */
public class SingletonTest {
    /*  private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

      @Before
      public void setBefore() {
          System.setOut(new PrintStream(this.bos));
      }

      @After
      public void whenAfter() {
          System.setOut(System.out);
      }
  */
    @Test
    public void whenSingletonGet25() throws InterruptedException {
        final Thread firstSingleton = new Thread(new FirstSingletonThread());
        final Thread secondSingleton = new Thread(new SecondSingletonThread());

        firstSingleton.start();
        firstSingleton.join();
        secondSingleton.start();
        secondSingleton.join();
        assertThat("another text", is("another text"));
    }

    private class FirstSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Some text");
            System.out.println(singleton.getValue());
        }
    }

    private class SecondSingletonThread implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("another text");
            System.out.println(singleton.getValue());
        }
    }
}
