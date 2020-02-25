package web.logic;

import web.logic.action.Action;
import web.logic.action.Action404;
import web.logic.action.Action444;
import web.logic.action.ActionAdd;
import web.logic.action.ActionClearStore;
import web.logic.action.ActionDelete;
import web.logic.action.ActionEdit;
import web.logic.action.ActionEdited;
import web.logic.action.ActionException;
import web.logic.action.ActionGate;
import web.logic.action.ActionList;
import web.logic.action.ActionLoad;
import web.logic.action.ActionLogOut;
import web.logic.action.ActionLogin;
import web.logic.action.ActionUpload;
import web.logic.action.ActionView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * LogicService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/29/2020
 */
public final class LogicService implements Logic {
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
    private LogicService() {
        this.map.put("gate", new ActionGate());
        this.map.put("login", new ActionLogin());
        this.map.put("logout", new ActionLogOut());
        this.map.put("add", new ActionAdd());
        this.map.put("upload", new ActionUpload());
        this.map.put("load", new ActionLoad());
        this.map.put("edit", new ActionEdit());
        this.map.put("edited", new ActionEdited());
        this.map.put("view", new ActionView());
        this.map.put("delete", new ActionDelete());
        this.map.put("clear", new ActionClearStore());
        this.map.put("exception", new ActionException());
        this.map.put("404", new Action404());
        this.map.put("444", new Action444());
        this.map.put(null, new ActionList());
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
    public void runAction(final String action,
                          final HttpServletRequest req,
                          final HttpServletResponse resp)
            throws ServletException, IOException {
        this.getAction(action).execute(req, resp);
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
