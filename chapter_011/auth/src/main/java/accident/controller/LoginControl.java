package accident.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * LoginControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/10/2020
 */
@SuppressWarnings("ALL")
@Controller
public class LoginControl {
    /**
     * Method handler a login page.
     *
     * @param error  a error
     * @param logout a logout
     * @param model  a model
     * @return login page
     */
    @GetMapping("/login")
    public final String loginPage(
            @RequestParam(
                    value = "error", required = false) final String error,
            @RequestParam(
                    value = "logout", required = false) final String logout,
            final Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "is incorrect";
        }
        if (logout != null) {
            errorMessage = "logout is success";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    /**
     * Method handler form logout.
     *
     * @param req  request
     * @param resp response
     * @return path for redirect
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public final String logoutPage(final HttpServletRequest req,
                                   final HttpServletResponse resp) {
        final Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (Objects.nonNull(auth)) {
            new SecurityContextLogoutHandler().logout(req, resp, auth);
        }
        return "redirect:/login?logout=true";
    }
}
