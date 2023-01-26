package framework.managers;

import framework.pages.*;
import framework.product.ProductList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PageManager {

    private FindBlock findBlock;
    private SearchPage searchPage;
    private ProductPage productPage;
    private BasketPage basketPage;
    private ProductList productList;
    private static PageManager INSTANCE = null;

    private static Map<Class, Object> pageSet = new HashMap<>();

    private PageManager() {
    }


    public static PageManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public ProductList getProductList(){
        if(productList == null){
            productList = new ProductList();
        }
        return productList;
    }

//    public <T extends BasePage> T getPage(Class<T> page) {
//        try {
//            if(pageSet.isEmpty()){
//                Class.forName(String.valueOf(page));
//                Constructor c1 = Class.class.getConstructor();
//                pageSet.put(c1.getClass(), page);
//                return (T) c1.newInstance();
//            } else if(pageSet.containsKey(page)){
//                return (T) pageSet.get(page);
//            } else {
//                Class.forName(String.valueOf(page));
//                Constructor c1 = Class.class.getConstructor();
//                pageSet.put(c1.getClass(), page);
//                return (T) c1.newInstance();
//            }
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException |
//                 NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        }
//    }



    public FindBlock getFindBlock() {
        if(findBlock == null) {
            findBlock = new FindBlock();
        }
        return findBlock;
    }

    public SearchPage getSearchPage() {
        if(searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }

    public ProductPage getProductPage() {
        if(productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public BasketPage getBasketPage() {
        if(basketPage == null) {
            basketPage = new BasketPage();
        }
        return basketPage;
    }


}
