package accident;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/accident")
    public final String index(final Model model) {
        return "index";
    }
}
