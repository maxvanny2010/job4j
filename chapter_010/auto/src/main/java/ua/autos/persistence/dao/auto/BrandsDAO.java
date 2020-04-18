package ua.autos.persistence.dao.auto;

import ua.autos.model.auto.Brands;
import ua.autos.persistence.dao.store.IStore;

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
