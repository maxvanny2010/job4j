package patterns.structure.fly.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * FlyWeight.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/14/2019
 */
class FlyWeight {
    /**
     * field map.
     */
    private final Map<String, Mercedes> map = new HashMap<>();

    /**
     * Method to get mercedes.
     *
     * @param color color
     * @return the mercedes with a color.
     */
    final Mercedes getMercedes(final String color) {
        Mercedes mercedes = map.get(color);
        if (mercedes == null) {
            mercedes = new Mercedes();
            mercedes.setColor(color);
            this.map.put(color, mercedes);
        }
        return mercedes;
    }
}
