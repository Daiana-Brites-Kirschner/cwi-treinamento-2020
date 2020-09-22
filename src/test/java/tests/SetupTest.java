package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes de site de e-commerce")
public class SetupTest extends BaseTests {

    @Test
    @Story("Abrir o site")
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
    @Story("Realizar o login")
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
    @Test
    public void testSearchDesafio() {
        String quest = "T-SHIRTS";
        String questResultQtd = "1";
        String questResultQtdCart = "1";

        //Iniciar as páginas   PageObjects
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();
        ProductPage product = new ProductPage();
        CartPage cart = new CartPage();

        // fazer a pesquisa
        home.doSearch(quest);

        assertTrue(search.isSearchPage());
        // precisa remover as aspas duplas que vem junto do site
        assertEquals(search.getTextLighter().replace("\"",""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
        //clicar no produto pesquisado
        search.clickProductImage();
        System.out.println("clicou no quick view");
        //Validar se está na página correta do Produto selecionado
        assertTrue(product.isProducPage());
        System.out.println("Produto foi selecionado corretamente");
        //Colocar o produto no carrinho
        product.clickBtnAddToCart();
        System.out.println("Produto foi selecionado no carrinho");
        product.clickBtnProcedToCheckout();
        System.out.println("Clicado para finalizar a compra");
        //Validar que produto foi adicionado no carrinho
        assertTrue(cart.isCartPage());
        assertThat(cart.getTextSummary_products_quantity(),CoreMatchers.containsString(questResultQtdCart));
    }

    @Test
    @Story("Criar um usuário")
    @Description("Acessar a página inicial e criar um usuário para realizar as compras")
    public void testCriarUsuario(){
        // Inicia as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        AccountCreationPage account = new AccountCreationPage();
        MyAccountPage myAccountPage = new MyAccountPage();
        // Clicar no botão "Sign in" da home
        home.clickBtnLogin();
        System.out.println("Clicamos no botão login");
        // Verificação se ao clicar no botão login da Home ocorreu o direcionamento para a página de login e Criação de Página
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains("my-account"));
        assertTrue(login.isPageLogin());
        System.out.println("Direcionamento para página para criação de usuário está OK!.");
        // Colar email pessoal e clicar para criar usuário
        login.doCreateUser();
        System.out.println("Solicitando um usuário");
        // Verificação o direcionamento para a página de minha conta ao realizar o login
        account.isAccounCreationPage();
        //Colocar Dados Pessoais e clilcar em criar usuário
        account.doCreateAccount();
        System.out.println("Criamos o usuário");
        //Validação da criação de usuário
        assertTrue(myAccountPage.isPageMyAccount());
        System.out.println("Direcionamento para página de login.");
    }

}
