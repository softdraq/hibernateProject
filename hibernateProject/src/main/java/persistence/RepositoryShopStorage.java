package persistence;

import model.ShopStorage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryShopStorage {

    private EntityManager em;

    public RepositoryShopStorage() {

        this.em = getEntityManager();

    }

    public void saveNewShopStorage(ShopStorage shopStorage) {

        this.em.getTransaction().begin();
        this.em.persist(shopStorage);
        this.em.getTransaction().commit();

    }

    public List<ShopStorage> queryForShopStorage(int shopStorageId) {
        this.em = getEntityManager();
        List<ShopStorage> shopStorages = em.createQuery("SELECT shopStorage from ShopStorage shopStorage where shopStorage.shopStorageId = ?1")
                .setParameter(1, shopStorageId)
                .getResultList();
        return shopStorages;
    }

    public void UpdateShopStoragePriceById(int shopStorageId, double shopStoragePrice) {

        ShopStorage shopStorage = this.em.find(ShopStorage.class, shopStorageId);
        shopStorage.setShopStoragePrice(shopStoragePrice);
        this.em.getTransaction().begin();
        this.em.merge(shopStorage);
        this.em.getTransaction().commit();

    }

}
