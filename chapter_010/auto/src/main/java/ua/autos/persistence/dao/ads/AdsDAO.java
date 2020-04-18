package ua.autos.persistence.dao.ads;

import ua.autos.model.ads.Ads;
import ua.autos.model.ads.Status;
import ua.autos.model.user.User;
import ua.autos.persistence.dao.store.IStore;

import java.util.List;

/**
 * AdsDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
public interface AdsDAO extends IStore<Ads> {
    /**
     * Method to find.
     *
     * @param status a ads
     * @param user   a user
     * @return a ads
     */
    List<Ads> findAdsBy(Status status, User user);

    /**
     * Method to delete a ads.
     *
     * @param id a id
     */
    void deleteAds(String id);

    /**
     * Method to find.
     *
     * @param id a id
     * @return a list
     */
    Ads findAdsByIdAuto(Integer id);
}
