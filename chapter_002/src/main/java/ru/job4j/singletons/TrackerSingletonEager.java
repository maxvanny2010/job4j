package ru.job4j.singletons;

import ru.job4j.models.Item;

/**
 * TrackerSingletonEager.
 *
 * @author Maxim Vanny.
 * @version 2.0
 * @since 0.1
 */
public final class TrackerSingletonEager {
    /**
     * Create link to TrackSingletonEager object.
     */
    private static final TrackerSingletonEager INSTANCE =
            new TrackerSingletonEager();

    /**
     * Constructor.
     */
    private TrackerSingletonEager() {
    }

    /**
     * Method get final static link to object TSE.
     *
     * @return final static link.
     */
    public static TrackerSingletonEager getInstance() {
        return INSTANCE;
    }

    /**
     * Start program.
     *
     * @param args string.
     */
    public static void main(final String[] args) {
        @SuppressWarnings("unused")
        var tracker = TrackerSingletonEager.getInstance();
    }

    /**
     * Example method.
     *
     * @param model model.
     * @return model.
     */
    @SuppressWarnings("unused")
    public Item add(final Item model) {
        return model;
    }
}
