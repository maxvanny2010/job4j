package ua.autos.filter;

import ua.autos.model.user.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * ${NAME}.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/28/2020
 */
@WebFilter("/auto")
public class AutoFilter implements Filter {
    @Override
    public final void init(final FilterConfig config) {
    }

    @Override
    public final void doFilter(final ServletRequest req,
                               final ServletResponse resp,
                               final FilterChain chain)
            throws ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(false);
        if (Objects.equals(session, null)) {
            session = request.getSession(true);
        }
        String role = (String) session.getAttribute("role");
        if (role == null || role.isEmpty()) {
            session.setAttribute("role", "unknown");
            session.setAttribute("user", new User("unknown"));
        }
        chain.doFilter(req, resp);
    }

    @Override
    public final void destroy() {
    }
}
