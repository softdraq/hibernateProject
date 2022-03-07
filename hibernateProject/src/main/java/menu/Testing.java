package menu;

import model.Brand;
import model.ShopOrder;
import model.ShopStorage;
import model.UserData;
import persistence.*;

import java.util.List;

public class Testing {

    public static void main(String[] args) {

        System.out.println("-- Test beginning --");

        // create new brands
        RepositoryBrand repositoryBrand = new RepositoryBrand();
        repositoryBrand.saveNewBrand("Nike", "Sport apparel");
        repositoryBrand.saveNewBrand("Adidas", "Sport apparel");
        List<Brand> brand = repositoryBrand.queryForBrandsByBrandName("Nike");
        System.out.println(brand.get(0).getBrandName());

        //create new user
        RepositoryUserData repositoryUserData = new RepositoryUserData();
        UserData account = new UserData();
        account.setUsername("testUser");
        account.setPwd("1234");
        account.setEmail("testUser@gmail.com");
        account.setAddress("Tallinn 212");
        account.setPhone(51444222);
        account.setDate();
        repositoryUserData.createNewAccount(account);

        UserData account2 = new UserData();
        account2.setUsername("testUser2");
        account2.setPwd("123444");
        account2.setEmail("test2User@gmail.com");
        account2.setAddress("Tartu 212");
        account2.setPhone(51444222);
        account2.setDate();
        repositoryUserData.createNewAccount(account2);

        //show username
        List<UserData> userData = repositoryUserData.getAllAccounts();
        System.out.println(userData.get(0).getUsername());


        //create new storage item
        RepositoryShopStorage repositoryShopStorage = new RepositoryShopStorage();
        ShopStorage shopStorage = new ShopStorage();
        shopStorage.setShopStorageName("toode 1");
        shopStorage.setStorageCount(100);
        shopStorage.setShopStoragePrice(5.99);
        repositoryShopStorage.saveNewShopStorage(shopStorage);
        repositoryShopStorage.UpdateShopStoragePriceById(1, 20);


        //show storage items
        List<ShopStorage> shopStorages = repositoryShopStorage.queryForShopStorage(1);
        System.out.println(shopStorages.get(0).getShopStorageName());


        //show shop storage items
        List<Brand> brands =  repositoryBrand.queryForBrandsByBrandName("Adidas");
        System.out.println(brands.get(0).getBrandDescription());
        List<UserData> accountsList = repositoryUserData.getAllAccounts();
        System.out.println(accountsList.get(0).getUsername());
        System.out.println(repositoryUserData.getCountOfAccount());

        //create new product item
        RepositoryProduct repositoryProduct = new RepositoryProduct();
        repositoryProduct.saveNewProduct(1,1);

        //create new shopOrder
        RepositoryShopOrder repositoryShopOrder = new RepositoryShopOrder();
        repositoryShopOrder.saveNewShopOrder(1, 1, 10);

        System.out.println(repositoryUserData.getNumberOfUsers());

        System.out.println("-- Test end --");
    }

}
