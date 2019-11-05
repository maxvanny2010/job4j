package patterns.behavior.template;

/**
 * Template.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
abstract class Template {
    /**
     * Method to one.
     */
    abstract void stepOne();

    /**
     * Method to two.
     */
    abstract void stepTwo();

    /**
     * Method to three.
     */
    abstract void stepThree();

    /**
     * Method to run all step.
     */
    void run() {
        stepOne();
        stepTwo();
        stepThree();
    }
}
