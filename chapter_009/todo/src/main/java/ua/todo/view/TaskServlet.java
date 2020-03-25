package ua.todo.view;

import ua.todo.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * TaskServlet.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 3/20/2020
 */
public class TaskServlet extends HttpServlet {
    /**
     * field a service.
     */
    private final TaskService service = TaskService.getInstance();

    @Override
    public final void doGet(final HttpServletRequest req,
                            final HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        final List<?> tasks = this.service.getAllTasks();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/WEB-INF/html/task.html")
                .forward(req, resp);
    }
}
