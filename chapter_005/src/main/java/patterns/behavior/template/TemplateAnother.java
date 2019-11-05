package patterns.behavior.template;

/**
 * TemplateAnother.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/30/2019
 */
class TemplateAnother extends Template {
    @Override
    final void stepOne() {
        System.out.println("step One another");
    }

    @Override
    final void stepTwo() {
        System.out.println("step Two another");
    }

    @Override
    final void stepThree() {
        System.out.println("step Three another");
    }
}
