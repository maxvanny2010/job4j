package patterns.structure.adapters.adapterdb;

/**
 * AdapterDB.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
@SuppressWarnings("unused")
public class AdapterDB extends Application implements DataBase {
    @Override
    public final void insert() {
        this.insertObject();
    }

    @Override
    public final void update() {
        this.updateObject();
    }

    @Override
    public final void remove() {
        this.removeObject();
    }
}
