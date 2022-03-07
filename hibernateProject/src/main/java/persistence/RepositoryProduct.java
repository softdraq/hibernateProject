package persistence;

import model.Product;
import util.DBUtil;

import javax.persistence.EntityManager;

import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryProduct {

    private EntityManager em;

    public RepositoryProduct() {

        this.em = DBUtil.getEntityManager();

    }

    public void saveNewProduct(int brandId, int shopStorageId) {

        this.em.getTransaction().begin();
        Product product = new Product();
        product.setBrandId(brandId);
        product.setShopStorageId(shopStorageId);
        this.em.persist(product);
        this.em.getTransaction().commit();

    }

    public List<Product> queryForProductsByProductId(int productId) {

        this.em = getEntityManager();
        List<Product> products = em.createQuery("SELECT product from Product product where product.productId = ?1")
                .setParameter(1, productId)
                .getResultList();
        return products;

    }

    public int getNumberOfProducts() {

        this.em = getEntityManager();
        List<Product> products = em.createQuery("SELECT product from Product")
                .getResultList();
        int numberOfProducts = products.size();
        return numberOfProducts;

    }


}
