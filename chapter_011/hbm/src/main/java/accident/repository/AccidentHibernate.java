package accident.repository;

import accident.model.Accident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccidentHibernate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Repository
public class AccidentHibernate implements IRepository<Accident> {
    /**
     * field a factory.
     */
    private final SessionFactory factory;

    /**
     * Constructor.
     *
     * @param aFactory a jdbc
     */
    public AccidentHibernate(final SessionFactory aFactory) {
        this.factory = aFactory;
    }

    @Override
    public final Accident save(final Accident accident) {
        try (final Session session = this.factory.openSession()) {
            session.save(accident);
            return accident;
        }
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident update(final Accident accident) {
        try (final Session session = this.factory.openSession()) {
            session.update(accident);
            return accident;
        }
    }

    @Override
    public final Accident delete(final Accident accident) {
        try (final Session session = this.factory.openSession()) {
            session.delete(accident);
            return accident;
        }
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident get(final int id) {
        try (Session session = this.factory.openSession()) {
            return session.get(Accident.class, id);
        }
    }

    @Override
    public final List<Accident> getAll() {
        try (Session session = this.factory.openSession()) {
            return session
                    .createQuery("FROM Accident", Accident.class)
                    .list();
        }
    }
}
