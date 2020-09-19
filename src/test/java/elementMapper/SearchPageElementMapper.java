package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(className = "lighter")
    public WebElement lighter;

    @FindBy(className = "heading-counter")
    public WebElement heading_counter;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    public WebElement product_image;

}
