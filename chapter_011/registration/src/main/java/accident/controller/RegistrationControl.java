package accident.controller;

import accident.model.User;
import accident.repository.AuthorityRepository;
import accident.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
     * field a users.
     */
    private final AuthorityRepository authority;

    /**
     * Constructor.
     *
     * @param aEncoder   encoder
     * @param aUsers     a repo by users
     * @param aAuthority a role
     */
    public RegistrationControl(final PasswordEncoder aEncoder,
                               final UserRepository aUsers,
                               final AuthorityRepository aAuthority) {
        this.encoder = aEncoder;
        this.users = aUsers;
        this.authority = aAuthority;
    }

    /**
     * Method handler registration form.
     *
     * @param user data user from form
     * @return path
     */
    @PostMapping("/registration")
    public final String registration(@ModelAttribute final User user) {
        user.setEnable(true);
        user.setAuthority(this.authority.findByAuthority("ROLE_USER"));
        user.setPassword(this.encoder.encode(user.getPassword()));
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
