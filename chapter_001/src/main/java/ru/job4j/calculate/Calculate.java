package ru.job4j.calculate;

/**
 * Calculate.
 * It prints string to console.
 *
 * @author Maxim Vanny
 */
public class Calculate {
    /**
     * Method main.
     * The point of enter to program.
     *
     * @param args - array String.
     */
    public static void main(final String[] args) {

        System.out.println("Hello World");
    }

    /**
     * Method echo.
     *
     * @param name Your name.
     * @return Echo plus your name.
     */
    public final String echo(final String name) {
        return "Echo, echo, echo : " + name;
    }
}
