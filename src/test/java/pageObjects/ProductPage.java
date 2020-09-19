package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage(){
       PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isProducPage(){
        return product_title.getText().equals("Faded Short Sleeve T-shirts");
    }

    public void clickBtnAddToCart() {
        btn_addcart.click();
    }

    public void clickBtnProcedToCheckout(){
        btn_ProcedToCheckout.click();
    }

}
