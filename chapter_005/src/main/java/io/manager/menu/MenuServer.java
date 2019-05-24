package io.manager.menu;

import io.manager.assembly.Assembling;
import io.manager.assembly.Assembly;

import java.io.IOException;
import java.net.Socket;

/**
 * ServerMenu.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/25/2019
 */
public class MenuServer extends Menus {
    /**
     * field assembly input and output.
     */
    private final Assembly assembly = new Assembling();

    /**
     * Method set output.
     *
     * @param socket socket
     * @throws IOException io exception
     */
    private void setOut(final Socket socket) throws IOException {
        this.assembly.setOutputWriter(socket);
    }

    /**
     * Method set input.
     *
     * @param socket socket
     * @throws IOException io exception
     */
    private void setIn(final Socket socket) throws IOException {
        this.assembly.setInputReader(socket);
    }


    @Override
    public final String in() throws IOException {
        return this.assembly.inInputReader();
    }

    @Override
    public final void out(final String answer) throws IOException {
        this.assembly.outOutputWriter(answer);
    }

    @Override
    public final void print(final String line) {
        System.out.println(line);
    }

    @Override
    public final void connect(final Socket aSocket) {
        try {
            setIn(aSocket);
            setOut(aSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
