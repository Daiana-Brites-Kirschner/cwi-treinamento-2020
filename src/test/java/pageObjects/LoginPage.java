package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isPageLogin() {
        return navigation_page.getText().equals("Authentication");
    }

    public void doLogin() {
        imput_email_address.sendKeys("rrsetcwi+autopractice@gmail.com");
        imput_password.sendKeys("teste123");
        submit_login.click();
    }
}
