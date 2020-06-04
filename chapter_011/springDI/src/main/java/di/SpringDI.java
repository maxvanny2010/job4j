package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * SpringDI.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
public final class SpringDI {
    /**
     * Constructor.
     */
    private SpringDI() {
    }

    /**
     * Method to point into program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.scan("di");
        context.refresh();
        final StartUI ui = context.getBean(StartUI.class);
        ui.add("2091 #205776");
        ui.add("2092 #205776");
        ui.print();
    }
}
