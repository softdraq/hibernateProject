package persistence;

import com.mysql.cj.Session;
import model.Brand;
import util.DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

import static util.DBUtil.getEntityManager;

public class RepositoryBrand {

    private EntityManager em;

    public RepositoryBrand() {
        this.em = DBUtil.getEntityManager();
    }

    public void saveNewBrand(String brandName, String description) {
        this.em.getTransaction().begin();
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setBrandDescription(description);
        brand.setBrandRegistrationDate();
        this.em.persist(brand);
        this.em.getTransaction().commit();
    }

    /*
    public List<Brand> queryForBrands() {
        //this.em = getEntityManager();
        List<Brand> brands = em.createQuery("SELECT brand from Brand brand")
                .getResultList();
        return brands;
    }

     */

    public List<Brand> queryForBrandsByBrandName(String brandName) {
        //this.em = getEntityManager();
        List<Brand> brands = em.createQuery("SELECT brand from Brand brand where brand.brandName = ?1")
                .setParameter(1, brandName)
                .getResultList();
        return brands;
    }

    public List<Brand> queryForBrandsByBrandId(int brandId) {
        //this.em = getEntityManager();
        List<Brand> brands = em.createQuery("SELECT brand from Brand brand where brand.brandId = ?1")
                .setParameter(1, brandId)
                .getResultList();
        return brands;
    }

}
