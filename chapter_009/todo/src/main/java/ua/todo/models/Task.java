package ua.todo.models;

import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/13/2020
 */
public class Task {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a login.
     */
    private String desc;
    /**
     * field a password.
     */
    private String done;
    /**
     * field a time.
     */
    private String created;

    /**
     * Constructor.
     */
    public Task() {
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a id
     **/
    public final void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a description
     */
    public final String getDesc() {
        return this.desc;
    }

    /**
     * Method to set.
     *
     * @param aDesc a description
     **/
    public final void setDesc(final String aDesc) {
        this.desc = aDesc;
    }

    /**
     * Method to get.
     *
     * @return a result done
     */
    public final String getDone() {
        return this.done;
    }

    /**
     * Method to set.
     *
     * @param aDone a done
     **/
    public final void setDone(final String aDone) {
        this.done = aDone;
    }

    /**
     * Method to get.
     *
     * @return a created
     */
    public final String getCreated() {
        return this.created;
    }

    /**
     * Method to set.
     *
     * @param aCreated a created
     **/
    public final void setCreated(final String aCreated) {
        this.created = aCreated;
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                "{", "}")
                .add("\"id\":\"" + this.id + "\" ")
                .add("\"created\":\"" + this.created + "\" ")
                .add("\"desc\":\"" + this.desc + "\" ")
                .add("\"done\":\"" + this.done + "\" ")
                .toString();
    }
}
