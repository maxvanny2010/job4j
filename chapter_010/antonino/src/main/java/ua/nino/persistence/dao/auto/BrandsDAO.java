package ua.nino.persistence.dao.auto;

import ua.nino.model.auto.Brands;
import ua.nino.persistence.dao.store.IStore;

/**
 * BrandDAO.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
interface BrandsDAO extends IStore<Brands> {
    /**
     * Method to delete a brand.
     *
     * @throws RuntimeException RuntimeException
     */
    void deleteBrand();
}
