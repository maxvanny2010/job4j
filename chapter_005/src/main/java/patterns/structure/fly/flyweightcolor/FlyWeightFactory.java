package patterns.structure.fly.flyweightcolor;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyWeightFactory.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
class FlyWeightFactory {
    /**
     * field map.
     */
    private final Map<String, Circle> map = new HashMap<>();

    /**
     * Method to get circle with a color.
     *
     * @param color color
     * @return the circle with a color
     */
    final Circle getCircle(final String color) {
        Circle circle = this.map.get(color);
        if (circle == null) {
            circle = new Circle(color);
            this.map.put(color, circle);
        }
        return circle;
    }
}
