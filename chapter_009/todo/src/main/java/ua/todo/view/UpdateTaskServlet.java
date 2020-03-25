package ua.todo.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.todo.models.Task;
import ua.todo.services.TaskService;
import ua.todo.view.util.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * UpdateTaskServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/27/2020
 */
public class UpdateTaskServlet extends HttpServlet {
    /**
     * field a service.
     */
    private final TaskService service = TaskService.getInstance();

    @Override
    public final void doPost(final HttpServletRequest req,
                             final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final ObjectMapper mapper = new ObjectMapper();
        final HashMap<String, String> line = Util.getJSON(mapper, req);
        final int id = Integer.parseInt(line.get("id"));
        final String done = line.get("done");
        this.service.updateTask(id, done);
        final Task task = this.service.getTask(id);
        final String answer = mapper.writeValueAsString(task);
        resp.setContentType("application/json; charset=UTF-8");
        final PrintWriter out = resp.getWriter();
        out.print(answer);
        out.close();
    }
}
