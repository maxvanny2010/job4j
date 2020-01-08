package cash;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Cash.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/1/2020
 */
class Cashes {
    /**
     * field map.
     */
    private final Map<Integer, Base> map = new ConcurrentHashMap<>();

    /**
     * Method to add.
     *
     * @param model model
     * @return result
     */
    final Base add(final Base model) {
        return this.map.putIfAbsent(model.getId(), model);
    }

    /**
     * Method to update.
     *
     * @param model model
     */
    final void update(final Base model) {
        this.map.computeIfPresent(model.getId(), (k, v) -> {
            if (v.getVersion() != model.getVersion()) {
                throw new OptimisticException();
            }
            model.changeVersion();
            return model;
        });
    }

    /**
     * Method to delete.
     *
     * @param model model
     * @return result
     */
    final Base delete(final Base model) {
        return this.map.remove(model.getId());
    }

    /**
     * Method to get.
     *
     * @return a size
     */
    final int size() {
        return this.map.size();
    }

    /**
     * Method to get.
     *
     * @param key key
     * @return model
     */
    final Base get(final int key) {
        return this.map.get(key);
    }
}
