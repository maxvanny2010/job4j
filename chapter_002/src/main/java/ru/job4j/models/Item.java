package ru.job4j.models;

/**
 * Item.
 *
 * @author Maxim Vanny.
 * @version 2.0
 * @since 0.1
 */
public class Item {
    /**
     * уникальный ключ заявки.
     */
    private String id;
    /**
     * имя заявки.
     */
    public String name;
    /**
     * описание заявки.
     */
    public String description;
    /**
     * создание заявки.
     */
    public long create;

    /**
     * констуртор заявки.
     *
     * @param name        название заявки.
     * @param description описание заявки.
     * @param create      создание заявки.
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * получение имени заявки.
     *
     * @return возвращает имя заявки.
     */
    public String getName() {
        return this.name;
    }

    /**
     * получение описания заявки.
     *
     * @return возвращает описание заявки.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * получение создания заявки.
     *
     * @return возращает создание заявки
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * устанавливает создание заявки.
     *
     * @param create создание заявки.
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * устанавливает уникальный ключ для заявки
     *
     * @param id уникальный ключ заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * получение уникального ключа заявки.
     *
     * @return уникальный ключ заявки
     */
    public String getId() {
        return id;
    }
}