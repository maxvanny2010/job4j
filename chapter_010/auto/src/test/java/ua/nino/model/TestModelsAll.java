package ua.nino.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ua.nino.model.ads.AdsTest;
import ua.nino.model.auto.AutoTest;
import ua.nino.model.user.UserTest;

import java.util.function.Consumer;

/**
 * TestModelsAll.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/29/2020
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AdsTest.class,
        UserTest.class,
        AutoTest.class
})
public class TestModelsAll {

    public static void wrapper(final Consumer<Session> command) {
        final SessionFactory factory = new Configuration()
                .configure().buildSessionFactory();
        final Session session = factory.openSession();
        try {
            command.accept(session);
        } finally {
            session.getTransaction().rollback();
            session.close();
            factory.getCurrentSession().close();
        }
    }
}
