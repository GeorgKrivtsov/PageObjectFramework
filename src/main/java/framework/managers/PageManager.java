package framework.managers;

import framework.pages.BasketPage;
import framework.pages.FindBlock;
import framework.pages.ProductPage;
import framework.pages.SearchPage;

public class PageManager {

    private static PageManager INSTANCE = null;

    private FindBlock findBlock;
    private SearchPage searchPage;
    private ProductPage productPage;
    private BasketPage basketPage;


    private PageManager() {
    }

    public static PageManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

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
