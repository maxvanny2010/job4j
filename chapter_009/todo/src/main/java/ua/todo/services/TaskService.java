package ua.todo.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.todo.models.Task;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * TaskService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/20/2020
 */
public class TaskService {
    /**
     * field a factory.
     */
    private static final SessionFactory FACTORY = new Configuration()
            .configure().buildSessionFactory();

    /**
     * field a service.
     */
    private static final TaskService SERVICE = new TaskService();

    /**
     * Constructor.
     */
    public TaskService() {
    }

    /**
     * Method to get.
     *
     * @return the task service
     */
    public static TaskService getInstance() {
        return SERVICE;
    }

    /**
     * Method to get.
     *
     * @return Db Store
     */
    public final SessionFactory getFactory() {
        return FACTORY;
    }

    /**
     * Method to apply command.
     *
     * @param command a command
     * @param <T>     a parameter
     * @return result
     */
    private <T> T wrappers(final Function<Session, T> command) {
        final Session session = this.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        try (session) {
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * Method wrapper for void function.
     *
     * @param command a command
     */
    private void wrapper(final Consumer<Session> command) {
        final Session session = this.getFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        try (session) {
            command.accept(session);
            transaction.commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    /**
     * Method to save a user to db.
     *
     * @param desc a desc
     * @return a task
     */
    public final Task addTask(final String desc) {
        final Task task = new Task();
        return this.wrappers(session -> {
            task.setDesc(desc);
            task.setCreated(String.valueOf(
                    new Timestamp(System.currentTimeMillis())));
            task.setDone("false");
            session.save(task);
            return task;
        });
    }

    /**
     * Method to get.
     *
     * @return a list of tasks
     */
    public final List<?> getAllTasks() {
        return this.wrappers(session -> session.createQuery(
                "FROM Task task").list());
    }

    /**
     * Method to get.
     *
     * @return a list of tasks
     */
    public final List<?> getNotDoneTasks() {
        return this.wrappers(session -> {
            final String sql = "FROM Task task WHERE done= :done";
            final Query<Task> query = session.createQuery(sql, Task.class);
            query.setParameter("done", "false");
            return query.getResultList();
        });
    }

    /**
     * Method to delete a task.
     *
     * @param id a id
     */
    public final void deleteTask(final int id) {
        this.wrapper(session -> {
            final String sql = "DELETE from Task task WHERE id= :id";
            final var query = session.createQuery(sql);
            query.setParameter("id", id);
            query.executeUpdate();
        });
    }

    /**
     * Method to delete a task.
     *
     * @param mark a mark
     * @param id   a id
     */
    public final void updateTask(final int id, final String mark) {
        this.wrapper(session -> {
            final String sql = "UPDATE Task task "
                    + "SET done = :mark WHERE id= :id";
            final var query = session.createQuery(sql);
            query.setParameter("id", id);
            query.setParameter("mark", mark);
            query.executeUpdate();
        });
    }

    /**
     * Method to get.
     *
     * @param id a id
     * @return a list of tasks
     */
    public final Task getTask(final int id) {
        try {
            return this.wrappers(session -> {
                final String sql = "FROM Task task WHERE id= :id";
                final Query<Task> query = session.createQuery(sql, Task.class);
                query.setParameter("id", id);
                return query.getSingleResult();
            });
        } catch (final Exception e) {
            return null;
        }
    }
}
