package accident.controller;

import accident.model.Role;
import accident.model.User;
import accident.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

/**
 * RegControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/11/2020
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class RegistrationControl {
    /**
     * field a encoder.
     */
    private final PasswordEncoder encoder;
    /**
     * field a users.
     */
    private final UserRepository users;

    /**
     * Constructor.
     *
     * @param aEncoder encoder
     * @param aUsers   a repo by users
     */
    public RegistrationControl(final PasswordEncoder aEncoder,
                               final UserRepository aUsers) {
        this.encoder = aEncoder;
        this.users = aUsers;
    }

    /**
     * Method handler registration form.
     *
     * @param user data user from form
     * @return path
     */
    @PostMapping("/registration")
    public final String registration(@ModelAttribute final User user) {
        // to check by unique don't create.
        //user.setPassword(this.encoder.encode(user.getPassword()));
        user.setPassword(user.getPassword());
        user.setEnable(true);
        user.setRoles(Collections.singleton(Role.USER));
        this.users.save(user);
        return "redirect:/login";
    }

    /**
     * Method handler registration path.
     *
     * @return path
     */
    @GetMapping("/registration")
    public final String reg() {
        return "registration";
    }
}
