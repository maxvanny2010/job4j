package store.user;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 12/26/2019
 */
class User {

    /**
     * field id.
     */
    private final int id;

    /**
     * field amount.
     */
    private int amount;

    /**
     * Constructor.
     *
     * @param aAmount amount
     */
    User(final int aAmount) {
        this.amount = aAmount;
        this.id = Atomic.ATOMIC_INTEGER.getAndIncrement();
    }

    /**
     * Getter.
     *
     * @return id
     */
    final int getId() {
        return id;
    }

    /**
     * Getter.
     *
     * @return amount
     */
    final int getAmount() {
        return this.amount;
    }

    /**
     * Setter plus aAmount.
     *
     * @param aAmount amount
     */
    final void plusAmount(final int aAmount) {
        this.amount += aAmount;
    }

    /**
     * Setter minus aAmount.
     *
     * @param aAmount amount
     */
    final void minusAmount(final int aAmount) {
        this.amount -= aAmount;
    }
}
