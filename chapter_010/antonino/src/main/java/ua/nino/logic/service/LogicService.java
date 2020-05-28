package ua.nino.logic.service;

import ua.nino.logic.action.Action;
import ua.nino.logic.action.ActionBase;
import ua.nino.logic.action.ActionCabinet;
import ua.nino.logic.action.ActionCabinetAds;
import ua.nino.logic.action.ActionClearStore;
import ua.nino.logic.action.ActionDeleteAds;
import ua.nino.logic.action.ActionDeleteUser;
import ua.nino.logic.action.ActionEditAds;
import ua.nino.logic.action.ActionException;
import ua.nino.logic.action.ActionGetAds;
import ua.nino.logic.action.ActionGetAdsByDate;
import ua.nino.logic.action.ActionGetModel;
import ua.nino.logic.action.ActionLogOut;
import ua.nino.logic.action.ActionLogin;
import ua.nino.logic.action.ActionRegister;
import ua.nino.logic.action.ActionSearches;
import ua.nino.logic.action.ActionUploadAds;
import ua.nino.logic.action.ActionViewAds;
import ua.nino.logic.action.ActionViewUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * LogicService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/21/2020
 */
public class LogicService implements Logic {
    /**
     * field  a instance of LogicService.
     */
    private static final LogicService LOGIC_SERVICE = new LogicService();
    /**
     * field a map.
     */
    private final Map<String, Action> map = new HashMap<>();

    /**
     * Constructor.
     */
    public LogicService() {
        this.map.put("exception", new ActionException());
        this.map.put("date", new ActionGetAdsByDate());
        this.map.put("clear", new ActionClearStore());
        this.map.put("delU", new ActionDeleteUser());
        this.map.put("delA", new ActionDeleteAds());
        this.map.put("cabinetByRole", new ActionCabinet());
        this.map.put("cabinetAdsUserByAdmin", new ActionCabinetAds());
        this.map.put("editU", new ActionViewUser());
        this.map.put("editA", new ActionEditAds());
        this.map.put("viewU", new ActionViewUser());
        this.map.put("viewA", new ActionViewAds());
        this.map.put("upload", new ActionUploadAds());
        this.map.put("model", new ActionGetModel());
        this.map.put("searches", new ActionSearches());
        this.map.put("logout", new ActionLogOut());
        this.map.put("login", new ActionLogin());
        this.map.put("register", new ActionRegister());
        this.map.put("index", new ActionGetAds());
        this.map.put(null, new ActionBase());
        this.map.put("base", new ActionBase());
    }

    /**
     * Method to get.
     *
     * @return the instance of LogicService
     */
    public static LogicService getInstance() {
        return LOGIC_SERVICE;
    }

    @Override
    public final void runAction(final String action,
                                final HashMap<String, String> json,
                                final HttpServletRequest req,
                                final HttpServletResponse resp)
            throws Exception {
        this.getAction(action).execute(json, req, resp);
    }

    /**
     * Method to get action from the Page.
     *
     * @param action a action
     * @return action
     */
    private Action getAction(final String action) {
        return this.map.getOrDefault(action, this.map.get("exception"));
    }
}
