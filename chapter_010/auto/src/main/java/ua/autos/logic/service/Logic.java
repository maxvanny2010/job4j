package ua.autos.logic.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Logic.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/21/2020
 */
public interface Logic {
    /**
     * Method to run action.
     *
     * @param action a action
     * @param json   a map this json
     * @param req    a request
     * @param resp   a response
     * @throws Exception a exception
     */
    void runAction(String action,
                   HashMap<String, String> json,
                   HttpServletRequest req,
                   HttpServletResponse resp)
            throws Exception;
}
