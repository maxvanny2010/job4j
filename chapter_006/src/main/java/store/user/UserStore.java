package store.user;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import store.exception.StoreException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/26/2019
 */
@ThreadSafe
class UserStore {
    /**
     * field store.
     */
    @GuardedBy("this")
    private final List<User> store = new ArrayList<>();

    /**
     * Getter.
     *
     * @return the list store
     */
    final synchronized List<User> getStore() {
        return this.store;
    }

    /**
     * Method to add into the store.
     *
     * @param user user
     * @return result
     */
    final synchronized boolean add(final User user) {
        Objects.requireNonNull(user, "must not be null");
        if (!this.store.contains(user)) {
            return this.store.add(user);
        }
        return false;
    }

    /**
     * Method to update in the store.
     *
     * @param user user
     * @return result
     */
    final synchronized boolean update(final User user) {
        Objects.requireNonNull(user, "must not be null");
        final int index = this.store.indexOf(user);
        if (index != -1) {
            this.store.set(index, user);
            return true;
        }
        return false;
    }

    /**
     * Method to delete in the store.
     *
     * @param user user
     * @return result
     */
    final synchronized boolean delete(final User user) {
        Objects.requireNonNull(user, "must not be null");
        return this.store.removeIf(u -> u.equals(user));
    }

    /**
     * Method to transfer amount between id users into the store.
     *
     * @param fromId from id
     * @param toId   to id
     * @param amount amount
     */
    final synchronized void transfer(final int fromId,
                                     final int toId,
                                     final int amount) {
        final int from = getUserIndexById(fromId);
        final int to = getUserIndexById(toId);
        final User scr = this.store.get(from);
        final User dst = this.store.get(to);
        if (scr.getAmount() < amount) {
            throw new StoreException("Transfer break.Money out.");
        }
        scr.minusAmount(amount);
        dst.plusAmount(amount);
        this.store.set(from, scr);
        this.store.set(to, dst);
    }

    /**
     * Method to get id users into the store.
     *
     * @param id id
     * @return id
     */
    private synchronized int getUserIndexById(final int id) {
        for (User user : this.store) {
            if (id == user.getId()) {
                return this.store.indexOf(user);
            }
        }
        throw new StoreException("Id " + id + " is absent.");
    }
}

