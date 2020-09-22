package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigation_page;

    @FindBy(className = "page-heading")
    public WebElement page_heading;

    @FindBy(id = "customer_firstname")
    public WebElement imput_customer_firstname;

    @FindBy(id = "customer_lastname")
    public WebElement imput_customer_lastname;

    @FindBy(id = "email")
    public WebElement imput_email;

    @FindBy(id = "passwd")
    public WebElement imput_passwd;

    @FindBy(id = "address1")
    public WebElement imput_address1;

    @FindBy(id = "city")
    public WebElement imput_city;

    @FindBy(id = "postcode")
    public WebElement imput_postcode;

    @FindBy(id = "phone_mobile")
    public WebElement imput_phone_mobile;

    @FindBy(id = "id_state")
    public WebElement select_id_state;

//    @FindBy(id = "id_country")
//    public WebElement selectid_country;

    @FindBy(id = "submitAccount")
    public WebElement btn_register;

}
