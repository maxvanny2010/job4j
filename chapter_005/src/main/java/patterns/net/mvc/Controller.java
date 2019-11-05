package patterns.net.mvc;

/**
 * Controller.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/31/2019
 */
class Controller {
    /**
     * field model.
     */
    private final Student model;
    /**
     * field view.
     */
    private final View view;

    /**
     * Constructor.
     *
     * @param sModel model
     * @param sView  view
     */
    Controller(final Student sModel, final View sView) {
        this.model = sModel;
        this.view = sView;
    }

    /**
     * Method set name.
     *
     * @param name name
     */
    final void setStudentName(final String name) {
        this.model.setName(name);
    }

    /**
     * Method get name.
     *
     * @return name
     */
    @SuppressWarnings("unused")
    final String getStudentName() {
        return this.model.getName();
    }

    /**
     * Method to set id.
     *
     * @param id id
     */
    final void setStudentId(final String id) {
        this.model.setId(id);
    }

    /**
     * Method to get id.
     *
     * @return id
     */
    @SuppressWarnings("unused")
    final String getStudentId() {
        return this.model.getId();
    }

    /**
     * Method update view.
     */
    final void updateView() {
        this.view.printStudentDetails(this.model.getName(), this.model.getId());
    }
}
