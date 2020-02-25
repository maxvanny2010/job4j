package web.persistent;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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
    public Optional<User> findById(final int id) {
        return Optional.ofNullable(
                this.storage.getOrDefault(id, null));
    }

    @Override
    public boolean isLogin(final String login) {
        return this.storage.values().stream()
                .anyMatch(u -> u.getLogin().equals(login));
    }

    @Override
    public Optional<User> findUserBy(final String login,
                                     final String password) {
        return this.storage.values().stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> u.getPassword().equals(password))
                .findFirst();
    }

    @Override
    public int findIdBy(final String login, final String password) {
        return this.storage.values().stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> u.getPassword().equals(password))
                .mapToInt(User::getId)
                .findFirst().orElse(-1);
    }

    @Override
    public void clearStore() {
        this.storage.clear();
        ATOMIC_INTEGER.set(0);
    }
}
