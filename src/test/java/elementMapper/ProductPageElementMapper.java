package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    public WebElement product_title;

    @FindBy(name = "Submit")
    public WebElement btn_addcart;

    @FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement btn_ProcedToCheckout;
}
