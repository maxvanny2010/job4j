package di;

import org.springframework.stereotype.Component;

/**
 * StartUI.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Component
public class StartUI {
    /**
     * field a store.
     */
    private final Store store;

    /**
     * Constructor.
     *
     * @param aStore a store
     */
    public StartUI(final Store aStore) {
        this.store = aStore;
    }

    /**
     * Method to add.
     *
     * @param value value
     */
    public final void add(final String value) {
        store.add(value);
    }

    /**
     * Method to print.
     */
    public final void print() {
        store.getAll().forEach(System.out::println);
    }
}
