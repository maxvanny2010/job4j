package patterns.behavior.template;

/**
 * TemplateJob.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
class TemplateBase extends Template {
    @Override
    final void stepOne() {
        System.out.println("step One base");
    }

    @Override
    final void stepTwo() {
        System.out.println("step Two base");
    }

    @Override
    final void stepThree() {
        System.out.println("step Three base");
    }
}
