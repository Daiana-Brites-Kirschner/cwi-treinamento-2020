package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(id = "summary_products_quantity")
    public WebElement summary_products_quantity;

}
