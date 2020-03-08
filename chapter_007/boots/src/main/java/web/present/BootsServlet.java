package web.present;


import com.fasterxml.jackson.databind.ObjectMapper;
import web.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * BootsServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/1/2020
 */
public class BootsServlet extends HttpServlet {
    @Override
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final StringBuilder sb = new StringBuilder();
        String line;
        try {
            final BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        final ObjectMapper jack = new ObjectMapper();
        final User value = jack.readValue(sb.toString(), User.class);
        final String name = value.getName();
        final String email = value.getEmail();
        final String login = value.getLogin();
        final String password = value.getPassword();
        final String file = value.getImg();
        final byte[] encoded = Base64.getEncoder().encode(file.getBytes());
        final String encodedStr = (new String(encoded, StandardCharsets.UTF_8));
        final byte[] decoded = Base64.getDecoder().decode(encodedStr);
        final String decodedStr = (new String(decoded, StandardCharsets.UTF_8));
        final User user = new User(name, login, email, password, decodedStr);
        final User sent = new User("dada", "dado",
                "dada@gmail.com", "1", file);
        final ObjectMapper send = new ObjectMapper();
        final String one = send.writeValueAsString(user);
        final String two = send.writeValueAsString(sent);
        final List<String> list = new ArrayList<>(Arrays.asList(one, two));
        List<String> my = send.readValue(list.toString(),
                send.getTypeFactory()
                        .constructCollectionType(List.class, User.class));
        resp.setContentType("application/json; charset=UTF-8");
        final PrintWriter out = resp.getWriter();
        out.print(my);
        out.flush();

    }

    @Override
    public final void doGet(final HttpServletRequest req,
                            final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/json.html")
                .forward(req, resp);
    }
}
