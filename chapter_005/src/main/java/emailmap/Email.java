package emailmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Email.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/28/2019
 */
public class Email {
    /**
     * field checks result of events.
     */
    private static boolean checks = false;
    /**
     * field map.
     */
    private final ConcurrentHashMap<String, Set<String>> map =
            new ConcurrentHashMap<>();

    /**
     * Method to put data at Map.
     *
     * @param key  a key map
     * @param list a value map
     */
    final void addToMap(final String key, final Set<String> list) {
        this.map.put(key, list);
    }

    /**
     * Method to get the Map.
     *
     * @return the Map
     */
    public final ConcurrentHashMap<String, Set<String>> getMap() {
        return this.map;
    }

    /**
     * Method to print data from the Map.
     * @param maps maps
     */
    final void infoMap(
            final ConcurrentHashMap<String, Set<String>> maps) {
        maps.forEach((key, value) -> System.out.printf("%s: %s\n", key, value));
    }

    /**
     * Method to get a clear result emails and users from the Map.
     *
     */
    final void clearEmails() {
        Iterator<Map.Entry<String, Set<String>>> outIter;
        Iterator<Map.Entry<String, Set<String>>> inIter;
        outIter = this.getMap().entrySet().iterator();
        while (outIter.hasNext()) {
            isRemove(outIter);
            final var next = outIter.next();
            final var key = next.getKey();
            final var value = next.getValue();
            inIter = this.getMap().entrySet().iterator();
            while (inIter.hasNext() && !checks) {
                final var nextTwo = inIter.next();
                final var keyTwo = nextTwo.getKey();
                final var valueTwo = nextTwo.getValue();
                if (!key.equals(keyTwo)) {
                    isCleanResult(value, keyTwo, valueTwo);
                }
            }
        }
    }

    /**
     * Method to remove a full users from the Map.
     *
     * @param iter1 a inner iterator
     */
    private void isRemove(
            final Iterator<Map.Entry<String, Set<String>>> iter1) {
        if (checks) {
            iter1.remove();
            checks = false;
        }
    }

    /**
     * Method id a decomposition ClearResult and find the same email in the Map.
     *
     * @param value    set from the Map
     * @param keyTwo   key from the Map
     * @param valueTwo value from the Map
     */
    private void isCleanResult(final Set<String> value,
                               final String keyTwo,
                               final Set<String> valueTwo) {

        final var first = value.stream()
                .filter(valueTwo::contains).findFirst();
        if (first.isPresent()) {
            valueTwo.addAll(value);
            this.addToMap(keyTwo, valueTwo);
            checks = true;
        }
    }
}





