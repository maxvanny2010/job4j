package patterns.generate.builder.sportcarbuilder;

/**
 * SportCar.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public final class SportCar {

    /**
     * field name.
     */
    private final String name;
    /**
     * field color.
     */
    private final String color;
    /**
     * field speed.
     */
    private final int maxSpeed;

    /**
     * Constructor.
     *
     * @param builder the builder
     */
    private SportCar(final Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    /**
     * Getter.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     *
     * @return color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Getter.
     *
     * @return speed
     */
    int getMaxSpeed() {
        return this.maxSpeed;
    }

    /**
     * Builder.
     *
     * @author Maxim Vanny
     * @version 5.0
     * @since 10/28/2019
     */
    static class Builder {
        /**
         * field name.
         */
        private final String name;
        /**
         * field color.
         */
        private String color;
        /**
         * field speed.
         */
        private int maxSpeed;

        /**
         * Constructor.
         *
         * @param aName the name
         */
        Builder(final String aName) {
            this.name = aName;
        }

        /**
         * Setter.
         *
         * @param aColor the color
         * @return this
         */
        public final Builder setColor(final String aColor) {
            this.color = aColor;
            return this;
        }

        /**
         * Setter.
         *
         * @param aMaxSpeed the speed
         * @return this
         */
        final Builder setMaxSpeed(final int aMaxSpeed) {
            this.maxSpeed = aMaxSpeed;
            return this;
        }

        /**
         * Setter.
         *
         * @return sport car with this
         */
        final SportCar build() {
            return new SportCar(this);
        }

    }
}
