package web.logic.action;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import web.logic.exception.StoreException;
import web.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static web.logic.action.utils.actionutil.ActionUtil.getBytes;
import static web.logic.action.utils.actionutil.ActionUtil.getPath;
import static web.logic.action.utils.actionutil.ActionUtil.is20kB;
import static web.logic.action.utils.actionutil.ActionUtil.isType;

/**
 * ActionUpload.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 1/30/2020
 */
public class ActionUpload extends ActionAbs {
    @Override
    public final void execute(final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        final HttpSession session = req.getSession(false);
        final Map<String, String> fields = new HashMap<>();
        if (ServletFileUpload.isMultipartContent(req)) {
            final byte[] image = uploadDataForm(req, fields);
            final String name = fields.get("name");
            final String email = fields.get("email");
            final String login = fields.get("login");
            final String password = fields.get("password");
            final boolean isLogin = this.getStore().isLogin(login);
            if (isLogin) {
                System.out.println("Login is present");
                session.setAttribute("infoUpload", "Логин занят.");
                resp.sendRedirect("/add");
                return;
            }
            final User user = new User(name, email, login, password, image);
            this.getStore().add(user);
            final String role = (String) session.getAttribute("role");
            if (Objects.equals(role, "admin")) {
                final int id = this.getStore().findIdBy(login, password);
                this.getKeeper().add(id);
            }
        }
        resp.sendRedirect("/gate");
        session.setAttribute("infoUpload", " ");
    }

    /**
     * Method to upload data from form and set it to map and byte array.
     *
     * @param req    a request
     * @param fields a fields from form
     * @return image by byte array
     */
    private byte[] uploadDataForm(final HttpServletRequest req,
                                  final Map<String, String> fields) {
        final DiskFileItemFactory factory = new DiskFileItemFactory();
        final ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            final List<FileItem> items = upload.parseRequest(req);
            for (FileItem item : items) {
                final InputStream stream = item.getInputStream();
                if (item.isFormField()) {
                    this.getFormField(fields, item, stream);
                }
                if (!item.isFormField()) {
                    return this.getFormFile(req, item, stream);
                }
            }
        } catch (Exception e) {
            throw new StoreException(e.getMessage());
        }
        return new byte[0];
    }

    /**
     * Method to get a file from field form.
     *
     * @param req    a request
     * @param item   a item
     * @param stream a stream
     * @return a file by a byte array
     *
     * @throws IOException io exception
     */
    private byte[] getFormFile(final HttpServletRequest req,
                               final FileItem item,
                               final InputStream stream)
            throws IOException {
        final int size = (int) item.getSize();
        if (is20kB(size) && isType(item)) {
            return stream.readAllBytes();
        }
        final String path = getPath("/img", "default.png", req);
        return getBytes(path);
    }

    /**
     * Method to get a data from simple field form.
     *
     * @param fields storage for fields
     * @param item   a item for a request
     * @param stream a item by a stream
     * @throws IOException exception
     */
    private void getFormField(final Map<String, String> fields,
                              final FileItem item,
                              final InputStream stream)
            throws IOException {
        final String name = item.getFieldName();
        final String value = Streams.asString(stream, "UTF-8");
        fields.put(name, value);
    }
}
