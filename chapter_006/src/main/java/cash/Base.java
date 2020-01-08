package cash;

import java.util.StringJoiner;

/**
 * Base.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/1/2020
 */
class Base {
    /**
     * field id.
     */
    private final int id;
    /**
     * field name.
     */
    private String name;
    /**
     * field version.
     */
    private int version;

    /**
     * Constructor.
     *
     * @param aName name
     */
    Base(final String aName) {
        this.id = Atomic.getAtomicInteger().getAndIncrement();
        this.name = aName;
    }

    /**
     * Constructor.
     *
     * @param aId      id
     * @param aVersion version
     * @param aName    name
     */
    Base(final int aId, final int aVersion, final String aName) {
        this.id = aId;
        this.name = aName;
        this.version = aVersion;
    }

    /**
     * Method to get.
     *
     * @return id
     */
    final int getId() {
        return this.id;
    }

    /**
     * Method to get.
     *
     * @return name
     */
    final String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName name
     */
    final void setName(final String aName) {
        this.name = aName;
    }

    /**
     * Method to get.
     *
     * @return version
     */
    final int getVersion() {
        return this.version;
    }

    /**
     * Method to set version.
     */
    final void changeVersion() {
        this.version++;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Base.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("version=" + version)
                .toString();
    }
}
