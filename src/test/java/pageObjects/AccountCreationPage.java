package pageObjects;

import elementMapper.AccountCreationPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class AccountCreationPage extends AccountCreationPageElementMapper {

    public AccountCreationPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isAccounCreationPage() {
        return (navigation_page.getText().equals("Authentication")) && (page_heading.getText().equals("CREATE AN ACCOUNT"));
    }
    @Step("Colocar os Dados Pessoais")
    public void doCreateAccount(){
        imput_customer_firstname.sendKeys("Daiana");
        imput_customer_lastname.sendKeys("Brites");
//        imput_email.sendKeys("daia.brites@gmail.com");
        imput_passwd.sendKeys("teste123");
        imput_address1.sendKeys("Street Almirante Teodomiro,123");
        imput_city.sendKeys("Bonito");
        imput_postcode.sendKeys("00000");
        select_id_state.sendKeys("Alaska");
        imput_phone_mobile.sendKeys("+555180638006");
        btn_register.click();
    }
}
