package pageObjects;

import elementMapper.CartPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CartPage extends CartPageElementMapper {

    public CartPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public boolean isCartPage(){
        return navigation_page.getText().equals("Your shopping cart");
    }
    public String getTextSummary_products_quantity() {
            return summary_products_quantity.getText();
        }
}
