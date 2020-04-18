package ua.autos.logic.action;

import ua.autos.logic.action.utils.actionutil.SearchesUtil;
import ua.autos.model.ads.Ads;
import ua.autos.model.ads.Foto;
import ua.autos.model.ads.Status;
import ua.autos.model.auto.Auto;
import ua.autos.model.auto.Brands;
import ua.autos.model.auto.Colors;
import ua.autos.model.auto.Engines;
import ua.autos.model.auto.Models;
import ua.autos.model.auto.Years;
import ua.autos.model.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static ua.autos.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionUploadAds.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionUploadAds extends ActionAbs {
    /**
     * Method to get.
     *
     * @param foldr a folder
     * @param file  a file
     * @param ext   a extension
     * @return a path for default image
     */
    public static String getDefaultFoto(final String foldr, final String file,
                                        final String ext) {
        return new StringBuilder()
                .append(foldr)
                .append("/")
                .append(file)
                .append(".")
                .append(ext)
                .toString();
    }

    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final User user = (User) session.getAttribute("user");
        final String brands = json.get("brand");
        final String models = json.get("model");
        final String engines = json.get("engine");
        final String colors = json.get("color");
        final String years = json.get("year");
        String value = SearchesUtil.getColor(colors);
        List<?> list = getAuto().findByValue(value, Colors.class);
        final Colors color = (Colors) list.get(0);
        value = SearchesUtil.getBrand(brands);
        list = getAuto().findByValue(value, Brands.class);
        final Brands brand = (Brands) list.get(0);
        value = SearchesUtil.getModel(value, models);
        list = getAuto().findByValue(value, Models.class);
        final Models model = (Models) list.get(0);
        value = SearchesUtil.getYear(years);
        list = getAuto().findByValue(value, Years.class);
        final Years year = (Years) list.get(0);
        value = SearchesUtil.getEngine(engines);
        list = getAuto().findByValue(value, Engines.class);
        final Engines engine = (Engines) list.get(0);
        final Auto auto = new Auto(brand, model, engine, color, year);
        final int idAuto = getAuto().save(auto);
        final Auto autos = getAuto().getById(idAuto);
        final Set<Foto> fotoSet = new HashSet<>();
        final User byId = getUser().getById(user.getId());
        final Ads tmpA = new Ads(byId, autos, fotoSet, Status.NO.getStatus());
        final int idAds = getAds().save(tmpA);
        final Ads ads = getAds().getById(idAds);
        //******************************************
        Foto image;
        final String name = json.get("name");
        String foto = json.get("foto");
        if (Objects.isNull(foto)) {
            foto = getDefaultFoto("img", "default", "png");
        }
        image = new Foto(foto);
        image.setName(name);
        image.setAds(ads);
        fotoSet.add(image);
        ads.setFoto(fotoSet);
        getAds().update(ads);
        getUser().update(user);
        final User update = getUser().getById(user.getId());
        idxAds().add(ads.getId());
        idxAdmin().add(ads.getId());
        session.setAttribute("user", update);
        final Set<Ads> outs = update.getAds();
        setOut(resp, outs);
    }
}
