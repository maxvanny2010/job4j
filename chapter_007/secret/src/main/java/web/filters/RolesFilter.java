package web.filters;

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
 * UserAuthenticationFilter.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/20/2020
 */
@WebFilter("/*")
public class RolesFilter implements Filter {
    /**
     * field a paths.
     */
    private final String[] pathsUser = {"gate", "add", "add.jsp",
            "login", "login.jsp", "clear"};
    /**
     * field a paths.
     */
    private final String[] pathsAdmin = {"gate", "login", "login.jsp"};
    /**
     * field a paths.
     */
    private final String[] pathsUnKnown = {"view", "view.jsp",
            "edit", "edit.jsp", "delete", "clear"};

    @Override
    public final void init(final FilterConfig filterConfig) {
    }

    @Override
    public final void doFilter(final ServletRequest req,
                               final ServletResponse resp,
                               final FilterChain chain)
            throws ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        final HttpSession session = request.getSession();
        final String path = request.getServletPath();
        String role = (String) session.getAttribute("role");
        if (role == null || role.isEmpty()) {
            role = "unknown";
            session.setAttribute("role", role);
        }
        final String access = "Access " + role + " is denied";
        final String data = "ROLE:" + role + " " + session.getId() + " " + path;
        System.out.println(data);
        final boolean isUser = Objects.equals(role, "user");
        final boolean isAdmin = Objects.equals(role, "admin");
        if (Objects.equals(role, "unknown")
                && this.isAccess(request, this.pathsUnKnown)) {
            System.out.println(access);
            response.sendRedirect("/gate");
        } else {
            if (isAdmin && this.isAccess(request, this.pathsAdmin)) {
                System.out.println(access);
                response.sendRedirect("/list");
            } else if (isUser && this.isAccess(request, this.pathsUser)) {
                System.out.println(access);
                response.sendRedirect("/list");
            } else {
                chain.doFilter(req, resp);
            }
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
