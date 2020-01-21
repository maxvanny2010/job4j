package io.socket;

import com.google.common.base.Joiner;
import io.socket.connect.SocketServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SocketServerTest {
    public static final String LN = System.getProperty("line.separator");
    final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    @Before
    public void setBefore() {
        System.setOut(new PrintStream(this.bos));
    }

    @After
    public void setAfter() {
        System.setOut(System.out);
    }

    public void testServer(final String input, final String expected) throws IOException {
        final Socket socket = mock(Socket.class);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);
        final SocketServer server = new SocketServer(socket);
        server.startServer();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenClientAnswerThenChooseRandom() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenClientHelloThenBackGreatOracle() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "Hello Oracle",
                        "exit"
                ),
                String.format("Hello, dear friend, I'm a Oracle.%s", LN)
        );
    }

    @Test
    public void whenClientAnyThenBackDontUnderstand() throws IOException {
        this.testServer(
                Joiner.on(LN).join("be or not to be?", "exit"),
                Joiner.on(LN).join("I don't understand.", ""));
    }
}
