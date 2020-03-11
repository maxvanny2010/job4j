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
import java.util.Objects;

/**
 * RolesListFilter.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 2/26/2020
 */
@WebFilter("/list")
public class RolesListFilter implements Filter {
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
        final HttpSession session = request.getSession(false);
        final String role = (String) session.getAttribute("role");
        if (Objects.equals(role, "unknown")) {
            response.sendRedirect("/gate");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public final void destroy() {
    }
}
