package actors;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Actors.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/16/2020
 */
final class Actors {
    /**
     * field a increment.
     */
    public static final float INCREMENT = 0.2f;

    /**
     * Constructor.
     */
    private Actors() {
    }

    /**
     * Method a point to enter the program.
     *
     * @param args args
     **/
    public static void main(final String[] args) {
        final ActiveObject demo = new ActiveObject();
        final List<Future<?>> result = new CopyOnWriteArrayList<>();
        for (float f = 0.0f; f < 1.0f; f += INCREMENT) {
            result.add(demo.calculateFloat(f, f));
        }
        final int length = 5;
        IntStream.range(0, length)
                .forEach(i -> result.add(demo.calculateInt(i, i)));
        while (result.size() > 0) {
            for (Future<?> f : result) {
                if (f.isDone()) {
                    try {
                        System.out.println(f.get());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    result.remove(f);
                }
            }
        }
        demo.shutdown();
    }
}
