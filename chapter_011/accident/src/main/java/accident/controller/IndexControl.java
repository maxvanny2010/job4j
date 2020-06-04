package accident.controller;

import accident.model.Accident;
import accident.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
     * field a service.
     */
    private final AccidentService service = AccidentService.getService();

    /**
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @GetMapping("/accident")
    public final String index(final Model model) {
        this.service.clearStore();
        final ArrayList<Accident> list = new ArrayList<>() {{
            add(new Accident("11111", "app1", "bmw"));
            add(new Accident("22222", "app2", "zaz"));
            add(new Accident("33333", "app3", "mercedes"));
            add(new Accident("44444", "app4", "lexus"));
        }};
        final List<String> hats = Arrays.asList(
                "id", "имя", "адрес", "описание");
        this.service.initStore(list);
        final Map<Integer, Accident> map = this.service.getAllAccidents();
        model.addAttribute("map", map);
        model.addAttribute("hats", hats);
        return "index";
    }
}
