package accident.controller;

import accident.model.Accident;
import accident.model.User;
import accident.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * IndexControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Controller
public class IndexControl {
    /**
     * field a logger.
     */
    private static final Logger LOG = getLogger(IndexControl.class);
    /**
     * field a accidents.
     */
    private final UserRepository users;

    /**
     * Constructor.
     *
     * @param aUsers users
     */
    public IndexControl(final UserRepository aUsers) {
        this.users = aUsers;
    }

    /**
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/list")
    public final String index(final Model model) {
        final SecurityContext context = SecurityContextHolder.getContext();
        final Authentication authentication = context.getAuthentication();
        final UserDetails details = (UserDetails) authentication.getPrincipal();
        final User user = this.users.findByUsername(details.getUsername());
        LOG.info(user.toString());
        final List<Accident> list = new ArrayList<>(user.getDtp());
        model.addAttribute("user", user);
        model.addAttribute("list", list);
        model.addAttribute("hats", Arrays.asList(
                "id", "имя", "текст", "адрес"));
        return "list";
    }
}
