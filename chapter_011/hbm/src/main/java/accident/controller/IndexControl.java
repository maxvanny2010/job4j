package accident.controller;

import accident.repository.AccidentHibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

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
     * field a accidents.
     */
    private final AccidentHibernate accidents;

    /**
     * Constructor.
     *
     * @param aAccidents a accidents
     */
    public IndexControl(final AccidentHibernate aAccidents) {
        this.accidents = aAccidents;
    }

    /**
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/hbm")
    public final String index(final Model model) {
        model.addAttribute("list", this.accidents.getAll());
        model.addAttribute("hats", Arrays.asList(
                "id", "имя", "текст", "адрес"));
        return "index";
    }
}
