package cafe;

import java.util.StringJoiner;

/**
 * Food.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/12/2020
 */
class Food {
    /**
     * field a composition.
     */
    private final String[] composition;

    /**
     * Constructor.
     *
     * @param aComposition composition
     */
    Food(final String[] aComposition) {
        this.composition = aComposition;
    }

    /**
     * Method to get.
     *
     * @return a composition from food menu
     */
    public final String[] getComposition() {
        return this.composition;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Food.class.getSimpleName() + "(", ")")
                .add(this.composition[0])
                .add(this.composition[1])
                .toString();
    }
}
