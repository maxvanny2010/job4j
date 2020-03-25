package ua.todo.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.todo.services.TaskService;
import ua.todo.view.util.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * GetTasksServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/27/2020
 */
public class GetTasksServlet extends HttpServlet {
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
        final String done = line.get("done");
        List<?> tasks;
        if (done.equals("0")) {
            tasks = this.service.getAllTasks();
        } else if (done.equals("1")) {
            tasks = this.service.getNotDoneTasks();
        } else {
            tasks = new ArrayList<>();
        }
        resp.setContentType("application/json; charset=UTF-8");
        final PrintWriter out = resp.getWriter();
        out.print(tasks.toString());
        out.close();
    }
}
