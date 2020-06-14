package accident.controller;

import accident.model.Accident;
import accident.model.User;
import accident.repository.AccidentRepository;
import accident.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Objects;

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
     * field a accidents.
     */
    private final AccidentRepository accident;

    /**
     * Constructor.
     *
     * @param aUsers   users
     * @param accident accident
     */
    public IndexControl(final UserRepository aUsers,
                        final AccidentRepository accident) {
        this.users = aUsers;
        this.accident = accident;
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
        final String username = details.getUsername();
        final User user = this.users.findByUsername(username);
        LOG.info(user.toString());
        Iterable<Accident> list = user.getDtp();
        if (Objects.equals("admin", username)) {
            list = this.accident.findAll();
        }
        model.addAttribute("user", user);
        model.addAttribute("list", list);
        model.addAttribute("hats", Arrays.asList(
                "id", "имя", "текст", "адрес"));
        return "list";
    }
}
