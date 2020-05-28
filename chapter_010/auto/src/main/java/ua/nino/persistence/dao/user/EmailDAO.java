package ua.nino.persistence.dao.user;

import ua.nino.model.user.Email;
import ua.nino.persistence.dao.store.IStore;

/**
 * EmailDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface EmailDAO extends IStore<Email> {
    /**
     * Method to delete a email.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteEmail();
}
