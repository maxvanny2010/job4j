package web.persistent;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import static web.model.Atomic.ATOMIC_INTEGER;

/**
 * Storage.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public final class StoreMemory implements Store<User> {
    /**
     * field a instance of StoreMemory.
     */
    private static final StoreMemory STORE_MEMORY = new StoreMemory();
    /**
     * field a storage.
     */
    private final Map<Integer, User> storage;

    /**
     * Constructor.
     */
    private StoreMemory() {
        this.storage = new ConcurrentHashMap<>();
    }

    /**
     * Method to get.
     *
     * @return the instance of StoreMemory
     */
    @SuppressWarnings("unused")
    public static StoreMemory getInstance() {
        return STORE_MEMORY;
    }

    @Override
    public void add(final User user) {
        Objects.requireNonNull(user, "must not be null");
        this.storage.putIfAbsent(user.getId(), user);
    }

    @Override
    public void update(final User user) {
        Objects.requireNonNull(user, "must not be null");
        this.storage.computeIfPresent(user.getId(), (k, v) -> v = user);
    }

    @Override
    public void delete(final User user) {
        Objects.requireNonNull(user, "must not be null");
        this.storage.remove(user.getId());
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.storage.values());
    }

    @Override
    public User findById(final int id) {
        return this.storage.getOrDefault(id, null);
    }

    @Override
    public void clearStore() {
        this.storage.clear();
        ATOMIC_INTEGER.set(0);
    }
}
