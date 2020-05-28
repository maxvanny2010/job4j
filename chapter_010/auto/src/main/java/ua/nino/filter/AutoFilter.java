package ua.nino.filter;

import ua.nino.model.user.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * AutoFilter.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/28/2020
 */
@WebFilter("/*")
public class AutoFilter implements Filter {
    /**
     * field a paths.
     */
    private final String[] pathsUser = {"registration"};

    @Override
    public final void init(final FilterConfig config) {
    }

    @Override
    public final void doFilter(final ServletRequest req,
                               final ServletResponse resp,
                               final FilterChain chain)
            throws ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);
        if (Objects.equals(session, null)) {
            session = request.getSession(true);
        }
        String role = (String) session.getAttribute("role");
        if (role == null || role.isEmpty()) {
            session.setAttribute("role", "unknown");
            session.setAttribute("user", new User("unknown"));
        }
        final boolean isUser = Objects.equals(role, "user");
        final boolean isAdmin = Objects.equals(role, "admin");
        if ((isAdmin || isUser)
                && this.isAccess(request, this.pathsUser)) {
            response.sendRedirect("/auto");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public final void destroy() {
    }

    /**
     * Method to get.
     *
     * @param request a request
     * @param paths   a poll of define paths
     * @return is repeated path for authorized user
     */
    private boolean isAccess(final HttpServletRequest request,
                             final String[] paths) {
        final String requestURL = request.getServletPath();
        return Arrays.stream(paths).anyMatch(requestURL::contains);
    }
}
