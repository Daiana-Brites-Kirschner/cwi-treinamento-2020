package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isPageLogin() {
        return navigation_page.getText().equals("Authentication");
    }
    @Step("Colocar e-mail, senha e clicar no botão")
    public void doLogin() {
        imput_email_address.sendKeys("rrsetcwi+autopractice@gmail.com");
        imput_password.sendKeys("teste123");
        submit_login.click();
    }
}
