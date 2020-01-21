package storage.models;

/**
 * * Storage.
 * Item.
 *
 * @author Maxim Vanny.
 * @version 4.0
 * @since 0.1
 */
public class Item {
    /**
     * имя заявки.
     */
    private final String name;
    /**
     * описание заявки.
     */
    private final String description;
    /**
     * уникальный ключ заявки.
     */
    private String id;
    /**
     * создание заявки.
     */
    private long create;

    /**
     * констуртор заявки.
     *
     * @param aName   название заявки.
     * @param aDesc   описание заявки.
     * @param aCreate создание заявки.
     */
    public Item(final String aName, final String aDesc, final long aCreate) {
        this.name = aName;
        this.description = aDesc;
        this.create = aCreate;
    }

    /**
     * констуртор заявки.
     *
     * @param aName        название заявки.
     * @param aDescription описание заявки.
     */
    public Item(final String aName, final String aDescription) {
        this.name = aName;
        this.description = aDescription;
    }

    /**
     * получение имени заявки.
     *
     * @return возвращает имя заявки.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * получение описания заявки.
     *
     * @return возвращает описание заявки.
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * получение создания заявки.
     *
     * @return возращает создание заявки.
     */
    @SuppressWarnings("unused")
    public final long getCreate() {
        return this.create;
    }

    /**
     * устанавливает создание заявки.
     *
     * @param aCreate создание заявки.
     */
    @SuppressWarnings("unused")
    public final void setCreate(final long aCreate) {
        this.create = aCreate;
    }

    /**
     * получение уникального ключа заявки.
     *
     * @return уникальный ключ заявки.
     */
    public final String getId() {
        return id;
    }

    /**
     * устанавливает уникальный ключ для заявки.
     *
     * @param aId уникальный ключ заявки.
     */
    public final void setId(final String aId) {
        this.id = aId;
    }

    /**
     * Method toString.
     *
     * @return string mapping object
     */
    @Override
    public final String toString() {
        return '\n'
                + "Заявка: id '"
                + id
                + "', name='"
                + name
                + "', description='"
                + description
                + "'";
    }
}
