package di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Store.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Component
public class Store {
    /**
     * field a data.
     */
    private final List<String> data = new ArrayList<>();

    /**
     * Method to add.
     *
     * @param value value
     */
    public final void add(final String value) {
        this.data.add(value);
    }

    /**
     * Method to get.
     *
     * @return list of data
     */
    public final List<String> getAll() {
        return this.data;
    }
}
