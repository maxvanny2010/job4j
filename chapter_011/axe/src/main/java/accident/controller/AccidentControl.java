package accident.controller;

import accident.model.Accident;
import accident.service.AccidentService;
import accident.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * IndexControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@SuppressWarnings("ALL")
@Controller
public class AccidentControl {

    /**
     * field a service.
     */
    private final AccidentService service;

    /**
     * Constructor.
     *
     * @param aService a service
     */
    public AccidentControl(final AccidentService aService) {
        this.service = aService;
    }

    /**
     * Method to get.
     *
     * @param model a model
     * @return a page name
     */
    @GetMapping("/axe")
    public final String index(final Model model) {
        final Map<Integer, Accident> map = this.service.getAllAccidents();
        model.addAttribute("map", map);
        model.addAttribute("hats", Util.getHat());
        return "index";
    }

    /**
     * Method to create.
     *
     * @return lint to a create page
     */
    @GetMapping("/create")
    public final String create() {
        return "create";
    }

    /**
     * Method to save.
     *
     * @param accident a accident
     * @param file     a file
     * @param request  a request
     * @return redirect
     *
     * @throws IOException Exception
     */
    @PostMapping("/save")
    public final String save(@ModelAttribute final Accident accident,
                             @RequestParam("file") final MultipartFile file,
                             final HttpServletRequest request)
            throws IOException {
        if (!file.isEmpty()) {
            accident.setFoto(file.getInputStream().readAllBytes());
        } else {
            accident.setFoto(Util.getBytes(request));
        }
        accident.setId(Util.getATOM());
        this.service.addAccident(accident);
        return "redirect:/axe";
    }

    /**
     * Method to update.
     *
     * @param accident a accident
     * @return redirect
     */
    @PostMapping("/update")
    public final String update(@ModelAttribute final Accident accident) {
        final int id = accident.getId();
        final byte[] foto = this.service.getAccident(id).getFoto();
        accident.setFoto(foto);
        this.service.updateAccident(accident);
        return "redirect:/axe";
    }

    /**
     * Method to edit.
     *
     * @param id    a id
     * @param model a model
     * @return edit
     */
    @PostMapping("/edit")
    public final String edit(@RequestParam("id") final String id,
                             final Model model) {
        final int idx = Integer.parseInt(id);
        final Accident accident = this.service.getAccident(idx);
        if (Objects.isNull(accident)) {
            return "redirect:/axe";
        }
        model.addAttribute("axe", accident);
        return "edit";
    }
}
