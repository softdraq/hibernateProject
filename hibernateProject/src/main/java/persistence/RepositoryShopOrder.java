package persistence;

import model.ShopOrder;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryShopOrder {

    private EntityManager em;

    public RepositoryShopOrder() {

        this.em = getEntityManager();

    }

    public void saveNewShopOrder(int productsId, int idUser, int orderAmount) {

        this.em.getTransaction().begin();
        ShopOrder shopOrder = new ShopOrder();
        shopOrder.setProductsId(productsId);
        shopOrder.setIdUser(idUser);
        shopOrder.setOrderAmount(orderAmount);
        shopOrder.setDate();
        this.em.persist(shopOrder);
        this.em.getTransaction().commit();

    }

    public List<ShopOrder> queryForShopOrderByShopOrderId(int shopOrderId) {
        this.em = getEntityManager();
        List<ShopOrder> shopOrders = em.createQuery("SELECT shopOrder from ShopOrder shopOrder where shopOrder.shopOrderId = ?1")
                .setParameter(1, shopOrderId)
                .getResultList();
        return shopOrders;
    }

}