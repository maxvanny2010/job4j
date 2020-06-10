package accident.controller;

import accident.model.Accident;
import accident.repository.AccidentRepository;
import org.slf4j.Logger;
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
    private final AccidentRepository accidents;

    /**
     * Constructor.
     *
     * @param aAccidents a accidents
     */
    public IndexControl(final AccidentRepository aAccidents) {
        this.accidents = aAccidents;
    }

    /**
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @SuppressWarnings("SameReturnValue")
    @GetMapping("/sd")
    public final String index(final Model model) {
        final List<Accident> list = new ArrayList<>();
        this.accidents.findAll().forEach(list::add);
        LOG.info(list.toString());
        model.addAttribute("list", list);
        model.addAttribute("hats", Arrays.asList(
                "id", "имя", "текст", "адрес"));
        return "index";
    }
}
