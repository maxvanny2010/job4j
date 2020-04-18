package ua.autos.logic.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Action.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/21/2020
 */
public interface Action {
    /**
     * Method to execute action.
     *
     * @param json a json
     * @param req  a request
     * @param resp a response
     * @throws Exception a io exception
     */
    void execute(HashMap<String, String> json, HttpServletRequest req,
                 HttpServletResponse resp) throws Exception;
}
