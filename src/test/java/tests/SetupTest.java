package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests {

    @Test
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a URL!");
    }

    @Test
    public void testLoginOriginal(){
        // Inicia as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();

        // Clicar no botão login da home
        home.clickBtnLogin();
        System.out.println("Clicamos no botão login.");

        // Verificação se ao clicar no botão login da Home ocorreu o direcionamento para a página de login
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("my-account"));
        assertTrue(login.isPageLogin());
        System.out.println("Direcionamento para página de login OK!.");

        // Realizar o login
        login.doLogin();
        System.out.println("Realizamos o login.");

        // Verificação o direcionamento para a página de minha conta ao realizar o login
        assertTrue(myAccountPage.isPageMyAccount());
        System.out.println("Direcionamento para página de login.");
    }

    @Test
    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Clicou em Sign In e direcionou para a página de login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("rrsetcwi+autopractice@gmail.com");
        System.out.println("Preencheu o email");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("teste123");
        System.out.println("Preencheu a senha");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicou em Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a URL da minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou minha conta no site");
    }

    @Test
    public void testSearch() {
        String quest = "DRESS";
        String questResultQtd = "7";

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        // fazer a pesquisa
        home.doSearch(quest);

        assertTrue(search.isSearchPage());
        // precisa remover as aspas duplas que vem junto do site
        assertEquals(search.getTextLighter().replace("\"",""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
    }
}
