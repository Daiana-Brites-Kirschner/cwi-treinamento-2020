package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    @FindBy(className ="navigation_page")
    public WebElement navigation_page;

    @FindBy(id ="email")
    public WebElement imput_email_address;

    @FindBy(id = "passwd")
    public WebElement imput_password;

    @FindBy(name = "SubmitLogin")
    public WebElement submit_login;
}
